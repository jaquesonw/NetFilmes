package br.com.filo.netfilmes;

import br.com.filo.netfilmes.model.DadosSerie;
import br.com.filo.netfilmes.service.ConsumoAPI;
import br.com.filo.netfilmes.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetfilmesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NetfilmesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	var consumoAPI = new ConsumoAPI();
	var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=f9e4f62e");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}
