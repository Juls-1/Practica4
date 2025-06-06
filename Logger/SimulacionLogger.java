package Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import Aeronaves.*;
import TorreDeControl.TorreDeControl;

public class SimulacionLogger {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fileHandler = new FileHandler("Recursos/Logs/Log.txt");
        logger.addHandler(fileHandler);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);

        TorreDeControl torreDeControl = new TorreDeControl();
        logger.info("Iniciando simulacion de control aereo");

        Emergencia emergencia = new Emergencia("A123");
        Militar militar = new Militar("B456");
        Pasajeros pasajeros = new Pasajeros("C789");
        Carga carga = new Carga("D012");
        Emergencia emergencia2 = new Emergencia("E345");
        logger.info("Aeronaves creadas: " + emergencia.getId() + ", " + militar.getId() + ", " 
                   + pasajeros.getId() + ", " + carga.getId() + ", " + emergencia2.getId());

        // Registro de despegues
        torreDeControl.registrarAeronaveParaDespegue(carga);
        logger.info("Aeronave de carga " + carga.getId() + " registrada para despegue");
        torreDeControl.registrarAeronaveParaDespegue(emergencia);
        logger.info("Aeronave de emergencia " + emergencia.getId() + " registrada para despegue");
        torreDeControl.registrarAeronaveParaDespegue(militar);
        logger.info("Aeronave militar " + militar.getId() + " registrada para despegue");
        torreDeControl.registrarAeronaveParaDespegue(pasajeros);
        logger.info("Aeronave de pasajeros " + pasajeros.getId() + " registrada para despegue");
        torreDeControl.registrarAeronaveParaDespegue(emergencia2);
        logger.info("Aeronave de emergencia " + emergencia2.getId() + " registrada para despegue");

        // Solicitudes de aterrizaje
        militar.solicitarAterrizaje(torreDeControl);
        logger.info("Aeronave militar " + militar.getId() + " solicitó aterrizaje");
        emergencia.solicitarAterrizaje(torreDeControl);
        logger.info("Aeronave de emergencia " + emergencia.getId() + " solicitó aterrizaje");
        carga.solicitarAterrizaje(torreDeControl);
        logger.info("Aeronave de carga " + carga.getId() + " solicitó aterrizaje");
        pasajeros.solicitarAterrizaje(torreDeControl);
        logger.info("Aeronave de pasajeros " + pasajeros.getId() + " solicitó aterrizaje");
        emergencia2.solicitarAterrizaje(torreDeControl);
        logger.info("Aeronave de emergencia " + emergencia2.getId() + " solicitó aterrizaje");

        // Procesamiento de eventos
        System.out.println(torreDeControl);
        logger.info("Estado actual de la torre de control:\n" + torreDeControl.toString());
        System.out.println("---------------------------------------------------------------");

        // Resto del codigo con logging para cada procesamiento de evento
        for (int i = 1; i <= 10; i++) {
            torreDeControl.procesarSiguienteEvento();
            logger.info("Procesado evento #" + i);
            logger.info("Estado de la torre despues del evento:\n" + torreDeControl.toString());
            System.out.println("---------------------------------------------------------------");
            System.out.println(torreDeControl);
            System.out.println("---------------------------------------------------------------");
        }

        militar.solicitarAterrizaje(torreDeControl);
        logger.info("Nueva solicitud de aterrizaje de aeronave militar " + militar.getId());
        System.out.println(torreDeControl);
        logger.info("Estado final de la torre de control:\n" + torreDeControl.toString());
    }
}