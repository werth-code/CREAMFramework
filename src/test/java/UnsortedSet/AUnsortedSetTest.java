package UnsortedSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AUnsortedSetTest {
    AUnsortedSet<Integer>set;

    @Before
    public void setUp() throws Exception {
        set = new AUnsortedSet<>();
    }

    @Test
    public void add() {
        set.add(5);
        set.add(10);
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