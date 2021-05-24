package UI.NhanVienPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.GiangVienDAO;
import DAO.LopHocPhanDAO;
import DAO.NhomThucHanhDAO;
import DAO.PhongHocDAO;
import Entity.GiangVien;
import Entity.LopHocPhan;
import Entity.NhomThucHanh;
import Entity.PhongHoc;

public class TaoNhomThucHanh_JFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> cbPhongHoc;
	private JComboBox<String> cbTietHoc;
	private JComboBox<String> cbGiaoVien;
	private JComboBox<String> cbNhom;
	private DefaultComboBoxModel<String> modelCBNhom;
	private JComboBox<String> cbThu;
	private JLabel txtSiSoThucHanh;
	private DefaultComboBoxModel<String> modelCbGiaoVien;
	private DefaultComboBoxModel<String> modelCbPhongHoc;
	private DefaultTableModel modelTableDanhSachNhom;
	private JLabel lblMaLopHocPhan;
	private JButton btnNewButton;
	private JButton btnCapNhat;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TaoNhomThucHanh_JFrame frame = new TaoNhomThucHanh_JFrame(4, "LHP001", 90,"CNTT");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame. lay si so lay malophp lay so nhom thuc hÃ nh
	 * 
	 * 
	 */
	public TaoNhomThucHanh_JFrame(int soNhom, String maLopHP, int siso,String chuyenNganh) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1030, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nhóm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(53, 24, 46, 18);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 227, 907, 227);
		contentPane.add(scrollPane);

		table = new JTable();
		modelTableDanhSachNhom =  new DefaultTableModel(new Object[][] {},
				new String[] { "Nhóm", "Giảng viên", "Phòng","Thứ", "Tiết", "Sỉ số" });
		table.setModel(modelTableDanhSachNhom);
		scrollPane.setViewportView(table);

		cbNhom = new JComboBox<String>();
		cbNhom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modelCBNhom = new DefaultComboBoxModel<String>(new String[] { "0" });
		cbNhom.setModel(modelCBNhom);
		cbNhom.setBounds(187, 25, 56, 25);
		contentPane.add(cbNhom);

		JLabel lblNewLabel_1 = new JLabel("Giảng viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(53, 74, 89, 19);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Phòng thực hành");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(53, 129, 124, 20);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Sỉ số");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(532, 27, 56, 23);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2 = new JLabel("Tiết");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(532, 77, 46, 14);
		contentPane.add(lblNewLabel_2);

		cbGiaoVien = new JComboBox<String>();
		cbGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modelCbGiaoVien= new DefaultComboBoxModel<String>(new String[] {""});
		cbGiaoVien.setModel(modelCbGiaoVien);
		cbGiaoVien.setBounds(187, 70, 265, 25);
		contentPane.add(cbGiaoVien);

		cbPhongHoc = new JComboBox<String>();
		cbPhongHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modelCbPhongHoc= new DefaultComboBoxModel<String>(new String[] {""});
		cbPhongHoc.setModel(modelCbPhongHoc);
		cbPhongHoc.setBounds(187, 127, 89, 25);
		contentPane.add(cbPhongHoc);

		cbTietHoc = new JComboBox<String>();
		cbTietHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbTietHoc.setModel(new DefaultComboBoxModel<String>(new String[] { "1-3", "4-6", "7-9", "10-12", "13-15" }));
		cbTietHoc.setBounds(604, 72, 76, 25);
		contentPane.add(cbTietHoc);

		txtSiSoThucHanh = new JLabel("" + ((siso / soNhom) + 1) + "");
		txtSiSoThucHanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSiSoThucHanh.setBounds(604, 29, 62, 17);
		contentPane.add(txtSiSoThucHanh);

		JButton btnTaoNhomThucHanh = new JButton("Tạo ");
		btnTaoNhomThucHanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTaoNhomThucHanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String thu = cbThu.getSelectedItem().toString().trim();
					String maGiangVien = new GiangVienDAO().getMaGiangVien(cbGiaoVien.getSelectedItem().toString().trim());
					String phonghoc = new PhongHocDAO()
							.getMaPhongHocTheoTen(cbPhongHoc.getSelectedItem().toString().trim());
					///
					String tenNhom = cbNhom.getSelectedItem().toString().trim();
					String tietHoc = cbTietHoc.getSelectedItem().toString().trim();
					int siSo = (siso / soNhom) + 1;
					//
					if(new LopHocPhanDAO().kiemTraTrungTietThuGiangVien(tietHoc, thu, maGiangVien)) {
						if(new LopHocPhanDAO().kiemTraTrungTietThuPhong(tietHoc, thu, phonghoc)) {
							if(new NhomThucHanhDAO().kiemTraTrungTietThuGiangVien(tietHoc, thu, maGiangVien)) {
								if(new NhomThucHanhDAO().kiemTraTrungTietThuPhong(tietHoc, thu, phonghoc)) {
									if(new NhomThucHanhDAO().KiemTraSoNhomThucHanh(maLopHP)) {
										NhomThucHanh nhomThucHanh = new NhomThucHanh(new NhomThucHanhDAO().getMaNhomThucHanh(),Integer.parseInt(tenNhom),
												tietHoc,thu,siSo,new LopHocPhan(maLopHP),new PhongHoc(phonghoc),new GiangVien(maGiangVien));
										if(new NhomThucHanhDAO().ThemNhomThucHanh(nhomThucHanh)) {
											JOptionPane.showMessageDialog(null, "Tạo thành công nhóm thực hành ");
											loadNhom(soNhom,maLopHP);
											loadTableNhom(lblMaLopHocPhan.getText().trim());
											
										}else {
											JOptionPane.showMessageDialog(null, "Tạo thất bại nhóm thực hành ");
											return;
										}
									}else {
										JOptionPane.showMessageDialog(null, "Đã đủ số nhóm thực hành");
										return;
									}
								}else {
									JOptionPane.showMessageDialog(null, "Phòng "+new PhongHocDAO().getTenPhongHoc(phonghoc)+" Tiết "+tietHoc+" Thứ "+thu+" có lớp khác dạy xin chọn lại ");
									return;
								}
								
							}else {
								JOptionPane.showMessageDialog(null, "Giảng viên "+new GiangVienDAO().getTenGiangVien(maGiangVien)+" Tiết "+tietHoc+" Thứ "+thu+" có tiết dạy xin chọn lại Phòng");
								return;
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Phòng "+new PhongHocDAO().getTenPhongHoc(phonghoc)+" Tiết "+tietHoc+" Thứ "+thu+" có lớp khác dạy xin chọn lại ");
							return;
						}
					}else {
						JOptionPane.showMessageDialog(null, "Giảng viên "+new GiangVienDAO().getTenGiangVien(maGiangVien)+" Tiết "+tietHoc+" Thứ "+thu+" có tiết dạy xin chọn lại Phòng");
						return;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Xin kiểm tra lại dữ liệu");
					return;
				}
			}
		});
		btnTaoNhomThucHanh.setBounds(823, 90, 133, 44);
		contentPane.add(btnTaoNhomThucHanh);

		lblMaLopHocPhan = new JLabel(maLopHP);
		lblMaLopHocPhan.setBounds(53, 178, 89, 18);
		contentPane.add(lblMaLopHocPhan);
		JLabel lblNewLabel_2_1 = new JLabel("Thứ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(532, 133, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		cbThu = new JComboBox<String>();
		cbThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbThu.setModel(new DefaultComboBoxModel<String>(new String[] { "2", "3", "4", "5", "6", "7", "Chá»§ nháº­t" }));
		cbThu.setBounds(604, 127, 76, 25);
		contentPane.add(cbThu);
		
		btnNewButton = new JButton("Hủy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(823, 152, 137, 44);
		contentPane.add(btnNewButton);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCapNhat.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnCapNhat.setBounds(823, 36, 133, 44);
		contentPane.add(btnCapNhat);
		loadNhom(soNhom,maLopHP);
		LoadPhongThucHanh("A");
		LoadGiangVien(chuyenNganh);
		loadTableNhom(maLopHP);
	}

	public void loadNhom(int soNhom,String maLhp) {
		modelCBNhom.removeAllElements();
		Vector<String> vt = new Vector<String>();
		for (int i = 1; i <= soNhom; i++) {
			String ii = String.valueOf(i);
			vt.addElement(String.valueOf(ii));
			new NhomThucHanhDAO().getNhomThucHanhTheoMaLopHocPhan(maLhp).forEach(x->{
				
				if(ii.equalsIgnoreCase(String.valueOf(x.getTenNhom()))) {
					vt.removeElement(ii);	
				}
			});
			
		}
		modelCBNhom.addAll(vt);
		

	}

	

	public void LoadGiangVien(String maChuyenNganh) {
		modelCbGiaoVien.removeAllElements();
		Vector<String> vt = new Vector<String>();
		new GiangVienDAO().getGiangVienTheoChuyenNganh(maChuyenNganh).forEach(x -> {

			vt.addElement(x.getTenGiangVien());

		});

		modelCbGiaoVien.addAll(vt);
		cbGiaoVien.setModel(modelCbGiaoVien);
	}

	public void LoadPhongThucHanh(String tenDay) {
		
			modelCbPhongHoc.removeAllElements();
			Vector<String> vt = new Vector<String>();
			new PhongHocDAO().getPhongHocTheoDay(tenDay).forEach(x -> {
				vt.addElement(x.getTenPhongHoc());
			});
			modelCbPhongHoc.addAll(vt);
			cbPhongHoc.setModel(modelCbPhongHoc);
		
	}
	public void loadTableNhom(String maLhp) {
		modelTableDanhSachNhom.getDataVector().removeAllElements();
		new NhomThucHanhDAO().getNhomThucHanhTheoMaLopHocPhan(maLhp).forEach(x->{
//			"Nhóm", "Giảng viên", "Phòng", "Tiết", "Sỉ số" 
			Vector<String> vector = new  Vector<String>();
			vector.addElement(String.valueOf(x.getTenNhom()));
			vector.addElement(String.valueOf(new GiangVienDAO().getTenGiangVien(x.getGiangVien().getMaGiangVien())));
			vector.addElement(String.valueOf(new PhongHocDAO().getTenPhongHoc(x.getPhongHoc().getMaphongHoc())));
			vector.addElement(String.valueOf(x.getThu()));
			vector.addElement(String.valueOf(x.getTietHoc()));
			vector.addElement(String.valueOf(x.getSiSo()));
			modelTableDanhSachNhom.addRow(vector);
		});
		table.setModel(modelTableDanhSachNhom);
	}

	
}
