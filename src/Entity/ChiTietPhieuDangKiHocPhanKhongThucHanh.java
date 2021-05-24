package Entity;

import java.sql.Date;

public class ChiTietPhieuDangKiHocPhanKhongThucHanh {
	private SinhVien sinhVien;
	private LopHocPhan lopHocPhan;
	private float congNo;
	private Date ngayDangKi;
	private NhomThucHanh nhomThucHanh;
	public SinhVien getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	public LopHocPhan getLopHocPhan() {
		return lopHocPhan;
	}
	public void setLopHocPhan(LopHocPhan lopHocPhan) {
		this.lopHocPhan = lopHocPhan;
	}
	public float getCongNo() {
		return congNo;
	}
	public void setCongNo(float congNo) {
		this.congNo = congNo;
	}
	public Date getNgayDangKi() {
		return ngayDangKi;
	}
	public void setNgayDangKi(Date ngayDangKi) {
		this.ngayDangKi = ngayDangKi;
	}
	public NhomThucHanh getNhomThucHanh() {
		return nhomThucHanh;
	}
	public void setNhomThucHanh(NhomThucHanh nhomThucHanh) {
		this.nhomThucHanh = nhomThucHanh;
	}
	public ChiTietPhieuDangKiHocPhanKhongThucHanh(SinhVien sinhVien, LopHocPhan lopHocPhan, float congNo,
			Date ngayDangKi) {
		super();
		this.sinhVien = sinhVien;
		this.lopHocPhan = lopHocPhan;
		this.congNo = congNo;
		this.ngayDangKi = ngayDangKi;
	}
	public ChiTietPhieuDangKiHocPhanKhongThucHanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
