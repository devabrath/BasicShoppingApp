package com.example.onlineshopping.ui.AccountInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlineshopping.R;
import com.example.onlineshopping.databinding.FragmentAccountinfoBinding;
import com.example.onlineshopping.ui.home.HomeFragment;

public class AccountInfoFragment extends Fragment {

    TextView BackToHome;

    public AccountInfoFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_accountinfo,container,false);
        BackToHome = view.findViewById(R.id.BackToHome);
        BackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HomeFragment();
                FragmentTransaction transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.container_nav,fragment)
                        .commit();
            }
        });
        return view;

    }

}