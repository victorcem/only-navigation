package br.com.victor.dev.apenasnavigation.util

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import br.com.victor.dev.apenasnavigation.R
import br.com.victor.dev.apenasnavigation.ui.navigation.AppGraph

sealed class BottomBarItemConfig(
    val route: String,
    @StringRes val title: Int,
    val icon: ImageVector
) {
    object Home : BottomBarItemConfig(
        route = AppGraph.home.HOME,
        title = R.string.bottom_bar_home,
        icon = Icons.Default.Home
    )

    object Profile : BottomBarItemConfig(
        route = AppGraph.home.PROFILE,
        title = R.string.bottom_bar_profile,
        icon = Icons.Default.Person
    )

    object Settings : BottomBarItemConfig(
        route = AppGraph.home.SETTINGS,
        title = R.string.bottom_bar_settings,
        icon = Icons.Default.Settings
    )
}

object BottomBarConfigList {
    val all = listOf(
        BottomBarItemConfig.Home,
        BottomBarItemConfig.Profile,
        BottomBarItemConfig.Settings,
    )
}

@Composable
fun BottomBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val showNavigationItems = BottomBarConfigList.all.any { it.route == currentDestination?.route }
    if (showNavigationItems) {
        NavigationBar {

            BottomBarConfigList.all.forEach { itemConfig ->
                AddItem(
                    itemConfig = itemConfig,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    itemConfig: BottomBarItemConfig,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = stringResource(id = itemConfig.title))
        },
        icon = {
            Icon(imageVector = itemConfig.icon, contentDescription = "Navigation Icon")
        },
        selected = currentDestination?.hierarchy?.any { it.route == itemConfig.route } == true,
        onClick = {
            navController.navigate(itemConfig.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}