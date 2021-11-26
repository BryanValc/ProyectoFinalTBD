/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author bryan
 */
import conexionBD.ConexionBD;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author bryan
 */
public class Grafica {
    
    Connection c = ConexionBD.getConexion();
  
        public Boolean dibujar(){
            boolean ret=false;
            try {
                //String sql="SELECT L.Language AS Idioma, ROUND(SUM((L.Percentage/100)*C.Population)) AS Hablantes FROM CountryLanguage L JOIN Country C ON C.Code=L.CountryCode GROUP BY L.Language;";
                String sql="SELECT L.Language AS Idioma, ROUND(SUM((L.Percentage/100)*C.Population)) AS Hablantes FROM CountryLanguage L JOIN Country C ON C.Code=L.CountryCode WHERE C.Population*L.Percentage>1000000000 GROUP BY L.Language;";
                
                
                ResultSet rs=ConexionBD.ejecutarConsulta(sql);
                DefaultPieDataset dataset=new DefaultPieDataset();
                
                try {
                    while(rs.next()){
                        dataset.setValue(rs.getString("Idioma"), Float.parseFloat(rs.getString("Hablantes")));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }

                JFreeChart chart= ChartFactory.createPieChart("Top idiomas con más de 10M de hablantes", dataset, true, true, false);
                
                int x=1000;
                int y=1000;
                File f=new File("Grafica.png");
                ChartUtilities.saveChartAsPNG(f, chart, x, y);
            } catch (IOException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
        }
    
}