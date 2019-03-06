import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class test2 {
    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {true, new int[]{1, 2, 4, 5, 4, 1, 2}},
                {true, new int[]{1, 3, 3, 5}},
                {false, new int[]{5, 3, 5, 6, 3}},
                {true, new int[]{5, 3, 7, 4, 5, 6}},
        });
    }
    private int[] b;
    private boolean a;
    private Lesson6 t;

    public test2(int[] b, boolean a) {
        this.b = b;
        this.a = a;
    }

    @Before
    public void unit(){
        t = new Lesson6();
    }
    @Test
    public void testTask(){
        Assert.assertEquals(a, t.inaArray1or4(b));
    }
}
