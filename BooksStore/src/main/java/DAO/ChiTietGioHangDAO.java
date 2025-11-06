package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modal.ChiTietGioHang;
import modal.GioHang;
import modal.Sach;

public class ChiTietGioHangDAO {
	public ArrayList<ChiTietGioHang> getAllByUser(long userId) {
		ArrayList<ChiTietGioHang> ds = new ArrayList<>();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = """
					    SELECT s.tensach, s.masach, s.gia, s.anh, c.id, c.soluong
					    FROM ChiTietGioHang c
					    JOIN Sach s ON c.sach_id = s.masach
					    JOIN GioHang g ON g.id = c.gioHang_id
					    WHERE g.khachHang_id = ?
					""";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Sach s = new Sach();
				s.setAnh(rs.getString("anh"));
				s.setMaSach(rs.getLong("masach"));
				s.setGia(rs.getLong("gia"));
				s.setTenSach(rs.getString("tensach"));

				ChiTietGioHang ctgh = new ChiTietGioHang();
				ctgh.setId(rs.getLong("id"));
				ctgh.setSach(s);

				ctgh.setSoLuong(rs.getLong("soluong"));
				ctgh.setGia(rs.getLong("gia"));

				ds.add(ctgh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public ChiTietGioHang timChiTietGioHang(GioHang gh, Sach sach) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM ChiTietGioHang WHERE gioHang_id = ? AND sach_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setLong(1, gh.getId());
			stmt.setLong(2, sach.getMaSach());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				ChiTietGioHang ctgh = new ChiTietGioHang();
				ctgh.setId(rs.getLong("id"));
				ctgh.setGioHang(gh);
				ctgh.setSoLuong(rs.getLong("soLuong"));
				ctgh.setGia(rs.getLong("gia"));
				ctgh.setSach(sach);

				return ctgh;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(ChiTietGioHang ctgh) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "INSERT INTO ChiTietGioHang (gioHang_id, sach_id, soLuong, gia) VALUES(?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setLong(1, ctgh.getGioHang().getId());
			stmt.setLong(2, ctgh.getSach().getMaSach());
			stmt.setLong(3, ctgh.getSoLuong());
			stmt.setLong(4, ctgh.getGia());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(ChiTietGioHang ctgh) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "UPDATE chiTietGIoHang SET soLuong =? WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setLong(1, ctgh.getSoLuong());

			stmt.setLong(2, ctgh.getId());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void capNhatSoLuong(long ghId, long sId, long sl) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "UPDATE ChiTietGioHang SET soLuong =? WHERE sach_id=? and gioHang_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setLong(1, sl);
			stmt.setLong(2, sId);
			stmt.setLong(3, ghId);

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(long cartId, long sachId) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			// 1Xóa sản phẩm trong chi tiết giỏ hàng
			String sql = "DELETE FROM ChiTietGioHang WHERE sach_id = ? AND gioHang_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, sachId);
			stmt.setLong(2, cartId);
			stmt.executeUpdate();

			// Kiểm tra xem giỏ hàng còn sản phẩm nào không
			String countSql = "SELECT COUNT(*) FROM ChiTietGioHang WHERE gioHang_id = ?";
			PreparedStatement countStmt = conn.prepareStatement(countSql);
			countStmt.setLong(1, cartId);
			ResultSet rs = countStmt.executeQuery();

			if (rs.next() && rs.getInt(1) == 0) {
				// Nếu không còn sản phẩm nào, xóa luôn giỏ hàng
				String deleteCartSql = "DELETE FROM GioHang WHERE id = ?";
				PreparedStatement deleteCartStmt = conn.prepareStatement(deleteCartSql);
				deleteCartStmt.setLong(1, cartId);
				deleteCartStmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAll(ArrayList<ChiTietGioHang> ds, long cartId) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			// xoá chiTietGioHang theo sach_id và gioHang_id
			String sql = "DELETE FROM ChiTietGioHang WHERE sach_id=? and giohang_id=? ";
			PreparedStatement stmt = conn.prepareStatement(sql);

			for (ChiTietGioHang ct : ds) {
				stmt.setLong(1, ct.getSach().getMaSach());
				stmt.setLong(2, cartId);

				stmt.executeUpdate();
			}
			
			// sau khi xoá thì kiểm tra trong table ChiTietGioHang con tồn tại trường gioHangId không
			String countSql = "SELECT COUNT(*) FROM ChiTietGioHang WHERE gioHang_id = ?";
			PreparedStatement stmtCount = conn.prepareStatement(countSql);
			stmtCount.setLong(1, cartId);

			ResultSet rs = stmtCount.executeQuery();
			
			// Nếu không tồn tại trường gioHangId trong ChiTietGioHang thì xoá giỏ hàng trong table giỏ hàng
			//vì 1 gioHang - n ChiTietGIonHang
			if (rs.next() && rs.getInt(1) == 0) {
				String deleteCartSql = "DELETE FROM GioHang WHERE id = ?";
				PreparedStatement deleteCartStmt = conn.prepareStatement(deleteCartSql);
				deleteCartStmt.setLong(1, cartId);
				deleteCartStmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
