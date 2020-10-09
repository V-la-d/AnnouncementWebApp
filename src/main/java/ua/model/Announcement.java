package ua.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "city_of_work")
    private String cityofwork;
    @Column(name = "date_added")
    private Date date;

    public Announcement() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCityofwork() {
        return cityofwork;
    }

    public void setCityofwork(String cityofwork) {
        this.cityofwork = cityofwork;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cityofwork='" + cityofwork + '\'' +
                ", date=" + date +
                '}';
    }
}