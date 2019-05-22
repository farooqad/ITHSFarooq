package se.iths.Mimic.Sprint1;

import org.junit.Assert;
import org.junit.Test;

public class requestResponseTests {

    Store st = new Store();

    @Test
    public void saveResponse(){
        st.learnResponse("hi", "sweden");
        Assert.assertEquals("sweden", st.getResponse("hi"));
    }
    @Test
    public void multipleResponses()
    {
        st.learnResponse("hi", "pakistan");
        Assert.assertEquals("pakistan", st.getResponse("hi"));

        st.learnResponse("hi", "sweden");
        Assert.assertEquals("sweden", st.getResponse("hi"));

        Assert.assertNotEquals("hi", st.getResponse("bye"));

    }
    @Test
    public void unlearn(){
        st.learnResponse("hi", "pakistan");
        Assert.assertEquals("pakistan", st.getResponse("hi"));
        st.learnResponse("hi", "sweden");
        Assert.assertEquals("sweden", st.getResponse("hi"));

        Assert.assertNotNull(st.getResponse("hi"));

        st.unlearnAll();

        Assert.assertNotEquals("sweden", "hi");
        Assert.assertNotEquals("pakistan", st.getResponse("hi"));

        Assert.assertNull(st.getResponse("pakistan"));
        Assert.assertNull(st.getResponse("sweden"));
    }

}
