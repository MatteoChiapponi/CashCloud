package com.mateo.notificationsms.bussiness.services.impl;

import com.mateo.notificationsms.bussiness.services.IMailSenderService;
import com.mateo.notificationsms.bussiness.services.INotifyService;
import com.mateo.notificationsms.dtos.events.NewUserRegisteredData;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMultipart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class notifyUserRegistrationService implements INotifyService<NewUserRegisteredData> {

    private final IMailSenderService<MimeMultipart> mailSenderService;
    @Override
    public void notify(NewUserRegisteredData message) {
        MimeMultipart content = new MimeMultipart("related");
        var body = "<html>" +
                    "<body style='font-family: 'Poppins', sans-serif; background-color: rgb(234, 234, 234); display: flex; justify-content: center; margin: 0px;'>" +
                "       <div style = display: flex; flex-direction: column; background-color: rgb(247, 249, 251); max-width: 100%; height: 100vh; justify-content: space-between;'>" +
                "           <div> " +
                "               <div style=' height: 70px; background-color: rgb(61, 61, 61); display: flex; padding-left: 16px;'><img src='#' alt='#' style='width: 400px; padding-left: 16px; max-width: 100%;' /> </div>" +
                "                   <div style='padding-left: 16px; padding-right: 16px; padding-top: 32px; color: #3d3d3d;'>" +
                "                       <p style='margin-bottom: 0'> Hola <span>"+message.firstName() +" "+ message.lastName() +"</span>.</p>" +
                "                       <p style='margin-bottom: 0'>¡Tu cuenta en CashCloud fue creada exitosamente!</p>" +
                "                       <p>El email con el que creaste la cuenta fue <strong>"+message.email()+"</strong>.</p>" +
                "                       <p style='margin-bottom: 0'>una vez verifiques tu email, puedes hacer click<strong><a style='color: #6d6de1; text-decoration: underline;' href='#'> aquí</a></strong> para iniciar sesión.</p>" +
                "                   </div>" +
                "               </div>" +
                "           <div style='padding-top: 40px; padding-left: 16px; padding-bottom: 16px;'>" +
                "               <img src='#' alt='Logo CashCloud' />" +
                "               <p style='font-size: 13px; margin: 0px; color: #939393'>Usa tu plata fácil y rápido</p>" +
                "               <span style='font-size: 13px; color: #6d6de1'><a href='mailto:cashcloud@gmail.com'>cashcloud@gmail.com</a></span>" +
                "           </div>" +
                "       </div>" +
                "   </body>" +
                "</html>";
        MimeBodyPart html = new MimeBodyPart();
        try {
            html.setContent(body, "text/html");
            content.addBodyPart(html);
        } catch (MessagingException e) {
            throw new RuntimeException("un error creando el htlm");
        }
        //generar estilo del email
        mailSenderService.sendEmail(message.email(), "¡Successfully registered!",content);
    }
}
