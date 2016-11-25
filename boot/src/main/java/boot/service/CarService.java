package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.CarRepository;
import boot.model.Car;

@Service
@Transactional
public class CarService {
	private final CarRepository carRepository;
	
	public CarService(CarRepository carRepository){
		super();
		this.carRepository=carRepository;
	}
	
	public List<Car>findAll(){
		List<Car> cars=new ArrayList<Car>();
		for(Car car:carRepository.findAll()){
			cars.add(car);
		}
		return cars;
	}
	
	public void save(Car car){
		carRepository.save(car);
	}
	public void delete(int id){
		carRepository.delete(id);
	}
	public Car findCar(int id){
		return carRepository.findOne(id);
	}
	
}
