package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DATABASE.ConnectDataBase;
import Entity.GiangVien;
import Entity.Nganh;

public class GiangVienDAO {
	private ConnectDataBase db ;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psGiangVien;
	public GiangVienDAO() {
		db = new ConnectDataBase();
		con=db.getConnection();
	}
	public String getTenGiangVien(String id) {
		try {
			String sql = "select tenGiangVien from GiangVien  where maGiangVien='"+id+"'";
			con= db.getConnection();
			psGiangVien = con.prepareStatement(sql);
			rs = psGiangVien.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
		
	}
	public List<GiangVien> getAllGiangVien() {
		//String maGiangVien, String tenGiangVien, boolean gioiTinh, Date ngaySinh, NganhEnity nganh
		List<GiangVien> list = new ArrayList<GiangVien>();
		try {
			String sql = "select * from GiangVien";
			con= db.getConnection();
			psGiangVien = con.prepareStatement(sql);
		
			rs = psGiangVien.executeQuery();
			while (rs.next()) {
				list.add(new GiangVien(rs.getString(1),rs.getString(2),rs.getBoolean(3),rs.getDate(4),new Nganh(rs.getString(5))));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return list;
	}
	public String getMaGiangVien(String s) {

	
		String sql = "DECLARE @query NVARCHAR(100) SET @query = N'%" + s
				+ "%' SELECT * FROM GiangVien WHERE dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query";
		try {
			con = db.getConnection();
			psGiangVien = con.prepareStatement(sql);
//			psGiangVien.setString(1, s);
			rs = psGiangVien.executeQuery();
			while (rs.next()) {
				return rs.getString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
		
		
	}
	public List<GiangVien> getGiangVienTheoChuyenNganh(String maChuyenNganh) {
		List<GiangVien> list = new ArrayList<GiangVien>();
		String sql="select * from GiangVien where maNganh='"+maChuyenNganh+"'";
		try {
			con = db.getConnection();
			psGiangVien = con.prepareStatement(sql);
			rs = psGiangVien.executeQuery();
			while (rs.next()) {
				list.add(new GiangVien(rs.getString(1),rs.getString(2),rs.getBoolean(3),rs.getDate(4),new Nganh(rs.getString(5))));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean themGiangVien(GiangVien gv) {
		String sql = "insert into GiangVien (tenGiangVien,gioiTinh,ngaySinh,maNganh,maQuanLy) values(?,?,?,?,?)";
		try {
			con = db.getConnection();
			psGiangVien = con.prepareStatement(sql);
			psGiangVien.setString(1,gv.getTenGiangVien());
			psGiangVien.setBoolean(2,gv.isGioiTinh());
			psGiangVien.setDate(3,gv.getNgaySinh());
			psGiangVien.setString(4,gv.getNganh().getMaNganh());
			psGiangVien.setString(5,gv.getNguoiQuanLi().getMaQuanLi());
			return psGiangVien.executeUpdate()>0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Thêm không thành công");
		}
		return false;
		
	}
	public boolean capNhatGiangVien(GiangVien gv) {
		String sql = "update GiangVien set tenGiangVien=N'"+gv.getTenGiangVien()+"',gioiTinh='"+gv.isGioiTinh()+"',ngaySinh='"+gv.getNgaySinh()+"',maNganh='"+gv.getNganh().getMaNganh()+"' where maGiangVien ='"+gv.getMaGiangVien()+"' ";
		try {
			con = db.getConnection();
			psGiangVien = con.prepareStatement(sql);
			return psGiangVien.executeUpdate()>0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không cập nhật được");
		}
		return false;
		
	}
	public boolean xoaGiangVien(String ma) {
		String sql = "delete GiangVien where maGiangVien = '"+ma+"'";
		try {
			con = db.getConnection();
			psGiangVien = con.prepareStatement(sql);
			
			return psGiangVien.executeUpdate()>0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không thể xóa giảng viên đang dạy");
		}
		return false;
		
	}
	public String getMaGiangVien() {
		String ma = "GV00";
		String sql = "select count(maGiangVien)+1 as ma from GiangVien";
		try {
			con = db.getConnection();
			psGiangVien = con.prepareStatement(sql);						
			psGiangVien = con.prepareStatement(sql);						
			rs= psGiangVien.executeQuery();
			while (rs.next()) {
				ma += String.valueOf(rs.getInt(1));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return ma;
		
	}

}
