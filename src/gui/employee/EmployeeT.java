package gui.employee;

import gui.employee.Server;
import Util.LoadSubTypes;
import Util.LoadTables;
import Util.SearchTable;
import frameutil.ComboBox;
import frameutil.RoundedPanel;
import frameutil.ImageSizer;
import frameutil.MainTheme;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.MySql;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author acer
 */
public class EmployeeT extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EmployeeT() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 7, 7));

        jframeCustmize();
        this.setBackground(MainTheme.mainColor);
        roundedPanel1.setBackground(MainTheme.mainColor);
        roundedPanel2.setBackground(MainTheme.secondColor);

        this.setForeground(MainTheme.secondColor);
        jPanel2.setBackground(MainTheme.fourthColor);
        loadTable();
        loadCombos();

        this.tableListernRag();
        this.thiset = this;
        jPanel5.setBackground(MainTheme.thirdColor);
                employeeMenuBar1.foo(this);

    }

    public EmployeeT(Chef c) {
        this();
        this.chef = c;
        this.isUpdateStatus = true;
        otherFramesInvolved = true;
        comboBox1.setSelectedItem("Chef");
        comboBox1.setEnabled(false);
        isChefInvolved = true;
        otherFrame = c;
    }

    public EmployeeT(Manager c) {
        this();
        this.manager = c;
        this.isUpdateStatus = true;
        otherFramesInvolved = true;
        comboBox1.setSelectedItem("Manager");
        comboBox1.setEnabled(false);
        isMangerInvolved = true;
        otherFrame = c;
    }

    public EmployeeT(Server c) {
        this();
        this.server = c;
        this.isUpdateStatus = true;
        otherFramesInvolved = true;
        comboBox1.setSelectedItem("Server");
        comboBox1.setEnabled(false);
        isServerInvolved = true;
        otherFrame = c;
    }

    public EmployeeT(Cleaner c) {
        this();
        this.cleaner = c;
        this.isUpdateStatus = true;
        otherFramesInvolved = true;
        comboBox1.setSelectedItem("Cleaner");
        comboBox1.setEnabled(false);
        isCleanerInvolved = true;
        otherFrame = c;
    }

    public EmployeeT(Bartender c) {
        this();
        this.bartender = c;
        this.isUpdateStatus = true;
        otherFramesInvolved = true;
        comboBox1.setSelectedItem("Bartender");
        comboBox1.setEnabled(false);
        isBartenderInvolved = true;
        otherFrame = c;
    }

    public EmployeeT(Cashier c) {
        this();
        this.cashier = c;
        this.isUpdateStatus = true;
        otherFramesInvolved = true;
        comboBox1.setSelectedItem("Cashier");
        comboBox1.setEnabled(false);
        isCashierInvolved = true;
        otherFrame = c;
    }

    public EmployeeT(EmployeeSalary c) {
        this();
        this.es = c;
        this.isUpdateStatus = true;
        otherFramesInvolved = true;
        otherFrame = c;
        isEmpSalaryInvolved = true;
    }

    public EmployeeT(EmployeeWorkingHours c) {
        this();
        this.ewh = c;
        this.isUpdateStatus = true;
        otherFramesInvolved = true;
        otherFrame = c;
        isEmpWokringHoursInvolved = true;
    }
    boolean isUpdateStatus = false;
    boolean isChefInvolved = false;
    boolean isMangerInvolved = false;
    boolean isServerInvolved = false;
    boolean isCleanerInvolved = false;
    boolean isBartenderInvolved = false;
    boolean isCashierInvolved = false;
    boolean isEmpSalaryInvolved = false;
    boolean isEmpWokringHoursInvolved = false;
    boolean otherFramesInvolved = false;
    JFrame otherFrame;
    EmployeeT thiset;
    Chef chef;
    Manager manager;
    Server server;
    Cleaner cleaner;
    Bartender bartender;
    Cashier cashier;
    EmployeeSalary es;
    EmployeeWorkingHours ewh;
    String loadTableQuery;
    String[] colnames = {"employee_id", "employee_name", "employee_type_name", "employee_contact", "employee_email", "street_1", "city_name", "gender_name", "joined_date", "DOB"};

    private void loadQuery() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("employee");
        al.add("gender,employee");
        al.add("address,employee");
        al.add("city,address");
        al.add("employee_type,employee");
        SearchTable st = new SearchTable(al);
        this.loadTableQuery = st.getTableQuery();
        //System.out.println(this.loadTableQuery);

    }

    public void loadTable() {
        loadQuery();
        String sort = "ORDER BY `employee_name` ASC";

        StringBuilder stringquerybuild = new StringBuilder();
        stringquerybuild.append(this.loadTableQuery).toString();
        stringquerybuild.append(sort).toString();
        String query = stringquerybuild.toString();

        LoadTables lt = new LoadTables(customTable2, query, this.colnames);
    }
    String searchText;
    String seachcontact;
    String searchemail;

    public void advancedSearch() {
        String name = textF1.getText();
        boolean isNameInvolved = false;
        String contact = textF2.getText();
        boolean isContactIvolved = false;
        String email = textF3.getText();
        boolean isEmailInvolved = false;
        String sort = comboBox2.getSelectedItem().toString();
        String emptype = comboBox1.getSelectedItem().toString();

        StringBuilder stringquerybuild = new StringBuilder();
        StringBuilder whereQueryBuilder = new StringBuilder();
        Vector<String> v = new Vector<String>();
        boolean queriesInvolved = false;

        String sortQuery = "";
        String whereQuery = "";
        if (sort.equals("NAME A-Z")) {
            sortQuery = "ORDER BY `employee`.`employee_name` ASC";
        } else if (sort.equals("NAME Z-A")) {
            sortQuery = "ORDER BY `employee`.`employee_name` DESC";
        } else if (sort.equals("EMAIL A-Z")) {
            sortQuery = "ORDER BY `employee`.`employee_name` DESC";
        } else if (sort.equals("EMAIL Z-A")) {
            sortQuery = "ORDER BY `employee`.`employee_name` DESC";
        } else if (sort.equals("GENDER M")) {
            sortQuery = "AND `gender_name`='Male'";
        } else if (sort.equals("GENDER F")) {
            sortQuery = "AND `gender_name`='Female'";
        }
        if (!name.isEmpty()) {
            v.add("`employee_name` LIKE '%" + name + "%' ");
            queriesInvolved = true;
        }
        if (!contact.isEmpty()) {
            v.add("`employee_contact` LIKE '%" + contact + "%' ");
            queriesInvolved = true;
        }

        if (!email.isEmpty()) {
            v.add("`employee_email` LIKE '%" + email + "%' ");
            queriesInvolved = true;
        }
        if (!emptype.equals("Select employee_type")) {
            v.add("`employee_type_name` = '" + emptype + "' ");
            queriesInvolved = true;
        }
        if (queriesInvolved) {
            whereQueryBuilder.append("where ");
        }
        for (int i = 0; i < v.size(); i++) {
            //System.out.println("vectors are " + v.get(i));

            whereQueryBuilder.append("");
            whereQueryBuilder.append(v.get(i));

            if (i != v.size() - 1) {
                whereQueryBuilder.append("AND ");
            }
        }
        //System.out.println("where query is " + whereQueryBuilder);
        stringquerybuild.append(this.loadTableQuery);
        stringquerybuild.append(whereQueryBuilder);
        stringquerybuild.append(sortQuery);
        String query = stringquerybuild.toString();
        //System.out.println("where query is " + whereQueryBuilder);
        LoadTables lt = new LoadTables(customTable2, query, this.colnames);
    }

    public void advancedSearch(String name, String contact, String email) {

        boolean isNameInvolved = false;

        boolean isContactIvolved = false;

        boolean isEmailInvolved = false;
        String sort = comboBox2.getSelectedItem().toString();
        String emptype = comboBox1.getSelectedItem().toString();

        StringBuilder stringquerybuild = new StringBuilder();
        StringBuilder whereQueryBuilder = new StringBuilder();
        Vector<String> v = new Vector<String>();
        boolean queriesInvolved = false;

        String sortQuery = "";
        String whereQuery = "";
        if (sort.equals("NAME A-Z")) {
            sortQuery = "ORDER BY `employee`.`employee_name` ASC";
        } else if (sort.equals("NAME Z-A")) {
            sortQuery = "ORDER BY `employee`.`employee_name` DESC";
        } else if (sort.equals("EMAIL A-Z")) {
            sortQuery = "ORDER BY `employee`.`employee_name` DESC";
        } else if (sort.equals("EMAIL Z-A")) {
            sortQuery = "ORDER BY `employee`.`employee_name` DESC";
        } else if (sort.equals("GENDER M")) {
            sortQuery = "AND `gender_name`='Male'";
        } else if (sort.equals("GENDER F")) {
            sortQuery = "AND `gender_name`='Female'";
        }
        if (!name.isEmpty()) {
            v.add("`employee_name` LIKE '%" + name + "%' ");
            queriesInvolved = true;
        }
        if (!contact.isEmpty()) {
            v.add("`employee_contact` LIKE '%" + contact + "%' ");
            queriesInvolved = true;
        }

        if (!email.isEmpty()) {
            v.add("`employee_email` LIKE '%" + email + "%' ");
            queriesInvolved = true;
        }
        if (!emptype.equals("Select employee_type")) {
            v.add("`employee_type_name` = '" + emptype + "' ");
            queriesInvolved = true;
        }
        if (queriesInvolved) {
            whereQueryBuilder.append("where ");
        }
        for (int i = 0; i < v.size(); i++) {
            //System.out.println("vectors are " + v.get(i));

            whereQueryBuilder.append("");
            whereQueryBuilder.append(v.get(i));

            if (i != v.size() - 1) {
                whereQueryBuilder.append("AND ");
            }
        }
        //System.out.println("where query is " + whereQueryBuilder);
        stringquerybuild.append(this.loadTableQuery);
        stringquerybuild.append(whereQueryBuilder);
        stringquerybuild.append(sortQuery);
        String query = stringquerybuild.toString();
        //System.out.println("where query is " + whereQueryBuilder);
        LoadTables lt = new LoadTables(customTable2, query, this.colnames);

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

    public ImageIcon labelSetIcon(String src, int w, int h) {
        ImageSizer imgSizer = new ImageSizer();
        ImageIcon i = imgSizer.overaallResizer(src, w, h);
        return i;
    }

    private void loadCombos() {

        new LoadSubTypes().loadTypeIns(comboBox1, "employee_type");

    }

    public void tableListernRag() {
        customTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = customTable2.getSelectedRow();
                if (row != -1 && isUpdateStatus) {
                    String id = customTable2.getValueAt(row, 0).toString();
                    String name = customTable2.getValueAt(row, 1).toString();
                    String emptype = customTable2.getValueAt(row, 2).toString();
                    String contact = customTable2.getValueAt(row, 3).toString();
                    String email = customTable2.getValueAt(row, 4).toString();
                    String gender = customTable2.getValueAt(row, 7).toString();
                    String dob = customTable2.getValueAt(row, 9).toString();
                    String city = customTable2.getValueAt(row, 6).toString();
                    ArrayList<String> al = new ArrayList<String>();
                    String whereQuery;
                    SearchTable st;

                    al.add("employee");
                    al.add("address,employee");
                    al.add("city,address");
                    st = new SearchTable(al);
                    whereQuery = st.getTableQuery() + " WHERE `employee`.`employee_id`='" + id + "'";

                    try {

                        ResultSet rs = MySql.sq(whereQuery);
                        rs.next();
                        String add1 = rs.getString("street_1");
                        String add2 = rs.getString("street_2");
                        HashMap<String, String> hm = new HashMap<String, String>();
                        hm.put("id", id);
                        hm.put("name", name);
                        hm.put("type", emptype);
                        hm.put("contact", contact);
                        hm.put("email", email);
                        hm.put("add1", add1);
                        hm.put("add2", add2);
                        hm.put("city", city);
                        hm.put("gender", gender);
                        hm.put("dob", dob);

                        if (isChefInvolved) {
                            chef.textF1.setText(name);

                            chef.textF3.setText(email);
                            chef.setEnabled(true);
                            chef.empId = id;
                            thiset.dispose();
                        } else if (isMangerInvolved) {
                            manager.textF1.setText(name);

                            manager.textF3.setText(email);
                            manager.setEnabled(true);
                            manager.empId = id;
                            thiset.dispose();
                        } else if (isServerInvolved) {
                            server.textF1.setText(name);

                            server.textF3.setText(email);
                            server.setEnabled(true);
                            server.empId = id;
                            thiset.dispose();
                        } else if (isCleanerInvolved) {
                            cleaner.textF1.setText(name);

                            cleaner.textF3.setText(email);
                            cleaner.setEnabled(true);
                            cleaner.empId = id;
                            thiset.dispose();
                        } else if (isBartenderInvolved) {
                            bartender.textF1.setText(name);

                            bartender.textF3.setText(email);
                            bartender.setEnabled(true);
                            bartender.empId = id;
                            thiset.dispose();
                        } else if (isCashierInvolved) {
                            cashier.textF1.setText(name);

                            cashier.textF3.setText(email);
                            cashier.setEnabled(true);
                            cashier.empId = id;
                            thiset.dispose();
                        } else if (isEmpSalaryInvolved) {
                            String salaryLastPaidDate = "";
                              long totalWorkingHours = 0;
                            rs = MySql.sq("SELECT * FROM `employee_salary` WHERE `employee_id`='" + id + "' ORDER BY `paid_date` ASC");
                            ResultSet salaryrs = MySql.sq("SELECT * FROM `employee_salary` WHERE `employee_id`='" + id + "' ");
                            if (rs.next()) {
                                while (salaryrs.next()) {
                                    salaryLastPaidDate = salaryrs.getString("paid_date");
                                }
                                rs = MySql.sq("SELECT * FROM `employee_working_hours` WHERE `employee_id`='" + id + "' AND `working_hours_on` > '" + salaryLastPaidDate + "'  ");
                                ResultSet emphours = MySql.sq("SELECT * FROM `employee_working_hours` WHERE `employee_id`='" + id + "' AND `working_hours_on` > '" + salaryLastPaidDate + "' ");
                                //AND `working_hours_on` > '"+salaryLastPaidDate+"'

                                Date empWorkingHoursOn;
                                Date empWorkingHoursOff;
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                              
                                if (rs.next()) {
                                    while (emphours.next()) {
                                        empWorkingHoursOn = sdf.parse(rs.getString("working_hours_on"));
                                        empWorkingHoursOff = sdf.parse(rs.getString("working_hours_off"));

                                        long dateDiff = empWorkingHoursOff.getTime() - empWorkingHoursOn.getTime();
                                        long hourDiff = dateDiff / (1000 * 60 * 60);
                                        totalWorkingHours += hourDiff;
                                    }

                                }
                            }

                            es.empType = emptype;
                            es.empName = name;
                            es.textF8.setText(id);
                            es.textF6.setText(name);
                            es.textF9.setText(emptype);
                            es.textF12.setText(Long.toString(totalWorkingHours));

                            es.textF7.setText(email);
                            thiset.dispose();
                        } else if (isEmpWokringHoursInvolved) {
                            ewh.textF8.setText(id);
                            ewh.textF6.setText(name);
                            ewh.textF9.setText(emptype);
                            ewh.textF7.setText(email);
                            thiset.dispose();
                        } else {
                            Employee emp = new Employee(thiset, hm);
                            isUpdateStatus = false;
                            thiset.dispose();
                        }

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(EmployeeT.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(EmployeeT.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(EmployeeT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        roundedPanel1 = new RoundedPanel();
        roundedPanel2 = new RoundedPanel();
        jPanel1 = new javax.swing.JPanel();
        closeLabel = new javax.swing.JLabel();
        miniLabel = new javax.swing.JLabel();
        boxLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        customTable2 = new frameutil.CustomTable();
        customButton2 = new frameutil.CustomButton();
        jPanel3 = new javax.swing.JPanel();
        customButton1 = new frameutil.CustomButton();
        customButton3 = new frameutil.CustomButton();
        jPanel5 = new javax.swing.JPanel();
        textF1 = new frameutil.TextF();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textF2 = new frameutil.TextF();
        jLabel4 = new javax.swing.JLabel();
        textF3 = new frameutil.TextF();
        jLabel5 = new javax.swing.JLabel();
        comboBox2 = new frameutil.ComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        customButton4 = new frameutil.CustomButton();
        jPanel6 = new javax.swing.JPanel();
        comboBox1 = new frameutil.ComboBox<>();
        employeeMenuBar1 = new frameutil.EmployeeMenuBar();

        jToggleButton1.setText("jToggleButton1");

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

        customTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "E_Id", "Name", "E_Type", "Contact", "Email", "Ad_Line1", "City", "Gender", "Joined", "DOB"
            }
        ));
        customTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(customTable2);
        if (customTable2.getColumnModel().getColumnCount() > 0) {
            customTable2.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );

        customButton2.setText("Insert New");
        customButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton2ActionPerformed(evt);
            }
        });

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.CardLayout());

        customButton1.setText("Update Mode");
        customButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(customButton1, "card2");

        customButton3.setText("View Mode");
        customButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(customButton3, "card3");

        textF1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textF1KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contact");

        textF2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textF2KeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");

        textF3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textF3KeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Employee");

        comboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAME A-Z", "NAME Z-A", "EMAIL A-Z", "EMAIL Z-A", "GENDER M", "GENDER F" }));
        comboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBox2ItemStateChanged(evt);
            }
        });

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.CardLayout());

        customButton4.setText("Clear");
        customButton4.setStyle(frameutil.CustomButton.ButtonStyle.SECONDARY);
        customButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(customButton4, "card2");

        jPanel6.setLayout(new java.awt.CardLayout());

        comboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBox1ItemStateChanged(evt);
            }
        });
        jPanel6.add(comboBox1, "card2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(textF1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textF2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textF3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(employeeMenuBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeMenuBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        //  thiset.dispose();
        if (otherFramesInvolved) {
            otherFrame.setEnabled(true);
            thiset.dispose();
        } else {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);
        }
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

        private void customButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton2ActionPerformed
            // TODO add your handling code here:
            Employee e = new Employee(this);
            e.setVisible(true);

        }//GEN-LAST:event_customButton2ActionPerformed

        private void customButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton1ActionPerformed
            // TODO add your handling code here:
            isUpdateStatus = true;
            jPanel3.removeAll();
            jPanel3.add(customButton3);
            jPanel3.repaint();
            jPanel3.revalidate();
        }//GEN-LAST:event_customButton1ActionPerformed

        private void customButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton3ActionPerformed
            // TODO add your handling code here:

            isUpdateStatus = false;
            jPanel3.removeAll();
            jPanel3.add(customButton1);
            jPanel3.repaint();
            jPanel3.revalidate();

        }//GEN-LAST:event_customButton3ActionPerformed
    ComboBox<String> cb;
        private void customButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButton4ActionPerformed
            // TODO add your handling code here:

            EmployeeT et = new EmployeeT();
            et.setVisible(true);
            this.dispose();


        }//GEN-LAST:event_customButton4ActionPerformed

        private void textF1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textF1KeyTyped
            // TODO add your handling code here:
            String name = textF1.getText() + evt.getKeyChar();
            String contact = textF2.getText();
            String email = textF3.getText();
            advancedSearch(name, contact, email);
        }//GEN-LAST:event_textF1KeyTyped

        private void textF2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textF2KeyTyped
            // TODO add your handling code here:
            String name = textF1.getText();
            String contact = textF2.getText() + evt.getKeyChar();
            String email = textF3.getText();
            advancedSearch(name, contact, email);
        }//GEN-LAST:event_textF2KeyTyped

        private void textF3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textF3KeyTyped
            // TODO add your handling code here:
            String name = textF1.getText();
            String contact = textF2.getText();
            String email = textF3.getText() + evt.getKeyChar();
            advancedSearch(name, contact, email);
        }//GEN-LAST:event_textF3KeyTyped

        private void comboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox1ItemStateChanged
            // TODO add your handling code here:
            advancedSearch();
        }//GEN-LAST:event_comboBox1ItemStateChanged

        private void comboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox2ItemStateChanged
            // TODO add your handling code here:
            advancedSearch();
        }//GEN-LAST:event_comboBox2ItemStateChanged
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
            java.util.logging.Logger.getLogger(EmployeeT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

                JFrame jf = new EmployeeT();
                jf.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel boxLabel;
    private javax.swing.JLabel closeLabel;
    private frameutil.ComboBox<String> comboBox1;
    private frameutil.ComboBox<String> comboBox2;
    private frameutil.CustomButton customButton1;
    private frameutil.CustomButton customButton2;
    private frameutil.CustomButton customButton3;
    private frameutil.CustomButton customButton4;
    private frameutil.CustomTable customTable2;
    private frameutil.EmployeeMenuBar employeeMenuBar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel miniLabel;
    private RoundedPanel roundedPanel1;
    private RoundedPanel roundedPanel2;
    private frameutil.TextF textF1;
    private frameutil.TextF textF2;
    private frameutil.TextF textF3;
    // End of variables declaration//GEN-END:variables
}
