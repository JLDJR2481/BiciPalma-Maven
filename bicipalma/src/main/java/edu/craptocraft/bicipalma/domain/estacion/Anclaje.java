package edu.craptocraft.bicipalma.domain.estacion;

import edu.craptocraft.bicipalma.domain.bicicleta.*;

public class Anclaje {

    private boolean ocupado;
    private Movil bici;

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
        this.ocupado = true;

    }

    void liberarBici() {
        this.ocupado = false;
    }

}
