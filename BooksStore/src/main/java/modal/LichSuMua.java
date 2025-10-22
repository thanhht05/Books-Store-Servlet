package modal;

import java.sql.Date;

public class LichSuMua {
	private long user_id;
	private String tenSach;
	private long soLuongMua;
	private TrangThaiMua trangThaiMua;
	private Date ngayMua;
	private long gia; 
	private long thanhTien;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public long getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(long soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public TrangThaiMua getTrangThaiMua() {
		return trangThaiMua;
	}

	public void setTrangThaiMua(TrangThaiMua trangThaiMua) {
		this.trangThaiMua = trangThaiMua;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}

}
