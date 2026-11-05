package com.example.galeria_arte

import android.R.attr.contentDescription
import android.R.attr.top
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galeria_arte.ui.theme.Galeria_ArteTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Galeria_ArteTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color.White,
                    shape = RectangleShape,
                    )

                {
                    var posicion by remember { mutableStateOf(0) }
                    Foto(
                        obra = obras[posicion],
                        onAnterior = {
                            posicion = if (posicion > 0) posicion - 1 else obras.size - 1
                            },
                        onSiguiente = {posicion = if (posicion < obras.size - 1) posicion + 1 else 0}
                    )

                }
            }
        }
    }
}
data class Obra(

    val titulo: String,
    val autor: String,
    val ano: String,
    @DrawableRes val imagen: Int,

)
val obras = listOf(
    Obra( titulo = "La perrita del arnés rosa",
        autor = "Ana Alegría Riera Trillo",
        ano = "2025",
        imagen = R.drawable.perra2),

    Obra(titulo = "Siesta sobre mis zapatillas ",
        autor = "Ana Alegría Riera Trillo",
        ano = "2025",
        imagen = R.drawable.perra1),

    Obra(titulo = "La cara de la felicidad",
        autor = "Ana Alegría Riera Trillo",
        ano = "2025",
        imagen = R.drawable.perra3),

    Obra(
        titulo = "De paseo al atardecer",
        autor = "Ana Alegría Riera Trillo",
        ano = "2025",
        imagen = R.drawable.perra4
    ),
    Obra(
        titulo ="Perra quiere salir de paseo",
        autor = "Ana Alegría Riera Trillo",
        ano = "2025",
        imagen = R.drawable.perra5

)


)
@Composable
fun Foto(obra: Obra,
         onAnterior: () -> Unit,
         onSiguiente: () -> Unit
         )
{
    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(horizontal = 8.dp)
            .statusBarsPadding()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center

        ) {
            Surface(
                modifier = Modifier,
                color = Color.White,
                shadowElevation = 8.dp
            )

            {
                Image(
                    painter = painterResource(obra.imagen),
                    contentDescription = obra.titulo,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        Text(
            text = obra.titulo, fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "${obra.autor} (${obra.ano})"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onAnterior) {
                Text("Anterior")
            }

            Button(onClick = onSiguiente) {
                Text("Siguiente")
            }
        }
    }





}

