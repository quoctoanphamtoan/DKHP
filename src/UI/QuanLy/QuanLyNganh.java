package UI.QuanLy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.NganhDAO;
import Entity.Nganh;
import Entity.NguoiQuanLi;

public class QuanLyNganh extends JPanel {

	private JTable tableNganh;
	private DefaultTableModel tableModelNganh;
	private JTextField txt_manganh;
	private JTextField txt_tenNganh;

	/**
	 * Create the panel.
	 */
	public QuanLyNganh(NguoiQuanLi nql) {
		setSize(1300, 720);
		setLayout(null);

		JLabel lbldssv = new JLabel("Danh sách ngành");
		lbldssv.setBounds(10, 27, 167, 22);
		lbldssv.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane_sv = new JScrollPane();
		scrollPane_sv.setBounds(23, 71, 1227, 275);
		add(scrollPane_sv);

		tableNganh = new JTable();
		tableNganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableNganh.setBackground(new Color(255, 255, 255));
		tableModelNganh = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã ngành", "Tên ngành" });
		tableNganh.setModel(tableModelNganh);

		scrollPane_sv.setViewportView(tableNganh);

		JLabel lblNewLabel_5 = new JLabel("Thêm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(400, 544, 55, -42);
		add(lblNewLabel_5);
		tableNganh.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				txt_manganh.setText(tableNganh.getValueAt(tableNganh.getSelectedRow(), 0).toString().trim());
				txt_tenNganh.setText(tableNganh.getValueAt(tableNganh.getSelectedRow(), 1).toString().trim());
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 390, 1230, 307);
		add(panel);
		panel.setLayout(null);

		txt_tenNganh = new JTextField();
		txt_tenNganh.setBounds(606, 96, 236, 28);
		panel.add(txt_tenNganh);
		txt_tenNganh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_tenNganh.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Tên ngành");
		lblNewLabel_4.setBounds(481, 100, 99, 19);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
				JButton btn_Xoa = new JButton("XÓA");
				btn_Xoa.setBounds(962, 163, 161, 58);
				panel.add(btn_Xoa);
				btn_Xoa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						if(tableNganh.getSelectedRow()<0) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn chuyên ngành để xóa");
						}else {
							int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa chuyên ngành này "+(String) tableNganh.getValueAt(tableNganh.getSelectedRow(), 1));
								if(i==0) {
									if(new NganhDAO().xoaNganh((String) tableNganh.getValueAt(tableNganh.getSelectedRow(), 0).toString().trim())){
										JOptionPane.showMessageDialog(null, "Xóa thành công chuyên ngành "+(String) tableNganh.getValueAt(tableNganh.getSelectedRow(), 0));
										loadTablePhongHoc();;
									}else {
										JOptionPane.showMessageDialog(null, "Không thể xóa ngành này");
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

					public void actionPerformed(ActionEvent arg0) {
						String maNganh= txt_manganh.getText().trim();
						String tenNganh= txt_tenNganh.getText().trim();
//				String maQuanLi = "NV";
						if(new NganhDAO().themNganh((new Nganh(maNganh, tenNganh)))){
							JOptionPane.showMessageDialog(null, "Thêm thành công ");
							loadTablePhongHoc();
						}else {
							JOptionPane.showMessageDialog(null, "Thêm thất bại ");
						}
					}
				});
				btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				JLabel lblNewLabel = new JLabel("Mã ngành");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel.setBounds(32, 100, 73, 19);
				panel.add(lblNewLabel);
				
				txt_manganh = new JTextField();
				txt_manganh.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txt_manganh.setBounds(128, 96, 155, 28);
				panel.add(txt_manganh);
				txt_manganh.setColumns(10);
		
		
		loadTablePhongHoc();
	}
	
	   public void loadTablePhongHoc() {
		tableModelNganh.getDataVector().removeAllElements();
		new NganhDAO().getTALL().forEach(x->{
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getMaNganh());
			vt.addElement(x.getTenNganh());
			tableModelNganh.addRow(vt);
		});
		tableNganh.setModel(tableModelNganh);
		
	}
}
