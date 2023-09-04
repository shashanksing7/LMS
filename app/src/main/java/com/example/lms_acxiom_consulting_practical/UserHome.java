package com.example.lms_acxiom_consulting_practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lms_acxiom_consulting_practical.DTO.IssuedBooks;
import com.example.lms_acxiom_consulting_practical.RecyclerView.IssuedBooksAdapter;
import com.example.lms_acxiom_consulting_practical.ViewModel.LMSViewModel;

import java.util.List;

public class UserHome extends AppCompatActivity {
    TextView UserName,BooksBorrowed;
    List<IssuedBooks> IssuedBooksList;
    public LMSViewModel lmsViewModel;
    Button  SearchButton;
    int UserId;

    RecyclerView recyclerView;

    IssuedBooksAdapter issuedBooksAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        UserName=findViewById(R.id.username);
        BooksBorrowed=findViewById(R.id.BooksBorrowed);
        // Initialize the ViewModel
        lmsViewModel = new ViewModelProvider(this).get(LMSViewModel.class);
        recyclerView=findViewById(R.id.recyclerView);
        SearchButton=findViewById(R.id.searchBooksButton);

        // Retrieve the Bundle data in the target activity
        Bundle receivedBundle = getIntent().getBundleExtra("UserData");
        if (receivedBundle != null) {
            String userName = receivedBundle.getString("Name");
            int bookBorrowed = receivedBundle.getInt("Books Borrowed");
            UserId=receivedBundle.getInt("UserId");

            // Set the text of UserName TextView
            UserName.setText("Name"+":"+userName);

            // Set the text of BooksBorrowed TextView (assuming it's an integer)
            BooksBorrowed.setText(String.valueOf("BooksBorrowed"+":"+bookBorrowed));
            UserId=receivedBundle.getInt("UserId");

        }

        IssuedBooksList=lmsViewModel.GetIssuedBooks(UserId);
        issuedBooksAdapter=new IssuedBooksAdapter( new IssuedBooksAdapter.ItemClickListenerHelper() {
            @Override
            public void HelpListenItemClick(int BookId,int BooksId) {

                lmsViewModel.DeleteIssuedBooks(BookId);
                lmsViewModel.TAkeBAckBooks(BooksId);
                issuedBooksAdapter.getData(lmsViewModel.GetIssuedBooks(UserId));



            }
        });
        issuedBooksAdapter.getData(IssuedBooksList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(issuedBooksAdapter);

        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserHome.this,TakeBook.class);
                intent.putExtra("UserId",UserId);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        issuedBooksAdapter.getData(lmsViewModel.GetIssuedBooks(UserId));
    }
}