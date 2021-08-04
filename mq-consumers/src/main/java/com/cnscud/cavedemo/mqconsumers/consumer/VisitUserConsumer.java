package com.cnscud.cavedemo.mqconsumers.consumer;

import com.cnscud.xpower.mq.kafka.Consumers;
import com.cnscud.xpower.mq.unified.IMessageListener;
import com.cnscud.xpower.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Visit User Consumer.
 *
 * @author Felix Zhang 2021-08-04 18:00
 * @version 1.0.0
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class VisitUserConsumer implements DisposableBean, InitializingBean, Runnable, IMessageListener<String> {
    private final Logger logger = LoggerFactory.getLogger(VisitUserConsumer.class);
    final List<Consumers> consumers = new ArrayList<>();

    String mq_topic = "user_visit";

    @Override
    public void destroy() throws Exception {
        for (Consumers c : consumers) {
            c.close();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(this).start();
    }

    @Override
    public void run() {
        consumers.add(Consumers.buildConsumer(mq_topic, "default", this, "smallest"));
    }

    @Override
    public void onMessage(String s) {
        parseMessage(s);
    }

    private void parseMessage(String message) {

            Map<String, Object> messageMap = JsonUtils.toMap2(message);

            logger.info("userid: " + messageMap.get("userid") + " at " + messageMap.get("time"));
    }

}