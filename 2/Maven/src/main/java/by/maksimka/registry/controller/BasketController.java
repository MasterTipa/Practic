package by.maksimka.registry.controller;

import java.sql.*;

public class BasketController {
    public void getAllBasket() throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            Statement st = connection.createStatement();
            String query = "SELECT * FROM baskets";
            ResultSet resultSet= st.executeQuery(query);
            System.out.println("id\torder_id");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+"\t"
                        +resultSet.getString("order_id")+"\t");
            }
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void getBasket(int id) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            Statement st = connection.createStatement();
            String query = "SELECT * FROM baskets";
            ResultSet resultSet= st.executeQuery(query);
            System.out.println("id\torder_id");
            while(resultSet.next()){
                if (resultSet.getInt("id") == id)
                    System.out.println(resultSet.getInt("id")+"\t"
                            +resultSet.getString("order_id"));
            }
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void addBasket(int n) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO baskets(order_id) VALUES (n);");
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void updateBasket(int id, int order_id) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            Statement statement = connection.createStatement();
            String updSql = "update baskets set order_id='" +order_id+ "' WHERE id = '" + id + "';";
            statement.executeUpdate(updSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteBasket(int n) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            Statement statement = connection.createStatement();
            String updSql = "delete from baskets WHERE order_id = '" + n + "';";
            statement.executeUpdate(updSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
