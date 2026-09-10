package br.edu.ifsp.scl.sc304775x.navigationintent.navigation

sealed class Screen(val route: String) {
    object IntentScrenn: Screen("intent_screen")
    object ParameterScreen: Screen("parameter_screen")
}

