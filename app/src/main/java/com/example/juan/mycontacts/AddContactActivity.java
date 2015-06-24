package com.example.juan.mycontacts;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juan.mycontacts.data.Contact;


public class AddContactActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
    }

    public void addContact(View view) {
        Context context = getApplicationContext();
        EditText nameField = (EditText) findViewById(R.id.name_field);
        EditText emailField = (EditText) findViewById(R.id.email_field);
        EditText phoneField = (EditText) findViewById(R.id.phone_field);
        EditText addressField = (EditText) findViewById(R.id.address_field);

        Contact newContact = new Contact(nameField.getText().toString(),
                emailField.getText().toString(),
                addressField.getText().toString(),
                Long.parseLong(phoneField.getText().toString()));

        ((MyContacts) context).myContacts.add(newContact);

        Toast message = Toast.makeText(getApplicationContext(),
                getString(R.string.added_message), Toast.LENGTH_SHORT);
        message.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
