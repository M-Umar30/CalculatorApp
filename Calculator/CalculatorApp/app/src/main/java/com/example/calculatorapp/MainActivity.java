package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView expression, result;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_Add, button_Sub, button_Mul, button_Div, button_Equal, button_Clear, button_Dot, button_ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.answerText);
        expression = findViewById(R.id.expressionText);

        // assign ids to all buttons
        assignButtonId(button_0, R.id.zero_button);
        assignButtonId(button_1, R.id.one_button);
        assignButtonId(button_2, R.id.two_button);
        assignButtonId(button_3, R.id.three_button);
        assignButtonId(button_4, R.id.four_button);
        assignButtonId(button_5, R.id.five_button);
        assignButtonId(button_6, R.id.six_button);
        assignButtonId(button_7, R.id.seven_button);
        assignButtonId(button_8, R.id.eight_button);
        assignButtonId(button_9, R.id.nine_button);
        assignButtonId(button_Add, R.id.plus_button);
        assignButtonId(button_Sub, R.id.minus_button);
        assignButtonId(button_Mul, R.id.multiplication_button);
        assignButtonId(button_Div, R.id.division_button);
        assignButtonId(button_Equal, R.id.equal_button);
        assignButtonId(button_Clear, R.id.C_Button);
        assignButtonId(button_Dot, R.id.dotButton);
        assignButtonId(button_ac, R.id.ACButton);
    }

    void assignButtonId(Button button, int id) {
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    String evaluateExpression(String expression) {
        Context myContext = Context.enter();
        myContext.setOptimizationLevel(-1);
        String result = "";
        try {
            Scriptable scope = myContext.initStandardObjects();
            result = myContext.evaluateString(scope, expression, "JavaScript", 1, null).toString();
        } catch (Exception e) {
            result = "0";
        }
        return result;
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        String button_text = btn.getText().toString();
        String currentExpression = expression.getText().toString();
        String newExpression = "";
        if(button_text.equals("AC")){
            newExpression = "";
        }
        else if(button_text.equals("C")){
            newExpression = currentExpression.substring(0, currentExpression.length() - 1);
        }
        else if(button_text.equals("=")){
            String expression_result = evaluateExpression(currentExpression);
            result.setText(expression_result);
            newExpression = currentExpression;
        }
        else{
            newExpression = currentExpression + button_text;
        }

        expression.setText(newExpression);
    }
}