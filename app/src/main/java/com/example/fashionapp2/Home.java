package com.example.fashionapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.ExifInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fashionapp2.Adapter.FashionAdapter;
import com.example.fashionapp2.Adapter.catagoryAdapter;
import com.example.fashionapp2.Domain.CategoryDomain;
import com.example.fashionapp2.Domain.FashionDomain;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.ClientProtocolException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Home extends AppCompatActivity {
    TextView greeting, greeting2;
    private RecyclerView.Adapter adapter, adapter2;
    private  RecyclerView recyclerViewCategoryList, recyclerViewFashionList;
    Button outfit, shoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        greeting = findViewById(R.id.Greeting);
        greeting2 = findViewById(R.id.TextView2);
        outfit = findViewById(R.id.outfit);
        shoes = findViewById(R.id.shoes);
        Intent intent = getIntent();
        String input = intent.getStringExtra("input");
        greeting.setText("Good Morning, " + input);

        //recyclerViewCategory();
        recyclerViewFashion();
        bottomNavigation();


    }
    public void showShoes(View view){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFashionList=findViewById(R.id.fashion_list);
        recyclerViewFashionList.setLayoutManager(linearLayoutManager);

        ArrayList<FashionDomain> fashionList = new ArrayList<>();
        fashionList.add(new FashionDomain("Red Nike", "shoes1", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 300.0));
        fashionList.add(new FashionDomain("Brown Shoes", "shoes2", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 250.0));

        adapter2 = new FashionAdapter(fashionList);
        recyclerViewFashionList.setAdapter(adapter2);
    }
    public void showOutfit(View view){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFashionList=findViewById(R.id.fashion_list);
        recyclerViewFashionList.setLayoutManager(linearLayoutManager);

        ArrayList<FashionDomain> fashionList = new ArrayList<>();
        fashionList.add(new FashionDomain("Grey Hoddie", "a4", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 400.0));

        adapter2 = new FashionAdapter(fashionList);
        recyclerViewFashionList.setAdapter(adapter2);
    }
    public void showTrouser(View view){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFashionList=findViewById(R.id.fashion_list);
        recyclerViewFashionList.setLayoutManager(linearLayoutManager);

        ArrayList<FashionDomain> fashionList = new ArrayList<>();
        fashionList.add(new FashionDomain("Grey trouser", "trouser1", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 400.0));

        adapter2 = new FashionAdapter(fashionList);
        recyclerViewFashionList.setAdapter(adapter2);
    }
    public void showAll(View view){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFashionList=findViewById(R.id.fashion_list);
        recyclerViewFashionList.setLayoutManager(linearLayoutManager);

        ArrayList<FashionDomain> fashionList = new ArrayList<>();
        fashionList.add(new FashionDomain("Grey Hodie", "a4", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 400.0));
        fashionList.add(new FashionDomain("Red Nike", "shoes1", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 300.0));
        fashionList.add(new FashionDomain("Brown Shoes", "shoes2", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 250.0));
        fashionList.add(new FashionDomain("Grey trouser", "trouser1", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 400.0));
        adapter2 = new FashionAdapter(fashionList);
        recyclerViewFashionList.setAdapter(adapter2);
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.toCart);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, CartListActivity.class));
            }
        });
    }

    private void recyclerViewFashion() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFashionList=findViewById(R.id.fashion_list);
        recyclerViewFashionList.setLayoutManager(linearLayoutManager);

        ArrayList<FashionDomain> fashionList = new ArrayList<>();
        fashionList.add(new FashionDomain("Grey Hodie", "a4", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 400.0));
        fashionList.add(new FashionDomain("Red Nike", "shoes1", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 300.0));
        fashionList.add(new FashionDomain("Brown Shoes", "shoes2", "Comsy, nice for you to like going somewhere comsy. Just by new this and you will suprise with your style", 250.0));

        adapter2 = new FashionAdapter(fashionList);
        recyclerViewFashionList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        //recyclerViewCategoryList=findViewById(R.id.categories);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("All", "all"));
        categoryList.add(new CategoryDomain("Shoes", "derby"));
        categoryList.add(new CategoryDomain("Uniform", "uniform"));

        adapter = new catagoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }


}