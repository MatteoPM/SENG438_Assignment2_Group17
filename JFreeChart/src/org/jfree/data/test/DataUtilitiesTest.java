package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class DataUtilitiesTest {
//    @BeforeClass 
//	  public static void setUpBeforeClass() throws Exception {}
//
//    @Before
//    public void setUp() throws Exception {}


    @Test
    public void testCalculateColumnTotal_EmptyTable() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(0));
            oneOf(values).getColumnCount();
            will(returnValue(0));
            oneOf(values).getValue(0, 0);
            will(returnValue(null));
            }});
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(0.0,result,.000000001d);
    }
    
    @Test
    public void testCalculateColumnTotal_oneRow() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {{
                oneOf(values).getRowCount();
                will(returnValue(1));
                oneOf(values).getColumnCount();
                will(returnValue(1));
                oneOf(values).getValue(0, 0);
                will(returnValue(7.5));
            }});
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(7.5,result,.000000001d);
    }
    
    @Test
    public void testCalculateColumnTotal_multipleRows() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {{
                oneOf(values).getRowCount();
                will(returnValue(2));
                oneOf(values).getColumnCount();
                will(returnValue(1));
                oneOf(values).getValue(0, 0);
                will(returnValue(7));
                oneOf(values).getValue(1, 0);
                will(returnValue(3));
            }});
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(10.0,result,.000000001d);
    }
    
    
    @Test
    public void testCalculateRowTotal_EmptyTable() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(0));
            oneOf(values).getColumnCount();
            will(returnValue(0));
            oneOf(values).getValue(0, 0);
            will(returnValue(null));
            }});
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(0.0,result,.000000001d);
    }
    
    @Test
    public void testCalculateRowTotal_oneRow() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {{
                oneOf(values).getRowCount();
                will(returnValue(1));
                oneOf(values).getColumnCount();
                will(returnValue(1));
                oneOf(values).getValue(0, 0);
                will(returnValue(7.5));
            }});
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(7.5,result,.000000001d);
    }
    
    @Test
    public void testCalculateRowTotal_multipleRows() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {{
                oneOf(values).getRowCount();
                will(returnValue(1));
                oneOf(values).getColumnCount();
                will(returnValue(2));
                oneOf(values).getValue(0, 0);
                will(returnValue(7));
                oneOf(values).getValue(0, 1);
                will(returnValue(3));
            }});
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(10.0,result,.000000001d);
    }   
    
    @Test
    public void testCreateNumberArray_oneElement() {
        // setup
    	double[] data = {0.4};
    	final Number[] values = DataUtilities.createNumberArray(data);
        assertEquals(0.4,values[0]);
    }
    
    @Test
    public void testCreateNumberArray_negativeElement() {
        // setup
    	double[] data = {-23.0};
    	final Number[] values = DataUtilities.createNumberArray(data);
        assertEquals(-23.0,values[0]);
    }
    
    @Test
    public void testCreateNumberArray_multipleElements() {
        // setup
    	double[] data = {0.0, -1.0, 2.2};
    	final Number[] values = DataUtilities.createNumberArray(data);
    	assertEquals(0.0, values[0]);
        assertEquals(-1.0, values[1]);
        assertEquals(2.2, values[2]);
    }
    
    @Test
    public void testCreateNumberArray2D_oneElement() {
        // setup
    	double[][] data = {{0.9}};
    	final Number[][] values = DataUtilities.createNumberArray2D(data);
        assertEquals(0.9,values[0][0]);
    }
    
    @Test
    public void testCreateNumberArray2D_negativeElements() {
        // setup
    	double[][] data = {{0.9},{-32.0}};
    	final Number[][] values = DataUtilities.createNumberArray2D(data);
        assertEquals(0.9,values[0][0]);
        assertEquals(-32.0,values[1][0]);
    }
    
    @Test
    public void testCreateNumberArray2D_multipleElements() {
        // setup
    	double[][] data = {{0.9, 0.0},{-32.0},{0.0, 1.0}};
    	final Number[][] values = DataUtilities.createNumberArray2D(data);
        assertEquals(0.9,values[0][0]);
        assertEquals(0.0,values[0][1]);
        assertEquals(-32.0,values[1][0]);
        assertEquals(0.0,values[2][0]);
        assertEquals(1.0,values[2][1]);
    }
    
    @Test
    public void testGetCumulativePercentages_oneElement() {
    	// setup
        Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);
        mockingContext.checking(new Expectations() {{
                allowing(values).getItemCount();
                will(returnValue(1));
                allowing(values).getValue(0);
                will(returnValue(12.0));
                allowing(values).getKey(0);
                will(returnValue(12.0));
            }});
        KeyedValues result = DataUtilities.getCumulativePercentages(values);
        assertEquals(1.0,result.getValue(0));
    }
    
    @Test
    public void testGetCumulativePercentages_multipleElements() {
    	// setup
        Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);
        mockingContext.checking(new Expectations() {{
                allowing(values).getItemCount();
                will(returnValue(3));
                allowing(values).getValue(0);
                will(returnValue(12.0));
                allowing(values).getKey(0);
                will(returnValue(12.0));
                allowing(values).getValue(1);
                will(returnValue(1.4));
                allowing(values).getKey(1);
                will(returnValue(1.4));
                allowing(values).getValue(2);
                will(returnValue(234.3));
                allowing(values).getKey(2);
                will(returnValue(234.3));
            }});
        KeyedValues result = DataUtilities.getCumulativePercentages(values);
        assertEquals(0.048446,result.getValue(0).doubleValue(),.000001d);
        assertEquals(0.054098,result.getValue(1).doubleValue(),.000001d);
        assertEquals(1.0,result.getValue(2).doubleValue(),.000001d);
    }
    

//    @After
//    public void tearDown() throws Exception {}
//
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//    }
    
    
}

