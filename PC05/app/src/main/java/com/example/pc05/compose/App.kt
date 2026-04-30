package com.example.pc05.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pc05.MainViewModel

@Composable
fun App() {
    val viewModel: MainViewModel = viewModel(factory = AppViewModelProvider.Factory)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { if (viewModel.offset >= 20) viewModel.buscarPokemons(viewModel.offset - 20) },
                enabled = viewModel.offset >= 20
            ) {
                Text("Anterior")
            }

            Button(
                onClick = { viewModel.buscarPokemons(viewModel.offset + 20) }
            ) {
                Text("Próxima")
            }
        }

        Text(
            text = "Página Atual (Offset): ${viewModel.offset}",
            modifier = Modifier.padding(vertical = 16.dp)
        )


        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(viewModel.pokemonList) { pokemon ->
                Text(
                    text = "- ${pokemon.name}",
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}