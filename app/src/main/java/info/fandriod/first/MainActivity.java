package info.fandriod.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   // @Override
   // protected void onCreate(Bundle savedInstanceState) {
   //     super.onCreate(savedInstanceState);
   //     setContentView(R.layout.activity_main);

    TextView LCD;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnS, btnAdd, btnDiv, btnMul, btn0, btnEq, btnClnr, btnDot, btnC;

    int oper1, oper2, flagAction;

    double result;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим элементы
       // etNum1 = (EditText) findViewById(R.id.etNum1);
       // etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnS = (Button) findViewById(R.id.btnS);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btn9 = (Button) findViewById(R.id.btn9);
        btn8 = (Button) findViewById(R.id.btn8);
        btn7 = (Button) findViewById(R.id.btn7);
        btn6 = (Button) findViewById(R.id.btn6);
        btn5 = (Button) findViewById(R.id.btn5);
        btn4 = (Button) findViewById(R.id.btn4);
        btn3 = (Button) findViewById(R.id.btn3);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn0 = (Button) findViewById(R.id.btn0);
        btnClnr = (Button) findViewById(R.id.btnClnr);
        btnEq = (Button) findViewById(R.id.btnEq);
        LCD = (TextView) findViewById(R.id.LCD);

        // прописываем обработчик
        btnAdd.setOnClickListener(this);
        btnS.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEq.setOnClickListener(this);
        btnClnr.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        oper1 = 0;

        oper2 = 0;

        result = 0;

        flagAction = 0;
        LCD.setText(Integer.toString(oper1));
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btn1:
                ClickNum(1);
                break;
            case R.id.btn2:
                ClickNum(2);
                break;
            case R.id.btn3:
                ClickNum(3);
                break;
            case R.id.btn4:
                ClickNum(4);
                break;
            case R.id.btn5:
                ClickNum(5);
                break;
            case R.id.btn6:
                ClickNum(6);
                break;
            case R.id.btn7:
                ClickNum(7);
                break;
            case R.id.btn8:
                ClickNum(8);
                break;
            case R.id.btn9:
                ClickNum(9);
                break;
            case R.id.btn0:
                ClickNum(0);
                break;
            case R.id.btnAdd:
                if(flagAction == 0) flagAction = 1;
                break;
            case R.id.btnS:
                if(flagAction == 0) flagAction = 2;
                break;
            case R.id.btnMul:
                if(flagAction == 0) flagAction = 3;
                break;
            case R.id.btnDiv:
                if(flagAction == 0) flagAction = 4;
                break;
            case R.id.btnEq:
                switch(flagAction){
                    case 1:
                        result = oper1 + oper2;
                        break;
                    case 2:
                        result = oper1 - oper2;
                        break;
                    case 3:
                        result = oper1 * oper2;
                        break;
                    case 4:
                        result =(double) oper1 / (double) oper2;
                        break;
                    default:
                        Toast.makeText(this, "Операция не задана", Toast.LENGTH_LONG);

                }
                if(flagAction != 0){
                   LCD.setText(Double.toString(result));
                    oper1 = 0;
                    oper2 = 0;
                    result = 0;
                    flagAction = 0;
                }

                break;

            case R.id.btnClnr:
                oper1 = 0;
                oper2 = 0;
                result = 0;
                flagAction = 0;
               LCD.setText(Integer.toString(oper1));
                break;

        }



    }
     private void ClickNum(int num) {
         if (flagAction == 0)
         {
             oper1 = oper1 * 10 + num;
             LCD.setText(Integer.toString(oper1));
         }
         else
         {
             oper2 = oper2 * 10 + num;
             LCD.setText(Integer.toString(oper2));
         }
     }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
