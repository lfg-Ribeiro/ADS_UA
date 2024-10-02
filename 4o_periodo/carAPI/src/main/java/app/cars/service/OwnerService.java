package app.cars.service;

import app.cars.entity.Owner;
import app.cars.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public String save(Owner owner) {
        ownerRepository.save(owner);
        return (owner.getName() + "saved successfully!");
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Owner findById(Long id) {
        return ownerRepository.findById(id).get();
    }

    public String update(Long id, Owner owner) {
        owner.setId(id);
        ownerRepository.save(owner);
        return (owner.getName() + "updated successfully!");
    }

    public String delete(Long id) {
        ownerRepository.deleteById(id);
        return "deleted successfully!";
    }
}
