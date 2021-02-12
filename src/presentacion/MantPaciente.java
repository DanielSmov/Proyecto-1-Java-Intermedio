/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.bo.PacienteBo;
import negocio.clases.Paciente;

/**
 *
 * @author Danny
 */
public class MantPaciente extends javax.swing.JFrame {

    private PacienteBo pacienteBo;
    private DefaultTableModel modelPaciente;

    public MantPaciente() {
        initComponents();
        this.pacienteBo = new PacienteBo();
        this.modelPaciente = new DefaultTableModel();
        llenarTabla();
    }

    public void llenarTabla(List<Paciente> listaPaciente) {
        this.modelPaciente = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.modelPaciente.setColumnCount(0);
        this.modelPaciente.addColumn("Numero Ase.");
        this.modelPaciente.addColumn("Nombre Compl.");
        this.modelPaciente.addColumn("Direccion");
        this.modelPaciente.addColumn("Edad");
        this.modelPaciente.addColumn("Fecha Nac.");
        this.modelPaciente.addColumn("Email");
        this.modelPaciente.addColumn("Tel.");
        this.modelPaciente.addColumn("Profesion");

        //List<Paciente> listaPaciente = this.pacienteBo.consultaTodos();
        if (listaPaciente != null) {

            this.modelPaciente.setNumRows(listaPaciente.size());

            for (int i = 0; i < listaPaciente.size(); i++) {
                Paciente pac = listaPaciente.get(i);

                modelPaciente.setValueAt(pac.getNumAsegurado(), i, 0);
                modelPaciente.setValueAt(pac.getNombreCompleto(), i, 1);
                modelPaciente.setValueAt(pac.getDireccion(), i, 2);
                modelPaciente.setValueAt(pac.getEdad(), i, 3);
                modelPaciente.setValueAt(pac.getFechaNacimiento(), i, 4);
                modelPaciente.setValueAt(pac.getEmail(), i, 5);
                modelPaciente.setValueAt(pac.getTelefono(), i, 6);
                modelPaciente.setValueAt(pac.getProfesion(), i, 7);

            }
            //usa el obj recien creado para popular la tabla
            this.tabla.setModel(modelPaciente);
        }

    }

    public void llenarTabla() {
        this.modelPaciente = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.modelPaciente.setColumnCount(0);
        this.modelPaciente.addColumn("Numero Ase.");
        this.modelPaciente.addColumn("Nombre Compl.");
        this.modelPaciente.addColumn("Direccion");
        this.modelPaciente.addColumn("Edad");
        this.modelPaciente.addColumn("Fecha Nac.");
        this.modelPaciente.addColumn("Email");
        this.modelPaciente.addColumn("Tel.");
        this.modelPaciente.addColumn("Profesion");

        List<Paciente> listaPaciente = this.pacienteBo.consultaTodos();
        if (listaPaciente != null) {

            this.modelPaciente.setNumRows(listaPaciente.size());

            for (int i = 0; i < listaPaciente.size(); i++) {
                Paciente pac = listaPaciente.get(i);

                modelPaciente.setValueAt(pac.getNumAsegurado(), i, 0);
                modelPaciente.setValueAt(pac.getNombreCompleto(), i, 1);
                modelPaciente.setValueAt(pac.getDireccion(), i, 2);
                modelPaciente.setValueAt(pac.getEdad(), i, 3);
                modelPaciente.setValueAt(pac.getFechaNacimiento(), i, 4);
                modelPaciente.setValueAt(pac.getEmail(), i, 5);
                modelPaciente.setValueAt(pac.getTelefono(), i, 6);
                modelPaciente.setValueAt(pac.getProfesion(), i, 7);

            }

            //usa el obj recien creado para popular la tabla
            this.tabla.setModel(modelPaciente);

        }

    }

    public void limpiar() {
        this.numAseguradoTF.setText("");
        this.nombreCompletoTF.setText("");
        this.direccionTF.setText("");
        this.edadTF.setText("");
        this.fechaNacimientoTF.setText("");
        this.emailTF.setText("");
        this.telefonoTF.setText("");
        this.profesionTF.setText("");
        this.llenarTabla();
    }

