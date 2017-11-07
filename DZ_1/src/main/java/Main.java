// @formatter:off

import java.util.*;

import com.google.common.collect.Lists;

public class Main
{
    private static final int MEASURE_COUNT = 1;

    public static void main(String... args)
    {
        final Collection<Integer> example = new ArrayList<>();
        int min = 1;
        int max = 999_999;

        for (int i = min; i < max + 1; i++)
        {
            example.add(i);
        }

        final List<Integer> result = new ArrayList<>();
        Collections.shuffle((List<Integer>) example);
        calcTime(() -> result.addAll(Lists.reverse((List<Integer>)example)));
    }

    private static void calcTime(Runnable runnable)
    {
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASURE_COUNT; i++)
            runnable.run();
        long finishTime = System.nanoTime();
        long timeNs = (finishTime - startTime) / MEASURE_COUNT;
        System.out.println("Time spent: " + timeNs + "ns (" + timeNs / 1_000_000 + "ms)");
    }
}

