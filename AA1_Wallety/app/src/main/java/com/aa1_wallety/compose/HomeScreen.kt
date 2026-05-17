package com.aa1_wallety.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa1_wallety.compose.components.AddEntryModal
import com.aa1_wallety.compose.components.EntryCard
import com.aa1_wallety.compose.components.BottomNavigation
import com.aa1_wallety.ui.theme.*

@Composable
fun HomeScreen(
    viewModel: WalletyViewModel,
    onNavigateToFamily: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    val entries by viewModel.entries.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = GreenBackground,
        bottomBar = {
            BottomNavigation(
                currentRoute = "home",
                onNavigateToFamily = onNavigateToFamily,
                onNavigateToHome = {},
                onNavigateToLogin = onNavigateToLogin
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            BalanceCard()

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Últimas entradas",
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Button(
                    onClick = { showDialog = true },
                    colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Adicionar entrada", color = White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(entries) { entry ->
                    EntryCard(entry = entry)
                }
            }
        }
        if (showDialog) {
            AddEntryModal(
                onDismiss = { showDialog = false },
                onSave = {
                    println("Oii")
                }
            )
        }
    }
}

@Composable
fun BalanceCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("Olá,", color = GrayText, fontSize = 14.sp)
            Text("Roberto!", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = GrayText)

            Spacer(modifier = Modifier.height(16.dp))

            Text("Saldo total", color = GrayText, fontSize = 14.sp)
            Text("R$ 5.268,59", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = GrayText)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Entradas", color = GrayText, fontSize = 14.sp)
                    Text("R$ 8.100,00", color = GreenIncome, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Column {
                    Text("Gastos", color = GrayText, fontSize = 14.sp)
                    Text("R$ 2.813,41", color = RedPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
    }
}