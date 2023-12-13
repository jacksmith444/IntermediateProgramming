class StableAsset extends Asset {
    private double expectedReturn;

    
    //Constructor
    public StableAsset(String symbol, String name, double expectedReturn) {
        super(symbol, name);
        this.expectedReturn = expectedReturn;
    }
    
    //Calculate expected return
    @Override
    public double getExpectedReturn() {
        return expectedReturn;
    }
}