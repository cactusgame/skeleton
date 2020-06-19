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
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ModTest {
    private final int divisor = 2048;
    private final int loop = 100000000;

    private int result = 0;

    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void testCommonMod() {

        this.result = 0;
        for (int i = 0; i < loop; i++) {
            int y = i % divisor;
            this.result += y;
        }
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void testTrickyMod() {
        this.result = 0;
        for (int i = 0; i < loop; i++) {
            int y = (divisor - 1) & i;
            this.result += y;
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ModTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
