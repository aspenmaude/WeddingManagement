package com.qltc.pojo;

import com.qltc.pojo.Orders;
import com.qltc.pojo.UserRole;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-21T01:33:10")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> firstname;
    public static volatile SingularAttribute<User, String> address;
    public static volatile CollectionAttribute<User, UserRole> userRoleCollection;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, Date> dob;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile CollectionAttribute<User, Orders> ordersCollection;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> lastname;

}