package com.example.creditcardinputexcercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout firstname;
    private TextInputLayout lastname;
    private TextInputLayout secruitycode;
    private TextInputLayout date;
    private TextInputLayout cardnumber;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.first);
        lastname = findViewById(R.id.last);
        secruitycode = findViewById(R.id.secruity);
        date = findViewById(R.id.expiry);
        cardnumber = findViewById(R.id.card1);
        btn = findViewById(R.id.button);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardnumber.setError(null);
                String creditcard_No = cardnumber.getEditText().getText().toString().trim();
                String lastdate =date.getEditText().getText().toString().trim();
                String secruity =secruitycode.getEditText().getText().toString().trim();
                String first = firstname.getEditText().getText().toString().trim();
                String last = lastname.getEditText().getText().toString().trim();

                if(creditcard_No.isEmpty()){
                    cardnumber.setError("Please input the card number");
                    return;
                }
                if(creditcard_No.length() == 15) {
                    //Toast.makeText(MainActivity.this,""+creditcard_No,Toast.LENGTH_SHORT).show();
                    if(creditcard_No.charAt(0) !='3') {
                        cardnumber.setError("Incorrect card no");
                        return;
                    }
                }
                if(creditcard_No.length() == 16){
                    if(creditcard_No.charAt(0) == '4' || creditcard_No.charAt(0) == '5' || creditcard_No.charAt(0) == '6' || creditcard_No.charAt(0) == '3') {

                    }
                    else{
                        cardnumber.setError("Incorrect card no");
                        return;
                    }
                }
                else{
                    cardnumber.setError("Incorrect card no");
                    return;
                }
                int check = 1;
                int odd = 0;
                int even = 0 ;


             for (int i = creditcard_No.length() - 1; i >= 0; i--) {
                 if(check == 1) {
                     int k = 1*(Integer.parseInt(creditcard_No.charAt(i) + ""));
                     int sumation1 = 0;
                     while(k > 0) {
                         int rem = k % 10;
                         sumation1 = sumation1 + rem;
                         k = k/10;
                     }
                     odd = odd + sumation1;
                     check = 2;
                 }
                 else{
                     int l = 2*(Integer.parseInt(creditcard_No.charAt(i) + ""));
                     int sumation2 = 0;
                     while(l > 0) {
                         int rem = l % 10;
                         sumation2 = sumation2 + rem;
                         l = l/10;
                     }
                     even = even + sumation2;
                     check = 1;
                 }
             }
             int sum = odd + even;
             if(sum % 10 == 0) {

             }
             else{
                 Toast.makeText(MainActivity.this,""+sum,Toast.LENGTH_SHORT).show();
                 cardnumber.setError("Incorrect card no");
                 return;
             }
                if(secruity.isEmpty())
                {
                    secruitycode.setError("Please input the secruity code");
                    return;
                }
                if(secruity.length() == 4)
                {
                    if(  creditcard_No.charAt(0) == '3' && creditcard_No.length() == 15) {
                    }
                    else{
                        secruitycode.setError("Invalid secruity code");
                        return;
                    }

                }
                if(secruity.length() != 3  )
                {
                    secruitycode.setError("Invalid secruity code");
                    return;
                }

                if(first.isEmpty())
                {
                    firstname.setError("Please input the first name");
                    return;
                }
                int checkr = 0;
                for(int i = 0; i < first.length(); i++) {
                    if(first.charAt(i) >= 65 && first.charAt(i) <= 90) {

                    }
                    else if(first.charAt(i) >= 97 && first.charAt(i) <= 122){

                    }
                    else if(first.charAt(i) == ' ') {

                    }
                    else{
                        checkr = 1;
                        break;
                    }
                }
                if(checkr == 1){
                    firstname.setError("Invalid name");
                    return;
                }
                if(last.isEmpty())
                {
                    lastname.setError("Please input the last name");
                }
                int flag = 0;
                for(int i = 0; i < last.length(); i++) {
                    if(last.charAt(i) >= 65 && last.charAt(i) <= 90) {

                    }
                    else if(last.charAt(i) >= 97 && last.charAt(i) <= 122){


                    }
                    else if(last.charAt(i) == ' ') {

                    }
                    else{
                        flag = 1;
                        break;
                    }
                }
                if( flag == 1){
                    lastname.setError("Invalid name");
                    return;
                }
                if(lastdate.isEmpty()){
                    date.setError("please input the number");
                    return ;
                }
                   if(lastdate.length() != 5) {
                    date.setError("incorrect number");
                    return ;
                }
                   if(lastdate.charAt(2) != '/') {
                    date.setError("incorrect number");
                    return ;
                }
                   int p1 = Integer.parseInt(lastdate.substring(0,2));
                   if(p1 >= 1 && p1 <= 12) {

                   }
                   else{
                       date.setError("incorrect number");
                       return ;
                   }
                   int p2 = Integer.parseInt(lastdate.substring(3));
                   if(p2>=21 && p2<=35) {

                   }
                   else{
                       date.setError("incorrect number");
                       return ;
                   }
                openDialog();
            }
        });

    }
    public void openDialog()
    {

        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager() , "");
    }
}