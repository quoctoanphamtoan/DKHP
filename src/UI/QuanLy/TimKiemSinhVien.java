package UI.QuanLy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.LopDAO;
import DAO.NganhDAO;
import DAO.SinhVienDAO;
import DAO.TimKiemFull;

public class TimKiemSinhVien extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaLoc;
	private JTextField txtTenLoc;
	private JTextField txtNganhLoc;
	private JTable table;
	private DefaultTableModel modelSinhVien;
	private JComboBox<String> cbGioiTinh;

	/**
	 * Create the panel.
	 */
	public TimKiemSinhVien() {
		setSize(1300, 730);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Lọc theo mã");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(138, 58, 93, 19);
		add(lblNewLabel);

		txtMaLoc = new JTextField();
		txtMaLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaLoc.setBounds(250, 57, 120, 33);
		add(txtMaLoc);
		txtMaLoc.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Lọc theo tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(138, 117, 93, 23);
		add(lblNewLabel_1);

		txtTenLoc = new JTextField();
		txtTenLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenLoc.setColumns(10);
		txtTenLoc.setBounds(250, 117, 120, 33);
		add(txtTenLoc);

		JLabel lblNewLabel_2 = new JLabel("Lọc theo ngành");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(537, 66, 140, 24);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Lọc theo giới tính");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(537, 121, 151, 23);
		add(lblNewLabel_3);

		txtNganhLoc = new JTextField();
		txtNganhLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNganhLoc.setColumns(10);
		txtNganhLoc.setBounds(694, 60, 108, 30);
		add(txtNganhLoc);

		JButton btnLoc = new JButton("Lọc");
		btnLoc.setIcon(new ImageIcon("D:\\PhatTrienUD\\DangKiHP\\hinh\\search.png"));
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoc.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String ten = txtTenLoc.getText().trim();
				String ma = txtMaLoc.getText().trim();
				String chuyenNganh = txtNganhLoc.getText().trim();
				if (ten.length() == 0 && ma.length() == 0 && chuyenNganh.length() == 0) {
					GetAll();
				} else {
					locSinhVien(ten, ma, chuyenNganh);
				}
				txtTenLoc.setText("");
				txtMaLoc.setText("");
				txtNganhLoc.setText("");

			}

		});
		btnLoc.setBounds(893, 88, 108, 41);
		add(btnLoc);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 229, 1239, 390);
		add(scrollPane);

		table = new JTable();
		modelSinhVien = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sinh viên", "Họ tên", "Giới tính", "Ngày sinh", "Hệ đào tạo", "Lớp", "Ngành" });
		table.setModel(modelSinhVien);
		scrollPane.setViewportView(table);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbGioiTinh.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Nam", "Ná»¯" }));
		cbGioiTinh.setBounds(698, 117, 81, 33);
		add(cbGioiTinh);
	}

	public void loc(String s) {
		modelSinhVien.getDataVector().removeAllElements();
		String ma = txtMaLoc.getText().trim();

		String gioitinh;
		if (String.valueOf(cbGioiTinh.getSelectedItem()).trim().equalsIgnoreCase("Nam")) {
			gioitinh = "Nam";
		} else {
			gioitinh = "Ná»¯";
		}
		// txtTenLoc.getText().trim(), txtNganhLoc.getText().trim() ,""
		new TimKiemFull().LocGiangVien(s, "", "", "").forEach(x -> {
			Vector<String> vt = new Vector<String>();
			System.out.println(x.getTenGiangVien());
			vt.addElement(x.getMaGiangVien());
			vt.addElement(x.getTenGiangVien());
			String i;
			if (x.isGioiTinh() == true) {
				i = "Nam";

			} else {
				i = "Nữ";
			}
			vt.addElement(i);
			vt.addElement(String.valueOf(x.getNgaySinh()));
			vt.addElement(new NganhDAO().getTenNganh(x.getNganh().getMaNganh()));
			modelSinhVien.addRow(vt);

		});
//			modelSinhVien.getDataVector().removeAllElements();
		table.setModel(modelSinhVien);

	}

	public void locTen(String s) {
		modelSinhVien.getDataVector().removeAllElements();
		String ma = txtMaLoc.getText().trim();

		String gioitinh;
		if (String.valueOf(cbGioiTinh.getSelectedItem()).trim().equalsIgnoreCase("Nam")) {
			gioitinh = "Nam";
		} else {
			gioitinh = "Nữ";
		}
		// txtTenLoc.getText().trim(), txtNganhLoc.getText().trim() ,""
		new TimKiemFull().LocGiangVien("", s, "", "").forEach(x -> {
			Vector<String> vt = new Vector<String>();
			System.out.println(x.getTenGiangVien());
			vt.addElement(x.getMaGiangVien());
			vt.addElement(x.getTenGiangVien());
			String i;
			if (x.isGioiTinh() == true) {
				i = "Nam";

			} else {
				i = "Nữ";
			}
			vt.addElement(i);
			vt.addElement(String.valueOf(x.getNgaySinh()));
			vt.addElement(new NganhDAO().getTenNganh(x.getNganh().getMaNganh()));
			modelSinhVien.addRow(vt);

		});
//			modelSinhVien.getDataVector().removeAllElements();
		table.setModel(modelSinhVien);

	}

	public void locNganh(String s) {
		modelSinhVien.getDataVector().removeAllElements();
		String ma = txtMaLoc.getText().trim();

		String gioitinh;
		if (String.valueOf(cbGioiTinh.getSelectedItem()).trim().equalsIgnoreCase("Nam")) {
			gioitinh = "Nam";
		} else {
			gioitinh = "Nữ";
		}
		// txtTenLoc.getText().trim(), txtNganhLoc.getText().trim() ,""
		new TimKiemFull().LocGiangVien("", "", s, "").forEach(x -> {
			Vector<String> vt = new Vector<String>();
			System.out.println(x.getTenGiangVien());
			vt.addElement(x.getMaGiangVien());
			vt.addElement(x.getTenGiangVien());
			String i;
			if (x.isGioiTinh() == true) {
				i = "Nam";

			} else {
				i = "Nữ";
			}
			vt.addElement(i);
			vt.addElement(String.valueOf(x.getNgaySinh()));
			vt.addElement(new NganhDAO().getTenNganh(x.getNganh().getMaNganh()));
			modelSinhVien.addRow(vt);

		});
//			modelSinhVien.getDataVector().removeAllElements();
		table.setModel(modelSinhVien);

	}

	// "MÃ£ sinh viÃªn", "Há»� tÃªn", "Giá»›i tÃ­nh", "NgÃ y sinh", "Há»‡ Ä‘Ã o
	// táº¡o","Lá»›p","NgÃ nh"
	public void locSinhVien(String ten, String ma, String chuyenNganh) {
		modelSinhVien.getDataVector().removeAllElements();
		if (ma.equalsIgnoreCase("") && chuyenNganh.equalsIgnoreCase("")) {
			new TimKiemFull().LocSinhVienTheoTen(ten).forEach(x -> {
				Vector<String> vt = new Vector<String>();
				vt.addElement(x.getMaSinhVien());
				vt.addElement(x.getTenSinhVien());
				vt.addElement(String.valueOf(x.isGioiTinh()));
				vt.addElement(String.valueOf(x.getNgaySinh()));
				vt.addElement(x.getHeDaoTao());
				vt.addElement(new LopDAO().getTenLop(x.getLopEnity().getMaLop()));
				vt.addElement(new NganhDAO().getTenNganh(x.getNganhEnity().getMaNganh()));
				modelSinhVien.addRow(vt);
			});
		} else if (ten.equalsIgnoreCase("") && chuyenNganh.equalsIgnoreCase("")) {
			new TimKiemFull().LocSinhVienTheoMa(ma).forEach(x -> {
				Vector<String> vt = new Vector<String>();
				vt.addElement(x.getMaSinhVien());
				vt.addElement(x.getTenSinhVien());
				vt.addElement(String.valueOf(x.isGioiTinh()));
				vt.addElement(String.valueOf(x.getNgaySinh()));
				vt.addElement(x.getHeDaoTao());
				vt.addElement(new LopDAO().getTenLop(x.getLopEnity().getMaLop()));
				vt.addElement(new NganhDAO().getTenNganh(x.getNganhEnity().getMaNganh()));
				modelSinhVien.addRow(vt);
			});
		} else if (ten.equalsIgnoreCase("") && ma.equalsIgnoreCase("")) {
			new TimKiemFull().LocSinhVienTheoChuyenNganh(chuyenNganh).forEach(x -> {
				Vector<String> vt = new Vector<String>();
				vt.addElement(x.getMaSinhVien());
				vt.addElement(x.getTenSinhVien());
				vt.addElement(String.valueOf(x.isGioiTinh()));
				vt.addElement(String.valueOf(x.getNgaySinh()));
				vt.addElement(x.getHeDaoTao());
				vt.addElement(new LopDAO().getTenLop(x.getLopEnity().getMaLop()));
				vt.addElement(new NganhDAO().getTenNganh(x.getNganhEnity().getMaNganh()));
				modelSinhVien.addRow(vt);
			});
		}

		table.setModel(modelSinhVien);
	}

	private void GetAll() {
		modelSinhVien.getDataVector().removeAllElements();
		new SinhVienDAO().getSinhVienALL().forEach(x->{
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getMaSinhVien());
			vt.addElement(x.getTenSinhVien());
			vt.addElement(String.valueOf(x.isGioiTinh()));
			vt.addElement(String.valueOf(x.getNgaySinh()));
			vt.addElement(x.getHeDaoTao());
			vt.addElement(new LopDAO().getTenLop(x.getLopEnity().getMaLop()));
			vt.addElement(new NganhDAO().getTenNganh(x.getNganhEnity().getMaNganh()));
			modelSinhVien.addRow(vt);
		});
		table.setModel(modelSinhVien);

	}
}
