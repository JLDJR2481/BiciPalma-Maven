package edu.craptocraft.bicipalma.domain.bicicleta;

public class Bicicleta implements Movil {

    private final Integer id;

    public Bicicleta(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
