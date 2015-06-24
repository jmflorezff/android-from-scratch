package com.example.juan.mycontacts;

import android.app.Application;

import com.example.juan.mycontacts.data.Contact;

import java.util.ArrayList;

/**
 * Created by juan on 6/23/15.
 */
public class MyContacts extends Application {
    public ArrayList<Contact> myContacts;

    public MyContacts() {
        this.myContacts = new ArrayList<Contact>();
    }

    public Contact searchContactByName(String name) {
        Contact myContact = null;
        for (Contact contact : myContacts) {
            if (contact.getName() == name) {
                myContact = contact;
                break;
            }
        }
        return myContact;
    }
}
