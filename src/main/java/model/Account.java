package model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;

    public Account() {
    }

    public Account(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
