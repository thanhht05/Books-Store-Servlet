package BO;

import java.sql.Date;

import DAO.HoaDonDAO;
import modal.HoaDon;

public class HoaDonBO {
	HoaDonDAO hoaDonDAO = new HoaDonDAO();
	public long luuHoaDon(HoaDon hoaDon) {
		return hoaDonDAO.luuHoaDon(hoaDon);
	}
}
