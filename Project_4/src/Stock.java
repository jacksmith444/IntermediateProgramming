class Stock extends Asset {
    private double fiveYearReturn;
    private double oneYearReturn;
    private double ninetyDayReturn;
    
    //Constructor
    public Stock(String symbol, String name, double fiveYearReturn, double oneYearReturn, double ninetyDayReturn) {
        super(symbol, name);
        this.fiveYearReturn = fiveYearReturn;
        this.oneYearReturn = oneYearReturn;
        this.ninetyDayReturn = ninetyDayReturn;
    }
    
    public double getExpectedReturnSchemeB() {
        return 0.6 * oneYearReturn + 0.4 * ninetyDayReturn;
    }
    
    @Override
    public double getExpectedReturn() {
        return 0.6 * fiveYearReturn + 0.2 * oneYearReturn + 0.2 * ninetyDayReturn;
    }
}