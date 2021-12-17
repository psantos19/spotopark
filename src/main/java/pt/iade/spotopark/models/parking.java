package pt.iade.spotopark.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking")
public class parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "park_id", nullable = false)
    private int parkId;
    @Column(name = "park_address", nullable = false, length = 60)
    private int parkAddress;
    @Column(name = "park_coordinates", nullable = false, length = 60)
    private int parkCoordinates;
   
    public parking(){}

    public int getParkId() {
        return parkId;
    }
    
    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public int getPark_address() {
        return parkAddress;
    }

    public void setParkAddress(Integer parkAddress) {
        this.parkAddress = parkAddress;
    }

    public int getPark_coordinates() {
        return parkCoordinates;
    }

    public void setParkCoordinates(Integer parkCoordinates) {
        this.parkCoordinates = parkCoordinates;
    }

}
