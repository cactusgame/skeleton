package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class SwapTest {
    private final int loop = 100000000;
    private int result = 0;

    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void testCommonSwap() {
        this.result = 0;
        int a = 0;
        int b = 0;
        for (int i = 0 ;i < loop; i++){
            a = 12323432;
            b = 23440;

            int tmp = a;
            a = b;
            b = tmp;
            this.result += (a + b);

        }
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void testTrickySwap() {
        this.result = 0;
        int a = 0;
        int b = 0;
        for (int i = 0 ;i < loop; i++) {
            a = 12323432;
            b = 23440;

            b = a ^ b;
            a = a ^ b;
            b = a ^ b;
            this.result += (a + b);
        }
    }


    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(SwapTest.class.getSimpleName())
//                .forks(1)
//                .build();
//
//        new Runner(opt).run();

        System.out.println(2 >> 65);
    }
}