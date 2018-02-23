/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sparsha
 */
import java.io.File;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class Mailer {
    
    static final String username="saha.sparsha@gmail.com";
    static final String password="Sparsha97";
    
    String tomail;
    public Mailer(String addr)
    {
        this.tomail=addr;
    }
    
    public void send_mail()
    {
        Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                
        
                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
                
                
        		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("saha.sparsha@gmail.com"));

			// recipients email address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.tomail));

			// add the Subject of email
			message.setSubject("Got the stuff bro");

			Multipart multipart = new MimeMultipart();

			// add the body message
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setText("Log file attached");
			multipart.addBodyPart(bodyPart);

			// attach the file
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.attachFile(new File("logs.txt"));
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Email Sent Successfully");

		} catch (Exception e) {
			e.printStackTrace();

		}

        
    }
    
    public static void main(String args[])
    {
        Mailer m=new Mailer("saha.sparsha@gmail.com");
        m.send_mail();
    }
}
