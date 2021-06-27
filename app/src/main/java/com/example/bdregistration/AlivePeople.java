package com.example.bdregistration;

public class AlivePeople { String aid,amail,aname;
    public  AlivePeople(){}
    public AlivePeople(String aid,String amail,String aname){
        this.aid=aid;
        this.amail=amail;
        this.aname=aname;
    }

    public String getAid() {
        return aid;
    }

    public String getAmail() {
        return amail;
    }

    public String getAname() {
        return aname;
    }
}
