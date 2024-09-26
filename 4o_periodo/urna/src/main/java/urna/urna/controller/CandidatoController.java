package urna.urna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urna.urna.entity.Candidato;
import urna.urna.service.CandidatoService;

import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping
    public List<Candidato> getAllCandidatos() {
        return candidatoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidato> getCandidatoById(@PathVariable Long id) {
        Candidato candidato = candidatoService.findById(id);
        if (candidato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(candidato);
    }

    @PostMapping
    public Candidato createCandidato(@RequestBody Candidato candidato) {
        return candidatoService.save(candidato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidato> updateCandidato(@PathVariable Long id, @RequestBody Candidato candidato) {
        if (candidatoService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        candidato.setId(id);
        return ResponseEntity.ok(candidatoService.save(candidato));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidato(@PathVariable Long id) {
        candidatoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
