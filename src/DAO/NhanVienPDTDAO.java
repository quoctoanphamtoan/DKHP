package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DATABASE.ConnectDataBase;
import Entity.GiangVien;
import Entity.NguoiQuanLi;
import Entity.NhanVienPhongDaoTao;
import Entity.TaiKhoan;

public class NhanVienPDTDAO {
	private ConnectDataBase db ;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	public NhanVienPDTDAO() {
		db = new ConnectDataBase();
		con=db.getConnection();
	}
	public List<NhanVienPhongDaoTao> getAllNhanVien() {
		
		List<NhanVienPhongDaoTao> list = new ArrayList<NhanVienPhongDaoTao>();
		try {
			String sql = "select * from NhanVienPDT";
			con= db.getConnection();
			ps = con.prepareStatement(sql);
		
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new NhanVienPhongDaoTao(rs.getString(1),rs.getString(2),rs.getBoolean(3),rs.getDate(4),rs.getString(5),new TaiKhoan(rs.getString(6)),new NguoiQuanLi(rs.getString(7))));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return list;
	}
	public boolean themNhanVien(NhanVienPhongDaoTao nhanvien) {
		String sql = "insert into NhanVienPDT values(?,?,?,?,?,?,?)";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,nhanvien.getMaNhanVien());
			ps.setString(2,nhanvien.getTenNhanVien());
			ps.setBoolean(3,nhanvien.isGioiTinh());
			ps.setDate(4,nhanvien.getNgaySinh());
			ps.setString(5,nhanvien.getDiaChi());
			ps.setString(6,nhanvien.getTaiKhoan().getTaiKhoan());
			ps.setString(7,nhanvien.getNguoiQuanLi().getMaQuanLi());
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Mã nhân viên đã có");
		}
		return false;
		
	}
	public boolean capNhatNhanVien(NhanVienPhongDaoTao nv) {
		String sql = "update NhanVienPDT set tenNhanVien=N'"+nv.getTenNhanVien()+"',gioiTinh='"+nv.isGioiTinh()+"',ngaySinh='"+nv.getNgaySinh()+"',diaChi='"+nv.getDiaChi()+"' where maNhanVienPDT='"+nv.getMaNhanVien()+"' ";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không cập nhật được");
		}
		return false;
		
	}
	public boolean xoaNhanVien(String ma) {
		String sql = " delete NhanVienPDT where maNhanVienPDT = '"+ma+"'";
		String sqlxtk="delete TaiKhoan where tenDangNhap ='"+ma+"'";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			PreparedStatement psxoa= con.prepareStatement(sqlxtk);
			ps.executeUpdate();
			return psxoa.executeUpdate()>0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không thể xóa nhân viên này");
		}
		return false;
		
	}
	public String getMaNhanVien() {
		String ma = "NV0";
		String sql = "select count(maNhanVienPDT)+1 as maNV from NhanVienPDT ";
		try {
			con = db.getConnection();					
			ps = con.prepareStatement(sql);						
			rs= ps.executeQuery();
			while (rs.next()) {
				ma += String.valueOf(rs.getInt(1));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return ma;
		
	}
}
