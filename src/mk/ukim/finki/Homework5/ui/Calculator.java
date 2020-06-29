package mk.ukim.finki.Homework5.ui;

import mk.ukim.finki.Homework5.CalculatorManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the main class of the project Calculator.
 * <p>
 * As we need a GUI with Swing, this class extends JFrame. The main form of an
 * application is often built in this way.
 * <p>
 * We also need to implement the ActionListener interface, in order to listen
 * action events. This events are triggered by buttons, for instance.
 */
public class Calculator extends JFrame implements ActionListener {
    /**
     * This static field is not really necessary. As I am using Eclipse IDE, he
     * advises me to include this field. You can remove it if you want.
     */

    private static final CalculatorManager calculatorManager = new CalculatorManager();

    private static final long serialVersionUID = 1L;

    /**
     * The starting point for the application.
     */
    public static void main(String args[]) {
        Calculator calc = new Calculator();
        calc.setTitle("Java Swing Calculator");
        calc.setSize(500, 1000);
        calc.pack();
        calc.setLocation(400, 250);
        calc.setVisible(true);
        calc.setResizable(true);
    }


    /**
     * Represents the display of the calculator.
     */
    private JLabel jlbOutput;


    /*
    Represents the display of the memory register
     */

    private JLabel jlbMemory;

    /*
    Represents the display that shows if a program is saved or not (0/1)
     */

    private JLabel jlbProgram;

    /*
    * Represents the display that shows the history (the simulation of the paper tape)
    * */
    private JLabel jlbTape;

    /**
     * The buttons array. All buttons are stored in this array later.
     */
    private JButton jbnButtons[];

    /**
     * The main panel of the GUI. This panel is the container of jplBackSpace,
     * jplButtons and jplControl.
     */
    private JPanel jplMaster;


    /**
     * Creates a new Font from the specified name, style and point size.
     */
    private Font f18 = new Font("Times New Roman", 0, 18);

