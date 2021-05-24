package Entity;

public class LopHoc {
	 private String	maLop;
	 private String	tenLop;
	 private NguoiQuanLi quanly;
	 
	public NguoiQuanLi getQuanly() {
		return quanly;
	}
	public void setQuanly(NguoiQuanLi quanly) {
		this.quanly = quanly;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public LopHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LopHoc(String maLop) {
		super();
		this.maLop = maLop;
	}
	public LopHoc(String maLop, String tenLop, NguoiQuanLi quanly) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.quanly = quanly;
	}
	public LopHoc(String maLop, String tenLop) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
	}
	
	@Override
	public String toString() {
		return "LopHoc [maLop=" + maLop + ", tenLop=" + tenLop + ", quanly=" + quanly + "]";
	}
	
	
	 

}
