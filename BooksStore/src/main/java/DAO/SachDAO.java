package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modal.Sach;

public class SachDAO {
	public ArrayList<Sach> getAllSach() {
		ArrayList<Sach> ds = new ArrayList<Sach>();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM sach";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Sach s = new Sach();
				s.setAnh(rs.getString("anh"));
				s.setGia(rs.getLong("gia"));
				s.setTacGia(rs.getString("tacgia"));
				s.setTenSach(rs.getString("tensach"));
				s.setSoLuong(rs.getLong("soluong"));
				s.setMaLoai(rs.getString("maloai"));
				s.setMaSach(rs.getString("masach"));
				ds.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public ArrayList<Sach> getSachByLoai(String maLoai) {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM SACH WHERE maloai =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, maLoai);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Sach s = new Sach();

				s.setAnh(rs.getString("anh"));
				s.setGia(rs.getLong("gia"));
				s.setTacGia(rs.getString("tacgia"));
				s.setTenSach(rs.getString("tensach"));
				s.setSoLuong(rs.getLong("soluong"));
				s.setMaLoai(rs.getString("maloai"));
				dsSach.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSach;
	}

	public ArrayList<Sach> findByTenSach(String tenSach) {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM SACH WHERE tensach LIKE N'%" + tenSach + "%'";
			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, tenSach);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Sach s = new Sach();

				s.setAnh(rs.getString("anh"));
				s.setGia(rs.getLong("gia"));
				s.setTacGia(rs.getString("tacgia"));
				s.setTenSach(rs.getString("tensach"));
				s.setSoLuong(rs.getLong("soluong"));
				s.setMaLoai(rs.getString("maloai"));
				dsSach.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSach;
	}

	public ArrayList<Sach> getSachByPage(int pageNumber, int rowsPerPage) {
		ArrayList<Sach> ds = new ArrayList<Sach>();

		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM SACH ORDER BY masach OFFSET (?-1) * ? ROWS FETCH NEXT ? ROWS ONLY";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pageNumber);
			stmt.setInt(2, rowsPerPage);
			stmt.setInt(3, rowsPerPage);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Sach s = new Sach();

				s.setAnh(rs.getString("anh"));
				s.setGia(rs.getLong("gia"));
				s.setTacGia(rs.getString("tacgia"));
				s.setTenSach(rs.getString("tensach"));
				s.setSoLuong(rs.getLong("soluong"));
				s.setMaLoai(rs.getString("maloai"));
				ds.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public int countSach() {
		int c = 0;
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT COUNT(*) FROM Sach";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				c = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
