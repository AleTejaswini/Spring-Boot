package ConstructorInjection;

public class Orders {
	private int orderid;
	private String ordername;
	private Customers customers;
	public Orders(int orderid, String ordername, Customers customers) {
		super();
		this.orderid = orderid;
		this.ordername = ordername;
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", ordername=" + ordername + ", customers=" + customers + "]";
	}
}
