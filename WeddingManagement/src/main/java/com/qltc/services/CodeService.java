/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qltc.services;

import com.qltc.pojo.Code;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Vo Pham Huyen Khanh
 */
public class CodeService {

    private final static SessionFactory factory = HibernateUtils.getFACTORY();

    //get list category of food
    public List<Code> getFoodCategories() {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Code> query = builder.createQuery(Code.class);
            Root<Code> root = query.from(Code.class);
            // select * from `code` where `code_type` = "ProductCategory" and left(`value`,2) = '01'
            
            Predicate p1 = builder.equal(root.get("code_type"), "ProductCategory");
            Predicate p2 = builder.equal(builder.substring(root.<String>get("value"), 1, 2), "01");
            
            query.select(root).where(p1,p2);

            return session.createQuery(query).getResultList();
        }
    }

    //get list category of drinks
    public List<Code> getDrinkCategories() {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Code> query = builder.createQuery(Code.class);
            Root<Code> root = query.from(Code.class);
            // select * from `code` where `code_type` = "ProductCategory" and left(`value`,2) = '01'
            
            Predicate p1 = builder.equal(root.get("code_type"), "ProductCategory");
            Predicate p2 = builder.equal(builder.substring(root.<String>get("value"), 1, 2), "02");
            
            query.select(root).where(builder.and(p1,p2));

            return session.createQuery(query).getResultList();
        }
    }
}
