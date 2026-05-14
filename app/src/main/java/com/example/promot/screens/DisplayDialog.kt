package com.example.promot.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.example.promot.roomdb.Note
import com.example.promot.viewmodel.NoteViewModel

@Composable
fun DisplayDialog( viewModel: NoteViewModel ){
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedcolor by remember { mutableStateOf (Color.Blue) }


    AlertDialog(
        onDismissRequest = {  },

        title = { Text(text = "Enter Note") },
        text = {
            Column {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") }

                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }
                )

                Spacer(modifier = Modifier.height(16.dp))



            }
        },
        confirmButton = {
            Button(onClick = {
                val note = Note(
                    0,
                    title = title,
                    description = description,
                    color = selectedcolor.toArgb()
                )
            }){
                Text(text = "Save")
            }

        },
        dismissButton = {
            Button(onClick = {}){
                Text(text = "Cancel")
            }

        },
    )

}