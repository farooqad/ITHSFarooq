package se.iths.junitlab;

import junit.lab.PrimeNumberLab;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static se.iths.junitlab.StringBeginsWithLowerCaseMatcher.beginsWithLowerCase;

public class PrimeNumberTest {

    @Test
    public void simplePrimeTest(){

        List<Integer> primes = new PrimeNumberLab().getPrimeNumbersBetween(10, 12);

        assertThat(primes.get(0), is(11));
    }
    @Test
    public void PrimeTest1(){

        List<Integer> primes = new PrimeNumberLab().getPrimeNumbersBetween(2, 20);

        assertThat(primes.get(0), is(2));
    }

    public static class HamcrestExampleTest {

        @Test
        public void myFirstHamcrestTest(){
            String myMessage = "Apa!";

            assertThat(myMessage, is(equalTo("Apa!")));
        }

        @Test
        public void myHamcrestListTest(){

            List<String> myAnimalList = Collections.singletonList("Apa");

            assertThat(myAnimalList, hasItem("Apa"));
        }

        String myString = "bohan";

        @Test
        public void validateFirstLetterIsLowerCarse(){

            assertThat(myString, beginsWithLowerCase("b"));

        }
    }
}
