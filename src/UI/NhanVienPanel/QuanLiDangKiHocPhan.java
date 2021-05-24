package UI.NhanVienPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.GiangVienDAO;
import DAO.LopHocPhanDAO;
import DAO.MonHocDAO;
import DAO.NganhDAO;
import DAO.PhongHocDAO;
import Entity.GiangVien;
import Entity.LopHocPhan;
import Entity.MonHoc;
import Entity.NhanVienPhongDaoTao;
import Entity.PhongHoc;

public class QuanLiDangKiHocPhan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel modelLopHocPhan;
	private JTextField txtNamHoc;
	private JComboBox<String> cbMonHoc;
	private DefaultComboBoxModel<String> modelCbMon;
	private JComboBox<String> cbChuyenNganh;
	private DefaultComboBoxModel<String> modelCbChuyenNganh;
	private JComboBox<String> cbGiangVienLiThuyet;
	private DefaultComboBoxModel<String> modelCbGiangVienLiThuyet;
	private JLabel lblMaChuyenNganh;
	private JLabel lbltinChiLiThuyet;
	private JLabel lblTinChiThuchanh;
	private JSpinner spinnerNhomThucHanh;
	private JComboBox<String> cbPhongHoc;
	private JComboBox<String> cbDayPhong;
	private DefaultComboBoxModel<String> modelcbDayPhong;
	private DefaultComboBoxModel<String> modelCbPhongHoc;
	private JComboBox<String> cbTiet;
	private JComboBox<String> cbThu;
	private JTextField txtSiSo;
	private JButton btnTaoNhomThucHanh;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox<Integer> cbhocki;
	private JDateChooser dateNgayKetThuc;
	private JDateChooser dateNgayBatDau;
	private JButton btnCapNhat;
	private JButton btnHuyLopHP;

	/**
	 * Create the frame.
	 */
	public QuanLiDangKiHocPhan() {
		setSize(1300, 720);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1280, 213);
		add(scrollPane);

		table = new JTable();
//		"Mã lớp học phần", "Môn học", "Học kì", "Thứ", "Năm học", "Giảng viên", "Sỉ số",
//		"Phòng học", "Tiết học", "Ngày bắt đầu", "Ngày kết thúc", "số nhóm thực hành" 
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lamMoi();
				btnCapNhat.setEnabled(true);
				cbChuyenNganh.setEnabled(false);
				cbMonHoc.setEnabled(false);
				btnHuyLopHP.setEnabled(true);

				String TenGiangVien = (String) table.getValueAt(table.getSelectedRow(), 5).toString().trim();
				String tiethoc = (String) table.getValueAt(table.getSelectedRow(), 8).toString().trim();
				String thu = (String) table.getValueAt(table.getSelectedRow(), 3).toString().trim();
				String phonghoc = (String) table.getValueAt(table.getSelectedRow(), 7).toString().trim();
				int soNhomThucHanh = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 11));
				if (soNhomThucHanh > 0) {
					spinnerNhomThucHanh.setValue(soNhomThucHanh);
					spinnerNhomThucHanh.setEnabled(true);
					btnTaoNhomThucHanh.setEnabled(true);
				}

			}
		});
		modelLopHocPhan = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã lớp học phần", "Môn học", "Học kì", "Thứ", "Năm học", "Giảng viên", "Sỉ số",
						"Phòng học", "Tiết học", "Ngày bắt đầu", "Ngày kết thúc", "số nhóm thực hành" });
		table.setModel(modelLopHocPhan);
		scrollPane.setViewportView(table);

		JLabel lblHcK = new JLabel("Học kì");
		lblHcK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHcK.setBounds(951, 251, 76, 28);
		add(lblHcK);

		JLabel lblNmHc = new JLabel("Năm học");
		lblNmHc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmHc.setBounds(951, 302, 76, 36);
		add(lblNmHc);

		JLabel lblMnHc = new JLabel("Tên môn học");
		lblMnHc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMnHc.setBounds(33, 348, 119, 36);
		add(lblMnHc);

