package com.example.fashionapp2.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.fashionapp2.Domain.FashionDomain;
import com.example.fashionapp2.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertFashion(FashionDomain item){
        ArrayList<FashionDomain> listFashion=getListCard();
        boolean existAlready =false;
        int n=0;
        for(int i=0; i< listFashion.size(); i++){
            if(listFashion.get(i).getTitle().equals(item.getTitle())){
                existAlready =true;
                n=i;
                break;
            }
        }

        if (existAlready) {
            listFashion.get(n).setNumberInCard(item.getNumberInCard());
        }else {
            listFashion.add(item);
        }
        tinyDB.putListObject("CardList", listFashion);
        Toast.makeText(context, "Added To your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FashionDomain> getListCard(){
        return tinyDB.getListObject("CardList");
    }

    public void plusNumberFashion(ArrayList<FashionDomain> listfashion, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listfashion.get(position).setNumberInCard(listfashion.get(position).getNumberInCard()+1);
        tinyDB.putListObject("CardList", listfashion);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFashion(ArrayList<FashionDomain> listfashion, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if(listfashion.get(position).getNumberInCard()==1){
            listfashion.remove(position);
        }else {
            listfashion.get(position).setNumberInCard(listfashion.get(position).getNumberInCard()-1);
        }
        tinyDB.putListObject("CardList", listfashion);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<FashionDomain> listFashion2 = getListCard();
        double fee = 0;
        for(int i =0; i<listFashion2.size(); i++){
            fee= fee+(listFashion2.get(i).getFee()*listFashion2.get(i).getNumberInCard());
        }
        return fee;
    }
}
