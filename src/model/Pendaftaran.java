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
public class Pendaftaran {
    
    private int idPendaftaran;
    private int idPasien;
    private int idJadwal;

    public Pendaftaran() {
    }

    public Pendaftaran(int idPendaftaran, int idPasien, int idJadwal) {
        this.idPendaftaran = idPendaftaran;
        this.idPasien = idPasien;
        this.idJadwal = idJadwal;
    }

    public Pendaftaran(int idPasien, int idJadwal) {
        this.idPasien = idPasien;
        this.idJadwal = idJadwal;
    }
    
    public int getIdPendaftaran() {
        return idPendaftaran;
    }

    public void setIdPendaftaran(int idPendataran) {
        this.idPendaftaran = idPendataran;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }
    
    
    
    
    
    
    
}
