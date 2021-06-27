package com.example.bdregistration;

public class DoctorData {


    String id1,Username,Password,FullName,Address,Phone,Adhar,Education,HospitalName,Regno,email;
    public DoctorData() {

    }
    public DoctorData(String id1,String st1,String st2,String st4,String st5,String st6,String st7,String st8,String st9,String st10,String st11)
    {
        this.id1=id1;
        this.Username=st1;
        this.Password=st2;

        this.FullName=st4;
        this.Address=st5;
        this.Phone=st6;
        this.email=st7;
        this.Adhar=st8;
        this.Education=st9;
        this.HospitalName=st10;
        this.Regno=st11;

    }

    public String getUsername() {
        return Username;
    }

    public String getId1()
    {
        return  id1;
    }
    public String getPassword() {
        return Password;
    }

    public String getFullName() {
        return FullName;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAdhar() {
        return Adhar;
    }

    public String getEducation() {
        return Education;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public String getRegno() {
        return Regno;
    }

    public String getEmail() {
        return email;
    }
}
