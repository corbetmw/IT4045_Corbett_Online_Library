package com.it4045.common.utility;

import com.it4045.common.valueObjects.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Map;

public class HibernateUtility
{
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    /**
     * Gets sessionFactory, starts hibernate transaction, and
     * creates a Query object
     *
     * @param sql is the SQL passed in
     * @return Query object populated with sql object and database configuration
     */
    public static List createAndExecuteQuery(String sql, Map<String, Object> parameters)
    {
        getCurrentSession().beginTransaction();

        Query query = getCurrentSession().createQuery(sql);

        for (String paramName : parameters.keySet()){
            query.setParameter(paramName, parameters.get(paramName));
        }

        List list = query.list();

        closeSession();

        return list;
    }

    /**
     * Insert new record into database
     *
     * @param objectToAdd the object that you want to add.  Should be instance of Persistence.
     */
    public static void insertData(Persistence objectToAdd)
    {
        getCurrentSession().beginTransaction();

        getCurrentSession().save(objectToAdd);

        getCurrentSession().getTransaction().commit();

        closeSession();
    }

    /**
     * Insert record into database
     *
     * @param objectToAdd the object that you want to add.  Should be an instanceof Persistence
     */
    public static void deleteData(Persistence objectToAdd)
    {
        getCurrentSession().beginTransaction();

        getCurrentSession().remove(objectToAdd);

        getCurrentSession().getTransaction().commit();

        closeSession();
    }

    /**
     * Get the current session
     *
     * @return the current session
     */
    private static Session getCurrentSession()
    {
        return getSessionFactory().getCurrentSession();
    }

    /**
     * Close current session
     */
    public static void closeSession()
    {
        if (getCurrentSession().isOpen())
        {
            getCurrentSession().close();
        }
    }

    /**
     * Get the sessionFactory instance.  If null then create one
     *
     * @return SessionFactory object that is populated with the correct information
     */
    public static SessionFactory getSessionFactory()
    {
        if (sessionFactory == null)
        {
            try
            {
                // Create registry
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                if (registry != null)
                {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown()
    {
        if (registry != null)
        {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}