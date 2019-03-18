package es.urjc.etsii.dad.scholarWeb.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import InternalService.Mail;


@Controller
@RequestMapping("/contacto")
public class ContactoController {
	

	private static final String RestService = "http://127.0.0.1:8070/send"; 
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String newContacto(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "contacto";// llamarlo como se llama el html
	}
	
   @RequestMapping(value="/contacto/sendMail", method=RequestMethod.POST )
    public String sendMail(Model model, HttpServletRequest request, @RequestParam String name,@RequestParam String telefono, @RequestParam String mail, @RequestParam String body){
	   CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
	   model.addAttribute("token", token.getToken());
	   if(mail!="" && body!="") {
		   RestTemplate servInterno = new RestTemplate(); 
		   
	       String from = "scholar.web.dad@gmail.com"; // dirección de correo remitente -> usuario Administrador
	       String to = mail; // dirección del correo de destino -> nuevo usuario
	       String bodys = "Hola " + name + ", has sido contactado por la pag ScholarWeb facilitandonos el Telefono " + telefono + ", el Email: " +mail +"y el mensaje: " +body +" en breves le responderemos. \n Un saludo ScholarWeb.";
			
	       // AL INVOCAR ESTE MÉTODO LE PASO COMO PARÁMETROS LA URL DEL CONTROLADOR REST Y EL CORREO QUE QUIERO ENVIAR AL DESTINATARIO
	       servInterno.postForLocation(RestService, new Mail(from,to,"conctato en pag ScholarWeb",bodys));
	       servInterno.postForLocation(RestService, new Mail(from,from,"conctato en pag ScholarWeb",bodys));
			
	       return "contacto_recibido";
	   }
	return "formularioError";
   }
	
}