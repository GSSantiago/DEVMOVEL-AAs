package com.example.placarbasquete;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class PlacarViewModel extends ViewModel{
    private final MutableLiveData<Integer> pontuacaoEsquerdo = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> pontuacaoDireito = new MutableLiveData<>(0);

    public LiveData<Integer> getPontuacaoEsquerdo() {
        return pontuacaoEsquerdo;
    }

    public LiveData<Integer> getPontuacaoDireito() {
        return pontuacaoDireito;
    }

    public void addPoints(String time, int pontuacao) {
        if("esquerdo".equals(time)) {
            int lastPontuacao = pontuacaoEsquerdo.getValue() != null ? pontuacaoEsquerdo.getValue() : 0;
            int newValue = lastPontuacao + pontuacao;
            pontuacaoEsquerdo.setValue(newValue);
        }
        else {
            int lastPontuacao = pontuacaoDireito.getValue() != null ? pontuacaoDireito.getValue() : 0;
            int newValue = lastPontuacao+ pontuacao;
            pontuacaoDireito.setValue(newValue);
        }
     }
}
