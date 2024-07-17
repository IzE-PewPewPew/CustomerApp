import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfo {
    private JFrame frame;
    private JLabel idLabel, lastNameLabel, firstNameLabel, phoneLabel;
    private JTextField idField, lastNameField, firstNameField, phoneField;
    private JButton preButton, nButton;
    private int currentIndex = 0;
    private Customer[] customers;

    public CustomerInfo(Customer[] customers) {
        this.customers = customers;
        initialize();
        updateCustomerInfo();
    }

    private void initialize() {
        frame = new JFrame("Customer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        idLabel = new JLabel("ID:");
        frame.add(idLabel, gbc);
        gbc.gridx = 1;
        idField = new JTextField(15);
        idField.setEditable(false);
        frame.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        lastNameLabel = new JLabel("Last Name:");
        frame.add(lastNameLabel, gbc);
        gbc.gridx = 1;
        lastNameField = new JTextField(15);
        lastNameField.setEditable(false);
        frame.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        firstNameLabel = new JLabel("First Name:");
        frame.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        firstNameField = new JTextField(15);
        firstNameField.setEditable(false);
        frame.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        phoneLabel = new JLabel("Phone:");
        frame.add(phoneLabel, gbc);
        gbc.gridx = 1;
        phoneField = new JTextField(15);
        phoneField.setEditable(false);
        frame.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        preButton = new JButton("Previous");
        preButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateCustomerInfo();
                }
            }
        });
        frame.add(preButton, gbc);

        gbc.gridx = 1;
        nButton = new JButton("Next");
        nButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < customers.length - 1) {
                    currentIndex++;
                    updateCustomerInfo();
                }
            }
        });
        frame.add(nButton, gbc);

        frame.setVisible(true);
    }

    private void updateCustomerInfo() {
        Customer customer = customers[currentIndex];
        idField.setText(String.valueOf(customer.getId()));
        lastNameField.setText(customer.getLastName());
        firstNameField.setText(customer.getFirstName());
        phoneField.setText(customer.getPhone());
    }

    public static void main(String[] args) {
        Customer[] customers = {
                new Customer(1, "Chenda", "Sovisal", "092888999"),
                new Customer(2, "Kom", "Lina", "092088999"),
                new Customer(3, "Chan", "Seyha", "092777666")
        };

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerInfo(customers);
            }
        });
    }
}
