package TorreDeControl;
import java.util.ArrayList;

import Aeronaves.Aeronave;

public class TorreDeControl {
    
    private ArrayList<Aeronave> colaDeAterrizajes = new ArrayList<Aeronave>();
    private ArrayList<Aeronave> colaDeDespegues = new ArrayList<Aeronave>();
    private boolean pistaLibre;

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
    public void eventoActual(ArrayList<Aeronave> a){
        ocuparPista();
        System.out.println(a.get(0).getId()+" esta ocupando la pista");
        Aeronave aterrizandoODespegando = a.remove(0);
        aterrizandoODespegando.setOperacionExitosa(true);
        liberarPista();
    }

    public String toString(){
        return  "colaDeAterrizajes: "+colaDeAterrizajes+ 
                "\ncolaDeDespegues: "+colaDeDespegues;
    }


}
