/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frame;

import java.awt.geom.RoundRectangle2D;
import javax.swing.JDialog;

/**
 *
 * @author Acer
 */
public class NewClass extends JDialog {
	
	public NewClass(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		this.setUndecorated(true);
		this.setSize(200, 200);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 7, 7));
		setVisible(true);
	}
}
