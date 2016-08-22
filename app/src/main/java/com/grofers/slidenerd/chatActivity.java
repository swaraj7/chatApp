package com.grofers.slidenerd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class chatActivity extends AppCompatActivity {

    private MyAdapter adapter;
    private Button addBut;
    static List<Message>  messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
        setContentView(R.layout.activity_chat);

        RecyclerView recyclerView  = (RecyclerView)findViewById(R.id.my_recyclerview);

//        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(new MyAdapter(this));

        adapter = new MyAdapter(getApplicationContext(), messageList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //adding button for checking dynamic recycler view working or not
        addBut = (Button) findViewById(R.id.add_button);

        addBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message m1 =  new Message();
                m1.data = "added new";
                messageList.add(m1);
                adapter.notifyDataSetChanged();
            }
        });
    }



    public static void getData(){
       messageList = new ArrayList<>();
        String[] messages = {"hi i hate you", "hello dgvldivgdsivsdiv", " ok vblisdgqgrfsgufagsfasu;f", "bye  lvblfsivghgfivg"};
        for(int i=0;i<messages.length; i++){
            Message m = new Message();
            m.data = messages[i];
            messageList.add(m);
        }
        return;
    }
}
