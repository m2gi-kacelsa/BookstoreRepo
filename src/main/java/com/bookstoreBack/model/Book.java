/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstoreBack.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DELL_PC
 */
@Entity
public class Book {
    
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 200)
    private String title;
    
    @Column(length = 1000)
    private String description;
    
    @Column(name = "unit_cost")
    private float unitCost;
    private String isbn;
    
    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    
    @Column(name = "nb_of_pages")
    private Integer nbOfPages;
    
    @Column(name = "image_url")
    private String imageURL;
    private Language language;

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

    public float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getNbOfPages() {
        return nbOfPages;
    }

    public void setNbOfPages(Integer nbOfPages) {
        this.nbOfPages = nbOfPages;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Float.floatToIntBits(this.unitCost);
        hash = 67 * hash + Objects.hashCode(this.isbn);
        hash = 67 * hash + Objects.hashCode(this.publicationDate);
        hash = 67 * hash + Objects.hashCode(this.nbOfPages);
        hash = 67 * hash + Objects.hashCode(this.imageURL);
        hash = 67 * hash + Objects.hashCode(this.language);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (Float.floatToIntBits(this.unitCost) != Float.floatToIntBits(other.unitCost)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.imageURL, other.imageURL)) {
            return false;
        }
        if (!Objects.equals(this.publicationDate, other.publicationDate)) {
            return false;
        }
        if (!Objects.equals(this.nbOfPages, other.nbOfPages)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", description=" + description + ", unitCost=" + unitCost + ", isbn=" + isbn + ", publicationDate=" + publicationDate + ", nbOfPages=" + nbOfPages + ", imageURL=" + imageURL + ", language=" + language + '}';
    }
    
    
    
    
    
    
    
}
