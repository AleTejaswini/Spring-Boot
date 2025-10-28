package ServiceAnnotation;

public class ServiceAnnotationProduct {
	private int productid;
	private String productname;
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public ServiceAnnotationProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiceAnnotationProduct(int productid, String productname) {
		super();
		this.productid = productid;
		this.productname = productname;
	}
	
}
