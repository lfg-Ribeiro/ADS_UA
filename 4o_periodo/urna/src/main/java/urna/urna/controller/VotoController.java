package urna.urna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urna.urna.entity.Voto;
import urna.urna.service.VotoService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @GetMapping
    public List<Voto> getAllVotos() {
        return votoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voto> getVotoById(@PathVariable Long id) {
        Voto voto = votoService.findById(id);
        if (voto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(voto);
    }

    @PostMapping
    public ResponseEntity<String> createVoto(@RequestBody Voto voto) {
        // verifica se os candidatos existem no DB
        if (voto.getCandidatoPrefeito() == null || voto.getCandidatoVereador() == null) {
            return ResponseEntity.badRequest().body("Candidatos obrigatórios não fornecidos.");
        }

        // gera o hash do voto
        voto.setHash(generateHash());
        voto.setDataHora(LocalDateTime.now());

        Voto savedVoto = votoService.save(voto);
        return ResponseEntity.ok("Voto criado com sucesso. ID: " + savedVoto.getId());
    }

    private String generateHash() {
        // gera um hash unico
        return UUID.randomUUID().toString();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoto(@PathVariable Long id) {
        votoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
