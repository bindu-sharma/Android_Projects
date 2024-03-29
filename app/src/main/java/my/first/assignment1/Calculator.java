package my.first.assignment1;

import android.widget.Switch;

import java.util.ArrayList;

public class Calculator {
    ArrayList<String> inputString = new ArrayList<String>();
    ArrayList<String> storedCalcHistory = new ArrayList<>();
    int index = 0;
    int result = 0;
    int finalOutput = 0;
    int historyArrayIndex = 0;
    String joined;
    String historyJoinedString;

    public void push(String input) {
        inputString.add(index, input);
        index++;
        joined = String.join("", inputString);
    }

    public int calc(int operand1, int operand2, String operator) {

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;

        }
        return result;
    }
// Function to calculate the result of the expression

    public int calculate() {
        for (int i = 0; i < inputString.size(); i++) {
            if ((inputString.get(i).equals("+")) ||
                    (inputString.get(i).equals("-")) ||
                    (inputString.get(i).equals("*")) ||
                    (inputString.get(i).equals("/")))
            {
                String op = inputString.get(i);
                int num1;

                /*for the first iteration num1 will be the first number in the expression entered,
                for the rest of the iterations, num1 will be the result of previous calculation*/

                if(i==1) {
                    num1 = Integer.parseInt(inputString.get(i - 1));
                }
                else { num1=finalOutput;}
                int num2 = Integer.parseInt(inputString.get(i + 1));
                 finalOutput = calc(num1,num2,op);
            }
        }

        return finalOutput;
    }
// Function to store calculation history, it will be called when calculator is in advanced mode
    public void storeHistory(){

       historyJoinedString = joined+"="+finalOutput;// String to display in history textview
       storedCalcHistory.add(historyArrayIndex,historyJoinedString+"\n");
        historyArrayIndex++;

    }

}
