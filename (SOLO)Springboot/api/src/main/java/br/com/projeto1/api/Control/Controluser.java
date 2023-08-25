package br.com.projeto1.api.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto1.api.Models.Usuario;
import br.com.projeto1.api.Repository.Repositorio;
import br.com.projeto1.api.Repository.Repositoriouser;

@RestController
public class Controluser {
    @Autowired
    private Repositoriouser acao;


    @PostMapping("/cadastrarusuario")
    public Usuario cadastrar(@RequestBody Usuario obj){
        return acao.save(obj);
        
    }
}
