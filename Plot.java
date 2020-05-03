

public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	
	public Plot() {
		x=0;
		y=0;
		depth=1;
		width=1;
	}
	
	public Plot(Plot p) {
		x=p.getX();
		y=p.getY();
		depth=p.getDepth();
		width=p.getWidth();
	}
	

	public Plot(int length,int height,int z, int w) {
		x=length;
		y=height;
		depth=z;
		width=w;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
	    try {
	        return (Plot) super.clone();
	    } catch (CloneNotSupportedException e) {
	        return new Plot(this.getX(), this.getY(), this.getDepth(),this.getWidth());
	    }
	}
	
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
	
	/**
	 * Returns the instance value x
	 * @return the x value for the upper-left corner of the plot
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the value of x equal to the given parameter 
	 * @param the desired x value for the upper-left point of the plot
	 */
	public void setX(int length) {
		x=length;
	}
	
	/**
	 * Returns the instance value y
	 * @return the y value of the upper-left corner of the plot
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the value of y equal to the given parameter 
	 * @param the desired y value for the upper-left point of the plot
	 */
	public void setY(int height) {
		y=height;
	}
	
	/**
	 * Returns the instance value width
	 *  @return the value added to x to get the upper domain of the plot
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets the value for width equal to the given parameter 
	 * @param the value added to x to get the upper domain of the plot.
	 */
	public void setWidth(int w) {
		width=w;
	}
	
	/**
	 * Returns the instance value depth
	 * @return the value subtracted from y to get the lower range of the plot.
	 */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * Sets the value of depth equal to the given parameter 
	 * @param the desired y value for the bottom-right point of the plot
	 */
	public void setDepth(int d) {
		depth=d;
	}
	
	/**
	 * Checks if the parameter's given plot overlaps the current plot.
	 * @param the plot we're checking the current plot against
	 * @return A true or false value on whether the two plots overlap 
	 */
	public boolean overlaps(Plot p) {
		int xP=p.getX();
		int yP=p.getY();
		int wP=xP+p.getWidth();
		int dP=yP-p.getDepth();
		
		int x=this.getX();
		int y=this.getY();
		int w=x+this.getWidth();
		int d=y-this.getDepth();
		
		boolean OvXaxiL = (xP>=x && xP<w) || (x>=xP && x<wP);
		boolean OvXaxiR = (wP>x && wP<=w) || (w>xP && w<=wP);
		boolean OvYaxiU = (yP<=y && yP>d) || (y<=yP && y>dP);
		boolean OvYaxiD = (dP<y && dP>=d) || (d<yP && d>=dP);
		
		boolean OvXaxi  = (OvXaxiL||OvXaxiR);
		boolean OvYaxi  = (OvYaxiU||OvYaxiD);
		
//		boolean OvXaxiP  = (xP>=x && xP<w)||(wP>x && wP<=w);
//		boolean OvXaxiT  = (x>=xP && x<wP)||(w>xP && w<=wP);
//		
//		boolean OvYaxiP  = (yP<=y && yP>d)||(dP<y && dP>=d);
//		boolean OvYaxiT  = (y<=yP && y>dP)||(d<yP && d>=dP);
//		
//		boolean OvXaxi = OvXaxiP||OvXaxiT;
//		boolean OvYaxi = OvYaxiP||OvYaxiT;
		
		return (OvXaxi&&OvYaxi);
	}

	
	/**
	 * checks if this plot encompasses the parameter
	 * 
	 * @param the plot that should be encompassed
	 * @return a true false statement on if this plot does, in fact, encompass the parameter
	 */
	public boolean encompasses(Plot p) {
		int xP=p.getX();
		int yP=p.getY();

		int dP=yP-p.getDepth();
		
		int x=this.getX();
		int y=this.getY();

		int d=y-this.getDepth();
		
		//		int wP=xP+p.getWidth();
		//		int w=x+this.getWidth();
//		boolean OvXaxiL = (x>=xP && x<=wP) || (xP>=x && xP<=w);
//		boolean OvXaxiR = (w>=xP && w<=wP) || (wP>=x && wP<=w);
		
				int wP=xP-p.getWidth();
				int w=x-this.getWidth();
		boolean OvXaxiL = (x<=xP && x>=wP) || (xP<=x && xP>=w);
		boolean OvXaxiR = (w<=xP && w>=wP) || (wP<=x && wP>=w);
		
		boolean OvYaxiU = (y<=yP && y>=dP) || (yP<=y && yP>=d);
		boolean OvYaxiD = (d<=yP && d>=dP) || (dP<=y && dP>=d);
		
		boolean OvXaxi  = (OvXaxiL&&OvXaxiR);
		boolean OvYaxi  = (OvYaxiU&&OvYaxiD);
		return (OvXaxi&&OvYaxi);
	}
	

}
	
