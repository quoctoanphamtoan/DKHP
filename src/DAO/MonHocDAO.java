	package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DATABASE.ConnectDataBase;
import Entity.MonHoc;
import Entity.Nganh;
import Entity.NguoiQuanLi;

public class MonHocDAO {
	private ConnectDataBase db;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psMonHoc;

	public MonHocDAO() {
		db = new ConnectDataBase();
		con = db.getConnection();
	}

	public String getTenMonHoc(String id) {
		try {
			String sql = "select tenMonHoc from MonHoc  where maMonHoc=?";
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
			psMonHoc.setString(1, id);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				return rs.getString(1);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Kh�ng c� ";

	}

	public List<MonHoc> getAllMonHoc() {
		List<MonHoc> listMonHoc= new ArrayList<MonHoc>();
		
		try {
			String sql = "select * from MonHoc";
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				listMonHoc.add(new MonHoc(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),new Nganh(rs.getString(6)),new NguoiQuanLi(rs.getString(7))));
				
			}
			return listMonHoc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public List<MonHoc> getAllMonHocTheoChuyenNganh(String maChuyenNganh,String namHoc,int kiHoc) {
		List<MonHoc> listMonHoc= new ArrayList<MonHoc>();
		
		try {
			String sql = "SELECT * FROM MonHoc mh join LopHocPhan lhp on lhp.maMonHoc = mh.maMonHoc where mh.maNganh = '"+maChuyenNganh+"' and lhp.hocKy = '"+kiHoc+"' and lhp.namHoc= '"+namHoc+"'";
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				listMonHoc.add(new MonHoc(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),new Nganh(rs.getString(6)),new NguoiQuanLi(rs.getString(7))));
				
			}
			return listMonHoc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMonHoc;

	}
	public List<MonHoc> getMonHocTheoChuyenNghanh(String chuyenNganh) {
		List<MonHoc> listMonHoc= new ArrayList<MonHoc>();
		
		try {
			String sql = "select * from MonHoc where maNganh ='"+chuyenNganh+"'";
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				//String maMonHoc, String tenMonHoc, String monHocTienQuyet, int soTCLyThuyet, int soTCThucHanh,
//				Nganh nganh
				listMonHoc.add(new MonHoc(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),new Nganh(rs.getString(6))));
				
			}
			return listMonHoc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public int getTinChiLithuyet(String maMonHoc) {
	
		try {
			String sql ="select soTCLyThuyet from MonHoc where maMonHoc = '"+maMonHoc+"'";
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	public int getTinChiThucHanh(String maMonHoc) {
		
		try {
			String sql ="select soTCThucHanh from MonHoc where maMonHoc = '"+maMonHoc+"'";
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	public String getMaMonHoc(String s) {

		String sql = "DECLARE @query NVARCHAR(100) SET @query = N'%"+s+"%' SELECT * FROM MonHoc WHERE   dbo.ufn_removeMark(maMonHoc) LIKE @query OR tenMonHoc LIKE @query";
		try {
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
//			psGiangVien.setString(1, s);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				return rs.getString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";

	}
	public boolean themMonHoc(MonHoc monhoc) {
		String sql = "insert into MonHoc([tenMonHoc], [monHocTienQuyet], [soTCLyThuyet], [soTCThucHanh], [maNganh], [maQuanLy]) values(?,?,?,?,?,?)";
		try {
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
//			psMonHoc.setString(1, monhoc.getMaMonHoc());
			psMonHoc.setString(1, monhoc.getTenMonHoc());
			psMonHoc.setString(2, monhoc.getMonHocTienQuyet());
			psMonHoc.setInt(3, monhoc.getSoTCLyThuyet());
			psMonHoc.setInt(4, monhoc.getSoTCThucHanh());
			psMonHoc.setString(5, monhoc.getNganh().getMaNganh());
			psMonHoc.setString(6, "QL01");
			return psMonHoc.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	//select mh.maMonHoc as monHoc from LopHocPhan lhp join MonHoc mh on mh.maMonHoc = lhp.maMonHoc where lhp.maLopHP ='MH001'
	public String MaMonHocTheoMaLopHocPhan(String malophocphan) {
		String sql ="select mh.maMonHoc as monHoc from LopHocPhan lhp join MonHoc mh on mh.maMonHoc = lhp.maMonHoc where lhp.maLopHP ='"+malophocphan+"'";
		try {
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	public float congNo(String maLopHocPhan) {
		String sql ="select soTCLyThuyet,soTCThucHanh from MonHoc where maMonHoc = '"+ MaMonHocTheoMaLopHocPhan(maLopHocPhan).trim()+"'";
		float congno = 0;
		try {
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				congno= (rs.getInt(1)+rs.getInt(2))*520000;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return congno;
		
	}
	
	//neu co thuc hanh la true , khong co thuc hanh la false
	public boolean KiemTraMonHocCoChiThucHanh(String monHoc) {
		boolean resul =false;
		String sql ="select soTCThucHanh from MonHoc where maMonHoc = '"+monHoc+"'";
		try {
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				if(rs.getInt(1)>0) {
					resul = true;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resul;
		
		
	}
	public String getMaChuyenNganhBangTenMonHoc(String tenMonHoc) {
		String s ="";
		String sql ="SELECT maNganh from MonHoc where tenMonHoc LIKE N'%"+tenMonHoc+"%'";
		try {
			con = db.getConnection();
			psMonHoc = con.prepareStatement(sql);
			rs = psMonHoc.executeQuery();
			while (rs.next()) {
				s =  rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
		
	}
	

}
