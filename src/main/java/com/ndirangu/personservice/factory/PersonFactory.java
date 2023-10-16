package com.ndirangu.personservice.factory;

import com.ndirangu.personservice.entity.*;

public class PersonFactory {

    public static Person createPerson(String type){
        if (type.equalsIgnoreCase("coach")){
            return new Coach();
        } else if (type.equalsIgnoreCase("fan")) {
            return new Fan();
        } else if (type.equalsIgnoreCase("player")) {
            return new Player();
        } else if (type.equalsIgnoreCase("var")) {
            return new VAROfficial();
        }

        throw new IllegalArgumentException("No such person.");
    }
}
