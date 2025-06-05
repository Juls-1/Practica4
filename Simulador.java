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

        torreDeControl.registrarAeronaveParaDespegue(emergencia);
        torreDeControl.registrarAeronaveParaDespegue(militar);
        torreDeControl.registrarAeronaveParaDespegue(pasajeros);
        torreDeControl.registrarAeronaveParaDespegue(carga);
        torreDeControl.registrarAeronaveParaDespegue(emergencia2);


        System.out.println(torreDeControl);

        torreDeControl.procesarSiguienteEvento();
        System.out.println("-------------------------");
        System.out.println(torreDeControl);


    }
}