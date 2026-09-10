package br.edu.ifsp.scl.sc304775x.navigationintent.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifsp.scl.sc304775x.navigationintent.MainViewModel
import br.edu.ifsp.scl.sc304775x.navigationintent.ui.composable.screen.IntentScreen
import br.edu.ifsp.scl.sc304775x.navigationintent.ui.composable.screen.ParameterScreen


@Composable
fun MainNavHost(navHostController: NavHostController, modifier: Modifier, mainViewModel: MainViewModel) {
    val parameter by mainViewModel.parameterState.collectAsStateWithLifecycle()

    NavHost(
        navController = navHostController,
        startDestination = Screen.IntentScrenn.route
    ) {
        composable(route = Screen.IntentScrenn.route) {
            IntentScreen(
                receivedParameter = parameter,
                modifier = modifier
            )
        }

        composable(route = Screen.ParameterScreen.route) {
            ParameterScreen(
                receivedParameter = parameter ,
                modifier = modifier,
                onSave = mainViewModel::updateParameter
            ) {
                navHostController.popBackStack()
            }

        }
    }
}