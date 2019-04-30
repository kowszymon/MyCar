package kowszymon.ownProjects.myCar.entities;

import java.math.BigInteger;

public enum Fuel {

    EMPTY(""), PB95("PB95"), PB98("PB98"), LPG("LPG"), ON("ON");

    private String name;

    Fuel(String s) {
        this.name = s;
    }

    public String getName(){
        return this.name;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
