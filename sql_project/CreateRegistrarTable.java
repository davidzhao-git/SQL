// David Zhao, CISC 3810, SQL project, creating the registrar table

package sqlproject;

import java.sql.*;

public class CreateRegistrarTable {
    public static void main(String[] args) {
        try {
        // Create a connection to the database.
        Connection conn = 
                DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
	              
	// Create a Statement object.
	Statement stmt = conn.createStatement();
        
        // Create the Registrar table.
        System.out.println("Creating the Registrar table...");
        stmt.execute("CREATE TABLE Registrar (" +
            "StudentID varchar2(15) not null, " +
            "Term varchar2(30), " +
            "Year number(5), " +
            "CourseNumber varchar2(10), " +
            "GPA number(6,2))");
	System.out.println("Registrar table has been created");
        
        String insertStatement = "insert into Registrar values ('001002003', 'Spring', 2018, +"
	        		+ "'CISC3110', 3.67)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('001002003', 'Fall', 2017, +"
	        		+ "'CISC3810', 4.00)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('051002003', 'Fall', 2017, +"
	        		+ "'CISC3120', 3.00)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('054332002', 'Spring', 2016, +"
	        		+ "'CISC1220', 3.67)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('054332002', 'Fall', 2016, +"
	        		+ "'CISC1120', 2.33)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('054332002', 'Fall', 2017, +"
	        		+ "'CISC2000', 3.33)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('051442002', 'Spring', 2018, +"
	        		+ "'CISC2000', 2.00)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('051442002', 'Spring', 2018, +"
	        		+ "'CISC3000', 3.33)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('987332102', 'Spring', 2018, +"
	        		+ "'CISC2100', 2.33)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('987332102', 'Spring', 2018, +"
	        		+ "'CISC2300', 3.67)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('687332322', 'Spring', 2018, +"
	        		+ "'CISC3100', 3.67)";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Registrar values ('687332322', 'Spring', 2017, +"
	        		+ "'CISC2000', 4.00)";
	stmt.execute(insertStatement);
        
        stmt.close();     
        conn.close();
        System.out.println("Done");
        }
	catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            if (ex.getMessage().contains("ORA-00955")) {
                System.out.println("Table already exists.");
            }
        }
    }
}




