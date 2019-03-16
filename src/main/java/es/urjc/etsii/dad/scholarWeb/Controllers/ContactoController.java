//package es.urjc.etsii.dad.scholarWeb.Controllers;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import InternalService.EmailService;
//
//
//@Controller
//public class ContactoController {
//	
//	 private EmailService mailService;
//
//	@RequestMapping(value="/contacto", method=RequestMethod.GET)
//	public String newContacto(Model model) {
//
//		return "contacto";// llamarlo como se llama el html
//	}
//	
//	@RequestMapping(value="/recibido", method=RequestMethod.POST)
//	public String contactoRecibido(Model model, HttpServletRequest request, @RequestParam String nombre, @RequestParam Integer telefono, @RequestParam String email, @RequestParam String cuerpo) {
//		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
//		model.addAttribute("token", token.getToken());
//		
//		
//		
//		return "contacto_recibido";
//	}
//	
//   @PostMapping("/sendMail")
//    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body){
//
//        String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
//        mailService.sendMail("mail de propiedades","mail de contacto",subject,message);
//
//        return "contacto_recibido";
//   }
//	
//}