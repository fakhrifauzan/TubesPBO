/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import database.Database;
import model.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import view.*;

/**
 *
 * @author Fakhri Fauzan
 */
public class Controller extends MouseAdapter implements ActionListener, FocusListener {
    private ViewDashboard viewDashboard;
    private Aplikasi model;
    private Database connection;
    private Statement statement;
    private String query;
    private ResultSet resultSet;

    public Controller(Aplikasi model) throws SQLException {
        this.model = model;
        viewDashboard = new ViewDashboard();
        viewDashboard.setVisible(true);
        viewDashboard.setLocationRelativeTo(null);
        viewDashboard.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        //DOKTER
        if(source.equals(viewDashboard.getBtnAddDokter())){
            String idDokter = viewDashboard.getTxtIdDokter();
            String namaDokter = viewDashboard.getTxtNamaDokter();
            String jkDokter = viewDashboard.getCmbGender();
            String alamatDokter = viewDashboard.getTxtAlamatDokter();
//            int umur = Integer.parseInt(view.getTxtUmurPelanggan());
            String spesialis = viewDashboard.getCmbSpesialis();  

            model.createDokter(idDokter, namaDokter, jkDokter, alamatDokter, spesialis);
            //REALTIME MODE
            try {
                viewDashboard.viewDokter(model.getAllDokter());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        
        if (source.equals(viewDashboard.getBtnRefreshDokter())) {
            try {
                viewDashboard.viewDokter(model.getAllDokter());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnDeleteDokter())){
            try {
                String id = viewDashboard.getTxtDeleteIdDokter().getText();
                model.delDokter(id);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data tidak ada");
            }
        }
        
        if(source.equals(viewDashboard.getBtnCariDokterEdit())){
            try {
                String id = viewDashboard.getTxtIdDokterEdit().getText();
                if(model.getDokter(id)==null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else {
                    //viewDashboard.showMessage(null, "Data ditemukan");
                    Dokter d = model.getDokter(id);
                    viewDashboard.setTxtNamaDokterEdit(d.getNama());
                    viewDashboard.setTxtAlamatDokterEdit(d.getAlamat());
                    viewDashboard.setCmbGenderDokterEdit(d.getJenisKelamin());
                    viewDashboard.setCmbSpesialisEdit(d.getSpesialis());
                }
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        if (source.equals(viewDashboard.getBtnUpdateDokter())) {
            String id = viewDashboard.getTxtIdDokterEdit().getText();
            try {
                if (model.getDokter(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else{
                    String nama = viewDashboard.getTxtNamaDokterEdit().getText();
                    String gender = viewDashboard.getCmbGenderDokterEdit();
                    String alamat = viewDashboard.getTxtAlamatDokterEdit().getText();
                    String spesialis = viewDashboard.getCmbSpesialisEdit();
                    Dokter d = new Dokter(id, nama, gender, alamat, spesialis);
                    model.updateDokter(d);
                    viewDashboard.showMessage(null, "Edit Berhasil");
                }
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        //PERAWAT
        if(source.equals(viewDashboard.getBtnAddPerawat())){
            String idPerawat = viewDashboard.getTxtIdPerawat().getText();
            String namaPerawat = viewDashboard.getTxtNamaPerawat().getText();
            String jkPerawat = viewDashboard.getCmbGenderPerawat().getSelectedItem().toString();
            String alamatPerawat = viewDashboard.getTxtAlamatPerawat().getText();
//            int umur = Integer.parseInt(view.getTxtUmurPelanggan());
            String unit = viewDashboard.getCmbUnit().getSelectedItem().toString();

            model.createPerawat(idPerawat, namaPerawat, jkPerawat, alamatPerawat, unit);
            //REALTIME MODE
            try {
                viewDashboard.viewPerawat(model.getAllPerawat());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        
        if (source.equals(viewDashboard.getBtnRefreshPerawat())) {
            try {
                viewDashboard.viewPerawat(model.getAllPerawat());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnDeletePerawat())){
            try {
                String id = viewDashboard.getTxtDeleteIdPerawat().getText();
                if(model.getPerawat(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ditemukan");
                else {
                    model.delPerawat(id);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data tidak ada");
            }
        }

        if(source.equals(viewDashboard.getBtnCariPerawatEdit())){
            try {
                String id = viewDashboard.getTxtIdPerawatEdit().getText();
                if(model.getPerawat(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else {
//                    viewDashboard.showMessage(null, "Data ditemukan");
                    Perawat p = model.getPerawat(id);
                    viewDashboard.setTxtNamaPerawatEdit(p.getNama());
                    viewDashboard.setTxtAlamatPerawatEdit(p.getAlamat());
                    viewDashboard.setCmbGenderPerawatEdit(p.getJenisKelamin());
                    viewDashboard.setCmbUnitEdit(p.getUnit());
                }
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        if (source.equals(viewDashboard.getBtnUpdatePerawat())) {
            String id = viewDashboard.getTxtIdPerawatEdit().getText();
            try {
                if (model.getPerawat(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else{
                    String nama = viewDashboard.getTxtNamaPerawatEdit().getText();
                    String gender = viewDashboard.getCmbGenderPerawatEdit().getSelectedItem().toString();
                    String alamat = viewDashboard.getTxtAlamatPerawatEdit().getText();
                    String unit = viewDashboard.getCmbUnitEdit().getSelectedItem().toString();
                    Perawat p = new Perawat(id, nama, gender, alamat, unit);
                    model.updatePerawat(p);
                    viewDashboard.showMessage(null, "Edit Berhasil");
                }
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        //STAFF
        if(source.equals(viewDashboard.getBtnAddStaff())){
            String idStaff = viewDashboard.getTxtIdStaff().getText();
            String namaStaff = viewDashboard.getTxtNamaStaff().getText();
            String jkStaff = viewDashboard.getCmbGenderStaff().getSelectedItem().toString();
            String alamatStaff = viewDashboard.getTxtAlamatStaff().getText();
//            int umur = Integer.parseInt(view.getTxtUmurPelanggan());
            String bidang = viewDashboard.getCmbBidang().getSelectedItem().toString();

            model.createStaff(idStaff, namaStaff, jkStaff, alamatStaff, bidang);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        
        if (source.equals(viewDashboard.getBtnRefreshStaff())) {
            try {
                viewDashboard.viewStaff(model.getAllStaff());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnDeleteStaff())){
            try {
                String id = viewDashboard.getTxtDeleteIdStaff().getText();
                if(model.getStaff(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ditemukan");
                else {
                    model.delStaff(id);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data tidak ada");
            }
        }

        if(source.equals(viewDashboard.getBtnCariStaffEdit())){
            try {
                String id = viewDashboard.getTxtIdStaffEdit().getText();
                if(model.getStaff(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else {
//                    viewDashboard.showMessage(null, "Data ditemukan");
                    Staff s = model.getStaff(id);
                    viewDashboard.setTxtNamaStaffEdit(s.getNama());
                    viewDashboard.setTxtAlamatStaffEdit(s.getAlamat());
                    viewDashboard.setCmbGenderStaffEdit(s.getJenisKelamin());
                    viewDashboard.setCmbBidangEdit(s.getBidang());
                }
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        if (source.equals(viewDashboard.getBtnUpdateStaff())) {
            String id = viewDashboard.getTxtIdStaffEdit().getText();
            try {
                if (model.getStaff(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else{
                    String nama = viewDashboard.getTxtNamaStaffEdit().getText();
                    String gender = viewDashboard.getCmbGenderStaffEdit().getSelectedItem().toString();
                    String alamat = viewDashboard.getTxtAlamatStaffEdit().getText();
                    String bidang = viewDashboard.getCmbBidangEdit().getSelectedItem().toString();
                    Staff s = new Staff(id, nama, gender, alamat, bidang);
                    model.updateStaff(s);
                    viewDashboard.showMessage(null, "Edit Berhasil");
                }
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        //PASIEN
        if(source.equals(viewDashboard.getBtnAddPasien())){
            int idPasien = Integer.parseInt(viewDashboard.getTxtIdPasien().getText());
            String namaPasien = viewDashboard.getTxtNamaPasien().getText();
            String jkPasien = viewDashboard.getCmbGenderPasien().getSelectedItem().toString();
            String alamatPasien = viewDashboard.getTxtAlamatPasien().getText();
            String tglLahir = viewDashboard.getTxtTglLahir().getText();

            model.createPasien(idPasien, namaPasien, jkPasien, alamatPasien, tglLahir);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        
        if (source.equals(viewDashboard.getBtnRefreshPasien())) {
            try {
                viewDashboard.viewPasien(model.getAllPasien());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnDeletePasien())){
            try {
                int id = Integer.parseInt(viewDashboard.getTxtDeleteIdPasien().getText());
                if(model.getPasien(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ditemukan");
                else {
                    model.delPasien(id);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data tidak ada");
            }
        }

        if(source.equals(viewDashboard.getBtnCariPasienEdit())){
            try {
                int id = Integer.parseInt(viewDashboard.getTxtIdPasienEdit().getText());
                if(model.getPasien(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else
                    viewDashboard.showMessage(null, "Data ditemukan");
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        if (source.equals(viewDashboard.getBtnUpdatePasien())) {
            int id = Integer.parseInt(viewDashboard.getTxtIdPasienEdit().getText());
            try {
                if (model.getPasien(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else{
                    String nama = viewDashboard.getTxtNamaPasienEdit().getText();
                    String gender = viewDashboard.getCmbGenderPasienEdit().getSelectedItem().toString();
                    String alamat = viewDashboard.getTxtAlamatPasienEdit().getText();
                    String tglLahir = viewDashboard.getTxtTglLahirEdit().getText();
                    Pasien p = new Pasien(id, nama, gender, alamat, tglLahir);
                    model.updatePasien(p);
                    viewDashboard.showMessage(null, "Edit Berhasil");
                }
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        //JADWAL
        if (source.equals(viewDashboard.getBtnRefreshDataDokter())) {
            try {
                viewDashboard.listDokter(model.getAllDokter());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnRefreshDataJadwal())) {
            try {
                viewDashboard.listJadwal(model.getAllJadwal());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnRefreshJadwal())) {
            try {
                viewDashboard.viewJadwal(model.getAllJadwal());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if(source.equals(viewDashboard.getBtnCekInfoDokter())){
            try {
                String id = viewDashboard.getCmbDataDokter().getSelectedItem().toString();
                if(model.getDokter(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else {
                    Dokter d = model.getDokter(id);
                    viewDashboard.showMessage(null, "Nama : " + d.getNama() + " | Spesialis : " + d.getSpesialis());
                }                    
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        if(source.equals(viewDashboard.getBtnAddJadwal())){
            String idDokter = viewDashboard.getCmbDataDokter().getSelectedItem().toString();
            String hari = viewDashboard.getCmbHari().getSelectedItem().toString();
            String shift = viewDashboard.getCmbShift().getSelectedItem().toString();

            model.createJadwal(idDokter, hari, shift);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        
        if (source.equals(viewDashboard.getBtnDeleteJadwal())){
            try {
                int id = Integer.parseInt(viewDashboard.getTxtDeleteIdJadwal().getText());
                if(model.getJadwal(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ditemukan");
                else {
                    model.delJadwal(id);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data tidak ada");
            }
        }

        if(source.equals(viewDashboard.getBtnCekInfoJadwal())){
            try {
                int id = Integer.parseInt(viewDashboard.getCmbDataJadwal().getSelectedItem().toString());
                if(model.getJadwal(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else {
                    Jadwal j = model.getJadwal(id);
                    viewDashboard.showMessage(null, "ID Dokter : " + j.getIdDokter() + " | Hari : " + j.getHari() + " | Shift : " + j.getShift());
                }                    
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        if (source.equals(viewDashboard.getBtnUpdateJadwal())) {
            int id = Integer.parseInt(viewDashboard.getCmbDataJadwal().getSelectedItem().toString());
            try {
                if (model.getJadwal(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else{
                    Jadwal js = model.getJadwal(id);
                    String idDokter = js.getIdDokter();
                    String hari = viewDashboard.getCmbHariEdit().getSelectedItem().toString();
                    String shift = viewDashboard.getCmbShiftEdit().getSelectedItem().toString();
                    Jadwal j = new Jadwal(id, idDokter, hari, shift);
                    model.updateJadwal(j);
                    viewDashboard.showMessage(null, "Edit Berhasil");
                }
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        //PENDAFTARAN
        if (source.equals(viewDashboard.getBtnRefreshDataJadwalPendaftaran())) {
            try {
                viewDashboard.listJadwalPendaftaran(model.getAllJadwal());
                viewDashboard.listPasienPendaftaran(model.getAllPasien());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnRefreshDataJadwalPendaftaranEdit())) {
            try {
                viewDashboard.listJadwalPendaftaranEdit(model.getAllJadwal());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnRefreshDataPasienPendaftaran())) {
            try {
                viewDashboard.listPasienPendaftaran(model.getAllPasien());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnRefreshDataPasienPendaftaranEdit())) {
            try {
                viewDashboard.listPasienPendaftaranEdit(model.getAllPasien());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnRefreshDataPendaftaranEdit())) {
            try {
                viewDashboard.listPendaftaranEdit(model.getAllPendaftaran());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (source.equals(viewDashboard.getBtnRefreshPendaftaran())) {
            try {
                viewDashboard.viewPendaftaran(model.getAllPendaftaran());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if(source.equals(viewDashboard.getBtnCekInfoJadwalPendaftaran())){
            try {
                int id = Integer.parseInt(viewDashboard.getCmbDataJadwalPendaftaran().getSelectedItem().toString());
                if(model.getJadwal(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else {
                    Jadwal j = model.getJadwal(id);
                    viewDashboard.showMessage(null, "ID : " + j.getIdJadwal() + " | ID Dokter : " + j.getIdDokter() + " | Shift : " + j.getShift());
                }                    
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        if(source.equals(viewDashboard.getBtnCekInfoPendaftaranEdit())){
            try {
                int id = Integer.parseInt(viewDashboard.getCmbDataPendaftaranEdit().getSelectedItem().toString());
                if(model.getPendaftaran(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else {
                    Pendaftaran p = model.getPendaftaran(id);
                    viewDashboard.showMessage(null, "ID Pendaftaran : " + p.getIdPendaftaran() + " | ID Pasien : " + p.getIdPasien() + " | ID Jadwal : " + p.getIdJadwal());
                }                    
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        if(source.equals(viewDashboard.getBtnCekInfoJadwalPendaftaranEdit())){
            try {
                int id = Integer.parseInt(viewDashboard.getCmbDataJadwalPendaftaranEdit().getSelectedItem().toString());
                if(model.getJadwal(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else {
                    Jadwal j = model.getJadwal(id);
                    viewDashboard.showMessage(null, "ID : " + j.getIdJadwal() + " | ID Dokter : " + j.getIdDokter() + " | Shift : " + j.getShift());
                }                    
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        if(source.equals(viewDashboard.getBtnCekInfoPasienPendaftaran())){
            try {
                int id = Integer.parseInt(viewDashboard.getCmbDataPasienPendaftaran().getSelectedItem().toString());
                if(model.getPasien(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else {
                    Pasien p = model.getPasien(id);
                    viewDashboard.showMessage(null, "ID : " + p.getIdPasien() + " | Nama : " + p.getNama() + " | Gender : " + p.getJenisKelamin());
                }                    
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
        
        if(source.equals(viewDashboard.getBtnAddPendaftaran())){
            int idJadwal = Integer.parseInt(viewDashboard.getCmbDataJadwalPendaftaran().getSelectedItem().toString());
            int idPasien = Integer.parseInt(viewDashboard.getCmbDataPasienPendaftaran().getSelectedItem().toString());

            model.createPendaftaran(idPasien, idJadwal);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        
        if (source.equals(viewDashboard.getBtnDeletePendaftaran())){
            try {
                int id = Integer.parseInt(viewDashboard.getTxtDeleteIdPendaftaran().getText());
                if(model.getPendaftaran(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ditemukan");
                else {
                    model.delPendaftaran(id);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data tidak ada");
            }
        }

        if (source.equals(viewDashboard.getBtnUpdatePendaftaran())) {
            int id = Integer.parseInt(viewDashboard.getCmbDataPendaftaranEdit().getSelectedItem().toString());
            try {
                if (model.getPendaftaran(id) == null)
                    viewDashboard.showMessage(null, "Data tidak ada");
                else{
                    int idPendaftaran = Integer.parseInt(viewDashboard.getCmbDataPendaftaranEdit().getSelectedItem().toString());
                    int idPasien = Integer.parseInt(viewDashboard.getCmbDataPasienPendaftaranEdit().getSelectedItem().toString());
                    int idJadwal = Integer.parseInt(viewDashboard.getCmbDataJadwalPendaftaranEdit().getSelectedItem().toString());
                    Pendaftaran p = new Pendaftaran(idPendaftaran, idPasien, idJadwal);
                    model.updatePendaftaran(p);
                    viewDashboard.showMessage(null, "Edit Berhasil");
                }
            } catch (SQLException ex) {
                viewDashboard.showMessage(null, "Data tidak ada");
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
