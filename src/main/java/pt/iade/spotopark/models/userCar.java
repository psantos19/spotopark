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
    @Column(name = "user_car_id", nullable = false)
    private int userCarId;
    @Column(name = "user_car_plate", nullable = false, length = 60)
    private String userCarPlate;
    @Column(name = "user_car_year", nullable = false)
    private int userCarYear;
    @Column(name = "user_brand", nullable = false, length = 30)
    private String userBrand;
    @Column(name = "car_user_id", nullable = false)
    private int carUserId;

    public int getUserCarId(){
        return userCarId;
    }

    public void setUserCarId(Integer userCarId) {
        this.userCarId = userCarId;
    }
    
    public String getUserCarPlate(){
        return userCarPlate;
    }

    public void setUserCarPlate(String userCarPlate) {
        this.userCarPlate = userCarPlate;
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
