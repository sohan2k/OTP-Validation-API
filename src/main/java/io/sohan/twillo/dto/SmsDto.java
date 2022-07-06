package io.sohan.twillo.dto;

import java.util.Date;

public class SmsDto {
    private String phoneNo;
    private String message;

    private int code;
    private Date expirytime;



    public SmsDto generate(String phoneNo) {
        this.phoneNo = phoneNo;
        this.message = "Your OTP is:" + code + " for test spring message api";
        this.code= (int) (Math.random() * (99999 - 1000) + 1000);
        this.expirytime = new Date(System.currentTimeMillis()+120000);
        return new SmsDto();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getExpirytime() {
        return expirytime;
    }

    public void setExpirytime(Date expirytime) {
        this.expirytime = expirytime;
    }
}
