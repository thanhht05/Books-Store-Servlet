package modal;

public class ChiTietGioHang {
	private long id;
	private GioHang gioHang;
	private Sach sach;
	private long soLuong;
	private long gia;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public GioHang getGioHang() {
		return gioHang;
	}

	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

}
