import Aeronaves.*;
import TorreDeControl.TorreDeControl;

public class Simulador{
    public static void main(String[] args) {

        TorreDeControl torreDeControl = new TorreDeControl();

        Emergencia emergencia = new Emergencia("A123");
        Militar militar = new Militar("B456");
        Pasajeros pasajeros = new Pasajeros("C789");
        Carga carga = new Carga("D012");
        Emergencia emergencia2 = new Emergencia("E345");

        torreDeControl.registrarAeronaveParaDespegue(carga);
        torreDeControl.registrarAeronaveParaDespegue(emergencia);
        torreDeControl.registrarAeronaveParaDespegue(militar);
        torreDeControl.registrarAeronaveParaDespegue(pasajeros);
        torreDeControl.registrarAeronaveParaDespegue(emergencia2);


        militar.solicitarAterrizaje(torreDeControl);
        emergencia.solicitarAterrizaje(torreDeControl);
        carga.solicitarAterrizaje(torreDeControl);
        pasajeros.solicitarAterrizaje(torreDeControl);
        emergencia2.solicitarAterrizaje(torreDeControl);


        System.out.println(torreDeControl);
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");
        System.out.println(torreDeControl);
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");   
        System.out.println(torreDeControl);
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");   
        System.out.println(torreDeControl);
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");   
        System.out.println(torreDeControl);
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");   
        System.out.println(torreDeControl); 
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");   
        System.out.println(torreDeControl);
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");   
        System.out.println(torreDeControl);     
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");   
        System.out.println(torreDeControl); 
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");   
        militar.solicitarAterrizaje(torreDeControl);
        System.out.println(torreDeControl);        
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");   
        System.out.println(torreDeControl); 
        System.out.println("---------------------------------------------------------------");
        torreDeControl.procesarSiguienteEvento();
        System.out.println("---------------------------------------------------------------");   
        System.out.println(torreDeControl);                                                            
    }
}