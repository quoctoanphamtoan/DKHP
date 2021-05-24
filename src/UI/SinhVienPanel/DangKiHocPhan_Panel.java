package UI.SinhVienPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import javax.swing.table.DefaultTableModel;

import DAO.DangKiHocPhanCoNhomThucHanhDAO;
import DAO.DangKiHocPhanKhongCoNhomThucHanhDAO;
import DAO.GiangVienDAO;
import DAO.LopHocPhanDAO;
import DAO.MonHocDAO;
import DAO.NhomThucHanhDAO;
import DAO.PhongHocDAO;
import DAO.SinhVienDAO;
import Entity.LopHocPhan;
import Entity.NhomThucHanh;
import Entity.SinhVien;
import UI.XemCongNo;

public class DangKiHocPhan_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable table_dsLopHP;
	private JTable table_NhomTH;
	private JTable table_dsMonDaDangKy;

	private JComboBox<String> cb_kyhoc;

	private DefaultComboBoxModel<String> modelCbKyHoc;

	private JComboBox<String> cb_monHoc;

	private DefaultComboBoxModel<String> modelCbMonHoc;

	private DefaultTableModel modelTableMonHoc;

	private DefaultTableModel modelNhomLiThuyetThucHanh;

	private JComboBox<Object> cb_NhomTH;

	private DefaultComboBoxModel<Object> modelCbNhomTH;

	private DefaultTableModel modelTableDanhSachDaDangKi;

	private DefaultComboBoxModel<Object> modelNhomThucHanh;

	private JButton btn_Huy;

	/**
	 * Create the panel.
	 */

	public DangKiHocPhan_Panel(SinhVien sv) {
		setSize(1300, 730);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("ĐĂNG KÝ HỌC PHẦN");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(544, 0, 241, 28);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Năm học");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(201, 38, 62, 20);
		add(lblNewLabel_1);
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int namhienTai = gregorianCalendar.get(Calendar.YEAR);
		int namTiep = namhienTai + 1;
		JLabel lbl_namHoc = new JLabel(namhienTai + "-" + namTiep);
		lbl_namHoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_namHoc.setBounds(298, 38, 105, 20);
		add(lbl_namHoc);

		JLabel lblNewLabel_3 = new JLabel("Chọn kỳ  học");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(201, 69, 85, 20);
		add(lblNewLabel_3);

		cb_kyhoc = new JComboBox<String>();
		cb_kyhoc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String s = cb_kyhoc.getSelectedItem().toString().trim();
				String hocki = "";
				String namHoc = "";
				String[] splits = s.split("-");
				for (String item : splits) {
					int i = item.indexOf("/");
					if (i > 0) {
						namHoc = item;
					}
				}
				for (String item : splits) {
					int i = item.indexOf("/");
					if (i < 0) {
						hocki = item;
					}
				}
				getAllMonHocTheoChuyenNganh(sv.getMaSinhVien(), namHoc, Integer.parseInt(hocki));
//		        System.out.println(namHoc+hocki);
//		        System.out.println(sv.getMaSinhVien());

			}
		});
		modelCbKyHoc = new DefaultComboBoxModel<String>();
		cb_kyhoc.setModel(modelCbKyHoc);
		cb_kyhoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cb_kyhoc.setBounds(298, 69, 105, 20);
		add(cb_kyhoc);

		JLabel lblNewLabel_5 = new JLabel("DANH SÁCH LỚP HỌC PHẦN");
		lblNewLabel_5.setForeground(new Color(255, 69, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(622, 101, 250, 21);
		add(lblNewLabel_5);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(67, 125, 1173, 138);
		add(scrollPane_1);

		table_dsLopHP = new JTable();
		table_dsLopHP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String maLopHP = (String) table_dsLopHP.getValueAt(table_dsLopHP.getSelectedRow(), 0);
				LoadTableNhomLyThuyet(maLopHP);
				if (new DangKiHocPhanKhongCoNhomThucHanhDAO()
						.KiemTraKhongCoNhomThucHanh(new MonHocDAO().MaMonHocTheoMaLopHocPhan(maLopHP)) == false) {
					loadTabNhomThucHanh(maLopHP);
					cb_NhomTH.setEnabled(true);
//					cb_NhomTH.setModel(modelCbNhomTH);
					loadNhomThucHanh(maLopHP);
				}

			}

		});
		modelTableMonHoc = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã lớp học phần", "Sĩ số tối đa", "Sĩ số hiện tại" });
		table_dsLopHP.setModel(modelTableMonHoc);
		scrollPane_1.setViewportView(table_dsLopHP);

		JLabel lblNewLabel_6 = new JLabel("CHI TIẾT LỚP HỌC PHẦN");
		lblNewLabel_6.setForeground(new Color(255, 69, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(631, 269, 168, 20);
		add(lblNewLabel_6);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(67, 319, 1173, 105);
		add(scrollPane_2);

		table_NhomTH = new JTable();
		table_NhomTH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		modelNhomLiThuyetThucHanh = new DefaultTableModel(new Object[][] {},
				new String[] { "Thứ", "Tiết", "Phòng học", "Giảng viên", "Nhóm", "sỉ số" });
		table_NhomTH.setModel(modelNhomLiThuyetThucHanh);
		scrollPane_2.setViewportView(table_NhomTH);

		JLabel lblNewLabel_7 = new JLabel("Nhóm thực hành");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(267, 294, 136, 14);
		add(lblNewLabel_7);

		cb_NhomTH = new JComboBox<Object>();
		cb_NhomTH.setEnabled(false);
		modelCbNhomTH = new DefaultComboBoxModel<Object>();
		modelNhomThucHanh = new DefaultComboBoxModel<Object>();
		cb_NhomTH.setModel(modelNhomThucHanh);
		cb_NhomTH.setBounds(413, 291, 62, 22);
		add(cb_NhomTH);

		JLabel lblNewLabel_8 = new JLabel("DANH SÁCH MÔN HỌC ĐÃ ĐĂNG KÝ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setForeground(new Color(255, 69, 0));
		lblNewLabel_8.setBounds(607, 428, 241, 20);
		add(lblNewLabel_8);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(67, 459, 1173, 151);
		add(scrollPane_3);

		table_dsMonDaDangKy = new JTable();
		table_dsMonDaDangKy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_Huy.setEnabled(true);
			}
		});
		modelTableDanhSachDaDangKi = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã lớp học phần", "Tên môn học", "Số tín chỉ", "Nhóm thực hành", "Ngày đăng ký" });
		table_dsMonDaDangKy.setModel(modelTableDanhSachDaDangKi);
		scrollPane_3.setViewportView(table_dsMonDaDangKy);

		JLabel lblNewLabel_4 = new JLabel("Chọn môn học đăng ký");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(438, 41, 177, 14);
		add(lblNewLabel_4);

		cb_monHoc = new JComboBox<String>();
		cb_monHoc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (modelCbMonHoc.getSize() > 0) {
					loadTableMonHoc(new MonHocDAO().getMaMonHoc(cb_monHoc.getSelectedItem().toString().trim()));
				}

			}
		});
		modelCbMonHoc = new DefaultComboBoxModel<String>(new String[] { "" });
		cb_monHoc.setModel(modelCbMonHoc);
		cb_monHoc.setBounds(631, 38, 316, 22);
		add(cb_monHoc);

		JButton btnDangKy = new JButton("ĐĂNG KÝ");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < table_NhomTH.getRowCount(); i++) {
					String tiet = (String) table_NhomTH.getValueAt(i, 1);
					String thu = (String) table_NhomTH.getValueAt(i, 0);
					List<LopHocPhan> listTrung = new DangKiHocPhanKhongCoNhomThucHanhDAO()
							.KiemTraTrungTietThu(sv.getMaSinhVien(), tiet, thu);
					if (listTrung.size() > 0) {

//						String lophocphan = (Strisng) table_dsLopHP.getValueAt(table_dsLopHP.getSelectedRow(), 0);
						String monhoc = new MonHocDAO().getTenMonHoc(listTrung.get(0).getMonHocEnity().getMaMonHoc());
						JOptionPane.showMessageDialog(null,
								"Bị trung lịch vào tiết " + tiet + " thứ " + thu + " Môn " + monhoc);
						return;
					}

				}
