package io.sohan.twillo.repository;

import io.sohan.twillo.entites.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp,Long> {
    Optional<Otp> findByOtp(int otp);
}
