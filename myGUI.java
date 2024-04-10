import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Pattern;


/**
 * The GUI interface of the database.
 * <p>
 *     Declares all components and methods for the GUI.
 * </p>
 * @author Emmanuel Colon
 *
*/
public class myGUI extends JFrame {
    private JPanel MainPanel, panelButtons, outputPanel;
     private JLabel tblName, jlConsole, nameLbl, idLbl, genderLbl, ageLbl, raceLbl, tradeLbl;;
    private JTextField jtfUserFile, idTxt, nameTxt, genderTxt, ageTxt, raceTxt, tradeTxt, jtfTblMessage;
    private JButton updNameBtn, tradeOnBtn, tradeOffBtn, deleteIdBtn, deleteNameBtn, updGenderBtm, updAgeBtn, updRaceBtn, updTradeBtn;;
    private JTable myTable;
    private JButton printScreenBtn;
    private int checky, tableId, age;
    private String name, gender, race, trade;
    Connection con = null;
    Statement stat = null;
    ResultSet rs = null;


    /**
     * Displays all the database table data.
     * <p>
     *     Connects program to database and displays its contents.
     * </p>
     * @exception SQLException to catch SQL input errors
     */
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


    /**
     * Clears all user input text fields of the GUI.
     * <p>
     *     Cleared text fields allow for
     *     swift subsequent user input.
     * </p>
     */
    public void clearAllText() {
        idTxt.setText("");
        nameTxt.setText("");
        genderTxt.setText("");
        ageTxt.setText("");
        raceTxt.setText("");
        tradeTxt.setText("");
    }


    /**
     * The GUI constructor.
     * <p>
     *     Sets JFrames, buttons and their methods.
     * </p>
     */
    public myGUI() {
        setContentPane(MainPanel);
        setTitle("Affinity Chart");
        setSize(850, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        deleteIdBtn.addActionListener(new ActionListener() {
            /**
             * Deletes the tableId's row that the user selected.
             * @param evt sets the event to be processed.
             * @exception SQLException displays SQL error messages.
             */
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
                    clearAllText();
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    clearAllText();
                    jtfTblMessage.setText("Incorrect Input for tableId");
                }
                selectAll();
            }
        });


        deleteNameBtn.addActionListener(new ActionListener() {
            /**
             * Deletes the name's row that the user selected.
             * @param evt sets the event to be processed.
             * @exception SQLException displays SQL error messages.
             */
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
                    clearAllText();
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    clearAllText();
                    jtfTblMessage.setText("Incorrect Input for name");
                }
                selectAll();
            }
        });


        updNameBtn.addActionListener(new ActionListener() {
            /**
             * Updates the user-selected name.
             * @param evt sets the event to be processed.
             * @exception SQLException displays SQL error messages.
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String userInput = nameTxt.getText();

                    // Only allows alphatebical letters into a name
                    if(Pattern.matches("[a-zA-Z]+",userInput)) {

                        String sql = "update colony9 set name = '" + userInput + "'" + " where tableId = " + idTxt.getText();
                        Statement upd = con.createStatement();

                        checky = upd.executeUpdate(sql);
                        if (checky > 0) {
                            jtfTblMessage.setText("Name updated");
                        } else if (checky == 0) {
                            jtfTblMessage.setText("Name not found");
                        } else {
                            jtfTblMessage.setText("Error");
                        }

                    }
                    else {
                        jtfTblMessage.setText("Incorrect Input for name");
                    }
                    clearAllText();
                }
                catch(SQLException e) {
                    // Repetitive checks to ensure all inputs are captured.
                    e.printStackTrace();
                    clearAllText();
                    jtfTblMessage.setText("Incorrect Input for name");
                }
                selectAll();
            }
        });


        updGenderBtm.addActionListener(new ActionListener() {
            /**
             * Updates the user-selected gender.
             * @param evt sets the event to be processed.
             * @exception SQLException displays SQL error messages.
             */
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
                    clearAllText();
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    clearAllText();
                    jtfTblMessage.setText("Incorrect Input for gender");
                }
                selectAll();
            }
        });


        updAgeBtn.addActionListener(new ActionListener() {
            /**
             * Updates the user-selected age.
             * @param evt sets the event to be processed.
             * @exception SQLException displays SQL error messages.
             */
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
                    clearAllText();
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    clearAllText();
                    jtfTblMessage.setText("Incorrect Input for age");
                }
                selectAll();
            }
        });


        updRaceBtn.addActionListener(new ActionListener() {
            /**
             * Updates the user-selected race.
             * @param evt sets the event to be processed.
             * @exception SQLException displays SQL error messages.
             */
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
                    clearAllText();
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    clearAllText();
                    jtfTblMessage.setText("Incorrect Input for race");
                }
                selectAll();
            }
        });


        updTradeBtn.addActionListener(new ActionListener() {
            /**
             * Updates the user-selected trade.
             * @param evt sets the event to be processed.
             * @exception SQLException displays SQL error messages.
             */
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
                    clearAllText();
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    clearAllText();
                    jtfTblMessage.setText("Incorrect Input for trade");
                }
                selectAll();
            }
        });


        tradeOnBtn.addActionListener(new ActionListener() {
            /**
             * Sets entire trade column to "on"
             * @param evt sets the event to be processed.
             * @exception SQLException displays SQL error messages.
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "update colony9 set trade = 'on'";
                    Statement upd = con.createStatement();

                    checky = upd.executeUpdate(sql);
                    clearAllText();

                    jtfTblMessage.setText("All trades set on");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    clearAllText();
                    jtfTblMessage.setText("Incorrect Input");
                }
                selectAll();
            }
        });


        tradeOffBtn.addActionListener(new ActionListener() {
            /**
             * Sets entire trade column to "off"
             * @param evt sets the event to be processed.
             * @exception SQLException catches any SQL exceptions and displays error messages.
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    String sql = "update colony9 set trade = 'off'";
                    Statement upd = con.createStatement();

                    checky = upd.executeUpdate(sql);
                    clearAllText();

                    jtfTblMessage.setText("All trades set off");
                }
                catch(SQLException e) {
                    e.printStackTrace();
                    clearAllText();
                    jtfTblMessage.setText("Incorrect Input");
                }
                selectAll();
            }
        });


        printScreenBtn.addActionListener(new ActionListener() {
            /**
             * prints Database contents to screen
             * @param evt sets the event to be processed.
             * @exception SQLException catches any SQL exceptions and displays error messages.
             */
            @Override
            public void actionPerformed(ActionEvent evt) {
                selectAll();
                clearAllText();
            }
        });
    }


    /**
     * Main: activates the GUI and connects to MySQL database.
     * @param args declaring the GUI
     */
    public static void main(String[] args) {
        myGUI xc1Gui = new myGUI();
    }

}