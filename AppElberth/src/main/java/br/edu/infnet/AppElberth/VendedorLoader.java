package br.edu.infnet.AppElberth;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.AppElberth.model.domain.Vendedor;
import br.edu.infnet.AppElberth.model.service.VendedorService;

@Component
public class VendedorLoader implements ApplicationRunner {
	
	@Autowired
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("arquivos/vendedores.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
	
		String[] campos = null;

		System.err.println("#vendedor");
		while(linha != null) {
			
			campos = linha.split(";");
			
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(campos[0]);
			vendedor.setCpf(campos[1]);
			vendedor.setEmail(campos[2]);
		
			vendedorService.incluir(vendedor);

			linha = leitura.readLine();
		}
		
		System.out.println("Iniciando o processamento!");
		for(Vendedor vendedor : vendedorService.obterLista()) {
			System.out.println(vendedor);			
		}
		System.out.println("Processamento realizado com sucesso!");

		leitura.close();
	}
}