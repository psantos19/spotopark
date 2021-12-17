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
    private String parkAddress;
    @Column(name = "park_coordinates", nullable = false, length = 60)
    private String parkCoordinates;
   
    public parking(){}

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public String getParkAddress() {
        return parkAddress;
    }

    public void setParkAddress(String parkAddress) {
        this.parkAddress = parkAddress;
    }

    public String getParkCoordinates() {
        return parkCoordinates;
    }

    public void setParkCoordinates(String parkCoordinates) {
        this.parkCoordinates = parkCoordinates;
    }
}
