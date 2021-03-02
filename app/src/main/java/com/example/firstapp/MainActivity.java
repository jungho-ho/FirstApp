package com.example.firstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String Tag = "Log...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_btn_hello_text_change(View view) {
        TextView textView = (TextView) findViewById(R.id.txt_hello);
        textView.setText("It's beginnig!");
        if(check_editText()) {//공백 확인.
            calcu_Percent();//필수가 공백이 아닐때만 처리 함. 필수 공백일 때, 걍 죽는 현상 발생.
        }
    }

    private boolean check_editText(){
        String resultValue="";
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
            Log.v(Tag,ttView[i].getText().toString());
            if(edittText[i].length() == 0 &&
                    !ttView[i].getText().equals("4.대출 이자/월") &&
                    !ttView[i].getText().equals("5.대출 이자/년") &&
                    !ttView[i].getText().equals("7.수익률") &&
                    !ttView[i].getText().equals("8.수익금/년")){
                builder.setTitle("확인하세요.").setMessage(ttView[i].getText() + "(이)가 공백입니다.");
                builder.show();
                resultValue = "필수 입력값에 공백이 있습니다.";
                break;
            }
        }
        return (resultValue.equals("필수 입력값에 공백이 있습니다.") ? false : true);//공백
    }

    private void calcu_Percent(){
        calcu_대출이자();
        calcu_수익률();
    }

    private void calcu_수익률(){
        EditText 투자금 = (EditText) findViewById(R.id.editTxt_0);
        EditText 월세 = (EditText) findViewById(R.id.editTxt_6);
        EditText 년_대출이자 = (EditText) findViewById(R.id.editTxt_5);

        int 년수익 = Integer.parseInt(월세.getText().toString()) * 12 - Integer.parseInt(년_대출이자.getText().toString());
        Log.v(Tag + "_년수익", String.valueOf(년수익));
        EditText d = (EditText) findViewById(R.id.editTxt_8);
        d.setText(String.format("%d",년수익));//8.수익금/년

        double 수익률 = (년수익 * 100) / (double)Integer.parseInt(투자금.getText().toString());
        EditText dd = (EditText) findViewById(R.id.editTxt_7);
        dd.setText(String.format("%.1f", 수익률));//7.수익률
    }

    private void calcu_대출이자(){
        EditText 대출금 = (EditText) findViewById(R.id.editTxt_2);
        EditText 금리 = (EditText) findViewById(R.id.editTxt_3);

        double 년이자 = Integer.parseInt(대출금.getText().toString()) * (double)(Integer.parseInt(금리.getText().toString()) / (double)100);
        Log.v(Tag + "_금리", String.valueOf((double)(Integer.parseInt(금리.getText().toString()) / (double)100)));

        EditText dd = (EditText) findViewById(R.id.editTxt_5);
        dd.setText(String.format("%.0f", 년이자));//5.년이자

        EditText d = (EditText) findViewById(R.id.editTxt_4);
        d.setText(String.format("%.0f",년이자/12));//4.월이자
    }
}