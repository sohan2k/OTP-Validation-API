package io.sohan.twillo.entites;

import java.util.Date;

public class GeneratedOtp {
    private static int otp;
    private Date expirytime;

    public static int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public Date getExpirytime() {
        return expirytime;
    }

    public void setExpirytime(Date expirytime) {
        this.expirytime = expirytime;
    }
}
