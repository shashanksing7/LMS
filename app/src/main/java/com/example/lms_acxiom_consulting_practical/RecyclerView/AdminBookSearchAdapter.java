package com.example.lms_acxiom_consulting_practical.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms_acxiom_consulting_practical.AdminSearchBook;
import com.example.lms_acxiom_consulting_practical.DTO.Book;
import com.example.lms_acxiom_consulting_practical.R;

import java.util.List;

public class AdminBookSearchAdapter extends RecyclerView.Adapter<AdminBookSearchAdapter.MyviewHolder> {


    List<Book> BookList;
    ItemClickListenerHelper itemClickListenerHelper;
    public AdminBookSearchAdapter(ItemClickListenerHelper itemClickListenerHelper){
        this.itemClickListenerHelper=itemClickListenerHelper;

    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adminsearchbookslayout, parent, false);
        return new MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        Book item=BookList.get(position);
        holder.BookName.setText(item.getBookName());
        holder.AuthorName.setText(item.getAuthor());
        holder.BookIssued.setText(String.valueOf(item.getBookIssued()));
        if(item.getBookIssued()){
            holder.DeleteButton.setEnabled(false);
        }

    }

    @Override
    public int getItemCount() {
        return BookList.size();
    }
    public void getdata(List<Book>BookList){
        this.BookList=BookList;
        notifyDataSetChanged();
    }

    public class MyviewHolder extends  RecyclerView.ViewHolder{
        TextView BookName,AuthorName,BookIssued;
        Button DeleteButton;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            BookName=itemView.findViewById(R.id.bookNameTextView);
            AuthorName=itemView.findViewById(R.id.authorTextView);
            BookIssued=itemView.findViewById(R.id.bookIssuedTextView);
            DeleteButton=itemView.findViewById(R.id.deleteButton);
            DeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Book item = BookList.get(position);
                        int bookId = item.getBookId();
                        itemClickListenerHelper.HelpListenItemClick(bookId);
                    }
                }
            });
        }

    }

    /*
Creating an interface that will act as a callback when the user presses the "Take" button.
It will have a method that will take the data of the selected item as parameters,
and you can perform the respective actions in your activity or fragment.
 */
    public interface ItemClickListenerHelper {
        void HelpListenItemClick(int BookId );
    }
}
