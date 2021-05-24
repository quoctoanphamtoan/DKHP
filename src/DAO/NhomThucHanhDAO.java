package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DATABASE.ConnectDataBase;
import Entity.GiangVien;
import Entity.LopHocPhan;
import Entity.NhomThucHanh;
import Entity.PhongHoc;

public class NhomThucHanhDAO {
	private ConnectDataBase db;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;

	public NhomThucHanhDAO() {
		db = new ConnectDataBase();
		con = db.getConnection();
	}

	public boolean ThemNhomThucHanh(NhomThucHanh nhomThucHanh) {
		boolean temp = true;
		String sql = "insert into NhomThucHanh values(?,?,?,?,?,?,?,?)";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, nhomThucHanh.getMaNhom());
			ps.setInt(2, nhomThucHanh.getTenNhom());
			ps.setString(3, nhomThucHanh.getTietHoc());
			ps.setString(4, nhomThucHanh.getThu());
			ps.setInt(5, nhomThucHanh.getSiSo());
			ps.setString(6, nhomThucHanh.getLopHocPhan().getMaLopHP());
			ps.setString(7, nhomThucHanh.getPhongHoc().getMaphongHoc());
			ps.setString(8, nhomThucHanh.getGiangVien().getMaGiangVien());
			temp = ps.executeUpdate() > 0;

		} catch (Exception e) {
			temp = false;
			e.printStackTrace();
		}
		return temp;

	}

	public int getMaNhomThucHanh() {
		int maNhom = 0;
		String sql = "select count(maNhom)+1 as maNhom from NhomThucHanh";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				maNhom = rs.getInt(1);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return maNhom;

	}

	public boolean kiemTraTrungTietThuPhong(String tiet, String thu, String Phong) {
		// select * from NhomThucHanh where maLopHP = 'MH001' and
//		tietHoc = '1-3' and maPhongHoc  = 'PH001' and thu  = '2'
		boolean temp = true;
		String sql = "select maLopHP, tietHoc,thu,maPhongHoc from NhomThucHanh where  tietHoc = '" + tiet
				+ "' and maPhongHoc  = '" + Phong + "' and thu  = '" + thu + "'";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equalsIgnoreCase("")) {
					temp = true;
				}
				JOptionPane.showMessageDialog(null,
						"Tiết " + tiet + " Thứ " + thu + " Phòng " + Phong + " đã có lớp học phần, xin chọn lại");
				temp = false;

			}
		} catch (Exception e) {

		}
		return temp;

	}

	public boolean kiemTraTrungTietThuGiangVien(String tiet, String thu, String maGiangVien) {
		// select * from NhomThucHanh where maLopHP = 'MH001' and
//		tietHoc = '1-3' and maPhongHoc  = 'PH001' and thu  = '2'
		boolean temp = true;
		String sql = "select maLopHP, tietHoc,thu,maPhongHoc from NhomThucHanh where  tietHoc = '" + tiet
				+ "' and maGiangVien  = '" + maGiangVien + "' and thu  = '" + thu + "'";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equalsIgnoreCase("")) {
					temp = true;
				}
				JOptionPane.showMessageDialog(null, "Tiết " + tiet + " Thứ " + thu + " Giang vien " + maGiangVien
						+ " đã có lớp học phần, xin chọn lại");
				temp = false;

			}
		} catch (Exception e) {

		}
		return temp;

	}

	public boolean KiemTraSoNhomThucHanh(String maLopHocPhan) {
		int soNhomThucHanhDaDuocTao = 0;
		int soNhomThucHanhToiDa = 0;

		String sql_soNhomThucHanhToiDa = "SELECT soNhomTH FROM LopHocPhan WHERE maLopHP ='" + maLopHocPhan + "'";
		String sql_soNhomThucHanhDaDuocTao = "SELECT COUNT(maNhom) as soNhom FROM NhomThucHanh WHERE maLopHP = '"
				+ maLopHocPhan + "'";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql_soNhomThucHanhToiDa);
			rs = ps.executeQuery();

			while (rs.next()) {
				soNhomThucHanhToiDa = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		///////////////////
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql_soNhomThucHanhDaDuocTao);
			rs = ps.executeQuery();

			while (rs.next()) {
				soNhomThucHanhDaDuocTao = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (soNhomThucHanhDaDuocTao < soNhomThucHanhToiDa) {
			return true;
		}else {
			return false;
		}

		

	}
//SELECT COUNT(pdk.maSinhVien) as siso FROM PhieuDangKyHocPhan pdk JOIN NhomThucHanh nth on nth.maNhom = pdk.maNhom where nth.maLopHP = 'LHP01' and nth.maNhom = '1'
	public int getSiSoNhomThucHanh(int nhom, String maLopHP) {
		int ss = 0;
		String sql ="SELECT COUNT(pdk.maSinhVien) as siso FROM PhieuDangKyHocPhan pdk JOIN NhomThucHanh nth on nth.maNhom = pdk.maNhom where nth.maLopHP = '"+maLopHP+"' and nth.maNhom = '"+nhom+"'";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ss = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
		
		
	}
	public List<NhomThucHanh> getNhomThucHanhTheoMaLopHocPhan(String maLopHP) {
		List<NhomThucHanh> list = new ArrayList<>();
		String sql = "SELECT * FROM NhomThucHanh WHERE maLopHP = '"+maLopHP+"'";
		try {
			con = db.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new NhomThucHanh(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						new LopHocPhan(rs.getString(6)), new PhongHoc(rs.getString(7)),
						new GiangVien(rs.getString(8))));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}


}
