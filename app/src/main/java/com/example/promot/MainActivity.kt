package com.example.promot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.toColorInt
import androidx.lifecycle.ViewModelProvider
import com.example.promot.repository.NotesRepository
import com.example.promot.roomdb.Note
import com.example.promot.roomdb.NoteDB
import com.example.promot.screens.DisplayDialog
import com.example.promot.screens.DisplayNoteList
import com.example.promot.ui.theme.PromotTheme
import com.example.promot.viewmodel.NoteViewModel
import com.example.promot.viewmodel.NoteViewModelFactory
import kotlin.collections.listOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = NoteDB.getInstance(applicationContext)

        val repository = NotesRepository(database.noteDao)

        val viewModelFactory = NoteViewModelFactory(repository)

        val noteViewModel = ViewModelProvider(this, factory = viewModelFactory)
            .get(NoteViewModel::class.java)

//        val note1 = Note(id = 0,title = "Note 1",
//            description = "Welcome my friends, I am an Android Developer. Please rate this app 5 stars"
//
//            ,  "#F44336".toColorInt())
//
//        noteViewModel.insert(note1)



        setContent {
            PromotTheme {
                val notes by noteViewModel.allNotes.observeAsState(emptyList())

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        MyFab(viewModel = noteViewModel)
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        DisplayNoteList(notes = notes)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun MyFab(viewModel: NoteViewModel) {
    var showDialog by remember { mutableStateOf(false) }

    DisplayDialog(viewModel = viewModel, showDialog = showDialog) {
        showDialog = false
    }

    FloatingActionButton(
        onClick = { showDialog = true },
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Note"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PromotTheme {
        Greeting("Android")
    }
}