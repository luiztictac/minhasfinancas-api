package br.com.luiztictac.minhasFinancas.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiztictac.minhasFinancas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	//Optional<Usuario> findByEmail(String email);// Query metodos
	
	boolean existsByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);
}
