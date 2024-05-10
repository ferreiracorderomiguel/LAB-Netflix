package fp.netflix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class FactoriaNetflix {
	public static CatalogoNetflix leeNetflix(String rutaFichero) {
		CatalogoNetflix res = null;
		List<ProduccionNetflix> producciones;
		
		try {
			producciones = Files.readAllLines(Paths.get(rutaFichero))
					.stream()
					.map(FactoriaNetflix::parse)
					.collect(Collectors.toList());
			res = new CatalogoNetflix(producciones.stream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static ProduccionNetflix parse(String s) {
		String[] trozos = s.split(",");
		Checkers.check("Cadena mal troceada.", trozos.length == 8);
 		
		String titulo = trozos[0].trim();
		Tipo tipo = Tipo.valueOf(trozos[1].trim());
		Integer anhoProduccion = Integer.parseInt(trozos[2].trim());
		Duration duracion = Duration.ofMinutes(Integer.parseInt(trozos[3].trim()));
		Set<String> generos = parsearGeneros(trozos[4].trim());
		Integer numTemporadas = Integer.parseInt(trozos[5].trim());
		Double scoreIMDB = Double.parseDouble(trozos[6].trim());
		Long popularidadIMDB = Long.parseLong(trozos[7].trim());
		
		return null;
	}

	private static Set<String> parsearGeneros(String trim) {
		Set<String> res = new HashSet<String>();
		trim = trim.replace("[", "").replace("]", "").trim();
		String[] trozos = trim.split(";");
		
		for (String s: trozos) {
			res.add(s.replace("'", "").trim());
		}
		return res;
	}
}
