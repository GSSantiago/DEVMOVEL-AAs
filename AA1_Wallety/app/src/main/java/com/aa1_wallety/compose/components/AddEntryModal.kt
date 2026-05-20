package com.aa1_wallety.compose.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aa1_wallety.compose.AddEntryModalViewModel
import com.aa1_wallety.ui.theme.*
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEntryModal(
    onDismiss: () -> Unit,
    onSave: (String, String, Boolean, String, String, String) -> Unit,
    viewModel: AddEntryModalViewModel = viewModel()
) {
    val datePickerState = rememberDatePickerState()

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Adicionar Entrada", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = GrayText)
                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Fechar")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                        onClick = { viewModel.setTransactionType(true) },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (viewModel.isExpense) RedPrimary else GrayLight
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Despesa", color = if (viewModel.isExpense) White else GrayText)
                    }
                    Button(
                        onClick = { viewModel.setTransactionType(false) },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!viewModel.isExpense) GreenPrimary else GrayLight
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Receita", color = if (!viewModel.isExpense) White else GrayText)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = viewModel.title,
                    onValueChange = { viewModel.title = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = viewModel.amount,
                    onValueChange = { viewModel.updateAmount(it) },
                    label = { Text("Valor (R$)") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(8.dp))

                ExposedDropdownMenuBox(
                    expanded = viewModel.expanded,
                    onExpandedChange = { viewModel.expanded = !viewModel.expanded }
                ) {
                    OutlinedTextField(
                        value = viewModel.category,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Categoria") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = viewModel.expanded) },
                        modifier = Modifier.menuAnchor(type = MenuAnchorType.PrimaryNotEditable).fillMaxWidth(),
                    )
                    ExposedDropdownMenu(
                        expanded = viewModel.expanded,
                        onDismissRequest = { viewModel.expanded = false }
                    ) {
                        viewModel.categories.forEach { item ->
                            DropdownMenuItem(
                                text = { Text(item) },
                                onClick = {
                                    viewModel.category = item
                                    viewModel.expanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = viewModel.date,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Data") },
                    trailingIcon = {
                        IconButton(onClick = { viewModel.showDatePicker = true }) {
                            Icon(Icons.Default.CalendarToday, contentDescription = null)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                )

                if (viewModel.showDatePicker) {
                    DatePickerDialog(
                        onDismissRequest = { viewModel.showDatePicker = false },
                        confirmButton = {
                            TextButton(onClick = {
                                datePickerState.selectedDateMillis?.let {
                                    viewModel.date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(it))
                                }
                                viewModel.showDatePicker = false
                            }) { Text("OK", color = GreenPrimary) }
                        }
                    ) {
                        DatePicker(state = datePickerState)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = viewModel.description,
                    onValueChange = { viewModel.description = it },
                    label = { Text("Descrição") },
                    modifier = Modifier.fillMaxWidth().height(100.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        onSave(
                            viewModel.title,
                            viewModel.amount,
                            viewModel.isExpense,
                            viewModel.category,
                            viewModel.date,
                            viewModel.description
                        )
                        viewModel.resetValues()
                        onDismiss()
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Salvar Entrada", color = White, fontSize = 16.sp)
                }
            }
        }
    }
}