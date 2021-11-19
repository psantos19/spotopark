package pt.iade.spotopark.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_slot")
public class parkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_slot_id")
    private int parkingSlotId;
    @Column(name = "parking_slot_number")
    private int parkingSlotNumber;
    @Column(name = "parking_type_id")
    private int parkingTypeId;
    @Column(name = "parking_park_id")
    private int parkingParkId;

    public int getParkingSlotId() {
        return parkingSlotId;
    }

    public int getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public int getParkingTypeId() {
        return parkingTypeId;
    }

    public int getParkingParkId() {
        return parkingParkId;
    }
}
