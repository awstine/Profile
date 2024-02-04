@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.profilescreen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilescreen.ui.theme.ProfileScreenTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    image()
                }
            }
        }
    }

    @Composable
    fun image() {
        var presses by remember { mutableIntStateOf(0) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Profile")
                    }
                )
            },
        ) { innerPadding ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
                .size(200.dp),
                //elevation= 5.dp,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.boy),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .border(
                                BorderStroke(5.dp, Color.Cyan),
                                CircleShape
                            )
                            .size(200.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Austine Jesse",
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Android Developer",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 15.sp,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row() {
                        // Add your icons here
                        Icon(imageVector = Icons.Default.Email, contentDescription = null)
                        Text(text = "awstinejessy@gmail.com")
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                Row(){
                   Icon(imageVector = Icons.Default.Call, contentDescription = null)
                    Text(text = "0700 000 000")
                }

                    Spacer(modifier = Modifier.height(16.dp))

                    viewProfile()

                }
            }
        }
    }


    @Composable
    fun viewProfile() {
        val context = LocalContext.current
        Column(
            content = {
                Button(onClick = {
                    Toast.makeText(
                        context,
                        "You viewed my Profile",
                        Toast.LENGTH_SHORT
                    ).show()
                }, content = {
                    Text(text = "View Profile")
                },
                    )
            }, modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
    }

    @Composable
    fun Details() {
        Card(
            modifier = Modifier
                .background(Color.Black),
        ) {
            Text(text = "srhukfgsrhjk")

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ProfileScreenTheme {
            image()
        }
    }
}

