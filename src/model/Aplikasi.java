/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Database;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import controller.*;

/**
 *
 * @author Fakhri Fauzan
 */
public class Aplikasi {
    private ArrayList<Dokter> dataDokter;
    private ArrayList<Perawat> dataPerawat;
    private ArrayList<Staff> dataStaff;
    private ArrayList<Pasien> dataPasien;
    private ArrayList<Jadwal> dataJadwal;
    private ArrayList<Pendaftaran> dataPendaftaran;
//    private ArrayList<String> listDokter;
//    private ArrayList<String> listJadwal;
//    private ArrayList<String> listPasien;
//    private ArrayList<String> listPendaftaran;
    private Database connection;

    public Aplikasi() {
        this.dataDokter = new ArrayList<>();
        this.dataPerawat = new ArrayList<>();
        this.dataStaff = new ArrayList<>();
        this.dataPasien = new ArrayList<>();
        this.dataJadwal = new ArrayList<>();
//        this.listDokter = new ArrayList<>();
        this.dataPendaftaran = new ArrayList<>();
        this.connection = new Database();
        try {
            connection.connect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    //DOKTER
    public String createDokter(String id, String nama, String gender, String alamat, String spesialis){
        Dokter d = new Dokter(id, nama, gender, alamat, spesialis);
        try {
            dataDokter.add(d);
            connection.createDokter(d);
        } catch (SQLException e) {
        }
        return d.getId_dokter();
    }
    
    public ArrayList<Dokter> getAllDokter() throws SQLException{
        return connection.getAllDokter();
    }
    
    public Dokter getDokter(String idD) throws SQLException {
        Dokter d = connection.getDokter(idD);
        return d;
    }
    
    public void updateDokter(Dokter d){
        try {
            connection.updateDokter(d);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delDokter(String idDokter) throws SQLException {
        connection.DelDokter(idDokter);
    }
    
    //PERAWAT
    public String createPerawat(String id, String nama, String gender, String alamat, String unit){
        Perawat p = new Perawat(id, nama, gender, alamat, unit);
        try {
            dataPerawat.add(p);
            connection.createPerawat(p);
        } catch (SQLException e) {
        }
        return p.getId_perawat();
    }
    
    public ArrayList<Perawat> getAllPerawat() throws SQLException{
        return connection.getAllPerawat();
    }
    
    public Perawat getPerawat(String idP) throws SQLException {
        Perawat p = connection.getPerawat(idP);
        return p;
    }
    
    public void updatePerawat(Perawat p){
        try {
            connection.updatePerawat(p);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delPerawat(String idPerawat) throws SQLException {
        connection.DelPerawat(idPerawat);
    }
    
    //STAFF
    public String createStaff(String id, String nama, String gender, String alamat, String bidang){
        Staff s = new Staff(id, nama, gender, alamat, bidang);
        try {
            dataStaff.add(s);
            connection.createStaff(s);
        } catch (SQLException e) {
        }
        return s.getId_staff();
    }
    
    public ArrayList<Staff> getAllStaff() throws SQLException{
        return connection.getAllStaff();
    }
    
    public Staff getStaff(String idS) throws SQLException {
        Staff s = connection.getStaff(idS);
        return s;
    }
    
    public void updateStaff(Staff s){
        try {
            connection.updateStaff(s);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delStaff(String idStaff) throws SQLException {
        connection.DelStaff(idStaff);
    }
    
    //PASIEN
    public int createPasien(int id, String nama, String gender, String alamat, String tglLahir){
        Pasien p = new Pasien(id, nama, gender, alamat, tglLahir);
        try {
            dataPasien.add(p);
            connection.createPasien(p);
        } catch (SQLException e) {
        }
        return p.getIdPasien();
    }
    
    public ArrayList<Pasien> getAllPasien() throws SQLException{
        return connection.getAllPasien();
    }
    
    public Pasien getPasien(int idP) throws SQLException {
        Pasien p = connection.getPasien(idP);
        return p;
    }
    
    public void updatePasien(Pasien p){
        try {
            connection.updatePasien(p);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delPasien(int idPasien) throws SQLException {
        connection.DelPasien(idPasien);
    }
    
    //JADWAL
    public int createJadwal(String idDokter, String hari, String shift){
        Jadwal j = new Jadwal(idDokter, hari, shift);
        try {
            dataJadwal.add(j);
            connection.createJadwal(j);
        } catch (SQLException e) {
        }
        return j.getIdJadwal();
    }
    
    public ArrayList<Jadwal> getAllJadwal() throws SQLException{
        return connection.getAllJadwal();
    }
    
    public Jadwal getJadwal(int idJ) throws SQLException {
        Jadwal j = connection.getJadwal(idJ);
        return j;
    }
    
    public void updateJadwal(Jadwal j){
        try {
            connection.updateJadwal(j);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delJadwal(int idJadwal) throws SQLException {
        connection.DelJadwal(idJadwal);
    }
    
    //PENDAFTARAN
    public int createPendaftaran(int idPasien, int idJadwal){
        Pendaftaran p = new Pendaftaran(idPasien, idJadwal);
        try {
            dataPendaftaran.add(p);
            connection.createPendaftaran(p);
        } catch (SQLException e) {
        }
        return p.getIdPendaftaran();
    }
    
    public ArrayList<Pendaftaran> getAllPendaftaran() throws SQLException{
        return connection.getAllPendaftaran();
    }
    
    public Pendaftaran getPendaftaran(int idP) throws SQLException {
        Pendaftaran p = connection.getPendaftaran(idP);
        return p;
    }
    
    public void updatePendaftaran(Pendaftaran p){
        try {
            connection.updatePendaftaran(p);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delPendaftaran(int idPendaftaran) throws SQLException {
        connection.DelPendaftaran(idPendaftaran);
    }
    
    //MAIN
    public static void main(String[] args) throws SQLException {
        Aplikasi model = new Aplikasi();
        new ControllerLogin(model);
    }

    
    
}
