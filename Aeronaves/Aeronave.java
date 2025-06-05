package Aeronaves;

import TorreDeControl.TorreDeControl;
abstract public class Aeronave {
    private String id;
    private String tipo;
    private int prioridad;
    private boolean operacionExitosa;

    public Aeronave(String id) {
        this.id = id;
        this.tipo = "";
        this.prioridad = 10;
    }

    public String getId() {return id;}
    public String getTipo() {return tipo;}
    public int getPrioridad() {return prioridad;}
    public void setPrioridad(int prioridad) {this.prioridad = prioridad;}
    public void setId(String id) {this.id = id;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public boolean getOperacionExitosa() {return operacionExitosa;}
    public void setOperacionExitosa(boolean operacionExitosa) {this.operacionExitosa = operacionExitosa;}

    public void solicitarDespegue(TorreDeControl torreDeControl) {torreDeControl.registrarAeronaveParaDespegue(this);};
    public void solicitarAterrizaje(TorreDeControl torreDeControl) {torreDeControl.registrarAeronaveParaAterrizaje(this);};

    public String toString(){
        return  "\n\tid: "+id+ 
                "\ttipo: "+tipo+ 
                "\tprioridad: "+prioridad;
    }
}