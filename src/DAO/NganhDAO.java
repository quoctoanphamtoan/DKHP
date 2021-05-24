package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DATABASE.ConnectDataBase;
import Entity.Nganh;

public class NganhDAO {
	private ConnectDataBase db;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psNganh;

	public NganhDAO() {
		db = new ConnectDataBase();
		con = db.getConnection();
	}

	public String getTenNganh(String id) {
		try {
			String sql = "select tenNganh from Nganh where maNganh=?";
			con = db.getConnection();
			psNganh = con.prepareStatement(sql);
			psNganh.setString(1, id);
			rs = psNganh.executeQuery();
			while (rs.next()) {
				return rs.getString(1);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Kh�ng c�";

	}

	public List<Nganh> getTALL() {
		List<Nganh> list = new ArrayList<Nganh>();

		try {
			String sql = "select * from Nganh ";
			con = db.getConnection();
			psNganh = con.prepareStatement(sql);
			rs = psNganh.executeQuery();
			while (rs.next()) {
				list.add(new Nganh(rs.getString(1), rs.getString(2)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean themNganh(Nganh nganh) {
		con = db.getConnection();
		try {
			psNganh = con.prepareStatement("Insert into Nganh values (?,?,?)");
			psNganh.setString(1, nganh.getMaNganh());
			psNganh.setString(2, nganh.getTenNganh());
			psNganh.setString(3,"QL01");
			return psNganh.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getMaNganhBangTen(String tenNganh) {
		String sql = "DECLARE @query NVARCHAR(100) SET @query = N'%" + tenNganh
				+ "%' SELECT * FROM Nganh WHERE dbo.ufn_removeMark(tenNganh) LIKE @query OR tenNganh LIKE @query";
		try {
			con = db.getConnection();
			psNganh = con.prepareStatement(sql);
			rs = psNganh.executeQuery();
			while (rs.next()) {
				return rs.getString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

	public boolean xoaNganh(String ma) {
		String sql = "delete Nganh where maNganh = '" + ma + "'";
		try {
			con = db.getConnection();
			psNganh = con.prepareStatement(sql);

			return psNganh.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
