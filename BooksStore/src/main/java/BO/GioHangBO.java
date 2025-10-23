package BO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;

import javax.servlet.http.HttpSession;

import DAO.ChiTietGioHangDAO;
import DAO.GioHangDAO;
import DAO.SachDAO;
import modal.ChiTietGioHang;
import modal.GioHang;
import modal.Sach;
import modal.User;

public class GioHangBO {
	GioHangDAO gioHangDAO = new GioHangDAO();
	SachDAO sachDAO = new SachDAO();
	ChiTietGioHangDAO chiTietGioHangDAO = new ChiTietGioHangDAO();
	public GioHangBO() {

	}

	public ArrayList<GioHang> ds = new ArrayList<GioHang>();

	public void themSanPhamVaoGio(Long sachId,HttpSession session) {
		User user = (User) session.getAttribute("userLogin");
		if(user!=null) {
			GioHang gh = gioHangDAO.timGioHangByUserId(user.getId());
			
			// user chua co gio hang
			if(gh==null) {
				GioHang newGioHang = new GioHang();
				newGioHang.setUser(user);
				newGioHang.setSoLuong(0);
				
				gh=gioHangDAO.saveGioHang(newGioHang);
			}
			// user da co gio hang
			Sach sach = sachDAO.getSachById(sachId);
			if(sach!=null) {
				ChiTietGioHang ctgh = chiTietGioHangDAO.timChiTietGioHang(gh, sach);
				// chua co chi tiet gio hang
				if(ctgh==null) {
					ChiTietGioHang newCtgh = new ChiTietGioHang();
					newCtgh.setSach(sach);
					newCtgh.setGia(sach.getGia());
					newCtgh.setGioHang(gh);
					newCtgh.setSoLuong(1);
					
					chiTietGioHangDAO.save(newCtgh);
					
					long sum= gh.getSoLuong()+1;
					gh.setSoLuong(sum);
					
					
					gioHangDAO.updateGioHang(gh);
					session.setAttribute("sun",sum);
				}else {
					ctgh.setSoLuong(ctgh.getSoLuong()+1);
					chiTietGioHangDAO.update(ctgh);
				}
			}
			
		}
	}
	
	public GioHang timGioHangByUserId(Long id){
		return gioHangDAO.timGioHangByUserId(id);
	}

//	public GioHang getGioHangById(long id) {
//		GioHang gh = ds.stream().filter(item -> item.getMaSach()==id).findFirst().orElse(null);
//		return gh;
//
//	}
//
//	public void update(long id, int quantity) {
//		// update: // tao 1 tragn xoa => gui kem id vao request
//		// // trong trang xoa: :Lay thong tin cua Hang ra vao fill vao input
//		// // khi update: redirect ve trang gioHang.jsp
//
//		for (GioHang gh : ds) {
//			if (gh.getMaSach()==id) {
//				gh.setSoLuong(quantity);
//				return;
//			}
//		}
//
//	}
//
	
//
//	public long tongTien() {
//	    return ds.stream().mapToLong(GioHang::getThanhTien).sum();
//	}

}
