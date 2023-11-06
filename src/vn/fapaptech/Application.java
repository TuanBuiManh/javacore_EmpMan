package vn.fapaptech;

import vn.fapaptech.Impl.EmployeeImpl;
import vn.fapaptech.entity.Employee;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Application {
    public static void main(String[] args) throws SQLException {
        int choice,num;
        EmployeeImpl dao = new EmployeeImpl();
        Employee e;
        do{
            System.out.println("=====Menu=====");
            System.out.println("1.Get Employee by ID");
            System.out.println("2.Add Employee");
            System.out.println("3.Update Employee");
            System.out.println("4.Delete Employee");
            System.out.println("5.Get All Employee");
            System.out.println("6.Exit");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the ID of the Employee: ");
                    String id1 = scanner.next();
                    e = dao.getById(id1);
                    break;
                case 2:
                    System.out.println("Enter Employee Details: ");
                    System.out.println("Enter the Employee ID");
                    String id2 = scanner.next();
                    System.out.println("Enter the Employee name");
                    String name = scanner.next();
                    System.out.println("Enter Salary");
                    String salary = scanner.next();
                    Employee e1 = new Employee(id2,name,salary);
                    e = dao.add(e1);
                    break;
                case 3:
                    System.out.println("Enter the ID to change: ");
                    String id3 = scanner.next();
                    System.out.println("Enter the new Name: ");
                    String name1 = scanner.next();
                    e = dao.update(id3,name1);
                    break;
                case 4:
                    System.out.println("Enter the ID to delete: ");
                    String id4 = scanner.next();
                    e = dao.del(id4);
                    break;
                case 5:
                    System.out.println("Employee Data");
                    System.out.println("----------------------------");
                    System.out.printf("|%5s|%-10s|%-10s|\n","ID","Name","Salary");
                    System.out.println("----------------------------");
                    dao.getAll();
                    System.out.println("----------------------------");
                    break;
                case 6:
                    exit(0);
                default:
                    System.out.println("Wrong input...!");
                    break;
            }
            System.out.println("Enter 6 to continue...!");
            num = scanner.nextInt();
        } while (num == 6);
    }
}
