package com.fishinwater.android_plan_material_design.activity;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fishinwater.android_plan_material_design.R;
import com.fishinwater.android_plan_material_design.utils.EmailManager;


public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linearLayout;
    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordWrapper;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        iniViews();
    }

    private void iniViews(){
        linearLayout = findViewById(R.id.background);
        usernameWrapper = findViewById(R.id.usernameWrapper);
        passwordWrapper = findViewById(R.id.passwordWrapper);
        btn = findViewById(R.id.btn);

        linearLayout.setOnClickListener(this);
        usernameWrapper.setOnClickListener(this);
        passwordWrapper.setOnClickListener(this);
        btn.setOnClickListener(this);

        usernameWrapper.setHint("Username");
        passwordWrapper.setHint("Password");
    }


    @Override
    public void onClick(View v) {
        String username = usernameWrapper.getEditText().getText().toString();
        String password = usernameWrapper.getEditText().getText().toString();

        switch (v.getId()){
            case R.id.usernameWrapper:
                if (!new EmailManager().validateEmail(username)) {
                    usernameWrapper.setError("Not a valid email address!");
                }else {
                    usernameWrapper.setErrorEnabled(false);
                }
                break;

            case R.id.passwordWrapper:
                if (!new EmailManager().validatePassword(password)) {
                    passwordWrapper.setError("Not a valid password!");
                }else {
                    passwordWrapper.setErrorEnabled(false);
                }
                break;

            case R.id.btn:
                doLogin();
                break;

            case R.id.background:
                hideKeyboard();
                break;


            default:

                break;
        }
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public void doLogin() {
        Toast.makeText(getApplicationContext(), "OK! I'm performing login.", Toast.LENGTH_SHORT).show();
        // TODO: login procedure; not within the scope of this tutorial.
        MainActivity.anctionStart(this);
    }
}
