package edu.upc.dsa.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double num1 = 0;
    double num2 = 0;
    boolean dot1 = false;
    boolean dot2 = false;
    String zeros = "";
    int op = 0; //1:Add, 2:Subtract, 3:Multiply, 4:Divide
    double res;

    public static String fmt(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }

    private View.OnClickListener listenerNum = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String value = ((Button) v).getText().toString();
            TextView disp = findViewById(R.id.textView);

            if (op == 0 && res != 0) {
                num1 = 0;
                res = 0;
            } else if (op != 0 && res != 0) {
                num1 = res;
                res = 0;
            }


            if (op == 0) {
                if (Integer.parseInt(value) == 0) {
                    if (num1 % 1 == 0 && !dot1) {
                        num1 = Double.parseDouble(fmt(num1).concat(value));
                    } else {
                        zeros = zeros.concat("0");
                    }
                } else {
                    if (dot1) {
                        num1 = Double.parseDouble(fmt(num1).concat(".").concat(zeros).concat(value));
                        dot1 = false;
                    } else {
                        num1 = Double.parseDouble(fmt(num1).concat(zeros).concat(value));
                    }
                    zeros = "";
                }
                if (dot1) {
                    disp.setText(fmt(num1).concat(".").concat(zeros));
                } else {
                    disp.setText(fmt(num1).concat(zeros));
                }


            } else {
                if (Integer.parseInt(value) == 0) {
                    if (num2 % 1 == 0 && !dot2) {
                        num2 = Double.parseDouble(fmt(num2).concat(value));
                    } else {
                        zeros = zeros.concat("0");
                    }
                } else {
                    if (dot2) {
                        num2 = Double.parseDouble(fmt(num2).concat(".").concat(zeros).concat(value));
                        dot2 = false;
                    } else {
                        num2 = Double.parseDouble(fmt(num2).concat(zeros).concat(value));
                    }
                    zeros = "";
                }
                if (dot2) {
                    disp.setText(fmt(num2).concat(".").concat(zeros));
                } else {
                    disp.setText(fmt(num2).concat(zeros));
                }
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
        final Button btnEqual = findViewById(R.id.btnEqual);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnDot = findViewById(R.id.btnDot);
        final TextView display = findViewById(R.id.textView);
        final TextView calculation = findViewById(R.id.textView2);


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
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op == 0 && num1 % 1 == 0) {
                    dot1 = true;
                    display.setText(fmt(num1).concat("."));
                } else if (op != 0 && num2 % 1 == 0) {
                    dot2 = true;
                    display.setText(fmt(num2).concat("."));
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = 0;
                num2 = 0;
                dot1 = false;
                dot2 = false;
                res = 0;
                op = 0;
                zeros = "";
                display.setText("0");
                calculation.setText("");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op != 0 && num1 != 0 && num2 != 0) {
                    btnEqual.performClick();
                }
                calculation.setText("+");
                op = 1;
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op != 0 && num1 != 0 && num2 != 0) {
                    btnEqual.performClick();
                }
                calculation.setText("-");
                op = 2;
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op != 0 && num1 != 0 && num2 != 0) {
                    btnEqual.performClick();
                }
                calculation.setText("*");
                op = 3;
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op != 0 && num1 != 0 && num2 != 0) {
                    btnEqual.performClick();
                }
                calculation.setText("/");
                op = 4;
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sign = "";
                switch (op) {
                    case 1:
                        res = num1 + num2;
                        sign = " + ";
                        break;
                    case 2:
                        res = num1 - num2;
                        sign = " - ";
                        break;
                    case 3:
                        res = num1 * num2;
                        sign = " * ";
                        break;
                    case 4:
                        res = num1 / num2;
                        sign = " / ";
                        break;
                    default:

                        break;
                }

                display.setText(fmt(res));
                calculation.setText(fmt(num1)
                        .concat(sign)
                        .concat(fmt(num2))
                        .concat(" =")
                );

                op = 0;
                num1 = 0;
                num2 = 0;
            }
        });

    }



}
