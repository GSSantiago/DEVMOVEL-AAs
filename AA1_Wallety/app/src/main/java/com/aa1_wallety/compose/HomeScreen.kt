package com.aa1_wallety.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
            BalanceCard(viewModel)

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
                    onClick = { viewModel.openDialog() },
                    colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Adicionar entrada", color = White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(viewModel.entries) { entry ->
                    EntryCard(entry = entry)
                }
            }
        }
        if (viewModel.showAddEntryDialog) {
            AddEntryModal(
                onDismiss = { viewModel.closeDialog() },
                onSave = { title, amountStr, isExpense, category, date, desc ->
                    val amountDouble = amountStr.replace(Regex("[^0-9,]"), "").replace(",", ".").toDoubleOrNull() ?: 0.0

                    viewModel.addEntry(
                        title = title,
                        amount = amountDouble,
                        isExpense = isExpense,
                        category = category,
                        date = date,
                        description = desc
                    )
                }
            )
        }
    }
}

@Composable
fun BalanceCard(viewModel: WalletyViewModel) {
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
            Text(viewModel.balanceFormated, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = GrayText)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Entradas", color = GrayText, fontSize = 14.sp)
                    Text(viewModel.incomeFormated, color = GreenIncome, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Column {
                    Text("Gastos", color = GrayText, fontSize = 14.sp)
                    Text(viewModel.expenseFormated, color = RedPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
    }
}