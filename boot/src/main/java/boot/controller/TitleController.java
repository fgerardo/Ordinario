package boot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Task;
import boot.model.Title;
import boot.service.TaskService;
import boot.service.TitleService;

@Controller
public class TitleController {
	
	@Autowired
	private TitleService titleService;
	@GetMapping("title")
	public String home(HttpServletRequest request){
		request.setAttribute("mode","MODE_HOME");
		return "title";
	}
	//*Apartir de aqui nuevos metodos*/
	@GetMapping("/all-titles")
	public String allTitles(HttpServletRequest request){
		request.setAttribute("titles",titleService.findAll());
		request.setAttribute("mode","MODE_TITLES");
		return "title";
	}
	
	@GetMapping("/new-title")
	public String newTitle(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "title";
	}
	@PostMapping("/save-title")
	public String saveTitle(@ModelAttribute Title title,BindingResult bindingResult, HttpServletRequest request){
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		Date toDate=new Date();
		try{
			toDate=format.parse(request.getParameter("toDate"));
		}catch (ParseException e){
			e.printStackTrace();
		}
		
		title.setToDate(toDate);
		
		titleService.save(title);
		request.setAttribute("titles",titleService.findAll());
		request.setAttribute("mode","MODE_TITLES");
		return "title";
	}
	
	
	@GetMapping("/update-title")
	public String updateTitle(@RequestParam int idTitle,HttpServletRequest request){
		request.setAttribute("title",titleService.findTitle(idTitle));
		request.setAttribute("mode","MODE_UPDATE");
		return "title";
	}
	@GetMapping("/delete-title")
	public String deleteTitle(@RequestParam int idTitle,HttpServletRequest request){
		titleService.delete(idTitle);
		request.setAttribute("titles",titleService.findAll());
		request.setAttribute("mode","MODE_TITLES");
		return "title";
	}


}
