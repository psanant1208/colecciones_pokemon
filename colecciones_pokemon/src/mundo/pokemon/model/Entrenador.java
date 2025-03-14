package mundo.pokemon.model;

import java.util.Objects;

public class Entrenador {
	private String nombre;
	private int batallasGanadas;
	
	public Entrenador(String nombre) {
		super();
		this.nombre = nombre;
		this.batallasGanadas = 0;
		
	}
	
	public void competir(Entrenador otro) {
		
	}
	
	public boolean addPokemon(Pokemon aniadido) {
		
	}
	
	public boolean eliminarPokemon(Pokemon eliminado) {
		
	}
	
	public boolean eliminarPokemon(String nombre, Elemento elemento) {
		
	}
	
	public void vaciar() {
		
	}
	
	public Pokemon obtenerMasFuerte() {
		
	}
	
	public boolean donar(Entrenador entrenador) {
		
	}
	
	public String mostrarPokemon() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrenador other = (Entrenador) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Entrenador [nombre=" + nombre + ", batallasGanadas=" + batallasGanadas + "]";
	}
}
