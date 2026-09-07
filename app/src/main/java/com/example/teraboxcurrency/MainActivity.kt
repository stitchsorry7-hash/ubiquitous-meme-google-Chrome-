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
    val result = CurrencyCalculator.convert(amount, rate)

    Column(
        Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("💱 Currency", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("จำนวนเงิน") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = rate,
            onValueChange = { rate = it },
            label = { Text("อัตราแลกเปลี่ยน") },
            modifier = Modifier.fillMaxWidth()
        )
        Text("ผลลัพธ์: $result", style = MaterialTheme.typography.titleLarge)
        Text("TeraBox: พร้อมสำหรับการเชื่อมต่อผ่าน Open Platform เมื่อมี API/OAuth credentials ที่ออกโดย TeraBox")
        Button(onClick = openTeraBox, modifier = Modifier.fillMaxWidth()) {
            Text("เปิด TeraBox")
        }
    }
}
