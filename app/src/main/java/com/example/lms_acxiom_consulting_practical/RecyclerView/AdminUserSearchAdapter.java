package com.example.lms_acxiom_consulting_practical.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms_acxiom_consulting_practical.DTO.User;
import com.example.lms_acxiom_consulting_practical.R;

import java.util.List;

public class AdminUserSearchAdapter extends RecyclerView.Adapter<AdminUserSearchAdapter.MyViewHolder> {

    List<User>UserList;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adminsearchuserlayout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User item=UserList.get(position);
        holder.UserName.setText("User Name:"+" "+item.getUserName());
        holder.BooksBorrowed.setText("Books Borrowed:"+" "+String.valueOf(item.getBookBorrowed()));

    }


    @Override
    public int getItemCount() {
        return  UserList.size();
    }
    public void getdata(List<User>DataList){
        UserList=DataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView UserName,BooksBorrowed;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            UserName=itemView.findViewById(R.id.usernameTextView);
            BooksBorrowed=itemView.findViewById(R.id.bookBorrowedTextView);
        }

    }
}
