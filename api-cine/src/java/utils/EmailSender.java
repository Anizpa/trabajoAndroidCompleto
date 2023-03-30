/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.dto.Salas;

/**
 *
 * @author S1-PC54
 */
public class EmailSender {

    String to = "a26007@svalero.com";
    String from = "anizpa19@gmail.com";
    String password = "hqktkapjrrjjxbto";

    Salas sala;
    int cantidad;
 

    public EmailSender(String to, Salas sala, int cantidad) {
        //this.to = to;
        this.sala = sala;
        this.cantidad = cantidad;
    }

    public void sendEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }

        });

        try {
            // Creación del mensaje de correo electrónico
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Compra de entradas");
            String text = "Detalles de tu compra: \n"
                    + "Película: " + sala.getTitulo() + "\n"
                    + "Cine: " + sala.getNombreCine() + "\n"
                    + "Sala: " + sala.getIdSala() + "\n"
                    + "Horario: " + sala.getHorario() + "\n"
                    + "Entradas: " + cantidad + "\n";;

            text += "\n"
                    + "¡Muchas gracias por su compra!";

            message.setText(text);

            // Envío del mensaje de correo electrónico
            Transport transporte = session.getTransport("smtp");
            transporte.connect(from, password);
            transporte.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transporte.close();
//            Transport.send(message);

            System.out.println("El correo electrónico ha sido enviado correctamente.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
