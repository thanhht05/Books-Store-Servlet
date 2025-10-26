package BO;

import java.util.ArrayList;

import DAO.ChiTietHoaDonDAO;
import modal.ChiTietGioHang;
import modal.ChiTietHoaDon;
import modal.GioHang;

public class ChiTietHDBO {
	ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();

	public void luuChiTietHoaDon(ArrayList<ChiTietGioHang> ds, Long maHoaDon) {
		chiTietHoaDonDAO.luuChiTietHoaDon(ds, maHoaDon);
	}
	
	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() {
		return chiTietHoaDonDAO.getAllChiTietHoaDon();
	}
}
