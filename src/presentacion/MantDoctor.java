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
import negocio.clases.Doctor;

/**
 *
 * @author Danny
 */
public class MantDoctor extends javax.swing.JFrame {

    //atributos
    private DoctorBo doctorBo;
    private DefaultTableModel modelDoctor;

    public MantDoctor() {
        initComponents();
        this.doctorBo = new DoctorBo();
        this.modelDoctor = new DefaultTableModel();
        llenarTabla();
    }

    public void llenarTabla() {

        this.modelDoctor = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.tabla.getTableHeader().setReorderingAllowed(false);

        List<Doctor> listaDoctor = this.doctorBo.consultaTodos();

        this.modelDoctor.setColumnCount(0);
        this.modelDoctor.addColumn("Cédula");
        this.modelDoctor.addColumn("Nombre");
        this.modelDoctor.addColumn("Apellido");
        this.modelDoctor.addColumn("Especialidad");
        this.modelDoctor.addColumn("Salario");
        this.modelDoctor.addColumn("Direccion");
        this.modelDoctor.addColumn("Telefono");

        if (listaDoctor != null) {
            this.modelDoctor.setNumRows(listaDoctor.size());

            for (int i = 0; i < listaDoctor.size(); i++) {
                Doctor doc = listaDoctor.get(i);

                modelDoctor.setValueAt(doc.getCedula(), i, 0);
                modelDoctor.setValueAt(doc.getNombre(), i, 1);
                modelDoctor.setValueAt(doc.getApellido(), i, 2);
                modelDoctor.setValueAt(doc.getEspecialidad(), i, 3);
                modelDoctor.setValueAt(doc.getSalario(), i, 4);
                modelDoctor.setValueAt(doc.getDireccion(), i, 5);
                modelDoctor.setValueAt(doc.getTelefono(), i, 6);

            }
            this.tabla.setModel(modelDoctor);

        }

    }

    public void llenarTabla(List<Doctor> listaDoctor) {

        this.modelDoctor = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.tabla.getTableHeader().setReorderingAllowed(false);

        this.modelDoctor.setColumnCount(0);
        this.modelDoctor.addColumn("Cedula");
        this.modelDoctor.addColumn("Nombre");
        this.modelDoctor.addColumn("Apellido");
        this.modelDoctor.addColumn("Especialidad");
        this.modelDoctor.addColumn("Salario");
        this.modelDoctor.addColumn("Direccion");
        this.modelDoctor.addColumn("Telefono");

        if (listaDoctor != null) {
            this.modelDoctor.setNumRows(listaDoctor.size());

            for (int i = 0; i < listaDoctor.size(); i++) {
                Doctor doc = listaDoctor.get(i);

                modelDoctor.setValueAt(doc.getCedula(), i, 0);
                modelDoctor.setValueAt(doc.getNombre(), i, 1);
                modelDoctor.setValueAt(doc.getApellido(), i, 2);
                modelDoctor.setValueAt(doc.getEspecialidad(), i, 3);
                modelDoctor.setValueAt(doc.getSalario(), i, 4);
                modelDoctor.setValueAt(doc.getDireccion(), i, 5);
                modelDoctor.setValueAt(doc.getTelefono(), i, 6);

            }
            this.tabla.setModel(modelDoctor);

        }

    }

    public DoctorBo getDoctorBo() {
        return doctorBo;
    }

    public void setDoctorBo(DoctorBo doctorBo) {
        this.doctorBo = doctorBo;
    }

    public DefaultTableModel getModelDoctor() {
        return modelDoctor;
    }

    public void setModelDoctor(DefaultTableModel modelDoctor) {
        this.modelDoctor = modelDoctor;
    }

    private void limpiar() {
        this.cedulaTF.setText("");
        this.nombreTF.setText("");
        this.apellidoTF.setText("");
        this.especialidadTF.setText("");
        this.salarioTF.setText("");
        this.direccionTF.setText("");
        this.telefonoTF.setText("");
        llenarTabla();
        this.cedulaTF.setEnabled(true);
    }

    private boolean validarDatos() {
        boolean todoBien = true;

        //validacion para cedula
        if (this.cedulaTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la cédula del doctor.");
        } else {
            try {
                int num = Integer.parseInt(cedulaTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números en la cédula.");
            }
        }

        //validacion para nombre
        if (this.nombreTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null, "Digite el nombre del doctor.");
        }

        //validacion para apellido
        if (this.apellidoTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el apellido del doctor.");
        }
        //validacion para especialidad
        if (this.apellidoTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la especialidad del doctor.");
        }

        if (this.salarioTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null, "Digite el salario del profesor.");
        } else {
            try {
                double num = Double.parseDouble(this.salarioTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null, "Solo se permiten decimales en el salario.");
            }
        }

        //validacion para direccion
        if (this.apellidoTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la direccion del doctor.");
        }
        return todoBien;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        listarTodosBtn = new javax.swing.JButton();
        consultarBtn = new javax.swing.JButton();
        volverMenuBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cedulaTF = new javax.swing.JTextField();
        nombreTF = new javax.swing.JTextField();
        apellidoTF = new javax.swing.JTextField();
        especialidadTF = new javax.swing.JTextField();
        salarioTF = new javax.swing.JTextField();
        direccionTF = new javax.swing.JTextField();
        telefonoTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        limpiarBtn = new javax.swing.JButton();
        consultarNomBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        consultarBtn.setText("Consultar por cedula");
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

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellidos");

        jLabel4.setText("Especialidad");

        jLabel5.setText("Salario");

        jLabel6.setText("Direccion");

        jLabel7.setText("Telefono");

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

