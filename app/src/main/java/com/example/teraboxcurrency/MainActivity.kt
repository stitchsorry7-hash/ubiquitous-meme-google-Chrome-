package com.example.teraboxcurrency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); setContent { CurrencyScreen() } }
}

@Composable
fun CurrencyScreen() {
 var amount by remember { mutableStateOf("100") }
 var rate by remember { mutableStateOf("35.00") }
 Column(Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
  Text("💱 Currency", style = MaterialTheme.typography.headlineMedium)
  OutlinedTextField(amount, { amount = it }, label = { Text("จำนวนเงิน") })
  OutlinedTextField(rate, { rate = it }, label = { Text("อัตราแลกเปลี่ยน") })
  val result = (amount.toDoubleOrNull() ?: 0.0) * (rate.toDoubleOrNull() ?: 0.0)
  Text("ผลลัพธ์: %.2f".format(result), style = MaterialTheme.typography.titleLarge)
  Text("Cloud storage: TeraBox adapter พร้อมสำหรับการเชื่อมต่อ API อย่างเป็นทางการ")
 }
}
