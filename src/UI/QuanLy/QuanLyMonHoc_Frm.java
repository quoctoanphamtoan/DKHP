package UI.QuanLy;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.MonHocDAO;
import DAO.NganhDAO;
import Entity.MonHoc;
import Entity.Nganh;
import Entity.NguoiQuanLi;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class QuanLyMonHoc_Frm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton buttonGroup;
	private JTable tableMonHoc;
	private JTextField txtTenMonHoc;
	private JSpinner spinnerTCLithuyet;
	private JSpinner spinnerTCThucHanh;
	private JComboBox<String> cbChuyenNganh;
	private DefaultComboBoxModel<String> modelCbChuyenNganh;
	private JLabel lblMaChuyenNganh;
	private JComboBox<String> cbMonHocTienQuyet;
	private DefaultComboBoxModel<String> modelMonHocTienQuyet;
	private DefaultTableModel tableModelMonHoc;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public QuanLyMonHoc_Frm() {
		setSize(1300, 720);
		setLayout(null);

		JLabel lbldssv = new JLabel("Danh sách môn học");
		lbldssv.setBounds(10, 27, 167, 22);
		lbldssv.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane_sv = new JScrollPane();
		scrollPane_sv.setBounds(23, 71, 1227, 275);
		add(scrollPane_sv);

		tableMonHoc = new JTable();
		tableMonHoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableMonHoc.setBackground(new Color(255, 255, 255));
		tableModelMonHoc = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã môn học", "Tên môn học", "Số tín chỉ", "Môn học tiên quyết" });
		tableMonHoc.setModel(tableModelMonHoc);

		scrollPane_sv.setViewportView(tableMonHoc);

		JLabel lblNewLabel_5 = new JLabel("Thêm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(400, 544, 55, -42);
		add(lblNewLabel_5);

		JButton btn_Them = new JButton("THÊM");
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				String maMonHoc = txtMaMonHoc.getText().trim();
				String tenMonHoc = txtTenMonHoc.getText().trim();
				String tenMonHocTQ = cbMonHocTienQuyet.getSelectedItem().toString().trim();
				int tinChiLT = (int) spinnerTCLithuyet.getValue();
				int tinChiTH = (int) spinnerTCThucHanh.getValue();
				String maChuyenNganh = lblMaChuyenNganh.getText();
//				String maQuanLi = "NV";
				if (new MonHocDAO().themMonHoc(new MonHoc(tenMonHoc, tenMonHocTQ, tinChiLT, tinChiTH,
						new Nganh(maChuyenNganh), new NguoiQuanLi("NV")))) {
					JOptionPane.showMessageDialog(null, "Thêm thành công ");
					loadTableMonHoc();
				} else {
					JOptionPane.showMessageDialog(null, "Thêm thất bại ");
				}

			}
		});
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Them.setBounds(970, 398, 161, 58);
		add(btn_Them);

		JButton btn_Xoa = new JButton("XÓA");
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Xoa.setBounds(970, 498, 161, 58);
		add(btn_Xoa);

		JButton btn_Sua = new JButton("SỬA THÔNG TIN");
		btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sua.setBounds(970, 605, 161, 58);
		add(btn_Sua);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 387, 1230, 307);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Số tín chỉ lí thuyết");
		lblNewLabel_3.setBounds(451, 165, 122, 23);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1 = new JLabel("Môn học tiên quyết");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(451, 117, 136, 23);
		panel.add(lblNewLabel_1);

		txtTenMonHoc = new JTextField();
		txtTenMonHoc.setBounds(597, 61, 236, 28);
		panel.add(txtTenMonHoc);
		txtTenMonHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenMonHoc.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Tên môn học");
		lblNewLabel_4.setBounds(451, 65, 99, 19);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cbMonHocTienQuyet = new JComboBox<String>();
		modelMonHocTienQuyet = new DefaultComboBoxModel<String>(new String[] { "" });
		cbMonHocTienQuyet.setModel(modelMonHocTienQuyet);
		cbMonHocTienQuyet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbMonHocTienQuyet.setBounds(597, 114, 122, 28);
		panel.add(cbMonHocTienQuyet);

		spinnerTCLithuyet = new JSpinner();
		spinnerTCLithuyet.setBounds(597, 168, 30, 20);
		panel.add(spinnerTCLithuyet);

		JLabel lblNewLabel_3_1 = new JLabel("Số tín chỉ thực hành");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(451, 217, 136, 23);
		panel.add(lblNewLabel_3_1);

		spinnerTCThucHanh = new JSpinner();
		spinnerTCThucHanh.setBounds(597, 220, 30, 20);
		panel.add(spinnerTCThucHanh);

		JLabel lblChuynNgnh = new JLabel("Tên ngành");
		lblChuynNgnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChuynNgnh.setBounds(31, 66, 136, 22);
		panel.add(lblChuynNgnh);

		cbChuyenNganh = new JComboBox<String>();
		cbChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbChuyenNganh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String chuyenNghanh = cbChuyenNganh.getSelectedItem().toString();
				String maChuyenNghanh = new NganhDAO().getMaNganhBangTen(chuyenNghanh);
				lblMaChuyenNganh.setText(maChuyenNghanh);
			}
		});
		modelCbChuyenNganh = new DefaultComboBoxModel<String>(new String[] { "" });
		cbChuyenNganh.setModel(modelCbChuyenNganh);
		cbChuyenNganh.setBounds(175, 59, 197, 30);
		panel.add(cbChuyenNganh);

		lblMaChuyenNganh = new JLabel("Ma chuyen nghanh");
		lblMaChuyenNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaChuyenNganh.setBounds(175, 111, 197, 29);
		panel.add(lblMaChuyenNganh);

		JLabel lblNewLabel_2 = new JLabel("Mã ngành");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(31, 114, 84, 22);
		panel.add(lblNewLabel_2);
		loadChuyenNganh();
		loadMonHocTienQuyet();
		loadTableMonHoc();
	}

	public void loadMonHocTienQuyet() {
		new MonHocDAO().getAllMonHoc().forEach(x -> {
			Vector<String> vt = new Vector<String>();
			vt.addElement("");
			vt.addElement(x.getTenMonHoc());
			modelMonHocTienQuyet.addAll(vt);
		});
		cbMonHocTienQuyet.setModel(modelMonHocTienQuyet);

	}

	public void loadChuyenNganh() {
		new NganhDAO().getTALL().forEach(x -> {
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getTenNganh());
			modelCbChuyenNganh.addAll(vt);
		});
		cbChuyenNganh.setModel(modelCbChuyenNganh);

	}

	public void loadTableMonHoc() {
		tableModelMonHoc.getDataVector().removeAllElements();
		new MonHocDAO().getAllMonHoc().forEach(x -> {
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getMaMonHoc());
			vt.addElement(x.getTenMonHoc());
			vt.addElement("Li thuyet: " + x.getSoTCLyThuyet() + "Thuc hanh:" + x.getSoTCThucHanh());
			vt.addElement(x.getMonHocTienQuyet());
			tableModelMonHoc.addRow(vt);
		});
		tableMonHoc.setModel(tableModelMonHoc);

	}

}
