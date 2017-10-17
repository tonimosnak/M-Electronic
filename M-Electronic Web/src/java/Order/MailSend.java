package Order;

import static com.mchange.v2.c3p0.impl.C3P0Defaults.password;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {
    
    public void mailSend(String username, String password, String subject, String massage, String toEmail, String fromEmail) throws NoSuchProviderException, MessagingException{
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(true);

        Message mailMassage = new MimeMessage(mailSession);

        mailMassage.setFrom(new InternetAddress(fromEmail));
        mailMassage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        mailMassage.setContent(massage, "text/html; charset=UTF-8");
        mailMassage.setSubject(subject);

        Transport transport = mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", username, password);
        transport.sendMessage(mailMassage, mailMassage.getAllRecipients());
    }
    
}
