package Entity;

public class MonHoc {
	private String maMonHoc;
	private String tenMonHoc;
	private String monHocTienQuyet;
	private int soTCLyThuyet;
	private int soTCThucHanh;
	private Nganh nganh;
	private NguoiQuanLi nguoiQuanLi;
	
	
	
	public Nganh getNganh() {
		return nganh;
	}


	public void setNganh(Nganh nganh) {
		this.nganh = nganh;
	}


	public NguoiQuanLi getNguoiQuanLi() {
		return nguoiQuanLi;
	}


	public void setNguoiQuanLi(NguoiQuanLi nguoiQuanLi) {
		this.nguoiQuanLi = nguoiQuanLi;
	}


	public String getMaMonHoc() {
		return maMonHoc;
	}


	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}


	public String getTenMonHoc() {
		return tenMonHoc;
	}


	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}


	public String getMonHocTienQuyet() {
		return monHocTienQuyet;
	}


	public void setMonHocTienQuyet(String monHocTienQuyet) {
		this.monHocTienQuyet = monHocTienQuyet;
	}


	public int getSoTCLyThuyet() {
		return soTCLyThuyet;
	}


	public void setSoTCLyThuyet(int soTCLyThuyet) {
		this.soTCLyThuyet = soTCLyThuyet;
	}


	public int getSoTCThucHanh() {
		return soTCThucHanh;
	}


	public void setSoTCThucHanh(int soTCThucHanh) {
		this.soTCThucHanh = soTCThucHanh;
	}


	public MonHoc() {
		super();
	}


	public MonHoc(String maMonHoc, String tenMonHoc, String monHocTienQuyet, int soTCLyThuyet, int soTCThucHanh) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.monHocTienQuyet = monHocTienQuyet;
		this.soTCLyThuyet = soTCLyThuyet;
		this.soTCThucHanh = soTCThucHanh;
	}


	public MonHoc(String maMonHoc) {
		super();
		this.maMonHoc = maMonHoc;
	}
	


	@Override
	public String toString() {
		return "MonHocEnity [maMonHoc=" + maMonHoc + ", tenMonHoc=" + tenMonHoc + ", monHocTienQuyet=" + monHocTienQuyet
				+ ", soTCLyThuyet=" + soTCLyThuyet + ", soTCThucHanh=" + soTCThucHanh + "]";
	}


	public MonHoc(String maMonHoc, String tenMonHoc, String monHocTienQuyet, int soTCLyThuyet, int soTCThucHanh,
			NguoiQuanLi nguoiQuanLi) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.monHocTienQuyet = monHocTienQuyet;
		this.soTCLyThuyet = soTCLyThuyet;
		this.soTCThucHanh = soTCThucHanh;
		this.nguoiQuanLi = nguoiQuanLi;
	}


	public MonHoc(String maMonHoc, String tenMonHoc, String monHocTienQuyet, int soTCLyThuyet, int soTCThucHanh,
			Nganh nganh, NguoiQuanLi nguoiQuanLi) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.monHocTienQuyet = monHocTienQuyet;
		this.soTCLyThuyet = soTCLyThuyet;
		this.soTCThucHanh = soTCThucHanh;
		this.nganh = nganh;
		this.nguoiQuanLi = nguoiQuanLi;
	}


	public MonHoc(String maMonHoc, String tenMonHoc, String monHocTienQuyet, int soTCLyThuyet, int soTCThucHanh,
			Nganh nganh) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.monHocTienQuyet = monHocTienQuyet;
		this.soTCLyThuyet = soTCLyThuyet;
		this.soTCThucHanh = soTCThucHanh;
		this.nganh = nganh;
	}


	public MonHoc(String tenMonHoc, String monHocTienQuyet, int soTCLyThuyet, int soTCThucHanh, Nganh nganh,
			NguoiQuanLi nguoiQuanLi) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.monHocTienQuyet = monHocTienQuyet;
		this.soTCLyThuyet = soTCLyThuyet;
		this.soTCThucHanh = soTCThucHanh;
		this.nganh = nganh;
		this.nguoiQuanLi = nguoiQuanLi;
	}
	
	
	
	
}
