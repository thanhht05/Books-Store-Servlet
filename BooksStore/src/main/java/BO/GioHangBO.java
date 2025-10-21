package BO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;

import modal.GioHang;
import modal.Sach;

public class GioHangBO {
	public GioHangBO() {

	}

	public ArrayList<GioHang> ds = new ArrayList<GioHang>();

	public void them(GioHang gioHang) {
		for (int i = 0; i < ds.size(); i++) {
			GioHang gi = ds.get(i);
			if (gi.getMaSach()==gioHang.getMaSach()) {
				long soLm = gi.getSoLuong() + gioHang.getSoLuong();
				ds.get(i).setSoLuong(soLm);
				return;
			}
		}

		GioHang gh = new GioHang(gioHang.getMaSach(), gioHang.getTenSach(), gioHang.getSoLuong(), gioHang.getGia(),
				gioHang.getAnh());
		ds.add(gh);
	}

	public GioHang getGioHangById(long id) {
		GioHang gh = ds.stream().filter(item -> item.getMaSach()==id).findFirst().orElse(null);
		return gh;

	}

	public void update(long id, int quantity) {
		// update: // tao 1 tragn xoa => gui kem id vao request
		// // trong trang xoa: :Lay thong tin cua Hang ra vao fill vao input
		// // khi update: redirect ve trang gioHang.jsp

		for (GioHang gh : ds) {
			if (gh.getMaSach()==id) {
				gh.setSoLuong(quantity);
				return;
			}
		}

	}

	public void xoa(long id) {
		// tao 1 trang xoa.jsp
		// khi bam nut xoa gui kem id vao request
		// lay id ra va viet ham xoa theo id
		// redirect lai giohang.jsp

		ds.removeIf(u -> u.getMaSach()==id);

//		for(int i=0;i<ds.size();i++) {
//			if(ds.get(i).getMaSach().equals(id)) {
//				ds.remove(i);
//				i--;
//			}
//		}
//		
	}

	public long tongTien() {
	    return ds.stream().mapToLong(GioHang::getThanhTien).sum();
	}

}
