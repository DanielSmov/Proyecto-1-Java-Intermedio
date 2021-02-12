/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.bo.DoctorBo;
import negocio.bo.SalonBo;
import negocio.clases.Doctor;
import negocio.clases.Salon;

/**
 *
 * @author Danny
 */
public class MantSalon extends javax.swing.JFrame {

    private DoctorBo doctorBo;
    private SalonBo salonBo;
    private DefaultTableModel modelSalon;

    public MantSalon() {
        initComponents();
        this.salonBo = new SalonBo();
        this.doctorBo = new DoctorBo();
        this.modelSalon = new DefaultTableModel();
        llenarTabla();
        this.llenaDoctor();
    }

    public SalonBo getSalonBo() {
        return salonBo;
    }

    public void setSalonBo(SalonBo salonBo) {
        this.salonBo = salonBo;
    }

    public DefaultTableModel getModelSalon() {
        return modelSalon;
    }

    public void setModelSalon(DefaultTableModel modelSalon) {
        this.modelSalon = modelSalon;
    }

    public void llenarTabla(List<Salon> listaSalon) {
        this.modelSalon = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.modelSalon.setColumnCount(0);
        this.modelSalon.addColumn("Num Salon");
        this.modelSalon.addColumn("Cant. Camas");
        this.modelSalon.addColumn("Area");
        this.modelSalon.addColumn("Ced. Doc.");

        //List<Salon> listaSalon = this.salonBo.consultaTodos();
        if (listaSalon != null) {

            this.modelSalon.setNumRows(listaSalon.size());

            for (int i = 0; i < listaSalon.size(); i++) {
                Salon sal = listaSalon.get(i);
                modelSalon.setValueAt(sal.getNumSalon(), i, 0);
                modelSalon.setValueAt(sal.getCantCamas(), i, 1);
                modelSalon.setValueAt(sal.getArea(), i, 2);
                modelSalon.setValueAt(sal.getCedulaDoctor(), i, 3);

            }

            //usa el obj recien creado para popular la tabla
            this.tabla.setModel(modelSalon);

        }

    }

    public void llenarTabla() {
        this.modelSalon = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.modelSalon.setColumnCount(0);
        this.modelSalon.addColumn("Num Salon");
        this.modelSalon.addColumn("Cant. Camas");
        this.modelSalon.addColumn("Area");
        this.modelSalon.addColumn("Ced. Doc.");

        List<Salon> listaSalon = this.salonBo.consultaTodos();
        if (listaSalon != null) {

            this.modelSalon.setNumRows(listaSalon.size());

            for (int i = 0; i < listaSalon.size(); i++) {
                Salon sal = listaSalon.get(i);
                modelSalon.setValueAt(sal.getNumSalon(), i, 0);
                modelSalon.setValueAt(sal.getCantCamas(), i, 1);
                modelSalon.setValueAt(sal.getArea(), i, 2);
                modelSalon.setValueAt(sal.getCedulaDoctor(), i, 3);

            }

            //usa el obj recien creado para popular la tabla
            this.tabla.setModel(modelSalon);

        }

    }

    public void limpiar() {

        this.numeroSalonTF.setText("");
        this.cantidadCamasTF.setText("");
        this.areaTF.setText("");
        
        this.llenarTabla();
    }

