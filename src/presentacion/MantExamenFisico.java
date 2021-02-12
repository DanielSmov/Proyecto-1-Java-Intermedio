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
import negocio.bo.ExamenFisicoBo;
import negocio.bo.PacienteBo;
import negocio.clases.Doctor;
import negocio.clases.ExamenFisico;
import negocio.clases.Paciente;

/**
 *
 * @author Danny
 */
public class MantExamenFisico extends javax.swing.JFrame {

    /**
     * Creates new form MantExamenFisico
     */
    private ExamenFisicoBo examenBo;
    private DoctorBo doctorBo;
    private PacienteBo pacienteBo;
    private DefaultTableModel modelExamen;

    public MantExamenFisico() {
        initComponents();
        this.examenBo = new ExamenFisicoBo();
        this.modelExamen = new DefaultTableModel();
        this.doctorBo = new DoctorBo();
        this.pacienteBo = new PacienteBo();
        llenarTabla();
        this.llenaDoctor();
        this.llenaPaciente();
    }

    public void llenarTabla(List<ExamenFisico> listaExamen) {
        this.modelExamen = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.modelExamen.setColumnCount(0);
        this.modelExamen.addColumn("cod_examen");
        this.modelExamen.addColumn("num_asegurado");
        this.modelExamen.addColumn("peso");
        this.modelExamen.addColumn("altura");
        this.modelExamen.addColumn("presion_arterial");
        this.modelExamen.addColumn("temperatura");
        this.modelExamen.addColumn("enfermedad");
        this.modelExamen.addColumn("cedula_doctor");

        // List<ExamenFisico> listaExamen = this.examenBo.consultaTodos();
        if (listaExamen != null) {

            this.modelExamen.setNumRows(listaExamen.size());

            for (int i = 0; i < listaExamen.size(); i++) {
                ExamenFisico examen = listaExamen.get(i);

                modelExamen.setValueAt(examen.getCodExamen(), i, 0);
                modelExamen.setValueAt(examen.getNumAsegurado(), i, 1);
                modelExamen.setValueAt(examen.getPeso(), i, 2);
                modelExamen.setValueAt(examen.getAltura(), i, 3);
                modelExamen.setValueAt(examen.getPresionArterial(), i, 4);
                modelExamen.setValueAt(examen.getTemperatura(), i, 5);
                modelExamen.setValueAt(examen.getEnfermedad(), i, 6);
                modelExamen.setValueAt(examen.getCedulaDoctor(), i, 7);

            }

            //usa el obj recien creado para popular la tabla
            this.tabla.setModel(modelExamen);

        }

    }

    public void llenaDoctor() {
        List<Doctor> docs = this.doctorBo.consultaTodos();
        this.doctorCB.addItem("--seleccione--");
        for (Doctor doc : docs) {
            this.doctorCB.addItem(doc.getCedula() + "-" + doc.getNombre());
        }
    }
    
    public void llenaPaciente() {
        List<Paciente> pacs = this.pacienteBo.consultaTodos();
        this.pacienteCB.addItem("--seleccione--");
        for (Paciente pac : pacs) {
            this.pacienteCB.addItem(pac.getNumAsegurado() + "-" + pac.getNombreCompleto());
        }
    }

    public void llenarTabla() {
        this.modelExamen = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.modelExamen.setColumnCount(0);
        this.modelExamen.addColumn("cod_examen");
        this.modelExamen.addColumn("num_asegurado");
        this.modelExamen.addColumn("peso");
        this.modelExamen.addColumn("altura");
        this.modelExamen.addColumn("presion_arterial");
        this.modelExamen.addColumn("temperatura");
        this.modelExamen.addColumn("enfermedad");
        this.modelExamen.addColumn("cedula_doctor");

        List<ExamenFisico> listaExamen = this.examenBo.consultaTodos();
        if (listaExamen != null) {

            this.modelExamen.setNumRows(listaExamen.size());

            for (int i = 0; i < listaExamen.size(); i++) {
                ExamenFisico examen = listaExamen.get(i);

                modelExamen.setValueAt(examen.getCodExamen(), i, 0);
                modelExamen.setValueAt(examen.getNumAsegurado(), i, 1);
                modelExamen.setValueAt(examen.getPeso(), i, 2);
                modelExamen.setValueAt(examen.getAltura(), i, 3);
                modelExamen.setValueAt(examen.getPresionArterial(), i, 4);
                modelExamen.setValueAt(examen.getTemperatura(), i, 5);
                modelExamen.setValueAt(examen.getEnfermedad(), i, 6);
                modelExamen.setValueAt(examen.getCedulaDoctor(), i, 7);

            }

            //usa el obj recien creado para popular la tabla
            this.tabla.setModel(modelExamen);

        }

    }

