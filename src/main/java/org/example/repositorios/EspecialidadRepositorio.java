package org.example.repositorios;
import org.example.dominio.Especialidad;

import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class EspecialidadRepositorio {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarEspecialidad(Especialidad nuevoObjeto){
        session.beginTransaction();
        session.save(nuevoObjeto);
        session.getTransaction().commit();
    }

    public void actualizarEspecialidad(Especialidad unObjeto){
        session.beginTransaction();
        session.saveOrUpdate(unObjeto);
        session.getTransaction().commit();
    }

    public void eliminarEspecialidad(Especialidad unObjeto){
        session.beginTransaction();
        session.delete(unObjeto);
        session.getTransaction().commit();
    }
    public List<Especialidad> getEspecialidad(){
        return session.createQuery("from Especialidad", Especialidad.class).list();
    }
}
