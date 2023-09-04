package com.example.lms_acxiom_consulting_practical.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms_acxiom_consulting_practical.DTO.Book;
import com.example.lms_acxiom_consulting_practical.DTO.IssuedBooks;
import com.example.lms_acxiom_consulting_practical.R;

import java.util.List;

public class TakeBooksAdapter extends RecyclerView.Adapter<TakeBooksAdapter.MyViewHolder> {
    private List<Book> dataList;
    private ItemClickListenerHelper itemClickListenerHelper;

    public TakeBooksAdapter( ItemClickListenerHelper itemClickListenerHelper) {

        this.itemClickListenerHelper = itemClickListenerHelper;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.takebooklayout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book item = dataList.get(position);

        // Set the data from IssuedBooks to the TextViews
        holder.textViewBookName.setText("Book Name: " + item.getBookName());
        holder.textViewAuthorName.setText("Author Name: " + item.getAuthor());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void getData(List<Book> DataList){
        dataList=DataList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBookName;
        TextView textViewAuthorName;
        TextView textViewUserId;
        Button takeButton;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewBookName = itemView.findViewById(R.id.textViewBookName);
            textViewAuthorName = itemView.findViewById(R.id.textViewAuthorName);
            takeButton = itemView.findViewById(R.id.buttonTake);

            takeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Book item = dataList.get(position);
                        int bookId = item.getBookId();
                        String BookName=item.getBookName();
                        String AuthorName=item.getAuthor();
                        itemClickListenerHelper.HelpListenItemClick(bookId,BookName,AuthorName);
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
        void HelpListenItemClick(int BookId, String BookName,String AuthorName );
    }
}
