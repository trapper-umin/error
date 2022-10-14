package trapp.umin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import trapp.umin.models.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DataDAO {
    private static final AtomicInteger ID=new AtomicInteger(0);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DataDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Data> show(){
        return jdbcTemplate.query("SELECT * FROM Data", new BeanPropertyRowMapper<>(Data.class));
    }

    public Data index(int id){
        return jdbcTemplate.query("SELECT * FROM Data WHERE id=?",new Object[]{id},new BeanPropertyRowMapper<>(Data.class)).stream().findAny().orElse(null);
    }

    public void create(Data data){
        jdbcTemplate.update("INSERT INTO Data(name,surname,wallet,lock) VALUES (?,?,?,?)",data.getName(),data.getSurname(),data.getWallet(),data.getLock());
    }

    public void update(int id,Data data){
        jdbcTemplate.update("UPDATE Data SET name=?,surname=?,wallet=?,lock=? WHERE id=?",data.getName(),data.getSurname(),data.getWallet(),data.getLock(),id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Data WHERE id=?",id);
    }

}