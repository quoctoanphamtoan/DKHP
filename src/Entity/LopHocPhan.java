package Entity;

import java.sql.Date;

public class LopHocPhan {
	private String maLopHP;
	private int hocKy;
	private String namHoc;
	private MonHoc monHocEnity;
	private Date ngayThi;
	private String tietHoc;
	private String thu;
	private int siSo;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private int soNhomThucHanh;
	private PhongHoc phongHoc;
	private GiangVien giangVien;
	private  NhanVienPhongDaoTao nhanVienPhongDaoTao;
	public String getMaLopHP() {
		return maLopHP;
	}
	
	public void setMaLopHP(String maLopHP) {
		this.maLopHP = maLopHP;
	}
	public int getHocKy() {
		return hocKy;
	}
	public void setHocKy(int hocKy) {
		this.hocKy = hocKy;
	}
	public String getNamHoc() {
		return namHoc;
	}
	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}
	public MonHoc getMonHocEnity() {
		return monHocEnity;
	}
	public void setMonHocEnity(MonHoc monHocEnity) {
		this.monHocEnity = monHocEnity;
	}
	public Date getNgayThi() {
		return ngayThi;
	}
	public void setNgayThi(Date ngayThi) {
		this.ngayThi = ngayThi;
	}
	public String getTietHoc() {
		return tietHoc;
	}
	public void setTietHoc(String tietHoc) {
		this.tietHoc = tietHoc;
	}
	public String getThu() {
		return thu;
	}
	public void setThu(String thu) {
		this.thu = thu;
	}
	public int getSiSo() {
		return siSo;
	}
	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}
	public PhongHoc getPhongHoc() {
		return phongHoc;
	}
	public void setPhongHoc(PhongHoc phongHoc) {
		this.phongHoc = phongHoc;
	}
	public GiangVien getGiangVien() {
		return giangVien;
	}
	
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	public NhanVienPhongDaoTao getNhanVienPhongDaoTao() {
		return nhanVienPhongDaoTao;
	}
	public void setNhanVienPhongDaoTao(NhanVienPhongDaoTao nhanVienPhongDaoTao) {
		this.nhanVienPhongDaoTao = nhanVienPhongDaoTao;
	}
	
	public int getSoNhomThucHanh() {
		return soNhomThucHanh;
	}
	public void setSoNhomThucHanh(int soNhomThucHanh) {
		this.soNhomThucHanh = soNhomThucHanh;
	}
	
	
	
	
	public LopHocPhan(String maLopHP, int hocKy, String namHoc, MonHoc monHocEnity, Date ngayThi, String tietHoc,
			String thu, int siSo, Date ngayBatDau, Date ngayKetThuc, int soNhomThucHanh, PhongHoc phongHoc,
			GiangVien giangVien, NhanVienPhongDaoTao nhanVienPhongDaoTao) {
		super();
		this.maLopHP = maLopHP;
		this.hocKy = hocKy;
		this.namHoc = namHoc;
		this.monHocEnity = monHocEnity;
		this.ngayThi = ngayThi;
		this.tietHoc = tietHoc;
		this.thu = thu;
		this.siSo = siSo;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.soNhomThucHanh = soNhomThucHanh;
		this.phongHoc = phongHoc;
		this.giangVien = giangVien;
		this.nhanVienPhongDaoTao = nhanVienPhongDaoTao;
	}
	public LopHocPhan(String maLopHP, int hocKy, String namHoc, MonHoc monHocEnity, String tietHoc,
			String thu, int siSo, Date ngayBatDau, Date ngayKetThuc, int soNhomThucHanh, PhongHoc phongHoc,
			GiangVien giangVien) {
		super();
		this.maLopHP = maLopHP;
		this.hocKy = hocKy;
		this.namHoc = namHoc;
		this.monHocEnity = monHocEnity;
		this.tietHoc = tietHoc;
		this.thu = thu;
		this.siSo = siSo;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.soNhomThucHanh = soNhomThucHanh;
		this.phongHoc = phongHoc;
		this.giangVien = giangVien;
	}
	public LopHocPhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "LopHocPhan [maLopHP=" + maLopHP + ", hocKy=" + hocKy + ", namHoc=" + namHoc + ", monHocEnity="
				+ monHocEnity + ", ngayThi=" + ngayThi + ", tietHoc=" + tietHoc + ", thu=" + thu + ", siSo=" + siSo
				+ ", phongHoc=" + phongHoc + ", giangVien=" + giangVien + ", nhanVienPhongDaoTao=" + nhanVienPhongDaoTao
				+ "]";
	}
	

	public LopHocPhan(MonHoc monHocEnity, String tietHoc, String thu) {
		super();
		this.monHocEnity = monHocEnity;
		this.tietHoc = tietHoc;
		this.thu = thu;
	}

	public LopHocPhan(String maLopHP) {
		super();
		this.maLopHP = maLopHP;
	}

	public LopHocPhan(int hocKy, String namHoc, MonHoc monHocEnity, Date ngayThi, String tietHoc, String thu, int siSo,
			Date ngayBatDau, Date ngayKetThuc, int soNhomThucHanh, PhongHoc phongHoc, GiangVien giangVien,
			NhanVienPhongDaoTao nhanVienPhongDaoTao) {
		super();
		this.hocKy = hocKy;
		this.namHoc = namHoc;
		this.monHocEnity = monHocEnity;
		this.ngayThi = ngayThi;
		this.tietHoc = tietHoc;
		this.thu = thu;
		this.siSo = siSo;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.soNhomThucHanh = soNhomThucHanh;
		this.phongHoc = phongHoc;
		this.giangVien = giangVien;
		this.nhanVienPhongDaoTao = nhanVienPhongDaoTao;
	}
	

	
	
	
	
	
	
	
	
	
}
