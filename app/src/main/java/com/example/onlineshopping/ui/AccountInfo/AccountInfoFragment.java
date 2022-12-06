package com.example.onlineshopping.ui.AccountInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlineshopping.databinding.FragmentAccountinfoBinding;
import com.example.onlineshopping.databinding.FragmentAccountinfoBinding;

public class AccountInfoFragment extends Fragment {

private FragmentAccountinfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        AccountInfoViewModel accountInfoViewModel =
                new ViewModelProvider(this).get(AccountInfoViewModel.class);

    binding = FragmentAccountinfoBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textAccountInfo;
        accountInfoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}