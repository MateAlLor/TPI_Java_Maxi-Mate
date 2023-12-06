package org.example.repositorios;
import org.example.dominio.EstimadoPorProblema;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class EstimadoPorProblemaRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarEstimadoPorProblema(EstimadoPorProblema newObject){
        session.beginTransaction();
        session.save(newObject);
        session.getTransaction().commit();

    }

    public void actualizarEstimadoPorProblema(EstimadoPorProblema anObject){
        session.beginTransaction();
        session.saveOrUpdate(anObject);
        session.getTransaction().commit();
    }

    public void eliminarEstimadoPorProblema(EstimadoPorProblema anObject){
        session.beginTransaction();
        session.delete(anObject);
        session.getTransaction().commit();
    }

    public List<EstimadoPorProblema> getEstimadoPorProblema(){
        return session.createQuery("from EstimadoPorProblema", EstimadoPorProblema.class).list();
    }
}
