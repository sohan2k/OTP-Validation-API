package io.sohan.twillo.serivce;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.sohan.twillo.configuration.TwilioConfig;
import io.sohan.twillo.dto.SmsDto;
import io.sohan.twillo.entites.GeneratedOtp;
import io.sohan.twillo.entites.Otp;
import io.sohan.twillo.entites.User;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    private final TwilioConfig twilioConfig;


    public SmsService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    public void send(User user){
        //try{
//            int min = 10000;
//            int max = 99999;
//            int code = (int) (Math.random() * (max - min) + min);
//            String msg = "Your OTP is:" + code + " for test spring message api";
            SmsDto smsDto=new SmsDto();
            smsDto.generate(user.getPhoneNo());
            GeneratedOtp generatedOtp=new GeneratedOtp();
            generatedOtp.setOtp(smsDto.getCode());
            generatedOtp.setExpirytime(smsDto.getExpirytime());

            Message message = Message.creator(new PhoneNumber(smsDto.getPhoneNo())
                    , new PhoneNumber(twilioConfig.getFROM_NUMBER()), smsDto.getMessage()).create();
        //}
    }

    public Boolean validate(int otp){
        int generatedOtp=GeneratedOtp.getOtp();
//        //System.out.println(otp.getOtp());
        if(otp== generatedOtp)
            return true;
        return false;
    }
}
