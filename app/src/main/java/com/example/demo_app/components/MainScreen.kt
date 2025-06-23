package com.example.demo_app.components

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.demo_app.R
import com.example.demo_app.User
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun MainScreen(user: FirebaseUser?, onSignOut: () -> Unit) {
    val userProfile = remember { mutableStateOf<User?>(null) }
    val navController = rememberNavController()
    val brush = Brush.horizontalGradient(
        colors = listOf(Color(0xFFFFA726), Color(0xFFFF5722))
    )



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(50.dp)
                    .border(2.dp, brush, RoundedCornerShape(50)),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {}
            Spacer(modifier = Modifier.fillMaxWidth(.01f))
            Text(text = "Welcome, ", fontSize = 40.sp)
            Spacer(modifier = Modifier.fillMaxWidth(.6f))
            IconButton(onClick = { /* Settings page */ }) {
                Icon(
                    imageVector = Icons.Default.Settings, contentDescription = "Settings",
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
        Spacer(modifier = Modifier.fillMaxHeight(.05f))
        Row(
            modifier = Modifier.fillMaxWidth(.8f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(text = "Name", fontSize = 25.sp, modifier = Modifier.padding(5.dp))
                Text(text = "email", fontSize = 13.sp)
            }

                Spacer(modifier = Modifier.fillMaxWidth(.4f))
                IconButton(onClick = { /*Edit details*/ }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Button",
                        modifier = Modifier.size(24.dp))
                }


        }
        Spacer(modifier = Modifier.fillMaxHeight(.1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_bookmark_border_24),
                contentDescription = "Wishlist",
                modifier = Modifier
                    .size(50.dp)
                    .padding(vertical = 12.dp),
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.fillMaxWidth(.1f))
            Text(text = "Wishlist", fontSize = 25.sp, fontWeight = FontWeight.W300)
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.fillMaxHeight(.1f))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_school_24),
                contentDescription = "Certificate",
                modifier = Modifier
                    .size(50.dp)
                    .padding(vertical = 12.dp),
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.fillMaxWidth(.1f))
            Text(text = "Certificate", fontSize = 25.sp, fontWeight = FontWeight.W300)
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.fillMaxHeight(.1f))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Share, contentDescription = "refer and earn",
                modifier = Modifier
                    .size(50.dp)
                    .padding(vertical = 12.dp),
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.fillMaxWidth(.1f))
            Text(text = "Refer and Earn", fontSize = 25.sp, fontWeight = FontWeight.W300)
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.fillMaxHeight(.1f))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Settings, contentDescription = "Settings",
                modifier = Modifier
                    .size(50.dp)
                    .padding(vertical = 12.dp),
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.fillMaxWidth(.1f))
            Text(text = "Settings", fontSize = 25.sp, fontWeight = FontWeight.W300)
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.fillMaxHeight(.2f))
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Logout", fontSize = 3.sp, fontWeight = FontWeight.W100,
                    modifier = Modifier.padding(4.dp), style = TextStyle(brush)
                )
                IconButton(onClick = { onSignOut.invoke() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_logout_24),
                        contentDescription = "Logout",
                        tint = Color.Yellow,
                        modifier = Modifier.size(10.dp)
                    )
                }

            }
        }



    }
    var paddingVal  = PaddingValues(4.dp)
    Scaffold(
        modifier = Modifier.background(brush),
        bottomBar = {
            BottomNavBar(navController = navController, padding = paddingVal)
        }

    ) {
        paddingVal = it
    }


    }

