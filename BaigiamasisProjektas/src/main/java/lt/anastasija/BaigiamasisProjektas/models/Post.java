package lt.anastasija.BaigiamasisProjektas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="title")
    @NotBlank(message = "{NotBlank.Post.title}")
    private String title;
    @Column(name="company_name")
    @NotBlank
    private String company_name;
    @Column(name="position")
    private String  position;
    @Column(name="email")
    private String  email;
    @Column(name="answer")
    private String  answer;
    @Column(name="full_text")
    private String full_text;
    @Column(name="salary")
    private int salary;
    @Column(name="views")
    private int views;
    @Column(name="date_of_application")
    private LocalDate date_of_application;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getViews() {
        return views;
    }

    public LocalDate getDate_of_application() {
        return date_of_application;
    }

    public void setDate_of_application(LocalDate date_of_application) {
        this.date_of_application = date_of_application;
    }
    public void setViews(int views) {
        this.views = views;
    }

    public Post() {
    }

    public Post(String title, String company_name, String position, String email, String answer, String full_text, int salary, LocalDate date_of_application) {
        this.title = title;
        this.company_name = company_name;
        this.position = position;
        this.email = email;
        this.answer = answer;
        this.full_text = full_text;
        this.salary = salary;
        this.date_of_application = date_of_application;
    }
}











