package br.edu.infnet.AppElberth;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.AppElberth.model.domain.Alimenticio;
import br.edu.infnet.AppElberth.model.service.AlimenticioService;

@Component
public class AlimenticioLoader implements ApplicationRunner {
	
	@Autowired
	private AlimenticioService alimenticioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/alimenticios.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;

		System.err.println("#alimenticio");
		while(linha != null) {
			
			campos = linha.split(";");

			Alimenticio alimenticio = new Alimenticio();
			alimenticio.setDescricao(campos[0]);
			alimenticio.setPreco(Float.valueOf(campos[1]));
			alimenticio.setCodigo(Integer.valueOf(campos[2]));
			alimenticio.setEstoque(Boolean.valueOf(campos[3]));
			alimenticio.setOrganico(Boolean.valueOf(campos[4]));
			alimenticio.setCarateristica(campos[5]);
			
			alimenticioService.incluir(alimenticio);
			
			linha = leitura.readLine();
		}

		System.out.println("Iniciando o processamento!");
		for(Alimenticio alimenticio : alimenticioService.obterLista()) {
			System.out.println(alimenticio);			
		}
		System.out.println("Processamento realizado com sucesso!");
		
		leitura.close();
	}
}