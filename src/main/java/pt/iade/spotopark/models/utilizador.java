package pt.iade.spotopark.models;

import java.time.LocalDate;

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
    @Column(name = "utilizador_id", nullable = false)
    private int id;

    @Column(name = "utilizador_name", nullable = false, length = 60)
    private String name;

    @Column(name = "utilizador_password", nullable = false, length = 60)
    private String password;

    @Column(name = "utilizador_bdate", nullable = false)
    private LocalDate bdate;

    @Column(name = "utilizador_email", nullable = false, length = 100)
    private String email;

    public utilizador() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBdate() {
        return bdate;
    }

    public void setBdate(LocalDate bdate) {
        this.bdate = bdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
