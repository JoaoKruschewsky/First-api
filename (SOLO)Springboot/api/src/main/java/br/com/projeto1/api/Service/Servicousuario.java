package br.com.projeto1.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto1.api.Mensagem.Mensagem;
import br.com.projeto1.api.Models.Usuario;
import br.com.projeto1.api.Repository.Repositoriouser;

@Service
public class Servicousuario {
    
    @Autowired
    private Repositoriouser acao;
    @Autowired
    private Mensagem mensagem;

    public ResponseEntity<?> cadastrar(Usuario user){
        if (acao.countByUser(user) == null) {
            
            return new ResponseEntity<>(acao.save(user), HttpStatus.OK);
        } else {
            mensagem.setMensagem("Esse usuario já está cadastrado.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
    }
}