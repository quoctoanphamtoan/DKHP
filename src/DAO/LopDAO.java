package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DATABASE.ConnectDataBase;
import Entity.LopHoc;
import Entity.PhongHoc;

public class LopDAO {
	private ConnectDataBase db ;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psNganh;
	private PreparedStatement psLop;
	public LopDAO() {
		db = new ConnectDataBase();
		con=db.getConnection();
	}
	public String getTenLop(String id) {
		try {
			String sql = "select tenLop from LopHoc where maLop=?";
			con= db.getConnection();
			psLop = con.prepareStatement(sql);
			psLop.setString(1, id);
			rs = psLop.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
				
			}
		} catch (Exception e) {

		}
		return "Không có ";
		
	}
	public List<LopHoc> getLopTheoMaNganh(String ma) {
		List<LopHoc> list = new ArrayList<LopHoc>();
		String sql = "select * from LopHoc where maNganh = '"+ma+"'";
		try {
			con = db.getConnection();
			psLop = con.prepareStatement(sql);
			rs = psLop.executeQuery();
			while (rs.next()) {
				list.add(new LopHoc(rs.getString(1), rs.getString(2)));
				
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return list;
		
	}
	public String getMaLop(String id) {
		try {
			String sql = "DECLARE @query NVARCHAR(100) SET @query = N'%"+id+"%' SELECT * FROM LopHoc WHERE   dbo.ufn_removeMark(maLop) LIKE @query OR tenLop LIKE @query";
			con= db.getConnection();
			psLop = con.prepareStatement(sql);
	
			rs = psLop.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
				
			}
		} catch (Exception e) {

		}
		return "Không có ";
		
	}
	public List<LopHoc> getAllLopHoc() {
		List<LopHoc> list = new ArrayList<LopHoc>();
		String sql = "select * from LopHoc";
		try {
			con = db.getConnection();
			psLop = con.prepareStatement(sql);
			rs = psLop.executeQuery();
			while (rs.next()) {
				String maLop = rs.getString(1);
				String tenLop =rs.getString(2);
			
				list.add(new LopHoc(maLop,tenLop));
				
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return list;
		
	}
	public boolean themLopHoc(LopHoc lop) {
		con= db.getConnection();
		try {
			psLop=con.prepareStatement("Insert into LopHoc values (?,?,?)");
			psLop.setString(1, lop.getMaLop());
			psLop.setString(2, lop.getTenLop());
			psLop.setString(3, lop.getQuanly().getMaQuanLi());
			return psLop.executeUpdate()>0;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Thêm không thành công");
		}
		return false;
	}
	public boolean xoaLopHoc(String ma) {
		String sql = "delete LopHoc where maLop = '"+ma+"'";
		try {
			con = db.getConnection();
			psLop = con.prepareStatement(sql);
			
			return psLop.executeUpdate()>0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không thể xóa lớp đang học");
		}
		return false;
}
}
