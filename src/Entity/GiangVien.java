package Entity;

import java.sql.Date;

public class GiangVien{
	private String maGiangVien;
	private String tenGiangVien;
	private boolean gioiTinh;
	private Date ngaySinh;
	private Nganh nganh;
	private NguoiQuanLi nguoiQuanLi;
	
	public NguoiQuanLi getNguoiQuanLi() {
		return nguoiQuanLi;
	}
	public void setNguoiQuanLi(NguoiQuanLi nguoiQuanLi) {
		this.nguoiQuanLi = nguoiQuanLi;
	}
	public String getMaGiangVien() {
		return maGiangVien;
	}
	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}
	public String getTenGiangVien() {
		return tenGiangVien;
	}
	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
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
	public Nganh getNganh() {
		return nganh;
	}
	public void setNganh(Nganh nganh) {
		this.nganh = nganh;
	}
	
	public GiangVien(String maGiangVien, String tenGiangVien, boolean gioiTinh, Date ngaySinh, Nganh nganh,
			NguoiQuanLi nguoiQuanLi) {
		super();
		this.maGiangVien = maGiangVien;
		this.tenGiangVien = tenGiangVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.nganh = nganh;
		this.nguoiQuanLi = nguoiQuanLi;
	}
	public GiangVien(String tenGiangVien, boolean gioiTinh, Date ngaySinh, Nganh nganh, NguoiQuanLi nguoiQuanLi) {
		super();
		this.tenGiangVien = tenGiangVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.nganh = nganh;
		this.nguoiQuanLi = nguoiQuanLi;
	}
	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GiangVien(String maGiangVien) {
		super();
		this.maGiangVien = maGiangVien;
	}
	
	@Override
	public String toString() {
		return "GiangVienEnity [maGiangVien=" + maGiangVien + ", tenGiangVien=" + tenGiangVien + ", gioiTinh="
				+ gioiTinh + ", ngaySinh=" + ngaySinh + ", nganh=" + nganh + "]";
	}
	public GiangVien(String maGiangVien, String tenGiangVien) {
		super();
		this.maGiangVien = maGiangVien;
		this.tenGiangVien = tenGiangVien;
	}
	public GiangVien(String maGiangVien, String tenGiangVien, boolean gioiTinh, Date ngaySinh) {
		super();
		this.maGiangVien = maGiangVien;
		this.tenGiangVien = tenGiangVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
	}
	public GiangVien(String maGiangVien, String tenGiangVien, boolean gioiTinh, Date ngaySinh, Nganh nganh) {
		super();
		this.maGiangVien = maGiangVien;
		this.tenGiangVien = tenGiangVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.nganh = nganh;
	}
	
	
	
	
	

}
