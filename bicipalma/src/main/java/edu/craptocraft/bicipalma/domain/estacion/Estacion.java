package edu.craptocraft.bicipalma.domain.estacion;

import edu.craptocraft.bicipalma.domain.bicicleta.Movil;
import edu.craptocraft.bicipalma.domain.tarjetausuario.Autenticacion;

import java.util.Arrays;
import java.util.Optional;

public class Estacion {

    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    public Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numAnclajes);
    }

    @Override
    public String toString() {

        return ("id: " + this.id + "\ndireccion: " + this.direccion + "\nnumeroAnclajes: " + numAnclajes());
    }

    private Anclaje[] anclajes() {

        return this.anclajes.anclajes();
    }

    private int numAnclajes() {
        return this.anclajes.numAnclajes();
    }

    public void consultarEstacion() {
        System.out.println(this);
    }

    public long anclajesLibres() {

        return Arrays.stream(anclajes()).filter(o -> !o.isOcupado()).count();

    }

    public void anclarBicicleta(Movil bici) {

        Optional<Anclaje> anclajeLibre = Arrays.stream(anclajes()).filter(o -> !o.isOcupado()).findAny();

        if (anclajeLibre.isPresent()) {

            anclajeLibre.get().anclarBici(bici);
        } else {
            System.out.println("No hay anclajes disponibles");
        }

    }

    public boolean leerTarjetaUsuario(Autenticacion tarjetaUsuario) {

        return tarjetaUsuario.isActivada();

    }

    public void retirarBicicleta(Autenticacion tarjetaUsuario) {
        if (leerTarjetaUsuario(tarjetaUsuario) == true) {
            Optional<Anclaje> posibleAnclaje = Arrays.stream(anclajes()).filter(Anclaje::isOcupado).findAny();

            if (posibleAnclaje.isPresent()) {
                mostrarBicicleta(posibleAnclaje.get().getBici());
                posibleAnclaje.get().liberarBici();

            } else {
                System.out.println("No hay bicicletas en la estación");
            }
        } else {
            System.out.println("Tarjeta de usuario inactiva");
        }
    }

    private void mostrarBicicleta(Movil bici) {
        System.out.println("Bicicleta retirada: " + bici.getId());
    }

    public void consultarAnclajes() {

        Arrays.stream(anclajes()).map(a -> Optional.ofNullable((a.getBici())))
                .forEach(
                        bici -> System.out.print(
                                "Anclaje " + (bici.isPresent() ? "ocupado: nº de bicicleta " + bici.get() : "libre")
                                        + "\n"));
    }

}
