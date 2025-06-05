package Aeronaves;
public class Emergencia extends Aeronave{
    private static final int PRIORIDAD_EMERGENCIA = 1;

    public Emergencia(String id) {
        super(id);
        this.setTipo("Emergencia");
        this.setPrioridad(PRIORIDAD_EMERGENCIA);
    }
}