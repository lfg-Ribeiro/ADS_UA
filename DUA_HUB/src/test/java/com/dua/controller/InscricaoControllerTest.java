package com.dua.controller;

import static org.junit.jupiter.api.Assertions.assertEquals; // Importa assertEquals para verificar asserções
import static org.mockito.Mockito.when; // Importa when para simular comportamento de métodos

import java.time.LocalDateTime; // Importa LocalDateTime para manipular data e hora
import java.util.ArrayList; // Importa ArrayList para manipulação de listas
import java.util.List; // Importa List para listas

import org.junit.jupiter.api.Test; // Importa Test para definir um método de teste
import org.springframework.beans.factory.annotation.Autowired; // Importa Autowired para injetar dependências
import org.springframework.boot.test.context.SpringBootTest; // Importa SpringBootTest para rodar o teste com contexto do Spring
import org.springframework.boot.test.mock.mockito.MockBean; // Importa MockBean para simular repositório
import org.springframework.http.HttpStatus; // Importa HttpStatus para verificar status HTTP
import org.springframework.http.ResponseEntity; // Importa ResponseEntity para simular a resposta HTTP

import com.dua.entity.Inscricao; // Importa a entidade Inscricao
import com.dua.entity.Participante; // Importa a entidade Participante
import com.dua.entity.Prova; // Importa a entidade Prova
import com.dua.repository.InscricaoRepository; // Importa o repositório de Inscricao

@SpringBootTest // Indica que este é um teste de contexto do Spring Boot
public class InscricaoControllerTest {

    @Autowired
    InscricaoController inscricaoController; // Injeta o controller de Inscricao
    
    @MockBean
    InscricaoRepository inscricaoRepository; // Simula o repositório de Inscricao

    @Test
    void cenario01() {
        // Criando objetos fictícios de Participante e Prova
        Participante participante = new Participante(); // Cria objeto Participante fictício
        participante.setId(1L); // Define o ID do participante
        participante.setNome("João Pedro"); // Define o nome do participante

        Prova prova = new Prova(); // Cria objeto Prova fictício
        prova.setId(1L); // Define o ID da prova
        prova.setNome("Prova de Matemática"); // Define o nome da prova

        // Criando a Inscrição
        List<Inscricao> list = new ArrayList<>(); // Cria uma lista vazia de Inscricoes
        Inscricao inscricao = new Inscricao(); // Cria uma inscrição fictícia
        inscricao.setId(1L); // Define o ID da inscrição
        inscricao.setParticipante(participante); // Associa a inscrição ao participante fictício
        inscricao.setProva(prova); // Associa a inscrição à prova fictícia
        inscricao.setDataInscricao(LocalDateTime.now()); // Define a data e hora atuais como data de inscrição
        inscricao.setStatus("CONFIRMADA"); // Define o status da inscrição como CONFIRMADA

        list.add(inscricao); // Adiciona a inscrição à lista
        when(inscricaoRepository.findAll()).thenReturn(list); // Simula o retorno do repositório com a lista criada

        ResponseEntity<List<Inscricao>> retorno = this.inscricaoController.getAllInscricoes(); // Chama o método para obter todas as inscrições
        assertEquals(HttpStatus.OK, retorno.getStatusCode()); // Verifica se o status da resposta é OK (200)
        assertEquals(1, retorno.getBody().size()); // Verifica se há exatamente uma inscrição na resposta
        assertEquals("João Pedro", retorno.getBody().get(0).getParticipante().getNome()); // Verifica o nome do participante da inscrição
        assertEquals("Prova de Matemática", retorno.getBody().get(0).getProva().getNome()); // Verifica o nome da prova associada à inscrição
    }
}
