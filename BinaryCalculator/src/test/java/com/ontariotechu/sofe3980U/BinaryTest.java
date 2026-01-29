
package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor()
    {
		Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
		Binary binary=new Binary("1001001211");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
		Binary binary=new Binary("1001001A");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
		Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * T	est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
		Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
		Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
	/**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
		Binary binary1=new Binary("1000");
		Binary binary2=new Binary("1111");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
	/**
     * Test The add functions with two zeros
     */
    @Test
    public void add5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }

 // ---------------- NEW TESTS BELOW ----------------

    // OR tests (3)
    @Test
    public void orSameLength()
    {
        Binary a = new Binary("1010");
        Binary b = new Binary("1100");
        Binary r = Binary.OR(a, b);
        assertTrue(r.getValue().equals("1110"));
    }

    @Test
    public void orDifferentLengths()
    {
        Binary a = new Binary("101");
        Binary b = new Binary("11"); // treated as 011
        Binary r = Binary.OR(a, b);  // 101 OR 011 = 111
        assertTrue(r.getValue().equals("111"));
    }

    @Test
    public void orWithZero()
    {
        Binary a = new Binary("0");
        Binary b = new Binary("1011");
        Binary r = Binary.OR(a, b);
        assertTrue(r.getValue().equals("1011"));
    }

    // AND tests (3)
    @Test
    public void andSameLength()
    {
        Binary a = new Binary("1010");
        Binary b = new Binary("1100");
        Binary r = Binary.AND(a, b);
        assertTrue(r.getValue().equals("1000"));
    }

    @Test
    public void andDifferentLengths()
    {
        Binary a = new Binary("101");
        Binary b = new Binary("11"); // treated as 011
        Binary r = Binary.AND(a, b); // 101 AND 011 = 001 -> normalized to "1"
        assertTrue(r.getValue().equals("1"));
    }

    @Test
    public void andWithZero()
    {
        Binary a = new Binary("0");
        Binary b = new Binary("1011");
        Binary r = Binary.AND(a, b);
        assertTrue(r.getValue().equals("0"));
    }

    // multiply tests (3)
    @Test
    public void multiplyBasic()
    {
        Binary a = new Binary("101"); // 5
        Binary b = new Binary("11");  // 3
        Binary r = Binary.multiply(a, b); // 15
        assertTrue(r.getValue().equals("1111"));
    }

    @Test
    public void multiplyByZero()
    {
        Binary a = new Binary("0");
        Binary b = new Binary("1011");
        Binary r = Binary.multiply(a, b);
        assertTrue(r.getValue().equals("0"));
    }

    @Test
    public void multiplyByOne()
    {
        Binary a = new Binary("1");
        Binary b = new Binary("10010");
        Binary r = Binary.multiply(a, b);
        assertTrue(r.getValue().equals("10010"));
    }
}
