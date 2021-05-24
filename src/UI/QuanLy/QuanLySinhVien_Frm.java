package UI.QuanLy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.LopDAO;
import DAO.NganhDAO;
import DAO.SinhVienDAO;
import DAO.TaiKhoanDAO;
import Entity.LopHoc;
import Entity.Nganh;
import Entity.NguoiQuanLi;
import Entity.SinhVien;
import Entity.TaiKhoan;

public class QuanLySinhVien_Frm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_sv;
	private JTextField txt_Hoten;
	private JTextField txt_dichi;
	private JComboBox<String> cb_maLop;
	private DefaultComboBoxModel<String> modelCbLop;
	private JComboBox<String> cb_Nganh;
	private DefaultComboBoxModel<String> modelCbNganh;
	private JComboBox<String> cb_gioiTinh;
	private DefaultTableModel modelTableSinhVien;
	private JComboBox<String> cb_hdt;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private JDateChooser dateChooser;
	private JComboBox<String> comboBox_chonNganh;
	private DefaultComboBoxModel<String> modelNganh;
	private JComboBox<String> comboBox_chonLop;
	private DefaultComboBoxModel<String> modelLop;
	private JButton btn_Sua;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public QuanLySinhVien_Frm(NguoiQuanLi nql) {
		setSize(1300, 730);
		setLayout(null);

		JLabel lbldssv = new JLabel("Danh sách sinh viên");
		lbldssv.setBounds(10, 27, 167, 22);
		lbldssv.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane_sv = new JScrollPane();
		scrollPane_sv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_Sua.setEnabled(true);
				
				
			}
		});
		scrollPane_sv.setBounds(26, 99, 1252, 275);
		add(scrollPane_sv);

		table_sv = new JTable();
		table_sv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tenSinhVien = (String) table_sv.getValueAt(table_sv.getSelectedRow(), 1).toString().trim();
				String ngaySinh = (String) table_sv.getValueAt(table_sv.getSelectedRow(), 2).toString().trim();
				String heDaoTao = (String) table_sv.getValueAt(table_sv.getSelectedRow(), 3).toString().trim();
				String diaChi = (String) table_sv.getValueAt(table_sv.getSelectedRow(), 4).toString().trim();
				String MaLop = (String) table_sv.getValueAt(table_sv.getSelectedRow(), 5).toString().trim();
				String Nganh = (String) table_sv.getValueAt(table_sv.getSelectedRow(), 6).toString().trim();
				txt_Hoten.setText(tenSinhVien);
				cb_hdt.setSelectedItem(heDaoTao);
				cb_maLop.setSelectedItem(MaLop);
				txt_dichi.setText(diaChi);
				cb_Nganh.setSelectedItem(Nganh);
				loadMaLop(Nganh);
				btn_Sua.setEnabled(true);
				

			}
		});
		table_sv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modelTableSinhVien = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sinh viên", "Họ tên", "Ngày sinh", "Hệ đào tạo", "Địa chỉ", "Mã lớp", "Ngành" });
		table_sv.setModel(modelTableSinhVien);

		scrollPane_sv.setViewportView(table_sv);

		JPanel panel = new JPanel();
		panel.setBounds(26, 384, 1252, 307);
		add(panel);
		panel.setLayout(null);
		modelCbLop = new DefaultComboBoxModel<String>(new String[] { "" });
		modelCbNganh = new DefaultComboBoxModel<String>(new String[] { "" });

		JLabel lblNewLabel_6 = new JLabel("Giới tính");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(23, 203, 77, 18);
		panel.add(lblNewLabel_6);

		cb_gioiTinh = new JComboBox<String>();
		cb_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb_gioiTinh.setModel(new DefaultComboBoxModel<String>(new String[] { "Nam", "Nữ" }));
		cb_gioiTinh.setBounds(106, 196, 86, 33);
		panel.add(cb_gioiTinh);

		JLabel lblNewLabel_4 = new JLabel("Địa chỉ");
		lblNewLabel_4.setBounds(23, 149, 55, 19);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setBounds(25, 46, 69, 22);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Hoten = new JTextField();
		txt_Hoten.setBounds(104, 39, 259, 33);
		panel.add(txt_Hoten);
		txt_Hoten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Hoten.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Ngày sinh:");
		lblNewLabel_2.setBounds(25, 97, 69, 21);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_dichi = new JTextField();
		txt_dichi.setBounds(104, 139, 259, 33);
		panel.add(txt_dichi);
		txt_dichi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_dichi.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Hệ đào tạo");
		lblNewLabel_3.setBounds(458, 46, 84, 22);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cb_hdt = new JComboBox<String>();
		cb_hdt.setBounds(575, 41, 136, 33);
		panel.add(cb_hdt);
		cb_hdt.setModel(new DefaultComboBoxModel<String>(new String[] { "Đại học", "Cao đẳng" }));
		cb_hdt.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btn_Them = new JButton("THÊM");
		btn_Them.setBounds(962, 28, 160, 58);
		panel.add(btn_Them);
		// btn_Them.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		// }
		// });
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String hotenSinhVien = txt_Hoten.getText().trim();
				String diaChi = txt_dichi.getText().trim();
				boolean gioiTinh = true;
				if (cb_gioiTinh.getSelectedItem().toString().trim().equalsIgnoreCase("Nữ")) {
					gioiTinh = false;
				}
				String heDaoTao = cb_hdt.getSelectedItem().toString().trim();
				String maNganh = new NganhDAO().getMaNganhBangTen(cb_Nganh.getSelectedItem().toString().trim());
				String malop = new LopDAO().getMaLop(cb_maLop.getSelectedItem().toString().trim());
				String ngaySinh = formatter.format(dateChooser.getDate());
				Date date = Date.valueOf(ngaySinh);
				if (new TaiKhoanDAO().themTaiKhoan()) {
					if (new SinhVienDAO().themSinhVien(new SinhVien(hotenSinhVien, gioiTinh, date, diaChi, heDaoTao,
							new Nganh(maNganh), new TaiKhoan(new SinhVienDAO().getMaSinhVien()),
							new LopHoc(malop, cb_maLop.getSelectedItem().toString().trim()), nql))) {
						JOptionPane.showMessageDialog(null, "Thêm thành công ");
						loadSinhVien();
					} else {
						JOptionPane.showMessageDialog(null, "Loi");

					}

				}

			}
		});
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btn_Sua = new JButton("SỬA THÔNG TIN");
		btn_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String hoTen = txt_Hoten.getText().toString().trim();
					String maSinhVien = table_sv.getValueAt(table_sv.getSelectedRow(), 0).toString().trim();
					String maLop = new LopDAO().getMaLop(cb_maLop.getSelectedItem().toString().trim());
					String ngaySinh = formatter.format(dateChooser.getDate());
					Date date = Date.valueOf(ngaySinh);
					boolean gioiTinh = true;
					if (cb_gioiTinh.getSelectedItem().toString().trim().equalsIgnoreCase("Nữ")) {
						gioiTinh = false;
					}
					String diaChi = txt_dichi.getText().trim();
					String heDaoTao = cb_hdt.getSelectedItem().toString().trim();
					if(new SinhVienDAO().capNhatSinhVien(maLop, hoTen, maLop, date,diaChi , heDaoTao, gioiTinh)) {
						JOptionPane.showMessageDialog(null, "Cap nhat thanh cong");
						loadSinhTheoLop(maLop);
					}
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Kiem tra lai thong tin");
				}
			}
		});
		btn_Sua.setEnabled(false);
		btn_Sua.setBounds(962, 190, 160, 58);
		panel.add(btn_Sua);
		btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 14));

		dateChooser = new JDateChooser();
		dateChooser.setBounds(104, 91, 196, 33);
		panel.add(dateChooser);

		JLabel lblNewLabel_7 = new JLabel("Chuyên nghành");
		lblNewLabel_7.setBounds(458, 97, 108, 20);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_Nganh = new JComboBox<String>();
		cb_Nganh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String maNganh = new NganhDAO().getMaNganhBangTen(cb_Nganh.getSelectedItem().toString().trim());
				loadLopTheoNganh(maNganh);
			}

		});
		cb_Nganh.setBounds(575, 93, 240, 33);
		panel.add(cb_Nganh);
		cb_Nganh.setModel(modelCbNganh);

		JLabel lblNewLabel_5 = new JLabel("Lớp");
		lblNewLabel_5.setBounds(458, 149, 55, 18);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_maLop = new JComboBox<String>();
		cb_maLop.setBounds(575, 142, 240, 33);
		panel.add(cb_maLop);
		cb_maLop.setModel(modelCbLop);
		cb_maLop.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btn_Xoa = new JButton("XÓA");
		btn_Xoa.setBounds(962, 111, 160, 58);
		panel.add(btn_Xoa);
		btn_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String maSinhVien = (String) table_sv.getValueAt(table_sv.getSelectedRow(), 0).toString().trim();
				int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa sinh viên "
						+ (String) table_sv.getValueAt(table_sv.getSelectedRow(), 1).toString().trim());
				if (i == 0) {
					if (new SinhVienDAO().xoaSinhVien(maSinhVien)) {
						JOptionPane.showMessageDialog(null, "Xóa thành công "
								+ (String) table_sv.getValueAt(table_sv.getSelectedRow(), 1).toString().trim());
						loadSinhVien();
					} else {
						JOptionPane.showMessageDialog(null, "Xóa không thành công "
								+ (String) table_sv.getValueAt(table_sv.getSelectedRow(), 1).toString().trim());
					}
				}
			}
		});
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("Chọn ngành");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(84, 38, 85, 21);
		add(lblNewLabel);

		comboBox_chonNganh = new JComboBox<String>();
		comboBox_chonNganh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String nganh = comboBox_chonNganh.getSelectedItem().toString();
				String maNganh = new NganhDAO().getMaNganhBangTen(nganh);
				loadMaLop(maNganh);
			}

		});
		modelNganh = new DefaultComboBoxModel<String>();
		comboBox_chonNganh.setModel(modelNganh);
		comboBox_chonNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_chonNganh.setBounds(197, 42, 316, 26);
		add(comboBox_chonNganh);

		JLabel lblNewLabel_8 = new JLabel("Chọn lớp");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(596, 42, 73, 21);
		add(lblNewLabel_8);

		comboBox_chonLop = new JComboBox<String>();
		comboBox_chonLop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modelLop.getSize() > 0) {
					String lop = comboBox_chonLop.getSelectedItem().toString().trim();
					loadSinhTheoLop(new LopDAO().getMaLop(lop));
				}
			}
		});
		modelLop = new DefaultComboBoxModel<String>();
		comboBox_chonLop.setModel(modelLop);
		comboBox_chonLop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_chonLop.setBounds(677, 42, 160, 26);
		add(comboBox_chonLop);

		JLabel lblNewLabel_9 = new JLabel("Danh sách sinh viên");
		lblNewLabel_9.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_9.setBounds(26, 83, 165, 13);
		add(lblNewLabel_9);
		loadSinhVien();
		loadChuyenNganh();
		loadLop();
		loadNganh();

	}

