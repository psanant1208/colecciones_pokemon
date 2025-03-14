package mundo.pokemon.model;

import java.util.Objects;

public class Pokemon implements Comparable<Pokemon> {
    protected String nombre;
    protected Elemento elemento;
    protected int fuerza;
    protected int nivel;
    
    public Pokemon(String nombre, Elemento elemento) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.fuerza = obtenerFuerzaInicial();
        this.nivel = 3;
    }
    
    public Pokemon luchar(Pokemon rival) {
        Pokemon ganador;
        
        if (rival.fuerza > this.fuerza) {
            ganador = rival;
            this.nivel = Math.max(1, this.nivel - 1);
            this.fuerza = Math.max(0, this.fuerza - 5);
        } else {
            ganador = this;
            this.nivel++;
            this.fuerza += 10;
        }
        return ganador;
    }
    
    public void evolucionarTrasBatalla() {
        this.nivel++;
        this.fuerza += 10;
    }
    
    public int obtenerFuerzaInicial() {
        return (int) (Math.random() * (255 - 5 + 1)) + 5;
    }

    public String getNombre() {
        return nombre;
    }

    public Elemento getElemento() {
        return elemento;
    }
    
    @Override
    public int compareTo(Pokemon otro) {
        return Integer.compare(this.fuerza, otro.fuerza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elemento, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pokemon other = (Pokemon) obj;
        return elemento == other.elemento && Objects.equals(nombre, other.nombre);
    }
}

