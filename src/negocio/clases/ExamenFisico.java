/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.clases;

/**
 *
 * @author Danny
 */
public class ExamenFisico {
    private Integer codExamen;
    private Integer numAsegurado;
    private Integer peso;
    private Double altura;
    private String presionArterial;
    private Double temperatura;
    private String enfermedad;
    private Integer cedulaDoctor; 

    public Integer getCodExamen() {
        return codExamen;
    }

    public void setCodExamen(Integer codExamen) {
        this.codExamen = codExamen;
    }

    public Integer getNumAsegurado() {
        return numAsegurado;
    }

    public void setNumAsegurado(Integer numAsegurado) {
        this.numAsegurado = numAsegurado;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Integer getCedulaDoctor() {
        return cedulaDoctor;
    }

    public void setCedulaDoctor(Integer cedulaDoctor) {
        this.cedulaDoctor = cedulaDoctor;
    }
    
    
}
