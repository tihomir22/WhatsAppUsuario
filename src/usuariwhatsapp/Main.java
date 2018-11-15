/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuariwhatsapp;

import java.util.ArrayList;

/**
 *
 * @author mati
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Whatsapp whats = new Whatsapp();
        UsuariWhatsapp user1 = new UsuariWhatsapp(whats, 1);
        UsuariWhatsapp user2 = new UsuariWhatsapp(whats, 2);
        UsuariWhatsapp user3 = new UsuariWhatsapp(whats, 3);
        UsuariWhatsapp user4 = new UsuariWhatsapp(whats, 4);
        ArrayList<UsuariWhatsapp> listaUsuarios = new ArrayList<UsuariWhatsapp>();
        listaUsuarios.add(user1);
        listaUsuarios.add(user2);
        listaUsuarios.add(user3);
        listaUsuarios.add(user4);
        whats.setNumeroMiembros(listaUsuarios.size());
        
        user1.start();
        user2.start();
        user3.start();
        user4.start();
        
    }
    
}
