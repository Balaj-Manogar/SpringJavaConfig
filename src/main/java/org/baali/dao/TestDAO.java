package org.baali.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Balaji on 01/11/16.
 */
@Repository
public class TestDAO
{
    private SessionFactory sessionFactory;

    @Autowired
    public TestDAO(SessionFactory theSessionFactory)
    {
        this.sessionFactory = theSessionFactory;
    }
}
