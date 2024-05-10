package fp.netflix;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CatalogoNetflix {
	// Atributo
	private SortedSet<ProduccionNetflix> producciones;

	// Constructor
	public CatalogoNetflix(Stream<ProduccionNetflix> producciones) {
        this.producciones = producciones.collect(Collectors.toCollection(TreeSet::new));
    }
	
	// Métodos
	public SortedSet<ProduccionNetflix> getProducciones() {
		return producciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(producciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatalogoNetflix other = (CatalogoNetflix) obj;
		return Objects.equals(producciones, other.producciones);
	}

	@Override
	public String toString() {
		return "CatalogoNetflix [producciones=" + producciones + "]";
	}
}