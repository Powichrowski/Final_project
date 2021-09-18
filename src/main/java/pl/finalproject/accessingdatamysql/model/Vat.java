package pl.finalproject.accessingdatamysql.model;

import javax.persistence.*;

@Entity
@Table(name = "vat")
public class Vat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double grocery;
    private Double bills;
    private Double entertainment;
    private Double services;
    private Double alcohol;
    private Double cigarettes;

    @OneToOne(mappedBy = "vat")
//    @JoinColumn(name = "users_login")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getGrocery() {
        return grocery;
    }

    public void setGrocery(Double grocery) {
        this.grocery = grocery;
    }

    public Double getBills() {
        return bills;
    }

    public void setBills(Double bills) {
        this.bills = bills;
    }

    public Double getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(Double entertainment) {
        this.entertainment = entertainment;
    }

    public Double getServices() {
        return services;
    }

    public void setServices(Double services) {
        this.services = services;
    }

    public Double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }

    public Double getCigarettes() {
        return cigarettes;
    }

    public void setCigarettes(Double cigarettes) {
        this.cigarettes = cigarettes;
    }
}
