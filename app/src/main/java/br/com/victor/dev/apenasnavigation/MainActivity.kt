package br.com.victor.dev.apenasnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.com.victor.dev.apenasnavigation.ui.navigation.RootNavigationGraph
import br.com.victor.dev.apenasnavigation.ui.theme.ApenasNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApenasNavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        RootNavigationGraph(navController = rememberNavController())
                    }
                }
            }
        }
    }
}
