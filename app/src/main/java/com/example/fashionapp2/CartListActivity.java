package com.example.fashionapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.fashionapp2.Adapter.CardListAdapter;
import com.example.fashionapp2.Helper.ManagementCart;
import com.example.fashionapp2.Interface.ChangeNumberItemsListener;

public class CartListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private  RecyclerView recyclerViewList;
    ManagementCart managementCart;
    TextView totalFeeTxt,taxTxt, deliveryTxt,totalTxt,emptyTxt;
    Button checkOut;
    double tax;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managementCart = new ManagementCart(this);

        initView();
        initList();
        calculateCard();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CardListAdapter(managementCart.getListCard(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });
        recyclerViewList.setAdapter(adapter);
        if(managementCart.getListCard().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
        }else{
            emptyTxt.setVisibility(View.GONE);
        }
    }
    private void calculateCard(){
        double percentTax=0.02;
        double delivery = 10;

        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100.0) / 100.0;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100.0) / 100.0;
        totalFeeTxt.setText("$ "+managementCart.getTotalFee());
        taxTxt.setText("$ "+tax);
        deliveryTxt.setText("$ "+delivery);
        totalTxt.setText("$ "+total);

    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerView);
        totalFeeTxt = findViewById(R.id.itemTotal);
        deliveryTxt = findViewById(R.id.delivery);
        taxTxt = findViewById(R.id.tax);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emtyTxt);
        scrollView = findViewById(R.id.scrollview);
        checkOut = findViewById(R.id.checkout);
    }
    public void toThank(View view){
        startActivity(new Intent(CartListActivity.this, Thanks.class));
    }
}