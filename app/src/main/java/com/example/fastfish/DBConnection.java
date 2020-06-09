package com.example.fastfish;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DBConnection {
//    public static List<User> userList= new ArrayList<>();
//    public static String stringtest = "fattttttttttttttt";

//    public  Connection connection;
////    public  List<User> list = new ArrayList<>();
//    public  Map<String, List<User>> map = new HashMap<>();
//    public static List<String> test = new ArrayList<>();

    public DBConnection (){
    }

//    public static List<User> getUserList() {
//        return userList;
//    }

    public static void main(String[] args) throws SQLException {


//        DBConnection con = new DBConnection();
//        con.createConnection();
////        con.signup("");
//        System.out.println(Arrays.toString(userList.toArray()));



    }
//    public static void print() {
//        System.out.println(Arrays.toString(list.toArray()));
//
//    }
//    public void startConnection(){
//        DBConnection con = new DBConnection();
//        con.createConnection();
//        con.signup("");
//    }

    public Boolean createConnection (String inputUsername, String inputPassword) throws SQLException {

        Connection connection;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HoverFly?user=root&password=moshiur1&serverTimezone=UTC"
            );
            System.out.println("Helooooooooooooooooooooooooooooooooooooooooo");

            System.out.println("Connection established");

            Statement stm = connection.createStatement();
            ResultSet rs =  stm.executeQuery("SELECT * FROM HOVERFLY");


            while(rs.next()){
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
                String name = rs.getString("name");
                String username = rs.getString("username");
                String password = rs.getString("username");
                int highscore = rs.getInt("highscore");
                if(username.equals(inputUsername)) {
                    System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBbbbbbbbbbbbbb");

                    if(password.equals(inputPassword)) {
                        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCcccccccccccc");

                        User.setHighScore(highscore);
                        User.setName(name);
                        User.setPassword(password);
                        User.setUsername(username);
                    }

                }
            }
            stm.close();
            connection.close();

        } catch (ClassNotFoundException e ) {
            System.out.println("Class not found jdbc or sql exception happened");
            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        System.out.println("ddddddddddddddddddddddddDDDDDDDDDDDDDDDDDDD");
        return false;
    }





//    public Boolean createConnection (String inputUsername, String inputPassword) throws SQLException {
//        Connection connection;
//
//        try {
//
//            Class.forName("com.mysql.jdbc.Driver");
//
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HoverFly?user=root&password=moshiur1&serverTimezone=UTC"
//            );
//            System.out.println("Helooooooooooooooooooooooooooooooooooooooooo");
//
//            System.out.println("Connection established");
//
//            Statement stm = connection.createStatement();
//            ResultSet rs =  stm.executeQuery("SELECT * FROM HOVERFLY");
//
//
//            while(rs.next()){
//                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
//                String name = rs.getString("name");
//                String username = rs.getString("username");
//                String password = rs.getString("username");
//                int highscore = rs.getInt("highscore");
//                if(username.equals(inputUsername)) {
//                    System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBbbbbbbbbbbbbb");
//
//                    if(password.equals(inputPassword)) {
//                        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCcccccccccccc");
//
//                        User.setHighScore(highscore);
//                        User.setName(name);
//                        User.setPassword(password);
//                        User.setUsername(username);
//                    }
//
//                }
//            }
//            stm.close();
//            connection.close();
//
//        } catch (ClassNotFoundException e ) {
//            System.out.println("Class not found jdbc or sql exception happened");
//            e.printStackTrace();
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        }
//        System.out.println("ddddddddddddddddddddddddDDDDDDDDDDDDDDDDDDD");
//        return false;
//    }

//    public static void updatehs(User user, int score) {
//        try {
//
//
//            String sql = "INSERT INTO hoverfly (username, password, name, highscore)" +
//                    "VALUES (?, ?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            String un = user.getUsername();
//            String pw = user.getPassword();
//            String name= user.getName();
//            int hs = user.getHighScore();
//            if(score > hs) {
//                hs = score;
//            }
//
//            preparedStatement.setString(1, un);
//            preparedStatement.setString(2, pw);
//            preparedStatement.setString(3, name);
//            preparedStatement.setInt(4, hs);
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }



//    public static void signup (User user) {
//        try {
//
//
//            String sql = "INSERT INTO hoverfly (username, password, name, highscore)" +
//                    "VALUES (?, ?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            String un = user.getUsername();
//            String pw = user.getPassword();
//            String name= user.getName();
//            int hs = user.getHighScore();
//
//            preparedStatement.setString(1, un);
//            preparedStatement.setString(2, pw);
//            preparedStatement.setString(3, name);
//            preparedStatement.setInt(4, hs);
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//


//    }

}