package Entity;

public class NguoiQuanLi {
	private String maQuanLi;
	private String tenQuanLi;
	private TaiKhoan taiKhoan;
	public String getMaQuanLi() {
		return maQuanLi;
	}
	public void setMaQuanLi(String maQuanLi) {
		this.maQuanLi = maQuanLi;
	}
	public String getTenQuanLi() {
		return tenQuanLi;
	}
	public void setTenQuanLi(String tenQuanLi) {
		this.tenQuanLi = tenQuanLi;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public NguoiQuanLi(String maQuanLi, String tenQuanLi, TaiKhoan taiKhoan) {
		super();
		this.maQuanLi = maQuanLi;
		this.tenQuanLi = tenQuanLi;
		this.taiKhoan = taiKhoan;
	}
	public NguoiQuanLi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NguoiQuanLi(String maQuanLi) {
		super();
		this.maQuanLi = maQuanLi;
	}
	
	

}
