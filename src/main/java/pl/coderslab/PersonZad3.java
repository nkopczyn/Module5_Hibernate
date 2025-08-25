package pl.coderslab;

import jakarta.persistence.*;

@Entity
@Table(name="persons")
public class PersonZad3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;

    @OneToOne
    private PersonDetZad3 personDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonDetZad3 getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetZad3 personDetails) {
        this.personDetails = personDetails;
    }
}
