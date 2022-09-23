package jdbc_maven;

public class Product {
	private int id;
	private String name;
	private double price;
	private String manufacture;
	private int discount;
	private int warranty;
	private String manu_date;
	private double gst;
	
	
	public Product(int id, String name, double price, String manufacture, int discount, int warranty, String manu_date,
			double gst) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufacture = manufacture;
		this.discount = discount;
		this.warranty = warranty;
		this.manu_date = manu_date;
		this.gst = gst;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getManufacture() {
		return manufacture;
	}


	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public int getWarranty() {
		return warranty;
	}


	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}


	public String getManu_date() {
		return manu_date;
	}


	public void setManu_date(String manu_date) {
		this.manu_date = manu_date;
	}


	public double getGst() {
		return gst;
	}


	public void setGst(double gst) {
		this.gst = gst;
	}
	
	Product()
	{
		
	}


	@Override
	public String toString() {
		return "\n Product [id=" + id + ", name=" + name + ", price=" + price + ", manufacture=" + manufacture
				+ ", discount=" + discount + ", warranty=" + warranty + ", manu_date=" + manu_date + ", gst=" + gst
				+ "]";
	}
	
	
}
