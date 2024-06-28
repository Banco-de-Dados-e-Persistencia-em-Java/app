package br.edu.infnet.AppElberth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.AppElberth.model.service.AlimenticioService;
import br.edu.infnet.AppElberth.model.service.ApiService;
import br.edu.infnet.AppElberth.model.service.EletronicoService;
import br.edu.infnet.AppElberth.model.service.EnderecoService;
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
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private ApiService apiService;
	
	@GetMapping(value = "/")
	public String telaHome(Model model){
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeAlimenticio", alimenticioService.obterQtde());
		model.addAttribute("qtdeEletronico", eletronicoService.obterQtde());
		model.addAttribute("qtdeEndereco", enderecoService.obterQtde());
		
		model.addAttribute("estados", apiService.obterEstados());
		
		
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
	
	@GetMapping(value = "/endereco/listagem")
	public String listaEnderecos(Model model){
		
		model.addAttribute("titulo", "Listagem de Endereços");
		model.addAttribute("listagem", enderecoService.obterLista());
		
		return telaHome(model);
	}

	@GetMapping(value = "/estado/listagem")
	public String listaEstados(Model model){
		
		model.addAttribute("titulo", "Listagem de Estados");
		model.addAttribute("listagem", apiService.obterEstados());
		
		return telaHome(model);
	}

	@GetMapping(value = "/municipio/listagem")
	public String listaMunicipios(Model model, @RequestParam Integer uf){
		
		model.addAttribute("titulo", "Listagem de Municipios");
		model.addAttribute("listagem", apiService.obterMunicipios(uf));
		
		return telaHome(model);
	}
}