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
        check_editText();
    }

    private void check_editText(){

//        ViewGroup viewGroup = (ViewGroup)findViewById(R.id.rootView);
//        viewGroup.getChildCount();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        EditText edittText;

        for(int i=0; i < 9; i++ ){
            edittText = (EditText)findViewById(R.id.editTxt_ + i);
            if(edittText.getText().toString() == ""){
//                builder.setTitle("확인하세요.").setMessage(viewGroup.getChildCount());
                builder.setTitle("확인하세요.").setMessage(edittText.getId() + "가 공백입니다.");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
            }
        }

//        builder.setTitle("확인하세요.").setMessage(viewGroup.getChildCount());
//
//        AlertDialog alertDialog = builder.create();
//
//        alertDialog.show();

        //for(TextInputEditText editText :
    }
}