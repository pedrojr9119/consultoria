package br.com.apr.sistema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IniciarController {

	private static final String PAGINA_NOME = "index";
	
	@GetMapping(value = "/index")
	public ModelAndView iniciar() {
		ModelAndView mv = new ModelAndView(PAGINA_NOME);
		mv.addObject("teste", "tes123123123te");
		mv.addObject("alan", "tes123123123tddddddddddddddddddddddddde");
		return mv;
	}
}
