package br.com.apr.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.apr.sistema.entidade.QuemSomos;
import br.com.apr.sistema.servico.QuemSomosBO;

@RestController
public class IniciarController {

	private static final String PAGINA_NOME = "index";
	
	private static final String PAGINA_QUEM_SOMOS_CADASTRO = "quemSomosCadastro";
	
	@Autowired
	private QuemSomosBO quemSomosBO;
	
	@GetMapping(value = "/index")
	public ModelAndView iniciar() {
		ModelAndView mv = new ModelAndView(PAGINA_NOME);
		mv.addObject("quemSomos", quemSomosBO.buscar().getDescricao());
		return mv;
	}
	
	@GetMapping(value = "/quemSomosCadastro")
	public ModelAndView quemSomosCadastro() {
		ModelAndView mv = new ModelAndView(PAGINA_QUEM_SOMOS_CADASTRO);
		mv.addObject("quemSomos", quemSomosBO.buscar());
		return mv;
	}
	
	@PostMapping(value = "/quemSomos/salvar") 
	public ModelAndView	quemSomosSalvar(@Validated QuemSomos quemSomos, ModelAndView mv) {
		quemSomosBO.salvar(quemSomos);
		return iniciar();
	}
}