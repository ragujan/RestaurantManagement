package gui;

import Util.BasicValidator;
import Util.CreateObject;
import Util.FilterDocRagRegex;
import Util.JOP;
import Util.LoadSubTypes;
import Util.PanelRemover;
import com.toedter.calendar.JDateChooser;
import frame.*;
import frameutil.RoundedPanel;
import frameutil.ImageSizer;
import frameutil.MainTheme;
import frameutil.OptionMessage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author acer
 */
public class FRN extends javax.swing.JFrame {

	/**
	 * Creates new form NewJFrame
	 */
	public FRN() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 7, 7));

		jframeCustmize();
		this.setBackground(MainTheme.mainColor);
		roundedPanel1.setBackground(MainTheme.mainColor);
		roundedPanel2.setBackground(MainTheme.secondColor);
		textF1.setBackground(MainTheme.fourthColor);
		textF2.setBackground(MainTheme.fourthColor);
		textF3.setBackground(MainTheme.fourthColor);
		textF1.setEditable(false);
		textF2.setEditable(false);
		textF3.setEditable(false);
		textF4.setEditable(false);
		textF5.setEditable(false);
		textF6.setEditable(false);
		textF7.setEditable(false);
		customButton2.setEnabled(false);
		textF1.setForeground(MainTheme.secondColor);
		textF2.setForeground(MainTheme.secondColor);
		textF3.setForeground(MainTheme.secondColor);
		jPanel4.setBackground(MainTheme.secondColor);
		jPanel2.setBackground(MainTheme.secondColor);
		jPanel4.setEnabled(false);

		this.setForeground(MainTheme.secondColor);
		this.setVisible(true);
		jDateChooser3.setVisible(false);
		jDateChooser4.setVisible(false);
		setValidadions();

	}

	private void jframeCustmize() {
		closeLabel.setIcon(labelSetIcon("/Icons/close.png", closeLabel.getWidth() - 25, closeLabel.getHeight() - 17));
		boxLabel.setIcon(labelSetIcon("/Icons/square.png", boxLabel.getWidth() - 23, boxLabel.getHeight() - 17));
		miniLabel.setIcon(labelSetIcon("/Icons/minus.png", miniLabel.getWidth() - 20, miniLabel.getHeight() - 13));

		miniLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				setState(JFrame.ICONIFIED);
			}
		});
	}
	public String foodItemType;

	public ImageIcon labelSetIcon(String src, int w, int h) {
		ImageSizer imgSizer = new ImageSizer();
		ImageIcon i = imgSizer.overaallResizer(src, w, h);
		return i;
	}

	private void addtoFRN() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		boolean isDatesChosen = false;
		boolean invalidDateChosen = false;
		//System.out.println(sdf.format(new Date()));
		if (jDateChooser3.getDate() != null && jDateChooser4.getDate() != null) {
			isDatesChosen = true;
			long time_difference = jDateChooser3.getDate().getTime() - jDateChooser4.getDate().getTime();
			if (time_difference <= 0) {
				invalidDateChosen = true;
			}
		}
		String supId = textF4.getText();
		String foodItemId = textF1.getText();
		String qty = textF8.getText();
		String price = textF9.getText();
		String foodName = textF2.getText();
		String foodType = textF3.getText();
		String supName = textF5.getText();
		String dealerName = textF6.getText();

		if (supId.isEmpty()) {
			Message m = new Message(this, "supplier id is not choosen", "Warning");
		} else if (foodItemId.isEmpty()) {
			Message m = new Message(this, "food item id is not choosen", "Warning");
		} else if (!isDatesChosen) {
			Message m = new Message(this, "Please choose the dates", "Warning");
		} else if (qty.isEmpty()) {
			Message m = new Message(this, "Plesae select the qty", "Warning");
		} else if (price.isEmpty()) {
			Message m = new Message(this, "Please enter the buying price", "Warning");
		} else if (invalidDateChosen) {
			Message m = new Message(this, "Please select valid exp mfd dates", "Warning");
		} else {

			boolean isIdExits = false;
			for (int i = 0; i < customTable1.getRowCount(); i++) {
				if (foodItemId.equals(customTable1.getValueAt(i, 0).toString())) {
					isIdExits = true;
					break;
				}
			}
			if (isIdExits) {

//				OptionMessage om = new OptionMessage(this, "Do you want to update", "Info");
//				int getValue = om.choosevalue;
//				om.addWindowListener(new WindowListener() {
//					@Override
//					public void windowOpened(WindowEvent e) {
//					}
//
//					@Override
//					public void windowClosing(WindowEvent e) {
//						
//					}
//
//					@Override
//					public void windowClosed(WindowEvent e) {
//
//					       System.out.println("Iclosed you");
//					}
//
//					@Override
//					public void windowIconified(WindowEvent e) {
//					
//					}
//
//					@Override
//					public void windowDeiconified(WindowEvent e) {
//						
//					}
//
//					@Override
//					public void windowActivated(WindowEvent e) {
//
//					}
//
//					@Override
//					public void windowDeactivated(WindowEvent e) {
//					}
//				});
//				if (getValue == 1) {
//					//do something
//				} else {
//					//blah blah
//				}
                                OptionMessage om = new OptionMessage(this, "what do you wanna do bro", "peace") {
					@Override
					public void handleConfirm() {
						System.out.println(getChoosevalue());
				//		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
					}
					
					@Override
					public void handleCancel() {
				//		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
					}
				};
				
				System.out.println("I came to this line without waiting");
			} else {
				Vector<String> v = new Vector<String>();
				v.add(foodItemId);
				v.add(foodName);
				v.add(foodType);
				v.add(qty);
				v.add(price);
				v.add(Double.toString(Double.parseDouble(qty) * Double.parseDouble(price)));
				DefaultTableModel dftm = (DefaultTableModel) customTable1.getModel();
				dftm.addRow(v);
			}

		}
		//Date onDTDiff = sdf.parse(jDateChooser3.getDate());
		//Date offDTDiff = sdf.parse(offTime);

	}

	private void setValidadions() {

		String priceRegex = "^\\d*([,]\\d*)*([.]\\d*)?";
		String qtyRegex = "([1-9][0-9]+|[1-9])";
		new FilterDocRagRegex(textF8, qtyRegex, 10);
		new FilterDocRagRegex(textF9, priceRegex, 10);

		String dobRegex = "[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]";
		FilterDocRagRegex dob = new FilterDocRagRegex(textF10, dobRegex);
		//dob = new FilterDocRagRegex(textF5, dobRegex);
	}
              
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jToggleButton1 = new javax.swing.JToggleButton();
                jPanel6 = new javax.swing.JPanel();
                jPanel7 = new javax.swing.JPanel();
                customButton4 = new frameutil.CustomButton();
                jLabel13 = new javax.swing.JLabel();
                jLabel14 = new javax.swing.JLabel();
                jLabel15 = new javax.swing.JLabel();
                textF12 = new frameutil.TextF();
                textF13 = new frameutil.TextF();
                textF14 = new frameutil.TextF();
                textF15 = new frameutil.TextF();
                jLabel16 = new javax.swing.JLabel();
                jLabel17 = new javax.swing.JLabel();
                textF16 = new frameutil.TextF();
                jLabel18 = new javax.swing.JLabel();
                jLabel19 = new javax.swing.JLabel();
                textF17 = new frameutil.TextF();
                jDateChooser5 = new com.toedter.calendar.JDateChooser();
                textF18 = new frameutil.TextF();
                jDateChooser6 = new com.toedter.calendar.JDateChooser();
                customButton5 = new frameutil.CustomButton();
                jPanel8 = new javax.swing.JPanel();
                customButton6 = new frameutil.CustomButton();
                textF19 = new frameutil.TextF();
                jLabel20 = new javax.swing.JLabel();
                textF20 = new frameutil.TextF();
                jLabel21 = new javax.swing.JLabel();
                textF21 = new frameutil.TextF();
                jLabel22 = new javax.swing.JLabel();
                textF22 = new frameutil.TextF();
                jLabel23 = new javax.swing.JLabel();
                jPanel9 = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                customTable2 = new frameutil.CustomTable();
                roundedPanel1 = new RoundedPanel();
                roundedPanel2 = new RoundedPanel();
                jPanel1 = new javax.swing.JPanel();
                closeLabel = new javax.swing.JLabel();
                miniLabel = new javax.swing.JLabel();
                boxLabel = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                textF4 = new frameutil.TextF();
                jLabel6 = new javax.swing.JLabel();
                textF5 = new frameutil.TextF();
                jLabel7 = new javax.swing.JLabel();
                textF6 = new frameutil.TextF();
                jLabel8 = new javax.swing.JLabel();
                textF7 = new frameutil.TextF();
                jLabel5 = new javax.swing.JLabel();
                jPanel10 = new javax.swing.JPanel();
                customButton1 = new frameutil.CustomButton();
                customButton7 = new frameutil.CustomButton();
                jPanel3 = new javax.swing.JPanel();
                jPanel4 = new javax.swing.JPanel();
                customButton2 = new frameutil.CustomButton();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                textF1 = new frameutil.TextF();
                textF2 = new frameutil.TextF();
                textF3 = new frameutil.TextF();
                textF8 = new frameutil.TextF();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                textF9 = new frameutil.TextF();
                jLabel11 = new javax.swing.JLabel();
                jLabel12 = new javax.swing.JLabel();
                textF10 = new frameutil.TextF();
                jDateChooser3 = new com.toedter.calendar.JDateChooser();
                textF11 = new frameutil.TextF();
                jDateChooser4 = new com.toedter.calendar.JDateChooser();
                customButton3 = new frameutil.CustomButton();
                jPanel5 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                customTable1 = new frameutil.CustomTable();
                jPanel11 = new javax.swing.JPanel();
                customButton8 = new frameutil.CustomButton();
                jLabel26 = new javax.swing.JLabel();
                jLabel25 = new javax.swing.JLabel();
                jLabel24 = new javax.swing.JLabel();
                textF25 = new frameutil.TextF();
                textF23 = new frameutil.TextF();
                textF24 = new frameutil.TextF();

                jToggleButton1.setText("jToggleButton1");

                jPanel7.setBackground(new java.awt.Color(51, 255, 0));

                customButton4.setText("Food Item");
                customButton4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                customButton4ActionPerformed(evt);
                        }
                });

                jLabel13.setBackground(new java.awt.Color(255, 255, 255));
                jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel13.setForeground(new java.awt.Color(255, 255, 255));
                jLabel13.setText("Id");

                jLabel14.setBackground(new java.awt.Color(255, 255, 255));
                jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel14.setForeground(new java.awt.Color(255, 255, 255));
                jLabel14.setText("Name");

                jLabel15.setBackground(new java.awt.Color(255, 255, 255));
                jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel15.setForeground(new java.awt.Color(255, 255, 255));
                jLabel15.setText("Type");

                jLabel16.setBackground(new java.awt.Color(255, 255, 255));
                jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel16.setForeground(new java.awt.Color(255, 255, 255));
                jLabel16.setText("Qty");

                jLabel17.setBackground(new java.awt.Color(255, 255, 255));
                jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel17.setForeground(new java.awt.Color(255, 255, 255));
                jLabel17.setText("Price");

                jLabel18.setBackground(new java.awt.Color(255, 255, 255));
                jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel18.setForeground(new java.awt.Color(255, 255, 255));
                jLabel18.setText("Mfd");

                jLabel19.setBackground(new java.awt.Color(255, 255, 255));
                jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel19.setForeground(new java.awt.Color(255, 255, 255));
                jLabel19.setText("Exp");

                textF17.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                textF17FocusGained(evt);
                        }
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                textF17FocusLost(evt);
                        }
                });

                jDateChooser5.setBackground(new java.awt.Color(0, 102, 255));
                jDateChooser5.setForeground(new java.awt.Color(255, 255, 255));
                jDateChooser5.setIcon(null);
                jDateChooser5.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                        public void propertyChange(java.beans.PropertyChangeEvent evt) {
                                jDateChooser5PropertyChange(evt);
                        }
                });

                textF18.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                textF18FocusGained(evt);
                        }
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                textF18FocusLost(evt);
                        }
                });

                jDateChooser6.setBackground(new java.awt.Color(0, 102, 255));
                jDateChooser6.setForeground(new java.awt.Color(255, 255, 255));
                jDateChooser6.setIcon(null);
                jDateChooser6.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                        public void propertyChange(java.beans.PropertyChangeEvent evt) {
                                jDateChooser6PropertyChange(evt);
                        }
                });

                customButton5.setText("Enter FRN");
                customButton5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                customButton5ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                jPanel7.setLayout(jPanel7Layout);
                jPanel7Layout.setHorizontalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                                .addComponent(textF18, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(textF17, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(customButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(textF15, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(textF12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                                                .addComponent(jLabel14)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(textF13, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(textF16, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(338, 338, 338)
                                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(textF14, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(87, 87, 87))))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(customButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
                jPanel7Layout.setVerticalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(customButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textF13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15)
                                        .addComponent(textF14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textF16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(textF17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel19))
                                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textF18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(customButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                );

                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(
                        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jPanel6Layout.setVerticalGroup(
                        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                jPanel8.setBackground(new java.awt.Color(0, 204, 255));

                customButton6.setText("Supplier");
                customButton6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                customButton6ActionPerformed(evt);
                        }
                });

                jLabel20.setBackground(new java.awt.Color(255, 255, 255));
                jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel20.setForeground(new java.awt.Color(255, 255, 255));
                jLabel20.setText("Name");

                jLabel21.setBackground(new java.awt.Color(255, 255, 255));
                jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel21.setForeground(new java.awt.Color(255, 255, 255));
                jLabel21.setText("Dealer");

                jLabel22.setBackground(new java.awt.Color(255, 255, 255));
                jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel22.setForeground(new java.awt.Color(255, 255, 255));
                jLabel22.setText("Type");

                jLabel23.setBackground(new java.awt.Color(255, 255, 255));
                jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel23.setForeground(new java.awt.Color(255, 255, 255));
                jLabel23.setText("Id");

                javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
                jPanel8.setLayout(jPanel8Layout);
                jPanel8Layout.setHorizontalGroup(
                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(customButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addComponent(textF19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel20)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(textF20, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(textF21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(textF22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(20, 20, 20))))
                );
                jPanel8Layout.setVerticalGroup(
                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(customButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textF20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
                );

                customTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Food_ID", "Name", "Category", "Qty", "Buying Price", "Total"
                        }
                ));
                jScrollPane2.setViewportView(customTable2);

                javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
                jPanel9.setLayout(jPanel9Layout);
                jPanel9Layout.setHorizontalGroup(
                        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)
                                .addContainerGap())
                );
                jPanel9Layout.setVerticalGroup(
                        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(107, Short.MAX_VALUE))
                );

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setUndecorated(true);

                roundedPanel1.setBackground(new java.awt.Color(153, 153, 153));
                roundedPanel1.setRoundBottomLeft(7);
                roundedPanel1.setRoundBottomRight(7);
                roundedPanel1.setRoundTopLeft(7);
                roundedPanel1.setRoundTopRight(7);

                roundedPanel2.setBackground(new java.awt.Color(51, 51, 51));
                roundedPanel2.setRoundTopLeft(7);
                roundedPanel2.setRoundTopRight(7);
                roundedPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        public void mouseDragged(java.awt.event.MouseEvent evt) {
                                roundedPanel2MouseDragged(evt);
                        }
                });
                roundedPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                roundedPanel2MousePressed(evt);
                        }
                });

                jPanel1.setOpaque(false);
                jPanel1.setPreferredSize(new java.awt.Dimension(120, 25));
                jPanel1.setLayout(new java.awt.BorderLayout());

                closeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                closeLabel.setPreferredSize(new java.awt.Dimension(40, 25));
                closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                closeLabelMouseClicked(evt);
                        }
                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                                closeLabelMouseEntered(evt);
                        }
                        public void mouseExited(java.awt.event.MouseEvent evt) {
                                closeLabelMouseExited(evt);
                        }
                });
                jPanel1.add(closeLabel, java.awt.BorderLayout.LINE_END);

                miniLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                miniLabel.setPreferredSize(new java.awt.Dimension(40, 25));
                miniLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                                miniLabelMouseEntered(evt);
                        }
                        public void mouseExited(java.awt.event.MouseEvent evt) {
                                miniLabelMouseExited(evt);
                        }
                });
                jPanel1.add(miniLabel, java.awt.BorderLayout.WEST);

                boxLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                boxLabel.setPreferredSize(new java.awt.Dimension(40, 25));
                jPanel1.add(boxLabel, java.awt.BorderLayout.CENTER);

                jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText("RAG");
                jLabel1.setToolTipText("");

                javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
                roundedPanel2.setLayout(roundedPanel2Layout);
                roundedPanel2Layout.setHorizontalGroup(
                        roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                roundedPanel2Layout.setVerticalGroup(
                        roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundedPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jPanel2.setBackground(new java.awt.Color(0, 204, 255));

                jLabel6.setBackground(new java.awt.Color(255, 255, 255));
                jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel6.setForeground(new java.awt.Color(255, 255, 255));
                jLabel6.setText("Name");

                jLabel7.setBackground(new java.awt.Color(255, 255, 255));
                jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel7.setForeground(new java.awt.Color(255, 255, 255));
                jLabel7.setText("Dealer");

                jLabel8.setBackground(new java.awt.Color(255, 255, 255));
                jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel8.setForeground(new java.awt.Color(255, 255, 255));
                jLabel8.setText("Type");

                jLabel5.setBackground(new java.awt.Color(255, 255, 255));
                jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(255, 255, 255));
                jLabel5.setText("Id");

                jPanel10.setOpaque(false);
                jPanel10.setLayout(new java.awt.CardLayout());

                customButton1.setText("Supplier");
                customButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                customButton1ActionPerformed(evt);
                        }
                });
                jPanel10.add(customButton1, "card2");

                customButton7.setText("Switch");
                customButton7.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                customButton7ActionPerformed(evt);
                        }
                });
                jPanel10.add(customButton7, "card3");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(textF4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(textF5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(textF6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(textF7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(20, 20, 20))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
                );

                jPanel4.setBackground(new java.awt.Color(51, 255, 0));

                customButton2.setText("Food Item");
                customButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                customButton2ActionPerformed(evt);
                        }
                });

                jLabel2.setBackground(new java.awt.Color(255, 255, 255));
                jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(255, 255, 255));
                jLabel2.setText("Id");

                jLabel3.setBackground(new java.awt.Color(255, 255, 255));
                jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                jLabel3.setText("Name");

                jLabel4.setBackground(new java.awt.Color(255, 255, 255));
                jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                jLabel4.setText("Type");

                jLabel9.setBackground(new java.awt.Color(255, 255, 255));
                jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel9.setForeground(new java.awt.Color(255, 255, 255));
                jLabel9.setText("Qty");

                jLabel10.setBackground(new java.awt.Color(255, 255, 255));
                jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel10.setForeground(new java.awt.Color(255, 255, 255));
                jLabel10.setText("Price");

                jLabel11.setBackground(new java.awt.Color(255, 255, 255));
                jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel11.setForeground(new java.awt.Color(255, 255, 255));
                jLabel11.setText("Mfd");

                jLabel12.setBackground(new java.awt.Color(255, 255, 255));
                jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel12.setForeground(new java.awt.Color(255, 255, 255));
                jLabel12.setText("Exp");

                textF10.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                textF10FocusGained(evt);
                        }
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                textF10FocusLost(evt);
                        }
                });

                jDateChooser3.setBackground(new java.awt.Color(0, 102, 255));
                jDateChooser3.setForeground(new java.awt.Color(255, 255, 255));
                jDateChooser3.setIcon(null);
                jDateChooser3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                        public void propertyChange(java.beans.PropertyChangeEvent evt) {
                                jDateChooser3PropertyChange(evt);
                        }
                });

                textF11.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                textF11FocusGained(evt);
                        }
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                textF11FocusLost(evt);
                        }
                });

                jDateChooser4.setBackground(new java.awt.Color(0, 102, 255));
                jDateChooser4.setForeground(new java.awt.Color(255, 255, 255));
                jDateChooser4.setIcon(null);
                jDateChooser4.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                        public void propertyChange(java.beans.PropertyChangeEvent evt) {
                                jDateChooser4PropertyChange(evt);
                        }
                });

                customButton3.setText("Enter FRN");
                customButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                customButton3ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                                .addComponent(textF11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(textF10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(customButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(textF8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(textF1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                                                .addComponent(jLabel3)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(textF2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(textF9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(338, 338, 338)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                                .addComponent(textF3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(87, 87, 87))))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(customButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
                jPanel4Layout.setVerticalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(customButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addComponent(textF3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textF9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(textF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel12))
                                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(customButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                );

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                customTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Food_ID", "Name", "Category", "Qty", "Buying Price", "Total"
                        }
                ));
                jScrollPane1.setViewportView(customTable1);

                customButton8.setText("Print");

                jLabel26.setBackground(new java.awt.Color(255, 255, 255));
                jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel26.setForeground(new java.awt.Color(255, 255, 255));
                jLabel26.setText("Type");

                jLabel25.setBackground(new java.awt.Color(255, 255, 255));
                jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel25.setForeground(new java.awt.Color(255, 255, 255));
                jLabel25.setText("Name");

                jLabel24.setBackground(new java.awt.Color(255, 255, 255));
                jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                jLabel24.setForeground(new java.awt.Color(255, 255, 255));
                jLabel24.setText("Id");

                javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
                jPanel11.setLayout(jPanel11Layout);
                jPanel11Layout.setHorizontalGroup(
                        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(customButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(textF23, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel25))
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textF24, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textF25, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                );
                jPanel11Layout.setVerticalGroup(
                        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textF23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textF24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel26)
                                        .addComponent(textF25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addComponent(customButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                jPanel5Layout.setVerticalGroup(
                        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
                roundedPanel1.setLayout(roundedPanel1Layout);
                roundedPanel1Layout.setHorizontalGroup(
                        roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(roundedPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(roundedPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                roundedPanel1Layout.setVerticalGroup(
                        roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents
    int x = 0;
	int y = 0;
    private void roundedPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundedPanel2MousePressed
	    // TODO add your handling code here:
	    x = evt.getX();
	    y = evt.getY();
    }//GEN-LAST:event_roundedPanel2MousePressed

    private void roundedPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundedPanel2MouseDragged
	    // TODO add your handling code here:
	    int xx = evt.getXOnScreen();
	    int yy = evt.getYOnScreen();
	    this.setLocation(xx - x, yy - y);
    }//GEN-LAST:event_roundedPanel2MouseDragged

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
	    // TODO add your handling code here:
	    System.exit(0);
    }//GEN-LAST:event_closeLabelMouseClicked

    private void closeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseEntered
	    // TODO add your handling code here:
	    closeLabel.setOpaque(true);
	    closeLabel.setBackground(MainTheme.mainColor);
    }//GEN-LAST:event_closeLabelMouseEntered

    private void closeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseExited
	    // TODO add your handling code here:
	    closeLabel.setBackground(MainTheme.secondColor);
	    closeLabel.setOpaque(false);

    }//GEN-LAST:event_closeLabelMouseExited

    private void miniLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniLabelMouseEntered
	    // TODO add your handling code here:
	    miniLabel.setOpaque(true);
	    miniLabel.setBackground(MainTheme.mainColor);
    }//GEN-LAST:event_miniLabelMouseEntered

    private void miniLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniLabelMouseExited
	    // TODO add your handling code here:

	    miniLabel.setBackground(MainTheme.secondColor);
	    miniLabel.setOpaque(false);
    }//GEN-LAST:event_miniLabelMouseExited

        private void textF10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textF10ActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_textF10ActionPerformed

        private void customButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton4ActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_customButton4ActionPerformed

        private void textF17FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textF17FocusGained
		// TODO add your handling code here:
        }//GEN-LAST:event_textF17FocusGained

        private void textF17FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textF17FocusLost
		// TODO add your handling code here:
        }//GEN-LAST:event_textF17FocusLost

        private void jDateChooser5PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser5PropertyChange
		// TODO add your handling code here:
        }//GEN-LAST:event_jDateChooser5PropertyChange

        private void textF18FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textF18FocusGained
		// TODO add your handling code here:
        }//GEN-LAST:event_textF18FocusGained

        private void textF18FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textF18FocusLost
		// TODO add your handling code here:
        }//GEN-LAST:event_textF18FocusLost

        private void jDateChooser6PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser6PropertyChange
		// TODO add your handling code here:
        }//GEN-LAST:event_jDateChooser6PropertyChange

        private void customButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton5ActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_customButton5ActionPerformed

        private void customButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton6ActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_customButton6ActionPerformed

        private void customButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton3ActionPerformed
		// TODO add your handling code here:
		addtoFRN();
        }//GEN-LAST:event_customButton3ActionPerformed

        private void jDateChooser4PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser4PropertyChange
		// TODO add your handling code here:
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String d = sdf.format(new Date());
		if (jDateChooser4.getDate() != null) {
			textF11.setText(sdf.format(jDateChooser4.getDate()).toString());
		}
        }//GEN-LAST:event_jDateChooser4PropertyChange

        private void textF11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textF11FocusLost
		// TODO add your handling code here:
		jDateChooser4.setVisible(false);
        }//GEN-LAST:event_textF11FocusLost

        private void textF11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textF11FocusGained
		// TODO add your handling code here:
		jDateChooser4.setVisible(true);
        }//GEN-LAST:event_textF11FocusGained

        private void jDateChooser3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser3PropertyChange
		// TODO add your handling code here:
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String d = sdf.format(new Date());
		if (jDateChooser3.getDate() != null) {
			textF10.setText(sdf.format(jDateChooser3.getDate()).toString());
		}
        }//GEN-LAST:event_jDateChooser3PropertyChange

        private void textF10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textF10FocusLost
		// TODO add your handling code here:
		jDateChooser3.setVisible(false);
        }//GEN-LAST:event_textF10FocusLost

        private void textF10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textF10FocusGained
		// TODO add your handling code here:
		//click the jdateChooser to pick the date
		//or show the jDateChooser to pick the date
		jDateChooser3.setVisible(true);

		//jDateChooser3.firePropertyChange(searchText, NORMAL, NORMAL);
		//jDateChooser3.propertyChange((PropertyChangeEvent) jDateChooser3.getPropertyChangeListeners()[0]);
        }//GEN-LAST:event_textF10FocusGained

        private void customButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton2ActionPerformed
		// TODO add your handling code here:
		CreateObject.make(new FoodItem(this, this.foodItemType));
        }//GEN-LAST:event_customButton2ActionPerformed

        private void customButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton1ActionPerformed
		// TODO add your handling code here:
		CreateObject.make(new Supplier(this));
		PanelRemover.removeP(jPanel10, customButton7);
        }//GEN-LAST:event_customButton1ActionPerformed

        private void customButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton7ActionPerformed
		// TODO add your handling code here:
		PanelRemover.removeP(jPanel10, customButton1);
        }//GEN-LAST:event_customButton7ActionPerformed
	boolean emailFieldEntred = false;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FRN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FRN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FRN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FRN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				JFrame jf = new FRN();
				jf.setVisible(true);

			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel boxLabel;
        private javax.swing.JLabel closeLabel;
        private frameutil.CustomButton customButton1;
        public frameutil.CustomButton customButton2;
        private frameutil.CustomButton customButton3;
        public frameutil.CustomButton customButton4;
        private frameutil.CustomButton customButton5;
        private frameutil.CustomButton customButton6;
        private frameutil.CustomButton customButton7;
        private frameutil.CustomButton customButton8;
        public frameutil.CustomTable customTable1;
        private frameutil.CustomTable customTable2;
        private com.toedter.calendar.JDateChooser jDateChooser3;
        private com.toedter.calendar.JDateChooser jDateChooser4;
        private com.toedter.calendar.JDateChooser jDateChooser5;
        private com.toedter.calendar.JDateChooser jDateChooser6;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel14;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JLabel jLabel18;
        private javax.swing.JLabel jLabel19;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel20;
        private javax.swing.JLabel jLabel21;
        private javax.swing.JLabel jLabel22;
        private javax.swing.JLabel jLabel23;
        private javax.swing.JLabel jLabel24;
        private javax.swing.JLabel jLabel25;
        private javax.swing.JLabel jLabel26;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel10;
        private javax.swing.JPanel jPanel11;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        public javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        public javax.swing.JPanel jPanel7;
        private javax.swing.JPanel jPanel8;
        private javax.swing.JPanel jPanel9;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JToggleButton jToggleButton1;
        private javax.swing.JLabel miniLabel;
        private RoundedPanel roundedPanel1;
        private RoundedPanel roundedPanel2;
        public frameutil.TextF textF1;
        public frameutil.TextF textF10;
        public frameutil.TextF textF11;
        public frameutil.TextF textF12;
        public frameutil.TextF textF13;
        public frameutil.TextF textF14;
        public frameutil.TextF textF15;
        public frameutil.TextF textF16;
        private frameutil.TextF textF17;
        private frameutil.TextF textF18;
        public frameutil.TextF textF19;
        public frameutil.TextF textF2;
        public frameutil.TextF textF20;
        public frameutil.TextF textF21;
        public frameutil.TextF textF22;
        public frameutil.TextF textF23;
        public frameutil.TextF textF24;
        public frameutil.TextF textF25;
        public frameutil.TextF textF3;
        public frameutil.TextF textF4;
        public frameutil.TextF textF5;
        public frameutil.TextF textF6;
        public frameutil.TextF textF7;
        public frameutil.TextF textF8;
        public frameutil.TextF textF9;
        // End of variables declaration//GEN-END:variables
}
