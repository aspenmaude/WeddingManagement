package com.qltc.pojo;

import com.qltc.pojo.Image;
import com.qltc.pojo.MenuSetDetail;
import com.qltc.pojo.OrderDetail;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-16T23:53:08")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> note;
    public static volatile SingularAttribute<Product, String> unit;
    public static volatile CollectionAttribute<Product, OrderDetail> orderDetailCollection;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile CollectionAttribute<Product, Image> imageCollection;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile CollectionAttribute<Product, MenuSetDetail> menuSetDetailCollection;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, String> type;
    public static volatile SingularAttribute<Product, String> category;
    public static volatile SingularAttribute<Product, Boolean> status;

}