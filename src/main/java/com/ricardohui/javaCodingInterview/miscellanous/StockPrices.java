class Tuple<X, Y> {
    public X x;
    public Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}

class StockPrices {
    public static Tuple findBuySellStockPrices(int[] array) {
        if (array.length < 2) {
            return null;
        }


        int localBuyPrice = array[0];
        int localSellPrice = array[1];

        int globalBuyPrice =  localBuyPrice;
        int globalSellPrice = localSellPrice;


        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1 && array[i] < localBuyPrice) {
                localBuyPrice = array[i];
                localSellPrice = array[i+1];
            }
            else {
                if (i != 0 && array[i] > localSellPrice) {
                    localSellPrice = array[i];
                }
            }

            System.out.println("localBuyPrice: " + localBuyPrice);
            System.out.println("localSellPrice: " + localSellPrice);
            if (localSellPrice - localBuyPrice > globalSellPrice - globalBuyPrice) {
                globalBuyPrice = localBuyPrice;
                globalSellPrice = localSellPrice;
            }
        }
        Tuple<Integer, Integer> result = new Tuple<Integer, Integer>(globalBuyPrice, globalSellPrice);

        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        Tuple result = null;
        result = findBuySellStockPrices(array);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));
        assert result.x == Integer.valueOf(1) : "expect 1 but actual: " + result.x;
        assert result.y == Integer.valueOf(5) : "expect 5 but actual: " + result.y;

        int[] array2 = {8, 6, 5, 4, 3, 2, 1};
        result = findBuySellStockPrices(array2);
        System.out.printf("Buy Price: %d, Sell Price: %d", result.x, result.y);
        assert result.x == Integer.valueOf(6) : "expect 6 but actual: " + result.x;
        assert result.y == Integer.valueOf(5) : "expect 5 but actual: " + result.y;
    }
}