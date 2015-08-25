/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardhell.petclinic.dao.hibernate;

import com.richardhell.petclinic.dao.VacunaDAO;
import com.richardhell.petclinic.model.Vacuna;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VacunaDAOH extends HibernateTemplate implements VacunaDAO {

    @Autowired
    public VacunaDAOH(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Vacuna find(Vacuna t) {
        Criteria criteria = this.getSession().createCriteria(Vacuna.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Vacuna) criteria.uniqueResult();
    }

    @Override
    public List<Vacuna> all() {
        Criteria criteria = this.getSession().createCriteria(Vacuna.class);
        return criteria.list();
    }

    @Override
    public void saveDAO(Vacuna t) {
        this.save(t);
    }

    @Override
    public void updateDAO(Vacuna t) {
        this.merge(t);
    }

    @Override
    public void deleteDAO(Vacuna t) {
        this.delete(t);
    }

}
