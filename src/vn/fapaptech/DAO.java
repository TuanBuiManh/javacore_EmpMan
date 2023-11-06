package vn.fapaptech;

import vn.fapaptech.entity.Customer;
import vn.fapaptech.entity.Employee;

import java.sql.SQLException;

public interface DAO {
    public Employee getById(String ID) throws SQLException;

    public void getAll() throws SQLException;
    public Employee add(Employee e) throws SQLException;
    public Employee del(String ID) throws SQLException;
    public Employee update(String ID, String name) throws SQLException;

}
