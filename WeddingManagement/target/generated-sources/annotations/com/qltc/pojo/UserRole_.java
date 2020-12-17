package com.qltc.pojo;

import com.qltc.pojo.Role;
import com.qltc.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-16T23:53:08")
@StaticMetamodel(UserRole.class)
public class UserRole_ { 

    public static volatile SingularAttribute<UserRole, Role> roleId;
    public static volatile SingularAttribute<UserRole, String> description;
    public static volatile SingularAttribute<UserRole, Integer> id;
    public static volatile SingularAttribute<UserRole, User> userId;
    public static volatile SingularAttribute<UserRole, Boolean> status;

}