//		Date day = new 
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int namhienTai = gregorianCalendar.get(Calendar.YEAR);
		int namTiep = namhienTai + 1;
		txtNamHoc = new JTextField("" + namhienTai + "/" + namTiep);
		txtNamHoc.setEditable(false);
		txtNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNamHoc.setColumns(10);
		txtNamHoc.setBounds(1069, 307, 105, 28);
		add(txtNamHoc);
		cbChuyenNganh = new JComboBox<String>();
		cbChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));

		modelCbChuyenNganh = new DefaultComboBoxModel<String>(new String[] { "" });
		cbChuyenNganh.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));
		cbChuyenNganh.setBounds(181, 251, 234, 28);
		add(cbChuyenNganh);
		cbChuyenNganh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String maChuyenNganh = new NganhDAO().getMaNganhBangTen(cbChuyenNganh.getSelectedItem().toString())
						.trim();
				cbMonHoc.removeAllItems();

				cbGiangVienLiThuyet.removeAllItems();
				lblMaChuyenNganh.setText(maChuyenNganh);
				loadCbGiangvien(maChuyenNganh);
				loadCbMonHoc(maChuyenNganh);

			}
		});
		cbMonHoc = new JComboBox<String>();
		cbMonHoc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					String tin = new MonHocDAO().getMaMonHoc(cbMonHoc.getSelectedItem().toString().trim());
					lbltinChiLiThuyet.setText(String.valueOf(new MonHocDAO().getTinChiLithuyet(tin)));
					String tinTH = new MonHocDAO().getMaMonHoc(cbMonHoc.getSelectedItem().toString().trim());
					lblTinChiThuchanh.setText(String.valueOf(new MonHocDAO().getTinChiThucHanh(tinTH)));
					if (new MonHocDAO().getTinChiThucHanh(tinTH) > 0) {
						spinnerNhomThucHanh.setEnabled(true);
					} else {
						spinnerNhomThucHanh.setEnabled(false);
					}
				} catch (Exception e) {
					lblTinChiThuchanh.setText("");
					lbltinChiLiThuyet.setText("");
					spinnerNhomThucHanh.setEnabled(false);
				}
			}
		});
		cbMonHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modelCbMon = new DefaultComboBoxModel<String>(new String[] { "" });
		cbMonHoc.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));

		cbMonHoc.setBounds(181, 353, 234, 27);
		add(cbMonHoc);

		JLabel lblNewLabel_1_1_1 = new JLabel("Giảng viên lý thuyết");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(33, 507, 139, 36);
		add(lblNewLabel_1_1_1);

		cbGiangVienLiThuyet = new JComboBox<String>();
		cbGiangVienLiThuyet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbGiangVienLiThuyet.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		modelCbGiangVienLiThuyet = new DefaultComboBoxModel<String>(new String[] { "" });
		cbGiangVienLiThuyet.setModel(modelCbGiangVienLiThuyet);
		cbGiangVienLiThuyet.setBounds(181, 512, 234, 27);
		add(cbGiangVienLiThuyet);

		JLabel lblNewLabel_1_1_2 = new JLabel("Tín chỉ lý thuyết");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(234, 394, 119, 36);
		add(lblNewLabel_1_1_2);

		lbltinChiLiThuyet = new JLabel("0");
		lbltinChiLiThuyet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltinChiLiThuyet.setBounds(380, 394, 119, 36);
		add(lbltinChiLiThuyet);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Tín chỉ thực hành");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(33, 394, 119, 36);
		add(lblNewLabel_1_1_2_1);

		lblTinChiThuchanh = new JLabel("0");
		lblTinChiThuchanh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Integer.parseInt(lblTinChiThuchanh.getText().trim()) > 0) {

				}
			}
		});

		lblTinChiThuchanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTinChiThuchanh.setBounds(194, 399, 64, 27);
		add(lblTinChiThuchanh);

		spinnerNhomThucHanh = new JSpinner();
		spinnerNhomThucHanh.setEnabled(false);
		spinnerNhomThucHanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerNhomThucHanh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
