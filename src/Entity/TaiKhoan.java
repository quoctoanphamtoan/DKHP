package Entity;

public class TaiKhoan {
	private String taiKhoan;
	private String matKhau;
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public TaiKhoan(String taiKhoan, String matKhau) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TaiKhoan(String taiKhoan) {
		super();
		this.taiKhoan = taiKhoan;
	}
	@Override
	public String toString() {
		return "TaiKhoanEnity [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + "]";
	}
	
	
}
