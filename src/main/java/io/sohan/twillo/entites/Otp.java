package io.sohan.twillo.entites;

import io.sohan.twillo.entites.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int otp;
    private String phoneNo;
    private Date expiryTime;

    @Builder.Default
    @Enumerated(value = EnumType.STRING)
    private Status status=Status.Failed;
    public void generate(String phoneNo){
        this.phoneNo=phoneNo;
        this.otp=(int) (Math.random()*(99999-10000)+10000);
        //this.msg="Your OTP is:"+ phoneNo +" for test spring message api";
        this.expiryTime=new Date(System.currentTimeMillis()+1000*120);
    }

}
