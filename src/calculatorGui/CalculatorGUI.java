package calculatorGui;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");

    boolean canAddOperator = true;
    boolean stop = false;

    String exp = "";
    JFrame jFrame;
    JButton zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, multiply,
            divide, equal, negate, clear, delete, clearExpression, percentage, sqrRoot, square,
            inverse, dot;

    JTextField answers;
    JTextField expression;
    JPanel buttonsPanel;
    public CalculatorGUI(){
        initGUI();
        function();
    }


    private void initGUI(){

        jFrame = new JFrame("Calculator");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(310, 525);
        //jFrame.setLayout(null);

        expression = new JTextField();
        answers = new JTextField();

        expression.setBounds(5, 5, 285, 25);
        expression.setBackground(Color.white);
        expression.setFont(new Font("calibri",Font.BOLD,15));
        expression.setHorizontalAlignment(JTextField.RIGHT);
        expression.setBorder(BorderFactory.createCompoundBorder(
                expression.getBorder(),
                BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        expression.setText("exp=?");
        expression.setEditable(false);

        answers.setBounds(5, 30, 285, 50);
        answers.setBackground(Color.white);
        answers.setFont(new Font("calibri",Font.BOLD,20));
        answers.setHorizontalAlignment(JTextField.RIGHT);
        answers.setBorder(BorderFactory.createCompoundBorder(
                answers.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        answers.setText("0");
        answers.setEditable(false);




        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("x");
        divide = new JButton("\u00F7");
        equal = new JButton("=");
        negate = new JButton("+/-");
        clear = new JButton("C");
        clearExpression = new JButton("CE");
        delete = new JButton("\u232b");
        percentage = new JButton("%");
        square = new JButton("x\u00B2");
        sqrRoot = new JButton("\u221A");
        inverse = new JButton("1/x");
        dot = new JButton(".");

        zero.setBackground(Color.white);
        one.setBackground(Color.white);
        two.setBackground(Color.white);
        three.setBackground(Color.white);
        four.setBackground(Color.white);
        five.setBackground(Color.white);
        six.setBackground(Color.white);
        seven.setBackground(Color.white);
        eight.setBackground(Color.white);
        nine.setBackground(Color.white);

        plus.setBackground(Color.LIGHT_GRAY);
        minus.setBackground(Color.LIGHT_GRAY);
        multiply.setBackground(Color.LIGHT_GRAY);
        divide.setBackground(Color.LIGHT_GRAY);
        equal.setBackground(Color.LIGHT_GRAY);
        negate.setBackground(Color.LIGHT_GRAY);
        clear.setBackground(Color.LIGHT_GRAY);
        clearExpression.setBackground(Color.LIGHT_GRAY);
        delete.setBackground(Color.LIGHT_GRAY);
        percentage.setBackground(Color.LIGHT_GRAY);
        square.setBackground(Color.LIGHT_GRAY);
        sqrRoot.setBackground(Color.LIGHT_GRAY);
        inverse.setBackground(Color.LIGHT_GRAY);
        dot.setBackground(Color.LIGHT_GRAY);




        zero.setFont(new Font("",Font.BOLD,25));
        one.setFont(new Font("",Font.BOLD,25));
        two.setFont(new Font("",Font.BOLD,25));
        three.setFont(new Font("",Font.BOLD,25));
        four.setFont(new Font("",Font.BOLD,25));
        five.setFont(new Font("",Font.BOLD,25));
        six.setFont(new Font("",Font.BOLD,25));
        seven.setFont(new Font("",Font.BOLD,25));
        eight.setFont(new Font("",Font.BOLD,25));
        nine.setFont(new Font("",Font.BOLD,25));

        plus.setFont(new Font("",Font.PLAIN,25));
        minus.setFont(new Font("",Font.PLAIN,25));
        multiply.setFont(new Font("",Font.PLAIN,25));
        divide.setFont(new Font("",Font.PLAIN,25));
        equal.setFont(new Font("",Font.PLAIN,25));
        negate.setFont(new Font("",Font.PLAIN,25));
        clear.setFont(new Font("",Font.PLAIN,15));
        clearExpression.setFont(new Font("",Font.PLAIN,15));
        delete.setFont(new Font("",Font.PLAIN,20));
        percentage.setFont(new Font("",Font.PLAIN,20));
        square.setFont(new Font("",Font.PLAIN,20));
        sqrRoot.setFont(new Font("",Font.PLAIN,20));
        inverse.setFont(new Font("",Font.PLAIN,20));
        dot.setFont(new Font("",Font.BOLD,25));


        buttonsPanel = new JPanel(new GridLayout(6, 4));
        buttonsPanel.setBounds(5, 85, 285, 400);


        buttonsPanel.add(percentage);
        buttonsPanel.add(sqrRoot);
        buttonsPanel.add(square);
        buttonsPanel.add(inverse);
        buttonsPanel.add(clearExpression);
        buttonsPanel.add(clear);
        buttonsPanel.add(delete);
        buttonsPanel.add(divide);
        buttonsPanel.add(seven);
        buttonsPanel.add(eight);
        buttonsPanel.add(nine);
        buttonsPanel.add(multiply);
        buttonsPanel.add(four);
        buttonsPanel.add(five);
        buttonsPanel.add(six);
        buttonsPanel.add(minus);
        buttonsPanel.add(one);
        buttonsPanel.add(two);
        buttonsPanel.add(three);
        buttonsPanel.add(plus);
        buttonsPanel.add(negate);
        buttonsPanel.add(zero);
        buttonsPanel.add(dot);
        buttonsPanel.add(equal);


        Container container = jFrame.getContentPane();
        container.setLayout(null);

        container.add(expression);
        container.add(answers);
        container.add(buttonsPanel);


        jFrame.setVisible(true);
    }
    private void function(){
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += "0";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += "1";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += "2";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += "3";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += "4";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += "5";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += "6";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += "7";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += "8";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += "9";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop && canAddOperator){
                    exp += "+";
                    canAddOperator = false;
                    expression.setText(exp);
                }
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop && canAddOperator){
                    exp += "-";
                    canAddOperator = false;
                    expression.setText(exp);
                }
            }
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop && canAddOperator){
                    exp += "*";
                    canAddOperator = false;
                    expression.setText(exp);
                }
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop && canAddOperator){
                    exp += "/";
                    canAddOperator = false;
                    expression.setText(exp);
                }
            }
        });
        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop && canAddOperator){
                    if(exp.equals(""))
                        answers.setText("0");
                    else{
                        stop = true;

                        canAddOperator = false;

                        ScriptEngineManager mgr = new ScriptEngineManager();
                        ScriptEngine engine = mgr.getEngineByName("JavaScript");
                        try {
                            answers.setText(String.valueOf(engine.eval(exp)));
                        } catch (ScriptException scriptException) {
                            scriptException.printStackTrace();
                        }
                        exp += "=";
                        expression.setText(exp);
                        expression.setForeground(Color.gray);
                    }
                }
            }
        });
        negate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop && canAddOperator){
                    if(exp.equals(""))
                        answers.setText("0");
                    else{
                        stop = true;

                        canAddOperator = false;
                        expression.setText(exp);
                        float result = 0;
                        ScriptEngineManager mgr = new ScriptEngineManager();

                        ScriptEngine engine = mgr.getEngineByName("JavaScript");
                        try {
                            result =  Float.parseFloat((String.valueOf(engine.eval(exp))));

                            if(result!=0){
                                result = 0 - result;
                            }
                            answers.setText(String.valueOf(result));

                        } catch (ScriptException scriptException) {
                            scriptException.printStackTrace();
                        }
                        exp = "~"+result;
                        expression.setText(exp);
                        expression.setForeground(Color.gray);
                    }
                }
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop = false;
                exp = "";
                canAddOperator = true;
                expression.setText("exp=?");
                answers.setText("0");
                expression.setForeground(Color.black);
            }
        });
        clearExpression.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop = false;
                exp = "";
                canAddOperator = true;
                expression.setText("exp=?");
                expression.setForeground(Color.black);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop&&!exp.equals("")) {
                    exp = exp.substring(0, exp.length()-1);
                    expression.setText(exp);
                    if(exp.length()>0) {
                        canAddOperator = exp.charAt(exp.length() - 1) != '+' && exp.charAt(exp.length() - 1) != '-' &&
                                exp.charAt(exp.length() - 1) != '*' && exp.charAt(exp.length() - 1) != '/';
                    }


                }
            }
        });
        percentage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop && canAddOperator){
                    if(exp.equals(""))
                        answers.setText("0");
                    else{
                        stop = true;

                        canAddOperator = false;
                        float result = 0;
                        ScriptEngineManager mgr = new ScriptEngineManager();
                        ScriptEngine engine = mgr.getEngineByName("JavaScript");
                        try {
                            result =  Float.parseFloat((String.valueOf(engine.eval(exp))));

                            result = result/100;
                            answers.setText(String.valueOf(result));
                        } catch (ScriptException scriptException) {
                            scriptException.printStackTrace();
                        }
                        exp = exp + "%";
                        expression.setText(exp);
                        expression.setForeground(Color.gray);
                    }
                }
            }
        });
        square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop && canAddOperator){
                    if(exp.equals(""))
                        answers.setText("0");
                    else{
                        stop = true;

                        canAddOperator = false;
                        float result = 0;
                        ScriptEngineManager mgr = new ScriptEngineManager();
                        ScriptEngine engine = mgr.getEngineByName("JavaScript");
                        try {
                            result =  Float.parseFloat((String.valueOf(engine.eval(exp))));

                            result = result * result;
                            answers.setText(String.valueOf(result));
                        } catch (ScriptException scriptException) {
                            scriptException.printStackTrace();
                        }
                        exp = result + "^2";
                        expression.setText(exp);
                        expression.setForeground(Color.gray);
                    }
                }
            }
        });
        sqrRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop && canAddOperator){
                    if(exp.equals(""))
                        answers.setText("0");
                    else{
                        stop = true;

                        canAddOperator = false;
                        float result = 0;
                        ScriptEngineManager mgr = new ScriptEngineManager();
                        ScriptEngine engine = mgr.getEngineByName("JavaScript");
                        try {
                            result =  Float.parseFloat((String.valueOf(engine.eval(exp))));

                            result = (float) Math.sqrt(result);
                            answers.setText(String.valueOf(result));
                        } catch (ScriptException scriptException) {
                            scriptException.printStackTrace();
                        }
                        exp = "\u221A" + result;
                        expression.setText(exp);
                        expression.setForeground(Color.gray);
                    }
                }
            }
        });
        inverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop && canAddOperator){
                    if(exp.equals(""))
                        answers.setText("0");
                    else{
                        stop = true;

                        canAddOperator = false;
                        float result = 0;
                        ScriptEngineManager mgr = new ScriptEngineManager();
                        ScriptEngine engine = mgr.getEngineByName("JavaScript");
                        try {
                            result =  Float.parseFloat((String.valueOf(engine.eval(exp))));

                            if(result!=0)
                                result = 1/result;
                            answers.setText(String.valueOf(result));
                        } catch (ScriptException scriptException) {
                            scriptException.printStackTrace();
                        }
                        exp = result + "^-1";
                        expression.setText(exp);
                        expression.setForeground(Color.gray);
                    }
                }
            }
        });
        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!stop) {
                    exp += ".";
                    canAddOperator = true;
                    expression.setText(exp);
                }
            }
        });
    }
}
