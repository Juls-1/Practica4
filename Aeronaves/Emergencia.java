package Aeronaves;
public class Emergencia extends Aeronave{
    private static final int PRIORIDAD_EMERGENCIA = 1;
    private static final int TIEMPO_DE_USO_DE_PISTA_EMERGENCIA = 2500;

    public Emergencia(String id) {
        super(id);
        this.setTipo("Emergencia");
        this.setPrioridad(PRIORIDAD_EMERGENCIA);
    }

    public int getTiempoDeUsoDePista() { return Emergencia.TIEMPO_DE_USO_DE_PISTA_EMERGENCIA; }
}