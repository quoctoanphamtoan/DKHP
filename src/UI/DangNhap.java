package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import DAO.TaiKhoanDAO;
import Entity.NguoiQuanLi;
import Entity.NhanVienPhongDaoTao;
import Entity.SinhVien;
import Entity.TaiKhoan;

public class DangNhap extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtTaiKhoan;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		UIManager.setLookAndFeel("com.sun.java.swing.plaf.bernstein.BernsteinLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					  UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(720, 380);

		ImageIcon icon = new ImageIcon("hinh/id-card.png");
		JLabel lblNewLabel_2 = new JLabel(icon);
		lblNewLabel_2.setBounds(164, 68, 37, 31);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("T\u00E0i Kho\u1EA3n");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(211, 68, 88, 23);
		contentPane.add(lblNewLabel);

		ImageIcon icon2 = new ImageIcon("hinh/padlock.png");
		JLabel lblNewLabel_4 = new JLabel(icon2);
		lblNewLabel_4.setBounds(164, 111, 37, 31);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_1 = new JLabel("M\u1EADt Kh\u1EA9u");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(211, 111, 88, 23);
		contentPane.add(lblNewLabel_1);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassword.setBounds(310, 111, 177, 31);
		contentPane.add(txtPassword);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBackground(new Color(255, 255, 255));
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTaiKhoan.setBounds(309, 65, 178, 31);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		JButton btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setBackground(new Color(135, 206, 235));
		btnDangNhap.setBorder(null);
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 

				if (comboBox.getSelectedItem().toString().trim().equalsIgnoreCase("Sinh Viên")) {
					SinhVien svtemp = new TaiKhoanDAO().dangNhapSinhVien(
							new TaiKhoan(txtTaiKhoan.getText(), String.valueOf(txtPassword.getPassword())));

					if (svtemp != null) {
						Index svForm = new Index(svtemp,null,null);
						svForm.setVisible(true);
						setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc tài khoản");
					}

				} else if (comboBox.getSelectedItem().toString().trim().equalsIgnoreCase("Phòng Đào Tạo")) {
					NhanVienPhongDaoTao nvt = new TaiKhoanDAO().dangNhapNhanVienPhongDaoTao(
							new TaiKhoan(txtTaiKhoan.getText(), String.valueOf(txtPassword.getPassword())));

					if (nvt != null) {
						Index svForm = new Index(null,nvt,null);
						svForm.setVisible(true);
						setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc tài khoản");
					}
				}else if (comboBox.getSelectedItem().toString().trim().equalsIgnoreCase("Quản lý")) {
					 NguoiQuanLi nvt = new TaiKhoanDAO().dangNhapQuanLi(
							new TaiKhoan(txtTaiKhoan.getText(), String.valueOf(txtPassword.getPassword())));

					if (nvt != null) {
						Index svForm = new Index(null,null,nvt);
						svForm.setVisible(true);
						setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc tài khoản");
					}
				}

			}
		});

		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDangNhap.setBounds(327, 215, 145, 38);
		contentPane.add(btnDangNhap);

		comboBox = new JComboBox<String>();
		comboBox.setForeground(new Color(25, 25, 112));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Sinh Viên", "Phòng Đào Tạo", "Quản lý" }));
		comboBox.setBounds(310, 162, 177, 31);
		contentPane.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_3.setForeground(new Color(30, 144, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(310, 10, 145, 45);
		contentPane.add(lblNewLabel_3);
	}
}
