package com.example.firstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_btn_hello_text_change(View view) {
        TextView textView = (TextView) findViewById(R.id.txt_hello);
        textView.setText("It's beginnig!");
        check_editText();//공백 확인.

    }

    private void check_editText(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        EditText[] edittText = new EditText[9];
        int etID;
        TextView[] ttView = new TextView[9];
        int tvID;

        for(int i=0; i < edittText.length; i++ ){
            etID = getResources().getIdentifier("editTxt_"+i, "id", getPackageName());
            edittText[i] = (EditText)findViewById(etID);

            tvID = getResources().getIdentifier("txt_"+i, "id", getPackageName());
            ttView[i] = (TextView)findViewById(tvID);

            if(edittText[i].length() == 0){
                builder.setTitle("확인하세요.").setMessage(ttView[i].getText() + "(이)가 공백입니다.");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
            }
        }

    }
}