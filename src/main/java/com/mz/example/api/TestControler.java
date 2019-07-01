package com.mz.example.api;

import com.mz.example.service.BasePerformanceTestingService;
import com.mz.example.service.identity.IdentityPerformanceTestingService;
import com.mz.example.service.long_id.LongIdPerformanceTestingService;
import com.mz.example.service.no_id.NoIdPerformanceTestingService;
import com.mz.example.service.one_to_one.OneToOnePerformanceTestingService;
import io.micrometer.core.instrument.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

@RestController("api/test")
public class TestControler {

    @Autowired
    private MeterRegistry meterRegistry;
    @Autowired
    private IdentityPerformanceTestingService identityPerformanceTestingService;
    @Autowired
    private LongIdPerformanceTestingService longIdPerformanceTestingService;
    @Autowired
    private OneToOnePerformanceTestingService oneToOnePerformanceTestingService;
    @Autowired
    private NoIdPerformanceTestingService noIdPerformanceTestingService;

    @PostConstruct
    private void init(){
        Counter.builder(PerformanceTestMetrics.IDENTITY_STATISTICS_COUNT_METRIC).register(meterRegistry);
        Counter.builder(PerformanceTestMetrics.LONG_ID_STATISTICS_COUNT_METRIC).register(meterRegistry);
        Counter.builder(PerformanceTestMetrics.ONE_TO_ONE_STATISTICS_COUNT_METRIC).register(meterRegistry);
        Counter.builder(PerformanceTestMetrics.NO_ID_STATISTICS_COUNT_METRIC).register(meterRegistry);
    }

    @RequestMapping(method = RequestMethod.GET, value = TestRequestMapping.IDENTITY_METHOD)
    public void handleIdentityTest(@RequestParam long testSize){
        performPerformanceTest(
                testSize,
                identityPerformanceTestingService,
                PerformanceTestMetrics.IDENTITY_STATISTICS_TIME_METRIC,
                PerformanceTestMetrics.IDENTITY_STATISTICS_COUNT_METRIC
        );
    }

    @RequestMapping(method = RequestMethod.GET, value = TestRequestMapping.LONG_ID_METHOD)
    public void handleLongIdTest(@RequestParam long testSize){
        performPerformanceTest(
                testSize,
                longIdPerformanceTestingService,
                PerformanceTestMetrics.LONG_ID_STATISTICS_TIME_METRIC,
                PerformanceTestMetrics.LONG_ID_STATISTICS_COUNT_METRIC
        );
    }

    @RequestMapping(method = RequestMethod.GET, value = TestRequestMapping.ONE_TO_ONE_METHOD)
    public void handleOneToOneTest(@RequestParam long testSize){
        performPerformanceTest(
                testSize,
                oneToOnePerformanceTestingService,
                PerformanceTestMetrics.ONE_TO_ONE_STATISTICS_TIME_METRIC,
                PerformanceTestMetrics.ONE_TO_ONE_STATISTICS_COUNT_METRIC
        );
    }

    @RequestMapping(method = RequestMethod.GET, value = TestRequestMapping.NO_ID_METHOD)
    public void handleNoIdTest(@RequestParam long testSize){
        performPerformanceTest(
                testSize,
                noIdPerformanceTestingService,
                PerformanceTestMetrics.NO_ID_STATISTICS_TIME_METRIC,
                PerformanceTestMetrics.NO_ID_STATISTICS_COUNT_METRIC
        );
    }

    private void performPerformanceTest(long testSize, BasePerformanceTestingService service, String timeMetricName, String countMetricName){
        long currentlyProcessed = 0;
        while(currentlyProcessed < testSize) {
            int nextPackageSize = nextPackageSize(currentlyProcessed, testSize);
            Timer.Sample sample = Timer.start(meterRegistry);
            service.performanceTest(nextPackageSize);
            sample.stop(Timer.builder(timeMetricName)
                    .register(meterRegistry));
            meterRegistry.counter(countMetricName).increment(nextPackageSize);
            currentlyProcessed += nextPackageSize;
        }
    }

    private int nextPackageSize(long currentlyProcessed, long testSize){
        if(testSize - currentlyProcessed <  IdentityPerformanceTestingService.MAX_PACKAGE_SIZE){
            return (int) (testSize - currentlyProcessed);
        }
//        return ThreadLocalRandom.current().nextInt(0, IdentityPerformanceTestingService.MAX_PACKAGE_SIZE + 1);
        return IdentityPerformanceTestingService.MAX_PACKAGE_SIZE;
    }

    private static class TestRequestMapping {

        private static final String IDENTITY_METHOD = "identity";
        private static final String LONG_ID_METHOD = "long_id";
        private static final String ONE_TO_ONE_METHOD = "one_to_one";
        private static final String NO_ID_METHOD = "no_id";
    }

    private static class PerformanceTestMetrics {

        public static final String IDENTITY_STATISTICS_COUNT_METRIC = "identity_count";
        public static final String LONG_ID_STATISTICS_COUNT_METRIC = "long_id_count";
        public static final String ONE_TO_ONE_STATISTICS_COUNT_METRIC = "one_to_one_count";
        public static final String NO_ID_STATISTICS_COUNT_METRIC = "no_id_count";

        public static final String IDENTITY_STATISTICS_TIME_METRIC = "identity_time";
        public static final String LONG_ID_STATISTICS_TIME_METRIC = "long_id_time";
        public static final String ONE_TO_ONE_STATISTICS_TIME_METRIC = "one_to_one_time";
        public static final String NO_ID_STATISTICS_TIME_METRIC = "no_id_time";
    }
}