    private boolean validarDatos() {
        boolean todoBien = true;

        //valida Num salon
        if (this.numeroSalonTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el numero de salon.");
        } else {
            try {
                int num = Integer.parseInt(numeroSalonTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números el numero de salon.");
            }
        }

        //valida cantidadCamas
        if (this.cantidadCamasTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el numero de camas.");
        } else {
            try {
                int num = Integer.parseInt(cantidadCamasTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números el numero de camas.");
            }
        }

        //validacion de area
        if (this.areaTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el area.");
        }

        //validacion de doctor a cargo
//        if (this.doctorCargoTF.getText().trim().equals("")) {
//            todoBien = false;
//            JOptionPane.showMessageDialog(null,
//                    "Digite el doctor a cargo.");
//        }

        return todoBien;

    }

    public void llenaDoctor() {
        List<Doctor> docs = this.doctorBo.consultaTodos();
        this.doctorCB.addItem("--seleccione--");
        for (Doctor doc : docs) {
            this.doctorCB.addItem(doc.getCedula() + "-" + doc.getNombre());
        }
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
        numeroSalonTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cantidadCamasTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        areaTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        consultarAreaBtn = new javax.swing.JButton();
        doctorCB = new javax.swing.JComboBox<>();

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

        consultarBtn.setText("Consultar num Salon");
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

        jLabel1.setText("Numero Salon");

        jLabel2.setText("Cantidad Camas");

        jLabel3.setText("Area");

        jLabel4.setText("Doctor a cargo");

        consultarAreaBtn.setText("Consultar Area");
        consultarAreaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarAreaBtnActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantidadCamasTF)
                            .addComponent(areaTF)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)
                        .addComponent(numeroSalonTF))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(volverMenuBtn)
                                    .addComponent(agregarBtn)
                                    .addComponent(eliminarBtn)
                                    .addComponent(listarTodosBtn)
                                    .addComponent(consultarBtn)
                                    .addComponent(consultarAreaBtn)
                                    .addComponent(modificarBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(74, 74, 74)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(21, 21, 21)
                                .addComponent(doctorCB, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numeroSalonTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cantidadCamasTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(areaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38)
                        .addComponent(agregarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listarTodosBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consultarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consultarAreaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverMenuBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(doctorCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        if (validarDatos()) {
            //crea obj profesor
            Salon sal = new Salon();

            sal.setNumSalon(Integer.parseInt(this.numeroSalonTF.getText()));
            sal.setCantCamas(Integer.parseInt(this.cantidadCamasTF.getText()));
            sal.setArea(this.areaTF.getText());
           // sal.setCedulaDoctor(Integer.parseInt(this.doctorCargoTF.getText()));

            String doc = this.doctorCB.getSelectedItem().toString();
            String[] partesDoc = doc.split("-");
            sal.setCedulaDoctor(Integer.parseInt(partesDoc[0]));
            
            //inserta el obj profesor usando el metodo de profesorBo
            int res = this.salonBo.insertar(sal);

            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Salon agregado correctamente.");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "No se pudo conectar a la BD.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Ya existe un salon con ese numero.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Ocurrio un error inesperado.");
                    break;
            }
        }
        limpiar();
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        // TODO add your handling code here:
        if (validarDatos()) {
            //crea obj profesor
            Salon sal = new Salon();

            sal.setNumSalon(Integer.parseInt(this.numeroSalonTF.getText()));
            sal.setCantCamas(Integer.parseInt(this.cantidadCamasTF.getText()));
            sal.setArea(this.areaTF.getText());
           
            String doc = this.doctorCB.getSelectedItem().toString();
            String[] partesDoc = doc.split("-");
            sal.setCedulaDoctor(Integer.parseInt(partesDoc[0]));
            
            //inserta el obj profesor usando el metodo de profesorBo
            int res = this.salonBo.modificar(sal);

            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Salon modificado correctamente.");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "No se pudo conectar a la BD.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Ya existe un salon con ese numero.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Ocurrio un error inesperado.");
                    break;
            }
        }
        limpiar();
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:

        if (this.numeroSalonTF.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ingrese una numero a eliminar");
        } else {
            try {
                int num = Integer.parseInt(this.numeroSalonTF.getText());

                Salon sal = new Salon();
                sal.setNumSalon(num);

                int res = this.salonBo.eliminar(sal);

                switch (res) {
                    case 0:
                        JOptionPane.showMessageDialog(null,
                                "No se elimino ningun salon");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                "Se elimino el salon correctamente");
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

    private void listarTodosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarTodosBtnActionPerformed
        // TODO add your handling code here:
        List<Salon> lista = salonBo.consultaTodos();
        llenarTabla(lista);
    }//GEN-LAST:event_listarTodosBtnActionPerformed

    private void consultarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBtnActionPerformed
        // TODO add your handling code here:
        if (this.numeroSalonTF.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el numero a consultar");
        } else {
            List<Salon> lista = salonBo.consultaPorNumSalon(numeroSalonTF.getText());
            llenarTabla(lista);
        }
    }//GEN-LAST:event_consultarBtnActionPerformed

    private void consultarAreaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarAreaBtnActionPerformed
        // TODO add your handling code here:
        if (this.areaTF.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el area a consultar");
        } else {
            List<Salon> lista = salonBo.consultarPorArea(areaTF.getText());
            llenarTabla(lista);
        }
    }//GEN-LAST:event_consultarAreaBtnActionPerformed

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

            this.numeroSalonTF.setText(tabla.getValueAt(fila, 0).toString());
            this.cantidadCamasTF.setText(tabla.getValueAt(fila, 1).toString());
            this.areaTF.setText(tabla.getValueAt(fila, 2).toString());
            //this.doctorCB.setText(tabla.getValueAt(fila, 3).toString());

        }
    }//GEN-LAST:event_tablaMouseClicked

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
            java.util.logging.Logger.getLogger(MantSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantSalon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantSalon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JTextField areaTF;
    private javax.swing.JTextField cantidadCamasTF;
    private javax.swing.JButton consultarAreaBtn;
    private javax.swing.JButton consultarBtn;
    private javax.swing.JComboBox<String> doctorCB;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listarTodosBtn;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTextField numeroSalonTF;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverMenuBtn;
    // End of variables declaration//GEN-END:variables
}
