package com.aa1_wallety.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa1_wallety.compose.components.EntryCard
import com.aa1_wallety.compose.components.BottomNavigation
import com.aa1_wallety.ui.theme.*

@Composable
fun FamilyScreen(
    viewModel: WalletyViewModel,
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    Scaffold(
        containerColor = GreenBackground,
        bottomBar = {
            BottomNavigation(
                currentRoute = "family",
                onNavigateToFamily = {},
                onNavigateToHome = onNavigateToHome,
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
            FamilyBalanceCard()

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Últimas entradas da Família",
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(viewModel.entries) { entry ->
                    EntryCard(entry = entry)
                }
            }
        }
    }
}

@Composable
fun FamilyBalanceCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    shape = CircleShape,
                    color = GreenPrimary
                ) {}

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text("Balanço da família", color = GrayText, fontSize = 14.sp)
                    Text("Oliveira", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = GrayText)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Saldo total", color = GrayText, fontSize = 14.sp)
            Text("R$ 10.047,69", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = GrayText)

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = GrayLight)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Total da Família", color = GrayText, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Entradas", color = GrayText, fontSize = 14.sp)
                    Text("R$ 14.450,00", color = GreenIncome, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("Gastos", color = GrayText, fontSize = 14.sp)
                    Text("R$ 4.402,61", color = RedPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Sua Contribuição", color = GrayText, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Entradas", color = GrayText, fontSize = 14.sp)
                    Text("R$ 8.100,00", color = GreenIncome, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("Gastos", color = GrayText, fontSize = 14.sp)
                    Text("R$ 2.813,41", color = RedPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
    }
}