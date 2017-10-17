/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lenovo ip 300
 */
public class Jadwal {
    
    private int idJadwal;
    private String idDokter;
    private String shift;
    private String hari;

    public Jadwal(int idJadwal, String idDokter, String hari, String shift) {
        this.idJadwal = idJadwal;
        //this.employee = employee;
        this.idDokter = idDokter;
        this.shift = shift;
        this.hari = hari;
    }
    
    public Jadwal(String idDokter, String hari, String shift) {
        //this.employee = employee;
        this.idDokter = idDokter;
        this.shift = shift;
        this.hari = hari;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }
    
}
