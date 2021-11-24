package promotionDemo.promo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
    	
       super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	List<Promotion> promotions = new ArrayList<>();
		promotions.add(new NSKUForFixPrice(true, "A", 3, 130));
		promotions.add(new NSKUForFixPrice(true, "B", 2, 45));
		promotions.add(new SKU1AndSKU2ForFixPrice(true, "C", "D", 1, 1, 30));

		List<SKU> skus = new ArrayList<>();
		skus.add(new SKU("A", 50));
		skus.add(new SKU("B", 30));
		skus.add(new SKU("C", 20));
		skus.add(new SKU("D", 15));

		Map<String, Integer> scenarios = new HashMap<>();
		scenarios.put("A", 1);
		scenarios.put("B", 1);
		scenarios.put("C", 1);
		double result = App.getTotal(promotions, scenarios, skus);
		assertEquals(100.0, result);
    }
    
    public void testCase2(){
    	List<Promotion> promotions = new ArrayList<>();
		promotions.add(new NSKUForFixPrice(true, "A", 3, 130));
		promotions.add(new NSKUForFixPrice(true, "B", 2, 45));
		promotions.add(new SKU1AndSKU2ForFixPrice(true, "C", "D", 1, 1, 30));

		List<SKU> skus = new ArrayList<>();
		skus.add(new SKU("A", 50));
		skus.add(new SKU("B", 30));
		skus.add(new SKU("C", 20));
		skus.add(new SKU("D", 15));

		Map<String, Integer> scenarios = new HashMap<>();
		scenarios.put("A", 5);
		scenarios.put("B", 5);
		scenarios.put("C", 1);
		double result = App.getTotal(promotions, scenarios, skus);
		assertEquals(370.0, result);
    }
    
    public void testCase3(){
    	List<Promotion> promotions = new ArrayList<>();
		promotions.add(new NSKUForFixPrice(true, "A", 3, 130));
		promotions.add(new NSKUForFixPrice(true, "B", 2, 45));
		promotions.add(new SKU1AndSKU2ForFixPrice(true, "C", "D", 1, 1, 30));

		List<SKU> skus = new ArrayList<>();
		skus.add(new SKU("A", 50));
		skus.add(new SKU("B", 30));
		skus.add(new SKU("C", 20));
		skus.add(new SKU("D", 15));

		Map<String, Integer> scenarios = new HashMap<>();
		scenarios.put("A", 3);
		scenarios.put("B", 5);
		scenarios.put("C", 1);
		scenarios.put("D", 1);
		double result = App.getTotal(promotions, scenarios, skus);
		assertEquals(280.0, result);
    }
}
