import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String title;
    private String customerAddress;
    private ArrayList<LineItem> lineItems;

    public Invoice(String title, String customerAddress) {
        this.title = title;
        this.customerAddress = customerAddress;
        this.lineItems = new ArrayList<>();

    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCustomerAddress()
    {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress)
    {
        this.customerAddress = customerAddress;
    }

    public ArrayList<LineItem> getLineItems()
    {
        return lineItems;
    }

    public void setLineItems(ArrayList<LineItem> lineItems)
    {
        this.lineItems = lineItems;
    }
    public void addLineItem(LineItem lineItem)
    {
        lineItems.add(lineItem);
    }
    public double calculateTotalAmountDue() {
        double totalAmountDue = 0.0;
        for (LineItem item : lineItems) {
            totalAmountDue += item.getTotal();
        }
        return totalAmountDue;
    }

    @Override
    public String toString() {
        return title + "\n" + customerAddress + "\n";
    }
}
