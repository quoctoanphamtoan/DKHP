package UI.NhanVienPanel;

import java.awt.Color;
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
import javax.swing.border.EmptyBorder;

import DAO.GiangVienDAO;
import DAO.LopHocPhanDAO;
import DAO.NganhDAO;
import DAO.PhongHocDAO;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ChinhSuaLopHocPhan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cbThu;
	private JComboBox<String> cbGiangVien;
	private JComboBox<String> cbTietHoc;
	private JComboBox<String> cbPhongHoc;
	private DefaultComboBoxModel<String> modelGiangVienCB;
	private DefaultComboBoxModel<String> modelPhongHocCB;
	private JLabel lblMaLopHocPhan;

	public ChinhSuaLopHocPhan(String maChuyenNganh,String maLopHP) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tiết Học");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 71, 78, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblTh = new JLabel("Thứ");
		lblTh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTh.setBounds(10, 119, 78, 23);
		contentPane.add(lblTh);
		
		JLabel lblPhngHc = new JLabel("Phòng học");
		lblPhngHc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhngHc.setBounds(10, 216, 78, 23);
		contentPane.add(lblPhngHc);
		
		JLabel lblGingVin = new JLabel("Giảng viên");
		lblGingVin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGingVin.setBounds(230, 71, 78, 23);
		contentPane.add(lblGingVin);
		
		cbGiangVien = new JComboBox<String>();
		modelGiangVienCB= new DefaultComboBoxModel<String>(new String[] {""});
		cbGiangVien.setModel(modelGiangVienCB);
		cbGiangVien.setBounds(312, 72, 164, 23);
		contentPane.add(cbGiangVien);
		
		cbThu = new JComboBox<String>();
		cbThu.setModel(new DefaultComboBoxModel<String>(new String[] {"2", "3", "4", "5", "6", "7", "Chá»§ nháº­t"}));
		cbThu.setBounds(98, 120, 78, 22);
		contentPane.add(cbThu);
		
		cbTietHoc = new JComboBox<String>();
		cbTietHoc.setModel(new DefaultComboBoxModel<String>(new String[] {"1-3", "4-6", "7-9", "10-12", "13-15"}));
		cbTietHoc.setBounds(98, 72, 78, 22);
		contentPane.add(cbTietHoc);
		
		cbPhongHoc = new JComboBox<String>();
		modelPhongHocCB= new DefaultComboBoxModel<String>(new String[] {""});
		cbPhongHoc.setModel(modelPhongHocCB);
		cbPhongHoc.setBounds(98, 217, 78, 22);
		contentPane.add(cbPhongHoc);
		
		JButton btnChinhSua = new JButton("Sửa");
		btnChinhSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "Nhấn có để sửa thông tin lớp học phần ");
				if(i==0) {
					
					try {
						String tietHoc= cbTietHoc.getSelectedItem().toString().trim();
						String thu = cbThu.getSelectedItem().toString().trim();
						String phongHoc = cbPhongHoc.getSelectedItem().toString().trim();
						String maGiangVien = new GiangVienDAO().getMaGiangVien(cbGiangVien.getSelectedItem().toString().trim());
						if (new LopHocPhanDAO().kiemTraTrungTietThuGiangVien(tietHoc, thu,
								new GiangVienDAO().getMaGiangVien(maGiangVien))) {
							if (new LopHocPhanDAO().kiemTraTrungTietThuPhong(tietHoc, thu,
									new PhongHocDAO().getMaPhongHocTheoTen(new PhongHocDAO().getMaPhongHocTheoTen(phongHoc)))) {
								///
								if(new LopHocPhanDAO().ChinhSuaLopHocPhan(maLopHP, thu, tietHoc, phongHoc, maGiangVien)) {
									JOptionPane.showMessageDialog(null, "Cập nhật thành công");
									setVisible(false);
									
								}else {
									JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
								}
								
							} else {
								JOptionPane.showMessageDialog(null, "Tiết " + tietHoc + " Thứ " + thu + " Phòng " + phongHoc
										+ " đã có lớp học phần, xin chọn lại");

							}
						} else {
							JOptionPane.showMessageDialog(null, "Tiết " + tietHoc + " Thứ " + thu + " Giang vien " + cbGiangVien.getSelectedItem().toString().trim()
									+ " đã có lớp học phần, xin chọn lại");

						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Xin kiểm tra lại dữ liệu");
					}
				}else{
					return;
				}
				
			}
		});
		btnChinhSua.setBounds(329, 150, 89, 23);
		contentPane.add(btnChinhSua);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnHuy.setBounds(329, 196, 89, 23);
		contentPane.add(btnHuy);
		
		lblMaLopHocPhan = new JLabel(maLopHP);
		lblMaLopHocPhan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaLopHocPhan.setBounds(10, 11, 78, 23);
		contentPane.add(lblMaLopHocPhan);
		
		JLabel lblDyPhng = new JLabel("Dãy phòng");
		lblDyPhng.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDyPhng.setBounds(10, 168, 78, 23);
		contentPane.add(lblDyPhng);
		
		JComboBox<String> cbDayPhong = new JComboBox<String>();
		cbDayPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				loadTenPhongPhong(cbDayPhong.getSelectedItem().toString().trim());
			}
		});
		cbDayPhong.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "B", "C", "D", "H", "V", "X", "E"}));
		cbDayPhong.setBounds(98, 169, 78, 22);
		contentPane.add(cbDayPhong);
		loadTenPhongPhong("A");
		loadCbGiangvien(maChuyenNganh);
		
	}
	public void loadTenPhongPhong(String tenDay) {
		modelPhongHocCB.removeAllElements();
		Vector<String> vt = new Vector<String>();
		new PhongHocDAO().getPhongHocTheoDay(tenDay).forEach(x -> {
			vt.addElement(x.getTenPhongHoc());
		});
		modelPhongHocCB.addAll(vt);
		cbPhongHoc.setModel(modelPhongHocCB);
//		cbPhongHoc.setSelectedIndex(0);
	}
	public void loadCbGiangvien(String maChuyenNganh) {
		modelGiangVienCB.removeAllElements();
		Vector<String> vt = new Vector<String>();
		new GiangVienDAO().getGiangVienTheoChuyenNganh(maChuyenNganh).forEach(x -> {
			vt.addElement(x.getTenGiangVien());

		});

		modelGiangVienCB.addAll(vt);
		cbGiangVien.setModel(modelGiangVienCB);

	}
	
}
