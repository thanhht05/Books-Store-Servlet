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

	public ArrayList<Sach> findByTenSach(String tenSach) {
		return sachDAO.findByTenSach(tenSach);
	}

	public ArrayList<Sach> getSachByLoai(String loai) {
		return sachDAO.getSachByLoai(loai);

	}
}
