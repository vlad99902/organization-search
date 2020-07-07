package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс для подключения к БД, создания запросов и выборок.
 */

public class DataBaseHandler extends Configs{
    Connection dbConnection;

    /**
     * Метод для установки соединения с БД.
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    public Connection getDbConnection()

            throws ClassNotFoundException, SQLException {
        String ConnectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?&serverTimezone=UTC&useSSL = false&verifyServerCertificate=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(ConnectionString, dbUser,
                dbPass);
        return dbConnection;
    }

    /**
     * Запрос на выборку таблицы организаций
     * @param nameOrg
     * @param siteOrg
     * @return
     */

    public ObservableList<Organization> getOrganizationInfo (String nameOrg, String siteOrg) {
        ObservableList<Organization> organization = FXCollections.observableArrayList();

        try {
            Connection connection = getDbConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT organizations_name, organizations_adress, \n" +
                    "organizations_email, organizations_site_adress, \n" +
                    "organizations_work_start_time, organizations_work_end_time, \n" +
                    "organizations_description, specialization_name, property_name\n" +
                    "FROM db_organization.organizations\n" +
                    "JOIN db_organization.specialization ON specialization_idspecialization = idspecialization\n" +
                    "JOIN db_organization.property ON property_idproperty = idproperty " +
                    "WHERE organizations_name LIKE '%"+ nameOrg +"%' " +
                    "AND organizations_site_adress LIKE '%"+ siteOrg + "%'");
            while (resultSet.next()){
                String name = resultSet.getString("organizations_name");
                String address = resultSet.getString("organizations_adress");
                String email = resultSet.getString("organizations_email");
                String site = resultSet.getString("organizations_site_adress");
                Date startDate = resultSet.getDate("organizations_work_start_time");
                Date endDate = resultSet.getDate("organizations_work_end_time");
                String description = resultSet.getString("organizations_description");
                String specialization = resultSet.getString("specialization_name");
                String property = resultSet.getString("property_name");
                organization.add(new Organization(name, address, email,
                        site, startDate, endDate, description,
                        specialization, property));
            }
        } catch (SQLException ex) {
            System.out.println("error");
            Logger.getLogger(MainFrameController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return  organization;
    }

    /**
     * Получение id организации по имени
     * @param organization
     * @return
     */
    public Organization getOrganizationIdByNameInfo (Organization organization) {
        ObservableList<Organization> resultOrganization = FXCollections.observableArrayList();
        try {
            Connection connection = getDbConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT idorganizations\n" +
                    "FROM db_organization.organizations\n" +
                    "WHERE organizations_name = '" + organization.getNameOrganization() + "'");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("idorganizations");
                organization.setIdOrganization(id);
                resultOrganization.add(organization);
            }
        } catch (SQLException ex) {
            System.out.println("error");
            Logger.getLogger(MainFrameController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        organization = resultOrganization.get(0);
        return organization;
    }

    /**
     * Запрос на выборку из таблицы номеров телефона по организации
     * @param idOrganization
     * @return
     */
    public ObservableList<PhoneNumbers> getPhoneNumbersInfo (Integer idOrganization) {
        ObservableList<PhoneNumbers> phoneNumbers = FXCollections.observableArrayList();

        try {
            Connection connection = getDbConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT phone_numbers_number, " +
                    "phone_numbers_fax, category_name\n" +
                    "FROM db_organization.phone_numbers\n" +
                    "JOIN db_organization.category ON idcategory = category_idcategory\n" +
                    "WHERE organizations_idorganizations = " + idOrganization);
            while (resultSet.next()){
                String name = resultSet.getString("phone_numbers_number");
                Boolean fax = resultSet.getBoolean("phone_numbers_fax");
                String category = resultSet.getString("category_name");

                phoneNumbers.add(new PhoneNumbers(name, fax, category));
            }
        } catch (SQLException ex) {
            System.out.println("error");
            Logger.getLogger(MainFrameController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return phoneNumbers;
    }

    /**
     * Выборка списка форм собственности
     * @return
     */

    public ObservableList<List> getPropertyList () {
        ObservableList<List> list = FXCollections.observableArrayList();

        try {
            Connection connection = getDbConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT property_name, " +
                    "COUNT(distinct property_idproperty) as num_of_org\n" +
                    "FROM db_organization.property\n" +
                    "left outer join db_organization.organizations ON property_idproperty = idproperty\n" +
                    "group by property_name\n" +
                    "order by property_name\n");
            while (resultSet.next()){
                String name = resultSet.getString("property_name");
                Integer count = resultSet.getInt("num_of_org");

                list.add(new List(name, count));
            }
        } catch (SQLException ex) {
            System.out.println("error");
            Logger.getLogger(MainFrameController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Выборка списка специализации
     * @return
     */

    public ObservableList<List> getSpecializationList () {
        ObservableList<List> list = FXCollections.observableArrayList();

        try {
            Connection connection = getDbConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT specialization_name, " +
                    "COUNT(distinct specialization_idspecialization) as num_of_org\n" +
                    "FROM db_organization.specialization\n" +
                    "left outer join db_organization.organizations ON specialization_idspecialization = idspecialization\n" +
                    "group by specialization_name\n" +
                    "order by specialization_name");
            while (resultSet.next()){
                String name = resultSet.getString("specialization_name");
                Integer count = resultSet.getInt("num_of_org");

                list.add(new List(name, count));
            }
        } catch (SQLException ex) {
            System.out.println("error");
            Logger.getLogger(MainFrameController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
}
