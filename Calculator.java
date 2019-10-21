import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author sonmezerekrem
 * A basic java gui calculator
 * To use this program run main method
 */
public class Calculator extends JFrame {

    public static void main(String[] args) {
        new Calculator().setVisible(true);
    }
    public Calculator() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+"1");
    }

    private void button2ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+"2");
    }

    private void button3ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+"3");
    }

    private void button5ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+"4");
    }

    private void button6ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+"5");
    }

    private void button4ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+"6");
    }

    private void button8ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+"7");
    }

    private void button9ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+"8");
    }

    private void button7ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+"9");
    }

    private void button12ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+"0");
    }

    private void button11ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        textField1.setText(n+".");
    }

    private void button10ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        if(n.length()>0) {
            if(n.charAt(n.length()-1) != '+' && n.charAt(n.length()-1) != '-'
                    && n.charAt(n.length()-1) != '*' && n.charAt(n.length()-1) != '/' && n.charAt(n.length()-1) != '.'
                    && n.charAt(n.length()-1) != ' ')
                textField1.setText(n+" + ");
        }
    }

    private void button13ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        if(n.length() == 0  || n.charAt(n.length()-2) != '-')
            textField1.setText(n+" - ");
    }

    private void button14ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        if(n.length()>0)
            textField1.setText(n+" * ");
    }

    private void button15ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        if(n.length()>0)
            textField1.setText(n+" / ");
    }

    private void button16ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        if(n.length()>0) {
            n = n.replace("  ", " ");
            if (n.charAt(0) == ' ')
                n = n.substring(1);
            String[] operation = n.split(" ");


            

            for (int i = 0; i < operation.length; i++) {
                if (operation[i].equals("*")) {
                    if (!operation[i + 1].equals("-")) {
                        double x = Double.parseDouble(operation[i - 1]);
                        double y = Double.parseDouble(operation[i + 1]);
                        x = x * y;
                        operation[i - 1] = "0";
                        operation[i] = "+";
                        operation[i + 1] = Double.toString(x);
                    } else {
                        double x = Double.parseDouble(operation[i - 1]);
                        double y = Double.parseDouble(operation[i + 2]);
                        x = x * y;
                        operation[i - 1] = "0";
                        operation[i] = "+";
                        operation[i + 1] = "-";
                        operation[i + 2] = Double.toString(x);
                    }
                } else if (operation[i].equals("/")) {
                    if (!operation[i + 1].equals("-")) {
                        double x = Double.parseDouble(operation[i - 1]);
                        double y = Double.parseDouble(operation[i + 1]);
                        x = x / y;
                        operation[i - 1] = "0";
                        operation[i] = "+";
                        operation[i + 1] = Double.toString(x);
                    } else {
                        double x = Double.parseDouble(operation[i - 1]);
                        double y = Double.parseDouble(operation[i + 2]);
                        x = x / y;
                        operation[i - 1] = "0";
                        operation[i] = "+";
                        operation[i + 1] = "-";
                        operation[i + 2] = Double.toString(x);
                    }
                }
            }
            
            for (int i = 0; i < operation.length; i++) {
                System.out.print(operation[i] + " ");
            }

            double result = 0.0;
            if (operation[0].equals("-")) {
                result = Double.parseDouble(operation[1]);
                result = result * -1;
            } else {
                result = Double.parseDouble(operation[0]);
            }

            for (int i = 0; i < operation.length; i++) {
                if (operation[i].equals("+")) {
                    if (!operation[i + 1].equals("-"))
                        result += Double.parseDouble(operation[i + 1]);
                    else
                        result -= Double.parseDouble(operation[i + 2]);
                }
                if (operation[i].equals("-")) {
                    if (i != 0) {
                        if (!operation[i - 1].equals("+"))
                            result -= Double.parseDouble(operation[i + 1]);
                    } else
                        continue;
                }
                if (operation[i].equals("*")) {
                    result *= Double.parseDouble(operation[i + 1]);
                }
                if (operation[i].equals("/")) {
                    result /= Double.parseDouble(operation[i + 1]);
                }
                int a = (int) result;
                if (a == result)
                    textField1.setText(Integer.toString(a));
                else
                    textField1.setText(Double.toString(result));

            }
        }
    }

    private void button17ActionPerformed(ActionEvent e) {
        textField1.setText("");
    }

    private void button18ActionPerformed(ActionEvent e) {
        String n = textField1.getText();
        if(n.length()>0) {
            if (n.charAt(n.length() - 1) == ' ')
                textField1.setText(n.substring(0, n.length() - 3));
            else
                textField1.setText(n.substring(0, n.length() - 1));
        }
    }


    private void initComponents() {
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button12 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button13 = new JButton();
        button14 = new JButton();
        button15 = new JButton();
        button16 = new JButton();
        label2 = new JLabel();
        button17 = new JButton();
        button18 = new JButton();

        //======== this ========
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setName("Calculator");
        setTitle("Calculator");
        setMinimumSize(new Dimension(645, 570));
        setForeground(Color.magenta);
        setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Calculator");
        label1.setFont(new Font("Segoe UI Light", Font.PLAIN, 65));
        label1.setForeground(Color.black);

        //---- textField1 ----
        textField1.setFont(new Font("Segoe UI Light", Font.BOLD, 40));
        textField1.setForeground(Color.white);
        textField1.setBackground(Color.black);
        textField1.setBorder(null);
        textField1.setHorizontalAlignment(SwingConstants.RIGHT);
        textField1.setEditable(false);

        //---- button1 ----
        button1.setText("1");
        button1.setBorder(null);
        button1.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button1.setForeground(Color.white);
        button1.setBackground(Color.black);
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("2");
        button2.setBorder(null);
        button2.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button2.setForeground(Color.white);
        button2.setBackground(Color.black);
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("3");
        button3.setBorder(null);
        button3.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button3.setForeground(Color.white);
        button3.setBackground(Color.black);
        button3.addActionListener(e -> button3ActionPerformed(e));

        //---- button4 ----
        button4.setText("6");
        button4.setBorder(null);
        button4.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button4.setForeground(Color.white);
        button4.setBackground(Color.black);
        button4.addActionListener(e -> button4ActionPerformed(e));

        //---- button5 ----
        button5.setText("4");
        button5.setBorder(null);
        button5.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button5.setForeground(Color.white);
        button5.setBackground(Color.black);
        button5.addActionListener(e -> button5ActionPerformed(e));

        //---- button6 ----
        button6.setText("5");
        button6.setBorder(null);
        button6.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button6.setForeground(Color.white);
        button6.setBackground(Color.black);
        button6.addActionListener(e -> button6ActionPerformed(e));

        //---- button7 ----
        button7.setText("9");
        button7.setBorder(null);
        button7.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button7.setForeground(Color.white);
        button7.setBackground(Color.black);
        button7.addActionListener(e -> button7ActionPerformed(e));

        //---- button8 ----
        button8.setText("7");
        button8.setBorder(null);
        button8.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button8.setForeground(Color.white);
        button8.setBackground(Color.black);
        button8.addActionListener(e -> button8ActionPerformed(e));

        //---- button9 ----
        button9.setText("8");
        button9.setBorder(null);
        button9.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button9.setForeground(Color.white);
        button9.setBackground(Color.black);
        button9.addActionListener(e -> button9ActionPerformed(e));

        //---- button12 ----
        button12.setText("0");
        button12.setBorder(null);
        button12.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button12.setForeground(Color.white);
        button12.setBackground(Color.black);
        button12.addActionListener(e -> button12ActionPerformed(e));

        //---- button10 ----
        button10.setBorder(null);
        button10.setBackground(Color.black);
        button10.setForeground(Color.white);
        button10.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button10.setText("+");
        button10.addActionListener(e -> button10ActionPerformed(e));

        //---- button11 ----
        button11.setText(".");
        button11.setBorder(null);
        button11.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button11.setForeground(Color.white);
        button11.setBackground(Color.black);
        button11.addActionListener(e -> button11ActionPerformed(e));

        //---- button13 ----
        button13.setBorder(null);
        button13.setBackground(Color.black);
        button13.setForeground(Color.white);
        button13.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button13.setText("-");
        button13.addActionListener(e -> button13ActionPerformed(e));

        //---- button14 ----
        button14.setBorder(null);
        button14.setBackground(Color.black);
        button14.setForeground(Color.white);
        button14.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button14.setText("*");
        button14.addActionListener(e -> button14ActionPerformed(e));

        //---- button15 ----
        button15.setBorder(null);
        button15.setBackground(Color.black);
        button15.setForeground(Color.white);
        button15.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button15.setText("/");
        button15.addActionListener(e -> button15ActionPerformed(e));

        //---- button16 ----
        button16.setText("=");
        button16.setBorder(null);
        button16.setBackground(Color.black);
        button16.setForeground(Color.white);
        button16.setFont(new Font("Segoe UI Light", Font.BOLD, 48));
        button16.addActionListener(e -> button16ActionPerformed(e));

        //---- label2 ----
        label2.setText("");
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        label2.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
        label2.setForeground(Color.black);

        //---- button17 ----
        button17.setBorder(null);
        button17.setBackground(Color.black);
        button17.setForeground(Color.white);
        button17.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button17.setText("esc");
        button17.addActionListener(e -> button17ActionPerformed(e));

        //---- button18 ----
        button18.setBorder(null);
        button18.setBackground(Color.black);
        button18.setForeground(Color.white);
        button18.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
        button18.setText("del");
        button18.addActionListener(e -> button18ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(button12, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(button11, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(button8, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(button9, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(button7, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(button5, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(button6, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(31, 31, 31)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(button15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(button14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(button13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(button10, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(button16, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button17, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button18, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
                                .addContainerGap(59, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(button8, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button9, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(button12, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button11, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(button10, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button17, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(button13, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button18, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(button14, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(button15, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(button16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        setSize(645, 570);
        setLocationRelativeTo(getOwner());
    }

    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button12;
    private JButton button10;
    private JButton button11;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JLabel label2;
    private JButton button17;
    private JButton button18;
    
}
