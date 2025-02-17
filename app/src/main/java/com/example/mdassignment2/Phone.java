package com.example.mdassignment2;

import androidx.annotation.NonNull;

public class Phone {
    String title;
    String Description;

    public Phone(){

    }

    public Phone(String title, String description){
        this.title=title;
        this.Description=description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return title + " " + Description;
    }
}
