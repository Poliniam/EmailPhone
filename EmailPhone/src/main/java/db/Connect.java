package db;

import model.User;
import java.sql.*;
import java.util.ArrayList;

public class Connect {

    public static String url = "jdbc:mysql://localhost:3306/login?useSSL=false&serverTimezone=UTC";
    public static String username = "root";
    public static String password = "root";

    // метод для получения данных из бд по известному имени
   public static ArrayList<User> select(String name){
   ArrayList<User> users = new ArrayList<User>();
   try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       try (Connection connection = DriverManager.getConnection(url, username, password)){
           String sql = "SELECT * FROM emails WHERE name = ?";
           //Statement stat = connection.createStatement();
           PreparedStatement prep = connection.prepareStatement(sql);
           prep.setString(1, name);
           ResultSet resultSet = prep.executeQuery();

           while(resultSet.next()){
               int id = resultSet.getInt(1);
               String namme = resultSet.getString(2);
               String email = resultSet.getString(3);
               String phone = resultSet.getString(4);

               User user = new User(id, namme, email, phone);
               users.add(user);
           }
       }
   }
   catch(Exception ex){
       System.out.println(ex);
   }
   return users;
   }
// метод для получения всех данных из таблицы БД
   public static ArrayList<User> showAll(){
       ArrayList<User> users = new ArrayList<User>();
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           try (Connection connection = DriverManager.getConnection(url, username, password)){
               Statement statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM emails");

               while(resultSet.next()){
                   int id = resultSet.getInt(1);
                   String namme = resultSet.getString(2);
                   String email = resultSet.getString(3);
                   String phone = resultSet.getString(4);

                   User user = new User(id, namme, email, phone);
                   users.add(user);
               }
           }
       }
       catch(Exception ex){
           System.out.println(ex);
       }
       return users;
   }
   // метод для удаления строки из таблицы
   public static void delete(String name){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           try (Connection connection = DriverManager.getConnection(url, username, password)){
               String sql = "DELETE FROM emails WHERE name = ?";
               //Statement stat = connection.createStatement();
               PreparedStatement prep = connection.prepareStatement(sql);
               prep.setString(1, name);
               int rows = prep.executeUpdate();
           }
       }
       catch(Exception ex){
           System.out.println(ex);
       }
   }
   // метод для добавления в базу нового пользователя
   public static void insert(int id, String name, String email, String phone){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           try (Connection connection = DriverManager.getConnection(url, username, password)){
               String sql = "INSERT emails(id, name, email, phone) VALUES(?, ?, ?, ?)";
               //Statement stat = connection.createStatement();
               PreparedStatement prep = connection.prepareStatement(sql);
               prep.setInt(1, id);
               prep.setString(2, name);
               prep.setString(3, email);
               prep.setString(4, phone);
               int rows = prep.executeUpdate();
           }
       }
       catch(Exception ex){
           System.out.println(ex);
       }

   }
}
