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
public class Staff extends Employee {
    private String id_staff;
    private String bidang;

    public Staff() {
    }

    public Staff(String id_staff, String nama, String jenisKelamin, String alamat,  String bidang) {
        super(nama, alamat, jenisKelamin);
        this.id_staff = id_staff;
        this.bidang = bidang;
    }

    public String getId_staff() {
        return id_staff;
    }

    public void setId_staff(String id_staff) {
        this.id_staff = id_staff;
    }

    public String getBidang() {
        return bidang;
    }

    public void setBidang(String bidang) {
        this.bidang = bidang;
    }
}

