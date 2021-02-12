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
import negocio.clases.Salon;

/**
 *
 * @author Danny
 */
public class SalonDao {

    private Conexion conn;
    private PreparedStatement sentencia;

    public SalonDao() {
        this.conn = new Conexion();
        this.sentencia = null;
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

    public int eliminar(Salon sal) {
        try {
            if (conn.conectarse()) { //si se conecta a la DB
                sentencia = conn.getConn().prepareStatement("delete from simame.salon where num_salon  = ? ");

                sentencia.setInt(1, sal.getNumSalon());
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

    public int insertar(Salon elSal) {
        try {
            if (conn.conectarse()) { //si se logra la conexion con la BD

                sentencia = conn.getConn().prepareStatement("insert into simame.salon values (?,?,?,?)");

                //especifica los datos que va a mandar el comando
                sentencia.setInt(1, elSal.getNumSalon());
                sentencia.setInt(2, elSal.getCantCamas());
                sentencia.setString(3, elSal.getArea());
                sentencia.setInt(4, elSal.getCedulaDoctor());

                //ejecuta la sentencia con los datos actualizados
                sentencia.executeUpdate();

                //se desconecta de la BD
                conn.desconectarse();
                return 0;

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

    public int modificar(Salon elSal) {
        try {
            if (conn.conectarse()) { //si se conecta a la DB
                //sentencia permite efectuar una sentencia en SQL
                //sentencia = conn.getConn().prepareStatement("insert into bibliotecaicai.profesor values (?,?,?,?)");
                sentencia = conn.getConn().prepareStatement("update simame.salon set cant_camas = ?,"
                        + "area = ?, cedula_doctor= ? where num_salon = ?");

                //hay que tener cuidado con el orden de los atributos
                sentencia.setInt(1, elSal.getCantCamas());
                sentencia.setString(2, elSal.getArea());
                sentencia.setInt(3, elSal.getCedulaDoctor());
                sentencia.setInt(4, elSal.getNumSalon());
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

    public List<Salon> consultaTodos() {
        try {
            if (conn.conectarse()) { //si se conecta a la DB
                //selecciona todo de la tabla estudiante
                //sentencia = conn.getConn().prepareStatement("select * from bibliotecaicai.estudiante");
                sentencia = conn.getConn().prepareStatement("select * from simame.salon");
                List lista = new ArrayList();

                //guarda la tabla en resultado
                ResultSet resultado = sentencia.executeQuery();

                //mientras haya un resultado
                while (resultado.next()) {
                    //crea estudiante

                    Salon sal = new Salon();

                    //anade atributos
                    sal.setNumSalon(resultado.getInt(1));
                    sal.setCantCamas(resultado.getInt(2));
                    sal.setArea(resultado.getString("area"));
                    sal.setCedulaDoctor(resultado.getInt(4));

                    //anade estudiante a la lista
                    lista.add(sal);
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

    public List<Salon> consultarPorArea(String area) {
        try {
            if (conn.conectarse()) {
                // sentencia = conn.getConn().prepareStatement("select * from bibliotecaicai.profesor");
                sentencia = conn.getConn().prepareStatement("select * from simame.salon where area like ?");

                //son para decir q inicie o termine con la palabra q se busca 
                //basta con que contenga 
                sentencia.setString(1, "%" + area + "%");

                List lista = new ArrayList();
                ResultSet resultado = sentencia.executeQuery();
                while (resultado.next()) {
                    Salon sal = new Salon();

                    //anade atributos
                    sal.setNumSalon(resultado.getInt(1));
                    sal.setCantCamas(resultado.getInt(2));
                    sal.setArea(resultado.getString("area"));
                    sal.setCedulaDoctor(resultado.getInt(4));

                    //anade estudiante a la lista
                    lista.add(sal);
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

    public List<Salon> consultarPorNumSalon(String num) {
        try {
            if (conn.conectarse()) {
                // sentencia = conn.getConn().prepareStatement("select * from bibliotecaicai.profesor");
                sentencia = conn.getConn().prepareStatement("select * from simame.salon where num_salon like ?");

                //son para decir q inicie o termine con la palabra q se busca 
                //basta con que contenga 
                sentencia.setString(1, "%" + num + "%");

                List lista = new ArrayList();
                ResultSet resultado = sentencia.executeQuery();
                while (resultado.next()) {
                    Salon sal = new Salon();

                    //anade atributos
                    sal.setNumSalon(resultado.getInt(1));
                    sal.setCantCamas(resultado.getInt(2));
                    sal.setArea(resultado.getString("area"));
                    sal.setCedulaDoctor(resultado.getInt(4));

                    //anade estudiante a la lista
                    lista.add(sal);
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

}
