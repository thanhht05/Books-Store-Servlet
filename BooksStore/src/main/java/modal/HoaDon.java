package modal;

import java.sql.Date;

public class HoaDon {
	private Long maHoaDon;
	private Long maKH;
	private Date ngayMua;

	public Long getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(Long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Long getMaKH() {
		return maKH;
	}

	public void setMaKH(Long maKH) {
		this.maKH = maKH;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

}
