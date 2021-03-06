package com.company.firestoreexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.company.firestoreexample.ui.theme.FirestoreExampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirestoreExampleTheme {
    }
}