package com.example.lms_acxiom_consulting_practical.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms_acxiom_consulting_practical.DTO.IssuedBooks;
import com.example.lms_acxiom_consulting_practical.R;

import java.util.List;

public class IssuedBooksAdapter extends RecyclerView.Adapter<IssuedBooksAdapter.MyViewHolder> {
    private List<IssuedBooks> dataList;
    private ItemClickListenerHelper itemClickListenerHelper;

    public IssuedBooksAdapter(ItemClickListenerHelper itemClickListenerHelper) {
        this.itemClickListenerHelper=itemClickListenerHelper;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.issuedbookslayout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        IssuedBooks item = dataList.get(position);

        // Set the data from IssuedBooks to the TextViews
        holder.textViewBookName.setText("Book Name: " + item.getBookName());
        holder.textViewAuthorName.setText("Author Name: " + item.getAuthorName());
    }

    public void getData(List<IssuedBooks> DataList){
        dataList=DataList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBookName;
        TextView textViewAuthorName;

        Button SubmitButton;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewBookName = itemView.findViewById(R.id.textViewBookName);
            textViewAuthorName = itemView.findViewById(R.id.textViewAuthorName);
            SubmitButton=itemView.findViewById(R.id.buttonSubmit);

            SubmitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        IssuedBooks item = dataList.get(position);
                        int bookId = item.getId(); // Get the ID from IssuedBooks
                        int booksid=item.getBookId();
                        itemClickListenerHelper.HelpListenItemClick(bookId,booksid);
                    }
                }
            });
        }
    }

    /*
    Creating an interface that will act as callback when the user presses the sell button.it will have a method that will take the data of the
    selected item as the parameter and we will perform the respective actions.
     */
    public  interface ItemClickListenerHelper{
        /*
        This method that will take the data of the selected item as the parameter and we will perform the respective actions
         */
        public void HelpListenItemClick(int BookId,int Booksid);
    }
}
