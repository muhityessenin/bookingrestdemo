package kz.booking.bookingrestdemo.observer;

import jakarta.mail.internet.InternetAddress;
import kz.booking.bookingrestdemo.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.nio.channels.SeekableByteChannel;
import java.util.Properties;

@Component
@Slf4j
public class EmailSubscriber {
    private final String from = "eseninmukhit@gmail.com";
    private String host = "smtp.gmail.com";
    private String port = "465";
    private Config config;
    public EmailSubscriber(Config config) {
        this.config = config;
    }

    public void update(String userEmail, String message) {
        try {
            config.send(userEmail,"Reservation Notification",message);
        } catch (MailException e) {
            log.info(e.getMessage());
        }
    }
}
