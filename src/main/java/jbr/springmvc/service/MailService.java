package jbr.springmvc.service;

import jbr.springmvc.model.Entries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(Object object) {

        Entries entry = (Entries) object;

        MimeMessagePreparator preparator = getMessagePreparator(entry);

        try {
            mailSender.send(preparator);
            System.out.println("Message Send...");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
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
