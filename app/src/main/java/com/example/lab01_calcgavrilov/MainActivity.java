package com.example.lab01_calcgavrilov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ta;
    TextView tb;
    TextView tc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ta = findViewById(R.id.textA);
        tb = findViewById(R.id.textB);
        tc = findViewById(R.id.textView_result);
    }

    public void onOperation_click(View vi)
    {
        String sa = ta.getText().toString();
        String sb = tb.getText().toString();

        double a = 0;
        double b = 0;

        if(sa.length() == 0 || sb.length() == 0)
        {
            tc.setText("text field A or B is empty");
        }

        try {
            a = Double.parseDouble(sa);
            b = Double.parseDouble(sb);
        }
        catch (Exception ex)
        {
            tc.setText("text field A or B is not a valid number");
            return;
        }

        switch ((String)vi.getTag())
        {
            case "0": tc.setText(String.valueOf(a + b)); break;
            case "1": tc.setText(String.valueOf(a - b)); break;
            case "2": tc.setText(String.valueOf(a * b)); break;
            case "3":
                if(b == 0)
                {
                    tc.setText("text field B is not a valid number");
                    return;
                }
                tc.setText(String.valueOf(a / b)); break;
            case "8": tc.setText(String.valueOf(Math.pow(a, b))); break;
        }
    }

    public void onSingleOperation_click(View vi)
    {
        String sa = ta.getText().toString();
        double a = 0;

        if(sa.length() == 0)
        {
            tc.setText("text field A or B is empty");
        }

        try {
            a = Double.parseDouble(sa);
        }
        catch (Exception ex)
        {
            tc.setText("text field A is not a valid number");
            return;
        }

        a *= Math.PI / 180;
        switch ((String)vi.getTag())
        {
            case "4":
                tc.setText(String.valueOf(Math.sin(a)));
            break;
            case "5":
                tc.setText(String.valueOf(Math.cos(a)));
                break;
            case "6":
                tc.setText(String.valueOf(Math.tan(a)));
                break;
            case "7":
                a = Double.parseDouble(sa);
                tc.setText(String.valueOf(Math.sqrt(a)));
                break;
        }
    }
}