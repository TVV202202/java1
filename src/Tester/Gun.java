package Tester;

class Gun {
    String model;
    Double caliber;
    private int cartrigeCount;

    public Gun(String model, Double caliber, int cartrigeCount) {
        this.model = model;
        this.caliber = caliber;
        this.cartrigeCount = cartrigeCount;
    }

    public int getCartrigeCount() {
        return cartrigeCount;
    }

    public void setCartrigeCount(int cartrigeCount) {
        if (cartrigeCount>16)
            this.cartrigeCount=16;
        else
            this.cartrigeCount = cartrigeCount;
    }
}
