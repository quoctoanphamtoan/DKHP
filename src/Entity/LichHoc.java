package Entity;

public class LichHoc {
	private String tenMonHoc;
	private String thu;
	private String tiethoc;
	private String tengiangvien;
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public String getThu() {
		return thu;
	}
	public void setThu(String thu) {
		this.thu = thu;
	}
	public String getTiethoc() {
		return tiethoc;
	}
	public void setTiethoc(String tiethoc) {
		this.tiethoc = tiethoc;
	}
	public String getTengiangvien() {
		return tengiangvien;
	}
	public void setTengiangvien(String tengiangvien) {
		this.tengiangvien = tengiangvien;
	}
	public LichHoc(String tenMonHoc, String thu, String tiethoc, String tengiangvien) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.thu = thu;
		this.tiethoc = tiethoc;
		this.tengiangvien = tengiangvien;
	}
	public LichHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
