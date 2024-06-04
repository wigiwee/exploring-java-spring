package com.studentManagementApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

//contains all CRUD operations
public class StudentDao {

	//Create operation
	public static boolean insertStudentToDB(Student student) {
		boolean result = false;
		try (Connection connection = DBConnection.connect()){
			//JDBC code
			
			//creating query
			String query = "INSERT INTO StudentManagementApp(sName, sPhone, sCity) values(?,?,?)"; //parameterized dynamic query
			
			PreparedStatement statement = connection.prepareStatement(query);

			//setting values of parameters
			statement.setString(1,  student.getsName()); //placing values at ? in query
			statement.setString(2, student.getsPhone());
			statement .setString(3, student.getsCity());
			
			//executing query in database server
			statement.executeUpdate();
			
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}

	//Read operation
	public static String getAllStudents() {
		try(Connection connection = DBConnection.connect()){
			//JDBC code

			//creating query
			String query = "SELECT * FROM StudentManagementApp";  //parameterized dynamic query

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(query);
			StringBuilder string = new StringBuilder();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String phone = resultSet.getString(3);
				String city = resultSet.getString("sCity");

				string.append("ID: ").append(id).append("\n");
				string.append("Name: ").append(name).append("\n");
				string.append("Phone: ").append(phone).append("\n");
				string.append("City: ").append(city).append("\n");
				string.append("+++++++++++++++++++++++++\n");

			}
			return string.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new String("[ERROR] Something went wrong");
	}

	//get Student by id
	public static String getStudentById(int id){
		try(Connection connection = DBConnection.connect()){
			String query = "SELECT * FROM StudentManagementApp WHERE sId= ?";

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			ResultSet resultSet =statement.executeQuery();

			if(resultSet.next()){

				int _id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String phone = resultSet.getString(3);
				String city = resultSet.getString("sCity");
				String string = "ID: " + _id + "\n" +
						"Name: " + name + "\n" +
						"Phone: " + phone + "\n" +
						"City: " + city + "\n";
				return string;
			}
		} catch (Exception e) {
            e.printStackTrace();
        }
        return "Something Went Wrong";
    }

	//Update operation
	public static boolean updateStudent(int id) {
		boolean result = false;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try(Connection connection = DBConnection.connect()) {
			int ch;
			String name=null, phone=null, city=null;



			while(true) {
				System.out.println("Press 1 to update Name");
				System.out.println("Press 2 to update Phone");
				System.out.println("Press 3 to update City");
				System.out.println("Press 4 to EXIT");
				ch= Integer.parseInt(reader.readLine());
				if(ch==1) {
					System.out.println("Enter student's new name: ");
					name = reader.readLine();
				}else if( ch ==2) {
					System.out.println("Enter student's new Phone no: ");
					phone= reader.readLine();
				}else if (ch==3) {
					System.out.println("Enter student's new City: ");
					city = reader.readLine();
				}else if (ch==4) {
					break;
				}
			}
			StringBuilder string = new StringBuilder();
			if(name != null) {
				string.append("sName= \"").append(name).append("\", ");
			}
			if(phone != null) {
				string.append("sPhone= \"").append(phone).append("\", ");
			}
			if(city != null) {
				string.append("sCity= \"").append(city).append("\", ");
			}
			StringBuilder string1;
			if(!string.isEmpty()){
				string1 = new StringBuilder(string.substring(0,(string.toString().length() -2)));
			}else {
				return false;
			}


			String query = "UPDATE StudentManagementApp SET "+string1+" WHERE sId= "+id;
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			return true;

		}catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	//Delete operation
	public static boolean deleteStudent(int id) {
		boolean result = false;
		try (Connection connection = DBConnection.connect()){
			//JDBC code

			
			//creating query
			String query = "DELETE FROM StudentManagementApp WHERE sId=?";  //parameterized dynamic query
			
			PreparedStatement statement = connection.prepareStatement(query);

			//setting values of parameters
			statement.setInt(1, id);
			
			//executing query in database server
			statement.executeUpdate();
			
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

}
	
