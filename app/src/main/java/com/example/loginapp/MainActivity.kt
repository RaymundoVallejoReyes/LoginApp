package com.example.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp


// ---------------------------------------------------------
// MAIN ACTIVITY
// ---------------------------------------------------------

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            MaterialTheme {

                AplicacionLogin()

            }
        }
    }
}


// ---------------------------------------------------------
// CONTROL DE PANTALLAS
// ---------------------------------------------------------

@Composable
fun AplicacionLogin() {

    // Esta variable indica qué pantalla se está mostrando.
    // false = Login
    // true = Registro
    var mostrarRegistro by remember {
        mutableStateOf(false)
    }


    if (mostrarRegistro) {

        PantallaRegistro(

            irALogin = {

                // Regresamos a la pantalla de inicio de sesión
                mostrarRegistro = false
            }
        )

    } else {

        PantallaLogin(

            irARegistro = {

                // Vamos a la pantalla de registro
                mostrarRegistro = true
            }
        )
    }
}


// ---------------------------------------------------------
// PANTALLA LOGIN
// ---------------------------------------------------------

@Composable
fun PantallaLogin(
    irARegistro: () -> Unit
) {

    // Guarda el nombre de usuario
    var username by remember {
        mutableStateOf("")
    }

    // Guarda la contraseña
    var password by remember {
        mutableStateOf("")
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {


            // -------------------------------------------------
            // LOGO
            // -------------------------------------------------

            Image(
                painter = painterResource(
                    id = R.drawable.logo
                ),

                contentDescription = "Logo de la aplicación",

                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),

                contentScale = ContentScale.Fit
            )


            // -------------------------------------------------
            // USUARIO
            // -------------------------------------------------

            OutlinedTextField(
                value = username,

                onValueChange = { nuevoTexto ->
                    username = nuevoTexto
                },

                label = {
                    Text("Usuario")
                },

                modifier = Modifier.fillMaxWidth(),

                singleLine = true
            )


            // -------------------------------------------------
            // CONTRASEÑA
            // -------------------------------------------------

            OutlinedTextField(
                value = password,

                onValueChange = { nuevoTexto ->
                    password = nuevoTexto
                },

                label = {
                    Text("Contraseña")
                },

                modifier = Modifier.fillMaxWidth(),

                singleLine = true,

                visualTransformation =
                    PasswordVisualTransformation(),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )


            // -------------------------------------------------
            // BOTÓN INICIAR SESIÓN
            // -------------------------------------------------

            Button(
                onClick = {

                    // En esta actividad no es necesario
                    // realizar autenticación real.

                },

                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Iniciar sesión")
            }


            // -------------------------------------------------
            // ENLACE HACIA REGISTRO
            // -------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.Center,

                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "¿No tienes una cuenta?"
                )

                TextButton(
                    onClick = irARegistro,

                    contentPadding = PaddingValues(
                        start = 4.dp,
                        end = 4.dp
                    )
                ) {

                    Text(
                        text = "Regístrate ahora"
                    )
                }
            }
        }
    }
}


// ---------------------------------------------------------
// PANTALLA REGISTRO
// ---------------------------------------------------------

@Composable
fun PantallaRegistro(
    irALogin: () -> Unit
) {

    // Guarda el nombre completo
    var nombreCompleto by remember {
        mutableStateOf("")
    }

    // Guarda el nombre de usuario
    var username by remember {
        mutableStateOf("")
    }

    // Guarda la contraseña
    var password by remember {
        mutableStateOf("")
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {


            // -------------------------------------------------
            // LOGO
            // -------------------------------------------------

            Image(
                painter = painterResource(
                    id = R.drawable.logo
                ),

                contentDescription = "Logo de la aplicación",

                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),

                contentScale = ContentScale.Fit
            )


            // -------------------------------------------------
            // NOMBRE COMPLETO
            // -------------------------------------------------

            OutlinedTextField(
                value = nombreCompleto,

                onValueChange = { nuevoTexto ->
                    nombreCompleto = nuevoTexto
                },

                label = {
                    Text("Nombre completo")
                },

                modifier = Modifier.fillMaxWidth(),

                singleLine = true
            )


            // -------------------------------------------------
            // NOMBRE DE USUARIO
            // -------------------------------------------------

            OutlinedTextField(
                value = username,

                onValueChange = { nuevoTexto ->
                    username = nuevoTexto
                },

                label = {
                    Text("Usuario")
                },

                modifier = Modifier.fillMaxWidth(),

                singleLine = true
            )


            // -------------------------------------------------
            // CONTRASEÑA
            // -------------------------------------------------

            OutlinedTextField(
                value = password,

                onValueChange = { nuevoTexto ->
                    password = nuevoTexto
                },

                label = {
                    Text("Contraseña")
                },

                modifier = Modifier.fillMaxWidth(),

                singleLine = true,

                visualTransformation =
                    PasswordVisualTransformation(),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )


            // -------------------------------------------------
            // BOTÓN REGISTRARTE
            // -------------------------------------------------

            Button(
                onClick = {

                    // No se almacenan usuarios todavía.
                    // Esta actividad solamente practica
                    // interfaces y navegación.

                },

                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Registrarte")
            }


            // -------------------------------------------------
            // ENLACE HACIA LOGIN
            // -------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.Center,

                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "¿Ya tienes una cuenta?"
                )

                TextButton(
                    onClick = irALogin,

                    contentPadding = PaddingValues(
                        start = 4.dp,
                        end = 4.dp
                    )
                ) {

                    Text(
                        text = "Inicia sesión ahora"
                    )
                }
            }
        }
    }
}