package Entity;

public class Nganh {
	private String maNganh;
	private String tenNganh;
	public String getMaNganh() {
		return maNganh;
	}
	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}
	public String getTenNganh() {
		return tenNganh;
	}
	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}
	public Nganh(String maNganh, String tenNganh) {
		super();
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
	}
	public Nganh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Nganh(String maNganh) {
		super();
		this.maNganh = maNganh;
	}
	@Override
	public String toString() {
		return "NganhEnity [maNganh=" + maNganh + ", tenNganh=" + tenNganh + "]";
	}

	
	
}
