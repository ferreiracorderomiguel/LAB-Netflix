package fp.netflix.test;

import fp.netflix.CatalogoNetflix;
import fp.netflix.FactoriaNetflix;

public class TestCatalogoNetflix {	
	public static void main(String[] args) {
		CatalogoNetflix catalogoNetflix = FactoriaNetflix.leeNetflix("data/titulos_netflix.csv");
		System.out.println("Número de registros leídos: " + catalogoNetflix.getProducciones().size());
	}
}
