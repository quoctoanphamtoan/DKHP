package GhiFileExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.LopDAO;
import DAO.MonHocDAO;
import DAO.NganhDAO;
import DAO.SinhVienDAO;
import Entity.GiangVien;
import Entity.LopHocPhan;
import Entity.MonHoc;
import Entity.PhongHoc;
import Entity.SinhVien;

public class GhiLopHocPhan {
	public static int rowIndex = 7;

	public static int i = 1;

	public static void main(String[] args) throws IOException {
//		final List<SinhVien> sinhViens = new SinhVienDAO().getSinhVienTheoLhp("LHP01");
//		final String excelFilePath = "Home/books4.xlsx";
//		writeExcel(sinhViens, excelFilePath, "LHP001");
	}
	public boolean ghiFile(LopHocPhan lopHocPhan,List<SinhVien> list,String duongDan) {
		String excelFilePath = ""+duongDan+"/"+lopHocPhan.getMaLopHP().trim()+".xlsx";
		try {
			writeExcel(list, excelFilePath, lopHocPhan);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public static void writeExcel(List<SinhVien> sinhViens, String excelFilePath, LopHocPhan lhp) throws IOException {
		// Create Workbook
		Workbook workbook = getWorkbook(excelFilePath);
		// Create sheet
		Sheet sheet = workbook.createSheet("" + lhp.getMaLopHP() + "" ); // Create sheet with sheet
																							// name

		// Write header
		writeHeader(sheet,lhp);
		// Write data

//	        for (Book book : books) {
//	            // Create row
//	            Row row = sheet.createRow(rowIndex);
//	            // Write data on row
//	            writeBook(book, row);
//	            rowIndex++;
//	        }

		sinhViens.forEach(x -> {
			Row row = sheet.createRow(rowIndex);
			writeBook(i, x, row,sheet,rowIndex+1);
			rowIndex++;
			i++;
		});

//	         
//	        // Write footer
//	        writeFooter(sheet, rowIndex);

		// Auto resize column witdth
//	        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
//	        autosizeColumn(sheet, numberOfColumn);

		// Create file excel
		createOutputFile(workbook, excelFilePath);
		System.out.println("Done!!!");
	}

	private static void writeHeader(Sheet sheet, LopHocPhan lhp) {
		// create CellStyle
		CellStyle cellStyle = createStyleForHeader(sheet);
		// Create row
		sheet.addMergedRegion(CellRangeAddress.valueOf("A1:U1"));
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Đại học Công nghiệp Thành phố Hồ Chí Minh");

		sheet.addMergedRegion(CellRangeAddress.valueOf("A2:U2"));
		Row row1 = sheet.createRow(1);
		Cell cell1 = row1.createCell(0);
		cell1.setCellStyle(cellStyle);
		cell1.setCellValue("DANH SÁCH SINH VIÊN LỚP HỌC PHẦN");
		////
		sheet.addMergedRegion(CellRangeAddress.valueOf("A3:C3"));
		Row row2 = sheet.createRow(2);
		Cell cell2 = row2.createCell(0);
		cell2.setCellValue("Lớp học phần");
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("A4:C4"));
		Row row3 = sheet.createRow(3);
		Cell cell3 = row3.createCell(0);
		cell3.setCellValue("Môn học phần");
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("A5:C5"));
		Row row4 = sheet.createRow(4);
		Cell cell4 = row4.createCell(0);
		cell4.setCellValue("Ngành");
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("A6:C6"));
		Row row5 = sheet.createRow(5);
		Cell cell5 = row5.createCell(0);
		cell5.setCellValue("Chuyên Ngành");
		////
		sheet.addMergedRegion(CellRangeAddress.valueOf("G3:J3"));
		cell2 = row2.createCell(6);
		cell2.setCellValue("Đợt");
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("G4:J4"));
		cell3 = row3.createCell(6);
		cell3.setCellValue("Năm học");
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("G5:J5"));
		cell4 = row4.createCell(6);
		cell4.setCellValue("Bậc đào tạo");
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("G6:J6"));
		cell5 = row5.createCell(6);
		cell5.setCellValue("Loại đào tạo");
		//////////////// Data head///////////////////////////

		sheet.addMergedRegion(CellRangeAddress.valueOf("D3:F3"));
		cell2 = row2.createCell(3);
		cell2.setCellValue(lhp.getMaLopHP());
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("D4:F4"));
		cell3 = row3.createCell(3);
		cell3.setCellValue(new MonHocDAO().getTenMonHoc(lhp.getMonHocEnity().getMaMonHoc()));
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("D5:F5"));
		cell4 = row4.createCell(3);
		cell4.setCellValue(new NganhDAO().getTenNganh(new MonHocDAO()
				.getMaChuyenNganhBangTenMonHoc(new MonHocDAO().getTenMonHoc(lhp.getMonHocEnity().getMaMonHoc()))));
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("D6:F6"));
		cell5 = row5.createCell(3);
		cell5.setCellValue(new MonHocDAO()
				.getMaChuyenNganhBangTenMonHoc(new MonHocDAO().getTenMonHoc(lhp.getMonHocEnity().getMaMonHoc())));
		////
		sheet.addMergedRegion(CellRangeAddress.valueOf("K3:L3"));
		cell2 = row2.createCell(10);
		cell2.setCellValue(lhp.getHocKy() + "-" + lhp.getNamHoc());
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("K4:L4"));
		cell3 = row3.createCell(10);
		cell3.setCellValue(lhp.getNamHoc());
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("K5:L5"));
		cell4 = row4.createCell(10);
		cell4.setCellValue("Đại học");
		/////
		sheet.addMergedRegion(CellRangeAddress.valueOf("K6:L6"));
		cell5 = row5.createCell(10);
		cell5.setCellValue("Tiên tiến");

		////////////////// titleSinhVien
		sheet.addMergedRegion(CellRangeAddress.valueOf("C7:E7"));
		Row row6 = sheet.createRow(6);
		Cell cell6 = row6.createCell(2);
		cell6.setCellValue("Họ tên");
		sheet.addMergedRegion(CellRangeAddress.valueOf("F7:H7"));
		cell6 = row6.createCell(5);
		cell6.setCellValue("Lớp học");
		cell6 = row6.createCell(8);
		cell6.setCellValue("Nhóm");

	}

	private static CellStyle createStyleForHeader(Sheet sheet) {
		// Create font
		Font font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setBold(true);
		font.setFontHeightInPoints((short) 20); // font size
		font.setColor(IndexedColors.WHITE.getIndex()); // text color

		// Create CellStyle
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFont(font);
//		cellStyle.setFillForegroundColor(IndexedColors.PINK.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		return cellStyle;
	}

	private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
		try (OutputStream os = new FileOutputStream(excelFilePath)) {
			workbook.write(os);
		}
	}

	private static Workbook getWorkbook(String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}

	private static void writeBook(int i, SinhVien sv, Row row,Sheet sheet,int y) {
		//258
		
		
		sheet.addMergedRegion(CellRangeAddress.valueOf("C"+y+":E"+y+""));
		sheet.addMergedRegion(CellRangeAddress.valueOf("F"+y+":H"+y+""));
		
		Cell cell = row.createCell(0);
		cell.setCellValue(i);

		cell = row.createCell(1);
		cell.setCellValue(sv.getMaSinhVien());

		cell = row.createCell(2);
		cell.setCellValue(sv.getTenSinhVien());

		cell = row.createCell(5);
		cell.setCellValue(new LopDAO().getTenLop(sv.getLopEnity().getMaLop()));
		cell = row.createCell(8);
		cell.setCellValue(1);
		
// 
//        cell = row.createCell(COLUMN_INDEX_PRICE);
//        cell.setCellValue(book.getPrice());
//        cell.setCellStyle(cellStyleFormatNumber);
// 
//        cell = row.createCell(COLUMN_INDEX_QUANTITY);
//        cell.setCellValue(book.getQuantity());
//         
//        // Create cell formula
//        // totalMoney = price * quantity
//        cell = row.createCell(COLUMN_INDEX_TOTAL, CellType.FORMULA);
//        cell.setCellStyle(cellStyleFormatNumber);
//        int currentRow = row.getRowNum() + 1;
//        String columnPrice = CellReference.convertNumToColString(COLUMN_INDEX_PRICE);
//        String columnQuantity = CellReference.convertNumToColString(COLUMN_INDEX_QUANTITY);
//        cell.setCellFormula(columnPrice + currentRow + "*" + columnQuantity + currentRow);
	}

}
