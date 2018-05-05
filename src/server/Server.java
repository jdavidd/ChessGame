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
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int clientNumber=0;
        listaUtilizatori=new ArrayList<>();
        listaCamere=new ArrayList();
        try(ServerSocket listener = new ServerSocket(9999)) {
            while(true){
            new Player(listener.accept(),clientNumber++).start();
            }
        }
        
    }
    
    private static class Player extends Thread{
        private final int clientNumber;
        private final Socket socket;
        private final conexiuneBazaUtilizator conexiuneUtilizator;
        private int idUser;
        private String numeUser;
        public Player(Socket socket,int clientNumber){
            idUser=0;
            numeUser=new String();
            this.clientNumber=clientNumber;
            this.socket=socket;
            conexiuneUtilizator=new conexiuneBazaUtilizator();
            System.out.println("There is a new connection with client number "+clientNumber);
        }
        @Override
        public void run(){
            try {
                
                BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
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
                            break OUTER;
                        }
                    //S-a facut o cerere de inregistrare
                        case 1:
                        {
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
                                {listaUtilizatori.add(this);
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
                        }
                        //Cerere pentru creare camera
                        case 4:
                        {
                            String numeCamera=request.substring(2,request.length());
                            try{
                                listaCamere.add(new room(this,numeCamera));
                                out.println("1;Camera creata");
                            }catch(Exception e)
                            {
                                out.println("0;Probleme la creare");
                            }
                            
                        }
                        default:
                        {
                            break;
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try{
                    socket.close();
                }
                catch(IOException e)
                {
                    System.out.println("Can't close the socket of client "+clientNumber+" Exceptio: "+e);
                }
            }
            
            
        }
     int getID()
    {
        return idUser;
    }
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
            default:
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
        Player white;
        Player black;
        String nume;
        public room(Player X,String NUME ){
            white=X;
            black=null;
            nume=NUME;
        }
        public Boolean addPlayer(Player X)
        {
            try{
                black=X;
            }
            catch(Exception e){
                System.out.println("There are problems in adding player");
                return false;
            }
            return true;
        }  
        
    }    
}
