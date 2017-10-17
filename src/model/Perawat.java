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
public class Perawat extends Employee {
    private String id_perawat;
    private String unit;

    public Perawat() {
    }

    public Perawat(String id_perawat, String nama, String jenisKelamin, String alamat, String unit) {
        super(nama, alamat, jenisKelamin);
        this.id_perawat = id_perawat;
        this.unit = unit;
    }
    
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }    

    public String getId_perawat() {
        return id_perawat;
    }

    public void setId_perawat(String id_perawat) {
        this.id_perawat = id_perawat;
    }
    
    
}
