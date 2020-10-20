package com.example.chat_boot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.CustomViewHolder> {

    List<ResponseMessage> responseMessages;
    Context context;
    class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public CustomViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textMessage);
        }
    }

    public MessageAdapter(List<ResponseMessage> responseMessages, Context context) {
        this.responseMessages = responseMessages;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(responseMessages.get(position).isMe()){
            return R.layout.me_buble;
        }
        return R.layout.boot_buble;
    }

    @Override
    public int getItemCount() {
        return  responseMessages.size();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textView.setText(responseMessages.get(position).getText());
    }
}