package com.example.apicachingapplication.feature_reading.presentation.quran_surah_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
          .padding(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "${surah.surahNumber}. ${surah.surahName}",
            color = Color(199, 104, 2),
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
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