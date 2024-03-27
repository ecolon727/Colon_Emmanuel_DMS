//import necessary utilities
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


/*
Emmanuel Colon
Software Development 1
March 27, 2024
*/

public class myGUI extends JFrame {

    // Jcomponents, universal variables
    private JPanel MainPanel, panelButtons, outputPanel;
     private JLabel tblName, jlConsole, nameLbl, idLbl, genderLbl, ageLbl, raceLbl, tradeLbl;;
    private JTextField jtfUserFile, idTxt, nameTxt, genderTxt, ageTxt, raceTxt, tradeTxt, jtfTblMessage;
    private JButton updNameBtn, tradeOnBtn, tradeOffBtn, deleteIdBtn, deleteNameBtn, updGenderBtm, updAgeBtn, updRaceBtn, updTradeBtn;;
    private JTable myTable;
    private int checky, tableId, age;
    private String name, gender, race, trade;
    Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

    // connects to Bionis database containing colony9 table
    public void selectAll() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bionis", "root", "apple123");
            stat = con.createStatement();
            rs = stat.executeQuery("SELECT * from colony9");
            myTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Create GUI
    public myGUI() {
        setContentPane(MainPanel);
        setTitle("Affinity Chart");
        setSize(850, 550);
        setVisible(true);
        selectAll();


        // Buttons with action listeners

        // deletes selected Id's row
        deleteIdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "Delete from colony9 where tableId = " + idTxt.getText();
                    Statement dlt = con.createStatement();

                    //check if row is found
                    checky = dlt.executeUpdate(sql);
                    if(checky > 0) {
                        jtfTblMessage.setText("Id deleted");
                    }
                    else if (checky == 0) {
                        jtfTblMessage.setText("Id not found");
                    }
                    else {
                        jtfTblMessage.setText("Error");
                    }
                    // clear all texts
                    idTxt.setText("");
                    nameTxt.setText("");
                    genderTxt.setText("");
                    ageTxt.setText("");
                    raceTxt.setText("");
                    tradeTxt.setText("");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
                selectAll();
            }
        });


        // delete selected Name's row
        deleteNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "Delete from colony9 where name = '" + nameTxt.getText() + "'";
                    Statement dlt = con.createStatement();

                    checky = dlt.executeUpdate(sql);
                    if(checky > 0) {
                        jtfTblMessage.setText("Name deleted");
                    }
                    else if (checky == 0) {
                        jtfTblMessage.setText("Name not found");
                    }
                    else {
                        jtfTblMessage.setText("Error");
                    }
                    idTxt.setText("");
                    nameTxt.setText("");
                    genderTxt.setText("");
                    ageTxt.setText("");
                    raceTxt.setText("");
                    tradeTxt.setText("");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
                selectAll();
            }
        });


        // update to new name with selected Id
        updNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "update colony9 set name = '" + nameTxt.getText() + "'" + " where tableId = " + idTxt.getText();
                    Statement upd = con.createStatement();

                    checky = upd.executeUpdate(sql);

                    if(checky > 0) {
                        jtfTblMessage.setText("Name updated");
                    }
                    else if (checky == 0) {
                        jtfTblMessage.setText("Name not found");
                    }
                    else {
                        jtfTblMessage.setText("Error");
                    }
                    idTxt.setText("");
                    nameTxt.setText("");
                    genderTxt.setText("");
                    ageTxt.setText("");
                    raceTxt.setText("");
                    tradeTxt.setText("");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
                selectAll();
            }
        });


        //update to new gender with selected Id
        updGenderBtm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "update colony9 set gender = '" + genderTxt.getText() + "'" + " where tableId = " + idTxt.getText();
                    Statement upd = con.createStatement();

                    checky = upd.executeUpdate(sql);

                    if(checky > 0) {
                        jtfTblMessage.setText("Gender updated");
                    }
                    else if (checky == 0) {
                        jtfTblMessage.setText("Gender not found");
                    }
                    else {
                        jtfTblMessage.setText("Error");
                    }
                    idTxt.setText("");
                    nameTxt.setText("");
                    genderTxt.setText("");
                    ageTxt.setText("");
                    raceTxt.setText("");
                    tradeTxt.setText("");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
                selectAll();
            }
        });


        // update new age with selected Id
        updAgeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "update colony9 set age = '" + ageTxt.getText() + "'" + " where tableId = " + idTxt.getText();
                    Statement upd = con.createStatement();

                    checky = upd.executeUpdate(sql);

                    if(checky > 0) {
                        jtfTblMessage.setText("Age updated");
                    }
                    else if (checky == 0) {
                        jtfTblMessage.setText("Age not found");
                    }
                    else {
                        jtfTblMessage.setText("Error");
                    }
                    idTxt.setText("");
                    nameTxt.setText("");
                    genderTxt.setText("");
                    ageTxt.setText("");
                    raceTxt.setText("");
                    tradeTxt.setText("");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
                selectAll();
            }
        });


        // update new race with selected Id
        updRaceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "update colony9 set race = '" + raceTxt.getText() + "'" + " where tableId = " + idTxt.getText();
                    Statement upd = con.createStatement();

                    checky = upd.executeUpdate(sql);

                    if(checky > 0) {
                        jtfTblMessage.setText("Race updated");
                    }
                    else if (checky == 0) {
                        jtfTblMessage.setText("Race not found");
                    }
                    else {
                        jtfTblMessage.setText("Error");
                    }
                    idTxt.setText("");
                    nameTxt.setText("");
                    genderTxt.setText("");
                    ageTxt.setText("");
                    raceTxt.setText("");
                    tradeTxt.setText("");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
                selectAll();
            }
        });


        // update to new trade with selected Id
        updTradeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "update colony9 set trade = '" + tradeTxt.getText() + "'" + " where tableId = " + idTxt.getText();
                    Statement upd = con.createStatement();

                    checky = upd.executeUpdate(sql);

                    if(checky > 0) {
                        jtfTblMessage.setText("Trade updated");
                    }
                    else if (checky == 0) {
                        jtfTblMessage.setText("Trade not found");
                    }
                    else {
                        jtfTblMessage.setText("Error");
                    }
                    idTxt.setText("");
                    nameTxt.setText("");
                    genderTxt.setText("");
                    ageTxt.setText("");
                    raceTxt.setText("");
                    tradeTxt.setText("");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
                selectAll();
            }
        });


        // sets entire trade column to "on"
        tradeOnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "update colony9 set trade = 'on'";
                    Statement upd = con.createStatement();

                    checky = upd.executeUpdate(sql);

                    idTxt.setText("");
                    nameTxt.setText("");
                    genderTxt.setText("");
                    ageTxt.setText("");
                    raceTxt.setText("");
                    tradeTxt.setText("");

                    jtfTblMessage.setText("All trades set on");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
                selectAll();
            }
        });


        //sets entire trade column to off
        tradeOffBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "update colony9 set trade = 'off'";
                    Statement upd = con.createStatement();

                    checky = upd.executeUpdate(sql);

                    idTxt.setText("");
                    nameTxt.setText("");
                    genderTxt.setText("");
                    ageTxt.setText("");
                    raceTxt.setText("");
                    tradeTxt.setText("");

                    jtfTblMessage.setText("All trades set off");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
                selectAll();
            }
        });


    }


    //activate GUI
    public static void main(String[] args) {
        myGUI xc1Gui = new myGUI();
    }

}