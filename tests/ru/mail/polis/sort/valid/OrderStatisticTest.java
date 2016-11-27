package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.OrderStatistic;
import ru.mail.polis.sort.QuickSort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(Parameterized.class)
public class OrderStatisticTest {

    private static final Random r = ThreadLocalRandom.current();

/*    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };
*/
    public static int[] gen(int n) {
        int[] a = new int[n];
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    @Parameterized.Parameters(name = "{index}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {gen(1),0},
                {gen(10),1},
                {gen(100),10},
                {gen(1000),100},
                {gen(10000),1000}
        });
    }

    public int[] array;
    public int k;

    public OrderStatisticTest(int[] array, int k){
        this.array = array;
        this.k=k;
    }




  /*  @Parameterized.Parameters(name = "{index}")
    public static List<Integer> statistic() {
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(0);
        a.add(1);
        a.add(10);
        a.add(100);
        a.add(1000);
        return a;
    }
*/
    public boolean isOrederStatistic(int a) {
        int[] b= QuickSort.sort(array,0,array.length-1);
        if(b[k]==a)
            return true;
        else
            return false;
    }

    @Test
    public void test01_checkOrderStatistic() throws IOException {
        Assert.assertTrue(isOrederStatistic(OrderStatistic.findOrderStatistic(array,k)));
    }

}