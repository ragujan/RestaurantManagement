/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import gui.FRNITEMVIEW;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Acer
 */
public abstract class TableListenerAbs {

	JTable jt;

	public TableListenerAbs(JTable jt) {
		this.jt = jt;
	}

	public void tableListernRag(JTable jt) {
		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("HEY HEY");
				if (jt.getRowCount() > 0 && jt.getRowCount() != -1) {
					int row = jt.getSelectedRow();
					if (row != -1) {

					}

				}

			}

		});

	}
}
