package com.mz.example.api;

import com.mz.example.service.identity.IdentityPerformanceTestingService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController("api/test")
public class TestControler {

    @Autowired
    private MeterRegistry meterRegistry;
    @Autowired
    private IdentityPerformanceTestingService identityPerformanceTestingService;

    @RequestMapping(method = RequestMethod.GET, value = TestRequestMapping.IDENTITY_METHOD)
    public void handleIdentityTest(@RequestParam long testSize){
        long currentlyProcessed = 0;
        while(currentlyProcessed < testSize) {
            int nextPackageSize = nextPackageSize(currentlyProcessed, testSize);
            Timer.Sample sample = Timer.start(meterRegistry);
            identityPerformanceTestingService.performanceTest(nextPackageSize);
            sample.stop(Timer.builder(PerformanceTestMetrics.IDENTITY_STATISTICS_METRIC)
                    .tags(Tags.of(
                            Tag.of(PerformanceTestMetrics.EVENTS_COUNT_TAG, String.valueOf(nextPackageSize))
                    ))
                    .register(meterRegistry));
            currentlyProcessed += nextPackageSize;
        }
    }

    private int nextPackageSize(long currentlyProcessed, long testSize){
        if(testSize - currentlyProcessed <  IdentityPerformanceTestingService.MAX_PACKAGE_SIZE){
            return (int) (testSize - currentlyProcessed);
        }
        return ThreadLocalRandom.current().nextInt(0, IdentityPerformanceTestingService.MAX_PACKAGE_SIZE + 1);
    }

    private static class TestRequestMapping {

        private static final String IDENTITY_METHOD = "identity";
    }

    private static class PerformanceTestMetrics {

        public static final String IDENTITY_STATISTICS_METRIC = "identity_statistics";

        public static final String EVENTS_COUNT_TAG = "events_count";
    }
}
