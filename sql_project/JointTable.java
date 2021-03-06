// David Zhao, CISC 3810, SQL project, Joint Table
package sqlproject;

import javax.swing.table.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class JointTable extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public JointTable() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "StudentID", "FirstName", "LastName", "CourseNumber", "GPA", "Term", "Year"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Enter a number");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Joint Table");

        jLabel2.setText("1. List all the students with the course number and GPA");

        jLabel3.setText("3. List all the students who have GPA greater than 3.0 with the course number ");

        jLabel4.setText("2. List all the students who enrolled in Spring semester");

        jLabel5.setText("4. List all the students who enrolled in 3000 level courses");

        jLabel6.setText("5. List all the students who enrolled in 3000 level courses with GPA > 2.90, where GPA is from high to low ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(106, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(168, 168, 168))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // handling code:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int rows = model.getRowCount();
        
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                model.removeRow(0);
            }
        }
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            // Create a connection to the Oracle database.
            Connection conn = 
                DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            
            // Create a Statement object.
	    Statement stmt = conn.createStatement();
            String query;
            String queryNumber = JOptionPane.showInputDialog(null, "Enter a number:");

            if (queryNumber.equalsIgnoreCase("1")) {
                query = "select s.studentid, firstname, lastname,"
                    + " coursenumber, gpa, term, year"
                    + " from student s, registrar r"
                    + " where s.studentid = r.studentid";
                
                ResultSet result = stmt.executeQuery(query);
                while (result.next()) {
                    String stID = result.getString("StudentID");
                    String firstName = result.getString("FirstName");
                    String lastName = result.getString("LastName");
                    String courseNum = result.getString("CourseNumber");
                    double gpa = result.getDouble("GPA");
                    String term = result.getString("Term");
                    int year = result.getInt("Year");

                    model.addRow(new Object[] {stID, firstName, lastName, 
                        courseNum, gpa, term, year});
                }
            }
            else if (queryNumber.equalsIgnoreCase("2")) {
                query = "select s.studentid, firstname, lastname, coursenumber, term, year"
                    + " from student s, registrar r"
                    + " where s.studentid = r.studentid"
                    + " and term Like 'Spring'";
                ResultSet result = stmt.executeQuery(query);
                while (result.next()) {
                    String stID = result.getString("StudentID");
                    String firstName = result.getString("FirstName");
                    String lastName = result.getString("LastName");
                    String courseNum = result.getString("CourseNumber");
                    String term = result.getString("Term");
                    int year = result.getInt("Year");

                    model.addRow(new Object[] {stID, firstName, lastName, 
                        courseNum, null, term, year});
                }
            }
            else if (queryNumber.equalsIgnoreCase("3")) {
                query = "select s.studentid, firstname, lastname, coursenumber, r.gpa"
                    + " from student s, registrar r"
                    + " where s.studentid = r.studentid"
                    + " and r.gpa > 3.0";
                ResultSet result = stmt.executeQuery(query);
                while (result.next()) {
                    String stID = result.getString("StudentID");
                    String firstName = result.getString("FirstName");
                    String lastName = result.getString("LastName");
                    String courseNum = result.getString("CourseNumber");
                    double gpa = result.getDouble("GPA");

                    model.addRow(new Object[] {stID, firstName, lastName, 
                        courseNum, gpa});
                }
            }
            else if (queryNumber.equalsIgnoreCase("4")) {
                query = "select s.studentid, firstname, lastname, coursenumber" 
                    + " from student s, registrar r"
                    + " where s.studentid = r.studentid"
                    + " and coursenumber Like '%CISC3%'";
                ResultSet result = stmt.executeQuery(query);
                while (result.next()) {
                    String stID = result.getString("StudentID");
                    String firstName = result.getString("FirstName");
                    String lastName = result.getString("LastName");
                    String courseNum = result.getString("CourseNumber");
                    
                    model.addRow(new Object[] {stID, firstName, lastName, courseNum});
                }     
            }
            else if (queryNumber.equalsIgnoreCase("5")) {
                query = "select s.studentid, firstname, lastname, coursenumber, r.gpa" 
                    + " from student s, registrar r"
                    + " where s.studentid = r.studentid"
                    + " and coursenumber Like '%CISC3%'"
                    + " and r.gpa > 2.90"
                    + " order by r.gpa desc";
                ResultSet result = stmt.executeQuery(query);
                while (result.next()) {
                    String stID = result.getString("StudentID");
                    String firstName = result.getString("FirstName");
                    String lastName = result.getString("LastName");
                    String courseNum = result.getString("CourseNumber");
                    double gpa = result.getDouble("GPA");
                    
                    model.addRow(new Object[] {stID, firstName, lastName, courseNum, gpa});
                }     
            }
            else {
                JOptionPane.showMessageDialog(this, "Try something else");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JointTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JointTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JointTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JointTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JointTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