//				btnTaoNhomThucHanh.setEnabled(true);
			}
		});
		spinnerNhomThucHanh.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerNhomThucHanh.setBounds(182, 450, 30, 20);
		add(spinnerNhomThucHanh);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Số nhóm thực hành");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1_1.setBounds(33, 442, 139, 36);
		add(lblNewLabel_1_1_2_1_1);

		btnTaoNhomThucHanh = new JButton("Nhóm thực hành");
		btnTaoNhomThucHanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTaoNhomThucHanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String maLopHP = (String) table.getValueAt(table.getSelectedRow(), 0);
				int soNhom = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 11));
				int siSo = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 6));
				String monHoc = (String) table.getValueAt(table.getSelectedRow(), 1);
				new TaoNhomThucHanh_JFrame(soNhom, maLopHP, siSo, new MonHocDAO().getMaChuyenNganhBangTenMonHoc(monHoc))
						.setVisible(true);

			}
		});
		btnTaoNhomThucHanh.setEnabled(false);
		btnTaoNhomThucHanh.setBounds(775, 612, 204, 50);
		add(btnTaoNhomThucHanh);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Dãy học");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(524, 399, 71, 27);
		add(lblNewLabel_1_1_1_1);

		JLabel lblChuynNgnh = new JLabel("Mã ngành");
		lblChuynNgnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChuynNgnh.setBounds(33, 302, 86, 36);
		add(lblChuynNgnh);

		lblMaChuyenNganh = new JLabel("");
		lblMaChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaChuyenNganh.setBounds(181, 302, 119, 28);
		add(lblMaChuyenNganh);

		cbPhongHoc = new JComboBox<String>();
		cbPhongHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modelCbPhongHoc = new DefaultComboBoxModel<String>(new String[] { "" });
		cbPhongHoc.setModel(modelCbPhongHoc);
		cbPhongHoc.setBounds(653, 446, 124, 28);
		add(cbPhongHoc);
