package Entity;

public class PhongHoc {
	private String maphongHoc;
	private String tenPhongHoc;
	private String day;
	private String loaiPhong;
	private NguoiQuanLi nguoiQuanLi;

	
	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public NguoiQuanLi getNguoiQuanLi() {
		return nguoiQuanLi;
	}

	public void setNguoiQuanLi(NguoiQuanLi nguoiQuanLi) {
		this.nguoiQuanLi = nguoiQuanLi;
	}

	public String getMaphongHoc() {
		return maphongHoc;
	}

	public void setMaphongHoc(String maphongHoc) {
		this.maphongHoc = maphongHoc;
	}

	public String getTenPhongHoc() {
		return tenPhongHoc;
	}

	public void setTenPhongHoc(String tenPhongHoc) {
		this.tenPhongHoc = tenPhongHoc;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;

	}

	public PhongHoc() {
		super();
	}

	public PhongHoc(String maphongHoc) {
		super();
		this.maphongHoc = maphongHoc;
	}


	public PhongHoc(String maphongHoc, String tenPhongHoc, String day, String loaiPhong, NguoiQuanLi nguoiQuanLi) {
		super();
		this.maphongHoc = maphongHoc;
		this.tenPhongHoc = tenPhongHoc;
		this.day = day;
		this.loaiPhong = loaiPhong;
		this.nguoiQuanLi = nguoiQuanLi;
	}

	public PhongHoc(String maphongHoc, String tenPhongHoc, String day, String loaiPhong) {
		super();
		this.maphongHoc = maphongHoc;
		this.tenPhongHoc = tenPhongHoc;
		this.day = day;
		this.loaiPhong = loaiPhong;
	}

	public PhongHoc(String tenPhongHoc, String day, String loaiPhong, NguoiQuanLi nguoiQuanLi) {
		super();
		this.tenPhongHoc = tenPhongHoc;
		this.day = day;
		this.loaiPhong = loaiPhong;
		this.nguoiQuanLi = nguoiQuanLi;
	}

	public PhongHoc(String maphongHoc, String tenPhongHoc, String day) {
		super();
		this.maphongHoc = maphongHoc;
		this.tenPhongHoc = tenPhongHoc;
		this.day = day;
	}

	@Override
	public String toString() {
		return "PhongHoc [maphongHoc=" + maphongHoc + ", tenPhongHoc=" + tenPhongHoc + ", day=" + day + "]";
	}

}
