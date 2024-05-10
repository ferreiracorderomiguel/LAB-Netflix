package fp.netflix;

import java.util.Objects;
import java.util.SortedSet;

public class CatalogoNetflix {
	// Atributo
	private SortedSet<ProduccionNetflix> producciones;

	// Constructor
	public CatalogoNetflix(SortedSet<ProduccionNetflix> producciones) {
		this.producciones = producciones;
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