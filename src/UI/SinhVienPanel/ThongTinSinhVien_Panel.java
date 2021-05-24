package UI.SinhVienPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.LopDAO;
import DAO.NganhDAO;
import Entity.SinhVien;

public class ThongTinSinhVien_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel panel_1;

	/**
	 * Create the panel.
	 */
	public ThongTinSinhVien_Panel(SinhVien sv) {
		setSize(1300,720);
		setLayout(null);
		 panel_1 = new JPanel();
//			tabbedPane.addTab("H\u1ED3 s\u01A1 sinh vi\u00EAn\r\n", (Icon) null, panel_1, null);
			
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("M\u00E3 s\u1ED1 sinh vi\u00EAn");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(209, 80, 116, 20);
			add(lblNewLabel);
			
			
			JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn ");
			lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblHTn.setBounds(209, 124, 116, 20);
			add(lblHTn);
			
			JLabel lblGiiTnh = new JLabel("Giới tính");
			lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblGiiTnh.setBounds(209, 172, 116, 20);
			add(lblGiiTnh);
			
			JLabel lblNgySinh = new JLabel("Ngày sinh");
			lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNgySinh.setBounds(209, 225, 116, 20);
			add(lblNgySinh);
			
			JLabel lblLpHc = new JLabel("L\u1EDBp H\u1ECDc");
			lblLpHc.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblLpHc.setBounds(647, 172, 116, 20);
			add(lblLpHc);
			
			JLabel lblKhaHc = new JLabel("Hệ đào tạo");
			lblKhaHc.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblKhaHc.setBounds(647, 80, 116, 20);
			add(lblKhaHc);
			
			JLabel lblNgnh = new JLabel("Ng\u00E0nh");
			lblNgnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNgnh.setBounds(647, 124, 116, 20);
			add(lblNgnh);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setBackground(new Color(0, 153, 255));
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\PhatTrienUngDung\\ec7d30e17121d4803c6e3853e11f0788.jpg"));
			lblNewLabel_1.setBounds(10, -180, 49, 14);
			add(lblNewLabel_1);
			
			JLabel lblMaSinhvien = new JLabel(sv.getMaSinhVien());
			lblMaSinhvien.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblMaSinhvien.setBounds(377, 79, 142, 21);
			add(lblMaSinhvien);
			
			JLabel lblHoTen = new JLabel(sv.getTenSinhVien());
			lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblHoTen.setBounds(377, 122, 171, 33);
			add(lblHoTen);
			if(sv.isGioiTinh()==true) {
				JLabel lblGioiTinh = new JLabel("Nam");
				lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblGioiTinh.setBounds(377, 172, 46, 33);
				add(lblGioiTinh);
			}else {
				JLabel lblGioiTinh = new JLabel("Nữ");
				lblGioiTinh.setBounds(377, 172, 46, 33);
				lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
				add(lblGioiTinh);
			}
			
			
			JLabel lblNgaySinh = new JLabel(sv.getNgaySinh().toString());
			lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNgaySinh.setBounds(377, 215, 116, 33);
			add(lblNgaySinh);
			
			JLabel lblHeDaoTao = new JLabel(sv.getHeDaoTao());
			lblHeDaoTao.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblHeDaoTao.setBounds(798, 85, 142, 25);
			add(lblHeDaoTao);
			
			JLabel lblNganh = new JLabel(new NganhDAO().getTenNganh(sv.getNganhEnity().getMaNganh()));
			lblNganh.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNganh.setBounds(798, 129, 189, 26);
			add(lblNganh);
			
			JLabel lblLopHoc = new JLabel(new LopDAO().getTenLop(sv.getLopEnity().getMaLop()));
			lblLopHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblLopHoc.setBounds(798, 172, 304, 33);
			add(lblLopHoc);
			
			
			

	}
}
