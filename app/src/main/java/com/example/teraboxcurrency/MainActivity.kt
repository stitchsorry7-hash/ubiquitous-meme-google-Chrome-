package com.example.teraboxcurrency

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CurrencyScreen(::openTeraBox) }
    }

    private fun openTeraBox() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.terabox.com/")))
    }
}

@Composable
fun CurrencyScreen(openTeraBox: () -> Unit) {
    var amount by remember { mutableStateOf("100") }
    var rate by remember { mutableStateOf("35.00") }
    var base by remember { mutableStateOf("USD") }
    var target by remember { mutableStateOf("THB") }
    val result = CurrencyCalculator.convert(amount, rate)

    Column(
        Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("💱 Currency", style = MaterialTheme.typography.headlineMedium)
        Text("แปลงสกุลเงิน", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("จำนวนเงิน") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = base,
            onValueChange = { base = it.uppercase() },
            label = { Text("สกุลเงินต้นทาง") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = target,
            onValueChange = { target = it.uppercase() },
            label = { Text("สกุลเงินปลายทาง") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = rate,
            onValueChange = { rate = it },
            label = { Text("อัตราแลกเปลี่ยน") },
            modifier = Modifier.fillMaxWidth()
        )
        Text("$amount $base = $result $target", style = MaterialTheme.typography.titleLarge)
        Text("หมายเหตุ: อัตราแลกเปลี่ยนยังเป็นค่าแบบกรอกเอง จนกว่าจะตั้งค่า API ผู้ให้บริการจริง")
        Button(onClick = openTeraBox, modifier = Modifier.fillMaxWidth()) {
            Text("เปิด TeraBox")
        }
    }
}
