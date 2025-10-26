package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modal.ChiTietGioHang;
import modal.ChiTietHoaDon;
import modal.GioHang;
import modal.HoaDon;
import modal.Sach;

public class ChiTietHoaDonDAO {
	SachDAO sachDAO = new SachDAO();
	HoaDonDAO hoaDonDAO = new HoaDonDAO();

	public void luuChiTietHoaDon(ArrayList<ChiTietGioHang> ds, Long maHoaDon) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "INSERT INTO ChiTietHD (masach, soluongmua, damua, mahoadon) VALUES(?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			for (ChiTietGioHang gh : ds) {
				stmt.setLong(1, gh.getSach().getMaSach());
				stmt.setLong(2, gh.getSoLuong());
				stmt.setBoolean(3, false);
				stmt.setLong(4, maHoaDon);

				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() {
		ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = """
					    SELECT
					    	cthd.maChiTieyHoaDon,
					        h.ngaymua,
					        h.mahoadon,
					        cthd.daMua,
					        cthd.soLuongMua,
					        s.masach,
					        s.tensach
					  
					    FROM HoaDon h 
					    JOIN ChiTietHD cthd ON h.mahoadon = cthd.maHoaDon
					    JOIN sach s ON s.masach = cthd.maSach
					""";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
			
				ChiTietHoaDon ct = new ChiTietHoaDon();
				ct.setMaChiTietHD(rs.getLong("maChiTieyHoaDon"));

				Sach s = sachDAO.getSachById(rs.getLong("maSach"));
				if (s != null) {
					ct.setSach(s);
				}
				HoaDon hd = hoaDonDAO.getHoaDonById(rs.getLong("maHoaDon"));
				if (hd != null) {
					ct.setHoaDon(hd);
				}
				ct.setDaMua(rs.getBoolean("damua"));
				ct.setSoLuongMua(rs.getLong("soLuongMua"));

				ds.add(ct);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
