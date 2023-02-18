package com.whatsapp.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @Project
 * @Created by Author (remzisahbaz)
 * @Date (5.02.2023)
 **/

@RestController
@RequestScope
@RequestMapping ("/")
public class RestApiController {

    public static final String ACCOUNT_SID = "AC434a75897ffa2a5f3be3b28e51d792d2";
    public static final String AUTH_TOKEN = "17bff3cd9a5ab75177a4c968849cd18d";
    public static final String AUTH_TOKEN2 = "17bff3cd9a5ab75177a4c968849cd18d";

    @GetMapping ()
    private String init() {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+905307718154"),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        "Merhaba ben remzi, postman'dan mesaj atıyorum! ")
                .create();

        return message.getBody();
    }


}
