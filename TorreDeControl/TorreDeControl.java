package TorreDeControl;
import java.util.ArrayList;
import Aeronaves.Aeronave;
import java.util.Random;

public class TorreDeControl {
    
    private ArrayList<Aeronave> colaDeAterrizajes = new ArrayList<Aeronave>();
    private ArrayList<Aeronave> colaDeDespegues = new ArrayList<Aeronave>();
    private boolean pistaLibre;
    private static final int TIEMPO_DE_INICIO_DE_OPERACION = 2000;
    private static final int TIEMPO_DE_FIN_DE_OPERACIOn = 1500;
    private static final int TIEMPO_DE_LIBERACION_DE_PISTA = 1000;
    private static final int TIEMPO_DE_RETRASO = 1000;
    private static final int TIEMPO_ACCIDENTE =4000;
    private static final double PROBABILIDAD_DE_ATRASO_AVION =0.25;
    private static final double PROBABILIDAD_DE_ATRASO_PISTA=0.1;
    private static final double PROBABILIDAD_DE_ACCIDENTE=0.05;

    public TorreDeControl(ArrayList<Aeronave> colaDeAterrizajes, ArrayList<Aeronave> colaDeDespegues, boolean pistaLibre) {
        this.colaDeAterrizajes = colaDeAterrizajes;
        ordenarCola(colaDeAterrizajes);
        this.colaDeDespegues = colaDeDespegues;
        ordenarCola(colaDeDespegues);
        this.pistaLibre = pistaLibre;
    }
    public TorreDeControl() {
        this.colaDeAterrizajes = new ArrayList<Aeronave>();
        this.colaDeDespegues = new ArrayList<Aeronave>();
        this.pistaLibre = true;
    }

    public void registrarAeronaveParaAterrizaje(Aeronave aeronave){
        colaDeAterrizajes.add(aeronave);
        ordenarCola(colaDeAterrizajes);
    }
    public void registrarAeronaveParaDespegue(Aeronave aeronave){
        colaDeDespegues.add(aeronave);
        ordenarCola(colaDeDespegues);
    }

    public void procesarSiguienteEvento() {
        if (pistaLibre) {
            if (!colaDeAterrizajes.isEmpty()) {
                eventoActual(colaDeAterrizajes);
                
            } else if (!colaDeDespegues.isEmpty()) {
                eventoActual(colaDeDespegues);
                }
            
            liberarPista();;
        }
    }

    public void ordenarCola(ArrayList<Aeronave> cola){
        cola.sort((a1, a2) -> a1.getPrioridad() - a2.getPrioridad());
    }     
    public void liberarPista(){
        pistaLibre = true;
    }
    public void ocuparPista(){
        pistaLibre = false;
    }
    public void eventoActual(ArrayList<Aeronave> a) {
        tiempoDeEsperaParaSiguientePaso(TIEMPO_DE_INICIO_DE_OPERACION);
        ocuparPista();
        Aeronave aeronaveActual = a.get(0);
        System.out.println(aeronaveActual.getId() + " esta ocupando la pista");

        if (ocurrioAccidente(aeronaveActual, a)) return;

        if (ocurrioAtrasoAvion()) {
            System.out.println("el avion se ha atrasado");
            tiempoDeEsperaParaSiguientePaso(TIEMPO_DE_RETRASO);
        }

        realizarOperacion(aeronaveActual);

        if (ocurrioAtrasoPista()) {
            System.out.println("la pista esta tardando en liberarse");
            tiempoDeEsperaParaSiguientePaso(TIEMPO_DE_RETRASO);
        }

        finalizarOperacion(a, aeronaveActual);
    }

    private boolean ocurrioAccidente(Aeronave aeronaveActual, ArrayList<Aeronave> a) {
        if (new Random().nextDouble() < PROBABILIDAD_DE_ACCIDENTE) {
            System.out.println("el avion ha sufrido un accidente");
            tiempoDeEsperaParaSiguientePaso(TIEMPO_ACCIDENTE);
            aeronaveActual.setOperacionExitosa(false);
            a.remove(0);
            liberarPista();
            System.out.println("Pista liberada");
            return true;
        }
        return false;
    }

    private boolean ocurrioAtrasoAvion() {
        return new Random().nextDouble() < PROBABILIDAD_DE_ATRASO_AVION;
    }

    private boolean ocurrioAtrasoPista() {
        return new Random().nextDouble() < PROBABILIDAD_DE_ATRASO_PISTA;
    }

    private void realizarOperacion(Aeronave aeronaveActual) {
        tiempoDeEsperaParaSiguientePaso(aeronaveActual.getTiempoDeUsoDePista());
        aeronaveActual.setOperacionExitosa(true);
        tiempoDeEsperaParaSiguientePaso(TIEMPO_DE_FIN_DE_OPERACIOn);
        System.out.println(aeronaveActual.getId() + " ha terminado su operacion");
    }

    private void finalizarOperacion(ArrayList<Aeronave> a, Aeronave aeronaveActual) {
        a.remove(0);
        tiempoDeEsperaParaSiguientePaso(TIEMPO_DE_LIBERACION_DE_PISTA);
        liberarPista();
        System.out.println("Pista liberada");
    }

    public void tiempoDeEsperaParaSiguientePaso(int tiempo){
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return  "colaDeAterrizajes: "+colaDeAterrizajes+ 
                "\ncolaDeDespegues: "+colaDeDespegues;
    }


}
