package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String roomID;
       for(int i=1;i<=7;i++){
           for (int j=1;j<=30;j++){
               roomID="A"+(int)(i*100+j);
               System.out.println(roomID);
               if(j<11){
                   addRoomToDB(roomID,"small",100);
               } else if (j<21) {
                   addRoomToDB(roomID,"medium",150);

               } else if (j<31) {
                   addRoomToDB(roomID,"large",200);

               }
           }
       }


    }



    public  static  void addRoomToDB(String roomID,String type,double price){
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotel", "root", ""
            );
            String sql="INSERT INTO room (roomID,roomType,price)" +
                    "VALUES ('"+roomID+"','"+type+ "',"+price+");";
            stmt=connection.createStatement();
            stmt.execute(sql);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public  static  void getStaff(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotel", "root", ""
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, name\n" +
                    "FROM staff;\n");

            while (resultSet.next()) {
                int id; String name;
                id=resultSet.getInt(1) ;
                name=resultSet.getString(2) ;
                System.out.println("id : "+id+ " name : "+name);

            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}