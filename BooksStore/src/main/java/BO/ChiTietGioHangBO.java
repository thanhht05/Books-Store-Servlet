package BO;

import java.util.ArrayList;

import DAO.ChiTietGioHangDAO;
import modal.ChiTietGioHang;
import modal.GioHang;
import modal.Sach;

public class ChiTietGioHangBO {
	ChiTietGioHangDAO chiTietGioHangDAO = new ChiTietGioHangDAO();

	public ArrayList<ChiTietGioHang> getAllByUser(long id) {
		return chiTietGioHangDAO.getAllByUser(id);
	}

	public void update(ChiTietGioHang ctgh) {
		chiTietGioHangDAO.update(ctgh);
	}

	public void capNhatSoLuong(long ghId, long sId, long sl) {
		chiTietGioHangDAO.capNhatSoLuong(ghId, sId, sl);
	}

	public void delete(long cartId, long sachId) {
		chiTietGioHangDAO.delete(cartId, sachId);
	}

	public void deleteAll(ArrayList<ChiTietGioHang> ds, long cartId) {
		chiTietGioHangDAO.deleteAll(ds, cartId);
	}

}
