package io.sohan.twillo.configuration;

import com.twilio.Twilio;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {
    private static final String ACCOUNT_SID="AC0fa92ecabf718f4c8f83f8ebf4ddca0d";
    private static final String AUTH_TOKEN="a2cc90be8f3f5ceee9090756ea506793";
    private final String FROM_NUMBER ="+19364630170";

    public String getACCOUNT_SID() {
        return ACCOUNT_SID;
    }

    public String getAUTH_TOKEN() {
        return AUTH_TOKEN;
    }

    public String getFROM_NUMBER() {
        return FROM_NUMBER;
    }

    static {
        Twilio.init(ACCOUNT_SID ,AUTH_TOKEN);
    }

//    public static TwilioConfig() {
//        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
//    }

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
