package kowszymon.ownProjects.myCar.entities;


public enum Fuel {

    PB95("PB95"), PB98("PB98"), LPG("LPG"), ON("ON");

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
