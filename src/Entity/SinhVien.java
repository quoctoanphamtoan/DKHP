package Entity;

import java.sql.Date;

import DAO.LopDAO;
import DAO.SinhVienDAO;

public class SinhVien {
	private String maSinhVien;
	private String tenSinhVien;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String heDaoTao;
	private Nganh nganhEnity;
	private TaiKhoan taiKhoanEnity;
	private LopHoc lopEnity;
	private NguoiQuanLi nguoiQuanLi;
	
	public NguoiQuanLi getNguoiQuanLi() {
		return nguoiQuanLi;
	}
	public void setNguoiQuanLi(NguoiQuanLi nguoiQuanLi) {
		this.nguoiQuanLi = nguoiQuanLi;
	}
	
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getTenSinhVien() {
		return tenSinhVien;
	}
	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(String heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public Nganh getNganhEnity() {
		return nganhEnity;
	}
	public void setNganhEnity(Nganh nganhEnity) {
		this.nganhEnity = nganhEnity;
	}
	public TaiKhoan getTaiKhoanEnity() {
		return taiKhoanEnity;
	}
	public void setTaiKhoanEnity(TaiKhoan taiKhoanEnity) {
		this.taiKhoanEnity = taiKhoanEnity;
	}
	public LopHoc getLopEnity() {
		return lopEnity;
	}
	public void setLopEnity(LopHoc lopEnity) {
		this.lopEnity = lopEnity;
	}
	
	public SinhVien(String tenSinhVien, boolean gioiTinh, Date ngaySinh, String diaChi, String heDaoTao,
			Nganh nganhEnity, TaiKhoan taiKhoanEnity, LopHoc lopEnity, NguoiQuanLi nguoiQuanLi) {
		super();
		this.tenSinhVien = tenSinhVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.heDaoTao = heDaoTao;
		this.nganhEnity = nganhEnity;
		this.taiKhoanEnity = taiKhoanEnity;
		this.lopEnity = lopEnity;
		this.nguoiQuanLi = nguoiQuanLi;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SinhVien(String maSinhVien) {
		super();
		this.maSinhVien = maSinhVien;
	}
	
	public SinhVien(String maSinhVien, String tenSinhVien, boolean gioiTinh, Date ngaySinh, 
			Nganh nganhEnity, LopHoc lopEnity) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;

		
		this.nganhEnity = nganhEnity;
	
		this.lopEnity = lopEnity;
		
	}
	
	public SinhVien(String maSinhVien, String tenSinhVien) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
	}
	
	
	
	public SinhVien(String maSinhVien, String tenSinhVien, boolean gioiTinh, Date ngaySinh, 
			String heDaoTao,String diaChi, Nganh nganhEnity, TaiKhoan taiKhoanEnity, LopHoc lopEnity) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.heDaoTao = heDaoTao;
		this.nganhEnity = nganhEnity;
		this.taiKhoanEnity = taiKhoanEnity;
		this.lopEnity = lopEnity;
		this.nguoiQuanLi = nguoiQuanLi;
	}
	
	public SinhVien(String maSinhVien, String tenSinhVien, boolean gioiTinh, Date ngaySinh, String diaChi,
			String heDaoTao, Nganh nganhEnity, LopHoc lopEnity) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.heDaoTao = heDaoTao;
		this.nganhEnity = nganhEnity;
		this.lopEnity = lopEnity;
	}
	
	public SinhVien(String maSinhVien, String tenSinhVien, boolean gioiTinh, Date ngaySinh, String diaChi,
			String heDaoTao, Nganh nganhEnity, TaiKhoan taiKhoanEnity, LopHoc lopEnity, NguoiQuanLi nguoiQuanLi) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.heDaoTao = heDaoTao;
		this.nganhEnity = nganhEnity;
		this.taiKhoanEnity = taiKhoanEnity;
		this.lopEnity = lopEnity;
		this.nguoiQuanLi = nguoiQuanLi;
	} 
	
	@Override
	public String toString() {
		return "SinhVienEnity [maSinhVien=" + maSinhVien + ", tenSinhVien=" + tenSinhVien + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", heDaoTao=" + heDaoTao + ", nganhEnity="
				+ nganhEnity + ", taiKhoanEnity=" + taiKhoanEnity + ", lopEnity=" + lopEnity + "]";
	}
	

	
	
	

}
