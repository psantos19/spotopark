package pt.iade.spotopark.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_car")
public class userCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_car_id")
    private int userCarId;
    @Column(name = "user_car_plate")
    private String userCarPlate;
    @Column(name = "user_car_year")
    private int userCarYear;
    @Column(name = "user_brand")
    private String userBrand;
    @Column(name = "car_user_id")
    private int carUserId;

    public int getUserCarId(){
        return userCarId;
    }
    
    public String getUserCarPlate(){
        return userCarPlate;
    }
    
    public int getUserCarYear(){
        return userCarYear;
    }
    public String getUserBrand(){
        return userBrand;
    }

    public int getCarUserId(){
        return carUserId;
    }
}
