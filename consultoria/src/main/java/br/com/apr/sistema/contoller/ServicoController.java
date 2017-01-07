package br.com.apr.sistema.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.apr.sistema.entidade.Servico;
import br.com.apr.sistema.servico.ServicoBO;



@Controller
@RequestMapping("/servicos")
public class ServicoController {
	private static final String CADASTRO_VIEW = "servico";
	private static final String PESQUISA_VIEW = "servicoPesquisa";
	
	@Autowired
	private ServicoBO servicoBO;
	
	@RequestMapping
	public ModelAndView pesquisar(){
		ModelAndView mv = new ModelAndView(PESQUISA_VIEW);		
		List<Servico> todosServicos = servicoBO.buscarTodos();
		mv.addObject("servicos", todosServicos);
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Servico());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Servico servico, Errors erros, RedirectAttributes attributes, ModelAndView mv){
		mv.addObject(servico);
		mv.setViewName(CADASTRO_VIEW);
		if(erros.hasErrors()){
			return mv;
		}
		try{
			this.servicoBO.salvar(servico);		
			attributes.addFlashAttribute("mensagem", "Serviço salvo com sucesso!");
			return new ModelAndView("redirect:/servicos/novo");
		}catch(DataIntegrityViolationException e){
			erros.rejectValue("dataVencimento", null, e.getMessage());
			return mv;
		}
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Servico servico){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(servico);
		
		return mv;
	}
	
	@RequestMapping(value = "{codigo}", method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes){
		this.servicoBO.excluir(codigo);
		attributes.addFlashAttribute("mensagem", "Serviço excluído com sucesso!");
		return "redirect:/servicos";
	}

}
