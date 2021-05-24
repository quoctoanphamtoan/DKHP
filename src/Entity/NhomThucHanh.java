package Entity;



public class NhomThucHanh {
	private int maNhom;
	private int tenNhom;
	private String tietHoc;
	private String thu;
	private int siSo;
	private LopHocPhan lopHocPhan;
	private PhongHoc phongHoc;
	private GiangVien giangVien;
	public int getMaNhom() {
		return maNhom;
	}
	public int getTenNhom() {
		return tenNhom;
	}
	public void setTenNhom(int tenNhom) {
		this.tenNhom = tenNhom;
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
	public LopHocPhan getLopHocPhan() {
		return lopHocPhan;
	}
	public void setLopHocPhan(LopHocPhan lopHocPhan) {
		this.lopHocPhan = lopHocPhan;
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
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	public void setMaNhom(int maNhom) {
		this.maNhom = maNhom;
	}
	public NhomThucHanh(int maNhom, int tenNhom, String tietHoc, String thu, int siSo, LopHocPhan lopHocPhan,
			PhongHoc phongHoc, GiangVien giangVien) {
		super();
		this.maNhom = maNhom;
		this.tenNhom = tenNhom;
		this.tietHoc = tietHoc;
		this.thu = thu;
		this.siSo = siSo;
		this.lopHocPhan = lopHocPhan;
		this.phongHoc = phongHoc;
		this.giangVien = giangVien;
	}
	@Override
	public String toString() {
		return  tenNhom+""; 
	}
	
	
	
	
	

}
