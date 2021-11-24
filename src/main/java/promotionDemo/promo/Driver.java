/*package promotionDemo.promo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Driver {

	public static void main(String[] args) {

		List<Promotion> promotions = new ArrayList<>();
		promotions.add(new NSKUForFixPrice(true, "A", 3, 130));
		promotions.add(new NSKUForFixPrice(true, "B", 2, 45));
		promotions.add(new SKU1AndSKU2ForFixPrice(true, "C", "D", 1, 1, 30));

		List<SKU> skus = new ArrayList<>();
		skus.add(new SKU("A", 50));
		skus.add(new SKU("B", 30));
		skus.add(new SKU("C", 20));
		skus.add(new SKU("D", 15));a

		Map<String, Integer> scenarios = new HashMap<>();
		scenarios.put("A", 1);
		scenarios.put("B", 1);
		scenarios.put("C", 1);


		double totalQ = 0;
		int count = 0;
		for (Promotion promotion : promotions) {
			if (promotion.getClass().equals(NSKUForFixPrice.class)) {
				NSKUForFixPrice nSKUForFixPrice = (NSKUForFixPrice) promotion;
				Integer quantity = scenarios.get(nSKUForFixPrice.getSKUId());
				if (quantity != null && quantity>=nSKUForFixPrice.getQuantity()) {
					Optional<SKU> skuOp = skus.parallelStream()
							.filter(x -> x.getId().equals(nSKUForFixPrice.getSKUId())).findFirst();
					if (skuOp.isPresent()) {
						totalQ += nSKUForFixPrice.applyPromtion(skuOp.get(), quantity);
					}
					scenarios.remove(nSKUForFixPrice.getSKUId());

				}
			} else if (promotion.getClass().equals(SKU1AndSKU2ForFixPrice.class)) {
				SKU1AndSKU2ForFixPrice sKU1AndSKU2ForFixPrice = (SKU1AndSKU2ForFixPrice) promotion;
				Integer quantity1 = scenarios.get(sKU1AndSKU2ForFixPrice.getSKU1Id());
				Integer quantity2 = scenarios.get(sKU1AndSKU2ForFixPrice.getSKU2Id());

				if (quantity1 != null && quantity2 != null && quantity1>=sKU1AndSKU2ForFixPrice.getSku1Quantity() && quantity2>=sKU1AndSKU2ForFixPrice.getSku2Quantity()) {
					Optional<SKU> skuOp1 = skus.parallelStream()
							.filter(x -> x.getId().equals(sKU1AndSKU2ForFixPrice.getSKU1Id())).findFirst();
					Optional<SKU> skuOp2 = skus.parallelStream()
							.filter(x -> x.getId().equals(sKU1AndSKU2ForFixPrice.getSKU2Id())).findFirst();
					if (skuOp1.isPresent() && skuOp2.isPresent()) {

						scenarios.remove(sKU1AndSKU2ForFixPrice.getSKU1Id());
						scenarios.remove(sKU1AndSKU2ForFixPrice.getSKU2Id());

						totalQ += sKU1AndSKU2ForFixPrice.applyPromtion(skuOp1.get(), quantity1, skuOp2.get(),
								quantity2);
					}
				}
			}
			count++;
		}
		for (Map.Entry<String, Integer> scenario : scenarios.entrySet()) {
			Optional<SKU> skuOp = skus.parallelStream().filter(x -> x.getId().equals(scenario.getKey())).findFirst();
			totalQ += skuOp.get().getPrice() * scenario.getValue();

		}
		System.out.println(totalQ);

	}
}*/
