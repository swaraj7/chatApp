package com.grofers.slidenerd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by swaraj on 11/08/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {

    Context context;
    private LayoutInflater inflator;

    //array of message class to populate my recyclerview
    //ArrayList<Message>  messageList = new ArrayList<Message>();
    //if we initialise the array as below , then we willnever get null pointer exception
    List<Message> messageList = Collections.emptyList();


    public MyAdapter(Context context, List<Message> mList) {

        //to inflate the items automatically
        this.context = context;
        inflator = LayoutInflater.from(context);
        messageList = mList;
    }



    @Override
    public MyAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rows, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Message current = messageList.get(position);
        holder.textMessage.setText(current.data);
    }


    @Override
    public int getItemCount() {
            return messageList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        //to populate data

        TextView textMessage;

        public myViewHolder(View itemView) {
            super(itemView);

            textMessage = (TextView) itemView.findViewById(R.id.my_textView);
        }
    }
}
