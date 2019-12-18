package com.zzh.demo.quartz;

import com.zzh.demo.util.WeatherUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestTask3 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("--WeatherUtil.query()--");
        WeatherUtil.query();
    }
}
