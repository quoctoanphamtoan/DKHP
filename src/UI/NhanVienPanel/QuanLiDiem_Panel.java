package UI.NhanVienPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.LopDAO;
import DAO.LopHocPhanDAO;
import DAO.NganhDAO;
import DAO.SinhVienDAO;
import DAO.TimKiemFull;
import Entity.LopHocPhan;
import Entity.SinhVien;
import GhiFileExcel.GhiLopHocPhan;

public class QuanLiDiem_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblDanhSachSinhVien;
	private JComboBox<String> cbLopHocPhan;
	private DefaultComboBoxModel<String> modelcbLHP;
	private DefaultTableModel modelSinhVien;
	private JLabel lblGIangVien;
	private JLabel lblTenMonHoc;
	private JComboBox<String> cbKi;
	private JTextField txtMaLopHP;
	private DefaultComboBoxModel<String> modelKi;
	private JTextField txtDuongDan;
	private JButton btnLuu;

	/**
	 * Create the panel.
	 */

	public QuanLiDiem_Panel() {
		setSize(1300, 730);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Lớp học phần");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(264, 20, 101, 33);
		add(lblNewLabel);

		cbLopHocPhan = new JComboBox<String>();
		cbLopHocPhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbLopHocPhan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (modelcbLHP.getSize() > 0) {
					loadDataTableSinhVIen(cbLopHocPhan.getSelectedItem().toString().trim());
				} else {
				}
			}
		});
		cbLopHocPhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		modelcbLHP = new DefaultComboBoxModel<String>(new String[] { "Chọn lớp học phần" });

		cbLopHocPhan.setBounds(353, 27, 177, 26);
		add(cbLopHocPhan);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 1257, 526);
		add(scrollPane);

		tblDanhSachSinhVien = new JTable();
		tblDanhSachSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblDanhSachSinhVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				String ma = String.valueOf(tblDanhSachSinhVien.getValueAt(tblDanhSachSinhVien.getSelectedRow(), 0))
//						.trim();
//				String ten = String.valueOf(tblDanhSachSinhVien.getValueAt(tblDanhSachSinhVien.getSelectedRow(), 1))
//						.trim();
//				SinhVien sv = new SinhVien(ma, ten);
//				MonHoc monhoc = new MonHoc(lblMaMH.getText().trim());
			}
		});
//		String maSinhVien, String tenSinhVien, boolean gioiTinh, Date ngaySinh, 
//		NganhEnity nganhEnity, LopEnity lopEnity
		modelSinhVien = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sinh viên", "Tên sinh viên", "Giới tính", "Ngày sinh", "Ngành", "Lớp" });
		tblDanhSachSinhVien.setModel(modelSinhVien);
		scrollPane.setViewportView(tblDanhSachSinhVien);

		lblGIangVien = new JLabel("");
		lblGIangVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGIangVien.setBounds(326, 15, 146, 33);
		add(lblGIangVien);

		lblTenMonHoc = new JLabel("");
		lblTenMonHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenMonHoc.setBounds(144, 650, 169, 33);
		add(lblTenMonHoc);

		cbKi = new JComboBox<String>();
		modelKi = new DefaultComboBoxModel<String>();
		cbKi.setModel(modelKi);
		cbKi.setBounds(135, 25, 101, 26);
		add(cbKi);

		JLabel lblNewLabel_1 = new JLabel("Chọn học kỳ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(53, 26, 78, 22);
		add(lblNewLabel_1);

		txtMaLopHP = new JTextField();
		txtMaLopHP.setBounds(578, 27, 86, 20);
		add(txtMaLopHP);
		txtMaLopHP.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String maMH = txtMaLopHP.getText().trim();
				if (maMH.length() == 0) {
					JOptionPane.showMessageDialog(null, "Vui Lòng nhập mã lớp");
				} else {
					timKiemLopHocPhanTheoMaMonHoc(maMH);

				}
				txtMaLopHP.setText("");

			}
		});
		btnTimKiem.setBounds(700, 26, 136, 23);
		add(btnTimKiem);

		JButton btnChonThuMuc = new JButton("Chọn thư mục");
		btnChonThuMuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					txtDuongDan.setText(String.valueOf(chooser.getSelectedFile()));

				} else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy đường dẫn");
				}
			}
		});
		btnChonThuMuc.setBounds(680, 613, 177, 26);
		add(btnChonThuMuc);

		txtDuongDan = new JTextField();
		txtDuongDan.setEditable(false);
		txtDuongDan.setBounds(320, 616, 338, 22);
		add(txtDuongDan);
		txtDuongDan.setColumns(10);

		btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modelcbLHP.getSize() > 0 && txtDuongDan.getText().trim().length() > 0) {
					String lopHP = cbLopHocPhan.getSelectedItem().toString().trim();
					String path = txtDuongDan.getText().toString().trim();
					LopHocPhan lhp = new LopHocPhanDAO().getLopHocPhanTheoMaLopHP(lopHP);
					List<SinhVien> sinhViens = new SinhVienDAO().getSinhVienTheoLhp(lhp.getMaLopHP());

					if (new GhiLopHocPhan().ghiFile(lhp, sinhViens, path)) {
						JOptionPane.showMessageDialog(null,
								"Lưu danh sách sinh viên lớp học phần " + lopHP + " tại " + path);
					} else {
						JOptionPane.showMessageDialog(null, "Lưu không thành công");
					}

				}
			}
		});
		btnLuu.setBounds(154, 609, 132, 33);
		add(btnLuu);
		cbKi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String s = cbKi.getSelectedItem().toString().trim();
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
//				loadTableSinhVienTheoKiNam()
				loadCBLopHocPhan(hocki, namHoc);
