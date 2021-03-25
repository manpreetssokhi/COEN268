Rpackage com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.util.Log;
import java.util.*;
import java.util.Stack;
import java.util.ArrayList;
import java.lang.String;
import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity {
    // declaring the operand (numbers) buttons
    Button buttonNumber1;
    Button buttonNumber2;
    Button buttonNumber3;
    Button buttonNumber4;
    Button buttonNumber5;
    Button buttonNumber6;
    Button buttonNumber7;
    Button buttonNumber8;
    Button buttonNumber9;
    Button buttonNumber0;

    // declaring the operator and other buttons
    Button buttonLeftParenthesis;
    Button buttonRightParenthesis;
    Button buttonSubtraction;
    Button buttonAddition;
    Button buttonDivision;
    Button buttonMultiplication;
    Button buttonDel;
    Button buttonDot;
    Button buttonEquals;

    // tvInput is the TextView where the user types the math expression they want to solve
    TextView tvInput;

    // tvResult is the TextView where the answer of the math expression is displayed
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // associate buttons with xml id values
        buttonNumber1 = findViewById(R.id.buttonNumber1);
        buttonNumber2 = findViewById(R.id.buttonNumber2);
        buttonNumber3 = findViewById(R.id.buttonNumber3);
        buttonNumber4 = findViewById(R.id.buttonNumber4);
        buttonNumber5 = findViewById(R.id.buttonNumber5);
        buttonNumber6 = findViewById(R.id.buttonNumber6);
        buttonNumber7 = findViewById(R.id.buttonNumber7);
        buttonNumber8 = findViewById(R.id.buttonNumber8);
        buttonNumber9 = findViewById(R.id.buttonNumber9);
        buttonNumber0 = findViewById(R.id.buttonNumber0);

        buttonLeftParenthesis = findViewById(R.id.buttonLeftParenthesis);
        buttonRightParenthesis = findViewById(R.id.buttonRightParenthesis);
        buttonSubtraction = findViewById(R.id.buttonSubtraction);
        buttonAddition = findViewById(R.id.buttonAddition);
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonMultiplication = findViewById(R.id.buttonMultiplication);
        buttonDel = findViewById(R.id.buttonDel);
        buttonDot = findViewById(R.id.buttonDot);
        buttonEquals = findViewById(R.id.buttonEquals);

        tvInput = findViewById(R.id.textViewInput);
        tvResult = findViewById(R.id.textViewResult);

        // onclick listeners for all buttons
        buttonNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText()+"1");
            }
        });

        buttonNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText()+"2");
            }
        });

        buttonNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "3");
            }
        });

        buttonNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "4");
            }
        });

        buttonNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "5");
            }
        });

        buttonNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "6");
            }
        });

        buttonNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "7");
            }
        });

        buttonNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "8");
            }
        });

        buttonNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "9");
            }
        });

        buttonNumber0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "0");
            }
        });

        buttonLeftParenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "(");
            }
        });

        buttonRightParenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + ")");
            }
        });

        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText()+"-");
            }
        });

        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "+");
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "÷");
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + "*");
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deleteOne = tvInput.getText().toString();
                deleteOne = deleteOne.substring(0, deleteOne.length() - 1);
                tvInput.setText(deleteOne);
            }
        });

        buttonDel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvInput.setText("");
                return true;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText(tvInput.getText() + ".");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String replaceDivision = tvInput.getText().toString();
               String replacedString = replaceDivision.replace('÷', '/');
               String result = eval(replacedString);
               tvResult.setText(String.valueOf(result));
           }
        });
    }

    // function to check if char is an operator
    public static boolean isOperatorChar(char operator) {
        if (operator == '-' || operator == '+' || operator == '/' || operator == '*') {
            return true;
        } else {
            return false;
        }
    }

    // function to check if string is an operator
    public static boolean isOperatorString(String operator) {
        if (operator.equals("-") || operator.equals("+") || operator.equals("/") ||
                operator.equals("*")) {
            return true;
        } else {
            return false;
        }
    }

    // function to verify if char contains single digit - returns a boolean
    public static boolean isDigitChar(char digit) {
        if (digit == '0' || digit == '1' || digit == '2' || digit == '3' || digit == '4' ||
                digit == '5' || digit == '6' || digit == '7' || digit == '8' || digit == '9') {
            return true;
        } else {
            return false;
        }
    }

    // function to verify if string contains single digits - returns a boolean
    public static boolean isDigitString(String digit) {
        if (digit.equals("0") || digit.equals("1") || digit.equals("2") || digit.equals("3") ||
                digit.equals("4") || digit.equals("5") || digit.equals("6") || digit.equals("7") ||
                digit.equals("8") || digit.equals("9")) {
            return true;
        } else {
            return false;
        }
    }

    // function to verify if string is a double value ex: digits.digits by using a regex - returns a
    // boolean
    public static boolean isNumeric(String formula) {
        return formula.matches("-?\\d+(\\.\\d+)?");
    }

    // function for getting order of operation on the operators - returns an int
    public static int getPriority(String operator) {
        if (operator.equals("-") || operator.equals("+")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else {
            return -1;
        }
    }

    // function that parses the string and accounts for decimal values
    // returns a stack of type String will all values
    public static Stack<String> convertStringToStack(final String formula) {
        String temp = "";
        int counterForI = 0;

        Stack<String> formulaStack = new Stack<>();

        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                formulaStack.push(Character.toString(formula.charAt(i)));
            } else if (formula.charAt(i) == ')') {
                formulaStack.push(Character.toString(formula.charAt(i)));
            } else if (isOperatorChar(formula.charAt(i))) {
                formulaStack.push(Character.toString(formula.charAt(i)));
            } else if (isDigitChar(formula.charAt(i)) || formula.charAt(i) == '.') {
                for (int j = i; j < formula.length(); j++) {
                    if (isDigitChar(formula.charAt(j)) || formula.charAt(j) == '.') {
                        temp += Character.toString(formula.charAt(j));
                        // System.out.println("temp " + temp);
                        counterForI += 1;
                    } else if (isOperatorChar(formula.charAt(j)) || formula.charAt(i) == ')' ||
                            formula.charAt(i) == '(') {
                        // counterForI = 0;
                        break;
                    }
                }
                formulaStack.push(temp);
                temp = "";
                i += counterForI - 1;
                counterForI = 0;
            }
        }
        return formulaStack;
    }

    // function that takes the operandStack and operatorStack and performs the correct calculations
    // before popping, we check if the stacks are empty
    // return undefined for division over 0
    // calculations are done as doubl but return type is String to accomodate undefined
    public static String doCalculation(Stack<Double> operandStack, Stack<String> operatorStack) {
        Double operand1 = 0.0;
        Double operand2 = 0.0;
        String operation = "";
        Double result = 0.0;

        try {
            operand1 = Double.valueOf(operandStack.pop());
        } catch (EmptyStackException e) {

        }
        try {
            operand2 = Double.valueOf(operandStack.pop());
        } catch (EmptyStackException e) {

        }
        try {
            operation = operatorStack.pop();
        } catch (EmptyStackException e) {

        }

        if (operation.equals("+")) {
            return String.valueOf(operand1 + operand2);
        } else if (operation.equals("-")) {
            return String.valueOf(operand2 - operand1);
        } else if (operation.equals("*")) {
            return String.valueOf(operand1 * operand2);
        } else if (operation.equals("/")) {
            if (operand1 == 0) {
                System.out.println("Undefined");
                return "Undefined";
            }
            return String.valueOf(operand2 / operand1);
        } else {
            return String.valueOf(0.0);
        }
    }

    // function to verify if the expression is valid
    public static String checkValidExpression(final String formula, Object [] fromulaStringList) {
        String tempFomula = formula;
        int parenthesisTestLeft = tempFomula.length() - tempFomula.replace("(", "").length();
        int parenthesisTestRight = tempFomula.length() - tempFomula.replace(")", "").length();
        int numOfOperators = 0;

        if (parenthesisTestLeft != parenthesisTestRight && parenthesisTestLeft != 0 &&
                parenthesisTestRight != 0) {
            return "Invalid number of parenthesis";
        } else if (isOperatorChar(formula.charAt(0)) ||
                isOperatorChar(formula.charAt(formula.length()-1))) {
            return "Invalid leading or trailing operator";
        } else {
            for (int i = 0; i < fromulaStringList.length - 2; i++) {
                String tempString = fromulaStringList[i].toString();
                String tempStringNext = fromulaStringList[i + 1].toString();
                if (isOperatorString(tempString) || isOperatorString(tempStringNext)) {
                    numOfOperators += 1;
                }
                if ((isOperatorString(tempString) && isOperatorString(tempStringNext))){
                    return "Invalid 1";
                }
                if (isNumeric(tempString) && tempStringNext.equals("(")) {
                    return "Invalid 2";
                }
                if (tempString.equals(")") && isNumeric(tempStringNext)) {
                    return "Invalid 3";
                }
            }
        }
        if (numOfOperators == 0) {
            return "Invalid expression";
        }
        return "good";
    }

    // function that get calls when the user hits the = button
    // evaluate the expression in inifx form using two stacks
    // try catch block are for EmptyStackException error
    public static String eval(final String formula) {
        Log.d("txInput", formula);
        Stack<String> formulaStack = convertStringToStack(formula);
        Log.d("Line break", "-----");
        System.out.println(Arrays.asList(formulaStack.toArray()));
        Object[] fromulaStringList = formulaStack.toArray();

        Stack<Double> operandStack = new Stack<>(); // numbers
        Stack<String> operatorStack = new Stack<>(); // operations

        double operand1 = 0.0;
        double operand2 = 0.0;
        double result = 0.0;
        double temp = 0.0;
        String operation = "";

        String validity = checkValidExpression(formula, fromulaStringList);
        if (!validity.equals("good")) {
            return validity;
        }

        System.out.println("-----");
        for (int i = 0; i < fromulaStringList.length; i++) {
            System.out.println(fromulaStringList[i]);
        }
        System.out.println("-----");

        for (int i = 0; i < fromulaStringList.length; i++) {
            String tempString = fromulaStringList[i].toString();

            if (isNumeric(tempString) || isDigitString(tempString)) { // operand
                temp = Double.parseDouble(fromulaStringList[i].toString());
                operandStack.push(temp);
                // System.out.println("case 1 " + tempString);
            } else if (tempString.equals("(")) {
                operatorStack.push(tempString);
                // System.out.println("case 2 " + tempString);
            } else if (tempString.equals(")")) {
                // System.out.println("case 3 " + tempString);
                try {
                    while (!(operatorStack.peek().equals("("))) { // double check
                        System.out.println("HERE");
                        String output = doCalculation(operandStack, operatorStack);
                        if (output.equals("Undefined")) {
                            return output;
                        } else {
                            operandStack.push(Double.parseDouble(output));
                        }
                    }
                } catch (EmptyStackException e) {

                }
                try {
                    operatorStack.pop();
                } catch (EmptyStackException e) {

                }
            } else if (isOperatorString(tempString)) {
                // System.out.println("case 4 " + tempString);
                try {
                    while (!operatorStack.isEmpty() &&
                            (getPriority(tempString) <= getPriority(operatorStack.peek()))) {
                        String output = doCalculation(operandStack, operatorStack);
                        if (output.equals("Undefined")) {
                            return output;
                        } else {
                            operandStack.push(Double.parseDouble(output));
                        }
                    }
                } catch (EmptyStackException e) {

                }
                try {
                    operatorStack.push(tempString);
                } catch (EmptyStackException e) {

                }
            }
        }

        while (!operatorStack.isEmpty()) {
            String output = doCalculation(operandStack, operatorStack);
            if (output.equals("Undefined")) {
                return output;
            } else {
                operandStack.push(Double.parseDouble(output));
            }
        }

        result = operandStack.pop();
        System.out.println("RESULT " + result);
        return String.valueOf(result);
    }
}