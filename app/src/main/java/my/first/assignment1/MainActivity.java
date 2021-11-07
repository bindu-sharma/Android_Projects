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
    Button clear;

    TextView inputField;
    TextView calcHistory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Creating connection between buttons and main.Activity

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
        clear = (Button) (findViewById(R.id.clear_button));

        inputField = (TextView) (findViewById(R.id.InputScreen));
        calcHistory = (TextView) (findViewById(R.id.historyView));

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/* When user clicks on Advanced history button following things happen:
    -Calculator mode changes to 1 i.e advanced mode
    -button text changes to standard-no history
    -history textview becomes visible and displays history
 */
                if(calculatorMode==0){
                    calculatorMode=1;
                    calcHistory.setVisibility(View.VISIBLE);
                    history.setText("STANDARD - NO HISTORY");
                    calcHistory.setText("");// initially, textview should be empty
                }
  /* When user clicks on standard history button following things happen:
    -Calculator mode changes to 0 i.e standard mode
    -button text changes to Advanced-history
    -history textview becomes invisible and text is set to ""
 */

                else {
                    calculatorMode=0;
                    calcHistory.setVisibility(View.INVISIBLE);
                    history.setText("ADVANCED - WITH HISTORY");
                    obj.storedCalcHistory.clear();
                    obj.historyArrayIndex=0;
                    obj.joined="";
                    obj.historyJoinedString="";
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                inputField.setText("0");
                obj.inputString.clear();
                obj.index=0;
                obj.joined = "";
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
            int result = obj.calculate();
           String resultString = String.valueOf(result);
           inputField.setText(obj.joined+"="+obj.finalOutput);

           /* In adnvanced mode, equals button, when pressed should display calculation history
                in the history textview*/
           if(calculatorMode==1){
               obj.storeHistory();
               calcHistory.setText(obj.storedCalcHistory.toString()
                       .replace("[","")
                       .replace("]","")
                       .replace(",",""));
           }
        }
        else{
            // Getting text of the button pressed
            String data = ((Button) v).getText().toString();
            obj.push(data);
            inputField.setText(obj.joined);

        }

    }


}