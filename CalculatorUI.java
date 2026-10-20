import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {

    private final JTextField firstField = new JTextField();
    private final JTextField secondField = new JTextField();
    private final JLabel resultLabel = new JLabel("Result: -", SwingConstants.CENTER);

    public CalculatorUI() {
        super("Simple Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(360, 260);
        setLocationRelativeTo(null);

        JPanel inputs = new JPanel(new GridLayout(2, 2, 10, 10));
        inputs.add(new JLabel("First number:"));
        inputs.add(firstField);
        inputs.add(new JLabel("Second number:"));
        inputs.add(secondField);

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        addButton.addActionListener(e -> calculate(true));
        subtractButton.addActionListener(e -> calculate(false));

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttons.add(addButton);
        buttons.add(subtractButton);

        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        JPanel root = new JPanel(new BorderLayout(10, 15));
        root.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        root.add(inputs, BorderLayout.NORTH);
        root.add(buttons, BorderLayout.CENTER);
        root.add(resultLabel, BorderLayout.SOUTH);
        setContentPane(root);
    }

    private void calculate(boolean isAdd) {
        try {
            double a = Double.parseDouble(firstField.getText().trim());
            double b = Double.parseDouble(secondField.getText().trim());
            double result = isAdd ? Calculator.add(a, b) : Calculator.subtract(a, b);
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorUI().setVisible(true));
    }
}
