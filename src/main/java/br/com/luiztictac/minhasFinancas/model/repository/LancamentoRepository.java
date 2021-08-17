package br.com.luiztictac.minhasFinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiztictac.minhasFinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	
}
