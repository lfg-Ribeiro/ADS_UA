package urna.urna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import urna.urna.entity.Apuracao;
import urna.urna.service.ApuracaoService;

@RestController
@RequestMapping("/apuracao")
public class ApuracaoController {

    @Autowired
    private ApuracaoService apuracaoService;

    @GetMapping
    public Apuracao getApuracao() {
        return apuracaoService.calcularApuracao();
    }
}
