import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class mail 
{
   public void sendemail(String toAddress,String subject, String message) throws AddressException,MessagingException 
   {       
        //Smtp server information  
         String host = "smtp.gmail.com";
         String port = "587";
         final String userName="votingproject08@gmail.com";
         final String password ="voting@08";        
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());

        // set plain text message
        msg.setContent(message, "text/html");
        // sends the e-mail
        Transport.send(msg);
    }
     mail(String mail,String subject,String message)
    {
        try {
            
               sendemail(mail,subject, message);
               System.out.println("Email sent.");
        }
        catch (MessagingException ex) 
        {
             System.out.println("Failed to sent email.\n"+ex);
        }
    }
     
}