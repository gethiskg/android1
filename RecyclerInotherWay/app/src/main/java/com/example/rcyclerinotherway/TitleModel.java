package com.example.rcyclerinotherway;

import java.io.Serializable;

public class TitleModel implements Serializable {
    public String name;
    public String phoneNumber;
    public String image;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getImage() {
        return image;
    }
}
