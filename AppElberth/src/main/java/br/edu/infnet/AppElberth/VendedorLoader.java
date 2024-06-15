package br.edu.infnet.AppElberth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.AppElberth.model.domain.Alimenticio;
import br.edu.infnet.AppElberth.model.domain.Eletronico;
import br.edu.infnet.AppElberth.model.domain.Vendedor;
import br.edu.infnet.AppElberth.model.service.AlimenticioService;
import br.edu.infnet.AppElberth.model.service.EletronicoService;
import br.edu.infnet.AppElberth.model.service.VendedorService;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private AlimenticioService alimenticioService;
	@Autowired
	private EletronicoService eletronicoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("arquivos/vendedores.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
	
		String[] campos = null;
		
		Vendedor vendedor = null;

		System.err.println("#vendedor");
		while(linha != null) {
			
			campos = linha.split(";");
			
			switch (campos[0].toUpperCase()) {
			case "V":
				vendedor = new Vendedor();
				vendedor.setNome(campos[1]);
				vendedor.setCpf(campos[2]);
				vendedor.setEmail(campos[3]);
			
				vendedorService.incluir(vendedor);
				break;
				
			case "A":
				Alimenticio alimenticio = new Alimenticio();
				alimenticio.setDescricao(campos[1]);
				alimenticio.setPreco(Float.valueOf(campos[2]));
				alimenticio.setCodigo(Integer.valueOf(campos[3]));
				alimenticio.setEstoque(Boolean.valueOf(campos[4]));
				alimenticio.setOrganico(Boolean.valueOf(campos[5]));
				alimenticio.setCarateristica(campos[6]);
				
				alimenticio.setVendedor(vendedor);
				
				alimenticioService.incluir(alimenticio);
				
				vendedor.getProdutos().add(alimenticio);

				break;
				
			case "E":
				Eletronico eletronico = new Eletronico();
				eletronico.setDescricao(campos[1]);
				eletronico.setPreco(Float.valueOf(campos[2]));
				eletronico.setCodigo(Integer.valueOf(campos[3]));
				eletronico.setEstoque(Boolean.valueOf(campos[4]));
				eletronico.setMarca(campos[5]);
				eletronico.setGarantiaMeses(Integer.valueOf(campos[6]));
				
				eletronico.setVendedor(vendedor);
				
				eletronicoService.incluir(eletronico);

				vendedor.getProdutos().add(eletronico);
				
				break;

			default:
				System.err.println("Linha: " + Arrays.asList(campos));
				break;
			}
			

			linha = leitura.readLine();
		}
		
		System.out.println("Iniciando o processamento!");
		for(Vendedor oVendedor : vendedorService.obterLista()) {
			System.out.println(oVendedor);			
		}
		System.out.println("Processamento realizado com sucesso!");
		

		leitura.close();
	}
}