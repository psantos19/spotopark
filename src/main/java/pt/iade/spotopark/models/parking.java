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
    @Column(name = "park_id")
    private int parkId;
    @Column(name = "park_address")
    private int parkAddress;
    @Column(name = "park_coordinates")
    private int parkCoordinates;
   
    public int getParkId() {
        return parkId;
    }

    public int getPark_address() {
        return parkAddress;
    }

    public int getPark_coordinates() {
        return parkCoordinates;
    }
}
