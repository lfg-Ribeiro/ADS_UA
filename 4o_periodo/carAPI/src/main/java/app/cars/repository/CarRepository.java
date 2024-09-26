package app.cars.repository;

import app.cars.entity.Brand;
import app.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    public List<Car> findByName(String name);

    public List<Car> findByBrand(Brand brand);
}
