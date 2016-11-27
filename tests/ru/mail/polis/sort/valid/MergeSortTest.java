package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.MergeSort;

import java.io.IOException;

@RunWith(value = Parameterized.class)
public class MergeSortTest  extends Tester{

    @Test
    public void test01_checkMergeSort() throws IOException {
        Assert.assertTrue(isSorted(MergeSort.sort(array)));
    }

}