    /**
     * Constructor - creates and configures the fields.
     */
    public Calculator() {
        /*
         * Set frame layout manager.
         *
         * The layout manager determines the size and position of the components
         * within a container.
         */

        setBackground(Color.gray);

        jplMaster = new JPanel();

        JPanel labelsPanel = new JPanel();

        jlbOutput = new JLabel("0");
        jlbOutput.setHorizontalTextPosition(JLabel.RIGHT);
        jlbOutput.setBackground(Color.WHITE);
        jlbOutput.setSize(300,20);
        jlbOutput.setFont(new Font("Times New Roman", 0, 24));
        jlbOutput.setOpaque(true);

        jlbMemory = new JLabel("M: 0");
        jlbMemory.setHorizontalTextPosition(JLabel.RIGHT);
        jlbMemory.setBackground(Color.WHITE);
        jlbMemory.setSize(150,20);
        jlbMemory.setFont(new Font("Times New Roman", 0, 24));
        jlbMemory.setOpaque(true);

        jlbProgram = new JLabel("P: 0");
        jlbProgram.setHorizontalTextPosition(JLabel.RIGHT);
        jlbProgram.setBackground(Color.WHITE);
        jlbProgram.setSize(150,20);
        jlbProgram.setFont(new Font("Times New Roman", 0, 24));
        jlbProgram.setOpaque(true);

        labelsPanel.setLayout(new BorderLayout());
        labelsPanel.add(jlbOutput, BorderLayout.NORTH);
        labelsPanel.add(jlbMemory, BorderLayout.CENTER);
        labelsPanel.add(jlbProgram, BorderLayout.SOUTH);

        jlbTape = new JLabel("Tape:                 ");
        jlbTape.setHorizontalTextPosition(JLabel.RIGHT);
        jlbTape.setBackground(Color.WHITE);
        jlbTape.setSize(500,100);
        jlbTape.setFont(new Font("Times New Roman", 0, 12));
        //jlbTape.setOpaque(true);

        /*
         * Add components to frame
         *
         * The content pane is the panel in a JFrame. Basically, a JFrame has
         * one menu bar (JMenuBar) and one panel (JPanel).
         *
         * The panel has a default layout manager named BorderLayout. This
         * layout manager divides the panel in five regions: north, south, east,
         * west, and center. Each region may contain no more than one component,
         * and is identified by a corresponding constant: NORTH, SOUTH, EAST,
         * WEST, and CENTER.
         */
        getContentPane().add(labelsPanel, BorderLayout.NORTH);


        /*
         * Here we create the buttons.
         */
        jbnButtons = new JButton[31];

        /* container for JButtons */
        JPanel jplButtons = new JPanel();

        // Create numeric JButtons
        for (int i = 0; i <= 9; i++) {
            // set each JButton label to the value of index
            jbnButtons[i] = new JButton(String.valueOf(i));
        }

        // Create operator JButtons
        jbnButtons[10] = new JButton("+/-");
        jbnButtons[11] = new JButton(".");
        jbnButtons[12] = new JButton("=");
        jbnButtons[13] = new JButton("/");
        jbnButtons[14] = new JButton("*");
        jbnButtons[15] = new JButton("-");
        jbnButtons[16] = new JButton("+");


        jbnButtons[17] = new JButton(" CE ");
        jbnButtons[18] = new JButton("C");

        jbnButtons[19] = new JButton("UNDO");
        jbnButtons[20] = new JButton("REDO");
        jbnButtons[21] = new JButton("PROG");
        jbnButtons[22] = new JButton("RCL");

        jbnButtons[23] = new JButton("MC");
        jbnButtons[24] = new JButton("MS");
        jbnButtons[25] = new JButton("M+");
        jbnButtons[26] = new JButton("M-");
        jbnButtons[27] = new JButton("MR");

        jbnButtons[28] = new JButton("CLR");
        jbnButtons[29] = new JButton("T");
        jbnButtons[30] = new JButton("+/-");


        // Setting all Numbered JButton's to Blue. The rest to Red
        for (int i = 0; i < jbnButtons.length; i++) {
            jbnButtons[i].setFont(f18);

            if (i < 10)
                jbnButtons[i].setForeground(Color.blue);

            else
                jbnButtons[i].setForeground(Color.red);
        }

        // Set panel layout manager for a 4 by 5 grid
        jplButtons.setLayout(new GridLayout(6, 5, 2, 2));

        // Add buttons to keypad panel starting at top left
        // First row

        for (int i=19;i<=23;i++)
            jplButtons.add(jbnButtons[i]);

        //Second row
        for (int i = 7; i <= 9; i++) {
            jplButtons.add(jbnButtons[i]);
        }

        // add button / and MS
        jplButtons.add(jbnButtons[13]);
        jplButtons.add(jbnButtons[24]);

        //Third row
        for (int i = 4; i <= 6; i++) {
            jplButtons.add(jbnButtons[i]);
        }

        // add button * and M+
        jplButtons.add(jbnButtons[14]);
        jplButtons.add(jbnButtons[25]);

        // Fourth row
        for (int i = 1; i <= 3; i++) {
            jplButtons.add(jbnButtons[i]);
        }

        // adds button - and M-
        jplButtons.add(jbnButtons[15]);
        jplButtons.add(jbnButtons[26]);

        // Fifth Row
        // add 0, ., +, = and MR
        jplButtons.add(jbnButtons[0]);
        jplButtons.add(jbnButtons[11]);
        jplButtons.add(jbnButtons[16]);
        jplButtons.add(jbnButtons[12]);
        jplButtons.add(jbnButtons[27]);

        //Sixth Row
        //add CLR and T buttons
        jplButtons.add(jbnButtons[28]);
        jplButtons.add(jbnButtons[29]);
        jplButtons.add(jbnButtons[30]);

        jplMaster.setLayout(new BorderLayout());
        jplMaster.add(jplButtons, BorderLayout.SOUTH);

        // Add components to frame
        getContentPane().add(jplMaster, BorderLayout.CENTER);
        getContentPane().add(jlbTape, BorderLayout.EAST);
        requestFocus();

        // activate ActionListener
        for (int i = 0; i < jbnButtons.length; i++) {
            jbnButtons[i].addActionListener(this);
        }

        /*
         * Clears the display and resets some fields.
         */


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } // End of Constructor Calculator

    /**
     * Actions handling - controls the menu items and buttons clicks
     */
    public void actionPerformed(ActionEvent e) {
        double result = 0;

        // Search for the button pressed until end of array or key found
        for (int i = 0; i < jbnButtons.length; i++) {
            if (e.getSource() == jbnButtons[i]) {
                String buttonText = jbnButtons[i].getText();
                jlbOutput.setText(calculatorManager.acceptKey(buttonText));
                jlbMemory.setText(calculatorManager.getMemory());
                jlbProgram.setText(calculatorManager.getProgramString());
                jlbTape.setText(calculatorManager.getTapeString());

            }
        }
    }

}