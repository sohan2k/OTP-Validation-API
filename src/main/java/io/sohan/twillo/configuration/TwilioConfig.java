package io.sohan.twillo.configuration;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class TwilioConfig {
    @Value("${twilio.ACCOUNT_SID}")
    private String ACCOUNT_SID;
    @Value("${twilio.AUTH_TOKEN}")
    private String AUTH_TOKEN;
    @Value("${twilio.FRM_NUMBER}")
    private String FRM_NUMBER;

    //    public void send(User user)throws ParseException{
//        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
//        int min=10000;
//        int max=99999;
//        int code= (int) (Math.random()*(max-min)+min);
//        String msg="Your OTP is:"+ code +" for test spring message api";
//
//        Message message=Message.creator(new PhoneNumber(user.getPhoneNo())
//                ,new PhoneNumber(FRM_NUMBER),msg).create();
//
//        GeneratedOtp.setOtp(code);
//    }
}
