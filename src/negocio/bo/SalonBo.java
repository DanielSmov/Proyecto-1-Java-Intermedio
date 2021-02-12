/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.bo;

import datos.SalonDao;
import java.util.List;
import negocio.clases.Salon;

/**
 *
 * @author Danny
 */
public class SalonBo {
    private SalonDao salonDao;
    
    public SalonBo(){
        this.salonDao = new SalonDao();
    }

    public SalonDao getSalonDao() {
        return salonDao;
    }

    public void setSalonDao(SalonDao salonDao) {
        this.salonDao = salonDao;
    }
    
    public int eliminar(Salon elSal){
        return salonDao.eliminar(elSal);
    }
    
    public int insertar(Salon elSal){
        return salonDao.insertar(elSal);
    }
    
    public int modificar(Salon elSal){
        return salonDao.modificar(elSal);
    }
    
    public List<Salon> consultaTodos(){
        return salonDao.consultaTodos();
    }
    
    public List<Salon> consultarPorArea(String area){
        return salonDao.consultarPorArea(area);
    }
    
    public List<Salon> consultaPorNumSalon(String num){
        return salonDao.consultarPorNumSalon(num);
    }
    
}
