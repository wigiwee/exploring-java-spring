package com.RestDemo;

import java.sql.*;
import java.util.ArrayList;

public class StudentRepository {

    private Connection con = null;

    public StudentRepository(){
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String username = "happypotter";
            String password = "password";
            String url = "jdbc:mysql://localhost:3306/ExploringSpring";

            con = DriverManager.getConnection(url, username, password);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Student> getAll(){
        ArrayList<Student> students = new ArrayList<>();

        try{
            String query = "SELECT * FROM student";
            Statement statement = con.createStatement();
            ResultSet resultSet =  statement.executeQuery(query);
            while (resultSet.next()){
                Student s = new Student();
                s.setId(resultSet.getInt(1));
                s.setName(resultSet.getString(2));
                s.setMarks(resultSet.getInt(3));

                students.add(s);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return students;
    }

    public Student get(int id) {
        Student student = new Student();
        try {
            String query = "SELECT * FROM student WHERE id=?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet resultSet =statement.executeQuery();
            if(resultSet.next()){

                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setMarks(resultSet.getInt(3));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return student;
    }

    public void create(Student student){
        try {

            String query = "INSERT INTO student(id, name, marks) values(?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getMarks());

            statement.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id){
        try {
            String query = "DELETE FROM student WHERE ID=?";
            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1,id);

            statement.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void update(Student s){
        try {
            String query = "UPDATE student SET name=? , marks=? WHERE id=?";
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, s.getName());
            statement.setInt(2, s.getMarks());
            statement.setInt(3,s.getId());

            statement.executeUpdate();

        }catch (Exception e){
            e.getMessage();
        }
    }
}