//				List<LopHocPhan> listTrung = new DangKiHocPhanKhongCoNhomThucHanhDAO().KiemTraTrungTietThu(sv.getMaSinhVien(),, "2");

				if (cb_NhomTH.isEnabled()) {

					if (cb_NhomTH.isEnabled() && cb_NhomTH == null) {
						JOptionPane.showMessageDialog(null,
								"Lớp học phần đang quá trình sắp xếp nhóm thực hành xin quay lại sau");
						return;
					}
//					String soNhomThucHanh = cb_NhomTH.getSelectedItem().toString().trim();
					if (cb_NhomTH.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhóm thực hành");
						return;
					}

					DangKiHocPhanCoThucHanh(sv.getMaSinhVien());
				} else {
					DangKiHocPhan(sv.getMaSinhVien());
				}
			}

		});
		btnDangKy.setBounds(393, 633, 99, 34);
		add(btnDangKy);

		btn_Huy = new JButton("HỦY LỚP HỌC PHẦN");
		btn_Huy.setEnabled(false);
		btn_Huy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String maLopHP = (String) table_dsMonDaDangKy.getValueAt(table_dsMonDaDangKy.getSelectedRow(), 0)
						.toString().trim();
				int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc sẽ hũy lớp học này");
				if (i == 0) {
					String tenMonHoc = (String) table_dsMonDaDangKy.getValueAt(table_dsMonDaDangKy.getSelectedRow(), 1)
							.toString().trim();
					int tinChiThucHanh = new MonHocDAO().getTinChiThucHanh(new MonHocDAO().getMaMonHoc(tenMonHoc));
					if (tinChiThucHanh > 0) {
						if (new DangKiHocPhanKhongCoNhomThucHanhDAO().KiemTraHuyLopCoThucHanh(maLopHP) == false) {
							JOptionPane.showMessageDialog(null,
									"Không được hũy lớp học phần này vì đã chấp nhận mở lớp");
							return;
						} else {
							if (new DangKiHocPhanCoNhomThucHanhDAO().SinhVienHuyLopHocPhanCoThucHanh(sv.getMaSinhVien(),
									maLopHP)) {
								JOptionPane.showMessageDialog(null, "Hũy thành công");
								modelTableDanhSachDaDangKi.removeRow(table_dsMonDaDangKy.getSelectedRow());
							} else {
								JOptionPane.showMessageDialog(null, "Không thành công");
							}
						}
					} else {
						if (new DangKiHocPhanKhongCoNhomThucHanhDAO().KiemTraHuyLopKhongThucHanh(maLopHP) == false) {
							JOptionPane.showMessageDialog(null,
									"Không được hũy lớp học phần này vì đã chấp nhận mở lớp");
							return;
						} else {
							if (new DangKiHocPhanKhongCoNhomThucHanhDAO()
									.SinhVienHuyLopHocPhanKhongThucHanh(sv.getMaSinhVien(), maLopHP)) {
								JOptionPane.showMessageDialog(null, "Hũy thành công");
								modelTableDanhSachDaDangKi.removeRow(table_dsMonDaDangKy.getSelectedRow());
							} else {
								JOptionPane.showMessageDialog(null, "Không thành công");
							}
						}
					}

				}

