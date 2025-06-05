package Aeronaves;
public class Pasajeros extends Aeronave {
    private static final int PRIORIDAD_PASAJEROS = 3;

    public Pasajeros(String id) {
        super(id);
        this.setTipo("Pasajeros");
        this.setPrioridad(PRIORIDAD_PASAJEROS);
    }
}
