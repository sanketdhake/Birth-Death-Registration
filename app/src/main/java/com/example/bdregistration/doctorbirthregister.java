package com.example.bdregistration;

public class doctorbirthregister {

    private String id,bFatherName,bFatherPhone,bFatherEmail,bFatherAdharCard,bMotherName,bMotherPhone,bMotherEmail,bMotherAdharCard,bChildGender,bChildDate,bChildTime,bChildPlace,bChildBloodGroup,bAddressHome,bAddressStreet,bAddressTaluka,bAddressDistrict,bAddressState;

    public doctorbirthregister(){}
    public doctorbirthregister( String id ,String bFatherName,String bFatherPhone,String bFatherEmail,String bFatherAdharCard,String bMotherName,String bMotherPhone,String bMotherEmail,String bMotherAdharCard,String bChildGender ,String bChildDate,String bChildTime,String bChildPlace,String bChildBloodGroup,String bAddressHome,String bAddressStreet,String bAddressTaluka,String bAddressDistrict,String bAddressState)
    {
        this.id=id;
        this.bFatherName=bFatherName;
        this.bFatherPhone=bFatherPhone;
        this.bFatherEmail=bFatherEmail;
        this.bFatherAdharCard=bFatherAdharCard;
        this.bMotherName=bMotherName;
        this.bMotherPhone=bMotherPhone;
        this.bMotherEmail=bMotherEmail;
        this.bMotherAdharCard=bMotherAdharCard;
        this.bChildGender=bChildGender;
        this.bChildDate=bChildDate;
        this.bChildTime=bChildTime;
        this.bChildPlace=bChildPlace;
        this.bChildBloodGroup=bChildBloodGroup;
        this.bAddressHome=bAddressHome;
        this.bAddressStreet=bAddressStreet;
        this.bAddressTaluka=bAddressTaluka;
        this.bAddressDistrict=bAddressDistrict;
        this.bAddressState=bAddressState;

    }

    public String getId(){
        return  id;
    }
    public String getbFatherName()
    {
        return bFatherName;
    }
    public String getbFatherPhone()
    {
        return  bFatherPhone;
    }
    public String getbFatherEmail()
    {
        return bFatherEmail;
    }
    public String getbFatherAdharCard()
    {
        return bFatherAdharCard;
    }
    public String getbMotherName()
    {
        return bMotherName;
    }
    public String getbMotherPhone()
    {
        return bMotherPhone;
    }
    public String getbMotherEmail()
    {
        return bMotherEmail;
    }
    public String getbMotherAdharCard()
    {
        return bMotherAdharCard;
    }
    public String getbChildGender(){
        return  bChildGender;
    }
    public String getbChildDate()
    {
        return bChildDate;
    }
    public String getbChildTime()
    {
        return  bChildTime;
    }
    public String getbChildPlace()
    {
        return bChildPlace;
    }
    public String getbChildBloodGroup()
    {
        return bChildBloodGroup;
    }
    public String getbAddressHome()
    {
        return bAddressHome;
    }
    public String getbAddressStreet()
    {
        return bAddressStreet;
    }
    public String getbAddressTaluka()
    {
        return bAddressTaluka;
    }
    public String getbAddressDistrict()
    {
        return bAddressDistrict;
    }
    public String getbAddressState()
    {
        return bAddressState;
    }

}
