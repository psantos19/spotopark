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
    private int park_id;
    @Column(name = "park_address")
    private int park_address;
    @Column(name = "park_coordinates")
    private int park_coordinates;
   
    public int getPark_id() {
        return park_id;
    }

    public int getPark_address() {
        return park_address;
    }

    public int getPark_coordinates() {
        return park_coordinates;
    }
}
