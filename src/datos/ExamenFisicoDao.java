/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import negocio.clases.ExamenFisico;

/**
 *
 * @author Danny
 */
public class ExamenFisicoDao {

    private Conexion conn;
    private PreparedStatement sentencia;

    public ExamenFisicoDao() {
        this.conn = new Conexion();
        this.sentencia = null;
    }

    public int eliminar(ExamenFisico examen) {
        try {
            if (conn.conectarse()) { //si se conecta a la DB
                //sentencia permite efectuar una sentencia en SQL
                //sentencia = conn.getConn().prepareStatement("insert into bibliotecaicai.profesor values (?,?,?,?)");
                sentencia = conn.getConn().prepareStatement("delete from simame.examen_fisico where codigo_examen  = ? ");

                sentencia.setInt(1, examen.getCodExamen());
                int res = sentencia.executeUpdate();
                conn.desconectarse();
                if (res == 0) {
                    return 0;
                    //se ejecuto la sentencia pero no se elimino nada
                } else {
                    return 1; //se eliminp bien el registo
                }
            } else {
                return 2; //no se conecto a la base de datos

            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            ex.printStackTrace();
            return 4; //algo extranno sucedio

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return 3; //algo extranno sucedio

        }

    }

    public int insertar(ExamenFisico elExa) {
        try {
            if (conn.conectarse()) { //si se logra la conexion con la BD

                //manda el comando SQL para insertar datos
                //sentencia = conn.getConn().prepareStatement("insert into bibliotecaicai.profesor values (?,?,?,?)");
                sentencia = conn.getConn().prepareStatement("insert into simame.examen_fisico values (?,?,?,?,?,?,?,?)");

                //especifica los datos que va a mandar el comando
                sentencia.setInt(1, elExa.getCodExamen());
                sentencia.setInt(2, elExa.getNumAsegurado());
                sentencia.setInt(3, elExa.getPeso());
                sentencia.setDouble(4, elExa.getAltura());
                sentencia.setString(5, elExa.getPresionArterial());
                sentencia.setDouble(6, elExa.getTemperatura());
                sentencia.setString(7, elExa.getEnfermedad());
                sentencia.setInt(8, elExa.getCedulaDoctor());

                //ejecuta la sentencia con los datos actualizados
                sentencia.executeUpdate();

                //se desconecta de la BD
                conn.desconectarse();
                return 0;// todo bien

            } else { //si no se logra la conexion con la base de datos
                return 1;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (sqle.getSQLState().startsWith("23")) {
                return 2; //llave PK duplicada
            } else {
                return 3; //error ejecutando el insert
            }
        }

    }

    public int modificar(ExamenFisico elExa) {
        try {
            if (conn.conectarse()) { //si se conecta a la DB
                //sentencia permite efectuar una sentencia en SQL
                //sentencia = conn.getConn().prepareStatement("insert into bibliotecaicai.profesor values (?,?,?,?)");
                sentencia = conn.getConn().prepareStatement("update simame.examen_fisico set num_asegurado = ?, peso = ?, altura = ?,"
                        + "presion_arterial = ?, temperatura = ?, enfermedad = ?, cedula_doctor = ? where codigo_examen = ?");

                //hay que tener cuidado con el orden de los atributos
                sentencia.setInt(1, elExa.getNumAsegurado());
                sentencia.setInt(2, elExa.getPeso());
                sentencia.setDouble(3, elExa.getAltura());
                sentencia.setString(4, elExa.getPresionArterial());
                sentencia.setDouble(5, elExa.getTemperatura());
                sentencia.setString(6, elExa.getEnfermedad());
                sentencia.setInt(7, elExa.getCedulaDoctor());
                sentencia.setInt(8, elExa.getCodExamen());

                //ejecuta la sentencia sql 
                sentencia.executeUpdate();
                conn.desconectarse();
                return 0; //todo bien
            } else {
                return 1; //no se conecto a la base de datos

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return 2; //algo sucedio
        }
    }

    public List<ExamenFisico> consultaTodos() {
        try {
            if (conn.conectarse()) { //si se conecta a la DB
                //selecciona todo de la tabla estudiante
                //sentencia = conn.getConn().prepareStatement("select * from bibliotecaicai.estudiante");
                sentencia = conn.getConn().prepareStatement("select * from simame.examen_fisico");
                List lista = new ArrayList();

                //guarda la tabla en resultado
                ResultSet resultado = sentencia.executeQuery();

                //mientras haya un resultado
                while (resultado.next()) {
                    //crea estudiante
                    ExamenFisico est = new ExamenFisico();

                    //anade atributos
                    est.setCodExamen(resultado.getInt(1));
                    est.setNumAsegurado(resultado.getInt(2));
                    est.setPeso(resultado.getInt(3));
                    est.setAltura(resultado.getDouble(4));
                    est.setPresionArterial(resultado.getString("presion_arterial"));
                    est.setTemperatura(resultado.getDouble(6));
                    est.setEnfermedad(resultado.getString("enfermedad"));
                    est.setCedulaDoctor(resultado.getInt(8));

                    //anade estudiante a la lista
                    lista.add(est);
                }
                //termina la conexion
                this.conn.desconectarse();
                //devuelve la lista
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<ExamenFisico> consultarPorCodigo(String codigo) {
        try {
            if (conn.conectarse()) {
                // sentencia = conn.getConn().prepareStatement("select * from bibliotecaicai.profesor");
                sentencia = conn.getConn().prepareStatement("select * from simame.examen_fisico where codigo_examen like ?");

                //son para decir q inicie o termine con la palabra q se busca 
                //basta con que contenga 
                sentencia.setString(1, "%" + codigo + "%");

                List lista = new ArrayList();
                ResultSet resultado = sentencia.executeQuery();
                while (resultado.next()) {
                    ExamenFisico examen = new ExamenFisico();
                    examen.setCodExamen(resultado.getInt(1));
                    examen.setNumAsegurado(resultado.getInt(2));
                    examen.setPeso(resultado.getInt(3));
                    examen.setAltura(resultado.getDouble(4));
                    examen.setPresionArterial(resultado.getString("presion_arterial"));
                    examen.setTemperatura(resultado.getDouble(6));
                    examen.setEnfermedad(resultado.getString("enfermedad"));
                    examen.setCedulaDoctor(resultado.getInt(7));

                    lista.add(examen);
                }
                this.conn.desconectarse();
                return lista;
            } else {
                return null; // retorna null si no se conecta
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ExamenFisico> consultarPorNumAsegurado(String num) {
        try {
            if (conn.conectarse()) {
                // sentencia = conn.getConn().prepareStatement("select * from bibliotecaicai.profesor");
                sentencia = conn.getConn().prepareStatement("select * from simame.examen_fisico where num_asegurado like ?");

                //son para decir q inicie o termine con la palabra q se busca 
                //basta con que contenga 
                sentencia.setString(1, "%" + num + "%");

                List lista = new ArrayList();
                ResultSet resultado = sentencia.executeQuery();
                while (resultado.next()) {
                    ExamenFisico examen = new ExamenFisico();
                    examen.setCodExamen(resultado.getInt(1));
                    examen.setNumAsegurado(resultado.getInt(2));
                    examen.setPeso(resultado.getInt(3));
                    examen.setAltura(resultado.getDouble(4));
                    examen.setPresionArterial(resultado.getString("presion_arterial"));
                    examen.setTemperatura(resultado.getDouble(6));
                    examen.setEnfermedad(resultado.getString("enfermedad"));
                    examen.setCedulaDoctor(resultado.getInt(7));

                    lista.add(examen);
                }
                this.conn.desconectarse();
                return lista;
            } else {
                return null; // retorna null si no se conecta
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }

    public PreparedStatement getSentencia() {
        return sentencia;
    }

    public void setSentencia(PreparedStatement sentencia) {
        this.sentencia = sentencia;
    }

}
