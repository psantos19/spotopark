package pt.iade.spotopark.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilizador")
public class utilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilizador_id") private int id;
    @Column(name = "utilizador_name") private String name;
    @Column(name = "utilizador_password") private String password;
    @Column(name = "utilizador_bdate") private String bdate;
    @Column(name = "utilizador_email") private String email;
    @Column(name = "utilizador_coordinates") private String coordinates;

    public utilizador() {

        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getBdate() {
        return bdate;
    }

    public String getEmail() {
        return email;
    }

    public String getCoordinates() {
        return coordinates;
    }
}
