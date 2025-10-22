package BO;

import java.util.ArrayList;

import DAO.ChiTietHoaDonDAO;
import modal.GioHang;

public class ChiTietHDBO {
	ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();

	public void luuChiTietHoaDon(ArrayList<GioHang> ds, Long maHoaDon) {
		chiTietHoaDonDAO.luuChiTietHoaDon(ds, maHoaDon);
	}
}
