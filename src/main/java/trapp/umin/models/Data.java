package trapp.umin.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Data {

    private int id;

    @NotEmpty(message = "Name should be not empty")
    @Size(min = 2,max = 20,message = "Name should be between 2 and 20 characters")
    private String name;
    @NotEmpty(message = "Surname should be not empty")
    @Size(min = 2,max = 20,message = "Surname should be between 2 and 20 characters")
    private String surname;
    @Min(value = 0, message = "Wallet should be more then 0")
    private int wallet;
    private String lock;

    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public void setWallet(int wallet){
        this.wallet=wallet;
    }
    public void setLock(String lock){
        this.lock=lock;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getWallet(){
        return wallet;
    }
    public String getLock(){
        return lock;
    }
}