//				getAllMonHocTheoChuyenNganh(sv.getMaSinhVien(), namHoc, Integer.parseInt(hocki));
			}
		});
//		loadLHP();
		loadKiHocNamHoc();

	}

//	public void loadLHP() {
//		new LopHocPhanDAO().getLopHocPhanPnDiem().forEach(x->{
//			Vector<String> vt = new Vector<String>();
//			vt.addElement(x);
//			modelcbLHP.addAll(vt);
//		});
//		
//	}
	public void loadDataTableSinhVIen(String s) {
		modelSinhVien.getDataVector().removeAllElements();
		List<SinhVien> list = new SinhVienDAO().getSinhVienTheoLhp(s);
		if (list.size() < 0) {
			tblDanhSachSinhVien.removeAll();
			modelSinhVien.getDataVector().removeAllElements();
			tblDanhSachSinhVien.setModel(modelSinhVien);
		}
		list.forEach(x -> {
			System.out.println(x.getMaSinhVien());
			Vector<String> vt = new Vector<String>();
			vt.addElement(String.valueOf(x.getMaSinhVien()));
			vt.addElement(String.valueOf(x.getTenSinhVien()));
			if (x.isGioiTinh() == false) {
				vt.addElement("Nữ");
			} else {
				vt.addElement("Nam");
			}
			vt.addElement(String.valueOf(x.getNgaySinh()));
			vt.addElement(String.valueOf(new NganhDAO().getTenNganh(x.getNganhEnity().getMaNganh())));
			vt.addElement(String.valueOf(new LopDAO().getTenLop(x.getLopEnity().getMaLop())));
			modelSinhVien.addRow(vt);

		});
		tblDanhSachSinhVien.setModel(modelSinhVien);

	}
//
//	public void loadThongTinALL(String s) {
//		ResultSet rs = new LopHocPhanDAO().ThongTinLopHocPhan_DiemPanel(s);
//		try {
//			while (rs.next()) {
//				lblGIangVien.setText(rs.getString("tenGiangVien"));
//
////				lblMaMH.setText(rs.getString("maMonHoc"));
//				lblTenMonHoc.setText(rs.getString("tenMonHoc"));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//	}

//	public void loadCbLhpTheoKi(String hocki) {
//		modelcbLHP.removeAllElements();
//		new TimKiemFull().timKiemLopHocPhan("", hocki, "").forEach(x -> {
//			Vector<String> vt = new Vector<String>();
//			vt.addElement(x.getMaLopHP());
//			modelcbLHP.addAll(vt);
//			;
//		});
//		cbLopHocPhan.setModel(modelcbLHP);
//	}

	public void timKiemLopHocPhanTheoMaMonHoc(String maLopHocPhan) {
		modelcbLHP.removeAllElements();

		LopHocPhan lhp = new LopHocPhanDAO().getLopHocPhanTheoMaLopHP(maLopHocPhan);
		if (lhp != null) {
			modelcbLHP.addElement(lhp.getMaLopHP());
			cbLopHocPhan.setModel(modelcbLHP);
			cbLopHocPhan.setSelectedIndex(0);
			
			loadDataTableSinhVIen(cbLopHocPhan.getSelectedItem().toString().trim());
			
		}

	}

	public void loadKiHocNamHoc() {
		cbKi.removeAllItems();
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
		modelKi.addAll(vt);
		cbKi.setModel(modelKi);
//		if()

	}

//	public void loadTableSinhVienTheoKiNam(String maLop) {
//		tblDanhSachSinhVien.removeAll();
//		List<SinhVien> list = new DangKiHocPhanKhongCoNhomThucHanhDAO().getALLSinhVienLopHocPhan(maLop);
//		if (list.size() > 0) {
//			list.forEach(x -> {
//				Vector<String> vector = new Vector<String>();
//				vector.addElement(x.getMaSinhVien());
//				vector.addElement(x.getTenSinhVien());
//				if (x.isGioiTinh() == true) {
//					vector.addElement("Nam");
//				}
//				vector.addElement("Nu");
//				vector.addElement(String.valueOf(x.getNgaySinh()));
//				vector.addElement(new NganhDAO().getTenNganh(x.getNganhEnity().getMaNganh()));
//
//				vector.addElement(x.getLopEnity().getMaLop());
//				modelSinhVien.addRow(vector);
//			});
//			tblDanhSachSinhVien.setModel(modelSinhVien);
//		}
//
//	}

	public void loadCBLopHocPhan(String ki, String nam) {
		cbLopHocPhan.removeAllItems();
		List<LopHocPhan> list = new LopHocPhanDAO().getLopHocPhanTheoNamKi(nam, ki);
		if (list.size() > 0) {
			list.forEach(x -> {
				Vector<String> vector = new Vector<String>();
				vector.add(x.getMaLopHP());
				modelcbLHP.addAll(vector);
			});
			cbLopHocPhan.setModel(modelcbLHP);
			if (modelcbLHP.getSize() > 0) {
				cbLopHocPhan.setSelectedIndex(0);
			}

		}

	}
}
