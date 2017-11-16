package ivan;

import java.lang.management.ManagementFactory;
        import java.lang.reflect.Type;
        import java.util.function.Supplier;

@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Main
{
    public static void main(String... args) throws InterruptedException
    {
        {
            System.gc();
            getObjectSize(Object::new);
            System.gc();
            getObjectSize(String::new);
            System.gc();
            getObjectSize(() -> new String(new char[0]));
            System.gc();
            getObjectSize(MyClass::new);
        }
    }

    private static void getObjectSize(Supplier<Object> supplier)throws InterruptedException
    {
        int size = 8000000;


        Runtime runtime = Runtime.getRuntime();
        System.gc();
        long mem, temp = runtime.totalMemory() - runtime.freeMemory();

        Object[] array = new Object[size];

        for (int i = 0; i < size; i++)
        {
            array[i] = supplier.get();
        }
        System.gc();
        mem = runtime.totalMemory() - runtime.freeMemory();

        System.out.println(mem - temp);
        System.out.println(temp);

        System.out.println("Size of " + array[0].getClass().getName() + " = " + ((mem - temp) / size));
        Thread.sleep(1000);
    }

    private static class MyClass
    {
        private int i = 0;
        private long l = 1;
    }
}

