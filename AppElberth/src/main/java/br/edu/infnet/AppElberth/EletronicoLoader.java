package br.edu.infnet.AppElberth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.AppElberth.model.domain.Eletronico;

@Component
public class EletronicoLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Map<Integer, Eletronico> mapa = new HashMap<Integer, Eletronico>();
		Integer id = 0;

		FileReader file = new FileReader("arquivos/eletronicos.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;

		System.err.println("#eletronico");
		while(linha != null) {
			
			campos = linha.split(";");

			Eletronico eletronico = new Eletronico();
			eletronico.setId(++id);
			eletronico.setDescricao(campos[0]);
			eletronico.setPreco(Float.valueOf(campos[1]));
			eletronico.setCodigo(Integer.valueOf(campos[2]));
			eletronico.setEstoque(Boolean.valueOf(campos[3]));
			eletronico.setMarca(campos[4]);
			eletronico.setGarantiaMeses(Integer.valueOf(campos[5]));
			
			mapa.put(eletronico.getId(), eletronico);
			
			linha = leitura.readLine();
		}

		System.out.println("Iniciando o processamento!");
		for(Eletronico eletronico : mapa.values()) {
			System.out.println(eletronico);			
		}
		System.out.println("Processamento realizado com sucesso!");
		
		leitura.close();
	}
}