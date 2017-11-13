package goldmansachs;

import java.util.Arrays;

public class MaximumUniqueItems {

	static String getMaxGroceryItems(int salary, int itemsToBuyForCashback, int cashback, String prices) {
		int amountLeft = salary + 10;//discount coupon also added
		int totalItemsbought = 0;

		String arr[] = prices.split(",");

		int price[] = new int[arr.length];
		Arrays.sort(price);
		for (int i = 0; i < arr.length; i++)
			price[i] = Integer.parseInt(arr[i]);

		Arrays.sort(price);

		// base case
		if (price[0] > amountLeft)
			return totalItemsbought + " " + amountLeft;

		// System.out.println(arr.length);

		for (int i = 0; i < arr.length; i++) {
			if (price[i] <= amountLeft) {
				amountLeft = amountLeft - price[i];
				// System.out.println(price[i]);
				totalItemsbought++;

				// System.out.println(totalItemsbought);

			}
			if (totalItemsbought % itemsToBuyForCashback == 0) {
				amountLeft = amountLeft + cashback;
			}
		}
		return totalItemsbought + " " + amountLeft;
	}

	public static void main(String[] args) {
		String result = getMaxGroceryItems(50, 3, 10, "22,12,1,2,5,4,8,6,14,18,7");
		System.out.println(result);
	}

}
