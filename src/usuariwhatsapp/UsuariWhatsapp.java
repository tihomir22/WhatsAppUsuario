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
public class UsuariWhatsapp extends Thread {

    private boolean salutacionHecha;
    private Whatsapp whats;
    private int numeroUsuario;
    private boolean despedida;

    @Override
    public void run() {
        while (despedida == false) {
            try {
                Thread.sleep(1000);
                System.out.println("Hola a todos soy " + this.getName());
                this.salutacionHecha=true;
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(UsuariWhatsapp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public UsuariWhatsapp(Whatsapp whats, int numero) {
        this.salutacionHecha = false;
        this.despedida = false;
        this.whats = whats;
        this.setName(numero + "");
    }

    public boolean isSalutacionHecha() {
        return salutacionHecha;
    }

    public void setSalutacionHecha(boolean salutacionHecha) {
        this.salutacionHecha = salutacionHecha;
    }

    public Whatsapp getWhats() {
        return whats;
    }

    public void setWhats(Whatsapp whats) {
        this.whats = whats;
    }

    @Override
    public String toString() {
        return "UsuariWhatsapp{" + "salutacionHecha=" + salutacionHecha + ", whats=" + whats + '}';
    }

}
