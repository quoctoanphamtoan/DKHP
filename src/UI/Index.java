package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.NguoiQuanLi;
import Entity.NhanVienPhongDaoTao;
import Entity.SinhVien;
import UI.NhanVienPanel.QuanLiDangKiHocPhan;
import UI.NhanVienPanel.QuanLiDiem_Panel;
import UI.QuanLy.QuanLyGiangVien_Frm;
import UI.QuanLy.QuanLyLopHoc_Frm;
import UI.QuanLy.QuanLyMonHoc_Frm;
import UI.QuanLy.QuanLyNganh;
import UI.QuanLy.QuanLyNhanVien;
import UI.QuanLy.QuanLyPhongHoc;
import UI.QuanLy.QuanLySinhVien_Frm;
import UI.QuanLy.TimKiemSinhVien;
import UI.SinhVienPanel.DangKiHocPhan_Panel;
import UI.SinhVienPanel.ThongTinSinhVien_Panel;
import UI.SinhVienPanel.XemLichHoc_Panel;
import UI.SinhVienPanel.XemLichThi_Panel;
import UI.TimKiemPanel.TimKiemGiangVien.TimKiemGiangVien_Panel;

public class Index extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JMenuItem menuQuanLiMonHoc;

	
	private static SinhVien svv;
	private DoiMatKhauJFrame doiMatKhauJFrame;
	private JMenu menuPhongDaoTao;
	private JMenu menuQuanLi;
	private JMenu menuSinhvien;
	private ImageIcon icon5;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Index frame = new Index(svv);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Index(SinhVien sv,NhanVienPhongDaoTao nvpdt,NguoiQuanLi nql) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300,730);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		ImageIcon icon = new ImageIcon("hinh/control-system.png");
		JMenu mnNewMenu = new JMenu("Hệ thống");
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnNewMenu.setIcon(icon);
		menuBar.add(mnNewMenu);

		JMenuItem menuDoiMatKhau = new JMenuItem("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		menuDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new DoiMatKhauJFrame(sv).setVisible(true);
			}
		});
		mnNewMenu.add(menuDoiMatKhau);

		JMenuItem menuDangXuat = new JMenuItem("\u0110\u0103ng xu\u1EA5t");
		menuDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new DangNhap().setVisible(true);
			}
		});
		mnNewMenu.add(menuDangXuat);

		JMenuItem mntmNewMenuItem = new JMenuItem("Tho\u00E1t");
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		ImageIcon icon2 = new ImageIcon("hinh/graduated.png");
		menuSinhvien = new JMenu("Sinh Vi\u00EAn");
		menuSinhvien.setForeground(new Color(0, 0, 0));
		menuSinhvien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuSinhvien.setIcon(icon2);
		menuBar.add(menuSinhvien);

		JMenuItem menuHoSoSinhVien = new JMenuItem("H\u1ED3 s\u01A1 sinh vi\u00EAn");
		menuHoSoSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuHoSoSinhVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new ThongTinSinhVien_Panel(sv));
				contentPane.validate();
				contentPane.repaint();
