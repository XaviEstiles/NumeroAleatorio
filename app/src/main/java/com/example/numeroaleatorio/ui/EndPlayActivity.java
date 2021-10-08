package com.example.numeroaleatorio.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.numeroaleatorio.R;
import com.example.numeroaleatorio.data.model.User;
import com.example.numeroaleatorio.databinding.ActivityEndPlayBinding;

public class EndPlayActivity extends AppCompatActivity {
    ActivityEndPlayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEndPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        User user = (User) getIntent().getExtras().getSerializable("user");
        if(user.isWin()){
            binding.tvNumAlt.setText(user.getName().toString()+" has ganado el numero es "+user.getNumAleatorio());
        }else{
            binding.tvNumAlt.setText(user.getName().toString()+" has perdido el numero es "+user.getNumAleatorio());
        }
        binding.tvIntentos.setText("Intentos restantes: "+user.getIntentos());
    }
}