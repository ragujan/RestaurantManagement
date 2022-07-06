/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import javax.swing.JFrame;

/**
 *
 * @author acer
 */
public class CreateObject {
	

	public static void make(JFrame jf) {
		jf.setVisible(true);
	}

	public static void make(JFrame closing, JFrame jf, boolean isDispose) {
		make(jf);

		if (isDispose) {
			closing.dispose();
		}

	}
}
