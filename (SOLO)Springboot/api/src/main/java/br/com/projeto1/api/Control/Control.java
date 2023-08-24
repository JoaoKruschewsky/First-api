package br.com.projeto1.api.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import br.com.projeto1.api.Models.Loja;
import br.com.projeto1.api.Repository.Repositorio;
import br.com.projeto1.api.Service.Servico;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
public class Control {

    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    // Cadastrar
    @PostMapping("/cadastrar")
    public Loja cadastro(@RequestBody Loja obj) {
        return acao.save(obj);
    }

    // Mostrar todos
    @GetMapping("Listar")
    public List<Loja> listartodos() {
        return acao.findAll();
    }

    // Selecionar pelo id
    @GetMapping("selecionar{id}")
    public Loja selecionarpelocodigo(@PathVariable int id) {
        return acao.findById(id);
    }

    // Selecionar pelo name
    @GetMapping("selecionar/{name}")
    public ResponseEntity<?> selectbyname(@PathVariable String name) {
        return servico.selectbyname(name);
    }
    // Selecionar pelo name e update por ele

    @Transactional
    @PutMapping("selecionar/{name}/{novaquantidade}")
    public ResponseEntity<?> updatebyname(@PathVariable int novaquantidade, @PathVariable String name) {
        return servico.uptadebyname(novaquantidade, name);

    }

    // Deletarbyname

    @Transactional
    @DeleteMapping("deletar/{name}")
    public ResponseEntity<?> deletebyname(@PathVariable String name) {
        return servico.delete(name);
    }

    // Deletarbycodigo
    @DeleteMapping("deletar{id}")
    public void delete(@PathVariable int id) {
        Loja obj = selecionarpelocodigo(id);

        acao.delete(obj);
    }

    @GetMapping("/")
    public String algo() {
        return "Olá negodi";
    }
}
