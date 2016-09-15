package com.icom.agenda;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static String DNI = "dni";
    private static String NAME = "name";
    private static String TELEPHONE = "telephone";
    private static String MAIL = "mail";
    private static String ADDRESS = "address";
    private static String PICTURE = "picture";
    private static String CONTACTS = "contacts";

    private List<ContactBean> contactBeenList;
    private EditText etSearch;
    private RecyclerView rvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = (EditText) findViewById(R.id.et_search);
        rvContacts = (RecyclerView) findViewById(R.id.rv_contactsList);

        contactBeenList = new ArrayList<>();

        addContact("Ufemia", "1234-5678", "ufemia@mail.com", "Avenida Siempre Viva 18", null);
        addContact("Joseshuy", "1234-5678", "ufemia@mail.com", "Avenida Siempre Viva 18", null);
        addContact("Toby", "1234-5678", "ufemia@mail.com", "Avenida Siempre Viva 18", null);
        addContact("Benito", "1234-5678", "ufemia@mail.com", "Avenida Siempre Viva 18", null);
        addContact("Bruja", "1234-5678", "ufemia@mail.com", "Avenida Siempre Viva 18", null);

        Log.i(TAG, "onCreate: ContactsBeanList size: " + contactBeenList.size());
        
        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(contactBeenList);

        rvContacts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvContacts.setAdapter(adapter);

    }

    public void addContact(String name, String telephone, String mail, String address, @Nullable String picture) {

        AdminSQLite adminSQLite = new AdminSQLite(this, "contacts", null, 1);
        ContactBean contactBean = new ContactBean();

        SQLiteDatabase database = adminSQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DNI, 1);
        contactBean.setId(1);

        contentValues.put(NAME, name);
        contactBean.setName(name);

        contentValues.put(TELEPHONE, telephone);
        contactBean.setTelephone(telephone);

        contentValues.put(MAIL, mail);
        contactBean.setMail(mail);

        contentValues.put(ADDRESS, address);
        contactBean.setAddress(address);

        database.insert(CONTACTS, null, contentValues);
        contactBeenList.add(contactBean);

        database.close();
    }

    public void addContact() {
        // aqui cuando se da click al boton +
    }
}