//				System.out.println(MaNhom);
			}
		});
		btn_Huy.setBounds(527, 633, 177, 34);
		add(btn_Huy);
		JButton btn_XemCongNo = new JButton("XEM CÔNG NỢ");
		btn_XemCongNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new XemCongNo(sv).setVisible(true);

			}
		});
		btn_XemCongNo.setBounds(775, 633, 177, 34);
		add(btn_XemCongNo);
		loadKiHocNamHoc();
		loadLopHocPhanDaDangKi(sv.getMaSinhVien());

	}

	public void getAllMonHocTheoChuyenNganh(String maSinhVien, String namHoc, int kiHoc) {
		modelCbMonHoc.removeAllElements();
		table_dsLopHP.removeAll();
		table_NhomTH.removeAll();
		Vector<String> vector = new Vector<String>();
		new MonHocDAO().getAllMonHocTheoChuyenNganh(new SinhVienDAO().getChuyenNganhSinhVien(maSinhVien), namHoc, kiHoc)
				.forEach(x -> {
					vector.add(x.getTenMonHoc());
					new SinhVienDAO().monHocDaDangKi(maSinhVien).forEach(Y -> {

						if (x.getTenMonHoc().equalsIgnoreCase(Y)) {
							vector.removeElement(x.getTenMonHoc());
						}
					});
					new SinhVienDAO().monHocDaDangKiKhongThucHanh(maSinhVien).forEach(Z -> {

						if (x.getTenMonHoc().equalsIgnoreCase(Z)) {
							vector.removeElement(x.getTenMonHoc());
						}
					});
				});

//		new LopHocPhanDAO().getLopHocPhanCoThucHanhDaDangKi(maSinhvien)
		modelCbMonHoc.addAll(vector);

//		vector.remo
		cb_monHoc.setModel(modelCbMonHoc);
		if (modelCbMonHoc.getSize() > 0) {
			cb_monHoc.setSelectedIndex(0);
		}

	}

	public void getLopHocThucHanhTheoMaHP(String monhoc) {
//		modelNhomLiThuyetThucHanh.getDataVector().removeAllElements();
		int i = 0;
		ResultSet rs = new LopHocPhanDAO().getLopHocThucHanhTheoMaHP(monhoc);
		try {
			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.addElement(rs.getString(2));
//				System.out.println(rs.getString(1));
				vector.addElement(rs.getString(3));
				vector.addElement(new PhongHocDAO().getTenPhongHoc(rs.getString(4)));
				vector.addElement(new GiangVienDAO().getTenGiangVien(rs.getString(5)));
				vector.addElement(rs.getString(1));
				modelNhomLiThuyetThucHanh.addRow(vector);
				i++;

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "TH");
		}
		table_NhomTH.setModel(modelNhomLiThuyetThucHanh);
		for (int x = 1; x <= i; x++) {
			Vector<String> vt = new Vector<String>();
			vt.add(String.valueOf(x));
			modelCbNhomTH.addAll(vt);
		}

