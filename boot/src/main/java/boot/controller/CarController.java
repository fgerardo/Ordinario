package boot.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import boot.model.Car;
import boot.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@GetMapping("car")
	public String home(HttpServletRequest request){
		request.setAttribute("mode","MODE_HOME");
		return "car";
	}
	
	@GetMapping("/all-cars")
	public String allCars(HttpServletRequest request){
		request.setAttribute("cars",carService.findAll());
		request.setAttribute("mode","MODE_CARS");
		return "car";
	}
	
	@GetMapping("/new-car")
	public String newCar(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "car";
	}
	@PostMapping("/save-car")
	public String saveCar(@ModelAttribute Car car,BindingResult bindingResult, HttpServletRequest request){
		carService.save(car);
		request.setAttribute("cars",carService.findAll());
		request.setAttribute("mode","MODE_CARS");
		return "car";
	}
	
	
	@GetMapping("/update-car")
	public String updateCar(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("car",carService.findCar(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "car";
	}
	@GetMapping("/delete-car")
	public String deletCar(@RequestParam int id,HttpServletRequest request){
		carService.delete(id);
		request.setAttribute("cars",carService.findAll());
		request.setAttribute("mode","MODE_CARS");
		return "car";
	}

}
