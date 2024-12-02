package br.com.victor.dev.apenasnavigation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import br.com.victor.dev.apenasnavigation.ui.screen.auth.forgot.ForgotPasswordScreen
import br.com.victor.dev.apenasnavigation.ui.screen.auth.login.LoginScreen
import br.com.victor.dev.apenasnavigation.ui.screen.auth.singUp.SingUpScreen
import br.com.victor.dev.apenasnavigation.ui.screen.details.disclaimer.DisclaimerScreen
import br.com.victor.dev.apenasnavigation.ui.screen.details.faq.FaqScreen
import br.com.victor.dev.apenasnavigation.ui.screen.details.help.HelpScreen
import br.com.victor.dev.apenasnavigation.ui.screen.home.HomeScreen
import br.com.victor.dev.apenasnavigation.ui.screen.home.HomeViewContent
import br.com.victor.dev.apenasnavigation.ui.screen.profile.ProfileScreen
import br.com.victor.dev.apenasnavigation.ui.screen.settings.SettingsScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = AppGraph.initial.ROOT,
        startDestination = AppGraph.auth.ROOT
    ) {
        authNavGraph(navController = navController)
        composable(route = AppGraph.home.ROOT) {
            HomeViewContent()
        }
    }
}

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = AppGraph.auth.ROOT,
        startDestination = AppGraph.auth.LOGIN
    ) {
        composable(route = AppGraph.auth.LOGIN) {
            LoginScreen(
                onLoginClick = {
                    navController.popBackStack()
                    navController.navigate(AppGraph.home.ROOT)
                },
                onSingUpClick = {
                    navController.navigate(AppGraph.auth.SIGN_UP)
                },
                onForgotClick = {
                    navController.navigate(AppGraph.auth.FORGOT_PASSWORD)
                }
            )
        }
        composable(route = AppGraph.auth.SIGN_UP) {
            SingUpScreen(onSingUpClick = {})
        }
        composable(route = AppGraph.auth.FORGOT_PASSWORD) {
            ForgotPasswordScreen(onForgotPasswordClick = {})
        }
    }
}

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = AppGraph.home.ROOT,
        startDestination = AppGraph.home.HOME
    ) {
        composable(route = AppGraph.home.HOME) {
            HomeScreen(
                onHomeClick = {
                    navController.navigate(AppGraph.details.ROOT)
                }
            )
        }
        composable(route = AppGraph.home.PROFILE) {
            ProfileScreen(
                onProfileClick = {}
            )
        }
        composable(route = AppGraph.home.SETTINGS) {
            SettingsScreen(
                onSettingsClick = {}
            )
        }
        detailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = AppGraph.details.ROOT,
        startDestination = AppGraph.details.HELP
    ) {
        composable(route = AppGraph.details.HELP){
            HelpScreen() {
                navController.navigate(AppGraph.details.DISCLAIMER)
            }
        }
        composable(route = AppGraph.details.DISCLAIMER){
            DisclaimerScreen() {
                navController.navigate(AppGraph.details.FAQ)
            }
        }
        composable(route = AppGraph.details.FAQ){
            FaqScreen() {
                navController.popBackStack(
                    route = AppGraph.details.FAQ,
                    inclusive = false
                )
            }
        }
    }
}