        limpiarBtn.setText("Limpiar");
        limpiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBtnActionPerformed(evt);
            }
        });

        consultarNomBtn1.setText("Consultar por nombre");
        consultarNomBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarNomBtn1ActionPerformed(evt);
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
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(direccionTF, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                            .addComponent(salarioTF)
                            .addComponent(especialidadTF)
                            .addComponent(telefonoTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreTF)
                            .addComponent(apellidoTF)
                            .addComponent(cedulaTF)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarBtn)
                            .addComponent(eliminarBtn)
                            .addComponent(modificarBtn)
                            .addComponent(listarTodosBtn)
                            .addComponent(consultarBtn)
                            .addComponent(limpiarBtn)
                            .addComponent(consultarNomBtn1))
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverMenuBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cedulaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(especialidadTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(direccionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(telefonoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
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
                        .addComponent(consultarNomBtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limpiarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(volverMenuBtn)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        // TODO add your handling code here:

        //validar datos
        if (validarDatos()) {
            //se crea un obj tipo doctor
            Doctor doc = new Doctor();

            //se parsea de string al dato adecuado
            doc.setCedula(Integer.parseInt(this.cedulaTF.getText()));
            doc.setNombre(this.nombreTF.getText());
            doc.setApellido(this.apellidoTF.getText());
            doc.setEspecialidad(this.especialidadTF.getText());
            doc.setSalario(Double.parseDouble(this.salarioTF.getText()));
            doc.setDireccion(this.direccionTF.getText());
            doc.setTelefono(Integer.parseInt(this.telefonoTF.getText()));

            int res = this.doctorBo.insertar(doc);

            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Doctor agregado correctamente.");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "No se pudo conectar a la BD.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Ya existe un doctor con esa cédula.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Ocurrio un error inesperado.");
                    break;
            }
        }
        limpiar();
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila = tabla.getSelectedRow();

            this.cedulaTF.setText(tabla.getValueAt(fila, 0).toString());
            this.nombreTF.setText(tabla.getValueAt(fila, 1).toString());
            this.apellidoTF.setText(tabla.getValueAt(fila, 2).toString());
            this.especialidadTF.setText(tabla.getValueAt(fila, 3).toString());
            this.salarioTF.setText(tabla.getValueAt(fila, 4).toString());
            this.direccionTF.setText(tabla.getValueAt(fila, 5).toString());
            this.telefonoTF.setText(tabla.getValueAt(fila, 6).toString());

            this.cedulaTF.setEnabled(false);
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:

        if (this.cedulaTF.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ingrese una cedula a eliminar");
        } else {
            try {
                //parsea la cedula a integer
                int ced = Integer.parseInt(this.cedulaTF.getText());
                Doctor doc = new Doctor();

                //asigna cedula a un obj doctor
                doc.setCedula(ced);

                //manda el objeto doctor al bussines obj
                int res = this.doctorBo.eliminar(doc);

                switch (res) {
                    case 0:
                        JOptionPane.showMessageDialog(null,
                                "No se elimino ningun doctor");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                "Se elimino el doctor correctamente");
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
        //valida datos
        if (validarDatos()) {
            //se crea un obj tipo doctor
            Doctor doc = new Doctor();

            //se parsea de string al dato adecuado
            doc.setCedula(Integer.parseInt(this.cedulaTF.getText()));
            doc.setNombre(this.nombreTF.getText());
            doc.setApellido(this.apellidoTF.getText());
            doc.setEspecialidad(this.especialidadTF.getText());
            doc.setSalario(Double.parseDouble(this.salarioTF.getText()));
            doc.setDireccion(this.direccionTF.getText());
            doc.setTelefono(Integer.parseInt(this.telefonoTF.getText()));

            //se manda el obj doctor al bussines obj
            int res = this.doctorBo.modificar(doc);

            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Doctor modificado correctamente.");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "No se pudo conectar a la BD.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Ocurrio un error inesperado .");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Ocurrio un error inesperado 3.");
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null,
                            "Ocurrio un error inesperado .");
                    break;

            }
        }
        limpiar();
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void limpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBtnActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_limpiarBtnActionPerformed

    private void consultarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBtnActionPerformed
        // TODO add your handling code here:
        if (this.cedulaTF.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la cedula a consultar");
        } else {
            List<Doctor> lista = doctorBo.consultarPorCedula(cedulaTF.getText());
            llenarTabla(lista);
        }
    }//GEN-LAST:event_consultarBtnActionPerformed

    private void listarTodosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarTodosBtnActionPerformed
        // TODO add your handling code here:
        List<Doctor> lista = doctorBo.consultaTodos();
        llenarTabla(lista);
    }//GEN-LAST:event_listarTodosBtnActionPerformed

    private void volverMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuBtnActionPerformed
        // TODO add your handling code here:
        Inicio ini = new Inicio();
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverMenuBtnActionPerformed

    private void consultarNomBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarNomBtn1ActionPerformed
        // TODO add your handling code here:
         if (this.nombreTF.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el nombre a consultar");
        } else {
            List<Doctor> lista = doctorBo.consultarPorNombre(nombreTF.getText());
            llenarTabla(lista);
        }
    }//GEN-LAST:event_consultarNomBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(MantDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JTextField apellidoTF;
    private javax.swing.JTextField cedulaTF;
    private javax.swing.JButton consultarBtn;
    private javax.swing.JButton consultarNomBtn1;
    private javax.swing.JTextField direccionTF;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JTextField especialidadTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarBtn;
    private javax.swing.JButton listarTodosBtn;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JTextField salarioTF;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField telefonoTF;
    private javax.swing.JButton volverMenuBtn;
    // End of variables declaration//GEN-END:variables
}
