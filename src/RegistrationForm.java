import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MyFrame extends JFrame implements ActionListener {
    private Container c;
    private JLabel title, name, mno, gender, dob, add, res;
    private JTextField tname, tmno;
    private JRadioButton male, female;
    private ButtonGroup gengp;
    private JComboBox<String> date, month, year;
    private JTextArea tadd, tout, resadd;
    private JCheckBox term;
    private JButton sub, reset;

    private String[] dates = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    private String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    private String[] years = { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" };

    public MyFrame() {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(200, 150);
        c.add(tmno);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);
        male.setBounds(200, 200, 75, 20);
        female.setBounds(275, 200, 80, 20);
        c.add(male);
        c.add(female);

        dob = new JLabel("DOB");
        dob.setBounds(100, 250, 100, 20);
        c.add(dob);
        date = new JComboBox<>(dates);
        month = new JComboBox<>(months);
        year = new JComboBox<>(years);
        date.setBounds(200, 250, 50, 20);
        month.setBounds(250, 250, 60, 20);
        year.setBounds(320, 250, 60, 20);
        c.add(date);
        c.add(month);
        c.add(year);

        add = new JLabel("Address");
        add.setBounds(100, 300, 100, 20);
        c.add(add);
        tadd = new JTextArea();
        tadd.setBounds(200, 300, 200, 75);
        c.add(tadd);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setBounds(150, 400, 250, 20);
        c.add(term);

        sub = new JButton("Submit");
        reset = new JButton("Reset");
        sub.setBounds(150, 450, 100, 20);
        reset.setBounds(270, 450, 100, 20);
        sub.addActionListener(this);
        reset.addActionListener(this);
        c.add(sub);
        c.add(reset);

        res = new JLabel("");
        res.setBounds(100, 500, 500, 25);
        c.add(res);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String gender = male.isSelected() ? "Male" : "Female";
                String dob = date.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem();
                insertIntoDatabase(tname.getText(), tmno.getText(), gender, dob, tadd.getText());
                res.setText("Registration Successfully Saved!");
            } else {
                res.setText("Please accept the terms & conditions.");
            }
        } else if (e.getSource() == reset) {
            tname.setText("");
            tmno.setText("");
            tadd.setText("");
            res.setText("");
            term.setSelected(false);
        }
    }

    private void insertIntoDatabase(String name, String mobile, String gender, String dob, String address) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "password");
            String query = "INSERT INTO users (name, mobile, gender, dob, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, mobile);
            stmt.setString(3, gender);
            stmt.setString(4, dob);
            stmt.setString(5, address);
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
 }
 
