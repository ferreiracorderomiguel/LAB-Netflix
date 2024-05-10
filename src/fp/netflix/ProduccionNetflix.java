package fp.netflix;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public class ProduccionNetflix implements Comparable<ProduccionNetflix> {
	// Atributos
	private String titulo;
	private Tipo tipo;
	private Integer anhoProduccion;
	private Duration duracion;
	private Set<String> generos;
	private Integer numTemporadas;
	private Double scoreIMDB;
	private Long popularidadIMDB;
	
	// Constructores
	public ProduccionNetflix(String titulo, Tipo tipo, Integer anhoProduccion, Duration duracion, Set<String> generos,
			Integer numTemporadas, Double scoreIMDB, Long popularidadIMDB) {
		Checkers.check("El año de producción debe ser posterior a 1900.", anhoProduccion > 1900);
		Checkers.check("El score de IMDB debe estar comprendido entre 0 y 10.", scoreIMDB >= 0 && scoreIMDB <= 10);
		Checkers.check("La popularidad en IMDB debe ser igual o superior a 0.", popularidadIMDB >= 0);
		Checkers.check("Si el tipo es MOVIE, el número de temporadas debe ser 0. Si el tipo es SHOW, el número de temporadas debe ser mayor o igual a 1.", comprobarNumTemp(tipo, numTemporadas));
		this.titulo = titulo;
		this.tipo = tipo;
		this.anhoProduccion = anhoProduccion;
		this.duracion = duracion;
		this.generos = generos;
		this.numTemporadas = numTemporadas;
		this.scoreIMDB = scoreIMDB;
		this.popularidadIMDB = popularidadIMDB;
	}
	
	private Boolean comprobarNumTemp(Tipo tipo2, Integer numTemporadas2) {
		Boolean res = false;
		
		if (tipo2 == Tipo.MOVIE) {
			if (numTemporadas2 == 0)
				res = true;
		} else if (tipo2 == Tipo.SHOW) {
			if (numTemporadas2 >= 1)
				res = true;
		}
		
		return res;
	}

	// Métodos
	public String getTitulo() {
		return titulo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Integer getAnhoProduccion() {
		return anhoProduccion;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public Set<String> getGeneros() {
		return generos;
	}

	public Integer getNumTemporadas() {
		return numTemporadas;
	}

	public Double getScoreIMDB() {
		return scoreIMDB;
	}

	public Long getPopularidadIMDB() {
		return popularidadIMDB;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anhoProduccion, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProduccionNetflix other = (ProduccionNetflix) obj;
		return Objects.equals(anhoProduccion, other.anhoProduccion) && Objects.equals(titulo, other.titulo);
	}
	
	public int compareTo(ProduccionNetflix p) {
		int r = this.titulo.compareTo(p.getTitulo());
		
		if (r == 0) {
			this.anhoProduccion.compareTo(p.getAnhoProduccion());
		}
		
		return r;
	}

	@Override
	public String toString() {
		return "ProduccionNetflix [titulo=" + titulo + ", tipo=" + tipo + ", anhoProduccion=" + anhoProduccion
				+ ", duracion=" + duracion + ", generos=" + generos + ", numTemporadas=" + numTemporadas
				+ ", scoreIMDB=" + scoreIMDB + ", popularidadIMDB=" + popularidadIMDB + "]";
	}
}