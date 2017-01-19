package com.example.alexwalker.firebasesandbox;

import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = (Button)findViewById(R.id.sendButton);
        Button cleanButton = (Button)findViewById(R.id.cleanButton);
        final EditText editText = (EditText)findViewById(R.id.editText);
        final TextView textView = (TextView)findViewById(R.id.textView2);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("message");

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                AMessage message = new AMessage(text, "anonymous", "0");
                myRef.push().setValue(message);
            }



        });
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                AMessage aMessage = dataSnapshot.getValue(AMessage.class);
                textView.append("\n" + aMessage.getUserName()
                                + "\n"
                                + aMessage.getTextMessage()
                                +"\n\n\n" );

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        myRef.addChildEventListener(childEventListener);

    }
}