//		loadCbChuyenNganh();
		cbDayPhong = new JComboBox<String>();
		cbDayPhong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbDayPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				loadTenPhongPhong(cbDayPhong.getSelectedItem().toString().trim());
			}
		});
		modelcbDayPhong = new DefaultComboBoxModel<String>(new String[] { "" });
		cbDayPhong.setModel(new DefaultComboBoxModel<String>(new String[] { "A", "B", "D", "F", "X", "V", "H" }));
		cbDayPhong.setBounds(653, 398, 54, 28);
		add(cbDayPhong);

		JButton btnTaoLopHocPhan = new JButton("THÊM LỚP HỌC PHẦN");
		btnTaoLopHocPhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTaoLopHocPhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemLopHocPhan();
			}

		});
		btnTaoLopHocPhan.setBounds(292, 612, 190, 50);
		loadCbChuyenNganh();

		add(btnTaoLopHocPhan);

		JLabel lblTitHc = new JLabel("Tiết học lý thuyết");
		lblTitHc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitHc.setBounds(524, 348, 119, 36);
		add(lblTitHc);

		cbTiet = new JComboBox<String>();
		cbTiet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbTiet.setModel(new DefaultComboBoxModel<String>(new String[] { "1-3", "4-6", "7-9", "10-12", "13-15" }));
		cbTiet.setBounds(653, 352, 71, 28);
		add(cbTiet);

		JLabel lblTh = new JLabel("Thứ");
		lblTh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTh.setBounds(524, 302, 58, 28);
		add(lblTh);

		cbThu = new JComboBox<String>();
		cbThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbThu.setModel(new DefaultComboBoxModel<String>(new String[] { "2", "3", "4", "5", "6", "7", "Chủ nhật" }));
		cbThu.setBounds(625, 302, 51, 28);
		add(cbThu);

		JLabel lblNewLabel_1 = new JLabel("Sỉ số");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(524, 252, 46, 14);
		add(lblNewLabel_1);

		txtSiSo = new JTextField();
		txtSiSo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSiSo.setBounds(625, 246, 54, 28);
		add(txtSiSo);
		txtSiSo.setColumns(10);

		lblNewLabel_2 = new JLabel("Tên ngành");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(33, 257, 105, 20);
		add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Phòng học");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(524, 450, 76, 20);
		add(lblNewLabel_3);

		cbhocki = new JComboBox<Integer>();
		cbhocki.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 1, 2, 3 }));

		cbhocki.setBounds(1069, 254, 88, 27);
		add(cbhocki);

		JLabel lblNewLabel = new JLabel("Ngày bắt đầu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(524, 493, 97, 23);
		add(lblNewLabel);

		dateNgayBatDau = new JDateChooser();
		dateNgayBatDau.setBounds(651, 493, 250, 28);
		add(dateNgayBatDau);

		JLabel lblNewLabel_4 = new JLabel("Ngày kết thúc");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(524, 534, 97, 20);
		add(lblNewLabel_4);
		dateNgayKetThuc = new JDateChooser();
		dateNgayKetThuc.setBounds(653, 531, 250, 27);
		add(dateNgayKetThuc);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lamMoi();
			}
		});
		btnLamMoi.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnLamMoi.setBounds(524, 612, 190, 50);
		add(btnLamMoi);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tenMonHoc = (String) table.getValueAt(table.getSelectedRow(), 1).toString().trim();
				String maLopHP = (String) table.getValueAt(table.getSelectedRow(), 0).toString().trim();
				String maChuyenNganh = new MonHocDAO().getMaChuyenNganhBangTenMonHoc(tenMonHoc);
				new ChinhSuaLopHocPhan(maChuyenNganh, maLopHP).setVisible(true);
				LoadTableLopHocPhan();
			}
		});
		btnCapNhat.setEnabled(false);
		btnCapNhat.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnCapNhat.setBounds(1040, 612, 190, 50);
		add(btnCapNhat);

		btnHuyLopHP = new JButton("Hũy LỚP HỌC PHẦN");
		btnHuyLopHP.setEnabled(false);
		btnHuyLopHP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String maLopHocPhan = (String) table.getValueAt(table.getSelectedRow(), 0).toString().trim();
