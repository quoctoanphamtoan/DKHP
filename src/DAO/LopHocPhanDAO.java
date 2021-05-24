package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import DATABASE.ConnectDataBase;
import Entity.ChiTietDangKiHocPhanCoThucHanh;
import Entity.GiangVien;
import Entity.LopHocPhan;
import Entity.MonHoc;
import Entity.PhongHoc;

public class LopHocPhanDAO {
	private ConnectDataBase db;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psLopHocPhan;

	public LopHocPhanDAO() {
		db = new ConnectDataBase();
		con = db.getConnection();
	}

	public ResultSet getLopHocPhan() {
		String sql = "SELECT maLopHP,maMonHoc,hocKy,thu,namHoc,maGiangVien,siSo,maPhongHoc,tietHoc,ngayBatDau,ngayKetThuc,soNhomTH FROM LopHocPhan";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<String> getLopHocPhanPnDiem() {
		List<String> listLHP = new ArrayList<>();
		String sql = "select lhp.maLopHP from PhieuDangKyHocPhan pdk join LopHocPhan lhp on pdk.maLopHP = lhp.maLopHP";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();
			while (rs.next()) {
//				 "LopHocPhanEnity [maLopHP=" + maLopHP + ", hocKy=" + hocKy + ", namHoc=" + namHoc + ", tietHoc="
//							+ tietHoc + ", thu=" + thu + ", phongHoc=" + phongHoc + ", siSo=" + siSo + ", maGiangVien="
//							+ maGiangVien + ", monHocEnity=" + monHocEnity + "]";
				listLHP.add(rs.getString(1));

			}
//			System.out.println(listLHP);
			return listLHP;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public ResultSet ThongTinLopHocPhan_DiemPanel(String lhp) {
		String sql = "select * from (GiangVien gv join LopHocPhan lhp on gv.maGiangVien =lhp.maGiangVien) join MonHoc mh on mh.maMonHoc  = lhp.maMonHoc where lhp.maLopHP='"
				+ lhp + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			return psLopHocPhan.executeQuery();

		} catch (Exception e) {
		}

		return null;

	}

	public boolean themLHP(LopHocPhan lhp) {
		String sql = "INSERT INTO LopHocPhan (hocKy,namHoc,maMonHoc,soNhomTH,ngayBatDau,ngayKetThuc,tietHoc,thu,siSo,maPhongHoc,maGiangVien,maNhanVienPDT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
//			psLopHocPhan.setString(1, null);
			psLopHocPhan.setInt(1, lhp.getHocKy());
			psLopHocPhan.setString(2, lhp.getNamHoc());
			psLopHocPhan.setString(3, lhp.getMonHocEnity().getMaMonHoc());
			psLopHocPhan.setInt(4, lhp.getSoNhomThucHanh());
			psLopHocPhan.setDate(5, lhp.getNgayBatDau());
			psLopHocPhan.setDate(6, lhp.getNgayKetThuc());
			psLopHocPhan.setString(7, lhp.getTietHoc());
			psLopHocPhan.setString(8, lhp.getThu());
			psLopHocPhan.setInt(9, lhp.getSiSo());
			psLopHocPhan.setString(10, lhp.getPhongHoc().getMaphongHoc());
			psLopHocPhan.setString(11, lhp.getGiangVien().getMaGiangVien());
			psLopHocPhan.setString(12, lhp.getNhanVienPhongDaoTao().getMaNhanVien());
			return psLopHocPhan.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean xoaLopHocPhan(String lhp) {
		String sql2 = "delete LopHocPhan where maLopHP ='" + lhp + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql2);

			return psLopHocPhan.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean capNhapLopHocPhan(LopHocPhan lhp, String maLHP) {
		String sql2 = "update LopHocPhan set hocKy=?,namHoc=?,tietHoc=?,thu=?,phongHoc=?,siSo=?,maGiangVien=?,maMonHoc=?  where maLopHP ='"
				+ maLHP + "'";

		try {
//			con = db.getConnection();
//			psLopHocPhan = con.prepareStatement(sql2);
//			psLopHocPhan.setInt(1, lhp.getHocKy());
//			psLopHocPhan.setString(2, lhp.getNamHoc());
//			psLopHocPhan.setString(3, lhp.getTietHoc());
//			psLopHocPhan.setString(4, lhp.getThu());
//			psLopHocPhan.setString(5, lhp.getPhongHoc().getMaphongHoc());
//			psLopHocPhan.setInt(6, lhp.getSiSo());
//			psLopHocPhan.setString(7, lhp.getGiangVien().getMaGiangVien());
//			psLopHocPhan.setString(8, lhp.getMonHocEnity().getMaMonHoc());

			return psLopHocPhan.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public ResultSet getLopTheoKi(int ki) {

		String sql = " select * from (LopHocPhan lhp join NhomLyThuyet nlt on nlt.maLopHP=lhp.maLopHP) join MonHoc mh on mh.maMonHoc = lhp.maMonHoc where lhp.hocKy = '"
				+ ki + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);

			rs = psLopHocPhan.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getLopTheoMaMonHoc(String Malop) {

		String sql = "SELECT maLopHP,siSo from LopHocPhan where maMonHoc = '" + Malop + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	// (select count(f.maNhom) from NhomThucHanh f where f.maLopHP=lhp.maLopHP) as
	// soNhom lay so nhom

//	select ntl.thu,ntl.tietHoc,rsntl.maPhongHoc,ntl.maGiangVien from (LopHocPhan lhp join NhomLyThuyet ntl on ntl.maLopHP = lhp.maLopHP) where lhp.maLopHP = 'LHP01'
//			select nth.thu,nth.tietHoc,nth.maPhongHoc,nth.maGiangVien from LopHocPhan lhp join NhomThucHanh nth on nth.maLopHP = lhp.maLopHP where lhp.maLopHP ='LHP01'

	public ResultSet getLopHocThucHanhTheoMaHP(String Malop) {

		String sql = " select nth.tenNhom,nth.thu,nth.tietHoc,nth.maPhongHoc,nth.maGiangVien from LopHocPhan lhp join NhomThucHanh nth on nth.maLopHP = lhp.maLopHP where lhp.maLopHP ='"
				+ Malop + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public LopHocPhan getLopHocPhanTheoMaLopHP(String maLopHP) {
		String sql = "SELECT * from LopHocPhan where maLopHP = '" + maLopHP + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();
			while (rs.next()) {
//				String maLopHP, int hocKy, String namHoc, MonHoc monHocEnity, String tietHoc,
//				String thu, int siSo, Date ngayBatDau, Date ngayKetThuc, int soNhomThucHanh, PhongHoc phongHoc,
//				GiangVien giangVien
				return new LopHocPhan(rs.getString(1), rs.getInt(2), rs.getString(3), new MonHoc(rs.getString(4)),
						rs.getString(8).trim(), rs.getString(9), rs.getInt(10), rs.getDate(6), rs.getDate(7),
						rs.getInt(5), new PhongHoc(rs.getString(11)), new GiangVien(rs.getString(12)));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public String getMaLopHocPhan() {
		String ma = "LHP0";
		String sql = "select count(maLopHP)+1 as ma from LopHocPhan";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();
			while (rs.next()) {
				ma += String.valueOf(rs.getInt(1));

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return ma;

	}

	public int getSiSoLopHocPhan(String maLopHocPhan) {
		int ss = 0;
		String sql = "select siSo from LopHocPhan where maLopHP ='" + maLopHocPhan + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();
			while (rs.next()) {
				ss = rs.getInt(1);

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return ss;

	}
	/*
	 * tạo lớp đăng kí học phần { - kiểm tra trùng tiết thứ phòng - kiểm tra trùng
	 * tiết thứ giảng viên }
	 */

	public boolean kiemTraTrungTietThuPhong(String tiet, String thu, String Phong) {
		// select * from LopHocPhan where maLopHP = 'MH001' and
//		tietHoc = '1-3' and maPhongHoc  = 'PH001' and thu  = '2'
		boolean temp = true;
		String sql = "select maLopHP, tietHoc,thu,maPhongHoc from LopHocPhan where  tietHoc = '" + tiet
				+ "' and maPhongHoc  = '" + Phong + "' and thu  = '" + thu + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equalsIgnoreCase("")) {
					temp = true;
				}
				temp = false;

			}
		} catch (Exception e) {

		}
		return temp;

	}

	public boolean kiemTraTrungTietThuGiangVien(String tiet, String thu, String maGiangVien) {
		// select * from LopHocPhan where maLopHP = 'MH001' and
//		tietHoc = '1-3' and maPhongHoc  = 'PH001' and thu  = '2'
		boolean temp = true;
		String sql = "select maLopHP, tietHoc,thu,maPhongHoc from LopHocPhan where  tietHoc = '" + tiet
				+ "' and maGiangVien  = '" + maGiangVien + "' and thu  = '" + thu + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equalsIgnoreCase("")) {
					temp = true;
				}
				temp = false;

			}
		} catch (Exception e) {

		}
		return temp;

	}

	public ResultSet getLopHocPhanCoThucHanhDaDangKi(String maSinhvien) {
		String sql = "SELECT lhp.maLopHP,mh.tenMonHoc,(mh.soTCLyThuyet+mh.soTCThucHanh) as tinchi,nth.tenNhom,pdk.ngayDangKy FROM ((PhieuDangKyHocPhan pdk JOIN LopHocPhan lhp ON lhp.maLopHP = pdk.maLopHP)\r\n"
				+ " JOIN MonHoc mh on mh.maMonHoc = lhp.maMonHoc )JOIN NhomThucHanh nth on nth.maNhom = pdk.maNhom\r\n"
				+ "WHERE pdk.maSinhVien ='" + maSinhvien + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getLopHocPhanKhongThucHanhDaDangKi(String maSinhvien) {
		String sql = "SELECT lhp.maLopHP,mh.tenMonHoc,(mh.soTCLyThuyet+mh.soTCThucHanh) as tinchi,pdk.ngayDangKi FROM ((PhieuDangKiHocPhanKhongTH pdk JOIN LopHocPhan lhp ON lhp.maLopHP = pdk.maLopHP) JOIN MonHoc mh on mh.maMonHoc = lhp.maMonHoc ) WHERE pdk.maSinhVien ='"
				+ maSinhvien + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<LopHocPhan> getLopHocPhanTheoNamKi(String nam, String ki) {
		List<LopHocPhan> list = new ArrayList<LopHocPhan>();
		String sql = "SELECT * FROM LopHocPhan  WHERE hocKy ='" + ki + "' and namHoc = '" + nam + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			rs = psLopHocPhan.executeQuery();
			while (rs.next()) {
				list.add(new LopHocPhan(rs.getString(1)));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public boolean HuyLopHocPhan(String maLopHP) {
		sqlXoaPhieuDangKiHocPhanKhongThucHanh(maLopHP);
		sqlXoaPhieuDangKiHocCoThucHanh(maLopHP);
		sqlXoaNhomThucHanh(maLopHP);
		String sqlXoaLopHocPhan = "DELETE LopHocPhan WHERE maLopHP = '" + maLopHP + "'";
		try {
			con = db.getConnection();

			psLopHocPhan = con.prepareStatement(sqlXoaLopHocPhan);
			return psLopHocPhan.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean sqlXoaPhieuDangKiHocPhanKhongThucHanh(String maLopHP) {
		String sqlXoaPhieuDangKiHocPhanKhongThucHanh = "DELETE PhieuDangKiHocPhanKhongTH WHERE maLopHP = '" + maLopHP
				+ "'";
		try {
			con = db.getConnection();

			psLopHocPhan = con.prepareStatement(sqlXoaPhieuDangKiHocPhanKhongThucHanh);
			return psLopHocPhan.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean sqlXoaPhieuDangKiHocCoThucHanh(String maLopHP) {
		String sqlXoaPhieuDangKiHocPhancoThucHanh = "DELETE PhieuDangKyHocPhan WHERE maLopHP = '" + maLopHP + "'";
		try {
			con = db.getConnection();

			psLopHocPhan = con.prepareStatement(sqlXoaPhieuDangKiHocPhancoThucHanh);
			return psLopHocPhan.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean sqlXoaNhomThucHanh(String maLopHP) {
		String sqlXoaNhomThucHanh = "delete NhomThucHanh where maLopHP='" + maLopHP + "'";
		try {
			con = db.getConnection();

			psLopHocPhan = con.prepareStatement(sqlXoaNhomThucHanh);
			return psLopHocPhan.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getSiSoLopHocPhanDangKi(String maLopHP) {
		int i = 0;
		String sqlCoThucHanh = "SELECT COUNT(maSinhVien) from PhieuDangKyHocPhan WHERE maLopHP = '" + maLopHP + "'";
		String sqlKhongThucHanh = "SELECT COUNT(maSinhVien) from PhieuDangKiHocPhanKhongTH WHERE maLopHP = '" + maLopHP
				+ "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sqlCoThucHanh);
			rs = psLopHocPhan.executeQuery();
			while (rs.next()) {
				i += rs.getInt(1);

			}
			psLopHocPhan = con.prepareStatement(sqlKhongThucHanh);
			rs = psLopHocPhan.executeQuery();
			while (rs.next()) {
				i += rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public boolean ChinhSuaLopHocPhan(String maLopHP, String thu, String tiet, String phonghoc, String maGiangVien) {
		String sql = "UPDATE LopHocPhan SET thu = '" + thu + "',tietHoc='" + tiet + "',maPhongHoc='" + phonghoc
				+ "',maGiangVien='" + maGiangVien + "' WHERE maLopHP ='" + maLopHP + "'";
		try {
			con = db.getConnection();
			psLopHocPhan = con.prepareStatement(sql);
			return psLopHocPhan.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
