package com.example.lms_acxiom_consulting_practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lms_acxiom_consulting_practical.DTO.Book;
import com.example.lms_acxiom_consulting_practical.DTO.IssuedBooks;
import com.example.lms_acxiom_consulting_practical.RecyclerView.TakeBooksAdapter;
import com.example.lms_acxiom_consulting_practical.ViewModel.LMSViewModel;

import java.util.List;

public class TakeBook extends AppCompatActivity {

    SearchView searchView;
    RecyclerView recyclerView;
    TakeBooksAdapter takeBooksAdapter;
    LMSViewModel lmsViewModel;
    List<Book> BooksList;
    int Userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the Bundle data in the target activity
        Intent receivedBundle = getIntent();
        if (receivedBundle != null) {
            Userid=receivedBundle.getIntExtra("UserId",1);
        }
        setContentView(R.layout.activity_take_book);
        lmsViewModel=new ViewModelProvider(this).get(LMSViewModel.class);
        BooksList=lmsViewModel.GetAllBook();
        recyclerView=findViewById(R.id.SearchRecycleView);
        searchView=findViewById(R.id.SearchRecycleViewSearchbar);


        takeBooksAdapter=new TakeBooksAdapter(new TakeBooksAdapter.ItemClickListenerHelper() {
            @Override
            public void HelpListenItemClick(int BookId,String BookName,String AuthorName) {

                lmsViewModel.IssueBooks(BookId);
                if(lmsViewModel.BookIssuedOrNot(BookId)){
                    IssuedBooks issuedBooks=new IssuedBooks(BookName,AuthorName,BookId,Userid);
                    lmsViewModel.InsertIssuedBooks(issuedBooks);
                    int nOfBorrowedBooks=lmsViewModel.BooksBorrowed(Userid);
                    lmsViewModel.UpdateBooksBorrowed(Userid,nOfBorrowedBooks+1);
                    takeBooksAdapter.getData(lmsViewModel.GetAllBook());
                }
                else {
                    Toast.makeText(TakeBook.this, "BooK Already Issued", Toast.LENGTH_SHORT).show();
                }


            }
        });
        takeBooksAdapter.getData(BooksList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(takeBooksAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            /*
            This method will be called when the user submits the query.
             */
            @Override
            public boolean onQueryTextSubmit(String query) {

                /*
            This method is called when ever there is change in the search text entered by user.
             */
                SearchDataFromDataBase(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                /*
                `This method will be executed when the
                 */
                SearchDataFromDataBase(newText);
                return true;
            }
        });

    }
    /*
   This method will retrieve data from the database and save send to the SearchArrayAdapter.
    */
    public void SearchDataFromDataBase(String SearchTerm){

        if(SearchTerm.length()==0){
            takeBooksAdapter.getData(lmsViewModel.ReturnBook(SearchTerm));
        }
        else {
            takeBooksAdapter.getData(lmsViewModel.ReturnBook(SearchTerm));
        }

    }
}