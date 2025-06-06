package Aeronaves;
public class Carga extends Aeronave {
    private static final int PRIORIDAD_CARGA = 4;
    private static final int TIEMPO_DE_USO_DE_PISTA_CARGA = 4000;

    public Carga(String id) {
        super(id);
        this.setTipo("Carga     ");
        this.setPrioridad(PRIORIDAD_CARGA);
    }

    public int getTiempoDeUsoDePista() { return Carga.TIEMPO_DE_USO_DE_PISTA_CARGA; }
}
