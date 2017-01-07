package br.com.apr.sistema.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.apr.sistema.entidade.Servico;
import br.com.apr.sistema.repositorio.IServicoRepositorio;


@Service
public class ServicoBO {
	
	@Autowired
	private IServicoRepositorio servicoRepositorio;
	
	public void salvar(Servico servico){
		try{
			this.servicoRepositorio.save(servico);
		}catch(DataIntegrityViolationException e){
			throw new IllegalArgumentException("Formato de data inválido!");
		}
	}

	public List<Servico> buscarTodos() {
		return this.servicoRepositorio.findAll();
	}

	public void excluir(Long codigo) {
		this.servicoRepositorio.delete(codigo);
	}


}
