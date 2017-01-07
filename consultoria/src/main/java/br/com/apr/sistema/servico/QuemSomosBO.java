package br.com.apr.sistema.servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apr.sistema.entidade.QuemSomos;
import br.com.apr.sistema.repositorio.IQuemSomosRepositorio;

@Service
public class QuemSomosBO {

	@Autowired
	private IQuemSomosRepositorio entidadeRepo;
	
	public void salvar(QuemSomos entidade) {
		entidadeRepo.save(entidade);
	}
}
