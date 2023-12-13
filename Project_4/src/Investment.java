class Investment {
    private String assetSymbol;
    private int amountInvested;
    private int futureValue;

    // Constructor to initialize an Investment object
    public Investment(String assetSymbol, int amountInvested, int futureValue) {
        this.assetSymbol = assetSymbol;
        this.amountInvested = amountInvested;
        this.futureValue = futureValue;
    }

    // Getter method to retrieve the asset symbol
    public String getAssetSymbol() {
        return assetSymbol;
    }

    // Getter method to retrieve the amount initially invested
    public int getAmountInvested() {
        return amountInvested;
    }

    // Getter method to retrieve the expected future value of the investment
    public int getFutureValue() {
        return futureValue;
    }
}