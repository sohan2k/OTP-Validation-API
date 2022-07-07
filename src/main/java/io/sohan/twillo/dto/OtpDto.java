package io.sohan.twillo.dto;

import io.sohan.twillo.entites.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OtpDto {
    private int otp;
    @Nullable
    private String phoneNo;
    @Nullable
    private Date expiryTime;
    private Status status;
}
