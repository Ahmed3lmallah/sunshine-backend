package com.cognizant.cde.tjfems.model;

import java.util.Objects;

public class Office {

    private Long officeId;
    private String officeName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String country;
    private boolean active = true;
    private Long managerId;
    private String website;
    private String fax;

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return isActive() == office.isActive() &&
                Objects.equals(getOfficeId(), office.getOfficeId()) &&
                Objects.equals(getOfficeName(), office.getOfficeName()) &&
                Objects.equals(getStreetAddress(), office.getStreetAddress()) &&
                Objects.equals(getCity(), office.getCity()) &&
                Objects.equals(getState(), office.getState()) &&
                Objects.equals(getZip(), office.getZip()) &&
                Objects.equals(getCountry(), office.getCountry()) &&
                Objects.equals(getManagerId(), office.getManagerId()) &&
                Objects.equals(getWebsite(), office.getWebsite()) &&
                Objects.equals(getFax(), office.getFax());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOfficeId(), getOfficeName(), getStreetAddress(), getCity(), getState(), getZip(), getCountry(), isActive(), getManagerId(), getWebsite(), getFax());
    }
}
