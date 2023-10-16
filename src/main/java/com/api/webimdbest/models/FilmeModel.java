package com.api.webimdbest.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "filme_DB")
public class FilmeModel implements Serializable {

    @Id
    private String id;
    @Column(nullable = true, length = 10)
    private String rank;
    @Column(nullable = true, length = 100)
    private String title;
    @Column(nullable = true, length = 250)
    private String fullTitle;
    @Column(nullable = true, length = 5)
    private String year ;
    @Column(nullable = true, length = 250)
    private String image;
    @Column(nullable = true, length = 250)
    private String crew;
    @Column(nullable = true, length = 50)
    private String imDbRating;
    @Column(nullable = true)
    private String imDbRatingCount;

    public String getid() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getImDbRatingCount() {
        return imDbRatingCount;
    }

    public void setImDbRatingCount(String imDbRatingCount) {
        this.imDbRatingCount = imDbRatingCount;
    }
}
