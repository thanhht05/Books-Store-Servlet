package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import modal.GioHang;

public class ChiTietHoaDonDAO {
	public void luuChiTietHoaDon(ArrayList<GioHang> ds, Long maHoaDon) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "INSERT INTO ChiTietHD (masach, soluongmua, damua, mahoadon) VALUES(?,?,?,?)";
			PreparedStatement stmt= conn.prepareStatement(sql);
			
			for(GioHang gh:ds) {
				stmt.setLong(1, gh.getMaSach());
				stmt.setLong(2,gh.getSoLuong());
				stmt.setBoolean(3, false);
				stmt.setLong(4, maHoaDon);
				
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
