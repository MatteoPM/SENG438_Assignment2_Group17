package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range;
import org.jmock.Mockery;
import org.junit.*;

public class RangeTest {
    static private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception { 
        exampleRange = new Range(-5, 5);
    }


//    @Before
//    public void setUp() throws Exception {}


    @Test
    public void testContains_lowerBound() {
        assertEquals("The lowerBound of -5 and 5 is -5 and contains(-5) should return true",
        true, exampleRange.contains(-5));
    }
    
    @Test
    public void testContains_upperBound() {
        assertEquals("The upperBound of -5 and 5 is 5 and contains(5) should return true",
        true, exampleRange.contains(5));
    }
    
    @Test
    public void testContains_inBetween() {
        assertEquals("In the Range of -5 and 5 is contains(2) should return true",
        true, exampleRange.contains(2));
    }
    
    @Test
    public void testContains_belowLowerBound() {
        assertEquals("In the Range of -5 and 5 is contains(-7) should return false",
        false, exampleRange.contains(-7));
    }
        
    @Test
    public void testContains_belowUpperBound() {
        assertEquals("In the Range of -5 and 5 is contains(7) should return false",
        false, exampleRange.contains(7));
    }
   
    
    @Test
    public void testGetLowerBound_lowerbound() {
        Range instance = new Range(4,10);
        assertEquals("The lowerBound of 4 and 10 is 4 and getLowerBound() should return 4",
                4, instance.getLowerBound(), .000000001d);
    }
   
    
    @Test
    public void testGetLowerBound_lowerboundNeg() {
        Range instance = new Range(-4,-2);
        assertEquals("The lowerBound of -4 and -2 is -4 and getLowerBound() should return -4",
                -4, instance.getLowerBound(), .000000001d);
    }
   
    
    @Test
    public void testGetUpperBound_upperbound() {
        Range instance = new Range(4,10);
        assertEquals("The lowerBound of 4 and 10 is 10 and getUpperBound() should return 10",
                10, instance.getUpperBound(), .000000001d);
    }
   
    
    @Test
    public void testGetUpperBound_upperboundNeg() {
        Range instance = new Range(-4,-2);
        assertEquals("The lowerBound of -4 and -2 is -2 and getUpperBound() should return -2",
                -2, instance.getUpperBound(), .000000001d);
    }
   
    
    @Test
    public void testGetLength_SameUpperLower() {
        Range instance = new Range(5,5);
        assertEquals("The Length should be 0",
                0, instance.getLength(), .000000001d);
    }
       
    

//    @After
//    public void tearDown() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        exampleRange = null;
    }
}