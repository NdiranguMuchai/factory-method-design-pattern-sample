package com.ndirangu.personservice.factory;

import com.ndirangu.personservice.entity.Person;

public class FactoryClient {

    public static void main(String[] args) {
        String type = "var";

        Person official = PersonFactory.createPerson(type);

        System.out.println(official.getJob());
    }
}
