package urna.urna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urna.urna.entity.Eleitor;
import urna.urna.service.EleitorService;

import java.util.List;

@RestController
@RequestMapping("/eleitores")
public class EleitorController {

    @Autowired
    private EleitorService eleitorService;

    @GetMapping
    public List<Eleitor> getAllEleitores() {
        return eleitorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eleitor> getEleitorById(@PathVariable Long id) {
        Eleitor eleitor = eleitorService.findById(id);
        if (eleitor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eleitor);
    }

    @PostMapping
    public Eleitor createEleitor(@RequestBody Eleitor eleitor) {
        return eleitorService.save(eleitor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eleitor> updateEleitor(@PathVariable Long id, @RequestBody Eleitor eleitor) {
        Eleitor existingEleitor = eleitorService.findById(id);
        if (existingEleitor == null) {
            return ResponseEntity.notFound().build();
        }
        eleitor.setId(id);  // Garante que o ID esteja definido para a atualização
        Eleitor updatedEleitor = eleitorService.save(eleitor);
        return ResponseEntity.ok(updatedEleitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEleitor(@PathVariable Long id) {
        eleitorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}