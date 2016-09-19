package com.icom.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivAddContactDone;
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        ivAddContactDone = (ImageView) findViewById(R.id.iv_addContact_done);
        etName = (EditText) findViewById(R.id.et_name);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etEmail = (EditText) findViewById(R.id.et_email);
        etAddress = (EditText) findViewById(R.id.et_address);
    }

    private void validate() {


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_addContact_done) {
            validate();
        }
    }
}
