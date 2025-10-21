package BO;

import java.sql.Date;

import DAO.HoaDonDAO;

public class HoaDonBO {
	HoaDonDAO hoaDonDAO = new HoaDonDAO();
	public void luuHoaDon(long maKH, Date ngayMua) {
		hoaDonDAO.luuHoaDon(maKH, ngayMua);
	}
}
