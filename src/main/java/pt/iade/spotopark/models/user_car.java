package pt.iade.spotopark.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_car")
public class user_car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_car_id")
    private int user_car_id;
    @Column(name = "user_car_plate")
    private String user_car_plate;
    @Column(name = "user_car_year")
    private int user_car_year;
    @Column(name = "user_brand")
    private String user_brand;
    @Column(name = "car_user_id")
    private int car_user_id;

    public int getUser_car_id(){
        return user_car_id;
    }
    
    public String getUser_car_plate(){
        return user_car_plate;
    }
    
    public int getUser_car_year(){
        return user_car_year;
    }
    public String getUser_brand(){
        return user_brand;
    }

    public int getCar_user_id(){
        return car_user_id;
    }
}
