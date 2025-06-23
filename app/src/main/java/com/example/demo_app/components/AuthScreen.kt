package com.example.demo_app.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.demo_app.R
import com.google.firebase.annotations.concurrent.Background
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AuthScreen(navController: NavController,onSignedIn: (FirebaseUser) -> Unit, auth: FirebaseAuth) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confPassword by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var isSignIn by remember { mutableStateOf(true) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    // State variable for error message
    var myErrorMessage by remember { mutableStateOf<String?>(null) }


    val brush = Brush.horizontalGradient(
        colors = listOf(Color(0xFFFFA726), Color(0xFFFF5722))
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)


    ) {
        Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo",
                        modifier = Modifier
                            .size(380.dp)
                            )

                    // First Name TextField
                    if (!isSignIn) {
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = firstName,
                            onValueChange = { firstName = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 16.dp)
                                .background(color = Color.White)
                                .shadow(elevation = 4.dp),
                            label = {
                                Text("First Name")
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.LightGray,
                                unfocusedBorderColor = Color.White
                            )
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Last Name TextField
                        androidx.compose.material3.OutlinedTextField(
                            value = lastName,
                            onValueChange = { lastName = it },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.LightGray,
                                unfocusedBorderColor = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 16.dp)
                                .background(color = Color.White)
                                .shadow(elevation = 4.dp),
                            label = {
                                Text("Last Name")
                            }

                        )
                    }

                    // Email TextField
                    Spacer(modifier = Modifier.height(16.dp))
                    androidx.compose.material3.OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .background(color = Color.White)
                            .shadow(elevation = 4.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.LightGray,
                            unfocusedBorderColor = Color.White
                        ),
                        label = {
                            Text("Email")
                        },

                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Email
                        ),
                        visualTransformation = if (isSignIn) VisualTransformation.None else VisualTransformation.None
                    )

                    // Password TextField
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.LightGray,
                            unfocusedBorderColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                            .shadow(elevation = 4.dp),
                        label = {
                            Text("Password")
                        },
                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password
                        ),
                        trailingIcon = {
                            IconButton(
                                onClick = { isPasswordVisible = !isPasswordVisible }
                            ) {
                                val icon = if (isPasswordVisible) Icons.Default.Lock else Icons.Default.Search
                                Icon(
                                    imageVector = icon,
                                    contentDescription = "Toggle Password Visibility"
                                )
                            }
                        }
                    )
                    if(!isSignIn){
                        Spacer(modifier = Modifier.height(8.dp))
                        androidx.compose.material3.OutlinedTextField(
                            value = confPassword,
                            onValueChange = { confPassword = it },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.LightGray,
                                unfocusedBorderColor = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 16.dp)
                                .background(color = Color.White)
                                .shadow(elevation = 4.dp),
                            label = {
                                Text("Confirm Password")
                            },
                            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Password
                            ),
                            trailingIcon = {
                                IconButton(
                                    onClick = { isPasswordVisible = !isPasswordVisible }
                                ) {
                                    val icon = if (isPasswordVisible) Icons.Default.Lock else Icons.Default.Search
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = "Toggle Password Visibility"
                                    )
                                }
                            }
                        )
                    }

                    // ... (other content)
                    Spacer(modifier = Modifier.height(16.dp))

                    // Error Message
                    if (myErrorMessage != null) {
                        Text(
                            text = myErrorMessage!!,
                            color = Color.Red,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Sign In/Sign Up Buttons
                    Button(
                        onClick = {
                            if (isSignIn) {
                                signIn(auth, email, password,
                                    onSignedIn = { signedInUser: FirebaseUser ->
                                        onSignedIn(signedInUser)
                                    },
                                    onSignInError = { errorMessage: String ->
                                        // Show toast message on sign-in error
                                        myErrorMessage = errorMessage
                                    },
                                    navController = navController
                                )
                            } else {
                                signUp(auth, email, password, firstName, lastName, { signedInUser: FirebaseUser ->
                                    onSignedIn(signedInUser)
                                }, navController)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(.8f)
                            .height(60.dp)
                            .padding(2.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)



                    ) {
                        Text(
                            text = if (isSignIn) "Sign In" else "Sign Up",
                            fontSize = 18.sp,
                        )
                    }


                    // Clickable Text
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(8.dp),
                    ) {
                        ClickableText(
                            text = AnnotatedString(buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color.Blue)) {
                                    append(if (isSignIn) "Don't have an account? Sign Up" else "Already have an account? Sign In")
                                }
                            }.toString()),
                            onClick = {
                                myErrorMessage = null
                                email = ""
                                password = ""
                                isSignIn = !isSignIn
                            },
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
            Spacer(modifier = Modifier.height(180.dp))
                }

            }
}




