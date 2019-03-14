package es.urjc.etsii.dad.InternalService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class ProtocolIntenal {

	@Autowired
	private JavaMailSender sender;
	
	public boolean send(String [] emailParameters) {
		
		MimeMessage email = sender.createMimeMessage();
		
		try {
			
			MimeMessageHelper helper = new MimeMessageHelper(email,true);
			
			//Campos necesarios para mandar el correo 
			helper.setFrom(emailParameters[0]); // dirección origen
			helper.setTo(emailParameters[1]); // dirección destino
			helper.setSubject(emailParameters[2]); // asunto del correo
			helper.setText(emailParameters[3], true); // cuerpo del mensaje
			
			sender.send(email);
			
			return true;
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
}