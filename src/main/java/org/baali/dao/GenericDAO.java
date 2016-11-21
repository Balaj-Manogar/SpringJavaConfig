package org.baali.dao;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

import org.springframework.util.ObjectUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Balaji on 19/11/16.
 */
public class GenericDAO
{

    public <T, U> List<T> search(Supplier<T> inputObject, Class<U> outputType ,Function<T, String> sqlFunction ) throws
            ClassNotFoundException,
            SQLException, IllegalAccessException, InstantiationException
    {
        List<U> outputList = null;


        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

//        String sql = "SELECT * FROM employee";
        T dtobj = inputObject.get();
        String sql = sqlFunction.apply(dtobj);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        if (!ObjectUtils.isEmpty(rs))
        {
            outputList = new ArrayList<U>();

            while (rs.next())
            {
                ObjectMapper mapper = new ObjectMapper();
                JavaType userType = mapper.getTypeFactory().constructType(outputType);
                BeanDescription introspection = mapper.getSerializationConfig().introspect(userType);
                List<BeanPropertyDefinition> properties = introspection.findProperties();
                U obj = outputType.newInstance();
                properties.forEach(b ->{
                    AnnotatedMethod setter = b.getSetter();
                    try
                    {
                        Method m = obj.getClass().getDeclaredMethod(setter.getName(), setter.getParameter(0).getRawType());
                        m.invoke(obj, rs.getObject(0));
                    }
                    catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SQLException e)
                    {
                        e.printStackTrace();
                    }

                });
//                userType = mapper.getTypeFactory().constructType();
//                T e = clazz.newInstance();
//                e.setEmployeeId(rs.getInt("id"));

//                e.setEmployeeName(rs.getString("name"));
//                e.setJoinedDate(rs.getTimestamp("joinedDate"));
                //employees.add(e);
            }
        }

        return null;
    }
}
