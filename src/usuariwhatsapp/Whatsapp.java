/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuariwhatsapp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
class Whatsapp {

    private int numeroMiembros;
    private int contadorMiembrosSaludados;
    private boolean preguntaLugarHecha = false;
    private boolean respuestaLugar = false;
    private String threadPreguntador = "";

    public synchronized void saludar(String nombreThread) {
        System.out.println(nombreThread + " Hola a tots soc " + nombreThread);
        this.contadorMiembrosSaludados++;
        if (this.contadorMiembrosSaludados == this.numeroMiembros) {
            this.notifyAll();
        } else {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(UsuariWhatsapp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public synchronized void preguntarCena(String nombreThread) {
        if (this.preguntaLugarHecha == false) {
            System.out.println(nombreThread + " Hora y lugar para cenar el sabado?");
            this.threadPreguntador = nombreThread;
            this.preguntaLugarHecha = true;
        }
    }

    public synchronized void responderCena(String nombreThread) {
        if (this.respuestaLugar == false && !nombreThread.equalsIgnoreCase(this.threadPreguntador)) {
            System.out.println(nombreThread + " A las 22h a la pizzeria");
            this.respuestaLugar = true;
        }
    }

    public synchronized void  despedirse(String nombreThread) {
        System.out.println(nombreThread + " Ok.Nos vemos. Adios por parte de" + nombreThread);

    }

    public Whatsapp(int numeroMiembros) {
        this.numeroMiembros = numeroMiembros;
        this.contadorMiembrosSaludados = 0;
    }

    public Whatsapp() {
        this.numeroMiembros = 0;
        this.contadorMiembrosSaludados = 0;
    }

    public int getNumeroMiembros() {
        return numeroMiembros;
    }

    public void setNumeroMiembros(int numeroMiembros) {
        this.numeroMiembros = numeroMiembros;
    }

    public synchronized boolean isRespuestaLugar() {
        return respuestaLugar;
    }

    public void setRespuestaLugar(boolean respuestaLugar) {
        this.respuestaLugar = respuestaLugar;
    }

    @Override
    public String toString() {
        return "Whatsapp{" + '}';
    }

}
