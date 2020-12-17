package com.example.customlist;

public class Person
{
    private String repname;
    private String owname;

    public Person(String repname, String owname) {
        this.repname = repname;
        this.owname = owname;
    }

    public String getRepname() {
        return repname;
    }

    public void setRepname(String repname) {
        this.repname = repname;
    }

    public String getOwname() {
        return owname;
    }

    public void setOwname(String owname) {
        this.owname = owname;
    }
}
