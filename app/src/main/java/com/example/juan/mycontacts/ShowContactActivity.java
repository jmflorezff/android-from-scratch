package com.example.juan.mycontacts;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juan.mycontacts.data.Contact;


public class ShowContactActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);

        String[] names = getContactsNames();
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = ((TextView) view).getText().toString();
                Contact contact = ((MyContacts) getApplicationContext()).searchContactByName(name);
                Toast.makeText(getApplicationContext(),
                        getString(R.string.name_label) + getString(R.string.colon_label) + contact.getName() +
                        getString(R.string.comma_label) + getString(R.string.email_label) +
                        getString(R.string.colon_label) + contact.getEmail() + getString(R.string.comma_label) +
                        getString(R.string.phone_label) + getString(R.string.colon_label) + contact.getPhone() +
                        getString(R.string.comma_label) + getString(R.string.address_label) +
                        getString(R.string.colon_label) + contact.getAddress() + getString(R.string.comma_label),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String[] getContactsNames() {
        MyContacts myContacts = (MyContacts) getApplicationContext();
        int size = myContacts.myContacts.size();
        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            names[i] = myContacts.myContacts.get(i).getName();
        }

        return names;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_contact, menu);
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
