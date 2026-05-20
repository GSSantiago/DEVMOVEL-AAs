package com.aa1_wallety.compose

import androidx.compose.ui.res.stringResource
import com.aa1_wallety.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
    viewModel: FamilyViewModel,
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
            FamilyBalanceCard(viewModel = viewModel)

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(id = R.string.family_last_entry) ,
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(viewModel.entries) { familyEntry ->
                    EntryCard(entry = familyEntry)
                }
            }
        }
    }
}

@Composable
fun FamilyBalanceCard(viewModel: FamilyViewModel) {
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
                    Text(stringResource(id = R.string.family_balance), color = GrayText, fontSize = 14.sp)
                    Text(stringResource(id = R.string.user_family), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = GrayText)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(stringResource(id = R.string.total_balance), color = GrayText, fontSize = 14.sp)
            Text(viewModel.totalBalanceFormated, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = GrayText)

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = GrayLight)
            Spacer(modifier = Modifier.height(16.dp))

            Text(stringResource(id = R.string.family_total), color = GrayText, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(id = R.string.income), color = GrayText, fontSize = 14.sp)
                    Text(viewModel.familyIncomeFormated, color = GreenIncome, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(id = R.string.expense), color = GrayText, fontSize = 14.sp)
                    Text(viewModel.familyExpenseFormated, color = RedPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(stringResource(id = R.string.family_contribuition), color = GrayText, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(id = R.string.income), color = GrayText, fontSize = 14.sp)
                    Text(viewModel.myIncomeFormated, color = GreenIncome, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(id = R.string.expense), color = GrayText, fontSize = 14.sp)
                    Text(viewModel.myExpenseFormated, color = RedPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
    }
}