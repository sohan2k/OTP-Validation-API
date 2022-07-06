package io.sohan.twillo.configuration;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {
    @Autowired
    public TwilioInitializer(TwilioConfig twilioConfig) {
        Twilio.init(twilioConfig.getACCOUNT_SID(),twilioConfig.getAUTH_TOKEN());
    }
}
