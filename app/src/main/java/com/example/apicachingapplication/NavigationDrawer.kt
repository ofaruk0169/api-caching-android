package com.example.apicachingapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apicachingapplication.feature_reading.domain.model.MenuItem

@Preview
@Composable
fun DrawerHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Paypal",
            style = TextStyle(fontSize = 30.sp)
        )
    }
}

@Composable
fun DrawerBody(
    items : List<MenuItem>,
    onMenuItemClicked: (MenuItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(items) { item ->
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title
                )
                Spacer(
                    Modifier.width(10.dp)
                )
                Text(
                    item.title,
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        }
    }
}