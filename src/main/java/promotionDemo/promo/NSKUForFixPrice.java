package promotionDemo.promo;

public class NSKUForFixPrice implements Promotion {

	private boolean isActive;
	private String desc;
	private String SKUId;
	private int quantity;
	private int price;

	public NSKUForFixPrice(boolean isActive, String sKUId, int quantity, int price) {
		super();
		this.isActive = isActive;
		SKUId = sKUId;
		this.quantity = quantity;
		this.price = price;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSKUId() {
		return SKUId;
	}

	public void setSKUId(String sKUId) {
		SKUId = sKUId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double applyPromtion(SKU sku, int skuQuantity) {

		int qnty = skuQuantity / this.quantity;
		int rem = skuQuantity % this.quantity;

		return qnty * this.price + rem * sku.getPrice();

	}

}