//				contentPane.setVisible(true);

			}
		});
		menuSinhvien.add(menuHoSoSinhVien);

		JMenuItem menuDangKiHocPhan = new JMenuItem("\u0110\u0103ng k\u00ED h\u1ECDc ph\u1EA7n");
		menuDangKiHocPhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuDangKiHocPhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new DangKiHocPhan_Panel(sv));
				contentPane.validate();
				contentPane.repaint();
			}
		});
		menuSinhvien.add(menuDangKiHocPhan);

		JMenu mnNewMenu_2 = new JMenu("Xem l\u1ECBch");
		mnNewMenu_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnNewMenu_2.setForeground(new Color(0, 0, 0));
		menuSinhvien.add(mnNewMenu_2);

		JMenuItem menuXemLichHoc = new JMenuItem("Xem l\u1ECBch h\u1ECDc");
		menuXemLichHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuXemLichHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new XemLichHoc_Panel(sv));
				contentPane.validate();
				contentPane.repaint();
			}
		});
		mnNewMenu_2.add(menuXemLichHoc);

		JMenuItem menuXemLichThi = new JMenuItem("Xem l\u1ECBch thi");
		menuXemLichThi.setEnabled(false);
		menuXemLichThi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuXemLichThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new XemLichThi_Panel());
				contentPane.validate();
				contentPane.repaint();
			}
		});
		mnNewMenu_2.add(menuXemLichThi);

		ImageIcon icon3= new ImageIcon("hinh/participant.png");
		menuPhongDaoTao = new JMenu("Nh\u00E2n vi\u00EAn ph\u00F2ng \u0111\u00E0o t\u1EA1o");
		menuPhongDaoTao.setForeground(new Color(0, 0, 0));
		menuPhongDaoTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuPhongDaoTao.setIcon(icon3);
		menuBar.add(menuPhongDaoTao);

		JMenuItem menuQuanliDangkiHocPhan = new JMenuItem("Qu\u1EA3n l\u00ED l\u1EDBp h\u1ECDc ph\u1EA7n");
		menuQuanliDangkiHocPhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanliDangkiHocPhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new QuanLiDangKiHocPhan());
				contentPane.validate();
				contentPane.repaint();
			}
		});
		menuPhongDaoTao.add(menuQuanliDangkiHocPhan);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tìm kiếm sinh viên");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new TimKiemSinhVien());
				contentPane.validate();
				contentPane.repaint();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuPhongDaoTao.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("In danh sách sinh viên");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new QuanLiDiem_Panel());
				contentPane.validate();
				contentPane.repaint();
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuPhongDaoTao.add(mntmNewMenuItem_2);

		
		ImageIcon icon4= new ImageIcon("hinh/manager.png");
		menuQuanLi = new JMenu("Quản lý");
		menuQuanLi.setForeground(new Color(0, 0, 0));
		menuQuanLi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanLi.setIcon(icon4);
		menuBar.add(menuQuanLi);

		JMenuItem menuQuanLiGiangVien = new JMenuItem("Quản lý giảng viên");
		menuQuanLiGiangVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new QuanLyGiangVien_Frm(nql));
				contentPane.validate();
				contentPane.repaint();
				
				
				
			}
		});
		menuQuanLiGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanLi.add(menuQuanLiGiangVien);

		JMenuItem menuQuanLiSinhVien = new JMenuItem("Quản lý sinh viên");
		menuQuanLiSinhVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new QuanLySinhVien_Frm(nql));
				contentPane.validate();
				contentPane.repaint();
				
				
			}
		});
		menuQuanLiSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanLi.add(menuQuanLiSinhVien);

		menuQuanLiMonHoc = new JMenuItem("Quản lý môn học");
		menuQuanLiMonHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new QuanLyMonHoc_Frm());
				contentPane.validate();
				contentPane.repaint();
				
			}
		});
		menuQuanLiMonHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanLi.add(menuQuanLiMonHoc);
		
		JMenuItem mntmTimKiemSV = new JMenuItem("Tìm kiếm sinh viên");
		mntmTimKiemSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new TimKiemSinhVien());
				contentPane.validate();
				contentPane.repaint();
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Quản lý phòng học");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new QuanLyPhongHoc(nql));
				contentPane.validate();
				contentPane.repaint();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanLi.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Quản lý lớp học");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new QuanLyLopHoc_Frm(nql));
				contentPane.validate();
				contentPane.repaint();
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanLi.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Quản lý ngành\r\n");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new QuanLyNganh(nql));
				contentPane.validate();
				contentPane.repaint();
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanLi.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Quản lý nhân viên");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new QuanLyNhanVien(nql));
				contentPane.validate();
				contentPane.repaint();
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanLi.add(mntmNewMenuItem_6);
		mntmTimKiemSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanLi.add(mntmTimKiemSV);
		
		JMenuItem mntm_timkiemGV = new JMenuItem("Tìm kiếm giảng viên");
		mntm_timkiemGV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(new TimKiemGiangVien_Panel());
				contentPane.validate();
				contentPane.repaint();
			}
		});
		mntm_timkiemGV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuQuanLi.add(mntm_timkiemGV);

		icon5= new ImageIcon("hinh/search.png");
		contentPane = new JPanel();
			contentPane.setToolTipText("");
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PHẦN MỀM QUẢN LÝ ĐĂNG KÝ HỌC PHẦN");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel.setBounds(237, 70, 797, 119);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhóm 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(624, 221, 197, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phạm Quốc Toàn\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(624, 287, 287, 33);
		contentPane.add(lblNewLabel_2);
		
	 
		
		phanQuyen(sv,nvpdt,nql);

		
		
		
	}
	public void phanQuyen(SinhVien sv , NhanVienPhongDaoTao pdt , NguoiQuanLi nql) {
		if(sv!=null) {
			menuPhongDaoTao.setEnabled(false);
			menuQuanLi.setEnabled(false);
			
		}else if(pdt!=null) {
			menuSinhvien.setEnabled(false);
			menuQuanLi.setEnabled(false);
		}else if(nql!=null) {
			menuSinhvien.setEnabled(false);
			menuPhongDaoTao.setEnabled(false);
		}
		
	}
}
