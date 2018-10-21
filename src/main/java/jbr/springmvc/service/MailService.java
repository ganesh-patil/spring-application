package jbr.springmvc.service;

import jbr.springmvc.model.Entries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.Future;

public class MailService {

    @Autowired
    JavaMailSender mailSender;

    @Async
    public Future<String> sendEmail(Object object) {

        Entries entry = (Entries) object;

        MimeMessagePreparator preparator = getMessagePreparator(entry);

        try {
            mailSender.send(preparator);
            System.out.println("Message Send...");
            return new AsyncResult<String>("Mail sent sucessfully ");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    private MimeMessagePreparator getMessagePreparator(final Entries entry) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom(new InternetAddress("patil.ganesh170@gmail.com"));
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress("patil.ganesh170@gmail.com"));
                mimeMessage.setText("Dear New entry added ");
                mimeMessage.setSubject("New entry added ");
            }
        };
        return preparator;
    }
}
