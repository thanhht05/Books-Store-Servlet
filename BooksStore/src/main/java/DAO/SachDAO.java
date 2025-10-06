package DAO;

import java.util.ArrayList;

import modal.Sach;

public  class SachDAO {
	public ArrayList<Sach> getAllSach() {
		ArrayList<Sach> ds = new ArrayList<Sach>();
		ds.add(new Sach("s1", "Cấu trúc dữ liệu", "Messi", 10, 1200000, "b1.jpg", "tin"));
		ds.add(new Sach("s2", "Kỹ thuật hoá học", "Nga", 10, 1100000, "b2.jpg", "hoa"));
		ds.add(new Sach("s3", "Cấu trúc dữ liệu", "Lữ", 10, 900000, "b3.jpg", "tin"));
		ds.add(new Sach("s4", "Vật lý lượng từ", "Nga", 10, 1400000, "b4.jpg", "ly"));
		ds.add(new Sach("s5", "Cấu trúc dữ liệu", "Ronaldo", 10, 2200000, "b5.jpg", "tin"));
		ds.add(new Sach("s6", "Văn học việt nam", "Nga", 10, 1800000, "b6.jpg", "van"));
		ds.add(new Sach("s7", "Công nghệ sinh học", "Culi", 10, 1100000, "b7.jpg", "sinh"));
		ds.add(new Sach("s8", "Toán khoa học", "Nga", 10, 2700000, "b8.jpg", "toan"));

		return ds;
	}
	
	
}
