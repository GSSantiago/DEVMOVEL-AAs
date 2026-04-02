package com.example.placarbasquete;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.placarbasquete.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private PlacarViewModel placarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        placarViewModel = new ViewModelProvider(this).get(PlacarViewModel.class);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        placarViewModel.getPontuacaoEsquerdo().observe(this, value -> {
            binding.placarEsquerdo.setText(String.valueOf(value));
        });

        placarViewModel.getPontuacaoDireito().observe(this, value -> {
            binding.placarDireito.setText(String.valueOf(value));
        });

        placarViewModel.getDesfazerLance().observe(this, desfazerLance -> {
            binding.voltarLance.setEnabled(desfazerLance);
        });

        /* Lado esquerdo */
        binding.lanceLivreEsquerdo.setOnClickListener(v -> {
            placarViewModel.addPoints("esquerdo", 1);
        });

        binding.doisPontosEsquerdo.setOnClickListener(v -> {
            placarViewModel.addPoints("esquerdo", 2);
        });
        binding.tresPontosEsquerdo.setOnClickListener(v -> {
            placarViewModel.addPoints("esquerdo", 3);
        });

        /* Lado direito */
        binding.lanceLivreDireito.setOnClickListener(v -> {
            placarViewModel.addPoints("direito", 1);
        });

        binding.doisPontosDireito.setOnClickListener(v -> {
            placarViewModel.addPoints("direito", 2);
        });
        binding.tresPontosDireito.setOnClickListener(v -> {
            placarViewModel.addPoints("direito", 3);
        });

        /* Botãõ desfazer lance */
        binding.voltarLance.setOnClickListener(v -> {
            placarViewModel.desfazerLance();
        });

    }
}