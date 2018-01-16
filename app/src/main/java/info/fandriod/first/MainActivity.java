package info.fandriod.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   // @Override
   // protected void onCreate(Bundle savedInstanceState) {
   //     super.onCreate(savedInstanceState);
   //     setContentView(R.layout.activity_main);

    TextView LCD;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnS, btnAdd, btnDiv, btnMul, btn0, btnEq, btnClnr ;




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

    }

    @Override
    public void onClick(View v) {

        LCD.setText("кнопка " + v.getId());



    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
