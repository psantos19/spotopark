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
    private int reserveId;
    @Column(name = "reserve_ask_time")
    private String reserveAskTime;
    @Column(name = "reserve_start_time")
    private int reserveStartTime;
    @Column(name = "reserve_end_time")
    private String reserveEndTime;
    @Column(name = "reserve_carId")
    private int reserveCarId;
    @Column(name = "reserve_parking_slotId")
    private int reserveParkingSlotId;

    public int getReserveId() {
        return reserveId;
    }

    public String getReserveAskTime() {
        return reserveAskTime;
    }

    public int getReserveStartTime() {
        return reserveStartTime;
    }

    public String getReserveEndTime() {
        return reserveEndTime;
    }

    public int getReserveCarId() {
        return reserveCarId;
    }

    public int getReserveParkingSlotId() {
        return reserveParkingSlotId;
    }
}
