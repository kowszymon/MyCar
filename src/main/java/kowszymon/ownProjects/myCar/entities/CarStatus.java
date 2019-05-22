package kowszymon.ownProjects.myCar.entities;

public enum CarStatus {

    ACTIVE("ACTIVE"), ARCHIVED("ARCHIVED");

    private String name;

    CarStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
