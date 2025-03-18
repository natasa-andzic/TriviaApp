package com.natasa.triviaapp.network

import com.natasa.triviaapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {

    @GET("world.json")
    //outside of the main thread, so suspend
    suspend fun getAllQuestions(): Question

}