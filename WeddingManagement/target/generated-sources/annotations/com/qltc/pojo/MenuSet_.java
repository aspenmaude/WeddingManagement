package com.qltc.pojo;

import com.qltc.pojo.MenuSetDetail;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-21T01:33:10")
@StaticMetamodel(MenuSet.class)
public class MenuSet_ { 

    public static volatile SingularAttribute<MenuSet, BigDecimal> totalAmount;
    public static volatile SingularAttribute<MenuSet, String> name;
    public static volatile CollectionAttribute<MenuSet, MenuSetDetail> menuSetDetailCollection;
    public static volatile SingularAttribute<MenuSet, String> description;
    public static volatile SingularAttribute<MenuSet, Integer> id;
    public static volatile SingularAttribute<MenuSet, Boolean> status;

}