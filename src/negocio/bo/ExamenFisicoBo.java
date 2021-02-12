/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.bo;

import datos.ExamenFisicoDao;
import java.util.List;
import negocio.clases.ExamenFisico;

/**
 *
 * @author Danny
 */
public class ExamenFisicoBo {

    private ExamenFisicoDao examenFisicoDao;

    public ExamenFisicoBo() {
        this.examenFisicoDao = new ExamenFisicoDao();
    }

    public int eliminar(ExamenFisico examen) {
        return this.examenFisicoDao.eliminar(examen);
    }

    public int insertar(ExamenFisico examen) {
        return this.examenFisicoDao.insertar(examen);
    }

    public int modificar(ExamenFisico examen) {
        return this.examenFisicoDao.modificar(examen);
    }

    public List<ExamenFisico> consultaTodos() {
        return examenFisicoDao.consultaTodos();
    }
    
    public List<ExamenFisico> consultaPorCodigo(String codigo) {
        return examenFisicoDao.consultarPorCodigo(codigo);
    }
    
    public List<ExamenFisico> consultaPorNumAsegurado(String num) {
        return examenFisicoDao.consultarPorNumAsegurado(num);
    }

    public ExamenFisicoDao getExamenFisicoDao() {
        return examenFisicoDao;
    }

    public void setExamenFisicoDao(ExamenFisicoDao examenFisicoDao) {
        this.examenFisicoDao = examenFisicoDao;
    }

}
