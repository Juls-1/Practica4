package Aeronaves;
public class Carga extends Aeronave {
    private static final int PRIORIDAD_CARGA = 4;

    public Carga(String id) {
        super(id);
        this.setTipo("Carga     ");
        this.setPrioridad(PRIORIDAD_CARGA);
    }
}
