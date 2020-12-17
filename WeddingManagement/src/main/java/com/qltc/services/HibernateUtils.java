/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qltc.services;

import com.qltc.pojo.Code;
import com.qltc.pojo.Image;
import com.qltc.pojo.MenuSet;
import com.qltc.pojo.MenuSetDetail;
import com.qltc.pojo.OrderDetail;
import com.qltc.pojo.Orders;
import com.qltc.pojo.Product;
import com.qltc.pojo.Role;
import com.qltc.pojo.User;
import com.qltc.pojo.UserRole;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Vo Pham Huyen Khanh
 */
public class HibernateUtils {
    private final static SessionFactory FACTORY;
    
    static {
        Configuration conf = new Configuration();
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/qltieccuoidb");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "123456");
        props.put(Environment.SHOW_SQL, "");
        
        conf.setProperties(props);
        
        conf.addAnnotatedClass(Code.class);
        conf.addAnnotatedClass(Image.class);
        conf.addAnnotatedClass(MenuSet.class);
        conf.addAnnotatedClass(MenuSetDetail.class);
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(Orders.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Role.class);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(UserRole.class); 
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        
        FACTORY = conf.buildSessionFactory(registry);
}

/**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}