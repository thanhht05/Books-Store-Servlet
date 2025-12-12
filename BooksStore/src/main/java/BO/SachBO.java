package BO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import DAO.SachDAO;
import modal.Sach;

public class SachBO {
	SachDAO sachDAO = new SachDAO();
	ArrayList<Sach> ds;

	public ArrayList<Sach> getAllSach() {
		ds = sachDAO.getAllSach();
		return ds;
	}

	public ArrayList<Sach> findByTenSach(String tenSach, int page, int rowsPerPage) {
		return sachDAO.findByTenSach(tenSach, page, rowsPerPage);
	}

	public ArrayList<Sach> getSachByLoai(String loai, int page, int rowsPerPage) {
		return sachDAO.getSachByLoai(loai, page, rowsPerPage);

	}

	public ArrayList<Sach> getSachByPage(int pageNum, int rowsPerPage) {
		return sachDAO.getSachByPage(pageNum, rowsPerPage);
	}

	public int countSach() {
		return sachDAO.countSach();
	}

	public int countSachByLoai(String maLoai) {
		return sachDAO.countSachByLoai(maLoai);
	}

	public int countSachByTen(String ten) {
		return sachDAO.countSachByTen(ten);
	}

	public void createSach(String tenSach, long soLuong, long gia, String tacGia, String anh, Timestamp ngayNhap,
			String maLoai) {
		sachDAO.createSach(tenSach, soLuong, gia, tacGia, anh, ngayNhap, maLoai);
	}

	public ArrayList<Sach> getSachSapHetHang(int pageNumber, int rowsPerPage) {
		return sachDAO.getSachSapHetHang(pageNumber, rowsPerPage);
	}

	public int countSachSapHet() {

		return sachDAO.countSachSapHet();
	}

	public int countSachDaHet() {

		return sachDAO.countSachDaHet();
	}

	public void capNhatSoLuongSach(long soLuong, long maSach) {
		sachDAO.capNhatSoLuongSach(soLuong, maSach);
	}

}
