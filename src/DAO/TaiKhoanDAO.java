package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DATABASE.ConnectDataBase;
import Entity.LopHoc;
import Entity.Nganh;
import Entity.NguoiQuanLi;
import Entity.NhanVienPhongDaoTao;
import Entity.SinhVien;
import Entity.TaiKhoan;

public class TaiKhoanDAO {
	private ConnectDataBase db;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psTK;

	public TaiKhoanDAO() {
		db = new ConnectDataBase();
		con = db.getConnection();
	}

	public SinhVien dangNhapSinhVien(TaiKhoan t) {
		try {
			String sql = "select * from TaiKhoan t  join SinhVien sv on t.tenDangNhap = sv.tenDangNhap where t.tenDangNhap=? and t.matKhau=?";
			con = db.getConnection();
			psTK = con.prepareStatement(sql);
			psTK.setString(1, t.getTaiKhoan());
			psTK.setString(2, t.getMatKhau());
			rs = psTK.executeQuery();
			while (rs.next()) {
				SinhVien svt = new SinhVien(rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getDate(6),
						rs.getString(8), rs.getString(7), new Nganh(rs.getString(11)),
						new TaiKhoan(rs.getString(10), rs.getString(2)), new LopHoc(rs.getString(9)));

				return svt;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public NhanVienPhongDaoTao dangNhapNhanVienPhongDaoTao(TaiKhoan t) {
		try {
			String sql = "select * from TaiKhoan t  join NhanVienPDT sv on t.tenDangNhap = sv.tenDangNhap where t.tenDangNhap=? and t.matKhau=?";
			con = db.getConnection();
			psTK = con.prepareStatement(sql);
			psTK.setString(1, t.getTaiKhoan());
			psTK.setString(2, t.getMatKhau());
			rs = psTK.executeQuery();
			while (rs.next()) {
				NhanVienPhongDaoTao svt = new NhanVienPhongDaoTao(rs.getString(1));

				return svt;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public NguoiQuanLi dangNhapQuanLi(TaiKhoan t) {
		try {
			String sql = "select * from TaiKhoan t  join NguoiQuanLy sv on t.tenDangNhap = sv.tenDangNhap where t.tenDangNhap=? and t.matKhau=?";
			con = db.getConnection();
			psTK = con.prepareStatement(sql);
			psTK.setString(1, t.getTaiKhoan());
			psTK.setString(2, t.getMatKhau());
			rs = psTK.executeQuery();
			while (rs.next()) {
				NguoiQuanLi svt = new NguoiQuanLi(rs.getString(1));

				return svt;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean DoiMatKhau(String matKhauMoi, String taikhoan, String matKhauCu) {
		String sql = "update  TaiKhoan set matKhau = '" + matKhauMoi + "' where tenDangNhap ='" + taikhoan
				+ "' and matKhau = '" + matKhauCu + "'";
		try {
			con = db.getConnection();
			psTK = con.prepareStatement(sql);

			return psTK.executeUpdate() > 0;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}

	// select * from TaiKhoan order by tenDangNhap desc
	public String getTenDangNhap() {
		String sql = " select * from TaiKhoan order by tenDangNhap desc";
		try {
			con = db.getConnection();
			psTK = con.prepareStatement(sql);
//			psTK.exe
			rs = psTK.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

	public boolean themTaiKhoan() {
		String sql = "insert into TaiKhoan([matKhau]) values('123')";
		try {
			con = db.getConnection();
			psTK = con.prepareStatement(sql);
//			psTK.exe
			return psTK.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	public boolean themTaiKhoanNV(String ma) {
		String sql = "insert into TaiKhoan values('"+ma+"','123')";
		try {
			con = db.getConnection();
			psTK = con.prepareStatement(sql);
//			psTK.exe
			return psTK.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
