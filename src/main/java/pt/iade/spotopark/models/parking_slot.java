package pt.iade.spotopark.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_slot")
public class parking_slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_slot_id")
    private int parking_slot_id;
    @Column(name = "parking_slot_number")
    private int parking_slot_number;
    @Column(name = "parking_type_id")
    private int parking_type_id;
    @Column(name = "parking_park_id")
    private int parking_park_id;

    public int getParking_slot_id() {
        return parking_slot_id;
    }

    public int getParking_slot_number() {
        return parking_slot_number;
    }

    public int getParking_type_id() {
        return parking_type_id;
    }

    public int getParking_park_id() {
        return parking_park_id;
    }
}
