package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by 龙浩 on 2018/7/19.
 */
@Component
public class ScheduledTest {

    private final static Logger logger= LoggerFactory.getLogger(ScheduledTest.class);

    @Scheduled(cron = "*/5 * * * * ?")
    public void log() {
        logger.info("时间{}", new Date());
    }

}
