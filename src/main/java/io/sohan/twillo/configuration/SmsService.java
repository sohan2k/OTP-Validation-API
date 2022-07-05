package io.sohan.twillo.configuration;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.sohan.twillo.entites.GeneratedOtp;
import io.sohan.twillo.entites.User;
import org.springframework.stereotype.Component;

import java.security.PrivilegedAction;
import java.text.ParseException;
@Component
public class SmsService {
    private final String ACCOUNT_SID="AC0fa92ecabf718f4c8f83f8ebf4ddca0d";
    private final String AUTH_TOKEN="a2cc90be8f3f5ceee9090756ea506793";
    private final String FRM_NUMBER="+19364630170";

    public String getACCOUNT_SID() {
        return ACCOUNT_SID;
    }

    public String getAUTH_TOKEN() {
        return AUTH_TOKEN;
    }

    public String getFRM_NUMBER() {
        return FRM_NUMBER;
    }

    public void send(User user)throws ParseException{
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        int min=10000;
        int max=99999;
        int code= (int) (Math.random()*(max-min)+min);
        String msg="Your OTP is:"+ code +" for test spring message api";

        Message message=Message.creator(new PhoneNumber(user.getPhoneNo())
                ,new PhoneNumber(FRM_NUMBER),msg).create();

        GeneratedOtp.setOtp(code);
    }
}
