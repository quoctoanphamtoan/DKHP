package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DAO.TaiKhoanDAO;
import Entity.SinhVien;

import java.awt.Color;

public class DoiMatKhauJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPasscu;
	private JPasswordField txtPassMoi;
	private JPasswordField txtPassNhapLai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoiMatKhauJFrame frame = new DoiMatKhauJFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 * SinhVienEnity sv
	 */
	public DoiMatKhauJFrame(SinhVien sv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(720, 380);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu cũ ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(142, 57, 99, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhuMi = new JLabel("Mật khẩu mới");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhuMi.setBounds(142, 102, 99, 23);
		contentPane.add(lblMtKhuMi);
		
		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu mới");
		lblNhpLiMt.setForeground(new Color(0, 0, 0));
		lblNhpLiMt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhpLiMt.setBounds(142, 152, 167, 23);
		contentPane.add(lblNhpLiMt);
		
		JLabel lblNewLabel_1 = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(279, 10, 143, 38);
		contentPane.add(lblNewLabel_1);
		
		txtPasscu = new JPasswordField();
		txtPasscu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPasscu.setBounds(319, 52, 175, 28);
		contentPane.add(txtPasscu);
		
		txtPassMoi = new JPasswordField();
		txtPassMoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassMoi.setBounds(319, 100, 175, 28);
		contentPane.add(txtPassMoi);
		
		txtPassNhapLai = new JPasswordField();
		txtPassNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassNhapLai.setBounds(319, 155, 175, 28);
		contentPane.add(txtPassNhapLai);
		
		JButton btnThayDoi = new JButton("XÁC NHẬN");
		btnThayDoi.setForeground(new Color(0, 0, 0));
		btnThayDoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThayDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sv.getTaiKhoanEnity().getMatKhau().trim().equalsIgnoreCase(String.valueOf(txtPasscu.getPassword()).trim())) {
					if(String.valueOf(txtPassMoi.getPassword()).trim().equalsIgnoreCase(String.valueOf(txtPassNhapLai.getPassword()).trim())) {
						String matKhauCu = txtPasscu.getText().trim();
						String matKhauMoi = txtPassMoi.getText().trim();
						String taikhoan =sv.getTaiKhoanEnity().getTaiKhoan();
						
						if(new TaiKhoanDAO().DoiMatKhau(matKhauMoi,taikhoan,matKhauCu)) {
							JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
							setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "Lỗi hệ thống");
						}
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu!");
					}
				}else {
					
					JOptionPane.showMessageDialog(null, "Nhập sai mật khẩu cũ!");
				}
				
				
			}
		});
		btnThayDoi.setBounds(319, 216, 158, 38);
		contentPane.add(btnThayDoi);
	}
}
