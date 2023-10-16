package com.ndirangu.personservice.entity;

public class Coach implements Person{
    @Override
    public String getJob() {
        return "Bark out instructions";
    }
}
