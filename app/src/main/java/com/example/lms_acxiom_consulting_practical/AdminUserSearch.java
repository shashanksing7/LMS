package com.example.lms_acxiom_consulting_practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.lms_acxiom_consulting_practical.DTO.User;
import com.example.lms_acxiom_consulting_practical.RecyclerView.AdminUserSearchAdapter;
import com.example.lms_acxiom_consulting_practical.ViewModel.LMSViewModel;

import java.util.List;

public class AdminUserSearch extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    AdminUserSearchAdapter adminUserSearchAdapter;
    LMSViewModel lmsViewModel;
    List<User>UserList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_search);
        recyclerView=findViewById(R.id.adminrecyclerView);
        searchView=findViewById(R.id.adminsearchView);
        adminUserSearchAdapter=new AdminUserSearchAdapter();
        lmsViewModel=new ViewModelProvider(this).get(LMSViewModel.class);
        UserList=lmsViewModel.ReturnAllUser();
        adminUserSearchAdapter.getdata(UserList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adminUserSearchAdapter);

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
            adminUserSearchAdapter.getdata(lmsViewModel.ReturnSearchUser(SearchTerm));
        }
        else {
           adminUserSearchAdapter.getdata(lmsViewModel.ReturnSearchUser(SearchTerm));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        adminUserSearchAdapter.getdata(lmsViewModel.ReturnAllUser());

    }
}