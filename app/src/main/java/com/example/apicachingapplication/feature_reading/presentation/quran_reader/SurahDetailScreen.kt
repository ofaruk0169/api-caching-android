package com.example.apicachingapplication.feature_reading.presentation.quran_reader

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.apicachingapplication.feature_reading.presentation.Screen
import com.example.apicachingapplication.feature_reading.presentation.quran_surah_list.SurahListViewModel
import com.example.apicachingapplication.feature_reading.presentation.quran_surah_list.components.SurahListItem

@Composable
fun SurahDetailScreen(
    viewModel: SurahDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.surah?.let { surah ->
            LazyColumn (
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    top = 20.dp,
                    start = 65.dp,
                    end = 65.dp
                )
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${surah.surahNo }" + ".",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color(0xFFD4AF37),
                            )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(
                            text = "${surah.surahName}",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color(0xFFF5EBDD),
                        )
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 1.dp,
                        color = Color(0xFFD4AF37)
                    )

                }


                items(surah.english.size) { index ->
                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = (index + 1).toString(),
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Start,
                        color = Color(0xFFD4AF37),
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = surah.arabic1[index],
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 34.sp
                        ),
                        lineHeight = 48.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFFF5EBDD),
                        modifier =
                            Modifier
                                .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = surah.english[index],
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        color = Color(0xFFF5EBDD),
                        modifier =
                            Modifier
                                .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(30.dp))



                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                        ,
                        thickness = 1.dp,
                        color = Color(0xFFD4AF37),
                    )


                }
            }
        }

        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}