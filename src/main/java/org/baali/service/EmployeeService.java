package org.baali.service;

import org.baali.dao.GenericDAO;
import org.baali.dto.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Balaji on 19/11/16.
 */
public class EmployeeService
{
    public List<Employee> searchEmployees() throws SQLException, ClassNotFoundException
    {
        GenericDAO dao = new GenericDAO();
        //return dao.search();
        return null;
    }
}