    private boolean validarDatos() {
        boolean todoBien = true;

        //validacion para codExamen
        if (this.codigoExamenTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el codigo del examen.");
        } else {
            try {
                int num = Integer.parseInt(codigoExamenTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números en codigo de examen.");
            }
        }

        //validacion para Num Asegurado
//        if (this.numAseguradoTF.getText().trim().length() == 0) {
//            todoBien = false;
//            JOptionPane.showMessageDialog(null,
//                    "Digite el numero de asegurado.");
//        } else {
//            try {
//                int num = Integer.parseInt(numAseguradoTF.getText());
//            } catch (NumberFormatException nfe) {
//                todoBien = false;
//                JOptionPane.showMessageDialog(null,
//                        "Solo se permiten números en el numero de asegurado.");
//            }
//        }

        

        //validacion para peso
        if (this.pesoTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite el peso del paciente.");
        } else {
            try {
                int num = Integer.parseInt(pesoTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números el el peso.");
            }
        }

        //validacion para Altura
        if (this.alturaTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la altura del asegurado.");
        } else {
            try {
                double num = Double.parseDouble(alturaTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten decimales en la altura de asegurado.");
            }
        }

        //presionaArterial
        if (this.presionArterialTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la presion arterial del asegurado.");
        }

        //validacion para temperatura
        if (this.temperaturaTF.getText().trim().length() == 0) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la temperatura paciente.");
        } else {
            try {
                int num = Integer.parseInt(temperaturaTF.getText());
            } catch (NumberFormatException nfe) {
                todoBien = false;
                JOptionPane.showMessageDialog(null,
                        "Solo se permiten números la temperatura.");
            }
        }

        //validacion para enfermedad
        if (this.enfermedadTF.getText().trim().equals("")) {
            todoBien = false;
            JOptionPane.showMessageDialog(null,
                    "Digite la enfermedad del asegurado.");
        }

        //validacion para cedula doctor
//        if (this.cedulaDoctorTF.getText().trim().length() == 0) {
//            todoBien = false;
//            JOptionPane.showMessageDialog(null,
//                    "Digite la cedula del doctor.");
//        } else {
//            try {
//                int num = Integer.parseInt(temperaturaTF.getText());
//            } catch (NumberFormatException nfe) {
//                todoBien = false;
//                JOptionPane.showMessageDialog(null,
//                        "Solo se permiten números la cedula del doctor.");
//            }
//        }

        return todoBien;

    }

    public ExamenFisicoBo getExamenBo() {
        return examenBo;
    }

    public void setExamenBo(ExamenFisicoBo examenBo) {
        this.examenBo = examenBo;
    }

    public DefaultTableModel getModelExamen() {
        return modelExamen;
    }

    private void limpiar() {
        this.codigoExamenTF.setText("");
//        this.numAseguradoTF.setText("");
        this.pesoTF.setText("");
        this.alturaTF.setText("");
        this.presionArterialTF.setText("");
        this.temperaturaTF.setText("");
        this.enfermedadTF.setText("");
  //      this.cedulaDoctorTF.setText("");
        this.llenarTabla();

    }

    public void setModelExamen(DefaultTableModel modelExamen) {
        this.modelExamen = modelExamen;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        limpiarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        modificarBtn = new javax.swing.JButton();
        codigoExamenTF = new javax.swing.JTextField();
        listarTodosBtn = new javax.swing.JButton();
        numAseguradoTF = new javax.swing.JTextField();
        consultarBtn = new javax.swing.JButton();
        pesoTF = new javax.swing.JTextField();
        volverMenuBtn = new javax.swing.JButton();
        alturaTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        presionArterialTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        temperaturaTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        enfermedadTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        agregarBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        consultarCodigoBtn = new javax.swing.JButton();
        doctorCB = new javax.swing.JComboBox<>();
        pacienteCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("Tempreatura");

        limpiarBtn.setText("Limpiar");
        limpiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Enfermedad");

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

        consultarBtn.setText("Consultar por Numero Ase.");
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

        jLabel1.setText("Codigo Examen");

        jLabel2.setText("Numero Asegurado");

        jLabel3.setText("Peso");

        jLabel4.setText("Altura");

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

        jLabel5.setText("Presion Arterial");

        agregarBtn.setText("Agregar");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Cedula Doctor");

        consultarCodigoBtn.setText("Consultar por Codigo");
        consultarCodigoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarCodigoBtnActionPerformed(evt);
            }
        });

        doctorCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorCBActionPerformed(evt);
            }
        });

        pacienteCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacienteCBActionPerformed(evt);
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
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temperaturaTF, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                            .addComponent(presionArterialTF)
                            .addComponent(alturaTF)
                            .addComponent(enfermedadTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pesoTF)
                            .addComponent(codigoExamenTF)
                            .addComponent(doctorCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pacienteCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(consultarBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numAseguradoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(volverMenuBtn)
                                    .addComponent(agregarBtn)
                                    .addComponent(eliminarBtn)
                                    .addComponent(modificarBtn)
                                    .addComponent(limpiarBtn)
                                    .addComponent(consultarCodigoBtn)
                                    .addComponent(listarTodosBtn))
                                .addGap(74, 74, 74)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoExamenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pacienteCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alturaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(presionArterialTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(temperaturaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(enfermedadTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doctorCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(consultarBtn)
                            .addComponent(numAseguradoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(consultarCodigoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpiarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(volverMenuBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBtnActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_limpiarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:

        if (this.codigoExamenTF.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ingrese un codigo a eliminar");
        } else {
            try {
                int cod = Integer.parseInt(this.codigoExamenTF.getText());

                ExamenFisico examen = new ExamenFisico();
                examen.setCodExamen(cod);

                int res = this.examenBo.eliminar(examen);

                switch (res) {
                    case 0:
                        JOptionPane.showMessageDialog(null,
                                "No se elimino ningun examen");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                "Se elimino el examen correctamente");
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
            //se crea un obj tipo doctor
            //se crea un obj tipo doctor
            ExamenFisico examen = new ExamenFisico();

             
            String doc = this.doctorCB.getSelectedItem().toString();
            String[] partesDoc = doc.split("-");
            examen.setCedulaDoctor(Integer.parseInt(partesDoc[0]));
            
            
            String pac = this.pacienteCB.getSelectedItem().toString();
            String[] partesPac = pac.split("-");
            examen.setNumAsegurado(Integer.parseInt(partesPac[0]));
           
            
            //se parsea de string al dato adecuado
            examen.setCodExamen(Integer.parseInt(this.codigoExamenTF.getText()));
            //examen.setNumAsegurado(Integer.parseInt(this.numAseguradoTF.getText()));
            examen.setPeso(Integer.parseInt(this.pesoTF.getText()));
            examen.setAltura(Double.parseDouble(this.alturaTF.getText()));
            examen.setPresionArterial(this.presionArterialTF.getText());
            examen.setTemperatura(Double.parseDouble(this.temperaturaTF.getText()));
            examen.setEnfermedad(this.enfermedadTF.getText());
            //examen.setCedulaDoctor(Integer.parseInt(this.cedulaDoctorTF.getText()));

            int res = this.examenBo.modificar(examen);

            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Examen modificado correctamente.");
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
                            "Ocurrio un error inesperado .");
                    break;

            }
        }
        limpiar();
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void listarTodosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarTodosBtnActionPerformed
        // TODO add your handling code here:
        List<ExamenFisico> lista = examenBo.consultaTodos();
        llenarTabla(lista);
    }//GEN-LAST:event_listarTodosBtnActionPerformed

    private void consultarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBtnActionPerformed
        // TODO add your handling code here:
        if (this.numAseguradoTF.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el numero de asegurado a consultar");
        } else {
            List<ExamenFisico> lista = examenBo.consultaPorNumAsegurado(numAseguradoTF.getText());
            llenarTabla(lista);
        }
    }//GEN-LAST:event_consultarBtnActionPerformed

    private void volverMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuBtnActionPerformed
        Inicio ini = new Inicio();
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverMenuBtnActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila = tabla.getSelectedRow();

            this.codigoExamenTF.setText(this.tabla.getValueAt(fila, 0).toString());
           // this.numAseguradoTF.setText(this.tabla.getValueAt(fila, 1).toString());
            this.pesoTF.setText(this.tabla.getValueAt(fila, 2).toString());
            this.alturaTF.setText(this.tabla.getValueAt(fila, 3).toString());
            this.presionArterialTF.setText(this.tabla.getValueAt(fila, 4).toString());
            this.temperaturaTF.setText(this.tabla.getValueAt(fila, 5).toString());
            this.enfermedadTF.setText(this.tabla.getValueAt(fila, 6).toString());
            //this.cedulaDoctorTF.setText(this.tabla.getValueAt(fila, 7).toString());

        }
    }//GEN-LAST:event_tablaMouseClicked

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        // TODO add your handling code here:

        //validar datos
        if (validarDatos()) {
            //se crea un obj tipo doctor
            ExamenFisico examen = new ExamenFisico();

            
            String doc = this.doctorCB.getSelectedItem().toString();
            String[] partesDoc = doc.split("-");
            examen.setCedulaDoctor(Integer.parseInt(partesDoc[0]));
            
            
            String pac = this.pacienteCB.getSelectedItem().toString();
            String[] partesPac = pac.split("-");
            examen.setNumAsegurado(Integer.parseInt(partesPac[0]));
            
            
            //se parsea de string al dato adecuado
            examen.setCodExamen(Integer.parseInt(this.codigoExamenTF.getText()));
            //examen.setNumAsegurado(Integer.parseInt(this.numAseguradoTF.getText()));
            examen.setPeso(Integer.parseInt(this.pesoTF.getText()));
            examen.setAltura(Double.parseDouble(this.alturaTF.getText()));
            examen.setPresionArterial(this.presionArterialTF.getText());
            examen.setTemperatura(Double.parseDouble(this.temperaturaTF.getText()));
            examen.setEnfermedad(this.enfermedadTF.getText());
            //examen.setCedulaDoctor(Integer.parseInt(this.cedulaDoctorTF.getText()));

            int res = this.examenBo.insertar(examen);

            switch (res) {
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Examen Fiscio agregado correctamente.");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "No se pudo conectar a la BD.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Ya existe un examen fisico con ese codigo.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Ocurrio un error inesperado.");
                    break;
            }
        }
        limpiar();
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void consultarCodigoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarCodigoBtnActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (this.codigoExamenTF.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el codigo de examen a consultar");
        } else {
            List<ExamenFisico> lista = examenBo.consultaPorCodigo(codigoExamenTF.getText());
            llenarTabla(lista);
        }
    }//GEN-LAST:event_consultarCodigoBtnActionPerformed

    private void doctorCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorCBActionPerformed

    private void pacienteCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacienteCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pacienteCBActionPerformed

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
            java.util.logging.Logger.getLogger(MantExamenFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantExamenFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantExamenFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantExamenFisico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantExamenFisico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JTextField alturaTF;
    private javax.swing.JTextField codigoExamenTF;
    private javax.swing.JButton consultarBtn;
    private javax.swing.JButton consultarCodigoBtn;
    private javax.swing.JComboBox<String> doctorCB;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JTextField enfermedadTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarBtn;
    private javax.swing.JButton listarTodosBtn;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTextField numAseguradoTF;
    private javax.swing.JComboBox<String> pacienteCB;
    private javax.swing.JTextField pesoTF;
    private javax.swing.JTextField presionArterialTF;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField temperaturaTF;
    private javax.swing.JButton volverMenuBtn;
    // End of variables declaration//GEN-END:variables
}
