package BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.KetNoiJDBC;
import DAO.LoaiDAO;
import modal.Loai;

public class LoaiBO {
	LoaiDAO loaiDAO= new LoaiDAO();
	
	
	
	public ArrayList<Loai> getAllLoai(){
		return loaiDAO.getAllLoai();
	}
	
}
