package se.iths.junitlab;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;



public class HamcrestTest {

    @Test
    public void myFirstHamcrestTest(){
        String myMessage = "Farooq!";

        assertThat(myMessage, is(equalTo("Farooq!")));
    }

    @Test
    public void myHamcrestListTest(){

        List<String> myAnimalList = Collections.singletonList("Apa");

        assertThat(myAnimalList, hasItem("Apa"));
    }

    String myString = "bohan";

    @Test
    public void stringOnlyHasLowerCarse(){

        List<String> myAnimalList = Collections.singletonList("farooq");

        assertThat(myAnimalList, hasItem("farooq"));
    }
}