//		cb_NhomTH.setModel(modelCbNhomTH);

	}

	// select lhp.maLopHP,mh.tenMonHoc,mh.soTCLyThuyet,mh.soTCThucHanh, pdk.maNhom
	// ,pdk.ngayDangKy from (PhieuDangKyHocPhan pdk join LopHocPhan lhp on
	// lhp.maLopHP = pdk.maLopHP) join MonHoc mh on mh.maMonHoc = lhp.maMonHoc where
	// pdk.maSinhVien='SV02'
	public void loadKiHocNamHoc() {
		cb_kyhoc.removeAllItems();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		Vector<String> vt = new Vector<String>();
		int namhienTai = gregorianCalendar.get(Calendar.YEAR);
		int namTiep = namhienTai + 1;
		for (int i = 1; i <= 3; i++) {
			String s = i + "-" + (namhienTai - 1) + "/" + (namTiep - 1);
			vt.add(s);
		}
		for (int i = 1; i <= 3; i++) {
			String x = i + "-" + namhienTai + "/" + namTiep;
			vt.add(x);
		}
		for (int i = 1; i <= 3; i++) {
			String c = i + "-" + (namhienTai + 1) + "/" + (namTiep + 1);
			vt.add(c);
		}
		modelCbKyHoc.addAll(vt);
		cb_kyhoc.setModel(modelCbKyHoc);
//		if()

	}

	public void loadTableMonHoc(String monhoc) {
		modelTableMonHoc.getDataVector().removeAllElements();
		ResultSet rs = new LopHocPhanDAO().getLopTheoMaMonHoc(monhoc);
		try {
			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.addElement(rs.getString(1));
				vector.addElement(rs.getString(2));
				if (new MonHocDAO().KiemTraMonHocCoChiThucHanh(
						new MonHocDAO().getMaChuyenNganhBangTenMonHoc(cb_monHoc.getSelectedItem().toString().trim()))) {
					vector.addElement(String
							.valueOf(new DangKiHocPhanKhongCoNhomThucHanhDAO().getSiSoHienTaiLHP(rs.getString(1))));
				}
				vector.addElement(
						String.valueOf(new DangKiHocPhanCoNhomThucHanhDAO().getSiSoHienTaiLHP(rs.getString(1))));

				modelTableMonHoc.addRow(vector);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		table_dsLopHP.setModel(modelTableMonHoc);

	}

	public void LoadTableNhomLyThuyet(String maLopHP) {
		modelNhomLiThuyetThucHanh.getDataVector().removeAllElements();
		LopHocPhan lhp = new LopHocPhanDAO().getLopHocPhanTheoMaLopHP(maLopHP);
		if (lhp != null) {
			Vector<String> vector = new Vector<String>();
			vector.addElement(lhp.getThu());
			vector.addElement(lhp.getTietHoc());
			vector.addElement(new PhongHocDAO().getTenPhongHoc(lhp.getPhongHoc().getMaphongHoc()));
			vector.addElement(new GiangVienDAO().getTenGiangVien(lhp.getGiangVien().getMaGiangVien()));
			vector.addElement("Lý thuyết");
			vector.addElement(new DangKiHocPhanKhongCoNhomThucHanhDAO().getSiSoHienTaiLHP(maLopHP) + "/"
					+ new LopHocPhanDAO().getSiSoLopHocPhan(maLopHP));
			modelNhomLiThuyetThucHanh.addRow(vector);
		}
		table_NhomTH.setModel(modelNhomLiThuyetThucHanh);

	}

	public void loadTabNhomThucHanh(String maLopHP) {
		new NhomThucHanhDAO().getNhomThucHanhTheoMaLopHocPhan(maLopHP).forEach(x -> {
			Vector<String> vector = new Vector<String>();
			vector.addElement(x.getThu());
			vector.addElement(x.getTietHoc());
			vector.addElement(new PhongHocDAO().getTenPhongHoc(x.getPhongHoc().getMaphongHoc()));
			vector.addElement(new GiangVienDAO().getTenGiangVien(x.getGiangVien().getMaGiangVien()));
			vector.addElement("Nhóm thực hành " + String.valueOf(x.getTenNhom()));
			vector.addElement(new NhomThucHanhDAO().getSiSoNhomThucHanh(x.getMaNhom(), maLopHP) + "/" + x.getSiSo());
			modelNhomLiThuyetThucHanh.addRow(vector);

		});
		table_NhomTH.setModel(modelNhomLiThuyetThucHanh);

	}

	public void DangKiHocPhan(String maSinhVien) {
		String maLopHP = (String) table_dsLopHP.getValueAt(table_dsLopHP.getSelectedRow(), 0);
		if (new DangKiHocPhanKhongCoNhomThucHanhDAO()
				.KiemTraKhongCoNhomThucHanh(new MonHocDAO().MaMonHocTheoMaLopHocPhan(maLopHP))) {
			if (new DangKiHocPhanKhongCoNhomThucHanhDAO().SinhVienDangKiLopHocPhan(maSinhVien, maLopHP)) {
				JOptionPane.showMessageDialog(null, "Đăng kí thành công");
				loadLopHocPhanDaDangKi(maSinhVien);
//				getAllMonHocTheoChuyenNganh(maSinhVien,)
				cb_monHoc.remove(cb_monHoc.getSelectedIndex());
			}

		}

	}

	public void DangKiHocPhanCoThucHanh(String maSinhVien) {
		String maLopHP = (String) table_dsLopHP.getValueAt(table_dsLopHP.getSelectedRow(), 0);
		NhomThucHanh nhom = (NhomThucHanh) cb_NhomTH.getItemAt(cb_NhomTH.getSelectedIndex());
		if (new DangKiHocPhanKhongCoNhomThucHanhDAO()
				.KiemTraKhongCoNhomThucHanh(new MonHocDAO().MaMonHocTheoMaLopHocPhan(maLopHP)) == false) {
			if (new DangKiHocPhanCoNhomThucHanhDAO().SinhVienDangKiLopHocPhan(maSinhVien, maLopHP, nhom.getMaNhom())) {
				JOptionPane.showMessageDialog(null, "Đăng kí thành công");
				loadLopHocPhanDaDangKi(maSinhVien);
				cb_monHoc.remove(cb_monHoc.getSelectedIndex());
			}

		}

	}

	public void loadNhomThucHanh(String maLopHP) {
		modelNhomThucHanh.removeAllElements();
		new NhomThucHanhDAO().getNhomThucHanhTheoMaLopHocPhan(maLopHP).forEach(x -> {
			Vector<Object> vector = new Vector<Object>();
			vector.addElement(x);
			modelNhomThucHanh.addAll(vector);
		});
		cb_NhomTH.setModel(modelNhomThucHanh);

	}

	public void loadLopHocPhanDaDangKi(String maSinhVien) {
		modelTableDanhSachDaDangKi.getDataVector().removeAllElements();
		
		ResultSet rs = new LopHocPhanDAO().getLopHocPhanCoThucHanhDaDangKi(maSinhVien);
		try {
			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.addElement(rs.getString(1));
				vector.addElement(rs.getString(2));
				vector.addElement(String.valueOf(rs.getInt(3)));
				vector.addElement(String.valueOf(rs.getInt(4)));
				vector.addElement(String.valueOf(rs.getDate(5)));
				modelTableDanhSachDaDangKi.addRow(vector);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rss = new LopHocPhanDAO().getLopHocPhanKhongThucHanhDaDangKi(maSinhVien);

		try {
			while (rss.next()) {
				Vector<String> vector = new Vector<String>();
				vector.addElement(rss.getString(1));
				vector.addElement(rss.getString(2));
				vector.addElement(String.valueOf(rss.getInt(3)));
				vector.addElement("");
				vector.addElement(String.valueOf(rss.getDate(4)));
				modelTableDanhSachDaDangKi.addRow(vector);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		table_dsMonDaDangKy.setModel(modelTableDanhSachDaDangKi);
	}
}
