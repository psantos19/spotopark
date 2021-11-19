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
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "user_password")
    private String user_password;
    @Column(name = "user_bdate")
    private String user_bdate;
    @Column(name = "user_email")
    private String user_email;
    @Column(name = "user_coordinates")
    private String user_coordinates;

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_bdate() {
        return user_bdate;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_coordinates() {
        return user_coordinates;
    }
}
