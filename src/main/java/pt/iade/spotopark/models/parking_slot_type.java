package pt.iade.spotopark.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_slot_type")
public class parking_slot_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id ")
    private int type_id ;
    @Column(name = "type_name ")
    private String type_name ;

    public int getType_id() {
        return type_id;
    }

    public String getType_name() {
        return type_name;
    }
}
