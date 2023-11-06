package vn.fapaptech.Impl;

import vn.fapaptech.DAO;
import vn.fapaptech.MySQLConnection;
import vn.fapaptech.entity.Customer;
import vn.fapaptech.entity.Employee;

import java.sql.*;

public class EmployeeImpl implements DAO{
    Employee e = new Employee();

    @Override
    public Employee getById(String ID) throws SQLException {
        Connection connection = MySQLConnection.getMyConnection();
        String query = "select * from employee where id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,ID);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            String id = resultSet.getString(1);
            e.setID(id);
            String name = resultSet.getString(2);
            e.setName(name);
            String salary = resultSet.getString(3);
            e.setSalary(salary);
            System.out.println("        Employee Data");
            System.out.println("===========================");
            System.out.println("ID: "+id);
            System.out.println("Name: "+name);
            System.out.println("Salary: "+salary);
        }
        return e;
    }

    @Override
    public void getAll() throws SQLException {
        String query = "select * from employee";
        Connection connection = MySQLConnection.getMyConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            String id = resultSet.getString(1);
            e.setID(id);
            String name = resultSet.getString(2);
            e.setName(name);
            String salary = resultSet.getString(3);
            e.setSalary(salary);
            System.out.printf("|%5s|%-10s|%-10s|\n",id,name,salary);
        }
    }

    @Override
    public Employee add(Employee e) throws SQLException {
        Connection connection = MySQLConnection.getMyConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?)");
        ps.setString(1,e.getID());
        ps.setString(2,e.getName());
        ps.setString(3,e.getSalary());
        int newCount = ps.executeUpdate();
        if(newCount > 0){
            System.out.println("Employee added successfully...!");
        }
        else {
            System.out.println("Failed to add a record.........!");
        }
        return null;
    }

    @Override
    public Employee del(String ID) throws SQLException {
        Connection connection = MySQLConnection.getMyConnection();
        String query = "DELETE FROM employee WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,ID);

        int i = ps.executeUpdate();
        if(i>0){
            System.out.println("Delete data successfully!");
        }
        else{
            System.out.println("Fail to delete data....!");
        }
        return null;
    }

    @Override
    public Employee update(String ID, String name) throws SQLException {
        Connection connection = MySQLConnection.getMyConnection();
        String query = "UPDATE employee SET Name = ? WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,name);
        ps.setString(2,ID);
        int i = ps.executeUpdate();
        if(i>0){
            System.out.println("An existing user was updated successfully!");
        }
        else{
            System.out.println("Fail to update data...!");
        }
        return null;
    }

}
