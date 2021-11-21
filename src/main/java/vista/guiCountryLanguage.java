/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;

/**
 *
 * @author bryan
 */
public class guiCountryLanguage extends javax.swing.JFrame {

    /**
     * Creates new form guiCountryLanguage
     */
    public guiCountryLanguage() {
        initComponents();
        actualizarTabla("SELECT * FROM CountryLanguage;");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        caja1 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        caja2 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        caja3 = new javax.swing.JFormattedTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        comboFiltro = new javax.swing.JComboBox<>();
        comboOperacion = new javax.swing.JComboBox<>();
        btnOperacion = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Formulario lenguaje de país");
        setMinimumSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código de país");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 20, 110, 14);

        try {
            caja1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        caja1.setToolTipText("Introduce el código del país");
        caja1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caja1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja1KeyTyped(evt);
            }
        });
        getContentPane().add(caja1);
        caja1.setBounds(30, 50, 90, 25);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lenguaje");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 20, 97, 14);

        caja2.setToolTipText("Introduce el nombre del lenguaje");
        caja2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caja2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caja2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja2KeyTyped(evt);
            }
        });
        getContentPane().add(caja2);
        caja2.setBounds(150, 50, 110, 25);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("¿Es oficial?");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 79, 97, 14);

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        combo1.setToolTipText("Selecciona si es oficial o no el lenguaje");
        combo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo1MouseClicked(evt);
            }
        });
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });
        getContentPane().add(combo1);
        combo1.setBounds(30, 104, 70, 25);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Porcentaje");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 135, 90, 14);

        caja3.setToolTipText("Introduce el porcentaje de habitantes que hablan el idioma");
        caja3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caja3ActionPerformed(evt);
            }
        });
        caja3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caja3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caja3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja3KeyTyped(evt);
            }
        });
        getContentPane().add(caja3);
        caja3.setBounds(30, 160, 70, 25);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Borra todos los textos de los campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(120, 160, 100, 23);

        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 210, 340, 120);

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Búsqueda precisa", "Búsqueda amplia" }));
        comboFiltro.setToolTipText("Busca que los datos sean exactamente como en los campos en búsqueda precisa, con la búsqueda amplia busca cualquier coincidencia por cada campo");
        comboFiltro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboFiltroMouseClicked(evt);
            }
        });
        getContentPane().add(comboFiltro);
        comboFiltro.setBounds(220, 80, 150, 25);

        comboOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agregar", "Eliminar", "Modificar" }));
        comboOperacion.setToolTipText("Selecciona el tipo de operación");
        getContentPane().add(comboOperacion);
        comboOperacion.setBounds(240, 130, 100, 25);

        btnOperacion.setText("Agregar");
        btnOperacion.setToolTipText("Realizar operación");
        getContentPane().add(btnOperacion);
        btnOperacion.setBounds(240, 160, 100, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\bryan\\OneDrive\\one drive\\Documentos\\NetBeansProjects\\ProyectoFinalTBD\\archivos\\guiLanguage.png")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 740, 870);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actualizarTabla(String sql) {
		ResultSetTableModel modeloDatos =null;
		try {
			modeloDatos = new ResultSetTableModel("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/world",sql);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
                jScrollPane1.getViewport().remove(jTable1);
		jTable1 = new JTable(modeloDatos);
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	obtenerRegistroTabla();
		    }
		});
                jScrollPane1.getViewport().add(jTable1);
                
	}
    
    public void obtenerRegistroTabla(){
        caja1.setText(""+jTable1.getValueAt(jTable1.getSelectedRow(),0));
        caja2.setText(""+jTable1.getValueAt(jTable1.getSelectedRow(),1));
        String isOfficial = ""+jTable1.getValueAt(jTable1.getSelectedRow(),2);
        if(isOfficial.contains("T")){
            combo1.setSelectedItem("Sí");
        }else{
            combo1.setSelectedItem("No");
        }
        caja3.setText(""+jTable1.getValueAt(jTable1.getSelectedRow(),3));
        
    }
    
    String op1,op2,op3;
    public void setOps(JComboBox<String> caja) {
	switch (""+caja.getSelectedItem()) {
	case "Búsqueda precisa":
            op1="= ";
            op2=" AND ";
            op3="";
            break;
	case "Búsqueda amplia":
            op1="LIKE ";
            op2=" OR ";
            op3="%";
            break;
	default:
		break;
	}
    }
    
    public String consulta() {
	String sql = "SELECT * FROM CountryLanguage ";
	setOps(comboFiltro);
        
        String isOfficial="";
        switch (""+combo1.getSelectedItem()) {
            case "Sí":isOfficial="T";break;
            case "No":isOfficial="F";break;
            default:break;
        }
		
	boolean primero=true;
	if(!caja1.getText().equals("")&&!caja1.getText().equals("   ")) {
            if (!primero) {sql+=op2;}else {sql+="WHERE ";}
            primero=false;
            sql+=("CountryCode "+op1+" '"+op3+caja1.getText().replaceAll(" ", "")+op3+"'");
	}
	if(!caja2.getText().equals("")) {
            if (!primero) {sql+=op2;}else {sql+="WHERE ";}
            primero=false;
            sql+=("Language "+op1+" '"+op3+caja2.getText()+op3+"'");
	}
        if(combo1.getSelectedIndex()!=-1) {
            if (!primero) {sql+=op2;}else {sql+="WHERE ";}
            primero=false;
            sql+=("IsOfficial "+op1+" '"+op3+isOfficial+op3+"'");
	}
        if(!caja3.getText().equals("")) {
            if (!primero) {sql+=op2;}else {sql+="WHERE ";}
            primero=false;
            sql+=("Percentage "+op1+" '"+op3+caja3.getText()+op3+"'");
	}
        System.out.println(sql);
	return sql;
    }
    
    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        
    }//GEN-LAST:event_combo1ActionPerformed

    private void caja3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caja3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caja3ActionPerformed

    private void caja2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja2KeyPressed
        int code = evt.getKeyCode();
	int limite = 30;
        JFormattedTextField caja = caja2;
	if ((caja.getText().equals("")?true:!(caja.getText().charAt(caja.getText().length()-1)==' '&&code==KeyEvent.VK_SPACE))&&(caja.getText().length()<limite||code==KeyEvent.VK_BACK_SPACE)) {
		caja.setEditable(true);
	}else{
		caja.setEditable(false);
	}
    }//GEN-LAST:event_caja2KeyPressed
    int peCaja3 = 0;
    private void caja3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja3KeyPressed
        int code=evt.getKeyCode();
        int limite1 = 4;
        int limite2 = 1;
        JFormattedTextField caja = caja3;
	if (((evt.getKeyChar() >= '0'&&evt.getKeyChar() <= '9')&&!caja.getText().contains("."))&&caja.getText().length()<(limite1)||(code==KeyEvent.VK_BACK_SPACE)) {
            caja.setEditable(true);
        }else if((caja.getText().length()<(limite1+1))&&(evt.getKeyChar() == '.'&&!caja.getText().contains("."))){
            peCaja3 = caja.getText().length();
            caja.setEditable(true);
	}else if((evt.getKeyChar() >= '0'&&evt.getKeyChar() <= '9')&&(caja.getText().length()<(peCaja3+limite2+1))&&caja.getText().contains(".")){
            caja.setEditable(true);
        }else{
            caja.setEditable(false);
	}
    }//GEN-LAST:event_caja3KeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        caja1.setText("");
        caja2.setText("");
        caja3.setText("");
        combo1.setSelectedIndex(-1);
        String sql = consulta();
        actualizarTabla(sql);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void caja1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja1KeyReleased
        String sql = consulta();
        actualizarTabla(sql);
    }//GEN-LAST:event_caja1KeyReleased

    private void caja2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja2KeyTyped
        
    }//GEN-LAST:event_caja2KeyTyped

    private void caja1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja1KeyTyped
       
    }//GEN-LAST:event_caja1KeyTyped

    private void caja3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja3KeyTyped
        
    }//GEN-LAST:event_caja3KeyTyped

    private void caja2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja2KeyReleased
        String sql = consulta();
        actualizarTabla(sql);
    }//GEN-LAST:event_caja2KeyReleased

    private void caja3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja3KeyReleased
        String sql = consulta();
        actualizarTabla(sql);
    }//GEN-LAST:event_caja3KeyReleased

    private void combo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo1MouseClicked
        String sql = consulta();
        actualizarTabla(sql);
    }//GEN-LAST:event_combo1MouseClicked

    private void comboFiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboFiltroMouseClicked
        String sql = consulta();
        actualizarTabla(sql);
    }//GEN-LAST:event_comboFiltroMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(guiCountryLanguage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiCountryLanguage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiCountryLanguage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiCountryLanguage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiCountryLanguage().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnOperacion;
    private javax.swing.JFormattedTextField caja1;
    private javax.swing.JFormattedTextField caja2;
    private javax.swing.JFormattedTextField caja3;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JComboBox<String> comboFiltro;
    private javax.swing.JComboBox<String> comboOperacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}