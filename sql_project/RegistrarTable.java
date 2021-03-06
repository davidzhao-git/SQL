// David Zhao, CISC 3810, SQL project, Registrar Table
package sqlproject;

import javax.swing.table.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class RegistrarTable extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public RegistrarTable() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "StudentID", "Term", "Year", "CourseNumber", "GPA"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Enter a number");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Registrar Table");

        jLabel2.setText("2. Get a report for students with GPA greater than 3.0");

        jLabel3.setText("1. Get a full report for Registrar");

        jLabel4.setText("3. Get a report for students enrolled in year 2017");

        jLabel5.setText("4. Get a report for students enrolled in Course CISC2000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(33, Short.MAX_VALUE))
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
                query = "select * from registrar";
                ResultSet result = stmt.executeQuery(query);
                while (result.next()) {
                    String stID = result.getString("StudentID");
                    String term = result.getString("Term");
                    int year = result.getInt("Year");
                    String courseNum = result.getString("CourseNumber");
                    double gpa = result.getDouble("GPA");

                    model.addRow(new Object[] {stID, term, year, 
                        courseNum, gpa});
                }
            }
            else if (queryNumber.equalsIgnoreCase("2")) {
                query = "select * from registrar where gpa > 3";
                ResultSet result = stmt.executeQuery(query);
                while (result.next()) {
                    String stID = result.getString("StudentID");
                    String term = result.getString("Term");
                    int year = result.getInt("Year");
                    String courseNum = result.getString("CourseNumber");
                    double gpa = result.getDouble("GPA");

                    model.addRow(new Object[] {stID, term, year, 
                        courseNum, gpa});
                }
            }
            else if (queryNumber.equalsIgnoreCase("3")) {
                query = "select * from registrar where year = 2017";
                ResultSet result = stmt.executeQuery(query);
                while (result.next()) {
                    String stID = result.getString("StudentID");
                    String term = result.getString("Term");
                    int year = result.getInt("Year");
                    String courseNum = result.getString("CourseNumber");
                    double gpa = result.getDouble("GPA");

                    model.addRow(new Object[] {stID, term, year, 
                        courseNum, gpa});
                }   
            }
            else if (queryNumber.equalsIgnoreCase("4")) {
                query = "select * from registrar where CourseNumber Like 'CISC2000'";
                ResultSet result = stmt.executeQuery(query);
                while (result.next()) {
                    String stID = result.getString("StudentID");
                    String term = result.getString("Term");
                    int year = result.getInt("Year");
                    String courseNum = result.getString("CourseNumber");
                    double gpa = result.getDouble("GPA");

                    model.addRow(new Object[] {stID, term, year, 
                        courseNum, gpa});
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
            java.util.logging.Logger.getLogger(RegistrarTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarTable().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