//	public void loadLopHoc() {
//		modelCbLop.removeAllElements();
//		Vector<String> vt = new Vector<String>();
//
//		new LopDAO().getMaLopHocByNganh(ma).forEach(x -> {
//			vt.addElement(x.getTenLop());
//
//		});
//		modelCbLop.addAll(vt);
//		cb_maLop.setModel(modelCbLop);
//	}

	public void loadSinhVien() {
		modelTableSinhVien.getDataVector().removeAllElements();
		// Mã sinh viên", "Họ tên", "Ngày sinh", "Hệ đào tạo", "Địa chỉ", "Mã lớp",
		// "Ngành"
		new SinhVienDAO().getSinhVienALL().forEach(x -> {
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getMaSinhVien());
			vt.addElement(x.getTenSinhVien());
			vt.addElement(String.valueOf(x.getNgaySinh()));
			vt.addElement(String.valueOf(x.getHeDaoTao()));
			vt.addElement(String.valueOf(x.getDiaChi()));
			vt.addElement(String.valueOf(x.getLopEnity().getMaLop()));
			vt.addElement(new NganhDAO().getTenNganh(String.valueOf(x.getNganhEnity().getMaNganh())));
			modelTableSinhVien.addRow(vt);

		});
		table_sv.setModel(modelTableSinhVien);
	}

	public void loadMaLop(String maNganh) {
		modelLop.removeAllElements();
		List<LopHoc> list = new LopDAO().getLopTheoMaNganh(maNganh);
		try {
			if (list.size() > 0) {
				list.forEach(x -> {
					Vector<String> vt = new Vector<String>();
					vt.add(x.getTenLop());
					modelLop.addAll(vt);
				});

				comboBox_chonLop.setModel(modelLop);
			}
		} catch (Exception e) {
			modelLop.removeAllElements();
		}
		if (modelLop.getSize() > 0) {
			comboBox_chonLop.setSelectedIndex(0);
		}

	}

	public void loadChuyenNganh() {
		comboBox_chonNganh.removeAll();
		Vector<String> vt = new Vector<String>();
		new NganhDAO().getTALL().forEach(x -> {

			vt.addElement(x.getTenNganh());

		});
		modelNganh.addAll(vt);
		comboBox_chonNganh.setModel(modelNganh);
		if (modelNganh.getSize() > 0) {
			comboBox_chonNganh.setSelectedIndex(0);
		}

	}

	public void loadNganh() {
		cb_Nganh.removeAll();
		Vector<String> vt = new Vector<String>();
		new NganhDAO().getTALL().forEach(x -> {

			vt.addElement(x.getTenNganh());

		});
		modelCbNganh.addAll(vt);
		cb_Nganh.setModel(modelCbNganh);
		if (modelCbNganh.getSize() > 0) {
			cb_Nganh.setSelectedIndex(0);
		}

	}

	public void loadLop() {
		cb_maLop.removeAll();
		Vector<String> vt = new Vector<String>();
		new LopDAO().getAllLopHoc().forEach(x -> {

			vt.addElement(x.getMaLop());

		});
		modelCbLop.addAll(vt);
		cb_maLop.setModel(modelCbLop);
		if (modelCbLop.getSize() > 0) {
			cb_maLop.setSelectedIndex(0);
		}

	}

	public void loadSinhTheoNganh(String nganh) {
		modelTableSinhVien.getDataVector().removeAllElements();

		new SinhVienDAO().getSinhVienALLTheoMaNganh(nganh).forEach(x -> {
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getMaSinhVien());
			vt.addElement(x.getTenSinhVien());
			vt.addElement(String.valueOf(x.getNgaySinh()));
			vt.addElement(String.valueOf(x.getHeDaoTao()));
			vt.addElement(String.valueOf(x.getDiaChi()));
			vt.addElement(String.valueOf(x.getLopEnity().getMaLop()));
			vt.addElement(new NganhDAO().getTenNganh(String.valueOf(x.getNganhEnity().getMaNganh())));
			modelTableSinhVien.addRow(vt);

		});
		table_sv.setModel(modelTableSinhVien);

	}

	public void loadSinhTheoLop(String lop) {
		modelTableSinhVien.getDataVector().removeAllElements();
		new SinhVienDAO().getSinhVienALLTheoMaLop(lop).forEach(x -> {
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getMaSinhVien());
			vt.addElement(x.getTenSinhVien());
			vt.addElement(String.valueOf(x.getNgaySinh()));
			vt.addElement(String.valueOf(x.getHeDaoTao()));
			vt.addElement(String.valueOf(x.getDiaChi()));
			vt.addElement(String.valueOf(x.getLopEnity().getMaLop()));
			vt.addElement(new NganhDAO().getTenNganh(String.valueOf(x.getNganhEnity().getMaNganh())));
			modelTableSinhVien.addRow(vt);

		});
		table_sv.setModel(modelTableSinhVien);
	}

	private void loadLopTheoNganh(String maNganh) {
		cb_maLop.removeAllItems();
		Vector<String> vt = new Vector<String>();
		new LopDAO().getLopTheoMaNganh(maNganh).forEach(x -> {
			vt.add(x.getMaLop());
			modelCbLop.addAll(vt);

		});

		cb_maLop.setModel(modelCbLop);
//		if (modelCbLop.getSize() > 0) {
//			cb_maLop.setSelectedIndex(0);
//		}

	}
}
