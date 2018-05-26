/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author c-tin
 */

//Clasa codeRequest contine metoda care codifica Stringuri in mesaje pentru a fi trimise la server
//metodele respecta conventia de mesaje intre client si server
//
//METODA codeRequestLoginRegisterMail
//Metoda codeRequestLoginRegisterMail codifica mesaje pentru Login, Register si Recuperare date cont
//input metoda: 4 striguri, cele patru stringuri trebuie sa cel putin "", acestea nu pot avea valoarea null, 
//altfel metoda nu va functiona
//type=tipul de cerere la server ("-1"=clientul se va inchide "1"=Register "2"=Login "3"=cerere mail date cont)
//nume=numele de utilizator, NU POATE AVEA VALOAREA NULL, pentru lispa numelui folositi ""
//parola=parola utilizator, NU POATE AVEA VALOAREA NULL, pentru lispa numelui folositi ""
//mail=mail utilizator, NU POATE AVEA VALOAREA NULL, pentru lispa numelui folositi ""
public class codeRequest{
    
    public String codeRequestLoginRegisterMail(String type,String nume, String parola, String id)
    {
        String codedMessage=new String();
            switch (type) {
                case "-1":
                {
                    codedMessage="-1;;;";
                    return codedMessage;
                }
                case "1":
                    if(nume.equals("")||parola.equals("")||id.equals(""))
                    {
                        //Numele,parola sau mail nu este valid; pentru inregistrare trebuie cel putin 1 caracter
                        return null;
                    }   codedMessage=codedMessage.concat("1;");
                    break;
                case "2":
                    if(nume.equals("")||parola.equals(""))
                    {
                        //Numele sau parola nu este valid; pentur inregistrare trebuie cel putin 1 caracter
                        return null;
                    }    codedMessage=codedMessage.concat("2;");
                    break;
                case "3":
                    if(id.equals(""))
                    {
                        //Numele sau parola nu este valid; pentur inregistrare trebuie cel putin 1 caracter
                        return null;
                    }    codedMessage=codedMessage.concat("3;");
                    break;
                default:
                    return null;
            }
           
           codedMessage=codedMessage.concat(nume+";");
           codedMessage=codedMessage.concat(parola+";");
           codedMessage=codedMessage.concat(id);
        
        return codedMessage;
    }
}