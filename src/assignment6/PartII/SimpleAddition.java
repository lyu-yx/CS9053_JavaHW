package assignment6.PartII;

import javax.swing.*;

public class SimpleAddition extends JFrame {

    JPanel textPanel, panelForTextFields, completionPanel;
    JLabel titleLabel, addend1Label, addend2Label, sumLabel;
    JTextField addend1Field, addend2Field;
    JLabel sumField;
    JButton quitButton;
    private double addend1, addend2, sum;

    public SimpleAddition() {
    	this.add(this.createContentPane());
    }
    
    private void setupComponentValues() {

    	/* Do not worry about any of this code. It just sets the
    	 * GUI layout up. You don't have to understand it to
    	 * complete the assignment 
    	 */
    	
        titleLabel = new JLabel("Addition Calculator");
        titleLabel.setLocation(110,0);
        titleLabel.setSize(180, 30);
        titleLabel.setHorizontalAlignment(0);

        // Creation of a Panel to contain the JLabels
        textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setLocation(10, 35);
        textPanel.setSize(180, 190);

        // Loan Label
        addend1Label = new JLabel("Addend 1");
        addend1Label.setLocation(0, 10);
        addend1Label.setSize(100, 30);
        addend1Label.setHorizontalAlignment(4);
        textPanel.add(addend1Label);

        // Login Label
        addend2Label = new JLabel("Addend 2");
        addend2Label.setLocation(0, 50);
        addend2Label.setSize(100, 30);
        addend2Label.setHorizontalAlignment(4);
        textPanel.add(addend2Label);
        
        sumLabel = new JLabel("Sum");
        sumLabel.setLocation(0,90);
        sumLabel.setSize(100, 30);
        sumLabel.setHorizontalAlignment(4);
        textPanel.add(sumLabel);

        // TextFields Panel Container
        panelForTextFields = new JPanel();
        panelForTextFields.setLayout(null);
        panelForTextFields.setLocation(250, 40);
        panelForTextFields.setSize(100, 180);

        // Addend1 
        addend1Field = new JTextField(8);
        addend1Field.setLocation(0, 0);
        addend1Field.setSize(100, 30);
        addend1Field.setText("5");
        panelForTextFields.add(addend1Field);
        

        // Addend2 
        addend2Field = new JTextField(8);
        addend2Field.setLocation(0, 40);
        addend2Field.setSize(100, 30);
        addend2Field.setText("6");
        panelForTextFields.add(addend2Field);
        
        sumField = new JLabel();
        sumField.setLocation(0, 80);
        sumField.setSize(100, 30);
        panelForTextFields.add(sumField);
        
        // Creation of a Panel to contain the completion JLabels
        completionPanel = new JPanel();
        completionPanel.setLayout(null);
        completionPanel.setLocation(40, 35);
        completionPanel.setSize(170, 180);
        
        // Button for Logging in
        quitButton = new JButton("Close");
        quitButton.setLocation(130, 250);
        quitButton.setSize(150, 30);
        quitButton.addActionListener((e) -> System.exit(0) );
    }

    public JPanel createContentPane (){

        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        setupComponentValues();
        /* initialize the sum value */
        String addend1String = addend1Field.getText();
        String addend2String = addend2Field.getText();
        
        /* initialize the sum field */        
        sumField.setText(Double.toString( Double.parseDouble(addend1String) + Double.parseDouble(addend2String)));

        /* any change in the addend fields is an event. add an event listener that will recalculate the sum any time a
         * change occurs in either addend field.
         * Your assignment is to add action listeners that will automatically update the sum
         * Hint: the code that initializes the text of sumField can be executed again to update the value to reflect
         * the current value
         */
        addend1Field.addActionListener((e) ->  {
                //panelForTextFields.add(addend2Field);
                sumField.setText(Double.toString( Double.parseDouble(addend1Field.getText()) + Double.parseDouble(addend2Field.getText())));});
        addend2Field.addActionListener((e) ->  {
                //panelForTextFields.add(addend2Field);
                sumField.setText(Double.toString( Double.parseDouble(addend1Field.getText()) + Double.parseDouble(addend2Field.getText())));});

        totalGUI.add(titleLabel);
        totalGUI.add(textPanel);
        totalGUI.add(panelForTextFields);
        totalGUI.add(completionPanel);
        totalGUI.add(quitButton);
        totalGUI.setOpaque(true);    
        return totalGUI;
    }


    public static void main(String[] args) {
    	
    	SimpleAddition simpleAddition = new SimpleAddition();
    	simpleAddition.setSize(400,400);
    	simpleAddition.setVisible(true);
    	
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
    }
}