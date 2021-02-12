/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.bo.HerramientaMedicaBo;
import negocio.clases.HerramientaMedica;

/**
 *
 * @author Danny
 */
public class MantHerramientaMedica extends javax.swing.JFrame {

    private HerramientaMedicaBo herramientaBo;
    private DefaultTableModel modelHerramienta;

    /**
     * Creates new form MantHerramientaMedica
     */
    public MantHerramientaMedica() {
        initComponents();
        this.herramientaBo = new HerramientaMedicaBo();
        this.modelHerramienta = new DefaultTableModel();
        llenarTabla();
    }

    public void llenarTabla(List<HerramientaMedica> listaHerramienta) {
        this.modelHerramienta = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.modelHerramienta.setColumnCount(0);
        this.modelHerramienta.addColumn("codigo");
        this.modelHerramienta.addColumn("descripcion");
        this.modelHerramienta.addColumn("cantidad Total");
        this.modelHerramienta.addColumn("cantidad Prestados");

        //List<HerramientaMedica> listaHerramienta = this.herramientaBo.consultaTodos();
        if (listaHerramienta != null) {

            this.modelHerramienta.setNumRows(listaHerramienta.size());

            for (int i = 0; i < listaHerramienta.size(); i++) {
                HerramientaMedica herr = listaHerramienta.get(i);

                modelHerramienta.setValueAt(herr.getCodigo(), i, 0);
                modelHerramienta.setValueAt(herr.getDescripcion(), i, 1);
                modelHerramienta.setValueAt(herr.getCantidadTotal(), i, 2);
                modelHerramienta.setValueAt(herr.getCantidadPrestado(), i, 3);
            }

            //usa el obj recien creado para popular la tabla
            this.tabla.setModel(modelHerramienta);
        }

    }

    public void llenarTabla() {
        this.modelHerramienta = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.modelHerramienta.setColumnCount(0);
        this.modelHerramienta.addColumn("codigo");
        this.modelHerramienta.addColumn("descripcion");
        this.modelHerramienta.addColumn("cantidad Total");
        this.modelHerramienta.addColumn("cantidad Prestados");

        List<HerramientaMedica> listaHerramienta = this.herramientaBo.consultaTodos();
        if (listaHerramienta != null) {

            this.modelHerramienta.setNumRows(listaHerramienta.size());

            for (int i = 0; i < listaHerramienta.size(); i++) {
                HerramientaMedica herr = listaHerramienta.get(i);

                modelHerramienta.setValueAt(herr.getCodigo(), i, 0);
                modelHerramienta.setValueAt(herr.getDescripcion(), i, 1);
                modelHerramienta.setValueAt(herr.getCantidadTotal(), i, 2);
                modelHerramienta.setValueAt(herr.getCantidadPrestado(), i, 3);
            }

            //usa el obj recien creado para popular la tabla
            this.tabla.setModel(modelHerramienta);
        }

    }

    public void limpiar() {
        this.codigoTF.setText("");
        this.descripcionTF.setText("");
        this.cantidadPrestadosTF.setText("");
        this.cantidadTotalTF.setText("");

        this.llenarTabla();
    }

