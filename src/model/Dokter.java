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
public class Dokter extends Employee {
    private String id_dokter;
    private String spesialis;

    public Dokter() {
    }

    public Dokter(String id_dokter, String nama, String jenisKelamin, String alamat, String spesialis) {
        super(nama, alamat, jenisKelamin);
        this.id_dokter = id_dokter;
        this.spesialis = spesialis;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(String id_dokter) {
        this.id_dokter = id_dokter;
    }
}
