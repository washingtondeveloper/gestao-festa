package br.com.wdcode.festa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.wdcode.festa.model.Convidado;
import br.com.wdcode.festa.repository.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	private Convidados convidados;

	@GetMapping()
	public ModelAndView listar(Convidado convidado) {
		ModelAndView mv = new ModelAndView("listaConvidados");
		mv.addObject("convidados", convidados.findAll());
		return mv;
	}

	@PostMapping()
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		this.convidados.delete(getContato(id));
		return "redirect:/convidados";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute(getContato(id));
		model.addAttribute("convidados", this.convidados.findAll());
		return "listaConvidados";
	}

	private Convidado getContato(Long id) {
		return this.convidados.findOne(id);
	}

}
