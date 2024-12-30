
import java.sql.ResultSet;
import java.sql.Statement;
import rc.so.db.Database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class ModificaCFAccreditamento {

    public static void main(String[] args) {
        Database db_gest = new Database(false);
        Database db_accr = new Database(true);

        String sql1 = "SELECT s.idsoggetti_attuatori,s.piva FROM soggetti_attuatori s";
        try {

            try (Statement st1 = db_gest.getC().createStatement(); ResultSet rs1 = st1.executeQuery(sql1)) {
                while (rs1.next()) {
                    String id = rs1.getString(1);
                    String partita_iva = rs1.getString(2);

                    String sql2 = "SELECT u.username FROM usersvalori u WHERE u.campo = 'piva' AND u.valore='" + partita_iva + "'";

                    try (Statement st2 = db_accr.getC().createStatement(); ResultSet rs2 = st2.executeQuery(sql2)) {
                        if (rs2.next()) {
                            String username = rs2.getString(1);
                            String sql3 = "SELECT u.valore FROM usersvalori u WHERE u.campo = 'cf' AND u.username='" + username + "'";
                            try (Statement st3 = db_accr.getC().createStatement(); ResultSet rs3 = st3.executeQuery(sql3)) {
                                if (rs3.next()) {
                                    String codice_fiscale = rs3.getString(1);
                                    System.out.println("ModificaCFAccreditamento.main() " + id);
                                    System.out.println("ModificaCFAccreditamento.main() " + partita_iva);
                                    System.out.println("ModificaCFAccreditamento.main() " + username);
                                    System.out.println("ModificaCFAccreditamento.main() " + codice_fiscale);

                                }
                            }
                        }
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        db_accr.closeDB();
        db_gest.closeDB();
    }
}
