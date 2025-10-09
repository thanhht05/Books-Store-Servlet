package BO;

import java.util.ArrayList;

import DAO.LoaiDAO;
import modal.Loai;

public class LoaiBO {
	LoaiDAO loaiDAO= new LoaiDAO();
	public ArrayList<Loai> getAllLoai(){
		
		return loaiDAO.getALlLoai();
	}
	
	
	
	
}
