package com.proyectalpha.BackEndProyectAlpha.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String enterpriseName;
    private String offerName;
    private String responsibility;
    private String requeriments;
    private String summary;
    private String salary;
    private String modality;
    private Date date;
    private String location;

    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="Offers_has_Technologies"
            ,joinColumns = @JoinColumn(name="offers_id")
            ,inverseJoinColumns = @JoinColumn(name="technologies_id")
    )
    private List<Technology> technologies = new ArrayList<>();

    public void addTechnologies(Technology technology){
        technologies.add(technology);
        technology.getOffers().add(this);
    }


    public Offer() {
    }

    public Offer(Long id, String enterpriseName, String offerName, String responsibility, String requeriments, String summary, String salary, String modality, Date date, String location) {
        this.id = id;
        this.enterpriseName = enterpriseName;
        this.offerName = offerName;
        this.responsibility = responsibility;
        this.requeriments = requeriments;
        this.summary = summary;
        this.salary = salary;
        this.modality = modality;
        this.date = date;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getRequeriments() {
        return requeriments;
    }

    public void setRequeriments(String requeriments) {
        this.requeriments = requeriments;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offers = (Offer) o;
        return id.equals(offers.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


