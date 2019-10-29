package UserProgram;

public class RoomType {
    private String categoryName;
    private int maxGuestAllowance;
    private double pricePerNight;
    private double pricePerWeek;
    private double promoPrice;
    private static int counter=0;
    private int id;

    public RoomType(String categoryName, int maxGuestAllowance, double pricePerNight, double pricePerWeek, double promoPrice) {
        this.maxGuestAllowance=maxGuestAllowance;
        this.categoryName=categoryName;
        this.pricePerNight = pricePerNight;
        this.pricePerWeek = pricePerWeek;
        this.promoPrice = promoPrice;
        this.id=counter;
        counter++;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public double getPricePerNight() {
        return pricePerNight;
    }
    public double getPricePerWeek() {
        return pricePerWeek;
    }
    public double getPromoPrice() {
        return promoPrice;
    }
    private void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public int getMaxGuestAllowance() {
        return maxGuestAllowance;
    }
    public void setMaxGuestAllowance(int maxGuestAllowance) {
        this.maxGuestAllowance = maxGuestAllowance;
    }
    private void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    private void setPricePerWeek(double pricePerWeek) {
        this.pricePerWeek = pricePerWeek;
    }
    private void setPromoPrice(double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public String toString(){
        return " Category: "+ categoryName+"/ MaxG: "+maxGuestAllowance+"/ PPN: "+pricePerNight+"/ PPW: "+ pricePerWeek+ "/ Promo Price: "+promoPrice;
    }

}
