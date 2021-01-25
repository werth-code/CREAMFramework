package UnsortedSet;

import com.codedifferently.collections.unsortedset.UnsortedSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class AUnsortedSetTest {
    UnsortedSet<Integer> set;

    @Before
    public void setUp() {
        set = new UnsortedSet<>();
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
        set.add(1);
        set.add(2);
        System.out.println(Arrays.toString(set.getBackingArray()));
        Boolean actual = set.contains(2);
        Boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        set.add(1);
        set.add(2);
        set.add(3);

        Boolean actual = set.remove(2);
        Boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        Integer actual = set.size();
        Integer expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toArray() {
        set.add(100);
        set.add(200);
        String actual = Arrays.toString(set.toArray());
        String expected = "[100, 200, null, null, null, null, null, null, null, null]";

        Assert.assertEquals(expected, actual);
    }
}