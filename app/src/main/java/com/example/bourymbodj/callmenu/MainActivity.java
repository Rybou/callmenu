package com.example.bourymbodj.callmenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<phoneContact> phoneContacts = GetPhoneContact();

        final ListView lv1 = (ListView) findViewById(R.id.listView);
        lv1.setAdapter(new CustomBaseAdapter(this, phoneContacts));
        // Register the ListView  for Context menu
        registerForContextMenu(lv1);

    }

    private ArrayList<phoneContact> GetPhoneContact() {
        ArrayList<phoneContact> results = new ArrayList<phoneContact>();

        phoneContact sr1 = new phoneContact();
        sr1.setName("John Smith");
        sr1.setPhone("214-555-1234");
        results.add(sr1);

        phoneContact sr2 = new phoneContact();
        sr2.setName("Jane Doe");
        sr2.setPhone("469-555-2587");
        results.add(sr2);

        phoneContact sr3 = new phoneContact();
        sr3.setName("Steve Young");
        sr3.setPhone("305-555-7895");
        results.add(sr3);

        phoneContact sr4 = new phoneContact();
        sr4.setName("Fred Jones");
        sr4.setPhone("612-555-8214");
        results.add(sr4);

        phoneContact sr5 = new phoneContact();
        sr5.setName("Boury Mbodj");
        sr5.setPhone("613-435-8214");
        results.add(sr5);

        phoneContact sr6 = new phoneContact();
        sr6.setName("EDD Hardy");
        sr6.setPhone("283-245-8741");
        results.add(sr5);


        return results;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Call") {
            Toast.makeText(getApplicationContext(), "calling code", Toast.LENGTH_LONG).show();
            Intent in=new Intent(Intent.ACTION_CALL,Uri.parse("0000000000"));
            try{
                startActivity(in);
            }

            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(),"yourActivity is not found",Toast.LENGTH_SHORT).show();
            }
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
            try {
                Uri uri = Uri.parse("smsto:"+ "Selected Contact");
                // No permisison needed
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                // Set the message to be sent
                smsIntent.putExtra("sms_body", "SMS application launched ");
                startActivity(smsIntent);
            } catch (Exception e) {
                Toast.makeText(this,
                        "SMS faild, please try again later!",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }else{
            return false;
        }
        return true;
    }
}


