package promotionDemo.promo;

public class SKU1AndSKU2ForFixPrice implements Promotion {

	private boolean isActive;
	private String desc;
	private String SKU1Id;
	private String SKU2Id;
	private int sku1Quantity;
	private int sku2Quantity;
	private int price;

	public SKU1AndSKU2ForFixPrice(boolean isActive, String sKU1Id, String sKU2Id, int sku1Quantity, int sku2Quantity,
			int price) {
		super();
		this.isActive = isActive;
		SKU1Id = sKU1Id;
		SKU2Id = sKU2Id;
		this.sku1Quantity = sku1Quantity;
		this.sku2Quantity = sku2Quantity;
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

	public String getSKU1Id() {
		return SKU1Id;
	}

	public void setSKU1Id(String sKU1Id) {
		SKU1Id = sKU1Id;
	}

	public String getSKU2Id() {
		return SKU2Id;
	}

	public void setSKU2Id(String sKU2Id) {
		SKU2Id = sKU2Id;
	}

	public int getSku1Quantity() {
		return sku1Quantity;
	}

	public void setSku1Quantity(int sku1Quantity) {
		this.sku1Quantity = sku1Quantity;
	}

	public int getSku2Quantity() {
		return sku2Quantity;
	}

	public void setSku2Quantity(int sku2Quantity) {
		this.sku2Quantity = sku2Quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double applyPromtion(SKU sku1, int sku1Quantity, SKU sku2, int sku2Quantity) {

		
		int pair1 = sku1Quantity / this.sku1Quantity;
		int pair2 = sku2Quantity / this.sku2Quantity;

		int uniquePair = Math.max(pair1, pair2);

		return uniquePair * this.price + (sku1Quantity - uniquePair) * sku1.getPrice()
				+ (sku2Quantity - uniquePair) * sku2.getPrice();
	}

}
