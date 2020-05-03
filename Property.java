import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Properties; 


public class Property {
	private String propertyName;
	private String city;
	private String owner;
	private double rentAmount;
	private Plot plot;
	private DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * Default constructor; entirely undefined.
	 */
	public Property() {
		propertyName="";
		city="";
		rentAmount=0;
		owner="";
		plot = new Plot();
	}
	
	/**
	 * A copier constructor. 
	 * Meant to copy the details of one property into another.
	 * 
	 * @param p = the property to be copied.
	 * @throws CloneNotSupportedException 
	 */
	public Property(Property p) throws CloneNotSupportedException {
		propertyName=p.getPropertyName();
		city=p.getCity();
		rentAmount=p.getRentAmount();
		owner=p.getOwner();
		
		//plot= new Plot(p.plot.getX(), p.plot.getY(), p.plot.getDepth(), p.plot.getWidth());
	
		plot=(Plot) p.plot.clone();
	}
	
	
	
	/**
	 * Parameterized constructor.
	 * All property varables are given and defined.
	 * Plot variables remain undefined
	 * 
	 * @param name = name of property
	 * @param city = name of city
	 * @param rent = cost of rent
	 * @param own = name of owner
	 */
	public Property(String name, String cit, double rent, String own) {
		propertyName= name;
		city= cit;
		rentAmount= rent;
		owner= own;
		plot = new Plot();
	}
	
	/**
	 * Parameterized constructor.
	 * All 8 varables are given and defined.
	 * 
	 * @param name = name of property
	 * @param city = name of city
	 * @param rent = cost of rent
	 * @param own = name of owner
	 * @param x = x value of upper-left corner of plot
	 * @param y = y value of upper-left corner of plot
	 * @param width = x value of lower-right corner of plot
	 * @param depth = y value of lower-right corner of plot
	 */
	public Property(String name, String cit, double rent, String own, int x, int y, int width, int depth) {
		propertyName= name;
		city= cit;
		rentAmount= rent;
		owner= own;
		plot = new Plot(x,y,width,depth);
	}
	
	@Override
	public Property clone() throws CloneNotSupportedException {
	    Property prop;
	    try {
	        prop = (Property) super.clone();
	        prop.plot = (Plot) this.plot.clone();
	    } catch (CloneNotSupportedException e) {
	        prop = new Property(
	          this.getPropertyName(), this.getCity(), this.getRentAmount(), this.getOwner(), 
	          this.plot.getX(), this.plot.getY(), this.plot.getWidth(), this.plot.getDepth());
	    }
	    
	    return prop;
	}
	
	/**
	 * Prints out the name, city, owner, and rent amount for a property
	 * 
	 * @return a string detailing the property name, the city its in, the name of the owner and the cost of rent, all in that order.
	 */
	public String toString() {
		return "\nProperty Name: \"" + propertyName 
				+ "\"\nCity Name: \"" + city 
				+ "\"\nOwner: \"" + owner 
				+ "\"\nRent Amount: $" + df.format(rentAmount)
				+ "\n"; 
	}

/**
 * Returns the private string for the city 
 * the property is located in.
 * 
 * @return city = the name of the city.
 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Changes the name of the city the property is
	 * located in.
	 * 
	 * @param the city's new name.
	 */
	public void setCity(String name) {
		city=name;
	}
	
	/**
	 * Returns the private string for the owner
	 * of the relevant property.
	 * 
	 * @return owner = the name of the owner.
	 */	
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Changes who the ownership of a property is
	 * addressed to. 
	 * 
	 * @param the name of the new owner
	 */
	public void setOwner(String name) {
		owner=name;
	}
	
	/**
	 * Returns the private string for what the 
	 * property in question is called.
	 * 
	 * @return name = the title of the property.
	 */
	public String getPropertyName() {
		 return propertyName;
	}
	
	/**
	 * Changes how the property is referred to.
	 * 
	 * @param the new title for the given property
	 */
	public void setPropertyName(String name) {
		propertyName=name;
	}
	
	/**
	 * Returns the private double for the rent 
	 * charged for the property. 
	 * 
	 * @return rentAmount = the cost of rent.
	 */
	public double getRentAmount() {
		 return rentAmount;
	}
	
	/**
	 * Changes the value of rent for the given property.
	 * 
	 * @return the new cost of rent.
	 */
	public void setRentAmount(double rent) {
		rentAmount=rent;
	}
	
	/**
	 * 
	 * @param x = the x-value of the upper-left point of the plot
	 * @param y = the y-value of the upper-left point of the plot
	 * @param width = the x-value of the lower-right point of the plot
	 * @param depth = the y-value of the lower-right point of the plot
	 * @return the Plot for the property
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
		
		return plot;
	}
	
	public Plot getPlot() {
	return plot;
	}
}
