

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	private Property p1,p2,p3,p4,p5,p6,p7,p8;
	private ManagementCompany m; 
	
	@Before
	public void setUp() throws Exception {
		p1 = new Property ("Echo Bazaar", "London", 7777.77, "A Group Of Bats");
		p2 = new Property ("Golden Empire", "El Dorado", 4844.00, "The Tarnished KIng",10,10,4,5);
		p3 = new Property ("Nowhere Brigade", "Temple Nil", 0.00, "Tail /w Snake Apendegaes",77,77,77,77);	
	
		ManagementCompany m= new ManagementCompany("Railey", "555555555",6);
		 
		assertEquals(m.addProperty(p1),0,0);
		assertEquals(m.addProperty(p2),1,0);
		assertEquals(m.addProperty(p3),-3,0);
	}

	@After
	public void tearDown() throws Exception {
		p1=p2=p3=p4=p5=p6=p7=p8=null;
		m=null;
	}
			
	@Test
	public void testGetMAX_PROPERTY() {
		assertEquals(m.getMAX_PROPERTY(),5);
	}
	
	@Test
	public void testAddPropertyDefaultPlot() throws CloneNotSupportedException{
		p4 = new Property ("Echo", "Uhhhh", 888.88, "idk",2,2,1,1);
		p5 = new Property ("filler", "text", 4844.00, "placeholder",4,10,1,2);
		p6 = new Property ("Nowhere Brigade", "Temple Nil", 0.00, "Tail /w Snake Apendegaes",2,2,2,1);
		p8 = new Property ("Nowhere Brigade", "Temple Nil", 0.00, "Tail /w Snake Apendegaes",1,1,1,1);
		p7 = new Property ("Nowhere Brigade", "Temple Nil", 0.00, "Tail /w Snake Apendegaes",3,3,1,1);	
		 

		assertEquals(m.addProperty(p4),2);
		
		assertEquals(m.addProperty(p5),3);
		
		assertEquals(m.addProperty(p6),-4);
		
		assertEquals(m.addProperty(p7),-2);
		
		assertEquals(m.addProperty(p8),4);
		
		assertEquals(m.addProperty(p7),-1);
	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(m.maxRentProp(),7777.77,0);
		//student should test if maxRentProp contains the maximum rent of properties
	}

	@Test
	public void testTotalRent() {
		assertEquals(m.totalRent(),77777.77+4844+888.88,0);
		//student should test if totalRent returns the total rent of properties
	}

 }
