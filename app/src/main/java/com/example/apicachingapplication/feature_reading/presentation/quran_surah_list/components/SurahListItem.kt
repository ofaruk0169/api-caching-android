package com.example.apicachingapplication.feature_reading.presentation.quran_surah_list.components

import android.R.attr.checked
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apicachingapplication.feature_reading.domain.model.Surah

@Composable
fun SurahListItem(
    surah: Surah,
    onItemClick: (Surah) -> Unit
) {
    Row(
      modifier = Modifier
          .fillMaxWidth()
          .clickable { onItemClick(surah) }
          .padding(
              start = 30.dp,

          ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "${surah.surahNumber}",
            fontSize = 18.sp,
            color = Color(199, 104, 2),
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier
            .width(30.dp))
        Text(
            text = "${surah.surahName}",
            fontSize = 18.sp,
            color = Color(199, 104, 2),
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier
            .width(30.dp))

        Checkbox(
            checked = true,
            onCheckedChange = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SurahListItemPreview() {
    Column {
        SurahListItem(
            surah = Surah(surahName = "Al-Fatiha", totalAyah = 7, surahNumber = 1),
            onItemClick = {}
        )
        SurahListItem(
            surah = Surah(surahName = "Al-Baqarah", totalAyah = 286, surahNumber = 2),
            onItemClick = {}
        )
    }
}