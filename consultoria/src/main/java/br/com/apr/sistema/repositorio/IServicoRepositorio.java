package br.com.apr.sistema.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apr.sistema.entidade.Servico;

public interface IServicoRepositorio extends JpaRepository<Servico, Long>{
	List<Servico> findByNomeContaining(String nome);
}
