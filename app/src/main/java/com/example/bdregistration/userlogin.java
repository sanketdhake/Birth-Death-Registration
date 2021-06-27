package com.example.bdregistration;


public class userlogin {

    String id,uUsername,uPassword,uRepassword,uName,uAddress,uPhone,uEmail,uAdharCard;
    boolean flg,flg1,dflg,dflg1,cert;
    public  userlogin(){}
    //  public userlogin(String s11,boolean flg)
    //{
    //    this.flg=flg;
    //}

    public userlogin( String id ,String uUsername,String uPassword,String uRepassword,String uName,String uAddress,String uPhone,String uEmail,String uAdharCard, boolean flg1,boolean flg,boolean dflg,boolean dflg1)
    {
        this.flg=flg;
        this.id=id;
        this.uUsername=uUsername;
        this.uPassword=uPassword;
        this.uRepassword=uRepassword;
        this.uName=uName;
        this.uAddress=uAddress;
        this.uPhone=uPhone;
        this.uEmail=uEmail;
        this.dflg=dflg;
        this.dflg1=dflg1;
        this.flg1=flg1;
        this.uAdharCard=uAdharCard;

    }

    public boolean getFlg1() {
        return flg1;
    }

    public boolean getDflg() {
        return dflg;
    }

    public boolean getDflg1() {
        return dflg1;
    }

    public boolean getFlg() {
        return flg;
    }

    public String getId(){
        return  id;
    }
    public String getuUsername()
    {
        return uUsername;
    }
    public String getuPassword()
    {
        return  uPassword;
    }
    public String getuRepassword()
    {
        return uRepassword;
    }
    public String getuName()
    {
        return uName;
    }
    public String getuAddress()
    {
        return uAddress;
    }
    public String getuPhone()
    {
        return uPhone;
    }
    public String getuEmail()
    {
        return uEmail;
    }
    public String getuAdharCard()
    {
        return uAdharCard;
    }

}
