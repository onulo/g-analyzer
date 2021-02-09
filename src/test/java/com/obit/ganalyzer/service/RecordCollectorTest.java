//package com.obit.ganalyzer.service;
//
//import java.util.List;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.test.util.ReflectionTestUtils;
//
//@ExtendWith({MockitoExtension.class})
//class RecordCollectorTest {
//
//    @Spy
////    private final RecordCollector recordCollector = new RecordCollector();
//
//    @Test
//    public void testCollectAndExit() {
//        ReflectionTestUtils.setField(recordCollector, "fileSize", 2);
//
//        boolean processed;
//
//        processed = recordCollector.process(getGForce());
//        Assertions.assertThat(processed).isFalse();
//
//        processed = recordCollector.process(getGForce());
//        Assertions.assertThat(processed).isFalse();
//
//        processed = recordCollector.process(getGForce());
//        Assertions.assertThat(processed).isTrue();
//    }
//
//    private List<String> getGForce() {
//        return List.of("dd", "dd", "rr");
//    }
//}