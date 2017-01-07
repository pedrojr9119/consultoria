package br.com.apr.sistema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IniciarController {

	private static final String PAGINA_NOME = "index";
	private static final String PAGINA_QUEM_SOMOS_CADASTRO = "quemSomosCadastro";
	
	@GetMapping(value = "/index")
	public ModelAndView iniciar() {
		ModelAndView mv = new ModelAndView(PAGINA_NOME);
		mv.addObject("quemSomos", "quemSomos");
		return mv;
	}
	
	@GetMapping(value = "/quemSomosCadastro")
	public ModelAndView quemSomosCadastro() {
		ModelAndView mv = new ModelAndView(PAGINA_QUEM_SOMOS_CADASTRO);
		return mv;
	}
}