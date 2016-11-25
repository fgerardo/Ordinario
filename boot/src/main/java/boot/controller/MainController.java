package boot.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import boot.model.Task;

import boot.service.CarService;

import boot.service.TaskService;

@Controller
public class MainController {
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private CarService carService;
	
	
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode","MODE_HOME");
		return "index";
	}
	
	
	
	//*Apartir de aqui nuevos metodos*/
	/*
	 * @GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("tasks",taskService.findAll());
		request.setAttribute("mode","MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "index";
	}
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task,BindingResult bindingResult, HttpServletRequest request){
		taskService.save(task);
		request.setAttribute("tasks",taskService.findAll());
		request.setAttribute("mode","MODE_TASKS");
		return "index";
	}
	
	
	@GetMapping("/update-task")
	public String updateTask(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("task",taskService.findTask(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "index";
	}
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id,HttpServletRequest request){
		taskService.delete(id);
		request.setAttribute("tasks",taskService.findAll());
		request.setAttribute("mode","MODE_TASKS");
		return "index";
	}*/
	//*Terminan metodos de Task**//
	/*
	@GetMapping("/all-bills")
	public String allBills(HttpServletRequest request){
		request.setAttribute("bills",billService.findAll());
		request.setAttribute("mode","MODE_BILLS");
		return "index";
	}
	
	@GetMapping("/new-bill")
	public String newBill(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEWB");
		return "index";
	}
	@PostMapping("/save-bill")
	public String saveBill(@ModelAttribute Bill bill,BindingResult bindingResult, HttpServletRequest request){
		billService.save(bill);
		request.setAttribute("bills",billService.findAll());
		request.setAttribute("mode","MODE_BILLS");
		return "index";
	}
	
	
	@GetMapping("/update-bill")
	public String updateBill(@RequestParam int id_bill,HttpServletRequest request){
		request.setAttribute("bill",billService.findBill(id_bill));
		request.setAttribute("mode","MODE_UPDATEB");
		return "index";
	}
	@GetMapping("/delete-bill")
	public String deleteBill(@RequestParam int id_bill,HttpServletRequest request){
		billService.delete(id_bill);
		request.setAttribute("bills",billService.findAll());
		request.setAttribute("mode","MODE_BILLS");
		return "index";
	}*/
	/*Aqui inicia RELATION*/
	/*
	@GetMapping("/all-relationCompositions")
	public String allRelationCompositions(HttpServletRequest request){
		request.setAttribute("relation_composition",relationCompositionService.findAll());
		request.setAttribute("mode","MODE_RELATIONS");
		return "index";
	}
	
	@GetMapping("/new-relationComposition")
	public String newRelationComposition(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEWR");
		return "index";
	}
	@PostMapping("/save-relationComposition")
	public String saveRelationComposition(@ModelAttribute RelationComposition relationComposition,BindingResult bindingResult, HttpServletRequest request){
		relationCompositionService.save(relationComposition);
		request.setAttribute("relation_composition",relationCompositionService.findAll());
		request.setAttribute("mode","MODE_RELATIONS");
		return "index";
	}
	
	@GetMapping("/update-relationComposition")
	public String updateRelationComposition(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("relationComposition",relationCompositionService.findRelationComposition(id));
		request.setAttribute("mode","MODE_UPDATER");
		return "index";
	}
	@GetMapping("/delete-relationComposition")
	public String deleteRelationComposition(@RequestParam int id,HttpServletRequest request){
		relationCompositionService.delete(id);
		request.setAttribute("relation_composition",relationCompositionService.findAll());
		request.setAttribute("mode","MODE_RELATIONS");
		return "index";
	}*/
	
	
}
