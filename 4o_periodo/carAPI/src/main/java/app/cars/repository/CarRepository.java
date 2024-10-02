package app.cars.repository;

import app.cars.entity.Brand;
import app.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByName(String name);

    List<Car> findByBrand(Brand brand);
}
