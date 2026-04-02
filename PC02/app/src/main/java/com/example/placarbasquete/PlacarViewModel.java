package com.example.placarbasquete;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class PlacarViewModel extends ViewModel{
    private final MutableLiveData<Integer> pontuacaoEsquerdo = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> pontuacaoDireito = new MutableLiveData<>(0);

    private final MutableLiveData<Boolean> habilitarDesfazer = new MutableLiveData<>(false);

    private String ultimoTime = null;
    private int ultimosPontos = 0;

    public LiveData<Integer> getPontuacaoEsquerdo() {
        return pontuacaoEsquerdo;
    }

    public LiveData<Integer> getPontuacaoDireito() {
        return pontuacaoDireito;
    }

    public LiveData<Boolean> getDesfazerLance() {
        return habilitarDesfazer;
    }

    public void addPoints(String time, int pontuacao) {
        ultimoTime = time;
        ultimosPontos = pontuacao;
        habilitarDesfazer.setValue(true);

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

    public void desfazerLance() {
        if (ultimoTime == null || Boolean.FALSE.equals(habilitarDesfazer.getValue())) {
            return;
        }

        if ("esquerdo".equals(ultimoTime)) {
            int lastPontuacao = pontuacaoEsquerdo.getValue() != null ? pontuacaoEsquerdo.getValue() : 0;
            pontuacaoEsquerdo.setValue(lastPontuacao - ultimosPontos);
        } else {
            int lastPontuacao = pontuacaoDireito.getValue() != null ? pontuacaoDireito.getValue() : 0;
            pontuacaoDireito.setValue(lastPontuacao - ultimosPontos);
        }

        habilitarDesfazer.setValue(false);
        ultimoTime = null;
        ultimosPontos = 0;
    }
}
