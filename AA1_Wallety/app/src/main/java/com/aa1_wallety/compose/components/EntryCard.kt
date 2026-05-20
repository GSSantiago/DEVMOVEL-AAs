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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.aa1_wallety.repository.Entry
import com.aa1_wallety.repository.FamilyEntry
import com.aa1_wallety.ui.theme.*
import java.text.NumberFormat
@Composable
fun EntryCard(entry: Entry) {
    EntryCardContent(
        title = entry.title,
        amount = entry.amount,
        isExpense = entry.isExpense,
        category = entry.category,
        date = entry.date,
        avatarUrl = null
    )
}

@Composable
fun EntryCard(entry: FamilyEntry) {
    EntryCardContent(
        title = entry.title,
        amount = entry.amount,
        isExpense = entry.isExpense,
        category = entry.category,
        date = entry.date,
        avatarUrl = entry.avatar
    )
}

@Composable
private fun EntryCardContent(
    title: String,
    amount: Double,
    isExpense: Boolean,
    category: String,
    date: String,
    avatarUrl: String?
) {
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

                if (!avatarUrl.isNullOrEmpty()) {
                    AsyncImage(
                        model = avatarUrl,
                        contentDescription = "Avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                } else {
                    Box(
                        modifier = Modifier.size(40.dp).clip(CircleShape)
                            .background(if (!isExpense) GreenPrimary else GrayLight),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(if (!isExpense) "💰" else "🛒", fontSize = 18.sp)
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(title, fontWeight = FontWeight.Bold, color = GrayText, fontSize = 16.sp)
                    Text(category, color = GrayText, fontSize = 14.sp)
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                val color = if (!isExpense) GreenIncome else RedPrimary
                val signal = if (!isExpense) "+" else "-"
                val formattedAmount = NumberFormat.getCurrencyInstance().format(amount)

                Text("$signal $formattedAmount", color = color, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(date, color = GrayText, fontSize = 14.sp)
            }
        }
    }
}