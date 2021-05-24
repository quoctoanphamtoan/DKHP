package UI.QuanLy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.AbstractButton;
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
import javax.swing.table.DefaultTableModel;

import DAO.GiangVienDAO;
import DAO.MonHocDAO;
import DAO.NganhDAO;
import DAO.PhongHocDAO;
import Entity.Nganh;
import Entity.NguoiQuanLi;
import Entity.PhongHoc;

public class QuanLyPhongHoc extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablePhongHoc;
	private DefaultTableModel tableModelPhongHoc;
	private JTextField txtMaPhong;
	private DefaultComboBoxModel<String> day;
	private JComboBox<String> cb_loaiPhong;
	/**
	 * Create the panel.
	 */
	private JComboBox<String> cb_day;

	public QuanLyPhongHoc(NguoiQuanLi nql) {
		setSize(1300, 720);
		setLayout(null);

		JLabel lbldssv = new JLabel("Danh sách môn học");
		lbldssv.setBounds(10, 27, 167, 22);
		lbldssv.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane_sv = new JScrollPane();
		scrollPane_sv.setBounds(23, 71, 1227, 275);
		add(scrollPane_sv);

		tablePhongHoc = new JTable();
		tablePhongHoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		tablePhongHoc.setBackground(new Color(255, 255, 255));
		tableModelPhongHoc = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phòng học", "Tên phòng học", "Dãy", "Loại phòng" });
		tablePhongHoc.setModel(tableModelPhongHoc);

		scrollPane_sv.setViewportView(tablePhongHoc);

		JLabel lblNewLabel_5 = new JLabel("Thêm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(400, 544, 55, -42);
		add(lblNewLabel_5);
		tablePhongHoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMaPhong.setText(tablePhongHoc.getValueAt(tablePhongHoc.getSelectedRow(), 1).toString().trim());
				cb_day.setSelectedItem(tablePhongHoc.getValueAt(tablePhongHoc.getSelectedRow(), 2).toString().trim());
				cb_loaiPhong
						.setSelectedItem(tablePhongHoc.getValueAt(tablePhongHoc.getSelectedRow(), 3).toString().trim());
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 390, 1230, 307);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Dãy");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(54, 133, 113, 23);
		panel.add(lblNewLabel_1);

		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(173, 82, 236, 28);
		panel.add(txtMaPhong);
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaPhong.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Tên phòng học");
		lblNewLabel_4.setBounds(54, 86, 99, 19);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cb_day = new JComboBox<String>();
		day = new DefaultComboBoxModel<String>(new String[] { "" });
		cb_day.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "H" }));
		cb_day.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb_day.setBounds(173, 130, 122, 28);
		panel.add(cb_day);

		cb_loaiPhong = new JComboBox();
		cb_loaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_loaiPhong.setModel(new DefaultComboBoxModel(new String[] { "Thực hành", "Lý thuyết" }));
		cb_loaiPhong.setBounds(647, 82, 158, 26);
		panel.add(cb_loaiPhong);

		JLabel lblNewLabel = new JLabel("Loại phòng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(538, 84, 99, 23);
		panel.add(lblNewLabel);

		JButton btn_Xoa = new JButton("XÓA");
		btn_Xoa.setBounds(962, 192, 161, 58);
		panel.add(btn_Xoa);
		btn_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tablePhongHoc.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng học để xóa");
				} else {
					int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa phòng học này "
							+ (String) tablePhongHoc.getValueAt(tablePhongHoc.getSelectedRow(), 1));
					if (i == 0) {
						if (new PhongHocDAO().xoaPhongHoc((String) tablePhongHoc
								.getValueAt(tablePhongHoc.getSelectedRow(), 0).toString().trim())) {
							JOptionPane.showMessageDialog(null, "Xóa thành công phòng học "
									+ (String) tablePhongHoc.getValueAt(tablePhongHoc.getSelectedRow(), 0));
							loadTablePhongHoc();
							;
						}
					}
				}

			}
		});
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JButton btn_Them = new JButton("THÊM");
		btn_Them.setBounds(962, 66, 161, 58);
		panel.add(btn_Them);
		btn_Them.addActionListener(new ActionListener() {
			private AbstractButton txtTenPhong;

			public void actionPerformed(ActionEvent arg0) {
				String tenPhong = txtTenPhong.getText().trim();
				String day = cb_day.getSelectedItem().toString().trim();
				String loaiPhong = cb_loaiPhong.getSelectedItem().toString().trim();
//				String maQuanLi = "NV";
				if (new PhongHocDAO().themPhongHoc(new PhongHoc(tenPhong, day, loaiPhong, nql))) {
					JOptionPane.showMessageDialog(null, "Thêm thành công ");
					loadTablePhongHoc();
				} else {
					JOptionPane.showMessageDialog(null, "Thêm thất bại ");
				}
			}
		});
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));

		loadTablePhongHoc();
	}

	public void loadTablePhongHoc() {
		tableModelPhongHoc.getDataVector().removeAllElements();
		new PhongHocDAO().getAllPhongHoc().forEach(x -> {
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getMaphongHoc());
			vt.addElement(x.getTenPhongHoc());
			vt.addElement(x.getDay());
			vt.addElement(x.getLoaiPhong());
			tableModelPhongHoc.addRow(vt);
		});
		tablePhongHoc.setModel(tableModelPhongHoc);

	}

}
