package io.sohan.twillo.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.sohan.twillo.configuration.TwilioConfig;
import io.sohan.twillo.dto.OtpDto;
import io.sohan.twillo.entites.Otp;
import io.sohan.twillo.entites.User;
import io.sohan.twillo.entites.enums.Status;
import io.sohan.twillo.repository.OtpRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SmsService {
    private final TwilioConfig twilioConfig;
    private final OtpRepository otpRepository;
    public SmsService(TwilioConfig twilioConfig, OtpRepository otpRepository) {
        this.twilioConfig = twilioConfig;
        this.otpRepository = otpRepository;
    }
    public Boolean send(User user) {
//        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        Otp otp = new Otp();
        try {
            otp.generate(user.getPhoneNo());

            String msg="Your OTP is:"+ otp.getOtp() +" for test spring message api";

            System.out.println("before =>"+otp.getPhoneNo()+"\n"+otp.getOtp()+"\n"+msg+"\n"+otp.getStatus());

            Message message = Message.creator(new PhoneNumber(otp.getPhoneNo())
                    , new PhoneNumber(twilioConfig.getFRM_NUMBER()), msg).create();
            otp.setStatus(Status.Delivered);
            otpRepository.save(otp);
            return true;
        }catch (Exception e){
            //otpRepository.save(otp);
            e.printStackTrace();
            return false;
        }

    }
    public Boolean isValid(OtpDto otpDto){
        Optional<Otp>  optionalOtp=otpRepository.findByOtp(otpDto.getOtp());
        Otp otp=optionalOtp.get();
        if(otp.getExpiryTime().before(new Date())){
            otpRepository.delete(otp);
            return true;
        }
        return false;
    }
}
