package com.example.bourymbodj.callmenu;

/**
 * Created by bourymbodj on 15-11-25.
 */
public class phoneContact {
    private String name;
    private String phone;

    public phoneContact() {
        name= "Name";
        phone= "Phone Number";

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
