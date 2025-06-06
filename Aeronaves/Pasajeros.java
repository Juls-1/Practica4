package Aeronaves;
public class Pasajeros extends Aeronave {
    private static final int PRIORIDAD_PASAJEROS = 3;
    private static final int TIEMPO_DE_USO_DE_PISTA_PASAJEROS = 3500;

    public Pasajeros(String id) {
        super(id);
        this.setTipo("Pasajeros ");
        this.setPrioridad(PRIORIDAD_PASAJEROS);
    }

    public int getTiempoDeUsoDePista() { return Pasajeros.TIEMPO_DE_USO_DE_PISTA_PASAJEROS; }
}
