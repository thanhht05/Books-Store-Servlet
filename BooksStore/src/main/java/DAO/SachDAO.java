package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
				s.setMaSach(rs.getLong("masach"));
				ds.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	
	public void createSach(String tenSach, long soLuong, long gia, String tacGia, String anh,Timestamp  ngayNhap, String maLoai ) {
		
		try (Connection conn = KetNoiJDBC.getConnection()){
			String sql="INSERT INTO sach ( tensach, soluong, gia, anh, tacgia, ngayNhap, maLoai) VALUES (?, ?,?,?, ?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, tenSach);
			stmt.setLong(2,soLuong);
			stmt.setLong(3, gia);
			stmt.setString(4, anh);
			stmt.setString(5, tacGia);
			stmt.setTimestamp(6,ngayNhap);
			stmt.setString(7, maLoai);
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 	OFFSET ( page-1)* rowPerpage:  Là số dòng muốn bỏ qua
	 	page?: Lấy dữ liệu từ trang số mấy
	 	rowPerpage?: Mỗi trang có 5 dòng
	 	FETCH NEXT?: Lấy rowsPerPage dòng tiếp theo
	 */
	public ArrayList<Sach> getSachByLoai(String maLoai, int page, int rowsPerPage) {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM SACH WHERE maloai =? ORDER BY masach OFFSET (?-1) * ? ROWS FETCH NEXT ? ROWS ONLY";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, maLoai);
			stmt.setInt(2, page);
			stmt.setInt(3, rowsPerPage);
			stmt.setInt(4, rowsPerPage);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Sach s = new Sach();
				s.setMaSach(rs.getLong("masach"));
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

	public int countSachByLoai(String maLoai) {
		int total = 0;
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT COUNT(*) FROM SACH WHERE maloai = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, maLoai);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public ArrayList<Sach> findByTenSach(String tenSach, int page, int rowsPerPage) {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM SACH WHERE tensach LIKE N'%" + tenSach
					+ "%' ORDER BY masach OFFSET (?-1) * ? ROWS FETCH NEXT ? ROWS ONLY";
			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, tenSach);
			stmt.setInt(1, page);
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
				s.setMaSach(rs.getLong("masach"));
				dsSach.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSach;
	}

	public int countSachByTen(String tenSach) {
		int total = 0;
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT COUNT(*) FROM SACH WHERE tensach LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + tenSach + "%"); 
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
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
				s.setMaSach(rs.getLong("masach"));
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

	public Sach getSachById(long id) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM SACH WHERE masach =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Sach s = new Sach();
				s.setMaSach(rs.getLong("masach"));
				s.setAnh(rs.getString("anh"));
				s.setGia(rs.getLong("gia"));
				s.setTacGia(rs.getString("tacgia"));
				s.setTenSach(rs.getString("tensach"));
				s.setSoLuong(rs.getLong("soluong"));
				s.setMaLoai(rs.getString("maloai"));
				return s;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public ArrayList<LoaiDAO>

}
