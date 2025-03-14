package mundo.pokemon.model;

import java.util.*;

public class Entrenador {
    private String nombre;
    private int batallasGanadas;
    private Map<Elemento, Pokemon> pokemons;
    
    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.batallasGanadas = 0;
        this.pokemons = new HashMap<>();
    }
    
    public void competir(Entrenador otro) {
        Pokemon miMasFuerte = obtenerMasFuerte();
        Pokemon suMasFuerte = otro.obtenerMasFuerte();
        
        if (miMasFuerte == null || suMasFuerte == null) return;
        
        Pokemon ganador = miMasFuerte.luchar(suMasFuerte);
        
        if (ganador.equals(miMasFuerte)) {
            batallasGanadas++;
            suMasFuerte.nivel = Math.max(1, suMasFuerte.nivel - 1);
            suMasFuerte.fuerza = Math.max(0, suMasFuerte.fuerza - 5);
            otro.eliminarPokemon(suMasFuerte);
            addPokemon(suMasFuerte);
        } else {
            otro.batallasGanadas++;
            miMasFuerte.nivel = Math.max(1, miMasFuerte.nivel - 1);
            miMasFuerte.fuerza = Math.max(0, miMasFuerte.fuerza - 5);
            eliminarPokemon(miMasFuerte);
            otro.addPokemon(miMasFuerte);
        }
    }
    
    public boolean addPokemon(Pokemon aniadido) {
        if (pokemons.containsKey(aniadido.getElemento())) {
            return false;
        }
        pokemons.put(aniadido.getElemento(), aniadido);
        return true;
    }
    
    public boolean eliminarPokemon(Pokemon eliminado) {
        return pokemons.remove(eliminado.getElemento(), eliminado);
    }
    
    public boolean eliminarPokemon(String nombre, Elemento elemento) {
        Pokemon p = pokemons.get(elemento);
        if (p != null && p.getNombre().equals(nombre)) {
            pokemons.remove(elemento);
            return true;
        }
        return false;
    }
    
    public void vaciar() {
        pokemons.clear();
    }
    
    public Pokemon obtenerMasFuerte() {
        return pokemons.values().stream().max(Comparator.naturalOrder()).orElse(null);
    }
    
    public boolean donar(Entrenador entrenador) {
        for (Pokemon p : pokemons.values()) {
            if (entrenador.pokemons.containsKey(p.getElemento())) {
                return false;
            }
        }
        entrenador.pokemons.putAll(this.pokemons);
        this.vaciar();
        return true;
    }
    
    public String mostrarPokemon() {
        StringBuilder sb = new StringBuilder();
        pokemons.values().stream()
                .sorted(Comparator.comparing(Pokemon::getElemento))
                .forEach(p -> sb.append(p.getNombre()).append(" (" + p.getElemento() + ")\n"));
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entrenador other = (Entrenador) obj;
        return Objects.equals(nombre, other.nombre);
    }
    
    @Override
    public String toString() {
        return "Entrenador [nombre=" + nombre + ", batallasGanadas=" + batallasGanadas + "]";
    }
}
