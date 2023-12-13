abstract class Asset {
    protected String symbol;
    protected String name;
    
    //Constructor
    public Asset(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
    
    //Calculate expected return
    public abstract double getExpectedReturn();

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}