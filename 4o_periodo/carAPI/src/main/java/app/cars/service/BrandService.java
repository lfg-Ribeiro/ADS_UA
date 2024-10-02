package app.cars.service;

import app.cars.entity.Brand;
import app.cars.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public String save(Brand brand) {
        brandRepository.save(brand);
        return (brand.getName() + "saved successfully!");
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand findById(Long id) {
        return brandRepository.findById(id).get();
    }

    public String update(Long id, Brand brand) {
        brand.setId(id);
        brandRepository.save(brand);
        return (brand.getName() + "updated successfully!");
    }

    public String delete(Long id) {
        brandRepository.deleteById(id);
        return "deleted successfully";
    }
}
