package org.baali.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * Created by Balaji on 19/11/16.
 */
public class Employee
{
    @JsonProperty("id")
    private int employeeId;
    @JsonProperty("name")
    private String employeeName;
    private Timestamp joinedDate;

    public int getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public Timestamp getJoinedDate()
    {
        return joinedDate;
    }

    public void setJoinedDate(Timestamp joinedDate)
    {
        this.joinedDate = joinedDate;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", joinedDate=" + joinedDate +
                '}' + "\n";
    }
}
