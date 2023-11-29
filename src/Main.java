import java.sql.*;

public class Main {

    private static final String url ="jdbc:mysql://localhost:3307/learnjdbc";
    private static final String userName = "root";
    private static final String passwrd = "root";

    public static void main(String[] args) {

        try {
            // Loading Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            //Establishing connection or get Connection instance
            Connection connection = DriverManager.getConnection(url,userName,passwrd);

            // creating statement
            Statement statement = connection.createStatement();
            String query = "select * from students";
            // execute statement and get ResultSet as return type which contains database tables
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double percent = resultSet.getDouble("percent");

                System.out.println("Id : "+id);
                System.out.println("Name : "+name);
                System.out.println("Age : "+age);
                System.out.println("Percentage : "+percent);
                System.out.println("-----------------------------");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


        }
    }
