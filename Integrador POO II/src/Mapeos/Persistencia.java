/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mapeos;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Persistencia {
    private SessionFactory sessionFactory;
    private Session session;
    
    public Persistencia() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        
    }
    
    public void insert(Object unObjeto) {
        Transaction tr = session.beginTransaction();
          session.save(unObjeto);
        tr.commit();
    }
    
    public void update(Object unObjeto){
        Transaction tr=session.beginTransaction();
        session.saveOrUpdate(unObjeto);
        tr.commit();
    }

    
    public Object load(String clase,Serializable id) {
        Object obj = session.get(clase,id);
        return obj;
    }
    
    public List find(String sentencia) {
        List obj = session.createQuery(sentencia).list();
        
        return obj;
    }
}
