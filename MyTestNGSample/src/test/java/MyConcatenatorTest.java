import org.testng.Assert;
import org.testng.annotations.Test;
import com.sicnarf.MyConcatenator;

public class MyConcatenatorTest {

    @Test
    public void testConcatanate() throws Exception {
        String concatenated = MyConcatenator.concatanate("one", "two", "three", "four");

        Assert.assertEquals("one,two,three,four", concatenated);
    }


}