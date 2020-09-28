package com.he.addressBook;

public class PhoneNumber {
    private String label;
    private String phoneNumber;

    public PhoneNumber(String label, String phoneNumber) throws Exception {
        // TODO
        if (label == null || label == "" ) {
            throw new Exception();
        }
        int length = label.length();
        if (length > 255 || label.trim().equals("")) {
            throw new Exception();
        }
        if (!label.matches("[a-zA-Z ]+")) {
            throw new Exception();
        }

        if (!phoneNumber.matches("[0-9]+")) {
            throw new Exception();
        }
        if (phoneNumber.length()!=10) {
            throw new Exception();
        }
        this.label = label;
        this.phoneNumber = phoneNumber;

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
