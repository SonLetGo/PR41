package com.sonya.pr41

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sonya.pr41.ui.theme.PR41Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("second") { SecondScreen(navController) }
        composable("third") { ThirdScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { navController.navigate("second") }) {
            Text("Перейти на второй экран")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("third") }) {
            Text("Перейти на третий экран")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("Это второй экран")
        Button(onClick = {navController.popBackStack()}) {
            Text("Назад")
        }
    }
}

@Composable
fun ThirdScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("Это третий экран")
        Button(onClick = { navController.popBackStack()}) {
            Text("Назад")
        }
    }
}
