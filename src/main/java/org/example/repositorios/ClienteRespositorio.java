package org.example.repositorios;
import org.example.dominio.Cliente;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class ClienteRespositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarCliente(Cliente newObject){
        session.beginTransaction();
        session.save(newObject);
        session.getTransaction().commit();

    }

    public void actualizarCliente(Cliente anObject){
        session.beginTransaction();
        session.saveOrUpdate(anObject);
        session.getTransaction().commit();
    }

    public void eliminarCliente(Cliente anObject){
        session.beginTransaction();
        session.delete(anObject);
        session.getTransaction().commit();
    }


    public List<Cliente> getClientes(){
        return session.createQuery("from Cliente", Cliente.class).list();
    }
}
