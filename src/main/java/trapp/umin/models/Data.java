package trapp.umin.models;


import jakarta.persistence.*;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @Column(name = "data_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    public Data(){}

    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

}
