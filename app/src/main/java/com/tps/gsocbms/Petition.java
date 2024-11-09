package com.tps.gsocbms;

public class Petition {

    public String email;
    public String petitionText;
    public String status;
    public String title;

    public Petition(String email, String petitionText, String status, String title) {
        this.email = email;
        this.petitionText = petitionText;
        this.status = status;
        this.title = title;
    }

    public Petition(){

    }

    public String getEmail() {
        return email;
    }

    public String getPetitionText() {
        return petitionText;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
