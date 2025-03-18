package com.natasa.triviaapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.natasa.triviaapp.component.QuestionDisplay
import com.natasa.triviaapp.screens.QuestionsViewModel
import com.natasa.triviaapp.screens.TriviaHome
import com.natasa.triviaapp.ui.theme.TriviaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TriviaAppTheme {
                TriviaHome()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TriviaAppTheme {
    }
}

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true)
        CircularProgressIndicator()
    else {
        Log.d(TAG, "Questions: ${questions?.size}")
        questions?.forEach{
            Log.d(TAG, "Question: ${it.question}")
        }
        if (questions!=null){
            QuestionDisplay(questions.first()) { }
        }
    }
}