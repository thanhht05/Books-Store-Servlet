package modal;

import java.time.Instant;

public class User {
	private long id;
	private String hoTen;
	private String phone;
	private String diaChi;
	private String email;
	private boolean gioTinh;
	private Role role;
	private String sessionId;
	private Instant sessionExpire;
	

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Instant getSessionExpire() {
		return sessionExpire;
	}

	public void setSessionExpire(Instant sessionExpire) {
		this.sessionExpire = sessionExpire;
	}

	public User() {

	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean getGioTinh() {
		return gioTinh;
	}

	public void setGioTinh(boolean gioTinh) {
		this.gioTinh = gioTinh;
	}

	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
