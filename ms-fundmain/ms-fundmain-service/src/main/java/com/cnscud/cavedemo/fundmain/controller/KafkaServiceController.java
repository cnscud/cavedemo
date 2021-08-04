package com.cnscud.cavedemo.fundmain.controller;

import com.cnscud.xpower.mq.kafka.Producers;
import com.cnscud.xpower.mq.unified.JsonMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kafka Service Demo.
 *
 * @author Felix Zhang 2021-08-04 17:09
 * @version 1.0.0
 */
@RestController
@RequestMapping("/mq")
public class KafkaServiceController {

    String mq_topic = "user_visit";

    @RequestMapping("/visituser")
    public String visitUserById(int userid){

        final JsonMessage jsonMessage = new JsonMessage(mq_topic);
        final JsonMessage.Json json = new JsonMessage.Json();
        json.addField("userid", userid).addField("time", System.currentTimeMillis());
        Producers.buildProducer().send(jsonMessage.add(json));


        return "You visited " + userid;
    }
}
