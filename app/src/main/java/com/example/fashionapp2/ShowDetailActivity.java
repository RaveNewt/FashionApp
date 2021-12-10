package com.example.fashionapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fashionapp2.Domain.FashionDomain;
import com.example.fashionapp2.Helper.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity {
    Button addToCartButton;
    TextView descriptionTxt, titleTxt, numberOrdertxt, feeTxt;
    ImageView plus, min, picFashion, backToBtn;
    FashionDomain object;
    int numberOrder = 1;
    ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart = new ManagementCart(this);

        backToBtn = findViewById(R.id.backToBtn);
        backToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        
        initView();
        getBundle();
    }

    private void getBundle() {
        object =(FashionDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable", this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(picFashion);
        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrdertxt.setText(String.valueOf(numberOrder));

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder +1 ;
                numberOrdertxt.setText(String.valueOf(numberOrder));
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder - 1 ;
                numberOrdertxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCard(numberOrder);
                managementCart.insertFashion(object);
            }
        });
    }

    private void initView() {
        addToCartButton = findViewById(R.id.addToCartBtn);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        titleTxt = findViewById(R.id.titleTxt);
        numberOrdertxt = findViewById(R.id.numberOrderTxt);
        feeTxt = findViewById(R.id.feeTxt);
        plus = findViewById(R.id.plus);
        min = findViewById(R.id.min);
        picFashion = findViewById(R.id.picFashion);
    }
}