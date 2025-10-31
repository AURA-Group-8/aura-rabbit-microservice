package com.aura8.rabbitmqservice.rabbitmq;

import com.aura8.rabbitmqservice.config.RabbitConfig;
import com.aura8.rabbitmqservice.config.MailConfig;
import com.aura8.rabbitmqservice.exception.EmailFailedException;
import com.aura8.rabbitmqservice.service.TwilioService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



import java.util.Map;

@Service
public class Consumer {

    @Autowired
    TwilioService twilioService;

    @Autowired
    MailConfig mailConfig;

    @RabbitListener(queues = RabbitConfig.SEND_MESSAGE_QUEUE)
    public void receiveMessage(Map<String, Object> message) {


//        System.out.println(message.get("phone"));
//        System.out.println(message.get("subject"));
//        System.out.println(message.get("message"));
//
//        System.out.println("Mensagem recebida: " + message);

        twilioService.sendWhatsappMessage(
                message.get("phone").toString(),
                message.get("subject") != null ? message.get("subject").toString() : "",
                message.get("message").toString()
        );

    }

    @RabbitListener(queues = RabbitConfig.SEND_EMAIL_QUEUE)
    public void receiveEmail(Map<String, Object> email) {
//        System.out.println(email.get("from"));
//        System.out.println(email.get("to"));
//        System.out.println(email.get("subject"));
//        System.out.println(email.get("text"));
//        System.out.println("Email recebido: " + email);

        try {
            JavaMailSender emailSender = mailConfig.getJavaMailSender();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.get("from").toString());
            message.setTo(email.get("to").toString());
            message.setSubject(email.get("subject").toString());
            message.setText(email.get("text").toString());
            System.out.println(message);
            emailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmailFailedException("Erro ao enviar e-mail, tente verificar as credênciais");
        }

    }
}