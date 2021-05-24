package UI.QuanLy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import DAO.NhanVienPDTDAO;
import DAO.TaiKhoanDAO;
import Entity.NguoiQuanLi;
import Entity.NhanVienPhongDaoTao;
import Entity.TaiKhoan;

import com.toedter.calendar.JDateChooser;

public class QuanLyNhanVien extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_Nhanvien;
	private JTextField txt_Hoten;
	private DefaultTableModel model_Nhanvien;
	private JComboBox<String> cbGioiTinh;
	private JTextField txt_diachi;
	private JDateChooser    dateChooser;
	private JTextField txt_ma;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Create the panel.
	 */
	public QuanLyNhanVien(NguoiQuanLi nql) {
		setLayout(null);
		setSize(1272, 728);

		JLabel lbldssv = new JLabel("Danh sách nhân viên phòng đào tạo");
		lbldssv.setBounds(10, 27, 167, 22);
		lbldssv.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane_sv = new JScrollPane();
		scrollPane_sv.setBounds(20, 50, 1242, 299);
		add(scrollPane_sv);

		table_Nhanvien = new JTable();
		table_Nhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_ma.setText(table_Nhanvien.getValueAt(table_Nhanvien.getSelectedRow(), 0).toString());
				txt_Hoten.setText((String) table_Nhanvien.getValueAt(table_Nhanvien.getSelectedRow(), 1).toString().trim());;
				String gioiTinh = (String) table_Nhanvien.getValueAt(table_Nhanvien.getSelectedRow(), 2).toString().trim();
				if(gioiTinh.equalsIgnoreCase("Nam")) {
					cbGioiTinh.setSelectedItem("Nam");
				}else {
					cbGioiTinh.setSelectedItem("Nữ");
				}
				Date date= Date.valueOf(table_Nhanvien.getValueAt(table_Nhanvien.getSelectedRow(), 3).toString().trim());
				dateChooser.setDate(date);
				txt_diachi.setText(table_Nhanvien.getValueAt(table_Nhanvien.getSelectedRow(), 4).toString().trim());
				
			}
		});
		table_Nhanvien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		model_Nhanvien = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã nhân viên", "Họ tên", "Giới tính", "Ngày Sinh", "Địa chỉ" });
		table_Nhanvien.setModel(model_Nhanvien);

		scrollPane_sv.setViewportView(table_Nhanvien);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(20, 380, 1242, 307);
		add(panel);
		panel.setLayout(null);

		txt_Hoten = new JTextField();
		txt_Hoten.setBounds(142, 115, 196, 28);
		panel.add(txt_Hoten);
		txt_Hoten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Hoten.setColumns(10);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Dialog", Font.PLAIN, 15));
		cbGioiTinh.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ"}));
		cbGioiTinh.setBounds(559, 46, 136, 33);
		panel.add(cbGioiTinh);

		JLabel lblNewLabel_3 = new JLabel("Giới tính");
		lblNewLabel_3.setBounds(425, 51, 101, 22);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btn_Them = new JButton("THÊM");
		btn_Them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String hoTen = txt_Hoten.getText().trim();
				String gioiTinh = cbGioiTinh.getSelectedItem().toString().trim();
			
				String ngaySinh= formatter.format(dateChooser.getDate());
				Date datesinh= Date.valueOf(ngaySinh); 
				String diachi= txt_diachi.getText().trim();
				String maNV = txt_ma.getText().trim();
				boolean gt =true;
				if(gioiTinh.equalsIgnoreCase("Nữ")) {
					gt = false;
				}
				if(new TaiKhoanDAO().themTaiKhoanNV(maNV)){
				if(maNV.length()>0) {
					if(new NhanVienPDTDAO().themNhanVien(new NhanVienPhongDaoTao(maNV,hoTen,
							gt,datesinh,diachi,new TaiKhoan(maNV),nql))){
								JOptionPane.showMessageDialog(null, "Thêm thành công");
								loadNhanVien();
					}
				}else {
					JOptionPane.showMessageDialog(null,"Không được để trống mã");
				}			
			}
			}
		});
		btn_Them.setBounds(961, 33, 154, 58);
		panel.add(btn_Them);
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btn_Xoa = new JButton("XÓA");
		btn_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(table_Nhanvien.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để xóa");
				}else {
					int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa nhân viên "+(String) table_Nhanvien.getValueAt(table_Nhanvien.getSelectedRow(), 1));
						if(i==0) {
							System.out.println((String) table_Nhanvien.getValueAt(table_Nhanvien.getSelectedRow(), 0).toString().trim());
							if(new NhanVienPDTDAO().xoaNhanVien((String) table_Nhanvien.getValueAt(table_Nhanvien.getSelectedRow(), 0).toString().trim())){
								JOptionPane.showMessageDialog(null, "Xóa thành công nhân viên "+(String) table_Nhanvien.getValueAt(table_Nhanvien.getSelectedRow(), 0));
								loadNhanVien();
							}
						}
				}
				
			}
		});
		btn_Xoa.setBounds(961, 115, 154, 58);
		panel.add(btn_Xoa);
		btn_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				JButton btn_Sua = new JButton("SỬA THÔNG TIN");
				btn_Sua.setBounds(961, 204, 154, 58);
				panel.add(btn_Sua);
				btn_Sua.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
				        String ten= txt_Hoten.getText().toString();
						String ma =(String) table_Nhanvien.getValueAt(table_Nhanvien.getSelectedRow(),0).toString().trim();
						String gioiTinh = cbGioiTinh.getSelectedItem().toString().trim();
						String ngaySinh= formatter.format(dateChooser.getDate());
						String diachi= txt_diachi.getText().trim();
						boolean gt =true;
						if(gioiTinh.equalsIgnoreCase("Nữ")) {
							gt = false;
						}
						
					        Date date = Date.valueOf(ngaySinh);
						if(ten.length()>0) {
							//String maNhanVien, String tenNhanVien, boolean gioiTinh, Date ngaySinh, String diaChi,
//							TaiKhoan taiKhoan, NguoiQuanLi nguoiQuanLi)
							if(new NhanVienPDTDAO().capNhatNhanVien(new NhanVienPhongDaoTao(ma, ten, gt, date, diachi, new TaiKhoan(ma),nql))){
										JOptionPane.showMessageDialog(null, "Cập nhật thành công");
										loadNhanVien();;
							}
						}else {
							JOptionPane.showMessageDialog(null, "Không được");
						}
					}
				});
				btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
						JLabel lblNewLabel_1 = new JLabel("Họ tên");
						lblNewLabel_1.setBounds(31, 118, 101, 22);
						panel.add(lblNewLabel_1);
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
						
								JLabel lblNewLabel_2 = new JLabel("Ngày sinh");
								lblNewLabel_2.setBounds(31, 184, 101, 21);
								panel.add(lblNewLabel_2);
								lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
								
							    dateChooser = new JDateChooser();
								dateChooser.setBounds(142, 177, 196, 28);
								panel.add(dateChooser);
								
								JLabel lblNewLabel = new JLabel("Địa chỉ");
								lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
								lblNewLabel.setBounds(425, 114, 86, 19);
								panel.add(lblNewLabel);
								
								txt_diachi = new JTextField();
								txt_diachi.setFont(new Font("Tahoma", Font.PLAIN, 14));
								txt_diachi.setBounds(559, 112, 254, 28);
								panel.add(txt_diachi);
								txt_diachi.setColumns(10);
								
								JLabel lblNewLabel_4 = new JLabel("Mã nhân viên");
								lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
								lblNewLabel_4.setBounds(29, 58, 103, 28);
								panel.add(lblNewLabel_4);
								
								txt_ma = new JTextField();
								txt_ma.setFont(new Font("Tahoma", Font.PLAIN, 14));
								txt_ma.setBounds(142, 55, 123, 28);
								panel.add(txt_ma);
								txt_ma.setColumns(10);
		loadNhanVien();
	}
	public void loadNhanVien() {
		model_Nhanvien.getDataVector().removeAllElements();
//		 "Mã giảng viên", "Họ tên", "Giới tính", "Ngày Sinh", "Ngành" 
		new NhanVienPDTDAO().getAllNhanVien().forEach(x->{
			Vector<String> vt = new Vector<String>();
			vt.addElement(x.getMaNhanVien());
			vt.addElement(x.getTenNhanVien());
			if(x.isGioiTinh()) {
				vt.addElement("Nam");
			}else {
				vt.addElement("Nữ");
			}
			
			vt.addElement(String.valueOf(x.getNgaySinh()));
			vt.addElement(x.getDiaChi());
			model_Nhanvien.addRow(vt);
			
		});
		
	}
}
