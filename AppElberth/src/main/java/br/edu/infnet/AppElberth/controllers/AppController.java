package br.edu.infnet.AppElberth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.AppElberth.model.service.AlimenticioService;
import br.edu.infnet.AppElberth.model.service.EletronicoService;
import br.edu.infnet.AppElberth.model.service.ProdutoService;
import br.edu.infnet.AppElberth.model.service.VendedorService;

@Controller
public class AppController {

	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private AlimenticioService alimenticioService;
	@Autowired
	private EletronicoService eletronicoService;
	
	@GetMapping(value = "/")
	public String telaHome(Model model){
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeAlimenticio", alimenticioService.obterQtde());
		model.addAttribute("qtdeEletronico", eletronicoService.obterQtde());
		
		return "home";
	}

	@GetMapping(value = "/vendedor/listagem")
	public String listaVendedores(Model model){
		
		model.addAttribute("titulo", "Listagem de Vendedores");
		model.addAttribute("listagem", vendedorService.obterLista());
		
		return telaHome(model);
	}

	@GetMapping(value = "/produto/listagem")
	public String listaProdutos(Model model){
		
		model.addAttribute("titulo", "Listagem de Produtos");
		model.addAttribute("listagem", produtoService.obterLista());
		
		return telaHome(model);
	}
	@GetMapping(value = "/alimenticio/listagem")
	public String listaAlimenticios(Model model){
		
		model.addAttribute("titulo", "Listagem de Produtos Alimentícios");
		model.addAttribute("listagem", alimenticioService.obterLista());
		
		return telaHome(model);
	}
	@GetMapping(value = "/eletronico/listagem")
	public String listaEletronicos(Model model){
		
		model.addAttribute("titulo", "Listagem de Produtos Eletrônicos");
		model.addAttribute("listagem", eletronicoService.obterLista());
		
		return telaHome(model);
	}
}