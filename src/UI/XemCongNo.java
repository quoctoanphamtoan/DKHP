package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.SinhVienDAO;
import Entity.SinhVien;

public class XemCongNo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblCongNo;
	private JLabel lblSinhVien;
	private DefaultTableModel modelConNo;
	private JLabel lblNewLabel_1;
	private JLabel lblCongNoTong;
	private JLabel lblHcK;
	private JLabel lblHocKi;
	private JLabel lblNamHoc;
	private JLabel lblHcK_1;
//	private SinhVienEnity sv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XemCongNo frame = new XemCongNo(new SinhVien("SV001"));
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
	public XemCongNo(SinhVien sv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 764, 248);
		contentPane.add(scrollPane);
		
		tblCongNo = new JTable();
		tblCongNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		modelConNo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					 "Mã Lớp học phần", "Môn học", "Tín chỉ", "Tổng tiền","Đã đóng","Tình trạng"
				}
			);
		tblCongNo.setModel(modelConNo);
		scrollPane.setViewportView(tblCongNo);
		
		JLabel lblNewLabel = new JLabel("Sinh Vi\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 13, 87, 21);
		contentPane.add(lblNewLabel);
		
		lblSinhVien = new JLabel("");
		lblSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinhVien.setBounds(97, 13, 156, 16);
		contentPane.add(lblSinhVien);
		
		lblNewLabel_1 = new JLabel("Tổng công nợ: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(366, 315, 128, 35);
		contentPane.add(lblNewLabel_1);
		
		lblCongNoTong = new JLabel("Tổng công nợ: ");
		lblCongNoTong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCongNoTong.setBounds(500, 315, 128, 35);
		contentPane.add(lblCongNoTong);
		
		JButton btnNewButton = new JButton("Đóng");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
//				new Index(sv,null,null).setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 317, 169, 35);
		contentPane.add(btnNewButton);
		
		lblHcK = new JLabel("Học kì");
		lblHcK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHcK.setBounds(396, 13, 87, 21);
		contentPane.add(lblHcK);
		
		lblHocKi = new JLabel("học kì");
		lblHocKi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHocKi.setBounds(492, 13, 87, 21);
		contentPane.add(lblHocKi);
		
		lblNamHoc = new JLabel("nam hoc");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(687, 13, 87, 21);
		contentPane.add(lblNamHoc);
		
		lblHcK_1 = new JLabel("Năm học");
		lblHcK_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHcK_1.setBounds(591, 13, 87, 21);
		contentPane.add(lblHcK_1);
		LoadMonHoc(sv.getMaSinhVien());
	}
	public void LoadMonHoc(String maSinhVien) {
		
		ResultSet rs = new SinhVienDAO().DanhSachCongNo(maSinhVien);
		try {float toong = 0;
			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.addElement(String.valueOf(rs.getString(1)));
				vector.addElement(String.valueOf(rs.getString(2)));
				vector.addElement(String.valueOf(rs.getString(3)));
				vector.addElement(String.valueOf(rs.getString(4)));
//				lblHocKi.setText(rs.String);
				modelConNo.addRow(vector);
				toong+=rs.getFloat(4);
				
			}
			lblCongNoTong.setText(toong+" VND");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tblCongNo.setModel(modelConNo);
		
	}
	
}
