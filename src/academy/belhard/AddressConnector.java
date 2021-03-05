package academy.belhard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/address_db?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "654321";

    public static Connection connection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void add(Address address) {

        try(PreparedStatement statement =  AddressConnector.connection().prepareStatement("INSERT INTO address " +
                "(city, street, house_number, building, flat) VALUES ( ?, ?, ?, ?, ?)")) {

            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouseNumber());
            statement.setInt(4, address.getBuilding());
            statement.setInt(5, address.getFlat());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Address> readAll() {

        List<Address> addresses = new ArrayList<>();

        Address address;

        try(PreparedStatement statement =  AddressConnector.connection().prepareStatement("SELECT * FROM address")) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                address  = new Address(resultSet.getInt("id"), resultSet.getString("city"),
                        resultSet.getString("street"), resultSet.getInt("house_number"),
                        resultSet.getInt("building"), resultSet.getInt("flat"));
                addresses.add(address);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    public static void delete(int id) {


        try(PreparedStatement statement = AddressConnector.connection().prepareStatement("DELETE FROM address WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Address address) {

        try(PreparedStatement statement = AddressConnector.connection().prepareStatement("UPDATE address " +
                "SET city = ?, street = ?, house_number = ?, building = ?, flat = ? " +
                "WHERE id = ?")) {

            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouseNumber());
            statement.setInt(4, address.getBuilding());
            statement.setInt(5, address.getFlat());
            statement.setInt(6, address.getId());
            statement.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
