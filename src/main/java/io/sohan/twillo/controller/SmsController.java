package io.sohan.twillo.controller;

import io.sohan.twillo.dto.OtpDto;
import io.sohan.twillo.entites.User;
import io.sohan.twillo.service.SmsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {
    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestBody User user) {
            if(smsService.send(user)){
                System.out.println(user.getPhoneNo());
                return new ResponseEntity<>("Otp send Successfully ", HttpStatus.OK);
            }
        return new ResponseEntity<>("failure ", HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("/validate")
    public ResponseEntity<String> validateOtp(@RequestBody OtpDto otpDto){
        if(smsService.isValid(otpDto))
            return new ResponseEntity<>("Correct OTP", HttpStatus.OK);
        return new ResponseEntity<>("Wrong OTP ", HttpStatus.UNAUTHORIZED);
    }

}
