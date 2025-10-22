package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modal.LichSuMua;

import modal.TrangThaiMua;

public class LichSuMuaDAO {
	public ArrayList<LichSuMua>  getLichSuMuaByUserId(long userId) {
		ArrayList<LichSuMua> dsls= new ArrayList<LichSuMua>();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "select * from V_LichSuMua where user_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LichSuMua lichSuMua = new LichSuMua();
				lichSuMua.setUser_id(rs.getLong("user_id"));
				lichSuMua.setSoLuongMua(rs.getLong("soLuongMua"));
				lichSuMua.setGia(rs.getLong("gia"));
				lichSuMua.setNgayMua(rs.getDate("ngaymua"));

				lichSuMua.setThanhTien(rs.getLong("ThanhTien"));

				lichSuMua.setTrangThaiMua(
						(rs.getBoolean("daMua")) ? TrangThaiMua.DA_THANH_TOAN : TrangThaiMua.CHUA_THANH_TOAN);
				
				lichSuMua.setTenSach(rs.getString("tensach"));
				dsls.add(lichSuMua);

			}
			return dsls;
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return dsls;
	}
}
