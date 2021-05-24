package UI.QuanLy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
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

import DAO.GiangVienDAO;
import DAO.NganhDAO;
import Entity.GiangVien;
import Entity.Nganh;
import Entity.NguoiQuanLi;
import com.toedter.calendar.JDateChooser;

public class QuanLyGiangVien_Frm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_Giangvien;
	private JTextField txt_Hoten;
	private DefaultTableModel modelGiangVien;
	private JComboBox<String> cb_maNganh;
	private JComboBox<String> cbGioiTinh;
	private DefaultComboBoxModel<String> modeCBnghanh;
	private JDateChooser dateChooser;

	public QuanLyGiangVien_Frm(NguoiQuanLi nql) {
		setLayout(null);
		setSize(1272, 728);

		JLabel lbldssv = new JLabel("Danh sách giảng viên");
		lbldssv.setBounds(10, 27, 167, 22);
		lbldssv.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane_sv = new JScrollPane();
		scrollPane_sv.setBounds(20, 50, 1242, 299);
		add(scrollPane_sv);

		table_Giangvien = new JTable();
		table_Giangvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_Hoten.setText((String) table_Giangvien.getValueAt(table_Giangvien.getSelectedRow(), 1).toString().trim());;
				String gioiTinh = (String) table_Giangvien.getValueAt(table_Giangvien.getSelectedRow(), 2).toString().trim();
				if(gioiTinh.equalsIgnoreCase("Nam")) {
					cbGioiTinh.setSelectedItem("Nam");
				}else {
					cbGioiTinh.setSelectedItem("Nữ");
				}
				
				Date date= Date.valueOf(table_Giangvien.getValueAt(table_Giangvien.getSelectedRow(), 3).toString().trim());
				dateChooser.setDate(date);
				cb_maNganh.setSelectedItem((String) table_Giangvien.getValueAt(table_Giangvien.getSelectedRow(), 4).toString().trim());
//				String tenGiangVien = (String) table_Giangvien.getValueAt(table_Giangvien.getSelectedRow(), 0);
//				String tenGiangVien = (String) table_Giangvien.getValueAt(table_Giangvien.getSelectedRow(), 0);
				
				
			}
		});
		table_Giangvien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modelGiangVien = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã giảng viên", "Họ tên", "Giới tính", "Ngày Sinh", "Ngành" });
		table_Giangvien.setModel(modelGiangVien);

		scrollPane_sv.setViewportView(table_Giangvien);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(20, 378, 1242, 307);
		add(panel);
		panel.setLayout(null);

		txt_Hoten = new JTextField();
		txt_Hoten.setBounds(140, 48, 196, 28);
		panel.add(txt_Hoten);
		txt_Hoten.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_Hoten.setColumns(10);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Dialog", Font.PLAIN, 15));
		cbGioiTinh.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ"}));
		cbGioiTinh.setBounds(559, 46, 136, 33);
		panel.add(cbGioiTinh);

		cb_maNganh = new JComboBox<String>();
		modeCBnghanh= new DefaultComboBoxModel<String>(new String[] {""});
		cb_maNganh.setModel(modeCBnghanh);
		cb_maNganh.setFont(new Font("Dialog", Font.PLAIN, 15));
		cb_maNganh.setBounds(559, 110, 233, 33);
		panel.add(cb_maNganh);

		JLabel lblNewLabel_7 = new JLabel("Ngành");
		lblNewLabel_7.setBounds(425, 114, 143, 20);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_3 = new JLabel("Giới tính");
		lblNewLabel_3.setBounds(425, 51, 101, 22);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btn_Them = new JButton("THÊM");
		btn_Them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String hoTenGiangVien = txt_Hoten.getText().trim();
				String gioiTinh = cbGioiTinh.getSelectedItem().toString().trim();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String ngaySinh= formatter.format(dateChooser.getDate());
