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
		ds = sachDAO.getAllSach();
		ArrayList<Sach> dsFind = ds.stream().filter(s -> s.getTenSach().toLowerCase().contains(tenSach.toLowerCase()))
				.collect(Collectors.toCollection(ArrayList::new));
		return dsFind;
	}

	public ArrayList<Sach> getSachByLoai(String loai) {
		ds = sachDAO.getAllSach();
		ArrayList<Sach> sachL = ds.stream().filter(s -> s.getMaLoai().toLowerCase().contains(loai.toLowerCase()))
				.collect(Collectors.toCollection(ArrayList::new));
		return sachL;

	}
}
