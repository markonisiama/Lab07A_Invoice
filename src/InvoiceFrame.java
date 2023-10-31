import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InvoiceFrame extends JFrame {

    private JFrame frame;
    private JTextArea invoiceTextArea;
    private JTextField titleField;
    private JTextField customerAddressField;
    private JTextField productNameField;
    private JTextField quantityField;
    private JTextField unitPriceField;
    private int lineItemCounter = 0;
    Toolkit kit = Toolkit.getDefaultToolkit();
    private Invoice invoice;
    private LineItem lineItem;


    public InvoiceFrame()
    {

        setTitle("Invoice Entry");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2));

        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Customer Address:"));
        customerAddressField = new JTextField();
        inputPanel.add(customerAddressField);

        inputPanel.add(new JLabel("Product Name:"));
        productNameField = new JTextField();
        inputPanel.add(productNameField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        inputPanel.add(new JLabel("Unit Price:"));
        unitPriceField = new JTextField();
        inputPanel.add(unitPriceField);

        JButton addItemButton = new JButton("Add Line Item");
        addItemButton.addActionListener((ActionEvent ae) ->
        {
            createLineItem();

        });

        inputPanel.add(addItemButton);

        JButton calculateTotalButton = new JButton("Calculate Total");
        calculateTotalButton.addActionListener((ActionEvent ae) ->
        {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Amount due: " + invoice.calculateTotalAmountDue());
            System.out.println("------------------------------------------------------------------------");
            clearAllInputFields();

        });

        JButton createNewInvoice = new JButton("Create new invoice");
        createNewInvoice.addActionListener((ActionEvent ae) ->
        {
            System.out.println("------------------------------------------------------------------------");
            createInvoice();
            System.out.print(invoice.toString());
            System.out.println("------------------------------------------------------------------------");

            System.out.printf("%-10s %-5s %-8s %-8s \n", "Name", "Qty", "Cost", "Total");
            createLineItem();



        });
        inputPanel.add(createNewInvoice);

        inputPanel.add(calculateTotalButton);

        add(inputPanel, BorderLayout.NORTH);
        pack();


    }

    private void createInvoice()
    {

        String title = titleField.getText();
        String customerAddress = customerAddressField.getText();
        invoice = new Invoice(title, customerAddress);

    }

    private void createLineItem() {

        try
        {
            String productName = productNameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double unitPrice = Double.parseDouble(unitPriceField.getText());

            Product product = new Product(productName, unitPrice);
            lineItem = new LineItem(product, quantity);
            invoice.addLineItem(lineItem);
            System.out.print(lineItem.toString());
            clearInputFields();
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(frame, "Invalid input. Quantity and Unit Price must be numbers.");
        }
    }


    private void clearInputFields()
    {
        productNameField.setText("");
        quantityField.setText("");
        unitPriceField.setText("");
    }

    private void clearAllInputFields()
    {
        titleField.setText("");
        customerAddressField.setText("");
        productNameField.setText("");
        quantityField.setText("");
        unitPriceField.setText("");
    }



}
