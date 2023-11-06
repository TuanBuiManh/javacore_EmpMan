package vn.fapaptech.Impl;

import vn.fapaptech.DAO;
import vn.fapaptech.entity.Customer;
import vn.fapaptech.entity.Employee;

import java.sql.SQLException;

public class CustomerImpl implements DAO {
    Customer c = new Customer();

    @Override
    public Employee getById(String ID) throws SQLException {
        return null;
    }

    @Override
    public void getAll() throws SQLException {

    }

    @Override
    public Employee add(Employee e) throws SQLException {
        return null;
    }

    @Override
    public Employee del(String ID) throws SQLException {
        return null;
    }

    @Override
    public Employee update(String ID, String name) throws SQLException {
        return null;
    }
}
