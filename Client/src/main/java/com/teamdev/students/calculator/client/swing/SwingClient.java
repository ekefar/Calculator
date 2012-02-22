package com.teamdev.students.calculator.client.swing;

import com.teamdev.students.calculator.services.CalculationException;
import com.teamdev.students.calculator.services.CalculationService;
import com.teamdev.students.calculator.services.CalculationServicesFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents simple swing UI
 */
public class SwingClient extends JFrame {

    // contains user`s input
    JTextArea textArea;

    // displays result of calculations
    JLabel resultLabel;

    // init calculation
    JButton okButton;

    public SwingClient() {
        super("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // create main panel
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.LINE_AXIS));

        // create ui elements
        textArea = new JTextArea();
        resultLabel = new JLabel("Result:");
        okButton = new JButton("Calculate");

        // add listener to the calculation button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation();
            }
        });

        // add them to panels
        outputPanel.add(resultLabel);
        outputPanel.add(Box.createHorizontalGlue());

        buttonsPanel.add(Box.createHorizontalGlue());
        buttonsPanel.add(okButton);

        // add all to main panel
        content.add(new JScrollPane(textArea));
        content.add(Box.createVerticalStrut(5));
        content.add(outputPanel);
        content.add(Box.createVerticalStrut(8));
        content.add(buttonsPanel);

        // prepare and show frame
        setContentPane(content);
        setPreferredSize(new Dimension(400, 200));
        pack();
        setVisible(true);
    }


    /**
     * Read expression from text area, perform calculations and display result.
     */
    private void performCalculation() {
        // create calculation service
        CalculationService calculationService = CalculationServicesFactory.createSimpleCalculationService();

        // get expression from text area
        String expression = textArea.getText().replaceAll("\n", "").replaceAll(" ", "");

        // try to calculate
        try {
            double calculationResult = calculationService.calculate(expression);
            resultLabel.setText("Result: " + Double.toString(calculationResult));
            textArea.setText(expression);
        } catch (CalculationException e1) {
            // show error message
            char invalidToken = expression.charAt(e1.getInvalidTokenPosition());
            resultLabel.setText("Result: '" + invalidToken + "'" + " at " + (e1.getInvalidTokenPosition() + 1) + ", " + e1.getMessage());

            // position cursor on the invalid token
            textArea.setText(expression);
            textArea.requestFocus();
            textArea.setCaretPosition(e1.getInvalidTokenPosition());
        } catch (Exception e) {
            resultLabel.setText(e.getMessage());

        }
    }


}
