package io.sohan.twillo.controller;

import io.sohan.twillo.entites.Otp;
import io.sohan.twillo.entites.User;
import io.sohan.twillo.serivce.SmsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {
//    @Autowired
//    private TwilioConfig twilioConfig;

    private SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }


    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestBody User user) {
//        try {
//            twilioConfig.send(user);
//            System.out.println(user.getPhoneNo());
//            return new ResponseEntity<>("Otp send Successfully ", HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
////        smsService.send(user);
////        System.out.println(user.getPhoneNo());
////        return "Otp send Successfully ";
        try{
            smsService.send(user);
            return new ResponseEntity<>("Otp send Successfully ", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("failure ", HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("/validate")
    public ResponseEntity<String> validateOtp(@RequestBody Otp otp){
        if(smsService.validate(otp.getOtp()))
            return new ResponseEntity<>("Correct OTP", HttpStatus.OK);
        return new ResponseEntity<>("Wrong OTP ", HttpStatus.UNAUTHORIZED);
    }

}
