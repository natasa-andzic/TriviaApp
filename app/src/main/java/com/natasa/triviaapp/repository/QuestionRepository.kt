package com.natasa.triviaapp.repository

import android.util.Log
import com.natasa.triviaapp.data.DataOrException
import com.natasa.triviaapp.model.QuestionItem
import com.natasa.triviaapp.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {

        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading = false
            }
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Exception", "getallQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }

}
