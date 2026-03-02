package com.example.fragmentos

import android.R.attr.onClick
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fragmentos.ui.theme.FragmentosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FragmentosTheme {
                    PantallaPrincipal()
            }
        }
    }
}

@Composable
fun PantallaPrincipal(){

    var numero by remember { mutableStateOf(0) }



    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text="Clicker",
            style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        FragmentoAzul(numero=numero)

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            FragmentoVerde(onClick={numero+=1})
            FragmentoRojo(onClick={if(numero>0)numero-=1})
        }
    }
}

@Composable
fun FragmentoAzul(numero: Int){
Box(modifier = Modifier
    .size(100.dp)
    .background(Color.Blue),
    contentAlignment = Alignment.Center
)  {
Text(text=numero.toString(),
    color = Color.White,
    style = MaterialTheme.typography.headlineLarge
    )
}
}

@Composable
fun FragmentoRojo(onClick:()->Unit){
    Box(modifier = Modifier
        .size(100.dp)
        .background(Color.Red)
        .clickable{onClick()},
        contentAlignment = Alignment.Center
    ) {
            Text("-1",
                color = Color.White,
                fontSize = 30.sp)
        }
    }


@Composable
fun FragmentoVerde(onClick:()->Unit){
    Box(modifier = Modifier
        .size(100.dp)
        .background(Color.Green)
        .clickable{onClick()},
        contentAlignment = Alignment.Center
    ) {

            Text("+1", color = Color.White, fontSize = 30.sp)
        }
    }
