package br.edu.infnet.AppElberth;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.AppElberth.model.domain.Alimenticio;
import br.edu.infnet.AppElberth.model.domain.Eletronico;
import br.edu.infnet.AppElberth.model.domain.Produto;
import br.edu.infnet.AppElberth.model.domain.Vendedor;
import br.edu.infnet.AppElberth.model.service.ProdutoService;

@Order(4)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/produtos.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;

		System.err.println("#produtos");
		while(linha != null) {
			
			campos = linha.split(";");
			
			switch (campos[0].toUpperCase()) {
			case "A":
				Alimenticio alimenticio = new Alimenticio();
				alimenticio.setDescricao(campos[1]);
				alimenticio.setPreco(Float.valueOf(campos[2]));
				alimenticio.setCodigo(Integer.valueOf(campos[3]));
				alimenticio.setEstoque(Boolean.valueOf(campos[4]));
				alimenticio.setOrganico(Boolean.valueOf(campos[5]));
				alimenticio.setCarateristica(campos[6]);
				
				alimenticio.setVendedor(new Vendedor(Integer.valueOf(campos[7])));
				
				produtoService.incluir(alimenticio);
				break;
				
			case "E":
				Eletronico eletronico = new Eletronico();
				eletronico.setDescricao(campos[1]);
				eletronico.setPreco(Float.valueOf(campos[2]));
				eletronico.setCodigo(Integer.valueOf(campos[3]));
				eletronico.setEstoque(Boolean.valueOf(campos[4]));
				eletronico.setMarca(campos[5]);
				eletronico.setGarantiaMeses(Integer.valueOf(campos[6]));
				
				eletronico.setVendedor(new Vendedor(Integer.valueOf(campos[7])));
				
				produtoService.incluir(eletronico);
				break;
				
			default:
				System.err.println("Tipo inválido!!!");
			}
			
			linha = leitura.readLine();
		}
		
		System.out.println("Iniciando o processamento!");
		for(Produto produto : produtoService.obterLista()) {
			System.out.println(produto);			
		}
		System.out.println("Processamento realizado com sucesso!");

		leitura.close();
	}
}