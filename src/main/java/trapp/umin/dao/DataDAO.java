package trapp.umin.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import trapp.umin.models.Data;

import java.util.List;

@Component
public class DataDAO {
    //private final JdbcTemplate jdbcTemplate;
    private final SessionFactory sessionFactory;

    @Autowired
    public DataDAO(SessionFactory sessionFactory){
      //  this.jdbcTemplate=jdbcTemplate;
        this.sessionFactory=sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Data> show(){
        Session session=sessionFactory.getCurrentSession();

        List<Data> data=session.createQuery("SELECT d FROM Data d",Data.class).getResultList();

        return data;
    }

    public Data index(int id){
        return null;

    }

    public void create(Data data){

    }

    public void update(int id,Data data){

    }

    public void delete(int id){
    }

}