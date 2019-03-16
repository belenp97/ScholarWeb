package es.urjc.etsii.dad.InternalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

	@Autowired
	private ProtocolIntenal smtp;
	
	@PostMapping("/send")
	public void sendEmail(Model model, @RequestBody Mail mail) {
		
		if(smtp.send(mail.getParameters())) {
			System.out.println("Servicio Interno ha enviado correctamente el e-mail. " + mail);
		} else {
			System.out.println("Servicio Interno no ha podido enviar el correo. " + mail.getTo());
		}
		
	}
	
}