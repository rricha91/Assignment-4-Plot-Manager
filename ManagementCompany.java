
public class ManagementCompany {

	private String name;
	private String taxID;
	
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private double mgmFEEPer;
	
	private Property[] properties;
	private Plot plot;
	
	public ManagementCompany() {
		name="";
		taxID="";
		plot= new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String n, String iD, double mgmFee) {
		name=n;
		taxID=iD;
		mgmFEEPer=mgmFee;
		plot= new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String n, String iD, double mgmFee, int x, int y, int width, int depth) {
		name=n;
		taxID=iD;
		mgmFEEPer=mgmFee;
		plot= new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) throws CloneNotSupportedException {
		name=otherCompany.name;
		taxID=otherCompany.taxID;
		mgmFEEPer=otherCompany.mgmFEEPer;
		
		plot=(Plot) otherCompany.getPlot().clone();
		
		properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < MAX_PROPERTY; i++) {
		    Property p = otherCompany.properties[i];
		    if (p != null) properties[i] = (Property) p.clone();
		    else break;
		}
	}
	
	public int addProperty(Property pro) throws CloneNotSupportedException {
		
		int n = 0;
		
		if (pro==null) return -2;
		if (!plot.encompasses(pro.getPlot())) return -3;
			
			for (; n < MAX_PROPERTY; n++) {
				if (properties[n]==null) {
					properties[n]= new Property(pro);
					return n;
				}
				
				else {
					if (properties[n].getPlot().overlaps(pro.getPlot())) return -4;
				}
			}
			
			return n==MAX_PROPERTY? -1 : -5;
	}
	
public int addProperty(String propertyName, String city, double rent, String owner) {
		
		if (propertyName==null||city==null||owner==null) return -2;
		
		Plot p = new Plot();
		if (!plot.encompasses(p)) return -3;
		
		int n = 0;
			for (; n < MAX_PROPERTY; n++) {
				if (properties[n]==null) {
					properties[n]= new Property(propertyName, city, rent, owner);
					return n;
				}
				else {
					if (properties[n].getPlot().overlaps(p)) return -4;
				}
			}
			return -1;
	}

public int addProperty(String propertyName, String city, double rent, String owner, int x, int y, int width, int depth) {
	
	if (propertyName==null||city==null||owner==null) return -2;
	
	Plot p = new Plot(x,y,width,depth);
	if (!plot.encompasses(p)) return -3;
	
	int n = 0;
		for (; n < MAX_PROPERTY; n++) {
			if (properties[n]==null) {
				properties[n]= new Property(propertyName, city, rent, owner,x,y,width,depth);
				return n;
			}
			else {
				if (properties[n].getPlot().overlaps(p)) return -4;
			}
		}
		return -1;
}

public int getMAX_PROPERTY() {
	return MAX_PROPERTY;
}

public String displayPropertyAtIndex(int i) {
	return i>0 && i<MAX_PROPERTY ? properties[i].toString() : "ERROR: GIVEN INDEX IS OUT OF BOUNDS";
}

public String toString() {
	String ret = "";

	for (int i=0;i<MAX_PROPERTY;i++) ret+=properties[i].toString();

	return ret;
}

public double maxRentProp() {
	double max = 0;
	double rent;
	for (int n=0; n<MAX_PROPERTY && properties[n]!=null; n++) {
		rent = properties[n].getRentAmount();
		if (rent>max) max=rent;
	}
	return max;
}

public int maxRentPropertyIndex() {
	int n=0;
	int m=0;
	for (double max=0, rent; n<MAX_PROPERTY && properties[n]!=null; n++) {
		rent = properties[n].getRentAmount();
		if (rent>max) { 
			max=rent;
			m=n;
		}
	}
	return m;
}

public double totalRent() {
	double total=0;

	for (int i=0;i<MAX_PROPERTY;i++) total+=properties[i].getRentAmount();

	return total;
}

public Plot getPlot() {
	return plot;
}

}
