package org.example.repositorios;

import org.example.dominio.Servicio;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class ServicioRepositorio{

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarServicio(Servicio newObject){
        session.beginTransaction();
        session.save(newObject);
        session.getTransaction().commit();

    }

    public void actualizarServicio(Servicio anObject){
        session.beginTransaction();
        session.saveOrUpdate(anObject);
        session.getTransaction().commit();
    }

    public void eliminarServicio(Servicio anObject){
        session.beginTransaction();
        session.delete(anObject);
        session.getTransaction().commit();
    }

    public List<Servicio> getServicio(){
        return session.createQuery("from Servicio", Servicio.class).list();
    }

}
