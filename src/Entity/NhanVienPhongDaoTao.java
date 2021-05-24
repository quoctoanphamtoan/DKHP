package Entity;

import java.sql.Date;

public class NhanVienPhongDaoTao {
	private String maNhanVien;
	private String tenNhanVien;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private TaiKhoan taiKhoan;
	private NguoiQuanLi nguoiQuanLi;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public NguoiQuanLi getNguoiQuanLi() {
		return nguoiQuanLi;
	}
	public void setNguoiQuanLi(NguoiQuanLi nguoiQuanLi) {
		this.nguoiQuanLi = nguoiQuanLi;
	}
	public NhanVienPhongDaoTao(String maNhanVien, String tenNhanVien, boolean gioiTinh, Date ngaySinh, String diaChi,
			TaiKhoan taiKhoan, NguoiQuanLi nguoiQuanLi) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.nguoiQuanLi = nguoiQuanLi;
	}
	public NhanVienPhongDaoTao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVienPhongDaoTao(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	
	

}
