/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import conexionBD.ConexionBD;
import controlador.UsuarioDAO;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import modelo.Usuario;

/**
 *
 * @author bryan
 */
public class guiUsuario extends javax.swing.JFrame {

    /**
     * Creates new form guiUsuario
     */
    public guiUsuario() {
        initComponents();
        actualizarTabla("SELECT * FROM Usuario;");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        caja1 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        caja2 = new javax.swing.JFormattedTextField();
        btnLimpiar = new javax.swing.JButton();
        comboFiltro = new javax.swing.JComboBox<>();
        comboOperacion = new javax.swing.JComboBox<>();
        btnOperacion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Formulario usuario");
        setMinimumSize(new java.awt.Dimension(331, 340));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 271, 121);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 70, 14);

        
        caja1.setToolTipText("Introduce el nombre de usuario");
        caja1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caja1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caja1KeyReleased(evt);
            }
        });
        getContentPane().add(caja1);
        caja1.setBounds(10, 31, 95, 25);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 57, 90, 14);

        
        caja2.setToolTipText("Introduce la contraseña del usuario");
        caja2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caja2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caja2KeyReleased(evt);
            }
        });
        getContentPane().add(caja2);
        caja2.setBounds(10, 77, 95, 25);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Borra todos los textos de los campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(10, 140, 90, 23);

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Búsqueda precisa", "Búsqueda amplia" }));
        comboFiltro.setToolTipText("Busca que los datos sean exactamente como en los campos en búsqueda precisa, con la búsqueda amplia busca cualquier coincidencia por cada campo");
        comboFiltro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboFiltroMouseClicked(evt);
            }
        });
        comboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroActionPerformed(evt);
            }
        });
        getContentPane().add(comboFiltro);
        comboFiltro.setBounds(130, 30, 150, 25);

        comboOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agregar", "Eliminar", "Modificar" }));
        comboOperacion.setToolTipText("Selecciona el tipo de operación");
        comboOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOperacionActionPerformed(evt);
            }
        });
        getContentPane().add(comboOperacion);
        comboOperacion.setBounds(150, 80, 100, 25);

        btnOperacion.setText("Agregar");
        btnOperacion.setToolTipText("Realizar operación");
        btnOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnOperacion);
        btnOperacion.setBounds(150, 110, 100, 23);

        jButton1.setText("Aplicar");
        jButton1.setToolTipText("Aplica todos los cambios realizados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 110, 90, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\bryan\\OneDrive\\one drive\\Documentos\\NetBeansProjects\\ProyectoFinalTBD\\archivos\\guiUsuario.png")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 350, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiar(){
        caja1.setText("");
        caja2.setText("");
        String sql = consulta();
        actualizarTabla(sql);
    }
    
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void caja2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja2KeyPressed
        int code = evt.getKeyCode();
	int limite = 20;
        JFormattedTextField caja = caja2;
	if ((caja.getText().equals("")?true:!(caja.getText().charAt(caja.getText().length()-1)==' '&&code==KeyEvent.VK_SPACE))&&(caja.getText().length()<limite||code==KeyEvent.VK_BACK_SPACE)) {
		caja.setEditable(true);
	}else{
		caja.setEditable(false);
	}
        
    }//GEN-LAST:event_caja2KeyPressed

    private void caja1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja1KeyPressed
        int code = evt.getKeyCode();
	int limite = 20;
        JFormattedTextField caja = caja1;
	if ((caja.getText().equals("")?true:!(caja.getText().charAt(caja.getText().length()-1)==' '&&code==KeyEvent.VK_SPACE))&&(caja.getText().length()<limite||code==KeyEvent.VK_BACK_SPACE)) {
		caja.setEditable(true);
	}else{
		caja.setEditable(false);
	}
    }//GEN-LAST:event_caja1KeyPressed

    private void caja1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja1KeyReleased
        String sql = consulta();
        actualizarTabla(sql);
    }//GEN-LAST:event_caja1KeyReleased

    private void caja2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja2KeyReleased
        String sql = consulta();
        actualizarTabla(sql);
    }//GEN-LAST:event_caja2KeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void comboFiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboFiltroMouseClicked
        String sql = consulta();
        actualizarTabla(sql);
    }//GEN-LAST:event_comboFiltroMouseClicked

    private void comboOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOperacionActionPerformed
        btnOperacion.setText(""+comboOperacion.getSelectedItem());
    }//GEN-LAST:event_comboOperacionActionPerformed
    
    public Usuario createUsuario(boolean isForDeletion){
        Usuario usuario=null;
        if(isForDeletion){
            usuario = new Usuario(caja1.getText(),"");
        }else{
            usuario = new Usuario(
                caja1.getText(),
                caja2.getText());
        }
        return usuario;
    }
    
    
    private void btnOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperacionActionPerformed
        String operacion = btnOperacion.getText();
        ArrayList<Usuario> comprobacion = new ArrayList<Usuario>();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario=null;
        
        switch(operacion){
            case "Eliminar":
                if (caja1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"No se está especificando el ID del usuario a eliminar");
		}else{
                    usuario = createUsuario(true);
                    comprobacion = usuarioDAO.buscar("SELECT * FROM Usuario WHERE Username = '"+caja1.getText()+"'");
                    if (comprobacion.size()==0) {
			JOptionPane.showMessageDialog(null,"No se pudo encontrar usuario a eliminar");
                    }else{
                        int reply = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar el usuario?", "¡Alerta!", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            if (usuarioDAO.borrarRegistro(usuario)) {	
                                JOptionPane.showMessageDialog(null,"Usuario eliminado exitosamente");
                                limpiar();
                            }else {	
                                JOptionPane.showMessageDialog(null,"No se pudo eliminar el usuario");	
                            }
			}
                    }
                }
                break;
            case "Modificar":
                if(comprobarCampos()){
                    usuario = createUsuario(false);
                    comprobacion = usuarioDAO.buscar("SELECT * FROM Usuario WHERE Username = '"+caja1.getText()+"'");
                    if (comprobacion.size()==0) {
			JOptionPane.showMessageDialog(null,"No se pudo encontrar el usuario a modificar");
                    }else {
                        if (usuarioDAO.modificarRegistro(usuario)) {
                            JOptionPane.showMessageDialog(null,"Usuario modificado exitosamente");
			}else{	
                            JOptionPane.showMessageDialog(null,"No se pudo modificar el usuario");	
                        }
                    }
                }
                
                break;
            case "Agregar":
                if(comprobarCampos()){
                    usuario = createUsuario(false);
                    if (usuarioDAO.insertarRegistro(usuario)) {
			JOptionPane.showMessageDialog(null,"Usuario agregado exitosamente");
                    }else {
			JOptionPane.showMessageDialog(null,"No se pudo agregar el usuario, quizá ya hay uno con el mismo ID");
                    }
                }
                break;
            default:break;
        }
        
        String sql = consulta();
        actualizarTabla(sql);
        
    }//GEN-LAST:event_btnOperacionActionPerformed

    private void comboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFiltroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConexionBD.Transaccion("COMMIT;");
        ConexionBD.ejecutarConsulta("CALL sp_CantidadDePaises();");
        ConexionBD.Transaccion("START TRANSACTION;");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
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
	String sql = "SELECT * FROM Usuario ";
	setOps(comboFiltro);
		
	boolean primero=true;
	if(!caja1.getText().equals("")) {
            if (!primero) {sql+=op2;}else {sql+="WHERE ";}
            primero=false;
            sql+=("Username "+op1+" '"+op3+caja1.getText()+op3+"'");
	}
        if(!btnOperacion.getText().contains("Modificar")){
            if(!caja2.getText().equals("")) {
                if (!primero) {sql+=op2;}else {sql+="WHERE ";}
                primero=false;
                sql+=("Password "+op1+" '"+op3+caja2.getText()+op3+"'");
            }
        }
	
	return sql;
    }
    
    public boolean comprobarCampos() {
        if(caja1.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Falta el nombre de usuario");
            caja1.requestFocus();
            return false;
	}
	if(caja2.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Falta la contraseña");
            caja2.requestFocus();
            return false;
	}
        return true;
    }
    
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
            java.util.logging.Logger.getLogger(guiUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiUsuario().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnOperacion;
    private javax.swing.JFormattedTextField caja1;
    private javax.swing.JFormattedTextField caja2;
    private javax.swing.JComboBox<String> comboFiltro;
    private javax.swing.JComboBox<String> comboOperacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
