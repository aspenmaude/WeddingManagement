/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qltc.services;

import com.qltc.pojo.MenuSet;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vo Pham Huyen Khanh
 */
public class MenuSetService {
    private final static SessionFactory factory = HibernateUtils.getFACTORY();
    
    public List<MenuSet> getAllMenuSet() {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<MenuSet> query = builder.createQuery(MenuSet.class);
            Root<MenuSet> root = query.from(MenuSet.class);
            
            query.select(root);

            return session.createQuery(query).getResultList();
        }
    }
}
