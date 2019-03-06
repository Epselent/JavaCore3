
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class test {
    @Parameterized.Parameters
    public static Collection<Object> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2}, new int[]{1, 2, 4 , 5, 4, 1, 2 }},
                {new int[]{1,2}, new int[]{1, 4, 3, 3, 4, 5}},
                {new int[]{5,6,3},new int[]{4, 5, 3, 4, 4, 5, 6, 3}},
                {new int[]{5, 6}, new int[]{5 , 3, 7, 4, 5, 6}},
        });
    }
    private int[] a;
    private int[] b;
    private Lesson6 t;

    public test(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }
    @Before
    public void unit(){
        t = new Lesson6();
    }
    @Test
    public void testTask(){
        Assert.assertEquals(a, t.arrayAfter4(b) );
    }
}
