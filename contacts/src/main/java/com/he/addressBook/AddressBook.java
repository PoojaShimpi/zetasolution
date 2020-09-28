package com.he.addressBook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    private Set<Contact> contactList;
    public AddressBook() {
        contactList = new HashSet<>();
    }

    public void addContact(Contact contact) throws Exception {
        if (contact != null) {
           for (Contact c : contactList) {
               if (c.getName().equals(contact.getName())) {
                   throw  new Exception();
               }
           }
           contactList.add(contact);
        }
    }

    public void deleteContact(String name) throws Exception {
        if (contactList!=null) {
            Iterator<Contact> it = contactList.iterator();
            boolean found = false;
            while (it.hasNext()) {
                Contact c = it.next();
                if (c.getName().equals(name)) {
                    found = true;
                    it.remove();
                    break;
                }
            }
            if (!found) {
                throw new Exception();
            }
        }
    }

    public void updateContact(String name, Contact contact) throws Exception{

        if (contactList!=null) {
            boolean found  = false;
            for (Contact c : contactList) {
                if (c.getName().equalsIgnoreCase(name)) {
                    found  = true;
                    c.setAddresses(contact.getAddresses());
                    c.setName(contact.getName());
                    c.setOrganisation(contact.getOrganisation());
                    c.setPhoneNumbers(contact.getPhoneNumbers());
                    break;
                }
            }
            if (!found) {
                throw  new Exception();
            }

        }
    }

    public List<Contact> searchByName(String name) {
        if (contactList!=null) {
            List<Contact> contacts = contactList.parallelStream()
                    .filter(contact -> contact.getName().toUpperCase().startsWith(name.toUpperCase())).
                    collect(Collectors.toList());
            return contacts;
        }
        return null;
    }

    public List<Contact> searchByOrganisation(String organisation) {
        if (contactList!=null) {
            List<Contact> contacts = contactList.parallelStream()
                    .filter(contact -> contact.getOrganisation().toUpperCase().startsWith(organisation.toUpperCase())).
                    collect(Collectors.toList());
            return contacts;
        }
        return null;
    }

}