package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DATABASE.ConnectDataBase;
import Entity.ChiTietPhieuDangKiHocPhanKhongThucHanh;
import Entity.LopHoc;
import Entity.LopHocPhan;
import Entity.MonHoc;
import Entity.Nganh;
import Entity.SinhVien;

public class DangKiHocPhanKhongCoNhomThucHanhDAO {
	private ConnectDataBase db;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;

	public DangKiHocPhanKhongCoNhomThucHanhDAO() {
		db = new ConnectDataBase();
		con = db.getConnection();
	}
	public int getSiSoMoLopKhongThucHanh(String malph) {
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
	public int getSiSoMoLopCoThucHanh(String malph) {
		int siso = 0;
		String sql = "select count(maSinhVien) as siso from PhieuDangKyHocPhan where maLopHP = '" + malph + "' ";
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

	public boolean KiemTraHuyLopKhongThucHanh(String maLHP) {
		boolean temp = true;
		int gioihan = new LopHocPhanDAO().getSiSoLopHocPhan(maLHP);
		if (getSiSoMoLopKhongThucHanh(maLHP) >= (gioihan/2)) {
			return false;
		}
		return temp;
		
	}
	public boolean KiemTraHuyLopCoThucHanh(String maLHP) {
		boolean temp = true;
		int gioihan = new LopHocPhanDAO().getSiSoLopHocPhan(maLHP);
		if (getSiSoMoLopCoThucHanh(maLHP) >= (gioihan/2)) {
			return false;
		}
		return temp;
		
	}
	public boolean SinhVienHuyLopHocPhanKhongThucHanh(String maSinhVien, String maLHP) {
		
		String sql = "delete PhieuDangKiHocPhanKhongTH where maLopHP ='" + maLHP + "' and maSinhVien ='" + maSinhVien
				+ "'";
		try {
			ps = con.prepareStatement(sql);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	//maSinhVien, maLopHocPhan
	public boolean SinhVienDangKiLopHocPhan(String masv, String maLopHocPhan) {
		if (getSiSoMoLopKhongThucHanh(maLopHocPhan) >= getSiSoLop(maLopHocPhan)) {
			return false;
		}
		String sql = "insert into PhieuDangKiHocPhanKhongTH values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, masv);
			ps.setString(2, maLopHocPhan);
			ps.setFloat(3, new MonHocDAO().congNo(maLopHocPhan));
			ps.setDate(4, new Date(System.currentTimeMillis()));
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<ChiTietPhieuDangKiHocPhanKhongThucHanh> getNhungMonDaDangKi(String maSinhVien) {
		List<ChiTietPhieuDangKiHocPhanKhongThucHanh> list = new ArrayList<ChiTietPhieuDangKiHocPhanKhongThucHanh>();
		
		String sql = "SELECT * from PhieuDangKiHocPhanKhongTH WHERE maSinhVien = '"+maSinhVien+"'";
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ChiTietPhieuDangKiHocPhanKhongThucHanh(new SinhVien(rs.getString(1)), new LopHocPhan(rs.getString(2)), rs.getFloat(3), rs.getDate(4)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public int  getSiSoHienTaiLHP(String maLopHP) {
		int i = 0;
		String sql = "SELECT COUNT(maSinhVien) as siso FROM PhieuDangKiHocPhanKhongTH WHERE maLopHP ='"+maLopHP+"'";
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
	public boolean KiemTraKhongCoNhomThucHanh(String Monhoc) {
		boolean temp = true;
		String sql = "SELECT soTCThucHanh from MonHoc where maMonHoc='"+Monhoc+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getInt(1)>0) {
					temp = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
		
	}
	public List<LopHocPhan> KiemTraTrungTietThu(String maSinhVien,String Tiet,String Thu) {
		List<LopHocPhan> list = new ArrayList<LopHocPhan>();
		String sql ="SELECT lhp.thu,lhp.tietHoc,lhp.maMonHoc FROM PhieuDangKiHocPhanKhongTH pdk JOIN LopHocPhan lhp on lhp.maLopHP = pdk.maLopHP WHERE pdk.maSinhVien = '"+maSinhVien+"' and thu = '"+Thu+"' and tietHoc ='"+Tiet+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new LopHocPhan(new MonHoc(rs.getString(3)),rs.getString(2),rs.getString(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql1 ="SELECT lhp.thu,lhp.tietHoc,lhp.maMonHoc FROM PhieuDangKyHocPhan pdk JOIN LopHocPhan lhp on lhp.maLopHP = pdk.maLopHP WHERE pdk.maSinhVien = '"+maSinhVien+"' and thu = '"+Thu+"' and tietHoc ='"+Tiet+"'";
		try {
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new LopHocPhan(new MonHoc(rs.getString(3)),rs.getString(2),rs.getString(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql2 ="SELECT nth.thu,nth.tietHoc,lhp.maMonHoc FROM (NhomThucHanh nth join LopHocPhan lhp on lhp.maLopHP = nth.maLopHP ) "
				+ "JOIN PhieuDangKyHocPhan pdk on pdk.maLopHP = lhp.maLopHP WHERE pdk.maSinhVien = '"+maSinhVien+"' and nth.thu='"+Thu+"' and \r\n" + 
				"				nth.tietHoc = '"+Tiet+"'";
		try {
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new LopHocPhan(new MonHoc(rs.getString(3)),rs.getString(2),rs.getString(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		SELECT nth.thu,nth.tietHoc,lhp.maMonHoc FROM (NhomThucHanh nth join LopHocPhan lhp on lhp.maLopHP = nth.maLopHP ) JOIN PhieuDangKyHocPhan pdk on pdk.maLopHP = lhp.maLopHP WHERE pdk.maSinhVien = 'SV001' and nth.thu='' and 
//				nth.tietHoc = ''
		return list;
		
	}
	public List<SinhVien> getALLSinhVienLopHocPhan(String maLopHP) {
		List<SinhVien> listSV = new ArrayList<SinhVien>();
		String sql ="SELECT sv.maSinhVien,sv.tenSinhVien,sv.gioiTinh,sv.ngaySinh,sv.maNganh,sv.maLop FROM PhieuDangKyHocPhan pdk JOIN SinhVien sv on sv.maSinhVien = pdk.maSinhVien WHERE pdk.maLopHP = '"+maLopHP+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				listSV.add(new SinhVien(rs.getString(1),rs.getString(2),rs.getBoolean(3),rs.getDate(4),new Nganh(rs.getString(5)),new LopHoc(rs.getString(6))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return listSV;
		
	}
	
	
	
}
