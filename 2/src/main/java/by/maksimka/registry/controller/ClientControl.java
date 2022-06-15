package by.maksimka.registry.controller;

import java.sql.*;

public class ClientControl {
    public void getAllClients() throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            Statement st = connection.createStatement();
            String query = "SELECT * FROM clients";
            ResultSet resultSet= st.executeQuery(query);
            System.out.println("id\tname\tmoney");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+"\t"
                        +resultSet.getString("name")+"\t\t"
                        +resultSet.getString("money"));
            }
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void getClient(int id) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            Statement st = connection.createStatement();
            String query = "SELECT * FROM clients";
            ResultSet resultSet= st.executeQuery(query);
            System.out.println("id\tname");
            while(resultSet.next()){
                if (resultSet.getInt("id") == id)
                    System.out.println(resultSet.getInt("id")+"\t"+resultSet.getString("name"));
            }
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void addClient(String n, double m) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients(name, money) VALUES ('"+ n + "', '"+ m +"');");
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void updateClient(int id, double money) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            Statement statement = connection.createStatement();
            String updSql = "update clients set money='" +money+ "' WHERE id = '" + id + "';";
            statement.executeUpdate(updSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteClient(String n) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            Statement statement = connection.createStatement();
            String updSql = "delete from clients WHERE name = '" + n + "';";
            statement.executeUpdate(updSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