    private boolean validarDatos() {
        boolean todoBien = true;

        //validacion de numAsegurado
        if (this.numAseguradoTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el numero de asegurado.");
        } else {
            try {
                int num = Integer.parseInt(numAseguradoTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números en el numero de asegurado.");
            }
        }

        //validacion de edad
        if (this.edadTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la edad asegurado.");
        } else {
            try {
                int num = Integer.parseInt(edadTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números en la edad del asegurado.");
            }
        }

        //validacion de telefono
        if (this.telefonoTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el telefono del asegurado.");
        } else {
            try {
                int num = Integer.parseInt(telefonoTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números en el telefono del asegurado.");
            }
        }

        //validacion de nombreCompleto
        if (this.nombreCompletoTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el nombre del asegurado.");
        }

        //validacion de direccion
        if (this.direccionTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la direccion del asegurado.");
        }

        //validacion de email
        if (this.emailTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el email del asegurado.");
        }

        //validacion de profesion
        if (this.profesionTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la profesion del asegurado.");
        }

        //??validacion para fecha Nacimiento 
        return todoBien;

    }

    public PacienteBo getPacienteBo() {
        return pacienteBo;
    }

    public void setPacienteBo(PacienteBo pacienteBo) {
        this.pacienteBo = pacienteBo;
    }

    public DefaultTableModel getModelPaciente() {
        return modelPaciente;
    }

    public void setModelPaciente(DefaultTableModel modelPaciente) {
        this.modelPaciente = modelPaciente;
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
        numAseguradoTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nombreCompletoTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        direccionTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edadTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fechaNacimientoTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        telefonoTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        profesionTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        consultarNomBtn = new javax.swing.JButton();

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

        consultarBtn.setText("Consultar Num Ase.");
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

        jLabel1.setText("numero asegurado");

        jLabel2.setText("nombre completo");

        jLabel3.setText("Direccion");

        jLabel4.setText("Edad");

        jLabel5.setText("Fecha Nacimiento");

        jLabel6.setText("Email");

        jLabel7.setText("Telefono");

        jLabel8.setText("Profesion");

        consultarNomBtn.setText("Consultar Nombre");
        consultarNomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarNomBtnActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numAseguradoTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(13, 13, 13)
                        .addComponent(nombreCompletoTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(59, 59, 59)
                        .addComponent(direccionTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(82, 82, 82)
                        .addComponent(emailTF))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(volverMenuBtn)
                            .addComponent(agregarBtn)
                            .addComponent(eliminarBtn)
                            .addComponent(modificarBtn)
                            .addComponent(listarTodosBtn)
                            .addComponent(consultarBtn)
                            .addComponent(consultarNomBtn))
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profesionTF)
                            .addComponent(telefonoTF)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edadTF)
                            .addComponent(fechaNacimientoTF))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numAseguradoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreCompletoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edadTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaNacimientoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(profesionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
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
                        .addComponent(consultarNomBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverMenuBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        // TODO add your handling code here:

        if (validarDatos()) {
            //crea obj profesor
            Paciente pac = new Paciente();
            String date = this.fechaNacimientoTF.getText();
            try {
                Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                pac.setFechaNacimiento(date1); //pendiente
            } catch (ParseException ex) {
                Logger.getLogger(MantPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }

            //popula al obj profesor con datos
            pac.setNumAsegurado(Integer.parseInt(this.numAseguradoTF.getText()));
            pac.setNombreCompleto(this.nombreCompletoTF.getText());
            pac.setDireccion(this.direccionTF.getText());
            pac.setEdad(Integer.parseInt(this.edadTF.getText()));

            pac.setEmail(this.emailTF.getText());
            pac.setTelefono(Integer.parseInt(this.telefonoTF.getText()));
            pac.setProfesion(this.profesionTF.getText());

            //inserta el obj profesor usando el metodo de profesorBo
            int res = this.pacienteBo.insertar(pac);

            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Paciente agregado correctamente.");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "No se pudo conectar a la BD.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Ya existe un paciente con ese numero de asegurado.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Ocurrio un error inesperado.");
                    break;
            }
        }
        limpiar();
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:

        if (this.numAseguradoTF.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ingrese un numero de Asegurado a eliminar");
        } else {
            try {
                int ced = Integer.parseInt(this.numAseguradoTF.getText());

                Paciente pac = new Paciente();

                int res = this.pacienteBo.eliminar(pac);

                switch (res) {
                    case 0:
                        JOptionPane.showMessageDialog(null,
                                "No se elimino ningun paciente");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                "Se elimino el profesor correctamente");
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
                JOptionPane.showMessageDialog(null, "solo se permiten numeros en el numero de asegurado");
            }
        }
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        // TODO add your handling code here:
        if (validarDatos()) {
            //crea obj profesor
            Paciente pac = new Paciente();

            //popula al obj profesor con datos
            pac.setNumAsegurado(Integer.parseInt(this.numAseguradoTF.getText()));
            pac.setNombreCompleto(this.nombreCompletoTF.getText());
            pac.setDireccion(this.direccionTF.getText());
            pac.setEdad(Integer.parseInt(this.edadTF.getText()));
            pac.setFechaNacimiento(new Date()); //pendiente
            pac.setEmail(this.emailTF.getText());
            pac.setTelefono(Integer.parseInt(this.telefonoTF.getText()));
            pac.setProfesion(this.profesionTF.getText());

            //inserta el obj profesor usando el metodo de profesorBo
            int res = this.pacienteBo.modificar(pac);

            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Paciente modificado correctamente.");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "No se pudo conectar a la BD.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Ya existe un paciente con ese numero de asegurado.");
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
        // TODO add your handling code here:
        List<Paciente> lista = pacienteBo.consultaTodos();
        llenarTabla(lista);
    }//GEN-LAST:event_listarTodosBtnActionPerformed

    private void consultarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBtnActionPerformed
        // TODO add your handling code here:
        if (this.numAseguradoTF.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el nombre a consultar");
        } else {
            List<Paciente> lista = pacienteBo.consultarPorNumAsegurado(numAseguradoTF.getText());
            llenarTabla(lista);
        }

    }//GEN-LAST:event_consultarBtnActionPerformed

    private void consultarNomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarNomBtnActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (this.nombreCompletoTF.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el nombre a consultar");
        } else {
            List<Paciente> lista = pacienteBo.consultarPorNombre(nombreCompletoTF.getText());
            llenarTabla(lista);
        }
    }//GEN-LAST:event_consultarNomBtnActionPerformed

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

            this.numAseguradoTF.setText(tabla.getValueAt(fila, 0).toString());
            this.nombreCompletoTF.setText(tabla.getValueAt(fila, 1).toString());
            this.direccionTF.setText(tabla.getValueAt(fila, 2).toString());
            this.edadTF.setText(tabla.getValueAt(fila, 3).toString());
            this.fechaNacimientoTF.setText(tabla.getValueAt(fila, 4).toString());
            this.emailTF.setText(tabla.getValueAt(fila, 5).toString());
            this.telefonoTF.setText(tabla.getValueAt(fila, 6).toString());
            this.profesionTF.setText(tabla.getValueAt(fila, 7).toString());

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
            java.util.logging.Logger.getLogger(MantPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JButton consultarBtn;
    private javax.swing.JButton consultarNomBtn;
    private javax.swing.JTextField direccionTF;
    private javax.swing.JTextField edadTF;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField fechaNacimientoTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listarTodosBtn;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTextField nombreCompletoTF;
    private javax.swing.JTextField numAseguradoTF;
    private javax.swing.JTextField profesionTF;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField telefonoTF;
    private javax.swing.JButton volverMenuBtn;
    // End of variables declaration//GEN-END:variables
}
