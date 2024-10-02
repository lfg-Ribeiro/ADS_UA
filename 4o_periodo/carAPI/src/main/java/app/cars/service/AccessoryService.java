package app.cars.service;

import app.cars.entity.Accessory;
import app.cars.repository.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryService {
    @Autowired
    private AccessoryRepository accessoryRepository;

    public String save(Accessory accessory) {
        accessoryRepository.save(accessory);
        return (accessory.getName() + " saved successfully!");
    }

    public List<Accessory> findAll() {
        return accessoryRepository.findAll();
    }

    public Accessory findById(Long id) {
        return accessoryRepository.findById(id).get();
    }

    public String update(Long id, Accessory accessory) {
        accessory.setId(id);
        accessoryRepository.save(accessory);
        return (accessory.getName() + "updated successfully!");
    }

    public String delete(Long id) {
        accessoryRepository.deleteById(id);
        return "deleted successfully";
    }
}
