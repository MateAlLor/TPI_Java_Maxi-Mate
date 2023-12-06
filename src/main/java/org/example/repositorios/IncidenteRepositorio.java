package org.example.repositorios;
import org.example.dominio.Incidente;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class IncidenteRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarIncidente(Incidente nuevoInc){
        session.beginTransaction();
        session.save(nuevoInc);
        session.getTransaction().commit();

    }

    public void actualizarIncidente(Incidente unInc){
        session.beginTransaction();
        session.saveOrUpdate(unInc);
        session.getTransaction().commit();
    }

    public void eliminarIncidente(Incidente unInc){
        session.beginTransaction();
        session.delete(unInc);
        session.getTransaction().commit();
    }
    public List<Incidente> getIncidentes(){
        return session.createQuery("from Incidente", Incidente.class).list();
    }

}
