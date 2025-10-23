package BO;

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
	
}
