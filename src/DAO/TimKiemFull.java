package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DATABASE.ConnectDataBase;
import Entity.GiangVien;
import Entity.LopHoc;
import Entity.LopHocPhan;
import Entity.MonHoc;
import Entity.Nganh;
import Entity.SinhVien;

//DECLARE @query NVARCHAR(100)
//SET @query = N'%Thị%'
//
//SELECT tenGiangVien,dbo.ufn_removeMark(tenGiangVien) AS tennv_khongdau
//FROM GiangVien
// WHERE dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query

public class TimKiemFull {
	private ConnectDataBase db;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psGiangVien,psLHP;
	private PreparedStatement psSinhVien;

	public TimKiemFull() {
		db = new ConnectDataBase();
		con = db.getConnection();
	}

	public List<String> TimKiemGiangVien(String s) {
		List<String> giangVien = new ArrayList<String>();
		String sql = "DECLARE @query NVARCHAR(100) SET @query = N'%" + s
				+ "%' SELECT * FROM GiangVien WHERE dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query";
		try {
			con = db.getConnection();
			psGiangVien = con.prepareStatement(sql);
//			psGiangVien.setString(1, s);
			rs = psGiangVien.executeQuery();
			while (rs.next()) {
				giangVien.add(rs.getString(2));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return giangVien;

	}

	public List<GiangVien> LocGiangVien(String ma, String ten, String maNganh, String gioiTinh) {
		List<GiangVien> listGiangVien = new ArrayList<GiangVien>();
		String sqlDau = "DECLARE @query NVARCHAR(100) SET @query = N'%" + ten + "%' ";
		String sqlThan = "select * from GiangVien where ";
		if (ma == "" && ten == "" && maNganh == "" && gioiTinh == "") {
			// Theo full ""
			String sqlFull = "select * from GiangVien ";
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlFull);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (ten == "" && maNganh == "" && gioiTinh == "") {
			// theo ma
			String sqlMa = sqlThan + "maGiangVien= '" + ma + "'";
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlMa);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ma == "" && maNganh == "" && gioiTinh == "") {
			// Theo Ten
			String sqlRs = sqlDau + sqlThan
					+ " dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query";
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (ma == "" && maNganh == "" && ten == "") {
			// theo gioiTinh
			boolean nam = true;
			if (gioiTinh.equalsIgnoreCase("nu")) {
				nam = false;
			}
			String sqlGioiTinh = sqlThan + "gioiTinh= '" + nam + "'";
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlGioiTinh);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ma == "" && gioiTinh == "" && ten == "") {
			// theo Nganh

			String sqlNganh = sqlThan + "maNganh= '" + maNganh + "'";
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlNganh);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (maNganh == "" && gioiTinh == "") {
			// Theo Ten & ma
			String sqlRs = sqlDau + sqlThan + " maGiangVien='" + ma + "' "
					+ " and dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query";
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (maNganh == "" && ten == "") {

			// Theo ma &gioiTinh

			boolean nam = true;
			if (gioiTinh.equalsIgnoreCase("nu")) {
				nam = false;
			}

			String sqlRs =  sqlThan + " gioiTinh='" + nam + "' "
					+ "  and maGiangVien='"+ma+"'";
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (gioiTinh == "" && ten == "") {

			// Theo ma &nghanh

			

			String sqlRs = sqlDau + sqlThan + " maNganh='" + maNganh + "' "
					+ "  and maGiangVien='"+ma+"'";
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		else if (ma == "" && gioiTinh == "") {

			// Theo ten & nganh
			String sqlRs = sqlDau + sqlThan
					+ " dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query and maNganh ='"+ maNganh + "'";
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (ma == "" && maNganh == "") {

			// Theo ten & gioiTinh
			boolean nam = true;
			if (gioiTinh.equalsIgnoreCase("nu")) {
				nam = false;
			}
			String sqlRs = sqlDau + sqlThan
					+ " dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query and gioiTinh ='"
					+ nam + "'";
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		else if (ma == "" && ten == "") {

			// Theo Nghanh & gioiTinh
			boolean nam = true;
			if (gioiTinh.equalsIgnoreCase("nu")) {
				nam = false;
			}
			String sqlRs =  sqlThan
					+ "gioiTinh='"+nam+"' and maNganh ='"+maNganh+"'";
				
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (maNganh=="") {

			// ma ten gioitinh 
			boolean nam = true;
			if (gioiTinh.equalsIgnoreCase("nu")) {
				nam = false;
			}
			String sqlRs = sqlDau+ sqlThan
					+ "gioiTinh='"+nam+"' and maGiangVien ='"+ma+"' and  dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query";
				
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (gioiTinh=="") {

			// ma ten nghanh 
			
			String sqlRs = sqlDau+ sqlThan
					+ "maGiangVien='"+ma+"' and maNganh ='"+maNganh+"' and  dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query";
				
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (ma=="") {

			// gioi ten nghanh 
			boolean nam = true;
			if (gioiTinh.equalsIgnoreCase("nu")) {
				nam = false;
			}
			String sqlRs = sqlDau+ sqlThan
					+ "gioiTinh='"+nam+"' and maNganh ='"+maNganh+"' and  dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query";
				
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else {
			boolean nam = true;
			if (gioiTinh.equalsIgnoreCase("nu")) {
				nam = false;
			}
			String sqlRs = sqlDau+ sqlThan
					+ "gioiTinh='"+nam+"' and maNganh ='"+maNganh+"' and  dbo.ufn_removeMark(tenGiangVien) LIKE @query OR tenGiangVien LIKE @query and maGiangVien='"+ma+"'";
				
			try {
				con = db.getConnection();
				psGiangVien = con.prepareStatement(sqlRs);
//				psGiangVien.setString(1, s);
				rs = psGiangVien.executeQuery();
				while (rs.next()) {
					listGiangVien.add(new GiangVien(rs.getString(1), rs.getString(2), rs.getBoolean(3),
							rs.getDate(4), new Nganh(rs.getString(5))));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		return listGiangVien;

	}
	public List<LopHocPhan> timKiemLopHocPhan(String namhoc,String hocKi,String ma) {
		List<LopHocPhan> list = new ArrayList<LopHocPhan>();
		if(namhoc.equalsIgnoreCase("")&&ma.equalsIgnoreCase("")) {
			
			String sql = "select * from LopHocPhan where hocKy='"+hocKi+"'";
			try {
				con = db.getConnection();
				psLHP = con.prepareStatement(sql);
				rs = psLHP.executeQuery();
				while (rs.next()) {
//					String maLopHP, int hocKy, String namHoc, MonHoc monHocEnity, Date ngayThi
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return list;
		
	}
	public List<LopHocPhan> timKiemLopHocPhanTheoMaLop(String ma) {
		List<LopHocPhan> list = new ArrayList<LopHocPhan>();
		
			
		
			
		
		return list;
		
	}
	public List<SinhVien> LocSinhVienTheoTen(String ten) {
		List<SinhVien> list =new ArrayList<SinhVien>();
		String sql ="DECLARE @query NVARCHAR(100) SET @query = N'%"+ten+"%' select * from SinhVien where dbo.ufn_removeMark(tenSinhVien) LIKE @query OR tenSinhVien LIKE @query ";
		try {
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);
			rs = psSinhVien.executeQuery();
			while (rs.next()) {
				list.add(new SinhVien(rs.getString(1),rs.getString(2), rs.getBoolean(3),
						rs.getDate(4),rs.getString(6) , rs.getString(5), new Nganh(rs.getString(9)),  new LopHoc(rs.getString(7))));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public List<SinhVien> LocSinhVienTheoMa(String ma) {
		List<SinhVien> list =new ArrayList<SinhVien>();
		String sql ="select * from SinhVien where maSinhvien = '"+ma+"'";
		try {
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);
			rs = psSinhVien.executeQuery();
			while (rs.next()) {
				list.add(new SinhVien(rs.getString(1),rs.getString(2), rs.getBoolean(3),
						rs.getDate(4),rs.getString(6) , rs.getString(5), new Nganh(rs.getString(9)),  new LopHoc(rs.getString(7))));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public List<SinhVien> LocSinhVienTheoChuyenNganh(String ma) {
		List<SinhVien> list =new ArrayList<SinhVien>();
		String sql ="select * from SinhVien where maNganh = '"+ma+"'";
		try {
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);
			rs = psSinhVien.executeQuery();
			while (rs.next()) {
				list.add(new SinhVien(rs.getString(1),rs.getString(2), rs.getBoolean(3),
						rs.getDate(4),rs.getString(6) , rs.getString(5), new Nganh(rs.getString(9)),  new LopHoc(rs.getString(7))));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public List<SinhVien> LocSinhVienFull(String ma) {
		
		List<SinhVien> list =new ArrayList<SinhVien>();
		String sql ="select * from SinhVien where maNganh = '"+ma+"'";
		try {
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);
			rs = psSinhVien.executeQuery();
			
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase("")) {
					
				}
				list.add(new SinhVien(rs.getString(1),rs.getString(2), rs.getBoolean(3),
						rs.getDate(4),rs.getString(6) , rs.getString(5), new Nganh(rs.getString(9)),  new LopHoc(rs.getString(7))));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	

}
