package TorreDeControl;
import java.util.ArrayList;

import Aeronaves.Aeronave;

public class TorreDeControl {
    
    private ArrayList<Aeronave> colaDeAterrizajes = new ArrayList<Aeronave>();
    private ArrayList<Aeronave> colaDeDespegues = new ArrayList<Aeronave>();
    private boolean pistaLibre;

    public TorreDeControl(ArrayList<Aeronave> colaDeAterrizajes, ArrayList<Aeronave> colaDeDespegues, boolean pistaLibre) {
        this.colaDeAterrizajes = colaDeAterrizajes;
        this.colaDeAterrizajes.sort((a1, a2) -> a1.getPrioridad() - a2.getPrioridad());
        this.colaDeDespegues = colaDeDespegues;
        this.colaDeDespegues.sort((a1, a2) -> a1.getPrioridad() - a2.getPrioridad());
        this.pistaLibre = pistaLibre;
    }
    public TorreDeControl() {
        this.colaDeAterrizajes = new ArrayList<Aeronave>();
        this.colaDeDespegues = new ArrayList<Aeronave>();
        this.pistaLibre = true;
    }

    public void registrarAeronaveParaAterrizaje(Aeronave aeronave){
        colaDeAterrizajes.add(aeronave);
        colaDeAterrizajes.sort((a1, a2) -> a1.getPrioridad() - a2.getPrioridad());
    }
    public void registrarAeronaveParaDespegue(Aeronave aeronave){
        colaDeDespegues.add(aeronave);
        colaDeDespegues.sort((a1, a2) -> a1.getPrioridad() - a2.getPrioridad());
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
    
    public void liberarPista(){
        pistaLibre = true;
    }
    public void ocuparPista(){
        pistaLibre = false;
    }
    public void eventoActual(ArrayList<Aeronave> a){
        ocuparPista();
        Aeronave aterrizandoODespegando = a.remove(0);
        aterrizandoODespegando.setOperacionExitosa(true);
        liberarPista();
    }

    public String toString(){
        return  "colaDeAterrizajes: "+colaDeAterrizajes+ 
                "\ncolaDeDespegues: "+colaDeDespegues;
    }


}
