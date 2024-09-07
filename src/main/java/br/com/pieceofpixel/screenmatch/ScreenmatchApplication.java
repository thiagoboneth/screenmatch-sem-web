package br.com.pieceofpixel.screenmatch;

import br.com.pieceofpixel.screenmatch.model.DadosSerie;
import br.com.pieceofpixel.screenmatch.service.ConsumeApi;
import br.com.pieceofpixel.screenmatch.service.ConverteDados;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	@Value("${API_KEY}")
	private String apiKey;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) {
		var consumeApi = new ConsumeApi();
		var json = consumeApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=" + apiKey);
		var converteDados = new ConverteDados();
		var serie = converteDados.obterDados(json, DadosSerie.class);
		System.out.println(serie);
	}
}
