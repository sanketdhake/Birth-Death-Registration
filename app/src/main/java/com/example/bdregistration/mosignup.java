package com.example.bdregistration;

public class mosignup {
    String srid,srname,sremail,srpass,srreg,sraddre,srregno,srphnno;
    mosignup() {

    }

    public mosignup(String srid,String srname,String sremail, String srpass, String srreg, String sraddre, String srregno,String srphnno) {
        this.srid=srid;
        this.sremail = sremail;
        this.srpass = srpass;
        this.srreg = srreg;
        this.sraddre = sraddre;
        this.srregno = srregno;
        this.srname=srname;
        this.srphnno=srphnno;
    }

    public String getSrid() {
        return srid;
    }

    public String getSrname() {
        return srname;
    }

    public String getSremail() {
        return sremail;
    }

    public String getSrpass() {
        return srpass;
    }

    public String getSrreg() {
        return srreg;
    }

    public String getSraddre() {
        return sraddre;
    }

    public String getSrregno() {
        return srregno;
    }

    public String getSrphnno() {
        return srphnno;
    }
}

