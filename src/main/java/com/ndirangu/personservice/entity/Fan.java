package com.ndirangu.personservice.entity;

public class Fan implements  Person {
    @Override
    public String getJob() {
        return "Cheer for team";
    }
}
