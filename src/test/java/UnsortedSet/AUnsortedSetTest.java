package UnsortedSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class AUnsortedSetTest {
    AUnsortedSet<Integer>set;
    AUnsortedSet<String>setString;

    @Before
    public void setUp() throws Exception {
        set = new AUnsortedSet<>();
        setString = new AUnsortedSet<>();
    }

    @Test
    public void add() {
        set.add(5);
        set.add(10);
        System.out.println(Arrays.toString(set.getBackingArray()));
        Integer actual = set.size();
        Integer expected = 2;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addFail() {
        set.add(5);
        set.add(5);
        System.out.println(Arrays.toString(set.getBackingArray()));
        Integer actual = set.size();
        Integer expected = 1;
        Assert.assertEquals(expected,actual);
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
}