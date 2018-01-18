package info.fandriod.first;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText LCD;
    TextView  resultField, operationField;

   // Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
   // Button btnS, btnAdd, btnDiv, btnMul, btn0, btnEq, btnClnr, btnDot, btnC;
   // int oper1, oper2, flagAction;

    Double operand = null;
    String lastOperation = "=";


    //double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LCD = (EditText) findViewById(R.id.LCD);
        resultField =(TextView) findViewById(R.id.resultField);
        operationField = (TextView)  findViewById(R.id.operationField) ;


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("OPERATION", lastOperation);
        if(operand!=null)
            outState.putDouble("OPERAND", operand);
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getString("OPERATION");
        operand= savedInstanceState.getDouble("OPERAND");
        resultField.setText(operand.toString());
        operationField.setText(lastOperation);
    }


    public void onNumClick(View v) {

        Button button = (Button)v;
        LCD.append(button.getText());

        if(lastOperation.equals("=") && operand!=null){
            operand = null;
        }

    }


     public void onOperClick(View v) {
         Button button = (Button)v;
         String op = button.getText().toString();
         String number = LCD.getText().toString();

         if(op =="C"){
             operationField.setText("");
             resultField.setText("");
             LCD.setText("");

         }
         else {
             if (number.length() > 0) {
                 // number = number.replace(',', '.');
                 try {
                     performOperation(Double.valueOf(number), op);
                 } catch (NumberFormatException ex) {
                     LCD.setText("");
                 }
             }
             lastOperation = op;
             operationField.setText(lastOperation);
             LCD.setText("");
         }


     }


    private void performOperation(Double number, String operation){


        if(operand ==null){
            operand = number;
        }
        else{
            if(lastOperation.equals("=")){
                lastOperation = operation;
            }
            switch(lastOperation){
                case "=":
                    operand =number;
                    break;
                case "/":
                    if(number==0){
                        operand =0.0;
                    }
                    else{
                        operand /=number;
                    }
                    break;
                case "*":
                    operand *=number;
                    break;
                case "+":
                    operand +=number;
                    break;
                case "-":
                    operand -=number;
                    break;

            default:
                Toast.makeText(this, "операція не задана", Toast.LENGTH_LONG);
        }
        }
        resultField.setText(operand.toString());
        LCD.setText("");

    }

}