    private boolean validarDatos() {
        boolean todoBien = true;

        //validacion de codigo
        if (this.codigoTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el codigo de la herramienta.");
        } else {
            try {
                int num = Integer.parseInt(codigoTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números en el codigo.");
            }
        }

        //validacion de descripcion
        if (this.descripcionTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la descripcion de la herramienta.");
        }

        //validacion de cantidadTotal
        if (this.cantidadTotalTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la cantidad total de herramientas.");
        } else {
            try {
                int num = Integer.parseInt(cantidadTotalTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números en la cantidad total.");
            }
        }

        //validacion de cantidadPRestado
        if (this.cantidadPrestadosTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la cantidad de herramientas prestadas.");
        } else {
            try {
                int num = Integer.parseInt(cantidadPrestadosTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números la cantidad de herramientas prestadas.");
            }
        }

        return todoBien;

    }

    public HerramientaMedicaBo getHerramientaBo() {
        return herramientaBo;
    }

    public void setHerramientaBo(HerramientaMedicaBo herramientaBo) {
        this.herramientaBo = herramientaBo;
    }

    public DefaultTableModel getModelHerramienta() {
        return modelHerramienta;
    }

    public void setModelHerramienta(DefaultTableModel modelHerramienta) {
        this.modelHerramienta = modelHerramienta;
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
        tabla = new javax.swing.JTable();
        agregarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        listarTodosBtn = new javax.swing.JButton();
        consultarBtn = new javax.swing.JButton();
        volverMenuBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        codigoTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cantidadTotalTF = new javax.swing.JTextField();
        cantidadPrestadosTF = new javax.swing.JTextField();
        descripcionTF = new javax.swing.JTextField();
        limpiarBtn = new javax.swing.JButton();
        consultarDescBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        agregarBtn.setText("Agregar");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        listarTodosBtn.setText("Listar Todos");
        listarTodosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarTodosBtnActionPerformed(evt);
            }
        });

        consultarBtn.setText("Consultar por codigo");
        consultarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarBtnActionPerformed(evt);
            }
        });

        volverMenuBtn.setText("volver a menu");
        volverMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMenuBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Descripcion");

        jLabel3.setText("Cantidad Total");

        jLabel4.setText("Cantidad Prestados ");

        limpiarBtn.setText("Limpiar");
        limpiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBtnActionPerformed(evt);
            }
        });

        consultarDescBtn.setText("Consultar por descripcion");
        consultarDescBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarDescBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidadPrestadosTF))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(59, 59, 59)
                        .addComponent(descripcionTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(46, 46, 46)
                        .addComponent(cantidadTotalTF))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 175, Short.MAX_VALUE)
                        .addComponent(codigoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarBtn)
                            .addComponent(eliminarBtn)
                            .addComponent(volverMenuBtn)
                            .addComponent(modificarBtn)
                            .addComponent(listarTodosBtn)
                            .addComponent(consultarBtn)
                            .addComponent(limpiarBtn)
                            .addComponent(consultarDescBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(descripcionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cantidadTotalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cantidadPrestadosTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listarTodosBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consultarBtn)
                        .addGap(3, 3, 3)
                        .addComponent(consultarDescBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpiarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(volverMenuBtn)
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        // TODO add your handling code here:

        if (validarDatos()) {
            //crea obj profesor

            HerramientaMedica her = new HerramientaMedica();

            //popula al obj profesor con datos
            her.setCodigo(Integer.parseInt(this.codigoTF.getText()));
            her.setDescripcion(this.descripcionTF.getText());
            her.setCantidadTotal(Integer.parseInt(this.cantidadTotalTF.getText()));
            her.setCantidadPrestado(Integer.parseInt(this.cantidadPrestadosTF.getText()));

            if (!(her.getCantidadPrestado() > her.getCantidadTotal())) {
                 //inserta el obj profesor usando el metodo de profesorBo
            int res = this.herramientaBo.insertar(her);

            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Herramienta agregada correctamente.");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "No se pudo conectar a la BD.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Ya existe una herramienta con esa codigo.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Ocurrio un error inesperado.");
                    break;
            }
            }else{
                JOptionPane.showMessageDialog(null,
                        "La cantidad de herramientas prestadas no puede ser mayor a la cantidad total.");
            }

           
        }
        limpiar();

    }//GEN-LAST:event_agregarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:

        if (this.codigoTF.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ingrese una cedula a eliminar");
        } else {
            try {
                int cod = Integer.parseInt(this.codigoTF.getText());
                HerramientaMedica her = new HerramientaMedica();

                her.setCodigo(cod);

                int res = this.herramientaBo.eliminar(her);

                switch (res) {
                    case 0:
                        JOptionPane.showMessageDialog(null,
                                "No se elimino ninguna herramienta");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                "Se elimino la herramienta correctamente");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,
                                "No se pudo conectar a la BD");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,
                                "Ocurrio un error inesperado.");
                        break;
                }
                limpiar();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "solo se permiten numeros en la cedula");
            }
        }
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        // TODO add your handling code here:

        if (validarDatos()) {
            //crea obj profesor

            HerramientaMedica her = new HerramientaMedica();

            //popula al obj profesor con datos
            her.setCodigo(Integer.parseInt(this.codigoTF.getText()));
            her.setDescripcion(this.descripcionTF.getText());
            her.setCantidadTotal(Integer.parseInt(this.cantidadTotalTF.getText()));
            her.setCantidadPrestado(Integer.parseInt(this.cantidadPrestadosTF.getText()));

            //inserta el obj profesor usando el metodo de profesorBo
            int res = this.herramientaBo.modificar(her);

            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Herramienta modificada correctamente.");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "No se pudo conectar a la BD.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Ya existe una herramienta con esa codigo.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Ocurrio un error inesperado.");
                    break;
            }
        }
        limpiar();

    }//GEN-LAST:event_modificarBtnActionPerformed

    private void listarTodosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarTodosBtnActionPerformed
        // TODO add your handling code here:
        List<HerramientaMedica> lista = herramientaBo.consultaTodos();
        llenarTabla(lista);
    }//GEN-LAST:event_listarTodosBtnActionPerformed

    private void consultarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBtnActionPerformed
        // TODO add your handling code here:
        if (this.codigoTF.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el nombre a consultar");
        } else {
            List<HerramientaMedica> lista = herramientaBo.consultarPorCodigo(codigoTF.getText());
            llenarTabla(lista);
        }
    }//GEN-LAST:event_consultarBtnActionPerformed

    private void limpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBtnActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_limpiarBtnActionPerformed

    private void volverMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuBtnActionPerformed
        // TODO add your handling code here:
        Inicio ini = new Inicio();
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverMenuBtnActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila = tabla.getSelectedRow();

            this.codigoTF.setText(tabla.getValueAt(fila, 0).toString());
            this.descripcionTF.setText(tabla.getValueAt(fila, 1).toString());
            this.cantidadTotalTF.setText(tabla.getValueAt(fila, 2).toString());
            this.cantidadPrestadosTF.setText(tabla.getValueAt(fila, 3).toString());

        }
    }//GEN-LAST:event_tablaMouseClicked

    private void consultarDescBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarDescBtnActionPerformed
        // TODO add your handling code here:
        if (this.descripcionTF.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la descripcion a consultar");
        } else {
            List<HerramientaMedica> lista = herramientaBo.consultarPorDescripcion(descripcionTF.getText());
            llenarTabla(lista);
        }
    }//GEN-LAST:event_consultarDescBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MantHerramientaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantHerramientaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantHerramientaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantHerramientaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantHerramientaMedica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JTextField cantidadPrestadosTF;
    private javax.swing.JTextField cantidadTotalTF;
    private javax.swing.JTextField codigoTF;
    private javax.swing.JButton consultarBtn;
    private javax.swing.JButton consultarDescBtn;
    private javax.swing.JTextField descripcionTF;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarBtn;
    private javax.swing.JButton listarTodosBtn;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverMenuBtn;
    // End of variables declaration//GEN-END:variables
}
