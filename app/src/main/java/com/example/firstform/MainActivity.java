package com.example.firstform;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Submit(View view) {
        EditText editUsername = findViewById(R.id.editUsername);
        EditText editFullName = findViewById(R.id.editFullName);
        EditText editCountry = findViewById(R.id.editCountry);
        EditText editEmailAddress = findViewById(R.id.editEmailAddress);
        EditText editPhone = findViewById(R.id.editPhone);
        EditText editTextTextPassword = findViewById(R.id.editTextTextPassword);
        RadioButton radioMale = findViewById(R.id.radioMale);
        RadioButton radioFemale = findViewById(R.id.radioFemale);
        CheckBox checkBoxTerms = findViewById(R.id.checkBoxTerms);

        String username = editUsername.getText().toString();
        String fullName = editFullName.getText().toString();
        String country = editCountry.getText().toString();
        String emailAddress = editEmailAddress.getText().toString();
        String phone = editPhone.getText().toString();
        String password = editTextTextPassword.getText().toString();

        String gender = "";
        if (radioMale.isChecked()) {
            gender = radioMale.getText().toString();
        } else if (radioFemale.isChecked()) {
            gender = radioFemale.getText().toString();
        }

        String terms = checkBoxTerms.isChecked() ? "Yes" : "No";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(R.string.dialog_title);
        alertDialogBuilder.setMessage("Username: " + username + "\n" +
                "Name: " + fullName + "\n" +
                "Country: " + country + "\n" +
                "Email: " + emailAddress + "\n" +
                "Phone: " + phone + "\n" +
                "Password: " + password + "\n" +
                "Gender: " + gender + "\n" +
                "Terms Accepted: " + terms);
        alertDialogBuilder.setPositiveButton(R.string.btn_ok, null);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
