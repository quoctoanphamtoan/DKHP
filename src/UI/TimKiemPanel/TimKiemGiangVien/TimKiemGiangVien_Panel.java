package UI.TimKiemPanel.TimKiemGiangVien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.NganhDAO;
import DAO.TimKiemFull;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class TimKiemGiangVien_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtMaLoc;
	private JTextField txtTenLoc;
	private JTextField txtNganhLoc;
	private JTable table;
	private DefaultTableModel modelGiangVienLoc;
	private JComboBox<String> cbGioiTinh;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TimKiemGiangVien_Panel frame = new TimKiemGiangVien_Panel();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TimKiemGiangVien_Panel() {
		setSize(1300, 730);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("L\u1ECDc theo m\u00E3"); 
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(138, 58, 93, 19);
		add(lblNewLabel);
		
		txtMaLoc = new JTextField();
		txtMaLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaLoc.setBounds(250, 57, 120, 33);
		add(txtMaLoc);
		txtMaLoc.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("L\u1ECDc theo t\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(138, 117, 93, 23);
		add(lblNewLabel_1);
		
		txtTenLoc = new JTextField();
		txtTenLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenLoc.setColumns(10);
		txtTenLoc.setBounds(250, 117, 120, 33);
		add(txtTenLoc);
		
		JLabel lblNewLabel_2 = new JLabel("L\u1ECDc theo ng\u00E0nh");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(537, 66, 140, 24);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("L\u1ECDc theo gi\u1EDBi t\u00EDnh");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(537, 121, 151, 23);
		add(lblNewLabel_3);
		
		txtNganhLoc = new JTextField();
		txtNganhLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNganhLoc.setColumns(10);
		txtNganhLoc.setBounds(694, 60, 108, 30);
		add(txtNganhLoc);
		
		JButton btnLoc = new JButton("LỌC");
		btnLoc.setIcon(new ImageIcon("D:\\PhatTrienUD\\DangKiHP\\hinh\\search.png"));
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoc.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent arg0) {
				if(txtMaLoc.getText().trim().equalsIgnoreCase("")&&txtNganhLoc.getText().equalsIgnoreCase("")&&txtTenLoc.getText().equalsIgnoreCase("")) {

					loc("");
				}else if(txtNganhLoc.getText().equalsIgnoreCase("")&&txtTenLoc.getText().equalsIgnoreCase("")) {
					loc(txtMaLoc.getText().trim());
				}else if(txtMaLoc.getText().trim().equalsIgnoreCase("")&&txtNganhLoc.getText().equalsIgnoreCase("")){
					locTen(txtTenLoc.getText().trim());
				}else if(txtMaLoc.getText().trim().equalsIgnoreCase("")&&txtTenLoc.getText().equalsIgnoreCase("")) {
					locNganh(txtNganhLoc.getText().trim());
				}
		
				
			}
		});
		btnLoc.setBounds(893, 88, 108, 41);
		add(btnLoc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 229, 1239, 390);
		add(scrollPane);
		
		table = new JTable();
		modelGiangVienLoc= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã giảng viên", "Tên giảng viên", "Giới tính", "Ngày sinh", "Ngành"
				}
			);
		table.setModel(modelGiangVienLoc);
		scrollPane.setViewportView(table);
		
		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbGioiTinh.setModel(new DefaultComboBoxModel<String>(new String[] {"","Nam", "Nữ"}));
		cbGioiTinh.setBounds(698, 117, 81, 24);
		add(cbGioiTinh);
	}
	public void loc(String s) {
		modelGiangVienLoc.getDataVector().removeAllElements();
		String ma= txtMaLoc.getText().trim();
	
		String gioitinh;
		if(String.valueOf(cbGioiTinh.getSelectedItem()).trim().equalsIgnoreCase("Nam")) {
			gioitinh = "Nam";
		}else {
			gioitinh="Nữ";
		}					
		//txtTenLoc.getText().trim(), txtNganhLoc.getText().trim() ,""
			new TimKiemFull().LocGiangVien(s,"", "" ,"").forEach(x->{
				Vector<String> vt = new Vector<String>();
				System.out.println(x.getTenGiangVien());
				vt.addElement(x.getMaGiangVien());
				vt.addElement(x.getTenGiangVien());
				String i;
				if(x.isGioiTinh()==true) {
					i="Nam";
					
				}else {
					i="Nữ";
				}
				vt.addElement(i);
				vt.addElement(String.valueOf(x.getNgaySinh()));
				vt.addElement(new NganhDAO().getTenNganh(x.getNganh().getMaNganh()));
				modelGiangVienLoc.addRow(vt);
				
				
			});
//			modelGiangVienLoc.getDataVector().removeAllElements();
			table.setModel(modelGiangVienLoc);
			
		
	}
	public void locTen(String s) {
		modelGiangVienLoc.getDataVector().removeAllElements();
		String ma= txtMaLoc.getText().trim();
	
		String gioitinh;
		if(String.valueOf(cbGioiTinh.getSelectedItem()).trim().equalsIgnoreCase("Nam")) {
			gioitinh = "Nam";
		}else {
			gioitinh="Nữ";
		}					
		//txtTenLoc.getText().trim(), txtNganhLoc.getText().trim() ,""
			new TimKiemFull().LocGiangVien("",s, "" ,"").forEach(x->{
				Vector<String> vt = new Vector<String>();
				System.out.println(x.getTenGiangVien());
				vt.addElement(x.getMaGiangVien());
				vt.addElement(x.getTenGiangVien());
				String i;
				if(x.isGioiTinh()==true) {
					i="Nam";
					
				}else {
					i="Nữ";
				}
				vt.addElement(i);
				vt.addElement(String.valueOf(x.getNgaySinh()));
				vt.addElement(new NganhDAO().getTenNganh(x.getNganh().getMaNganh()));
				modelGiangVienLoc.addRow(vt);
				
				
			});
//			modelGiangVienLoc.getDataVector().removeAllElements();
			table.setModel(modelGiangVienLoc);
			
		
	}
	public void locNganh(String s) {
		modelGiangVienLoc.getDataVector().removeAllElements();
		String ma= txtMaLoc.getText().trim();
	
		String gioitinh;
		if(String.valueOf(cbGioiTinh.getSelectedItem()).trim().equalsIgnoreCase("Nam")) {
			gioitinh = "Nam";
		}else {
			gioitinh="Nữ";
		}					
		//txtTenLoc.getText().trim(), txtNganhLoc.getText().trim() ,""
			new TimKiemFull().LocGiangVien("","", s ,"").forEach(x->{
				Vector<String> vt = new Vector<String>();
				System.out.println(x.getTenGiangVien());
				vt.addElement(x.getMaGiangVien());
				vt.addElement(x.getTenGiangVien());
				String i;
				if(x.isGioiTinh()==true) {
					i="Nam";
					
				}else {
					i="Nữ";
				}
				vt.addElement(i);
				vt.addElement(String.valueOf(x.getNgaySinh()));
				vt.addElement(new NganhDAO().getTenNganh(x.getNganh().getMaNganh()));
				modelGiangVienLoc.addRow(vt);
				
				
			});
//			modelGiangVienLoc.getDataVector().removeAllElements();
			table.setModel(modelGiangVienLoc);
			
		
	}
}
