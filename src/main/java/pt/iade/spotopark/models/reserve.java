package pt.iade.spotopark.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reserve")
public class reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id")
    private int reserve_id;
    @Column(name = "reserve_ask_time")
    private String reserve_ask_time;
    @Column(name = "reserve_start_time")
    private int reserve_start_time;
    @Column(name = "reserve_end_time")
    private String reserve_end_time;
    @Column(name = "reserve_car_id")
    private int reserve_car_id;
    @Column(name = "reserve_parking_slot_id")
    private int reserve_parking_slot_id;

    public int getReserve_id(){
        return reserve_id;
    }
    
    public String getReserve_ask_time(){
        return reserve_ask_time;
    }
    
    public int getReserve_start_time(){
        return reserve_start_time;
    }
    public String getReserve_end_time(){
        return reserve_end_time;
    }

    public int getReserve_car_id(){
        return reserve_car_id;
    }
    
    public int getReserve_parking_slot_id(){
        return reserve_parking_slot_id;
    }
}
