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

        @Test
        public void camelCase_takes_a_meaning_and_converts_it_to_camel_case(){
            String camelCase = stUtility.camelCase("Hello my name is Johan");
            Assert.assertEquals(camelCase.toLowerCase(), ("hellomynameisjohan"));
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
