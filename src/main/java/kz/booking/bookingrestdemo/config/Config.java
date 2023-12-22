package kz.booking.bookingrestdemo.config;

import org.springframework.context.annotation.Configuration;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Configuration
public class Config{
    static final String from = "reservease7@gmail.com";
    static final String host = "smtp.gmail.com";
    static final String port = "465";
    public void send(String to, String subject, String text){
        System.out.println("send");
        Properties properties = new Properties();
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port",Integer.parseInt(port));
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        Session session = Session.getInstance(
                properties,
                new Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(from,"wbbccfsswmjfhtbu");
                    }
                }
        );
        session.setDebug(true);
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(String.valueOf(new InternetAddress(from)));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
