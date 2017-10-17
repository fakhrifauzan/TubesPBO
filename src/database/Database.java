/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.*;
import model.*;

/**
 *
 * @author Fakhri Fauzan
 */
public class Database {
    private String server = "jdbc:mysql://localhost:3306/rumahsakit", dbuser = "root", dbpass = "";
    private Statement statement;
    private Connection connection;
    
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(server, dbuser, dbpass);
        statement = connection.createStatement();
    }
    
    //DOKTER
    public void createDokter(Dokter d) throws SQLException {
        String query = "INSERT INTO dokter (id_dokter, nama_dokter, jenis_kelamin, alamat_dokter, spesialis) VALUES ('"
                        +d.getId_dokter()+"','"+d.getNama()+"','"+d.getJenisKelamin()+"','"
                        +d.getAlamat()+"','"+d.getSpesialis()+"')";
        //System.out.println(query);
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys(); 
    }
    
    public Dokter getDokter(String idDokter) throws SQLException {
        Dokter d = null;
        String query = "SELECT * FROM dokter WHERE id_dokter = '" + idDokter+"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            d = new Dokter(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
        }
        return d;
    } 
    
    public void updateDokter(Dokter d) throws SQLException {
            String query = "update dokter set nama_dokter ='"
                    + d.getNama() + "', alamat_dokter= '"
                    + d.getAlamat() + "', jenis_kelamin='"
                    + d.getJenisKelamin() + "', spesialis='"
                    + d.getSpesialis() + "' where id_dokter = '"
                    + d.getId_dokter() + "'";
            //System.out.println(query);
            statement.executeUpdate(query);
    }  
    
    public ArrayList<Dokter> getAllDokter() throws SQLException{
        ArrayList<Dokter> dataDokter = new ArrayList<>();
        
        String query = "SELECT * FROM dokter";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Dokter d = new Dokter(rs.getString("id_dokter"), rs.getString("nama_dokter"), rs.getString("jenis_kelamin"), rs.getString("alamat_dokter"), rs.getString("spesialis"));
            dataDokter.add(d);
        }
        return dataDokter;  
    }
    
    public void DelDokter(String idDokter) throws SQLException {
        String query = "Delete from dokter where id_dokter='"+idDokter+"'";
        statement.execute(query);
    }
    
    //PERAWAT
    public void createPerawat(Perawat p) throws SQLException {
        String query = "INSERT INTO perawat (id_perawat, nama_perawat, jenis_kelamin, alamat_perawat, unit) VALUES ('"
                        +p.getId_perawat()+"','"+p.getNama()+"','"+p.getJenisKelamin()+"','"
                        +p.getAlamat()+"','"+p.getUnit()+"')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys(); 
    }
    
    public Perawat getPerawat(String idPerawat) throws SQLException {
        Perawat p = null;
        String query = "SELECT * FROM perawat WHERE id_perawat = '" + idPerawat+"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            p = new Perawat(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
        }
        return p;
    } 
    
    public void updatePerawat(Perawat p) throws SQLException {
        String query = "update perawat set nama_perawat ='"
                + p.getNama() + "', alamat_perawat= '"
                + p.getAlamat() + "', jenis_kelamin='"
                + p.getJenisKelamin() + "', unit='"
                + p.getUnit() + "' where id_perawat = '"
                + p.getId_perawat() + "'";
        //System.out.println(query);
        statement.executeUpdate(query);
    }  
    
    public ArrayList<Perawat> getAllPerawat() throws SQLException{
        ArrayList<Perawat> dataPerawat = new ArrayList<>();
        
        String query = "SELECT * FROM perawat";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Perawat p = new Perawat(rs.getString("id_perawat"), rs.getString("nama_perawat"), rs.getString("jenis_kelamin"), rs.getString("alamat_perawat"), rs.getString("unit"));
            dataPerawat.add(p);
        }
        return dataPerawat;  
    }
    
    public void DelPerawat(String idPerawat) throws SQLException {
        String query = "Delete from perawat where id_perawat='"+idPerawat+"'";
        statement.execute(query);
    }
    
    //STAFF
    public void createStaff(Staff s) throws SQLException {
        String query = "INSERT INTO staff (id_staff, nama_staff, jenis_kelamin, alamat_staff, bidang) VALUES ('"
                        +s.getId_staff()+"','"+s.getNama()+"','"+s.getJenisKelamin()+"','"
                        +s.getAlamat()+"','"+s.getBidang()+"')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys(); 
    }
    
    public Staff getStaff(String idStaff) throws SQLException {
        Staff s = null;
        String query = "SELECT * FROM staff WHERE id_staff = '" + idStaff +"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            s = new Staff(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
        }
        return s;
    } 
    
    public void updateStaff(Staff s) throws SQLException {
        String query = "update staff set nama_staff ='"
                + s.getNama() + "', alamat_staff= '"
                + s.getAlamat() + "', jenis_kelamin='"
                + s.getJenisKelamin() + "', bidang='"
                + s.getBidang() + "' where id_staff = '"
                + s.getId_staff() + "'";
        //System.out.println(query);
        statement.executeUpdate(query);
    }  
    
    public ArrayList<Staff> getAllStaff() throws SQLException{
        ArrayList<Staff> dataStaff = new ArrayList<>();
        
        String query = "SELECT * FROM staff";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Staff s = new Staff(rs.getString("id_staff"), rs.getString("nama_staff"), rs.getString("jenis_kelamin"), rs.getString("alamat_staff"), rs.getString("bidang"));
            dataStaff.add(s);
        }
        return dataStaff;  
    }
    
    public void DelStaff(String idStaff) throws SQLException {
        String query = "Delete from staff where id_staff='"+idStaff+"'";
        statement.execute(query);
    }
    
    //PASIEN
    public void createPasien(Pasien p) throws SQLException {
        String query = "INSERT INTO pasien (id_pasien, nama_pasien, jenis_kelamin, alamat_pasien, tanggal_lahir) VALUES ('"
                        +p.getIdPasien()+"','"+p.getNama()+"','"+p.getJenisKelamin()+"','"
                        +p.getAlamat()+"','"+p.getTanggalLahir()+"')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys(); 
    }
    
    public Pasien getPasien(int idPasien) throws SQLException {
        Pasien p = null;
        String query = "SELECT * FROM pasien WHERE id_pasien = '" + idPasien +"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            p = new Pasien(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
        }
        return p;
    } 
    
    public void updatePasien(Pasien p) throws SQLException {
        String query = "update pasien set nama_pasien ='"
                + p.getNama() + "', alamat_pasien = '"
                + p.getAlamat() + "', jenis_kelamin ='"
                + p.getJenisKelamin() + "', tanggal_lahir ='"
                + p.getTanggalLahir() + "' where id_pasien = '"
                + p.getIdPasien() + "'";
        //System.out.println(query);
        statement.executeUpdate(query);
    }
    
    public ArrayList<Pasien> getAllPasien() throws SQLException{
        ArrayList<Pasien> dataPasien = new ArrayList<>();
        
        String query = "SELECT * FROM pasien";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Pasien p = new Pasien(rs.getInt("id_pasien"), rs.getString("nama_pasien"), rs.getString("jenis_kelamin"), rs.getString("alamat_pasien"), rs.getString("tanggal_lahir"));
            dataPasien.add(p);
        }
        return dataPasien;  
    }
    
    public void DelPasien(int idPasien) throws SQLException {
        String query = "Delete from pasien where id_pasien='"+idPasien+"'";
        statement.execute(query);
    }
    
    //JADWAL
    public void createJadwal(Jadwal j) throws SQLException {
        String query = "INSERT INTO jadwal (id_dokter, hari, shift) VALUES ('"
                        +j.getIdDokter()+"','"+j.getHari()+"','"+j.getShift()+"')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys(); 
    }
    
    public Jadwal getJadwal(int idJadwal) throws SQLException {
        Jadwal j = null;
        String query = "SELECT * FROM jadwal WHERE id_jadwal = '" + idJadwal +"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            j = new Jadwal(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
        }
        return j;
    } 
    
    public void updateJadwal(Jadwal j) throws SQLException {
        String query = "update jadwal set hari ='"
                + j.getHari() + "', shift = '"
                + j.getShift() + "' where id_jadwal = '"
                + j.getIdJadwal()+ "'";
        //System.out.println(query);
        statement.executeUpdate(query);
    }
    
    public ArrayList<Jadwal> getAllJadwal() throws SQLException{
        ArrayList<Jadwal> dataJadwal = new ArrayList<>();
        
        String query = "SELECT * FROM jadwal";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Jadwal j = new Jadwal(rs.getInt("id_jadwal"), rs.getString("id_dokter"), rs.getString("hari"), rs.getString("shift"));
            dataJadwal.add(j);
        }
        return dataJadwal;  
    }
    
    public void DelJadwal(int idJadwal) throws SQLException {
        String query = "Delete from jadwal where id_jadwal='"+idJadwal+"'";
        statement.execute(query);
    }
    
    //PENDAFTARAN
    public void createPendaftaran(Pendaftaran p) throws SQLException {
        String query = "INSERT INTO pendaftaran (id_pasien, id_jadwal) VALUES ('"
                        +p.getIdPasien()+"','"+p.getIdJadwal()+"')";
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys(); 
    }
    
    public Pendaftaran getPendaftaran(int idPendaftaran) throws SQLException {
        Pendaftaran p = null;
        String query = "SELECT * FROM pendaftaran WHERE id_pendaftaran = '" + idPendaftaran +"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            p = new Pendaftaran(rs.getInt(1), rs.getInt(2), rs.getInt(3));
        }
        return p;
    } 
    
    public void updatePendaftaran(Pendaftaran p) throws SQLException {
        String query = "update pendaftaran set id_pasien ='"
                + p.getIdPasien() + "', id_jadwal = '"
                + p.getIdJadwal() + "' where id_pendaftaran = '"
                + p.getIdPendaftaran()+ "'";
        //System.out.println(query);
        statement.executeUpdate(query);
    }
    
    public ArrayList<Pendaftaran> getAllPendaftaran() throws SQLException{
        ArrayList<Pendaftaran> dataPendaftaran = new ArrayList<>();
        
        String query = "SELECT * FROM pendaftaran";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Pendaftaran p = new Pendaftaran(rs.getInt("id_pendaftaran"), rs.getInt("id_pasien"), rs.getInt("id_jadwal"));
            dataPendaftaran.add(p);
        }
        return dataPendaftaran;  
    }
    
    public void DelPendaftaran(int idPendaftaran) throws SQLException {
        String query = "Delete from pendaftaran where id_pendaftaran='"+idPendaftaran+"'";
        statement.execute(query);
    }
}
