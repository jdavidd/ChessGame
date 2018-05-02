/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author c-tin
 */

//Clasa mailSender contine mai multe metoda care trimit mail;


public class mailSender {
    
    public static Boolean sendMailRecuperareDateCont(String mail,String nume, String parola)
    {
        final String username = "chessservermds@gmail.com"; // enter your mail id
		final String password = "MDSprogramare1234";// enter ur password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("chessservermds@gmail.com")); // same email id
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(mail));// whome u have to send mails that person id
			message.setSubject("Recuperare Date Cont");
			message.setText("Buna ziua,\n\nAcest mail contine informatiile pe care le-ati cerut.\nDatele contului dumneavoastra sunt:\n"
                                +"Username: "+nume+"\nParola: "+parola
                                +"\nadresa mail: "+mail
				+ "\n\n Va multumim ca utilizati aplicatia noastra! Echipa noastra incearca sa ofere utilizatorilor cea"
                        +" mai frumoasa experienta in ceea ce priveste jocul de sah.\nPentru orice informatii ne puteti contacta prin mail\n\n"
                        +"Toate cele bune si mult spor la sah,\nEchipa Masters Mind");

			Transport.send(message);
                        return true;

		} catch (MessagingException e) {
			throw new RuntimeException(e);

		}
	}
    
}
