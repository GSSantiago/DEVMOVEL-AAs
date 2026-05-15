package com.aa1_wallety.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa1_wallety.compose.FinancialEntry
import com.aa1_wallety.ui.theme.*

@Composable
fun EntryCard(entry: FinancialEntry) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(40.dp).clip(CircleShape)
                        .background(if (entry.type == "Receita") GreenPrimary else GrayLight),
                    contentAlignment = Alignment.Center
                ) {
                    Text(if (entry.type == "Receita") "💰" else "🛒", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(entry.title, fontWeight = FontWeight.Bold, color = GrayText, fontSize = 16.sp)
                    Text(entry.category, color = GrayText, fontSize = 14.sp)
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                val color = if (entry.type == "Receita") GreenIncome else RedPrimary
                val signal = if (entry.type == "Receita") "+" else "-"
                val formattedAmount = String.format("%.2f", entry.amount).replace(".", ",")

                Text("$signal R$ $formattedAmount", color = color, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(entry.date, color = GrayText, fontSize = 14.sp)
            }
        }
    }
}