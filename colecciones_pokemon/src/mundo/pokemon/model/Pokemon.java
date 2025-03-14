package mundo.pokemon.model;

import java.util.Objects;

public class Pokemon {
	protected String nombre;
	protected Elemento elemento;
	protected int fuerza;
	protected int nivel;
	
	public Pokemon(String nombre, Elemento elemento) {
		super();
		this.nombre = nombre;
		this.elemento = elemento;
		this.fuerza = obtenerFuerzaInicial();
		this.nivel = 3;
	}
	
	public Pokemon luchar(Pokemon rival) {
		Pokemon ganador;
		
		if(rival.fuerza > this.fuerza) {
			ganador = rival;
		}
		else{
			ganador = this;
		}
		
		return ganador;
	}
	
	public void evolucionarTrasBatalla() {
		
	}
	
	public int obtenerFuerzaInicial() {
		int fuerza = (int) (Math.random() * (255 - 5 + 1)) + 5;
		return fuerza;
	}

	public String getNombre() {
		return nombre;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public int compareTo(Pokemon otro) {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(elemento, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return elemento == other.elemento && Objects.equals(nombre, other.nombre);
	}
}
