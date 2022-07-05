package io.sohan.twillo.controller;

import io.sohan.twillo.configuration.SmsService;
import io.sohan.twillo.entites.GeneratedOtp;
import io.sohan.twillo.entites.Otp;
import io.sohan.twillo.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {
    @Autowired
    private SmsService smsService;

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestBody User user) {
        try {
            smsService.send(user);
            System.out.println(user.getPhoneNo());
            return new ResponseEntity<>("Otp send Successfully ", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
//        smsService.send(user);
//        System.out.println(user.getPhoneNo());
//        return "Otp send Successfully ";
        return new ResponseEntity<>("failure ", HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("/validate")
    public ResponseEntity<String> validateOtp(@RequestBody Otp otp){
        int generatedOtp=GeneratedOtp.getOtp();
        //System.out.println(otp.getOtp());
        if(otp.getOtp()== generatedOtp)
            return new ResponseEntity<>("Correct OTP", HttpStatus.OK);
        return new ResponseEntity<>("Wrong OTP ", HttpStatus.UNAUTHORIZED);
    }

}
