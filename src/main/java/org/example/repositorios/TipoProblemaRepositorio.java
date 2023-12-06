package org.example.repositorios;
import org.example.dominio.TipoProblema;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class TipoProblemaRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarTipoProblema(TipoProblema newObject){
        session.beginTransaction();
        session.save(newObject);
        session.getTransaction().commit();

    }

    public void actualizarTipoProblema(TipoProblema anObject){
        session.beginTransaction();
        session.saveOrUpdate(anObject);
        session.getTransaction().commit();
    }

    public void eliminarTipoProblema(TipoProblema anObject){
        session.beginTransaction();
        session.delete(anObject);
        session.getTransaction().commit();
    }

    public List<TipoProblema> getTipoProblema(){
        return session.createQuery("from TipoProblema", TipoProblema.class).list();
    }
}
