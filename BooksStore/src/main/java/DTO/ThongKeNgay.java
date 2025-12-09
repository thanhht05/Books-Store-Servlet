package DTO;

import java.sql.Date;
import java.time.LocalDateTime;

public class ThongKeNgay {
	private Date ngay;
	private long doanhThu;

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date date) {
		this.ngay = date;
	}

	public long getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(long doanhThu) {
		this.doanhThu = doanhThu;
	}

}
