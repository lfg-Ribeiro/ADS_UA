package app.cars.service;

import app.cars.entity.Brand;
import app.cars.entity.Car;
import app.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public String save(Car car) {
        carRepository.save(car);
        return (car.getName() + " saved successfully!");
    }

    public List<Car> findAll() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    public Car findById(Long id) {
        Car car = carRepository.findById(id).get();
        return car;
    }

    public String update(Long id, Car car) {
        car.setId(id);
        carRepository.save(car);
        return (car.getName() + " updated successfully!");
    }

    public String delete(Long id) {
        carRepository.deleteById(id);
        return "deleted successfully!";
    }

    public List<Car> findByName(String name) {
        System.out.println(name);
        return carRepository.findByName(name);
    }

    public List<Car> findByBrand(Long idBrand) {
        Brand brand = new Brand();
        brand.setId(idBrand);
        return carRepository.findByBrand(brand);
    }
}
