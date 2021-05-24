package UI.QuanLy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.AbstractButton;
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

import DAO.LopDAO;
import DAO.PhongHocDAO;
import Entity.LopHoc;
import Entity.NguoiQuanLi;
import Entity.PhongHoc;

public class QuanLyLopHoc_Frm extends JPanel {

	private JTable tableLopHoc;
	private DefaultTableModel tableModelLopHoc;
	private JTextField txtMaPhong;
	private DefaultComboBoxModel<String> day;
	private JTextField txt_malop;
	private JTextField txtTenLop;

	/**
	 * Create the panel.
	 */
	public QuanLyLopHoc_Frm(NguoiQuanLi nql) {
		setSize(1300, 720);
		setLayout(null);

		JLabel lbldssv = new JLabel("Danh sách lớp học");
		lbldssv.setBounds(10, 27, 167, 22);
		lbldssv.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane_sv = new JScrollPane();
		scrollPane_sv.setBounds(23, 71, 1227, 275);
		add(scrollPane_sv);

		tableLopHoc = new JTable();
		tableLopHoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableLopHoc.setBackground(new Color(255, 255, 255));
		tableModelLopHoc = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã lớp học", "Tên lớp học" });
		tableLopHoc.setModel(tableModelLopHoc);

		scrollPane_sv.setViewportView(tableLopHoc);

		JLabel lblNewLabel_5 = new JLabel("Thêm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(400, 544, 55, -42);
		add(lblNewLabel_5);
		tableLopHoc.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				txt_malop.setText(tableLopHoc.getValueAt(tableLopHoc.getSelectedRow(), 0).toString().trim());
				txtTenLop.setText(tableLopHoc.getValueAt(tableLopHoc.getSelectedRow(), 1).toString().trim());
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 390, 1230, 307);
		add(panel);
		panel.setLayout(null);

		txtTenLop = new JTextField();
		txtTenLop.setBounds(606, 96, 236, 28);
		panel.add(txtTenLop);
		txtTenLop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenLop.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Tên lớp học");
		lblNewLabel_4.setBounds(481, 100, 99, 19);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		day = new DefaultComboBoxModel<String>(new String[] {""});
		
				JButton btn_Xoa = new JButton("XÓA");
				btn_Xoa.setBounds(962, 163, 161, 58);
				panel.add(btn_Xoa);
				btn_Xoa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						if(tableLopHoc.getSelectedRow()<0) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn lớp học để xóa");
						}else {
							int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa lớp học này "+(String) tableLopHoc.getValueAt(tableLopHoc.getSelectedRow(), 1));
								if(i==0) {
									if(new LopDAO().xoaLopHoc((String) tableLopHoc.getValueAt(tableLopHoc.getSelectedRow(), 0).toString().trim())){
										JOptionPane.showMessageDialog(null, "Xóa thành công lớp học "+(String) tableLopHoc.getValueAt(tableLopHoc.getSelectedRow(), 0));
										loadTablePhongHoc();;
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
						String malop= txt_malop.getText().trim();
						String tenLop = txtTenLop.getText().trim();
//				String maQuanLi = "NV";
						if(new LopDAO().themLopHoc(new LopHoc(malop,tenLop, nql))) {
							JOptionPane.showMessageDialog(null, "Thêm thành công ");
							loadTablePhongHoc();
						}else {
							JOptionPane.showMessageDialog(null, "Thêm thất bại ");
						}
					}
				});
				btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				JLabel lblNewLabel = new JLabel("Mã lớp học");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel.setBounds(32, 100, 73, 19);
				panel.add(lblNewLabel);
				
				txt_malop = new JTextField();
				txt_malop.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txt_malop.setBounds(128, 96, 155, 28);
				panel.add(txt_malop);
				txt_malop.setColumns(10);
		
		
		loadTablePhongHoc();
	}
	
	   public void loadTablePhongHoc() {
		tableModelLopHoc.getDataVector().removeAllElements();
		new LopDAO().getAllLopHoc().forEach(x->{
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getMaLop());
			vt.addElement(x.getTenLop());
			tableModelLopHoc.addRow(vt);
		});
		tableLopHoc.setModel(tableModelLopHoc);
		
	}
}
