public class LineItem {
    private Product product;
    private int quantity;
    private double total;

    public LineItem(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
        this.total = product.getCost() * quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getTotal()
    {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString()
    {
        return String.format("%-10s %-5s %-8s %-8s \n", product.getName(), quantity, product.getCost(), total) ;
    }
}
