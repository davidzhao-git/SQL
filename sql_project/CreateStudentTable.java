/* 
    David Zhao, CISC 3810, SQL project
    The project uses Java and it connects to Oracle database.
    There are two tables. One is the Student table and 
    the other one is the Registrar table. 
    On the printout, I have included the schema, and the output of a sample query 
    for each table, as well as a query using Join. But the codes contain 
    more than just one query for each table.  
*/
package sqlproject;

import java.sql.*;

public class CreateStudentTable {
    public static void main(String[] args) {
        try {
        // Create a connection to the database.
        Connection conn = 
                DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
	              
	// Create a Statement object.
	Statement stmt = conn.createStatement();
	              
	// Create the Student table.
	System.out.println("Creating the Student table...");
        
        stmt.execute("CREATE TABLE Student (" +
            "StudentID varchar2(15) Primary Key, " +
            "FirstName varchar2(30), " +
            "LastName varchar2(30), " +
            "HomeAddress varchar2(50), " +
            "PhoneNumber varchar2(15), " + 
            "Email varchar2(40), " + 
            "Gender varchar2(1))");
	System.out.println("Student table has been created");
	        
        String insertStatement = "insert into Student values ('001002003', 'Brendon', 'Ashcraft', +"
	        		+ "'100 Smith Street, Brooklyn NY 11221', '917-504-2012', 'BrendonA@gmail.com', 'M')";
	stmt.execute(insertStatement);
	        
        insertStatement = "insert into Student values ('051002003', 'Adena', 'Greggs', +"
	        		+ "'540 Gold Street, Brooklyn NY 11201', '646-514-2012', 'AdenaG@gmail.com', 'F')";
	stmt.execute(insertStatement);
	        
        insertStatement = "insert into Student values ('054332002', 'Spencer', 'Eugene', +"
	        		+ "'140 Gold Street, Brooklyn NY 11201', '646-765-2012', 'SpencerE@gmail.com', 'M')";
	stmt.execute(insertStatement);
	        
	insertStatement = "insert into Student values ('051442002', 'Kristen', 'Boshart', +"
	        		+ "'11 Water Street, New York NY 10001', '646-878-2015', 'KristenB@gmail.com', 'F')";
	stmt.execute(insertStatement);
	        
	insertStatement = "insert into Student values ('191332002', 'Kathrine', 'Abernathy', +"
	        		+ "'550 12th Ave, New York NY 10002', '646-762-3012', 'KathrineA@gmail.com', 'F')";
	stmt.execute(insertStatement);
	        
	insertStatement = "insert into Student values ('987332102', 'Sidney', 'Matthias', +"
	        		+ "'556 11th Ave, New York NY 10002', '347-162-3012', 'SidneyM@gmail.com', 'M')";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Student values ('687332322', 'John', 'Luc', +"
	        		+ "'600 E 14th Street, Brooklyn NY 11220', '347-987-3233', 'JohnL@gmail.com', 'M')";
	stmt.execute(insertStatement);
        
        insertStatement = "insert into Student values ('923111202', 'Kevin', 'Matthias', +"
	        		+ "'56 2nd Ave, New York NY 11000', '347-871-1112', 'KevinM@gmail.com', 'M')";
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




