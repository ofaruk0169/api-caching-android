package com.example.apicachingapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.CloudQueue
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apicachingapplication.core.ui.theme.APICachingApplicationTheme
import com.example.apicachingapplication.feature_reading.presentation.Screen
import com.example.apicachingapplication.feature_reading.presentation.quran_reader.SurahDetailScreen
import com.example.apicachingapplication.feature_reading.presentation.quran_surah_list.SurahListScreen
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.apicachingapplication.feature_reading.presentation.TextSizeViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            APICachingApplicationTheme {
                val navController = rememberNavController()
                var cacheAction by remember { mutableStateOf<() -> Unit>({}) }
                var isCurrentSurahCached by remember { mutableStateOf(false) }
                var cacheAllAction by remember { mutableStateOf<() -> Unit>({}) }
                var isAllSurahsCached by remember { mutableStateOf(false) }

                val textSizeViewModel: TextSizeViewModel = hiltViewModel()
                val textSizeState by textSizeViewModel.textsize

                Box{
                    Image(
                        painter = painterResource(R.drawable.app_background),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),
                        containerColor = Color.Transparent,
                        topBar = {
                            CenterAlignedTopAppBar(
                                modifier = Modifier.padding(bottom = 20.dp),
                                navigationIcon = {
                                    IconButton(onClick = { }) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "Menu",
                                            tint = Color(0xFFc9d1c7),
                                            modifier = Modifier.size(30.dp)
                                        )
                                    }
                                },
                                title = {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                    ) {
                                        Text(
                                            text = "The Noble Quran",
                                            color = Color(0xFFc9d1c7),
                                            fontWeight = FontWeight.Bold,
                                            style = MaterialTheme.typography.headlineLarge
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "KS Studio",
                                            color = Color(0xFFc9d1c7),
                                            fontWeight = FontWeight.Bold,
                                            style = MaterialTheme.typography.titleMedium
                                        )
                                        Spacer(modifier = Modifier.height(20.dp))
                                    }
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(
                                    containerColor = Color.Transparent
                                )
                            )
                        },

                        bottomBar = {

                            val backStackEntryState = navController.currentBackStackEntryAsState()
                            val currentRoute = backStackEntryState.value?.destination?.route

                            BottomAppBar(
                                containerColor = Color.Transparent,
                                contentColor = Color(0xFFF5EBDD),
                                modifier = Modifier
                                    .border(
                                        BorderStroke(
                                            width = 1.dp,
                                            color = Color(0xFFF5EBDD),
                                        ),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                            ) {

                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {

                                    //getting current screen from the backstack in order to dynamically change bottom bar download button

                                    when (currentRoute) {
                                        Screen.SurahListScreen.route -> {

                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
                                                verticalAlignment = Alignment.CenterVertically,
                                            ) {
                                                FilledIconButton(
                                                    onClick = { cacheAllAction() },
                                                    modifier = Modifier
                                                        .size(48.dp),
                                                ) {
                                                    Icon(
                                                        imageVector = if (isAllSurahsCached) Icons.Default.CheckCircle else Icons.Default.Download,
                                                        contentDescription = "Cache all surahs"
                                                    )
                                                }

                                                //size buttons below

                                                FilledIconButton(
                                                    onClick = { textSizeViewModel.decreaseTextSize() },
                                                    modifier = Modifier
                                                        .size(48.dp),
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Default.Remove,
                                                        contentDescription = "Decrease Text Size"
                                                    )
                                                }

                                                FilledIconButton(
                                                    onClick = { textSizeViewModel.increaseTextSize() },
                                                    modifier = Modifier
                                                        .size(48.dp),
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Default.Add ,
                                                        contentDescription = "Increase Text Size"
                                                    )
                                                }

                                            }

                                        }
                                        Screen.SurahDetailScreen.route + "/{surahId}" -> {

                                            FilledIconButton(
                                                onClick = { cacheAction() },
                                                modifier = Modifier
                                                    .size(48.dp),
                                            ) {
                                                Icon(
                                                   // imageVector = Icons.Default.Download,
                                                    imageVector = if (isCurrentSurahCached) Icons.Default.CheckCircle else Icons.Default.Download,
                                                    contentDescription = "Cache Current Surahs"
                                                )
                                            }

                                            FilledIconButton(
                                                onClick = { cacheAction() },
                                                modifier = Modifier
                                                    .size(48.dp),
                                            ) {
                                                Icon(
                                                    // imageVector = Icons.Default.Download,
                                                    imageVector = if (isCurrentSurahCached) Icons.Default.CheckCircle else Icons.Default.Download,
                                                    contentDescription = "Cache Current Surahs"
                                                )
                                            }


                                        }
                                        else -> {}
                                    }
                                }
                            }
                        }

                    ) { paddingValues ->
                        NavHost(
                            modifier = Modifier.padding(paddingValues),
                            navController = navController,
                            startDestination = Screen.SurahListScreen.route
                        ) {
                            composable(
                                route = Screen.SurahListScreen.route
                            ) {
                                SurahListScreen(
                                    navController,
                                    textSize = textSizeState.textSize,
                                    registerAction = { action -> cacheAllAction = action },
                                    onCacheStatusChanged = { cached -> isAllSurahsCached = cached }
                                )
                            }
                            composable(
                                route = Screen.SurahDetailScreen.route + "/{surahId}"
                            ) {
                                SurahDetailScreen(
                                    registerAction = { action -> cacheAction = action },
                                    onCacheStatusChanged = { cached -> isCurrentSurahCached = cached }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    APICachingApplicationTheme {
        Greeting("Android")
    }
}