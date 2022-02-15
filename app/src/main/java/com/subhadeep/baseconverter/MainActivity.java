package com.subhadeep.baseconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button ConvertBTN;
    private TextView BinVAL;
    private TextView DecVAL;
    private TextView OctVAL;
    private TextView HexaVAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spin1);
        BinVAL = findViewById(R.id.BinVAL);
        DecVAL = findViewById(R.id.DecVAL);
        OctVAL = findViewById(R.id.OctVAL);
        HexaVAL = findViewById(R.id.HexaVAL);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.base, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        EditText display = findViewById(R.id.display);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display1).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
        String a="HI";
        Button but= (Button) findViewById(R.id.ConvertBTN);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                String text=spinner.getSelectedItem().toString();
                if(text.equals("Binary") )
                    Bina(display.getText().toString());
                else if(text.equals("Decimal") )
                    Deci(display.getText().toString());
                else if(text.equals("Octal") )
                    Octa(display.getText().toString());
                else if(text.equals("Hexadecimal") )
                    Hexa(display.getText().toString());
            }
        });
    }

    public void Bina(String num){
        int a=0;
        for(int i=0;i<num.length();i++)
        {
            if((char)num.charAt(i)!=48 && (char)num.charAt(i)!=49)
                a=1;
        }
        if(a==1) {
            Toast.makeText(getApplicationContext(),"Enter a Binary number", Toast.LENGTH_SHORT).show();
            EditText display = findViewById(R.id.display);
            display.setText("");
        }
        else {
            BinVAL.setText(num);
            int decii = Integer.parseInt(num,2);
            String deci = String.valueOf(decii);
            DecVAL.setText(deci);
            String oct = Integer.toOctalString(decii);
            OctVAL.setText(oct);
            String hexa = Integer.toHexString(decii);
            hexa=hexa.toUpperCase();
            HexaVAL.setText(hexa);
        }
    }

    public void Deci(String num){
        int a=0;
        for(int i=0;i<num.length();i++)
        {
            if((char)num.charAt(i)<48 || (char)num.charAt(i)>57)
                a=1;
        }
        if(a==1) {
            Toast.makeText(getApplicationContext(),"Enter a Decimal number", Toast.LENGTH_SHORT).show();
            EditText display = findViewById(R.id.display);
            display.setText("");
        }
        else {
            int decii=Integer.parseInt(num);
            DecVAL.setText(num);
            String oct = Integer.toOctalString(decii);
            OctVAL.setText(oct);
            String hexa = Integer.toHexString(decii);
            hexa=hexa.toUpperCase();
            HexaVAL.setText(hexa);
            String bin = Integer.toBinaryString(decii);
            BinVAL.setText(bin);
        }
    }

    public void Octa(String num){
        int a=0;
        for(int i=0;i<num.length();i++)
        {
            if((char)num.charAt(i)<48 || (char)num.charAt(i)>55)
                a=1;
        }
        if(a==1) {
            Toast.makeText(getApplicationContext(),"Enter a Octal number", Toast.LENGTH_SHORT).show();
            EditText display = findViewById(R.id.display);
            display.setText("");
        }
        else {
            OctVAL.setText(num);
            int decii=Integer.parseInt(num,8);
            String deci = String.valueOf(decii);
            DecVAL.setText(deci);
            String hexa = Integer.toHexString(decii);
            hexa=hexa.toUpperCase();
            HexaVAL.setText(hexa);
            String bin = Integer.toBinaryString(decii);
            BinVAL.setText(bin);
        }
    }

    public void Hexa(String num){
        num=num.toUpperCase();
        int a=0;
        for(int i=0;i<num.length();i++)
        {
            if((char)num.charAt(i)<48 || (char)num.charAt(i)>70)
                a=1;
        }
        if(a==1) {
            Toast.makeText(getApplicationContext(),"Enter a Hexadecimal number", Toast.LENGTH_SHORT).show();
            EditText display = findViewById(R.id.display);
            display.setText("");
        }
        else {
            HexaVAL.setText(num);
            int decii=Integer.parseInt(num,16);
            String deci = String.valueOf(decii);
            DecVAL.setText(deci);
            String oct = Integer.toOctalString(decii);
            OctVAL.setText(oct);
            String bin = Integer.toBinaryString(decii);
            BinVAL.setText(bin);
        }
    }
}