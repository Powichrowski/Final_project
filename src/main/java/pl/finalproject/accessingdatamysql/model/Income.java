package pl.finalproject.accessingdatamysql.model;

import javax.persistence.*;

@Entity
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Integer id;

    private Double salary;
    private String type;

    @OneToOne(mappedBy = "income")
//    @JoinColumn(name = "user_login")
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
