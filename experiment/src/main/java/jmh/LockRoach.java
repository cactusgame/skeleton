package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1, jvmArgsPrepend = {"-XX:-UseBiasedLocking","-XX:LoopUnrollLimit=50"})
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LockRoach {

    int x;

    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void test() {
        for (int c = 0; c < 1000; c++) {
            synchronized (this) {
                x += 0x42;
            }
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LockRoach.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

// LoopUnrollLimit=1
//Benchmark           Mode  Samples      Score  Score error  Units
//        j.LockRoach.test    avgt        5  17497.692      299.517  ns/op

// LoopUnrollLimit=4
//Benchmark           Mode  Samples      Score  Score error  Units
//        j.LockRoach.test    avgt        5  17124.308      154.444  ns/op

// LoopUnrollLimit=8
//Benchmark           Mode  Samples      Score  Score error  Units
//        j.LockRoach.test    avgt        5  17139.375      118.764  ns/op


// LoopUnrollLimit=1000
//    Benchmark           Mode  Samples     Score  Score error  Units
//        j.LockRoach.test    avgt        5  1219.304       23.065  ns/op


    // LoopUnrollLimit=100
//    Benchmark           Mode  Samples     Score  Score error  Units
//        j.LockRoach.test    avgt        5  2294.098       13.714  ns/op


// without LoopUnrollLimit
//    Benchmark           Mode  Samples     Score  Score error  Units
//        j.LockRoach.test    avgt        5  4377.591       19.569  ns/op