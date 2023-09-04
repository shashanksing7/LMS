package com.example.lms_acxiom_consulting_practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.lms_acxiom_consulting_practical.DTO.Book;
import com.example.lms_acxiom_consulting_practical.RecyclerView.AdminBookSearchAdapter;
import com.example.lms_acxiom_consulting_practical.ViewModel.LMSViewModel;

import java.util.List;

public class AdminSearchBook extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchView searchView;
    LMSViewModel lmsViewModel;
    List<Book>BookList;
    AdminBookSearchAdapter adminBookSearchAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_search_book);
        recyclerView=findViewById(R.id.adminrecyclerViewSearch);
        searchView=findViewById(R.id.adminsearchViewSearch);
        lmsViewModel=new ViewModelProvider(this).get(LMSViewModel.class);
        BookList=lmsViewModel.GetBook();
        adminBookSearchAdapter =new AdminBookSearchAdapter(new AdminBookSearchAdapter.ItemClickListenerHelper() {
            @Override
            public void HelpListenItemClick(int BookId) {
                lmsViewModel.DeleteBook(BookId);
                adminBookSearchAdapter.getdata(lmsViewModel.GetBook());


            }
        });
        adminBookSearchAdapter.getdata(BookList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adminBookSearchAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SearchDataFromDataBase(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
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
            adminBookSearchAdapter.getdata(lmsViewModel.ReturnBook(SearchTerm));
        }
        else {
            adminBookSearchAdapter.getdata(lmsViewModel.ReturnBook(SearchTerm));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        adminBookSearchAdapter.getdata(lmsViewModel.GetBook());

    }
}