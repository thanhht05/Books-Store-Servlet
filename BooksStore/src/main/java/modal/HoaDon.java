package modal;

import java.sql.Date;

public class HoaDon {
	private Long maHoaDon;
	private User user;
	private Date ngayMua;

	public Long getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(Long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

}
