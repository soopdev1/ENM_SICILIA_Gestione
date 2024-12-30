/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class NewClass {

    public static void main(String[] args) {
        String scelta = "1";
        try {
            scelta = args[0];
        } catch (Exception e) {
//            e.printStackTrace();
        }

        switch (scelta) {
            case "0" -> {
                System.out.println("NewClass.main(ESEGUO METODO 0)");
            }
            case "1" -> {
                System.out.println("NewClass.main(ESEGUO METODO 1)");
            }
            case "2" -> {
            }
            default -> {
            }
        }
    }
}
