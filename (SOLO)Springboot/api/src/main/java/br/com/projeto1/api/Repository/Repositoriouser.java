package br.com.projeto1.api.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto1.api.Models.Usuario;

public interface Repositoriouser extends CrudRepository<Usuario, Long> {
    
}
