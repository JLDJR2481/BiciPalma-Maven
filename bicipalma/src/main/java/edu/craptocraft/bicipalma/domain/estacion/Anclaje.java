package edu.craptocraft.bicipalma.domain.estacion;

import edu.craptocraft.bicipalma.domain.bicicleta.Movil;

public class Anclaje {

    private boolean ocupado = false;
    private Movil bici = null;

    Anclaje() {
    };

    boolean isOcupado() {
        return this.ocupado;
    }

    Movil getBici() {
        return this.bici;
    }

    void anclarBici(Movil bici) {
        this.bici = bici;
        ocupado = true;

    }

    void liberarBici() {
        this.bici = null;
        ocupado = false;

    }

    @Override
    public String toString() {

        return "Ocupado: " + Boolean.toString(isOcupado());

    }

}
