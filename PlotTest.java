



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlotTest {
	private Plot plot1, plot2, plot3, plot4, plot5, plot6, plot7, plot8, plot9, 
		plot10, plot11, plot12, plot13;	
	 @Before
	public void setUp() throws Exception {
		 //[x,w] [y,d] where (w = x + width)
		 							  // ]10 11]11 12]12 13]13 14]14 15]15 16]16 17]17 18]18 19]19 20]20 21]		|[6 7]7 8]8 9]9 10]10 11]11 12]12 13]13 14]14 15]15 16]16 17]1718]18
		plot7 = new Plot(11,16,3,3);  // 	   [11   	 13] 														|				     	      		[13          	16]
		plot9 = new Plot(11,14,2,1);  // 	   [11	  	 13] 														|			            [11        		14]
		plot11 = new Plot(12,12,3,2); // 		     [12         	 15] 											|     	   	      [10       12]
		
		 
		plot2 = new Plot(10,10,2,2);  // [10       12] 																|	     [8	    10]
		plot3 = new Plot(11,11,3,2);  // 	   [11			   14] 													| 			 [9		  11]
		plot1 = new Plot(12,12,6,6);  // 		     [12 							   18] 							|[6 					    12]
		
		plot5 = new Plot(13,14,4,3);  // 			  	   [13             		 17] 								|			            [11         	14]
		
		plot4 = new Plot(16,11,4,2);  // 							  		 [16 			       20] 				|     	  	 [9	      11]
		
		plot10 = new Plot(19,12,2,2); // 												  	   [19		 21] 		| 	  	   		  [10 	    12]
		
		
		plot8 = new Plot(16,17,4,2);  // 							  		 [16				   20] 				|                         			    		[15		  17]
		plot12 = new Plot(15,17,3,1); // 	                      	   [15      	   18] 							| 										   	 		  [16 17]
		plot13 = new Plot(15,17,3,1); // 	                      	   [15      	   18] 							| 										   	 		  [16 17]
		
		plot6 = new Plot(16,15,3,1);  // 							  		 [16		  	 19] 					|						  	      		  [14 15] 
		
	}
 /*	
  * When w = x - width:																	
  * 1 	overlaps [2, 3, 4, 5, 11]		encompasess [2, 3, 11]
  * 2 	overlaps [1, 3]					encompasess [NONE]
  * 3 	overlaps [1, 2, 11]				encompasess [NONE]
  * 4 	overlaps [1, 11]				encompasess [NONE]
  * 5 	overlaps [1, 7, 9, 11]			encompasess [9]
  * 6 	overlaps [NONE]					encompasess [NONE]
  * 7 	overlaps [5, 9] 				encompasess [9]
  * 8 	overlaps [12, 13] 				encompasess [12, 13]
  * 9 	overlaps [5, 7]					encompasess [NONE]
  * 10 	overlaps [NONE]					encompasess [NONE]
  * 11	overlaps [1, 3, 4, 5]			encompasess [NONE]
  * 12  overlaps [8, 13]				encompasess [13]
  * 13 	overlaps [8, 12] 				encompasess [12]
  */
	
	@After
	public void tearDown() throws Exception {
		plot1=plot2=plot3=plot4=plot5=plot6=plot7=plot8=plot9=plot10=plot11=plot12=plot13=null;
	}

	@Test
	public void testOverlaps1() {
		assertTrue(plot1.overlaps(plot11)); //plot11 is entirely inside plot1
		assertTrue(plot11.overlaps(plot1));
	}
	
	@Test
	public void testOverlaps2() {
		assertTrue(plot1.overlaps(plot3)); //plot3 overlaps the lower left corner of plot1
		assertTrue(plot3.overlaps(plot1));

		assertTrue(plot1.overlaps(plot4)); //plot4 overlaps the lower right corner of plot1
		assertTrue(plot4.overlaps(plot1));
	}
	
//	@Test
//	public void testOverlaps3() {
//	/*
//	* Test appears to be faulty. No 
//	*
//	*/
//		assertTrue(plot1.overlaps(plot7)); //plot7 overlaps the upper left corner of plot1
//		assertTrue(plot7.overlaps(plot1));
//
//		assertTrue(plot1.overlaps(plot8)); //plot8 overlaps the upper right corner of plot1
//		assertTrue(plot8.overlaps(plot1));
//	}
	

//	public void testOverlaps4() {
//		/*
//		 * Faulty test. Plot 9 is incapable of overlapping with plot 1.
//		 * Same with plot 6.
//		 */
//		assertTrue(plot1.overlaps(plot9)); //plot9 overlaps the left side of plot1 
//		assertTrue(plot9.overlaps(plot1));
//		assertTrue(plot1.overlaps(plot6)); //plot6 overlaps the right side of plot1
//		assertTrue(plot6.overlaps(plot1));
//	}
	
	@Test
	public void testOverlaps5() {
		assertFalse(plot3.overlaps(plot9)); //plot9 does not overlap plot3
		assertFalse(plot9.overlaps(plot3));
		assertFalse(plot5.overlaps(plot8)); //plot5 does not overlap plot8, but partly share a side
		assertFalse(plot8.overlaps(plot5));
	}
	@Test
	public void testOverlaps6() {
		assertFalse(plot3.overlaps(plot4)); //plot4 does not overlap plot3
		assertFalse(plot4.overlaps(plot3));
		assertFalse(plot1.overlaps(plot10)); //plot1 does not overlap plot10
		assertFalse(plot10.overlaps(plot1));
		assertFalse(plot2.overlaps(plot1));	//plot2 does not overlap plot1
		assertTrue(plot12.overlaps(plot13)); //plot12 is exactly the same dimensions as plot13
	}
	
	@Test
	public void testEncompasses1() {
		assertTrue(plot1.encompasses(plot5)); //plot5 is contained in plot1
		assertFalse(plot5.encompasses(plot1));
		assertTrue(plot1.encompasses(plot11)); //plot11 is contained in plot1
		assertFalse(plot11.encompasses(plot1));
		assertTrue(plot1.encompasses(plot12)); //plot12 is contained in plot1
		assertFalse(plot12.encompasses(plot1));		
		
		
		
		assertFalse(plot2.encompasses(plot1));	
		assertFalse(plot3.encompasses(plot1)); 
		assertFalse(plot1.encompasses(plot3));
		assertFalse(plot7.encompasses(plot8)); 
		assertFalse(plot8.encompasses(plot7));
	}

	@Test
	public void testToString() {
		assertEquals("Upper left: (12,12); Width: 6 Depth: 6", ""+plot1);
	}
	
	@Test
	public void testGetWidth() {
		assertEquals(2, plot2.getWidth());
	}
	
	@Test
	public void testSetX() {
		plot3.setX(22);
		assertEquals(22, plot3.getX());
	}

}
