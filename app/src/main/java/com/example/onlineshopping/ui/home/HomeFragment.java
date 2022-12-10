package com.example.onlineshopping.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<Data> dataArrayList;
    private String[] prodHeading;
    private String[] prodDesc;
    private String[] price;
    private int[] imageResourceID;
    private RecyclerView recyclerview;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialize();
        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(getContext(), dataArrayList);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    private void dataInitialize(){

        dataArrayList = new ArrayList<>();

        prodHeading = new String[]{"Classmate Books","Women Ethic Wear","Lovely Bottles","Wall Decor Item", "Stationary Kit"};

        imageResourceID = new int[]{R.drawable.book,R.drawable.dress,R.drawable.bottle,R.drawable.decor,R.drawable.stationary_kit};

        prodDesc = new String[]{"Classmate Books \nSet of 6","Semi Stitched Lehenga Choli (Red)",
                "Stylish Printed  Water Bottles Pack of 4","King Decor Wall Shelves", "Classmate \nStationary Kit Set"};

        price = new String[]{"\u20B9599","\u20B92499","\u20B9399","\u20B9349","\u20B9189"};

        for (int i=0; i< prodHeading.length; i++){

            Data data = new Data(prodHeading[i],imageResourceID[i],prodDesc[i],price[i]);
            dataArrayList.add(data);

        }

    }
}