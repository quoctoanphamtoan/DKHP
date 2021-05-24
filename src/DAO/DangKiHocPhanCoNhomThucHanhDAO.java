package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DATABASE.ConnectDataBase;
import Entity.ChiTietPhieuDangKiHocPhanKhongThucHanh;
import Entity.LopHocPhan;
import Entity.MonHoc;
import Entity.SinhVien;

public class DangKiHocPhanCoNhomThucHanhDAO {
	private ConnectDataBase db;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;

	public DangKiHocPhanCoNhomThucHanhDAO() {
		db = new ConnectDataBase();
		con = db.getConnection();
	}

	public int getSiSoHienTaiLHP(String maLopHP) {
		int i = 0;
		String sql = "SELECT COUNT(maSinhVien) as siso FROM PhieuDangKyHocPhan WHERE maLopHP ='" + maLopHP + "'";
		try {
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public boolean SinhVienDangKiLopHocPhan(String masv, String maLopHocPhan, int maNhom) {
		if (getSiSoMoLop(maLopHocPhan) >= getSiSoLop(maLopHocPhan)) {
			return false;
		}
		String sql = "insert into PhieuDangKyHocPhan values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, maLopHocPhan);
			ps.setString(2, masv);
			ps.setFloat(3, new MonHocDAO().congNo(maLopHocPhan));
			ps.setDate(4, new Date(System.currentTimeMillis()));
			ps.setInt(5, maNhom);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean SinhVienHuyLopHocPhanCoThucHanh(String maSinhVien, String maLHP) {

		String sql = "delete PhieuDangKyHocPhan where maLopHP ='" + maLHP + "' and maSinhVien ='" + maSinhVien
				+ "'";
		try {
			ps = con.prepareStatement(sql);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<ChiTietPhieuDangKiHocPhanKhongThucHanh> getNhungMonDaDangKi(String maSinhVien) {
		List<ChiTietPhieuDangKiHocPhanKhongThucHanh> list = new ArrayList<ChiTietPhieuDangKiHocPhanKhongThucHanh>();

		String sql = "SELECT * from PhieuDangKiHocPhanKhongTH WHERE maSinhVien = '" + maSinhVien + "'";
		try {
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ChiTietPhieuDangKiHocPhanKhongThucHanh(new SinhVien(rs.getString(1)),
						new LopHocPhan(rs.getString(2)), rs.getFloat(3), rs.getDate(4)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public boolean KiemTraKhongCoNhomThucHanh(String Monhoc) {
		boolean temp = true;
		String sql = "SELECT soTCThucHanh from MonHoc where maMonHoc='" + Monhoc + "'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					temp = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;

	}

	public List<LopHocPhan> KiemTraTrungTietThu(String maSinhVien, String Tiet, String Thu) {
		List<LopHocPhan> list = new ArrayList<LopHocPhan>();
		String sql = "SELECT lhp.thu,lhp.tietHoc,lhp.maMonHoc FROM PhieuDangKiHocPhanKhongTH pdk JOIN LopHocPhan lhp on lhp.maLopHP = pdk.maLopHP WHERE pdk.maSinhVien = '"
				+ maSinhVien + "' and thu = '" + Thu + "' and tietHoc ='" + Tiet + "'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new LopHocPhan(new MonHoc(rs.getString(3)), rs.getString(2), rs.getString(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql1 = "SELECT lhp.thu,lhp.tietHoc,lhp.maMonHoc FROM PhieuDangKyHocPhan pdk JOIN LopHocPhan lhp on lhp.maLopHP = pdk.maLopHP WHERE pdk.maSinhVien = '"
				+ maSinhVien + "' and thu = '" + Thu + "' and tietHoc ='" + Tiet + "'";
		try {
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new LopHocPhan(new MonHoc(rs.getString(3)), rs.getString(2), rs.getString(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql2 = "SELECT nth.thu,nth.tietHoc,lhp.maMonHoc FROM (NhomThucHanh nth join LopHocPhan lhp on lhp.maLopHP = nth.maLopHP ) "
				+ "JOIN PhieuDangKyHocPhan pdk on pdk.maLopHP = lhp.maLopHP WHERE pdk.maSinhVien = '" + maSinhVien
				+ "' and nth.thu='" + Thu + "' and \r\n" + "				nth.tietHoc = '" + Tiet + "'";
		try {
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new LopHocPhan(new MonHoc(rs.getString(3)), rs.getString(2), rs.getString(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		SELECT nth.thu,nth.tietHoc,lhp.maMonHoc FROM (NhomThucHanh nth join LopHocPhan lhp on lhp.maLopHP = nth.maLopHP ) JOIN PhieuDangKyHocPhan pdk on pdk.maLopHP = lhp.maLopHP WHERE pdk.maSinhVien = 'SV001' and nth.thu='' and 
//				nth.tietHoc = ''
		return list;

	}

	public int getSiSoMoLop(String malph) {
		int siso = 0;
		String sql = "select count(maSinhVien) as siso from PhieuDangKiHocPhanKhongTH where maLopHP = '" + malph + "' ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				siso = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return siso;
	}

	public float getSiSoLop(String malph) {
		int siso = 0;
		String sql = "select siSo as siso from LopHocPhan where maLopHP = '" + malph + "'  ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				siso = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return siso;
	}

}
