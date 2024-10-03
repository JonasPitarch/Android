package com.example.contador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.contador.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Integer vidap1;
    private Integer pocionp1;
    private Integer vidap2;
    private Integer pocionp2;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vidap1=20;
        pocionp1 =0;
        vidap2=20;
        pocionp2=0;
        if (savedInstanceState!=null){
            savedInstanceState.getInt("vidap1", vidap1);
            savedInstanceState.getInt("pocionp1", pocionp1);
            savedInstanceState.getInt("vidap2", vidap2);
            savedInstanceState.getInt("pocionp2", pocionp2);
        }
        binding.vidap1.setOnClickListener(view1 -> {
            vidap1++;
            ref();
        });
        binding.menvidap1.setOnClickListener(view1 ->{
            vidap1--;
            ref();
        });
        binding.Masvidp2.setOnClickListener(view1 -> {
            vidap2 ++;
            more();
        });
        binding.Menosvidp2.setOnClickListener(view1 -> {
            vidap2--;
            more();
        });
        binding.vidapas1.setOnClickListener(view1 -> {
            vidap2--;
            vidap1++;
            ref();
            more();
        });
        binding.vidapas2.setOnClickListener(view1 -> {
            vidap1--;
            vidap2 ++;
            ref();
            more();
        });
    }
    private void ref(){
        binding.CounterTextp1.setText(vidap1 + "/" + pocionp1);
    }
    private void more(){
        binding.Textop2.setText(vidap2 + "/" + pocionp2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("vidap1",vidap1);
        outState.putInt("pocionp1",pocionp1);
        outState.putInt("vidap2",vidap2);
        outState.putInt("pocionp2",pocionp2);
    }
}