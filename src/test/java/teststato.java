
import rc.so.db.Entity;
import rc.so.domain.StatoPartecipazione;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class teststato {
    public static void main(String[] args) {
        
        
        Entity e = new Entity();
        
        e.begin();
        
        System.out.println("teststato.main() "+e.getEm().find(StatoPartecipazione.class, "11").toString());
        e.close();
    }
}
