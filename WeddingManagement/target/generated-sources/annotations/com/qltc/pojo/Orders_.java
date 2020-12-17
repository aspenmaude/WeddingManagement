package com.qltc.pojo;

import com.qltc.pojo.OrderDetail;
import com.qltc.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-16T23:53:08")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, String> note;
    public static volatile CollectionAttribute<Orders, OrderDetail> orderDetailCollection;
    public static volatile SingularAttribute<Orders, User> customerId;
    public static volatile SingularAttribute<Orders, Date> startOn;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile SingularAttribute<Orders, Date> createdOn;
    public static volatile SingularAttribute<Orders, Boolean> status;

}