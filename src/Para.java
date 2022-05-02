public class Para {
    public int dividend;
    public int divider;

    public Para(int dividend, int divider) {
        this.dividend = dividend;
        this.divider = divider;
    }

    @Override
    public String toString() {
        return "Para{" +
                "dividend=" + dividend +
                ", divider=" + divider +
                '}';
    }
}
