package com.icom.agenda;

import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Pattern;

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

        ivAddContactDone.setOnClickListener(this);
    }

    private boolean validate() {

        boolean flag = false;

        if (etName.getText().toString().length() > 0) {
            if (etPhone.getText().toString().length() > 0) {
                String regex = "^[0-9]+$";
                if (etPhone.getText().toString().matches(regex)) {
                    if (etEmail.getText().toString().matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*\n" +" @[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")) {
                        if (etAddress.getText().toString().length() > 0) {
                            flag = true;
                        } else {
                            flag = false;
                            Toast.makeText(AddContactActivity.this, "Ingresa una dirección.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        flag = false;
                        Toast.makeText(AddContactActivity.this, "Correo no válido", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    flag = false;
                    Toast.makeText(AddContactActivity.this, "El número no es válidp", Toast.LENGTH_SHORT).show();
                }
            } else {
                flag = false;
                Toast.makeText(AddContactActivity.this, "Ingresa un número de teléfono", Toast.LENGTH_SHORT).show();
            }
        } else {
            flag = false;
            Toast.makeText(AddContactActivity.this, "Nombre inválido", Toast.LENGTH_SHORT).show();
        }
        return flag;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_addContact_done) {
            if(validate()){
                Toast.makeText(AddContactActivity.this, "Contacto agregado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
