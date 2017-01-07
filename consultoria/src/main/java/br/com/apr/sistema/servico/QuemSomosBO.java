package br.com.apr.sistema.servico;

import java.util.List;

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

	public QuemSomos buscar() {
		List<QuemSomos> quemSomos = entidadeRepo.findAll();
		
		if (quemSomos.isEmpty()) {
			return new QuemSomos();
		}

		return quemSomos.get(0);
	}
}
