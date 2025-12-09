package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.ThongKeNgay;
import DTO.ThongKeSachBanChay;

public class ThongKeDAO {
	public ThongKeNgay getThongKeTheoNgay() {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = """
						SELECT SUM(s.gia * ct.soLuongMua) as tongTien, h.ngaymua
						 FROM HoaDon h JOIN CHiTietHD ct
								ON h.mahoadon=ct.maHoaDon
								JOIN sach s
								ON ct.maSach=s.masach

						WHERE ct.daMua=1 AND h.ngaymua= CAST(GetDate() as date)
						GROUP BY h.ngaymua
					""";

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			ThongKeNgay tkd = new ThongKeNgay();
			while (rs.next()) {
				tkd.setDoanhThu(Long.parseLong(rs.getString("tongTien")));
				tkd.setNgay(rs.getDate("ngaymua"));
			}
			return tkd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getSoLuongDonHangChuaXuLy() {
		int sl = 0;
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = """
					select count ( maChiTieyHoaDon) as soLuong
					from CHiTietHD
					where DaMua=0
					""";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				sl = Integer.parseInt(rs.getString("soLuong"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sl;
	}

	// gat sach ban chay trong 30 ngay
	public ArrayList<ThongKeSachBanChay> getSachBanChay() {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = """
					SELECT TOP (20)
					    s.tensach,
					    s.masach,
					    SUM(ct.soLuongMua) AS tongSoLuongMua
					FROM sach s
					JOIN CHiTietHD ct ON s.masach = ct.maSach
					JOIN HoaDon h ON ct.maHoaDon = h.mahoadon
					WHERE
					    h.ngaymua >= DATEADD(DAY, -30, CAST(GETDATE() AS date))
					    AND ct.daMua = 1
					GROUP BY
					    s.tensach,
					    s.masach
					ORDER BY
					    tongSoLuongMua DESC;

					""";
			 ArrayList<ThongKeSachBanChay> ds= new ArrayList<ThongKeSachBanChay>();
			
			PreparedStatement stmt=conn.prepareStatement(sql);
			
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				ThongKeSachBanChay s=new ThongKeSachBanChay();
				s.setMaSach(rs.getLong("masach"));
				s.setTenSach(rs.getString("tenSach"));
				s.setTongSoLuongMua(Long.parseLong(rs.getString("tongSoLuongMua")));
				ds.add(s);
			}
			
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
