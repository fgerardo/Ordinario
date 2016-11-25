package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Car;

public interface CarRepository extends CrudRepository<Car,Integer> {

}
