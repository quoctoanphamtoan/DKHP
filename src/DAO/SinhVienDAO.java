package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DATABASE.ConnectDataBase;
import Entity.LopHoc;
import Entity.Nganh;
import Entity.SinhVien;

public class SinhVienDAO {
	private ConnectDataBase db;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psSinhVien;
	private PreparedStatement psXoaTaiKhoanSinhVien;

	public SinhVienDAO() {
		db = new ConnectDataBase();
		con = db.getConnection();
	}
	public List<SinhVien> getSinhVienALLTheoMaLop(String ma) {
		List<SinhVien> list = new ArrayList<SinhVien>();
		
		try {
			String sql = "select * from SinhVien where maLop = '"+ma+"' ";
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);
//			psSinhVien.setString(1, id);
			rs = psSinhVien.executeQuery();
			while (rs.next()) {
							
				list.add(new SinhVien(rs.getString("maSinhVien"), rs.getString("tenSinhVien"),
						rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"),rs.getString("diachi"),rs.getString("heDaoTao") ,new Nganh(rs.getString("maNganh")),
						new LopHoc(rs.getString("maLop"))));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi hệ thống");
		}
		return list;
}
	public List<SinhVien> getSinhVienALLTheoMaNganh(String ma) {
		List<SinhVien> list = new ArrayList<SinhVien>();
		
		try {
			String sql = "select * from SinhVien where maNganh = '"+ma+"' ";
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);
			rs = psSinhVien.executeQuery();
			while (rs.next()) {	
				list.add(new SinhVien(rs.getString("maSinhVien"), rs.getString("tenSinhVien"),
						rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"),rs.getString("diachi"),rs.getString("heDaoTao") ,new Nganh(rs.getString("maNganh")),
						new LopHoc(rs.getString("maLop"))));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi hệ thống");
		}
		return list;
		
	}
	public List<SinhVien> getSinhVienTheoLhp(String lhp) {
		List<SinhVien> list = new ArrayList<SinhVien>();
		try {
			String sql = "select * from (SinhVien sv join PhieuDangKyHocPhan pdk on pdk.maSinhVien = sv.maSinhVien) join LopHocPhan lhp on lhp.maLopHP =pdk.maLopHP  where lhp.maLopHP ='"
					+ lhp + "'";
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);
			rs = psSinhVien.executeQuery();
			while (rs.next()) {

				list.add(new SinhVien(rs.getString("maSinhVien"), rs.getString("tenSinhVien"),
						rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"), new Nganh(rs.getString("maNganh")),
						new LopHoc(rs.getString("maLop"))));

			}
			String sql2 = "select * from (SinhVien sv join PhieuDangKiHocPhanKhongTH pdk on pdk.maSinhVien = sv.maSinhVien) join LopHocPhan lhp on lhp.maLopHP =pdk.maLopHP  where lhp.maLopHP ='"
					+ lhp + "'";
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql2);
			rs = psSinhVien.executeQuery();
			while (rs.next()) {

				list.add(new SinhVien(rs.getString("maSinhVien"), rs.getString("tenSinhVien"),
						rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"), new Nganh(rs.getString("maNganh")),
						new LopHoc(rs.getString("maLop"))));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	public List<SinhVien> getSinhVienALL() {
		List<SinhVien> list = new ArrayList<SinhVien>();
		
		try {
			String sql = "select * from SinhVien ";
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);
//			psSinhVien.setString(1, id);
			rs = psSinhVien.executeQuery();
			while (rs.next()) {
				
//				(String maSinhVien, String tenSinhVien, boolean gioiTinh, Date ngaySinh, String diaChi,
//						String heDaoTao, Nganh nganhEnity, TaiKhoan taiKhoanEnity, LopHoc lopEnity, NguoiQuanLi nguoiQuanLi
				
				list.add(new SinhVien(rs.getString("maSinhVien"), rs.getString("tenSinhVien"),
						rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"),rs.getString("diachi"),rs.getString("heDaoTao") ,new Nganh(rs.getString("maNganh")),
						new LopHoc(rs.getString("maLop"))));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi hệ thống");
		}
		return list;
		
	}
	public boolean themSinhVien(SinhVien sv) {
		String sql  = "insert into SinhVien([tenSinhVien], [gioiTinh], [ngaySinh], [heDaoTao], [diaChi], [maLop], [tenDangNhap], [maNganh], [maQuanLy]) values(?,?,?,?,?,?,?,?,?)";
		try {
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);
//			psSinhVien.setString(1,getMaSinhVien());
			psSinhVien.setString(1,sv.getTenSinhVien());
			psSinhVien.setBoolean(2,sv.isGioiTinh());
			psSinhVien.setDate(3,sv.getNgaySinh());
			psSinhVien.setString(4,sv.getHeDaoTao());
			psSinhVien.setString(5,sv.getDiaChi());
			psSinhVien.setString(6,sv.getLopEnity().getMaLop());
			psSinhVien.setString(7,new TaiKhoanDAO().getTenDangNhap());
			psSinhVien.setString(8,sv.getNganhEnity().getMaNganh());
			psSinhVien.setString(9,"QL01");
			return psSinhVien.executeUpdate()>0;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
		
	}

	public ResultSet loadThoiKhoaBieuLiThuyetTheoMaSinhvien(String maSinhVien) {
		String sql = "select lt.tietHoc,lt.maGiangVien,lhp.maMonHoc,lt.maPhongHoc,lt.thu  from ((NhomLyThuyet lt join LopHocPhan lhp on lhp.maLopHP = lt.maLopHP) join PhieuDangKyHocPhan pdk on pdk.maLopHP =lhp.maLopHP) JOIN LopHocPhan lhp on lhp.maLopHP = pdk.maLopHP where pdk.maSinhVien ='"
				+ maSinhVien + "'";
					try {
						con = db.getConnection();
						psSinhVien = con.prepareStatement(sql);						
						return psSinhVien.executeQuery();
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
		return null;

	}
	public ResultSet LoadLichHocThucHanh(String maSinhVien) {
		String sql = "SELECT nth.tietHoc,nth.maGiangVien,lhp.maMonHoc,nth.maPhongHoc,nth.thu FROM (PhieuDangKyHocPhan pdk JOIN NhomThucHanh nth on nth.maNhom = pdk.maNhom) JOIN LopHocPhan lhp on lhp.maLopHP = pdk.maLopHP WHERE pdk.maSinhVien= '"+maSinhVien+"'";
					try {
						con = db.getConnection();
						psSinhVien = con.prepareStatement(sql);						
						return psSinhVien.executeQuery();
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
		return null;

	}
	public ResultSet loadThoiKhoaBieuCoThucHanhTheoMaSinhvien(String maSinhVien) {
		String sql = "SELECT lhp.tietHoc,lhp.maGiangVien,lhp.maMonHoc,lhp.maPhongHoc,lhp.thu FROM PhieuDangKyHocPhan pdk JOIN LopHocPhan lhp on lhp.maLopHP = pdk.maLopHP where pdk.maSinhVien ='"+maSinhVien+"'";
					try {
//						PhieuDangKyHocPhan
						con = db.getConnection();
						psSinhVien = con.prepareStatement(sql);						
						return psSinhVien.executeQuery();
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Không được");
					}
		return null;

	}
	public ResultSet loadThoiKhoaBieuLyThuyetTheoMaSinhvienCoTH(String maSinhVien) {
		String sql = "SELECT lhp.tietHoc,lhp.maGiangVien,lhp.maMonHoc,lhp.maPhongHoc,lhp.thu FROM PhieuDangKiHocPhanKhongTH pdk JOIN LopHocPhan lhp on lhp.maLopHP = pdk.maLopHP where pdk.maSinhVien ='"+maSinhVien+"'";
					try {
						con = db.getConnection();
						psSinhVien = con.prepareStatement(sql);						
						return psSinhVien.executeQuery();
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Không được");
					}
		return null;

	}
	public boolean xoaSinhVien(String maSinhVien) {
		String sqltk = "delete TaiKhoan where tenDangNhap ='"+maSinhVien+"'";
		String sql = "delete SinhVien where maSinhVien ='"+maSinhVien+"'";
		try {
			con = db.getConnection();
			psXoaTaiKhoanSinhVien = con.prepareStatement(sqltk);						
			psSinhVien = con.prepareStatement(sql);						
			psXoaTaiKhoanSinhVien.executeUpdate();
			return psSinhVien.executeUpdate()>0;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sinh viên đang học, không thể xóa sinh viên");
		}
		return false;
		
	}
	public String getMaSinhVien() {
		String ma = "SV0";
		String sql = "select count(maSinhVien)+1 as maSV from SinhVien ";
		try {
			con = db.getConnection();
			psXoaTaiKhoanSinhVien = con.prepareStatement(sql);						
			psSinhVien = con.prepareStatement(sql);						
			rs= psXoaTaiKhoanSinhVien.executeQuery();
			while (rs.next()) {
				ma += String.valueOf(rs.getInt(1));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return ma;
		
	}
	public String getChuyenNganhSinhVien(String maSinhVien) {
		String maChuyenNganh ="";
		String sql = "SELECT maNganh FROM SinhVien WHERE maSinhVien = '"+maSinhVien+"'";
		try {
			con = db.getConnection();
			psXoaTaiKhoanSinhVien = con.prepareStatement(sql);						
			psSinhVien = con.prepareStatement(sql);						
			rs= psXoaTaiKhoanSinhVien.executeQuery();
			while (rs.next()) {
				maChuyenNganh = rs.getString(1);
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return maChuyenNganh;
		
	}
	public List<String> monHocDaDangKi(String maSinhVien) {
		List<String> list = new ArrayList<String>();
		String sql ="select mh.tenMonHoc from (MonHoc mh join LopHocPhan lhp on lhp.maMonHoc = mh.maMonHoc) JOIN PhieuDangKyHocPhan pdk on pdk.maLopHP = lhp.maLopHP WHERE pdk.maSinhVien ='"+maSinhVien+"'";
		try {
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);							
			rs= psSinhVien.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return list;
		
	}
	public List<String> monHocDaDangKiKhongThucHanh(String maSinhVien) {
		List<String> list = new ArrayList<String>();
		String sql ="select mh.tenMonHoc from (MonHoc mh join LopHocPhan lhp on lhp.maMonHoc = mh.maMonHoc) JOIN PhieuDangKiHocPhanKhongTH pdk on pdk.maLopHP = lhp.maLopHP WHERE pdk.maSinhVien ='"+maSinhVien+"'";
		try {
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);							
			rs= psSinhVien.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return list;
		
	}
	public ResultSet DanhSachCongNo(String maSinhVien) {
		String sql ="SELECT lhp.maLopHP,mh.tenMonHoc,(mh.soTCLyThuyet+soTCThucHanh) as tinChi,pdk.congNo,lhp.hocKy,pdk.maSinhVien,lhp.namHoc FROM (PhieuDangKyHocPhan pdk JOIN LopHocPhan lhp on lhp.maLopHP = pdk.maLopHP) JOIN MonHoc mh on mh.maMonHoc = lhp.maMonHoc WHERE maSinhVien = '"+maSinhVien+"'";
		try {
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);							
			rs= psSinhVien.executeQuery();
			return rs;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
		
	}
	public boolean capNhatSinhVien(String maSinhVien,String hoten,String maLop,Date ngaySinh,String diachi,String heDaoTao,boolean gioiTinh) {
		String sql ="update SinhVien set tenSinhVien= '"+hoten+"', maLop = '"+maLop+"',ngaySinh='"+ngaySinh+"',diaChi = '"+diachi+"',heDaoTao='"+heDaoTao+"',gioiTinh='"+gioiTinh+"' where maSinhVien = '"+maSinhVien+"'";
		try {
			con = db.getConnection();
			psSinhVien = con.prepareStatement(sql);							
			
			return psSinhVien.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gioiTinh;
		
	}
}
