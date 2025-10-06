package DAO;

import java.util.ArrayList;

import modal.Loai;

public class LoaiDAO {
	public ArrayList<Loai> getALlLoai(){
		 ArrayList<Loai> ds= new ArrayList<Loai>();
		 ds.add( new Loai( "tin", "Công nghệ thông tin"));
		 ds.add( new Loai( "ly", "Vật lý"));
		 ds.add( new Loai( "hoa", "Công nghệ hoá học"));
		 ds.add( new Loai( "sinh", "Công nghệ sinh học"));
		 ds.add( new Loai( "van", "Văn học"));
		 return ds;
		 
	}
}
