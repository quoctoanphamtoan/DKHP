package UI.SinhVienPanel;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import DAO.GiangVienDAO;
import DAO.MonHocDAO;
import DAO.PhongHocDAO;
import DAO.SinhVienDAO;
import Entity.SinhVien;

public class XemLichHoc_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea t213;
	private JTextArea t246;
	private JTextArea t279;
	private JTextArea t21012;
	private JTextArea t31315;
	private JTextArea t31012;
	private JTextArea t379;
	private JTextArea t313;
	private JTextArea t41315;
	private JTextArea t479;
	private JTextArea t446;
	private JTextArea t413;
	private JTextArea t51315;
	private JTextArea t579;
	private JTextArea t546;
	private JTextArea t513;
	private JTextArea t61315;
	private JTextArea t679;
	private JTextArea t646;
	private JTextArea t71315;
	private JTextArea t71012;
	private JTextArea t779;
	private JTextArea t21315;
	private JTextArea t346;
	private JTextArea t41012;
	private JTextArea t51012;
	private JTextArea t61012;
	private JTextArea t613;
	private JTextArea t746;
	private JTextArea t713;
	private JTextArea cn1315;
	private JTextArea cn1012;
	private JTextArea cn79;
	private JTextArea cn46;
	private JTextArea cn13;
	private JLabel lblTh_1;
	private JLabel lblTh_3;
	private JLabel lblTh_4;
	private JLabel lblTh_5;

	/**
	 * Create the panel.
	 */
	public XemLichHoc_Panel(SinhVien sv) {
		setBackground(new Color(255, 255, 255));
		setSize(1300,730);
		setLayout(null);
		t213 = new JTextArea("");
		t213.setBackground(new Color(176, 224, 230));
		t213.setForeground(Color.BLACK);
		t213.setEditable(false);
		t213.setBounds(76, 39, 147, 99);
		add(t213);
//		t213.setText("hiihi\nhuhu");
		t246 = new JTextArea("");
		t246.setForeground(Color.BLACK);
		t246.setEditable(false);
		t246.setBackground(new Color(176, 224, 230));
		t246.setBounds(76, 149, 147, 99);
		add(t246);
		
		t279 = new JTextArea("");
		t279.setForeground(Color.BLACK);
		t279.setEditable(false);
		t279.setBackground(new Color(176, 224, 230));
		t279.setBounds(76, 267, 147, 99);
		add(t279);
		
		t21012 = new JTextArea("");
		t21012.setForeground(Color.BLACK);
		t21012.setEditable(false);
		t21012.setBackground(new Color(176, 224, 230));
		t21012.setBounds(76, 371, 147, 99);
		add(t21012);
		
		t21315 = new JTextArea("");
		t21315.setForeground(Color.BLACK);
		t21315.setEditable(false);
		t21315.setBackground(new Color(176, 224, 230));
		t21315.setBounds(76, 495, 147, 99);
		add(t21315);
		
		t31315 = new JTextArea("");
		t31315.setForeground(Color.BLACK);
		t31315.setEditable(false);
		t31315.setBackground(new Color(176, 224, 230));
		t31315.setBounds(233, 495, 135, 99);
		add(t31315);
		
		t31012 = new JTextArea("");
		t31012.setForeground(Color.BLACK);
		t31012.setEditable(false);
		t31012.setBackground(new Color(176, 224, 230));
		t31012.setBounds(233, 371, 135, 99);
		add(t31012);
		
		t379 = new JTextArea("");
		t379.setForeground(Color.BLACK);
		t379.setEditable(false);
		t379.setBackground(new Color(176, 224, 230));
		t379.setBounds(233, 267, 135, 99);
		add(t379);
		
		t346 = new JTextArea("");
		t346.setForeground(Color.BLACK);
		t346.setEditable(false);
		t346.setBackground(new Color(176, 224, 230));
		t346.setBounds(233, 149, 135, 99);
		add(t346);
		
		t313 = new JTextArea("");
		t313.setForeground(Color.BLACK);
		t313.setEditable(false);
		t313.setBackground(new Color(176, 224, 230));
		t313.setBounds(233, 39, 135, 99);
		add(t313);
		
		t41315 = new JTextArea("");
		t41315.setForeground(Color.BLACK);
		t41315.setEditable(false);
		t41315.setBackground(new Color(176, 224, 230));
		t41315.setBounds(378, 495, 132, 99);
		add(t41315);
		
		t41012 = new JTextArea("");
		t41012.setForeground(Color.BLACK);
		t41012.setEditable(false);
		t41012.setBackground(new Color(176, 224, 230));
		t41012.setBounds(378, 371, 132, 99);
		add(t41012);
		
		t479 = new JTextArea("");
		t479.setForeground(Color.BLACK);
		t479.setEditable(false);
		t479.setBackground(new Color(176, 224, 230));
		t479.setBounds(378, 267, 132, 99);
		add(t479);
		
		t446 = new JTextArea("");
		t446.setForeground(Color.BLACK);
		t446.setEditable(false);
		t446.setBackground(new Color(176, 224, 230));
		t446.setBounds(378, 149, 132, 99);
		add(t446);
		
		t413 = new JTextArea("");
		t413.setForeground(Color.BLACK);
		t413.setEditable(false);
		t413.setBackground(new Color(176, 224, 230));
		t413.setBounds(378, 39, 135, 99);
		add(t413);
		
		t51315 = new JTextArea("");
		t51315.setForeground(Color.BLACK);
		t51315.setEditable(false);
		t51315.setBackground(new Color(176, 224, 230));
		t51315.setBounds(520, 495, 132, 99);
		add(t51315);
		
		t51012 = new JTextArea("");
		t51012.setForeground(Color.BLACK);
		t51012.setEditable(false);
		t51012.setBackground(new Color(176, 224, 230));
		t51012.setBounds(520, 371, 132, 99);
		add(t51012);
		
		t579 = new JTextArea("");
		t579.setForeground(Color.BLACK);
		t579.setEditable(false);
		t579.setBackground(new Color(176, 224, 230));
		t579.setBounds(520, 267, 132, 99);
		add(t579);
		
		t546 = new JTextArea("");
		t546.setForeground(Color.BLACK);
		t546.setEditable(false);
		t546.setBackground(new Color(176, 224, 230));
		t546.setBounds(520, 149, 132, 99);
		add(t546);
		
		t513 = new JTextArea("");
		t513.setForeground(Color.BLACK);
		t513.setEditable(false);
		t513.setBackground(new Color(176, 224, 230));
		t513.setBounds(523, 39, 129, 99);
		add(t513);
		
		t61315 = new JTextArea("");
		t61315.setForeground(Color.BLACK);
		t61315.setEditable(false);
		t61315.setBackground(new Color(176, 224, 230));
		t61315.setBounds(662, 495, 129, 99);
		add(t61315);
		
		t61012 = new JTextArea("");
		t61012.setForeground(Color.BLACK);
		t61012.setEditable(false);
		t61012.setBackground(new Color(176, 224, 230));
		t61012.setBounds(662, 371, 129, 99);
		add(t61012);
		
		t679 = new JTextArea("");
		t679.setForeground(Color.BLACK);
		t679.setEditable(false);
		t679.setBackground(new Color(176, 224, 230));
		t679.setBounds(662, 267, 129, 99);
		add(t679);
		
		t646 = new JTextArea("");
		t646.setForeground(Color.BLACK);
		t646.setEditable(false);
		t646.setBackground(new Color(176, 224, 230));
		t646.setBounds(662, 149, 129, 99);
		add(t646);
		
		t613 = new JTextArea("");
		t613.setForeground(Color.BLACK);
		t613.setEditable(false);
		t613.setBackground(new Color(176, 224, 230));
		t613.setBounds(662, 39, 129, 99);
		add(t613);
		
		t71315 = new JTextArea("");
		t71315.setForeground(Color.BLACK);
		t71315.setEditable(false);
		t71315.setBackground(new Color(176, 224, 230));
		t71315.setBounds(801, 495, 122, 99);
		add(t71315);
		
		t71012 = new JTextArea("");
		t71012.setForeground(Color.BLACK);
		t71012.setEditable(false);
		t71012.setBackground(new Color(176, 224, 230));
		t71012.setBounds(801, 371, 122, 99);
		add(t71012);
		
		t779 = new JTextArea("");
		t779.setForeground(Color.BLACK);
		t779.setEditable(false);
		t779.setBackground(new Color(176, 224, 230));
		t779.setBounds(801, 267, 122, 99);
		add(t779);
		
		t746 = new JTextArea("");
		t746.setForeground(Color.BLACK);
		t746.setEditable(false);
		t746.setBackground(new Color(176, 224, 230));
		t746.setBounds(801, 149, 122, 99);
		add(t746);
		
		t713 = new JTextArea("");
		t713.setForeground(Color.BLACK);
		t713.setEditable(false);
		t713.setBackground(new Color(176, 224, 230));
		t713.setBounds(801, 39, 122, 99);
		add(t713);
		
		cn1315 = new JTextArea("");
		cn1315.setForeground(Color.BLACK);
		cn1315.setEditable(false);
		cn1315.setBackground(new Color(176, 224, 230));
		cn1315.setBounds(933, 495, 132, 99);
		add(cn1315);
		
		cn1012 = new JTextArea("");
		cn1012.setForeground(Color.BLACK);
		cn1012.setEditable(false);
		cn1012.setBackground(new Color(176, 224, 230));
		cn1012.setBounds(933, 371, 132, 99);
		add(cn1012);
		
		cn79 = new JTextArea("");
		cn79.setForeground(Color.BLACK);
		cn79.setEditable(false);
		cn79.setBackground(new Color(176, 224, 230));
		cn79.setBounds(933, 267, 132, 99);
		add(cn79);
		
		cn46 = new JTextArea("");
		cn46.setForeground(Color.BLACK);
		cn46.setEditable(false);
		cn46.setBackground(new Color(176, 224, 230));
		cn46.setBounds(933, 149, 129, 99);
		add(cn46);
		
		cn13 = new JTextArea("");
		cn13.setForeground(Color.BLACK);
		cn13.setEditable(false);
		cn13.setBackground(new Color(176, 224, 230));
		cn13.setBounds(933, 39, 129, 99);
		add(cn13);
		
		JLabel lblNewLabel = new JLabel("Thứ 2");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(176, 224, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(124, 11, 46, 17);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(10, 39, 46, 203);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sáng");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(new Color(176, 224, 230));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 82, 36, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBounds(10, 267, 46, 203);
		add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chiều");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setBackground(new Color(176, 224, 230));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 82, 36, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(Color.BLACK);
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(224, 255, 255));
		panel_1_1.setBounds(10, 495, 46, 99);
		add(panel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tối");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setBackground(new Color(176, 224, 230));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(10, 42, 36, 14);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblTh = new JLabel("Thứ 3");
		lblTh.setForeground(Color.BLACK);
		lblTh.setBackground(new Color(176, 224, 230));
		lblTh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTh.setBounds(267, 11, 46, 17);
		add(lblTh);
		
		JLabel lblTh_2 = new JLabel("Thứ 4");
		lblTh_2.setForeground(Color.BLACK);
		lblTh_2.setBackground(new Color(176, 224, 230));
		lblTh_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTh_2.setBounds(422, 11, 46, 17);
		add(lblTh_2);
		
		lblTh_1 = new JLabel("Thứ 5");
		lblTh_1.setForeground(Color.BLACK);
		lblTh_1.setBackground(new Color(176, 224, 230));
		lblTh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTh_1.setBounds(577, 14, 46, 17);
		add(lblTh_1);
		
		lblTh_3 = new JLabel("Thứ 6");
		lblTh_3.setForeground(Color.BLACK);
		lblTh_3.setBackground(new Color(176, 224, 230));
		lblTh_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTh_3.setBounds(704, 11, 46, 17);
		add(lblTh_3);
		
		lblTh_4 = new JLabel("Thứ 7");
		lblTh_4.setForeground(Color.BLACK);
		lblTh_4.setBackground(new Color(176, 224, 230));
		lblTh_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTh_4.setBounds(842, 11, 46, 17);
		add(lblTh_4);
		
		lblTh_5 = new JLabel("Chủ nhật");
		lblTh_5.setForeground(Color.BLACK);
		lblTh_5.setBackground(new Color(176, 224, 230));
		lblTh_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTh_5.setBounds(963, 11, 64, 17);
		add(lblTh_5);
//		loadLichHocThucHanhTheoMaSinhvien(sv.getMaSinhVien());
		loadLichHocCoThucHanhTheoMaSinhvien(sv.getMaSinhVien());
		loadLichHocKhongCoThucHanhMaSinhvien(sv.getMaSinhVien());
		LoadLichHocThucHanh(sv.getMaSinhVien());
		
		
	}
	public void loadLichHocCoThucHanhTheoMaSinhvien(String maSinhVien) {
		ResultSet rs = new SinhVienDAO().loadThoiKhoaBieuCoThucHanhTheoMaSinhvien(maSinhVien);
		try {
			while(rs.next()) {
				String tietHoc =rs.getString(1);
				String giangVien =new GiangVienDAO().getTenGiangVien(rs.getString(2));
				String monHoc =new MonHocDAO().getTenMonHoc(rs.getString(3));
				String PhongHoc =new PhongHocDAO().getTenPhongHoc(rs.getString(4));
				String thu = rs.getString(5);
				if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t213.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t246.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc+"");
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t279.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t21012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t21315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t313.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t346.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t379.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t31012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t31315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t413.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t446.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t479.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t41012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t41315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t513.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t546.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t579.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t51012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t51315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t613.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t646.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t679.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t61012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t61315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t713.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t746.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t779.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t71012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t71315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	public void loadLichHocKhongCoThucHanhMaSinhvien(String maSinhVien) {
		ResultSet rs = new SinhVienDAO().loadThoiKhoaBieuLyThuyetTheoMaSinhvienCoTH(maSinhVien);
		try {
			while(rs.next()) {
				String tietHoc =rs.getString(1);
				String giangVien =new GiangVienDAO().getTenGiangVien(rs.getString(2));
				String monHoc =new MonHocDAO().getTenMonHoc(rs.getString(3));
				String PhongHoc =new PhongHocDAO().getTenPhongHoc(rs.getString(4));
				String thu = rs.getString(5);
				if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t213.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t246.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc+"");
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t279.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t21012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t21315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t313.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t346.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t379.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t31012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t31315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t413.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t446.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t479.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t41012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t41315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t513.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t546.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t579.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t51012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t51315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t613.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t646.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t679.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t61012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t61315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t713.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t746.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t779.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t71012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t71315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	public void LoadLichHocThucHanh(String maSinhVien) {
		ResultSet rs = new SinhVienDAO().LoadLichHocThucHanh(maSinhVien);
		try {
			while(rs.next()) {
				String tietHoc =rs.getString(1);
				String giangVien =new GiangVienDAO().getTenGiangVien(rs.getString(2));
				String monHoc =new MonHocDAO().getTenMonHoc(rs.getString(3));
				String PhongHoc =new PhongHocDAO().getTenPhongHoc(rs.getString(4));
				String thu = rs.getString(5);
			
				if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t213.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t246.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t279.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t21012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("2")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t21315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t313.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t346.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t379.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t31012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("3")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t31315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t413.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t446.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t479.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t41012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("4")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t41315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t513.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t546.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t579.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t51012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("5")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t51315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t613.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t646.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t679.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t61012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("6")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t61315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("1-3")) {
					t713.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("4-6")) {
					t746.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("7-9")) {
					t779.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("10-12")) {
					t71012.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}else if(thu.trim().equalsIgnoreCase("7")&&tietHoc.trim().equalsIgnoreCase("13-15")) {
					t71315.setText(tietHoc+"\n"+giangVien+"\n"+PhongHoc+"\n"+monHoc);
					
				}
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
}
