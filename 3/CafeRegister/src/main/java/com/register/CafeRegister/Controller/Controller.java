package com.register.CafeRegister.Controller;

import java.sql.*;

public class Controller {
    public void getAll(String name) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            Statement st = connection.createStatement();
            String query = "SELECT * FROM "+name;
            ResultSet resultSet= st.executeQuery(query);
            switch (name){
                case "clients":
                    System.out.println("id\tname\tmoney");
                    while(resultSet.next()){
                        System.out.println(resultSet.getInt("id")+"\t"
                                +resultSet.getString("name")+"\t\t"
                                +resultSet.getString("money"));
                    }
                    st.close();
                    break;
                case "providers":
                    System.out.println("id\tname");
                    while(resultSet.next()){
                        System.out.println(resultSet.getInt("id")+"\t"
                                +resultSet.getString("name"));
                    }
                    st.close();
                    break;
                case "baskets":
                    System.out.println("id\torder_id");
                    while(resultSet.next()){
                        System.out.println(resultSet.getInt("id")+"\t"
                                +resultSet.getInt("order_id"));
                    }
                    st.close();
                    break;
                case "cafes":
                    System.out.println("id\tname\tplace\tscore\ttable_cout\tmax_table");
                    while(resultSet.next()){
                        System.out.println(resultSet.getInt("id")+"\t"
                                +resultSet.getString("name")+"\t"
                                +resultSet.getString("place")+"\t"
                                +resultSet.getDouble("score")+"\t"
                                +resultSet.getInt("table_cout")+"\t"
                                +resultSet.getInt("max_table"));
                    }
                    st.close();
                    break;
                case "dishes":
                    System.out.println("id\tbasket_id\tname\tcost");
                    while(resultSet.next()){
                        System.out.println(resultSet.getInt("id")+"\t"
                                +resultSet.getInt("basket_id")+"\t"
                                +resultSet.getString("name")+"\t"
                                +resultSet.getDouble("cost")+"\t");
                    }
                    st.close();
                    break;
                case "dishes_has_providers":
                    System.out.println("dish_id\tprovider_id");
                    while(resultSet.next()){
                        System.out.println(resultSet.getInt("dish_id")+"\t"
                                +resultSet.getInt("provider_id")+"\t");
                    }
                    st.close();
                    break;
                case "feedbacks":
                    System.out.println("id\tcafe_id\tfeedback\tscore");
                    while(resultSet.next()){
                        System.out.println(resultSet.getInt("id")+"\t"
                                +resultSet.getInt("cafe_id")+"\t"
                                +resultSet.getString("feedback")+"\t"
                                +resultSet.getDouble("score")+"\t");
                    }
                    st.close();
                    break;
                case "orders":
                    System.out.println("id\tcafe_id\tclient_id\tbill\ttable_number");
                    while(resultSet.next()){
                        System.out.println(resultSet.getInt("id")+"\t"
                                +resultSet.getInt("cafe_id")+"\t"
                                +resultSet.getInt("client_id")+"\t"
                                +resultSet.getDouble("bill")+"\t"
                                +resultSet.getInt("table_number"));
                    }
                    st.close();
                    break;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void add(String name) {
    }

    public void delete(String name) {
    }

    public void change(String name) {
    }

    public void getFromId(String name, int basketid,int orderid,int dishid,int providerid,int cafeid,int clientid) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registry", "root", "1234")){
            Statement st = connection.createStatement();
            String query = "SELECT * FROM " + name;
            ResultSet resultSet= st.executeQuery(query);
            switch (name) {
                case "baskets":
                    System.out.println("id\torder_id");
                    while (resultSet.next()) {
                        if (resultSet.getInt("id") == basketid)
                             System.out.println(resultSet.getInt("id")+"\t"
                                               +resultSet.getInt("order_id"));
                }
                st.close();
                break;
                case "clients":
                    while (resultSet.next()) {
                        if (resultSet.getInt("id") == clientid)
                            System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name"));
                    }
                    st.close();
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
