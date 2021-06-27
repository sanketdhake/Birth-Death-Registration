package com.example.bdregistration;

public class death {

    String username,usergen,deathdate,deathtime,deathplace,docname,father,mother,wihu,wihurel,othname,othrel,othphn,otheml,homeno,street,taluka,distric,state;
    boolean dcert=false;
    public death() { }

    public death(String username, String usergen, String deathdate, String deathtime, String deathplace, String docname, String father, String mother, String wihu, String wihurel, String othname, String othrel, String othphn, String otheml, String homeno, String street, String taluka, String distric, String state,boolean dcert) {
        this.username = username;
        this.usergen = usergen;
        this.deathdate = deathdate;
        this.deathtime = deathtime;
        this.deathplace = deathplace;
        this.docname = docname;
        this.father = father;
        this.mother = mother;
        this.wihu = wihu;
        this.wihurel = wihurel;
        this.othname = othname;
        this.othrel = othrel;
        this.othphn = othphn;
        this.otheml = otheml;
        this.homeno = homeno;
        this.street = street;
        this.taluka = taluka;
        this.distric = distric;
        this.state = state;
        this.dcert=dcert;
    }

    public String getUsername() {
        return username;
    }

    public String getUsergen() {
        return usergen;
    }

    public String getDeathdate() {
        return deathdate;
    }

    public String getDeathtime() {
        return deathtime;
    }

    public String getDeathplace() {
        return deathplace;
    }

    public String getDocname() {
        return docname;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getWihu() {
        return wihu;
    }

    public String getWihurel() {
        return wihurel;
    }

    public String getOthname() {
        return othname;
    }

    public String getOthrel() {
        return othrel;
    }

    public String getOthphn() {
        return othphn;
    }

    public String getOtheml() {
        return otheml;
    }

    public String getHomeno() {
        return homeno;
    }

    public String getStreet() {
        return street;
    }

    public String getTaluka() {
        return taluka;
    }

    public String getDistric() {
        return distric;
    }

    public String getState() {
        return state;
    }

    public boolean getDcert() {
        return dcert;
    }
}
