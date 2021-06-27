package com.example.bdregistration;

public class childinfo {
    String id;
    String childfather,fatherphn,fatheremail,fatheradhar,childmother,motherphn,motheremail,motheradhar,housename,street,taluka,district,state,childname,gender,birthdate,birthtime,birthplace,bloodgroup,Hospitalname,doctorname,emailid,trusted1,trusted2,trustedr1,trustedr2;
    boolean cert=false;
    public childinfo()
    {

    }


    public childinfo(String id, String childfather, String fatherphn, String fatheremail, String fatheradhar, String childmother, String motherphn, String motheremail, String motheradhar, String housename, String street, String taluka, String district, String state, String childname, String gender, String birthdate, String birthtime, String birthplace, String bloodgroup, String hospitalname, String doctorname,String emailid,boolean cert,String trusted1,String trustedr1,String trusted2,String truestedr2) {
        this.id = id;
        this.trusted1=trusted1;
        this.trusted2=trusted2;
        this.trustedr1=trustedr1;
        this.trustedr2=truestedr2;
        this.childfather = childfather;
        this.fatherphn = fatherphn;
        this.fatheremail = fatheremail;
        this.fatheradhar = fatheradhar;
        this.childmother = childmother;
        this.motherphn = motherphn;
        this.motheremail = motheremail;
        this.motheradhar = motheradhar;
        this.housename = housename;
        this.street = street;
        this.taluka = taluka;
        this.district = district;
        this.state = state;
        this.childname = childname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.birthtime = birthtime;
        this.birthplace = birthplace;
        this.bloodgroup = bloodgroup;
        this. Hospitalname = hospitalname;
        this.doctorname = doctorname;
        this.cert=cert;
        this.emailid=emailid;
    }

    public String getTrusted1() {
        return trusted1;
    }

    public String getTrusted2() {
        return trusted2;
    }

    public String getTrustedr1() {
        return trustedr1;
    }

    public String getTrustedr2() {
        return trustedr2;
    }

    public String getId() {
        return id;
    }

    public String getChildfather() {
        return childfather;
    }

    public String getFatherphn() {
        return fatherphn;
    }

    public String getFatheremail() {
        return fatheremail;
    }

    public String getFatheradhar() {
        return fatheradhar;
    }

    public String getChildmother() {
        return childmother;
    }

    public String getMotherphn() {
        return motherphn;
    }

    public String getMotheremail() {
        return motheremail;
    }

    public String getMotheradhar() {
        return motheradhar;
    }

    public String getHousename() {
        return housename;
    }

    public String getStreet() {
        return street;
    }

    public String getTaluka() {
        return taluka;
    }

    public String getDistrict() {
        return district;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getState() {
        return state;
    }

    public String getChildname() {
        return childname;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getBirthtime() {
        return birthtime;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getHospitalname() {
        return Hospitalname;
    }

    public String getDoctorname() {
        return doctorname;
    }
    public boolean getCert() { return cert; }

}
