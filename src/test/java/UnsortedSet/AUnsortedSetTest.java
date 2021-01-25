package UnsortedSet;

import com.codedifferently.collections.unsortedset.AUnsortedSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class AUnsortedSetTest {
    AUnsortedSet<Integer> set;

    @Before
    public void setUp() throws Exception {
        set = new AUnsortedSet<>();
    }

    @Test
    public void add() {
        set.add(1);
        set.add(2);
        System.out.println(Arrays.toString(set.getBackingArray()));
        Integer actual = set.size();
        Integer expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addOverflowTest() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        set.add(11);
        set.add(12);
        System.out.println(Arrays.toString(set.getBackingArray()));
        Integer actual = set.size();
        Integer expected = 12;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void contains() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void size() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void getBackingArray() {
    }
}