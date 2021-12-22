package pt.iade.spotopark.models;

import java.sql.Timestamp;

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
    @Column(name = "reserve_id", nullable = false)
    private int reserveId;
    @Column(name = "reserve_ask_time", nullable = false)
    private Timestamp reserveAskTime;

    /*@Column(name = "reserve_start_time", nullable = false)
    private Timestamp reserveStartTime;
    @Column(name = "reserve_end_time", nullable = false)
    private Timestamp reserveEndTime;*/

    @Column(name = "reserve_car_id", nullable = false)
    private int reserveCarId;
    @Column(name = "reserve_parking_slot_id", nullable = false)
    private int reserveParkingSlotId;

    public reserve() {
    }

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    public Timestamp getReserveAskTime() {
        return reserveAskTime;
    }

    public void setReserveAskTime(Timestamp reserveAskTime) {
        this.reserveAskTime = reserveAskTime;
    }

    /*public Timestamp getReserveStartTime() {
        return reserveStartTime;
    }

    public void setReserveStartTime(Timestamp reserveStartTime) {
        this.reserveStartTime = reserveStartTime;
    }

    public Timestamp getReserveEndTime() {
        return reserveEndTime;
    }

    public void setReserveEndTime(Timestamp reserveEndTime) {
        this.reserveEndTime = reserveEndTime;
    }*/

    public int getReserveCarId() {
        return reserveCarId;
    }

    public void setReserveCarId(int reserveCarId) {
        this.reserveCarId = reserveCarId;
    }

    public int getReserveParkingSlotId() {
        return reserveParkingSlotId;
    }

    public void setReserveParkingSlotId(int reserveParkingSlotId) {
        this.reserveParkingSlotId = reserveParkingSlotId;
    }

}
