/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardhell.petclinic.dao.hibernate;

import com.richardhell.petclinic.dao.DetalleDAO;
import com.richardhell.petclinic.helper.GenericDAO;
import com.richardhell.petclinic.model.Detalle;
import com.richardhell.petclinic.model.Especie;
import com.richardhell.petclinic.model.Vacuna;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pantojarosales
 */
@Repository
public class DetalleDAOH extends HibernateTemplate implements DetalleDAO {

    @Autowired
    public DetalleDAOH(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Detalle find(Detalle t) {
        Criteria criteria = this.getSession().createCriteria(Detalle.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Detalle) criteria.uniqueResult();
    }

    @Override
    public List<Detalle> all() {
        Criteria criteria = this.getSession().createCriteria(Detalle.class);
        return criteria.list();
    }

    @Override
    public void saveDAO(Detalle t) {
        this.save(t);
    }

    @Override
    public void updateDAO(Detalle t) {
        this.merge(t);
    }

    @Override
    public void deleteDAO(Detalle t) {
        this.delete(t);
    }

}
