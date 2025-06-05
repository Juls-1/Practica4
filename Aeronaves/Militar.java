package Aeronaves;
public class Militar extends Aeronave{
    private static final int PRIORIDAD_MILITAR = 2;

    public Militar(String id) {
        super(id);
        this.setTipo("Militar");
        this.setPrioridad(PRIORIDAD_MILITAR);
    }
}