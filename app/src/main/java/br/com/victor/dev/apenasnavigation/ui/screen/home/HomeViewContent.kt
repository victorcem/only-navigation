package br.com.victor.dev.apenasnavigation.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.victor.dev.apenasnavigation.ui.navigation.HomeNavGraph
import br.com.victor.dev.apenasnavigation.util.BottomBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeViewContent (navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) },
    ) {
        HomeNavGraph(navController = navController)
    }
}