package boot.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Title;
import boot.model.Transport;
import boot.service.TitleService;
import boot.service.TransportService;

@Controller
public class TransportController {
	@Autowired
	private TransportService transportService;
	@GetMapping("transport")
	public String home(HttpServletRequest request){
		request.setAttribute("mode","MODE_HOME");
		return "transport";
	}
	//*Apartir de aqui nuevos metodos*/
	@GetMapping("/all-transports")
	public String allTransports(HttpServletRequest request){
		request.setAttribute("transports",transportService.findAll());
		request.setAttribute("mode","MODE_TRANSPORTS");
		return "transport";
	}
	
	@GetMapping("/new-transport")
	public String newTransport(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "transport";
	}
	@PostMapping("/save-transport")
	public String saveTransport(@ModelAttribute Transport transport,BindingResult bindingResult, HttpServletRequest request){
		transportService.save(transport);
		request.setAttribute("transports",transportService.findAll());
		request.setAttribute("mode","MODE_TRANSPORTS");
		return "transport";
	}
	
	
	@GetMapping("/update-transport")
	public String updateTransport(@RequestParam int idTransport,HttpServletRequest request){
		request.setAttribute("transport",transportService.findTransport(idTransport));
		request.setAttribute("mode","MODE_UPDATE");
		return "transport";
	}
	@GetMapping("/delete-transport")
	public String deleteTransport(@RequestParam int idTransport,HttpServletRequest request){
		transportService.delete(idTransport);
		request.setAttribute("transports",transportService.findAll());
		request.setAttribute("mode","MODE_TRANSPORTS");
		return "transport";
	}

}
