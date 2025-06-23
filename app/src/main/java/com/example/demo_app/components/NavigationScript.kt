package com.example.demo_app.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.demo_app.components.MainScreen
import com.example.demo_app.components.AuthScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.rpc.context.AttributeContext.Auth

@Composable
fun NavigationScript(navController: NavHostController, currentUser: FirebaseUser?){
    NavHost(navController = navController,
        startDestination = if (currentUser != null){ "home"} else{ "login"}){
        composable(route= "login"){
            AuthScreen(navController,auth = Firebase.auth, onSignedIn = {})
        }
        composable("signup"){
            AuthScreen(navController, auth = Firebase.auth, onSignedIn = {})
        }
        composable(route = "home"){
            MainScreen(currentUser, onSignOut = {})
        }
        composable(route = "enter"){
            SplashScreen{}
        }
    }
}