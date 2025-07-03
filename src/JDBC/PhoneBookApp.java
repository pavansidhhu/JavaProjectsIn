package JDBC;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class PhoneBookApp extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "pa1@sql";

    private JTextField nameField, phoneField, emailField, addressField;
    private JTextArea outputArea;
    private Connection conn;

    public PhoneBookApp() {
        setTitle("Phone Book Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input fields
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        addressField = new JTextField();

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add");
        JButton viewBtn = new JButton("View All");
        JButton updateBtn = new JButton("Update by Name");
        JButton deleteBtn = new JButton("Delete by Name");

        buttonPanel.add(addBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);

        // Output area
        outputArea = new JTextArea(10, 60);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Database connection
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            String sql = "CREATE TABLE IF NOT EXISTS contacts (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "phone_number VARCHAR(20)," +
                    "email VARCHAR(100)," +
                    "address VARCHAR(200))";
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            showMessage("Connection Failed: " + e.getMessage());
        }

        // Action listeners
        addBtn.addActionListener(e -> addContact());
        viewBtn.addActionListener(e -> viewContacts());
        updateBtn.addActionListener(e -> updateContact());
        deleteBtn.addActionListener(e -> deleteContact());

        setVisible(true);
    }

    private void addContact() {
        try (PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO contacts(name, phone_number, email, address) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, nameField.getText());
            stmt.setString(2, phoneField.getText());
            stmt.setString(3, emailField.getText());
            stmt.setString(4, addressField.getText());
            int rows = stmt.executeUpdate();
            showMessage("Added " + rows + " contact(s).");
        } catch (SQLException e) {
            showMessage("Error: " + e.getMessage());
        }
    }

    private void viewContacts() {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM contacts")) {
            outputArea.setText("");
            while (rs.next()) {
                outputArea.append("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Phone: " + rs.getString("phone_number") +
                        ", Email: " + rs.getString("email") +
                        ", Address: " + rs.getString("address") + "\n");
            }
        } catch (SQLException e) {
            showMessage("Error: " + e.getMessage());
        }
    }

    private void updateContact() {
        try (PreparedStatement stmt = conn.prepareStatement(
                "UPDATE contacts SET phone_number=?, email=?, address=? WHERE name=?")) {
            stmt.setString(1, phoneField.getText());
            stmt.setString(2, emailField.getText());
            stmt.setString(3, addressField.getText());
            stmt.setString(4, nameField.getText());
            int rows = stmt.executeUpdate();
            showMessage("Updated " + rows + " contact(s).");
        } catch (SQLException e) {
            showMessage("Error: " + e.getMessage());
        }
    }

    private void deleteContact() {
        try (PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM contacts WHERE name=?")) {
            stmt.setString(1, nameField.getText());
            int rows = stmt.executeUpdate();
            showMessage("Deleted " + rows + " contact(s).");
        } catch (SQLException e) {
            showMessage("Error: " + e.getMessage());
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PhoneBookApp::new);
    }
}

