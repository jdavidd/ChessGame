/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/*
added player and room
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author c-tin
 */
public class Server {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    //Aceasta lista contine toti utilizatorii logati in server
    private static ArrayList <Player> listaUtilizatori;
    private static ArrayList <room> listaCamere;
    private static conexiuneBazaUtilizator conexiuneUtilizator;
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int clientNumber=0;
        listaUtilizatori=new ArrayList<>();
        listaCamere=new ArrayList();
        conexiuneUtilizator=new conexiuneBazaUtilizator();
        try(ServerSocket listener = new ServerSocket(9999)) {
            while(true){
            new Player(listener.accept(),clientNumber++).start();
            }
        }
    }
    
    public static class Player extends Thread{
        private final int clientNumber;
        private final Socket socket;
        private int idUser;
        private String numeUser;
        private room cameraJoc;
        private  BufferedReader in;         
        private  PrintWriter out;            
        private final Boolean mutex;       
        
        private ObjectOutputStream outt;
        private ObjectInputStream inn;

        
        public Player(Socket socket,int clientNumber){
            idUser=0;
            numeUser=new String();
            this.clientNumber=clientNumber;
            this.socket=socket;
            cameraJoc=null;
            try {
                in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out=new PrintWriter(socket.getOutputStream(),true);
                
                outt = new ObjectOutputStream(socket.getOutputStream());
                // Create an input stream from the socket
                inn = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("There is a new connection with client number "+clientNumber);
            mutex=false;
        }
        
        
        public static ArrayList<String> getListaUtilizatori() {
            ArrayList <String> users = new ArrayList<> ();
            System.out.println(listaUtilizatori.size());
            for (int i = 0; i < listaUtilizatori.size(); i++) { 
                users.add(listaUtilizatori.get(i).getNume());
            }
            return users;
        }
        public static ArrayList<String> getListaRoom() {
            ArrayList <String> users = new ArrayList<> ();
            System.out.println(listaCamere.size());
            for (int i = 0; i < listaCamere.size(); i++) { 
                users.add(listaCamere.get(i).getNume());
            }
            return users;
        }
        @Override
        public void run(){
            try {
                conexiuneUtilizator.selectAll();
                
                
                OUTER:
                while (true) {
                    
                    
                    String request=in.readLine();
                    ArrayList<String> cerere=decode(request);
                    int requestType=Integer.parseInt(cerere.get(0));
                    
                    
                    
                    if(requestType<-1)//Daca s-a facut o cerere cu un cod de identificare nevalid
                    {
                        out.println("0;Cere nerecunoscuta de server, a fost transmis un cod mai mic decat -1");
                    }
                    else
                    switch (requestType) {
                    //S-a facut o cere de intrerupere a conexiunii
                        case -1:
                        {
                            
                            out.println("0;EXIT_CLIENT");
                            System.out.println("am inchis clientul");
                            break OUTER;
                        }
                    //S-a facut o cerere de inregistrare
                        case 1:
                        {
                            ConfirmBox.display("test","singu");
                            int resultConexiune=conexiuneUtilizator.inregistrare(cerere.get(1),cerere.get(2),cerere.get(3));
                        switch (resultConexiune) {
                            case -1:
                            {
                                out.println("0;Inregistrare nereusita, au aparut probleme tehnice");
                                break;
                            }
                            case 0:
                            {
                                out.println("1;Inregistrare Reusita");
                                break;
                            }
                            case 1:
                            {
                                out.println("0;Adresa de email este folosita deja");
                                break;
                            }
                            case 2:
                                out.println("0;Username deja folosit");
                                break;
                            case 3:
                                out.println("0;Inregistrare nereusita, incercati din nou");
                                break;
                            default:
                                break;
                        }
                            break;
                        }
                    //S-a facut o cere de login
                        case 2:
                        {
                            int resultConexiune=conexiuneUtilizator.login(cerere.get(1),cerere.get(2));
                            if(resultConexiune>0)
                            {
                                idUser=resultConexiune;
                                numeUser=cerere.get(1);
                                Boolean ok=true;
                                int lungime=listaUtilizatori.size();
                        
                                for(int i=0;i<lungime;++i)
                                    if(idUser==(listaUtilizatori.get(i).getID()))
                                    {
                                        ok=false;
                                    }
                                if(ok==true)
                                {
                                    listaUtilizatori.add(this);
                                    out.println("1;Login reusit");
                         
                                }
                                else
                                out.println("0;Exista deja un utilizator logat in acest cont");
                                
                            }
                        switch (resultConexiune) {
                            case -1:
                                out.println("0;Login nereusit, au aparut probleme tehnice");
                                break;
                            case -2:
                                out.println("0;Acest Username nu exista");
                                break;
                            case -3:
                                out.println("0;Parola gresita");
                                break;
                            default:
                                break;
                        }
                            break;
                        }
                        
                        case 3:
                        {
                            ArrayList <String> numeParolaList=conexiuneUtilizator.getUtilizatorParolaMail(cerere.get(3));
                            if(numeParolaList.isEmpty())
                            {
                                out.println("0;Nu exista niciun cont cu aceasta adresa de mail");
                            }
                            else
                            {
                                if(mailSender.sendMailRecuperareDateCont(cerere.get(3),numeParolaList.get(0),numeParolaList.get(1))==true)
                                out.println("1;Un mail cu datele contului a fost trimis");
                                else
                                out.println("0;Nu s-a putut trimite mail-ul, a aparut o problema");
                            }
                            break;
                        }
                         //Cod adaugat !!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        //Cerere pentru creare camera
                        case 4:
                        {
                            System.out.println("creez camera");
                         String numeCamera=request.substring(2,request.length());
                         if(cameraJoc!=null)
                        {
                          out.println("-4;Deja faci parte dintr-o camera");    
                        }
                         else
                        {
                             
                             this.createRoom(in,out,numeCamera);
                             
                        }
                            break;
                        }
                        //Cazul in care se face cerere de aderare la o camera de joc
                        case 5:
                        {
                            if(cameraJoc!=null)
                            {
                                out.println("-5;Deja faci parte dintr-o camera");
                                
                            }
                            else{
                                
                                String numeCamera=request.substring(2,request.length());
                                this.enterRoom(in, out, numeCamera);
                            
                            }
                                                /*for(int i=0;i<listaCamere.size();++i)
                                                    if(listaCamere.get(i).black!=null)
                        System.out.println(listaCamere.get(i).getNume()+" "+listaCamere.get(i).white.getNume()+" "+listaCamere.get(i).black.getNume());
                                                else
                                                 System.out.println(listaCamere.get(i).getNume()+" "+listaCamere.get(i).white.getNume());       
                        System.out.println("\n\n\n");*/
                            
                            break;
                        }
                        //COD ADAUGAT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        case 6: {
                                // mesajul primit de client va fi de forma 6;nume: mesaj
                                //System.out.println("Hopa mesaj!");
                                broadcast(cerere.get(1),this.getNume());
                                break;
                        }
                        //cod 7 send players array
                        case 7: {
                            //System.out.println("AM ajuns player");
                             
                            ArrayList<String> users = getListaUtilizatori();        
                            outt.writeObject(users);
                            break;
                         }
                        //code 8 send rooms array
                        case 8:{
                            //System.out.println("AM ajuns room");
                            ArrayList<String> users = getListaRoom();        
                            outt.writeObject(users);
                            break;
                        }
                        case 9:
                        {
                            //System.out.println("Uraaa! A Ajuns in case 8");
                            
                            this.cameraJoc.makeMove(Integer.parseInt(request.substring(2,3)),Integer.parseInt(request.substring(3,4)),Integer.parseInt(request.substring(5,6)),Integer.parseInt(request.substring(6,7)), this);
                            break;
                        }
                        default:
                        {
                            //!!!!!!!!!!!!!!!!!!!!!AICICI AI ADAUGAT COD!!!!!!!!!!!!!!!!!!!!!!!
                            out.println("Cod nerecunoscut");
                            break;
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try{
                    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!AICICICICI!!!!!!!!!!!!!!!!!!!!!
                    listaUtilizatori.remove(this);
                    socket.close();
                }
                catch(IOException e)
                {
                    System.out.println("Can't close the socket of client "+clientNumber+" Exceptio: "+e);
                }
            }
            
            
        }
    public int getID()
    {
        return idUser;
    }
    //AICICI INCEP MODIFICARI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    
    public String getNume()
    {
        return numeUser;
    }
    
    
    private synchronized boolean writeMsg(String msg) {
        if(!socket.isConnected()) {
            try {
                socket.close();
                }
            catch(SocketException e){
                System.out.println(e.getMessage());
                }
            catch(IOException e){
                System.out.println(e.getMessage());
                }
                return false;
            }

            out.println(msg);
            return true;
        }

    private static synchronized void broadcast(String message,String nume) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        String time = sdf.format(new Date());
        String messageLf = "6;"+time+" "+nume + ": " + message;

        for(int i = listaUtilizatori.size() - 1; i >= 0; i--) {
            Player player = listaUtilizatori.get(i);
            // try to write to the Client if it fails remove it from the list
            if(!player.writeMsg(messageLf)) {
                listaUtilizatori.remove(i);
                System.out.println("Disconnected Client " + player.numeUser + " removed from list.");
            }
        }
    }
private synchronized void createRoom(BufferedReader in,PrintWriter out,String numeCamera)
    {
        int n=listaCamere.size();
        Boolean ok=true;

        for(int i=0;i<n;++i)
            if(listaCamere.get(i).getNume().equals(numeCamera))
                {
                    ok=false;
                    out.println("-4;Acest nume este deja folosit");
                }
                if(ok==true)
                try{
                    room camera=new room(this,numeCamera);
                    cameraJoc=camera;
                                listaCamere.add(camera);
                                out.println("4;Camera creata");
                                       for(int i = listaUtilizatori.size() - 1; i >= 0; i--) {
                                Player player = listaUtilizatori.get(i);
                            // try to write to the Client if it fails remove it from the list
                            if(!player.writeMsg("2;"+numeCamera)) {
                                listaUtilizatori.remove(i);
                                 System.out.println("Disconnected Client " + player.numeUser + " removed from list.");
                                        }
                                       }                    
                                
                                
                                
                            }catch(Exception e)
                            {
                                out.println("4;Probleme la creare");
                            }
    }
    
    private synchronized void enterRoom(BufferedReader in,PrintWriter out,String numeCamera)
    {
                            int n=listaCamere.size();
                            Boolean found=false;
                            room foundRoom=null;
                            for(int i=0;i<n;++i)
                                if(numeCamera.equals(listaCamere.get(i).getNume()))
                                {
                                    found=true;
                                    foundRoom=listaCamere.get(i);
                                    break;
                                }
                            
                            if(foundRoom==null)
                            {
                                out.println("-5;Camera "+numeCamera+" nu exista");
                            }
                            else
                            {
                                if(foundRoom.aderare(this).equals(true))
                                {
                                    cameraJoc=foundRoom;
                                    out.println("5;Ai intrat in camera");
                                    
                                }
                                else
                                out.println("-5;Nu ai intrat in camera, fie ai fost refuzat, fie camera are deja 2 jucatri");
                            }
    }
    
     //GATA MODIFICARI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }
    
        private static ArrayList decode(String a)
    {
        ArrayList<String> localList=new ArrayList<>();
        int n=a.length();
        int poz=0;
        String subExit=a.substring(0,1);
        switch (subExit) {
            case "-1":
                localList.add(subExit);
                break;
            case "4":
                localList.add(subExit);
                break;
            case "5":
                localList.add(subExit);
                break;
            case "6":
                localList.add(subExit);
                localList.add(a.substring(2));
                break;
            case "7":
                localList.add(subExit);
                break;
            case "8":
                localList.add(subExit);
                break;
            case "9":
                localList.add(subExit);
                break;
            default:
                if(a.substring(0,2).equals("DA"))
                {
                    localList.add("99999");
                    break;
                }
                for(int i=0;i<3;++i)
                {
                    String word="";
                    while(poz<n)
                    {
                        String sub=a.substring(poz,poz+1);
                        if(sub.equals(";"))
                            break;
                        word = word.concat(sub);
                        ++poz;
                        
                    }
                    ++poz;
                    localList.add(word);
                }       String word="";
                String sub=a.substring(poz,n);
                word=word.concat(sub);
                localList.add(word);
                break;
        }
    return localList;

    }
        
        
    private static class room{
        private final Player white;
        public  Player black;
        private  Player currentPlayer;
        private final String nume;
        
        Game game;
        public room(Player X,String NUME ){
            white=X;
            black=null;
            currentPlayer=white;
            nume=NUME;
            game=new Game();
        }
        //COD ADAUGAT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        public synchronized Boolean aderare(Player Y)
        {
            if(black!=null)
                return false;
            black=Y;
            return true;
        }
        
        public String getNume()
        {
            return nume;
        }
        public synchronized boolean makeMove(int linie, int coloana,int linieNoua, int coloanaNoua,Player jucator)
        {
            if(jucator!=this.currentPlayer)
            {
                jucator.writeMsg("-9;Este randul oponentului");
                return false;
            }
            else
            {
               if(game.move(linie,coloana,linieNoua,coloanaNoua)==true)
               {
                  // System.out.println("A ajuns aici la game move");
                if(currentPlayer==white) currentPlayer=black;
                else
                    currentPlayer=white;
                jucator.writeMsg("9;"+linie+coloana+";"+linieNoua+coloanaNoua+";");
                currentPlayer.writeMsg("9;"+linie+coloana+";"+linieNoua+coloanaNoua+";");
                return true;
                }
               else
               {
                   jucator.writeMsg("-9;Mutare nevalida");
               }
            }
        //COD ADAUGAT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            return false;
    }    
        //COD ADAUGAT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }    
}