//				String ngaySinh  = txt_NgaySinh.getText().trim();
				boolean gt =true;
				if(gioiTinh.equalsIgnoreCase("Nữ")) {
					gt = false;
				}
				
			        Date date = Date.valueOf(ngaySinh);
			
				String maNganh = new NganhDAO().getMaNganhBangTen(cb_maNganh.getSelectedItem().toString().trim());
				
				if(hoTenGiangVien.length()>0) {
					if(new GiangVienDAO().themGiangVien(new GiangVien(hoTenGiangVien,
							gt,date,new Nganh(maNganh),nql))){
								JOptionPane.showMessageDialog(null, "Thêm thành công");
								loadGiangVien();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Không hợp lệ");
				}			
			}
		});
		btn_Them.setBounds(961, 51, 154, 58);
		panel.add(btn_Them);
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btn_Xoa = new JButton("XÓA");
		btn_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(table_Giangvien.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn giảng viên để xóa");
				}else {
					int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa giảng viên "+(String) table_Giangvien.getValueAt(table_Giangvien.getSelectedRow(), 1));
						if(i==0) {
							if(new GiangVienDAO().xoaGiangVien((String) table_Giangvien.getValueAt(table_Giangvien.getSelectedRow(), 0).toString().trim())){
								JOptionPane.showMessageDialog(null, "Xóa thành công giảng viên "+(String) table_Giangvien.getValueAt(table_Giangvien.getSelectedRow(), 0));
								loadGiangVien();
							}
						}
				}
				
			}
		});
		btn_Xoa.setBounds(961, 138, 154, 58);
		panel.add(btn_Xoa);
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				JButton btn_Sua = new JButton("SỬA THÔNG TIN");
				btn_Sua.setBounds(961, 225, 154, 58);
				panel.add(btn_Sua);
				btn_Sua.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
//				String ten= txt_Hoten.getText().to;
						try {
							if(table_Giangvien.getSelectedRow()>0) {
								return;
							}
							String maGiangVien =(String) table_Giangvien.getValueAt(table_Giangvien.getSelectedRow(),0).toString().trim();
							String hoTenGiangVien = txt_Hoten.getText().trim();
							String gioiTinh = cbGioiTinh.getSelectedItem().toString().trim();
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							String ngaySinh= formatter.format(dateChooser.getDate());
							boolean gt =true;
							if(gioiTinh.equalsIgnoreCase("Nữ")) {
								gt = false;
							}
							
						        Date date = Date.valueOf(ngaySinh);
						
							String maNganh = new NganhDAO().getMaNganhBangTen(cb_maNganh.getSelectedItem().toString().trim());
							if(hoTenGiangVien.length()>0) {
								if(new GiangVienDAO().capNhatGiangVien(new GiangVien(maGiangVien,hoTenGiangVien,
										gt,date,new Nganh(maNganh),nql))){
											JOptionPane.showMessageDialog(null, "Cập nhật thành công");
											loadGiangVien();
								}
							}else {
								JOptionPane.showMessageDialog(null, "Không được");
							}
						} catch (Exception e) {
							return;
						}
					}
				});
				btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
						JLabel lblNewLabel_1 = new JLabel("Họ tên");
						lblNewLabel_1.setBounds(10, 51, 101, 22);
						panel.add(lblNewLabel_1);
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						
								JLabel lblNewLabel_2 = new JLabel("Ngày sinh");
								lblNewLabel_2.setBounds(10, 114, 101, 21);
								panel.add(lblNewLabel_2);
								lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
								
							 dateChooser = new JDateChooser();
								dateChooser.setBounds(140, 115, 196, 28);
								panel.add(dateChooser);
		loadGiangVien();
		loadCbNganh();
	}
	public void loadGiangVien() {
		modelGiangVien.getDataVector().removeAllElements();
//		 "Mã giảng viên", "Họ tên", "Giới tính", "Ngày Sinh", "Ngành" 
		new GiangVienDAO().getAllGiangVien().forEach(x->{
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getMaGiangVien());
			vt.addElement(x.getTenGiangVien());
			if(x.isGioiTinh()) {
				vt.addElement("Nam");
			}else {
				vt.addElement("Nữ");
			}
			
			vt.addElement(String.valueOf(x.getNgaySinh()));
			vt.addElement(String.valueOf(new NganhDAO().getTenNganh(x.getNganh().getMaNganh())));
			modelGiangVien.addRow(vt);
			
		});
		
	}
	public void loadCbNganh() {
		modeCBnghanh.removeAllElements();
		Vector<String> vt = new Vector<String>();
		new NganhDAO().getTALL().forEach(x->{
			vt.addElement(x.getTenNganh());
		});
		modeCBnghanh.addAll(vt);

	}
}
