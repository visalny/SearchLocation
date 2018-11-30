package com.weather.pc.finalckcc_java.entity;

public class Location {
    private String locaton_name;
    private String location_email;
    private String location_facepage;
    private String location_website;
    private String location_address;
    private String location_contact;
    private String location_image;

    public Location() {
    }

    public Location(String locaton_name, String location_email, String location_facepage, String location_website, String location_address, String location_contact, String location_image) {
        this.locaton_name = locaton_name;
        this.location_email = location_email;
        this.location_facepage = location_facepage;
        this.location_website = location_website;
        this.location_address = location_address;
        this.location_contact = location_contact;
        this.location_image = location_image;
    }

    public String getLocaton_name() {
        return locaton_name;
    }

    public void setLocaton_name(String locaton_name) {
        this.locaton_name = locaton_name;
    }

    public String getLocation_email() {
        return location_email;
    }

    public void setLocation_email(String location_email) {
        this.location_email = location_email;
    }

    public String getLocation_facepage() {
        return location_facepage;
    }

    public void setLocation_facepage(String location_facepage) {
        this.location_facepage = location_facepage;
    }

    public String getLocation_website() {
        return location_website;
    }

    public void setLocation_website(String location_website) {
        this.location_website = location_website;
    }

    public String getLocation_address() {
        return location_address;
    }

    public void setLocation_address(String location_address) {
        this.location_address = location_address;
    }

    public String getLocation_contact() {
        return location_contact;
    }

    public void setLocation_contact(String location_contact) {
        this.location_contact = location_contact;
    }

    public String getLocation_image() {
        return location_image;
    }

    public void setLocation_image(String location_image) {
        this.location_image = location_image;
    }
}
