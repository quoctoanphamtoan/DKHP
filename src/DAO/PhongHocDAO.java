package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DATABASE.ConnectDataBase;
import Entity.PhongHoc;

public class PhongHocDAO {
	private ConnectDataBase db ;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	public PhongHocDAO() {
		db = new ConnectDataBase();
		con=db.getConnection();
	}
	public String getTenPhongHoc(String id) {
		try {
			String sql = "select tenPhongHoc from PhongHoc  where maPhongHoc=?";
			con= db.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
		
	}
	public List<PhongHoc> getAllPhongHoc() {
		//String maPhongHoc, String tenPhongHoc, boolean gioiTinh, Date ngaySinh, NganhEnity nganh
		List<PhongHoc> list = new ArrayList<PhongHoc>();
		try {
			String sql = "select *from PhongHoc";
			con= db.getConnection();
			ps = con.prepareStatement(sql);
		
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PhongHoc(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<PhongHoc> getPhongHocTheoDay(String day) {
		//String maPhongHoc, String tenPhongHoc, boolean gioiTinh, Date ngaySinh, NganhEnity nganh
		List<PhongHoc> list = new ArrayList<PhongHoc>();
		try {
			String sql = "select * from PhongHoc where day = '"+day+"'";
			con= db.getConnection();
			ps = con.prepareStatement(sql);
		
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PhongHoc(rs.getString(1),rs.getString(2),rs.getString(3)));
				
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return list;
	}
	public List<PhongHoc> getPhongHocTheoDayALL() {
		//String maPhongHoc, String tenPhongHoc, boolean gioiTinh, Date ngaySinh, NganhEnity nganh
		List<PhongHoc> list = new ArrayList<PhongHoc>();
		try {
			String sql = "select * from PhongHoc";
			con= db.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PhongHoc(rs.getString(1),rs.getString(2),rs.getString(3)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public String getMaPhongHocTheoTen(String ten) {
		String sql = "DECLARE @query NVARCHAR(100) SET @query = N'%"+ten+"%' SELECT * FROM PhongHoc WHERE dbo.ufn_removeMark(tenPhongHoc) LIKE @query OR tenPhongHoc LIKE @query";
		try {
			
			con= db.getConnection();
			ps = con.prepareStatement(sql);
		
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
				
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return "";
	}
	public boolean themPhongHoc(PhongHoc phonghoc) {
		con= db.getConnection();
		try {
			ps=con.prepareStatement("Insert into PhongHoc (tenPhongHoc,day,loaiPhong,maQuanLy) values (?,?,?,?)");
			ps.setString(1, phonghoc.getTenPhongHoc());
			ps.setString(2, phonghoc.getDay());
			ps.setString(3, phonghoc.getLoaiPhong());
			ps.setString(4, phonghoc.getNguoiQuanLi().getMaQuanLi());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Thêm không thành công");
		}
		return false;
	}
	public boolean xoaPhongHoc(String ma) {
		String sql = "delete PhongHoc where maPhongHoc = '"+ma+"'";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không thể xóa phòng học đang học");
		}
		return false;
		
	}
}
