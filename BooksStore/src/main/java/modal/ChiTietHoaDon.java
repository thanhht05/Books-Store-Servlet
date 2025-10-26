package modal;

public class ChiTietHoaDon {
	private Long maChiTietHD;
	private Sach sach;
	private Boolean daMua;
	private HoaDon hoaDon;
	private long soLuongMua;

	public long getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(long soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public Long getMaChiTietHD() {
		return maChiTietHD;
	}

	public void setMaChiTietHD(Long maChiTietHD) {
		this.maChiTietHD = maChiTietHD;
	}

	

	public Boolean getDaMua() {
		return daMua;
	}

	public void setDaMua(Boolean daMua) {
		this.daMua = daMua;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	

}
