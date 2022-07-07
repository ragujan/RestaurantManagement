/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MySql;

/**
 *
 * @author Acer
 */
public class IdCheck {

	public static boolean isExits(String tname, String tid, String value) {
		boolean state = false;

		ResultSet rs;
		try {
			rs = MySql.sq("SELECT * FROM `" + tname + "` WHERE `" + tid + "`='" + value + "'");
			if (rs.next()) {
				state = true;
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(IdCheck.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(IdCheck.class.getName()).log(Level.SEVERE, null, ex);
		}

		return state;
	}

	public static boolean isExits(String tname, String value) {
		boolean state = false;
                String tid = tname+"_id";
		ResultSet rs;
		try {
			rs = MySql.sq("SELECT * FROM `" + tname + "` WHERE `" + tid + "`='" + value + "'");
			if (rs.next()) {
				state = true;
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(IdCheck.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(IdCheck.class.getName()).log(Level.SEVERE, null, ex);
		}

		return state;
	}
}
