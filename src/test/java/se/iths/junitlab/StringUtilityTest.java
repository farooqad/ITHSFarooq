package se.iths.junitlab;

import junit.homwork.StringUtility;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilityTest {

    StringUtility stUtility = new StringUtility();

        @Test
        public void reverse_weather_on_a_word(){
            String reverse = stUtility.reverse("Johan");
            Assert.assertNotEquals(reverse, "nahoJ");
        }

        /*@Test
        public void camelCase_takes_a_meaning_and_converts_it_to_lower_case(){
            String st = stUtility.camelCase("Hello my name is Johan");
            Assert.assertEquals(st.toLowerCase(), ("hellomynameisjohan"));
            Assert.assertEquals(st.toUpperCase(), ("HELLOMYNAMEISJOHAN"));
            Assert.assertEquals(st, ("HelloMyNameIsJohan"));
        }*/

        @Test
        public void camelCase_takes_a_meaning_and_converts_it_to_camel_case1(){
            StringUtility myStringUtility = new StringUtility();
            String camelCase = myStringUtility.camelCase("Hello my name is Johan");
            Assert.assertEquals(camelCase, ("HelloMyNameIsJohan"));
        }

        @Test
        public void isValidEmailAddress_validates_an_email_address(){
            String address = "farooq@gmail.com";
            boolean expectedResult = true;
            boolean actualResult = stUtility.isValidEmailAddress(address);
            Assert.assertTrue( "\ntestYo, EXPECTED: " + expectedResult + ", GOT: " + actualResult, (expectedResult==actualResult) );
            Assert.assertTrue(String.valueOf(expectedResult), actualResult);
        }
}