//				int
				int ss = new LopHocPhanDAO().getSiSoLopHocPhanDangKi(maLopHocPhan);
				int i = JOptionPane.showConfirmDialog(null, "Bạn có hũy lớp học phần " + maLopHocPhan
						+ " Lớp học phần hiện tại có " + ss + " sinh viên đăng kí");
				if (i == 0) {
					if (new LopHocPhanDAO().HuyLopHocPhan(maLopHocPhan)) {
						JOptionPane.showMessageDialog(null, "Hũy lớp học phần thành công");
						LoadTableLopHocPhan();
					} else {
						JOptionPane.showMessageDialog(null, "Hũy lớp học phần không thành công");
					}
				}

			}
		});
		btnHuyLopHP.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnHuyLopHP.setBounds(67, 612, 190, 50);
		add(btnHuyLopHP);
		LoadTableLopHocPhan();
		loadTenPhongPhong("A");

	}

	public void LoadTableLopHocPhan() {
		ResultSet rs = new LopHocPhanDAO().getLopHocPhan();
		modelLopHocPhan.getDataVector().removeAllElements();
		try {
			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.addElement(String.valueOf(rs.getString(1)));
				vector.addElement(String.valueOf(new MonHocDAO().getTenMonHoc(rs.getString(2))));
				vector.addElement(String.valueOf(rs.getString(3)));
				vector.addElement(String.valueOf(rs.getString(4)));
				vector.addElement(String.valueOf(rs.getString(5)));
				vector.addElement(String.valueOf(new GiangVienDAO().getTenGiangVien(rs.getString(6))));
				vector.addElement(String.valueOf(rs.getString(7)));
				vector.addElement(String.valueOf(rs.getString(8)));
				vector.addElement(String.valueOf(rs.getString(9)));
				vector.addElement(String.valueOf(rs.getString(10)));
				vector.addElement(String.valueOf(rs.getString(11)));
				vector.addElement(String.valueOf(rs.getString(12)));
				modelLopHocPhan.addRow(vector);

			}
			table.setModel(modelLopHocPhan);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadCbLopHocPhan() {
	}

	public void loadCbGiangvien(String maChuyenNganh) {
		modelCbGiangVienLiThuyet.removeAllElements();
		Vector<String> vt = new Vector<String>();
		new GiangVienDAO().getGiangVienTheoChuyenNganh(maChuyenNganh).forEach(x -> {

			vt.addElement(x.getTenGiangVien());

		});

		modelCbGiangVienLiThuyet.addAll(vt);
		cbGiangVienLiThuyet.setModel(modelCbGiangVienLiThuyet);

	}

	public void loadCbGiangvienALL() {
		modelCbGiangVienLiThuyet.removeAllElements();
		Vector<String> vt = new Vector<String>();
		new GiangVienDAO().getAllGiangVien().forEach(x -> {
			vt.addElement(x.getTenGiangVien());

		});

		modelCbGiangVienLiThuyet.addAll(vt);
		cbGiangVienLiThuyet.setModel(modelCbGiangVienLiThuyet);

	}

	public void loadCbMonHoc(String maChuyenNganh) {
		modelCbMon.removeAllElements();
		Vector<String> vt = new Vector<String>();
		new MonHocDAO().getMonHocTheoChuyenNghanh(maChuyenNganh).forEach(x -> {
			vt.addElement(x.getTenMonHoc());

		});
		modelCbMon.addAll(vt);
		cbMonHoc.setModel(modelCbMon);

	}

	public void loadCbChuyenNganh() {
		modelCbChuyenNganh.removeAllElements();

		Vector<String> vt = new Vector<String>();
		new NganhDAO().getTALL().forEach(x -> {
			vt.addElement(x.getTenNganh());

		});
		modelCbChuyenNganh.addAll(vt);
		cbChuyenNganh.setModel(modelCbChuyenNganh);
	}

	public void loadTenPhongPhong(String tenDay) {
		modelCbPhongHoc.removeAllElements();
		Vector<String> vt = new Vector<String>();
		new PhongHocDAO().getPhongHocTheoDay(tenDay).forEach(x -> {
			vt.addElement(x.getTenPhongHoc());
		});
		modelCbPhongHoc.addAll(vt);
		cbPhongHoc.setModel(modelCbPhongHoc);
//		cbPhongHoc.setSelectedIndex(0);
	}

	public void loadTenPhongALL() {
		modelCbPhongHoc.removeAllElements();
		Vector<String> vt = new Vector<String>();
		new PhongHocDAO().getPhongHocTheoDayALL().forEach(x -> {
			vt.addElement(x.getTenPhongHoc());
		});
		modelCbPhongHoc.addAll(vt);
		cbPhongHoc.setModel(modelCbPhongHoc);
	}

	private void ThemLopHocPhan() {
		String maLop = new LopHocPhanDAO().getMaLopHocPhan();
		try {
			int hocky = Integer.parseInt(cbhocki.getSelectedItem().toString().trim());
			String namHoc = txtNamHoc.getText().trim();
			String monHoc = cbMonHoc.getSelectedItem().toString().trim();
			int soNhomThucHanh = Integer.parseInt(spinnerNhomThucHanh.getValue().toString().trim());
			Date ngayBatDau = new Date(dateNgayBatDau.getDate().getTime());
			Date ngayKetThuc = new Date(dateNgayKetThuc.getDate().getTime());
			
			//////////KiemTra ngay//////
			Date today = new Date(System.currentTimeMillis());
			if(ngayBatDau.compareTo(today)<0) {
				JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải lớn hơn ngày hiện tại");
				return;
				
			}
			long tempketThucLong = new Date(today.getYear(), today.getMonth() + 5, today.getDay() + 1).getTime();
			if(ngayKetThuc.getTime()<tempketThucLong) {
				JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu ít nhất 5 tháng");
				return;
			}
			//////////////////////////
			
			
			
			String tietHoc = cbTiet.getSelectedItem().toString().trim();
			String thu = cbThu.getSelectedItem().toString().trim();
			int siSo = Integer.parseInt(txtSiSo.getText().trim());
			String maPhongHoc = cbPhongHoc.getSelectedItem().toString().trim();
			String magiangvien = cbGiangVienLiThuyet.getSelectedItem().toString().trim();
			String maNhanVienPhongDaoTao = "NV001";
			if (siSo < 30) {
				JOptionPane.showMessageDialog(null, "Sỉ số thấp nhất là 30");
				return;
			}
			LopHocPhan lopHocPhan = new LopHocPhan(maLop, hocky, namHoc,
					new MonHoc(new MonHocDAO().getMaMonHoc(monHoc)), null, tietHoc, thu, siSo, ngayBatDau, ngayKetThuc,
					soNhomThucHanh, new PhongHoc(new PhongHocDAO().getMaPhongHocTheoTen(maPhongHoc)),
					new GiangVien(new GiangVienDAO().getMaGiangVien(magiangvien)),
					new NhanVienPhongDaoTao(maNhanVienPhongDaoTao));
//			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//	        String strDate = formatter.format(date);
//			JOptionPane.showMessageDialog(null, strDate);
			if (new LopHocPhanDAO().kiemTraTrungTietThuGiangVien(tietHoc, thu,
					new GiangVienDAO().getMaGiangVien(magiangvien))) {
				if (new LopHocPhanDAO().kiemTraTrungTietThuPhong(tietHoc, thu,
						new PhongHocDAO().getMaPhongHocTheoTen(maPhongHoc))) {
					if (spinnerNhomThucHanh.isEnabled() && soNhomThucHanh == 0) {
						JOptionPane.showMessageDialog(null,
								"Môn học có thực hành xin vui lòng chọn 1 - 3 nhóm thực hành ");

					} else {
						if (new LopHocPhanDAO().themLHP(lopHocPhan)) {
							LoadTableLopHocPhan();
							JOptionPane.showMessageDialog(null, "Thêm thành công");

							spinnerNhomThucHanh.setEnabled(false);

							if (soNhomThucHanh > 0) {
								int i = JOptionPane.showConfirmDialog(null,
										"Bạn có muốn tạo nhóm thực hành hay để sau");
								if (i == 0) {
									String maChuyenNganh = new NganhDAO()
											.getMaNganhBangTen(cbChuyenNganh.getSelectedItem().toString()).trim();
									new TaoNhomThucHanh_JFrame(soNhomThucHanh, maLop, siSo, maChuyenNganh)
											.setVisible(true);
								}
							}

						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tiết " + tietHoc + " Thứ " + thu + " Phòng " + maPhongHoc
							+ " đã có lớp học phần, xin chọn lại");

				}
			} else {
				JOptionPane.showMessageDialog(null, "Tiết " + tietHoc + " Thứ " + thu + " Giang vien " + magiangvien
						+ " đã có lớp học phần, xin chọn lại");

			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Xin kiểm tra lại thông tin");
		}

	}

	public void lamMoi() {
//		LoadTableLopHocPhan();
		cbChuyenNganh.setSelectedIndex(1);
		cbChuyenNganh.setEnabled(true);
		btnHuyLopHP.setEnabled(false);
		cbPhongHoc.setSelectedIndex(0);
		cbMonHoc.setEnabled(true);
		btnCapNhat.setEnabled(false);
		btnTaoNhomThucHanh.setEnabled(false);
		lbltinChiLiThuyet.setText("");
		lblTinChiThuchanh.setText("");
		spinnerNhomThucHanh.setValue(0);
		spinnerNhomThucHanh.setEnabled(false);

	}
}