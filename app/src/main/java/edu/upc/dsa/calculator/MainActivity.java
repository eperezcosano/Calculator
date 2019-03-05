package edu.upc.dsa.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int num1 = 0;
    int num2 = 0;
    int op = 0; //1:Add, 2:Subtract, 3:Multiply, 4:Divide

    private View.OnClickListener listenerNum = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String value = ((Button) v).getText().toString();
            TextView res = findViewById(R.id.textView);
            if (op == 0) {
                num1 = Integer.parseInt(Integer.toString(num1).concat(value));
                res.setText(Integer.toString(num1));
            } else {
                num2 = Integer.parseInt(Integer.toString(num2).concat(value));
                res.setText(Integer.toString(num2));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMult = findViewById(R.id.btnMult);
        Button btnDiv = findViewById(R.id.btnDiv);


        btn0.setOnClickListener(listenerNum);
        btn1.setOnClickListener(listenerNum);
        btn2.setOnClickListener(listenerNum);
        btn3.setOnClickListener(listenerNum);
        btn4.setOnClickListener(listenerNum);
        btn5.setOnClickListener(listenerNum);
        btn6.setOnClickListener(listenerNum);
        btn7.setOnClickListener(listenerNum);
        btn8.setOnClickListener(listenerNum);
        btn9.setOnClickListener(listenerNum);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op = 1;
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op = 2;
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op = 3;
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op = 4;
            }
        });

    }



}
