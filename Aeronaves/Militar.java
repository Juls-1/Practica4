package Aeronaves;
public class Militar extends Aeronave{
    private static final int PRIORIDAD_MILITAR = 2;
    private static final int TIEMPO_DE_USO_DE_PISTA_MILITAR = 3000;

    public Militar(String id) {
        super(id);
        this.setTipo("Militar   ");
        this.setPrioridad(PRIORIDAD_MILITAR);
    }

    public int getTiempoDeUsoDePista() { return Militar.TIEMPO_DE_USO_DE_PISTA_MILITAR; }
}