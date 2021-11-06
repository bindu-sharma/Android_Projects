package my.first.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Calculator obj = new Calculator();
    int calculatorMode = 0;

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button history;
    Button equals;

    TextView inputField;
    TextView calcHistory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Creating conection between buttons and main.Activity

        one = (Button) (findViewById(R.id.one_button));
        two = (Button) (findViewById(R.id.two_button));
        three = (Button) (findViewById(R.id.three_button));
        four = (Button) (findViewById(R.id.four_button));
        five = (Button) (findViewById(R.id.five_button));
        six = (Button) (findViewById(R.id.six_button));
        seven = (Button) (findViewById(R.id.seven_button));
        eight = (Button) (findViewById(R.id.eight_button));
        nine = (Button) (findViewById(R.id.nine_button));
        zero = (Button) (findViewById(R.id.zero_button));

        plus = (Button) (findViewById(R.id.plus_button));
        minus = (Button) (findViewById(R.id.minus_button));
        multiply = (Button) (findViewById(R.id.times_button));
        divide = (Button) (findViewById(R.id.divide_button));

        history = (Button) (findViewById(R.id.getHistory));
        equals = (Button) (findViewById(R.id.equals_button));

        inputField = (TextView) (findViewById(R.id.InputScreen));
        calcHistory = (TextView) (findViewById(R.id.historyView));

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(calculatorMode==0){
                    calculatorMode=1;
                    calcHistory.setVisibility(View.VISIBLE);
                    history.setText("STANDARD - NO HISTORY");
                }
                else {
                    calculatorMode=0;
                    calcHistory.setVisibility(View.INVISIBLE);
                    history.setText("ADVANCED - WITH HISTORY");
                }
            }
        });

// Setting on click listener for multiple buttons
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equals.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==equals){
            System.out.println("**************");
            int result = obj.calculate();
            //System.out.println("Equals pressed");
           String resultString = String.valueOf(result);
           System.out.println(resultString);
           inputField.setText(resultString);
        }
        else{
            /*switch (v.getId()){
                case R.id.one_button:
                    obj.push("1");
                    inputField.setText(obj.joined);
                    break;
                case R.id.two_button:
                    obj.push("2");
                    inputField.setText(obj.joined);
                    break;
                case R.id.three_button:
                    obj.push("3");
                    inputField.setText(obj.joined);
                    break;
                case R.id.plus_button:
                    obj.push("+");
                    inputField.setText(obj.joined);
                    break;
                case R.id.four_button:
                    obj.push("4");
                    inputField.setText(obj.joined);
                    break;
                case R.id.five_button:
                    obj.push("5");
                    inputField.setText(obj.joined);
                    break;
                case R.id.six_button:
                    obj.push("6");
                    inputField.setText(obj.joined);
                    break;
                case R.id.minus_button:
                    obj.push("-");
                    inputField.setText(obj.joined);
                    break;
                case R.id.seven_button:
                    obj.push("7");
                    inputField.setText(obj.joined);
                    break;
                case R.id.eight_button:
                    obj.push("8");
                    inputField.setText(obj.joined);
                    break;
                case R.id.nine_button:
                    obj.push("9");
                    inputField.setText(obj.joined);
                    break;
                case R.id.times_button:
                    obj.push("*");
                    inputField.setText(obj.joined);
                    break;
                case R.id.zero_button:
                    obj.push("0");
                    inputField.setText(obj.joined);
                    break;
                case R.id.divide_button:
                    obj.push("/");
                    inputField.setText(obj.joined);
                    break;

            }*/
            // Getting text of the button pressed
            String data = ((Button) v).getText().toString();
            obj.push(data);
            inputField.setText(obj.joined);

        }

    }


}