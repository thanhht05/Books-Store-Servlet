package BO;

import java.util.ArrayList;

import DAO.LichSuMuaDAO;
import modal.LichSuMua;

public class LichSuMuaBO {
	LichSuMuaDAO lichSuMuaDAO = new LichSuMuaDAO();

	public ArrayList<LichSuMua>  getLichSuMuaByUserId(long userId) {
		return lichSuMuaDAO.getLichSuMuaByUserId(userId);
	}
}
