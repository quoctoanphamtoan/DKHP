package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DATABASE.ConnectDataBase;
import Entity.LichHoc;
import Entity.LopHoc;

public class LichHocDAO {
	private ConnectDataBase db ;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psLich;
	private PreparedStatement psLop;
	public LichHocDAO() {
		db = new ConnectDataBase();
		con=db.getConnection();
	} 
	public List<LichHoc> getlichHoc(String maSV) {
		List<LichHoc> listLich = new ArrayList<>();
		String sql="select mh.tenMonHoc,lhp.thu,lhp.tietHoc,gv.tenGiangVien from (((LopHocPhan lhp join PhieuDangKyHocPhan pdk on pdk.maLopHP= lhp.maLopHP) join SinhVien sv on sv.maSinhVien = pdk.maSinhVien) join MonHoc mh on mh.maMonHoc = lhp.maMonHoc) join GiangVien gv on gv.maGiangVien = lhp.maGiangVien where sv.maSinhVien=?";
		try {
			con= db.getConnection();
			psLich = con.prepareStatement(sql);
			psLich.setString(1, maSV);
			rs = psLich.executeQuery();
			while (rs.next()) {
				String monhoc = rs.getString(1);
				String thu =rs.getString(2);
				String tiethoc  = rs.getString(3);
				String giangvien = rs.getString(4);
				listLich.add(new LichHoc(monhoc,thu,tiethoc,giangvien));
				
			}
			
			return listLich;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}
//	public List<LopHocPhan> SinhVienDangKiTrungThuTiet(v) {
//		
//	}
	
}
