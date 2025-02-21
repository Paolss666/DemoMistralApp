package com.example.mistral.demo.service

import com.example.mistral.demo.config.RetrofitClient
import com.example.mistral.demo.models.MistralMessage
import com.example.mistral.demo.models.MistralRequest
import com.example.mistral.demo.models.MistralResponse
import retrofit2.Call
import retrofit2.Response
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import service.MistralService

@Service
class MistralApiService(
    @Value("\${mistral.api.key}") private val apiKey: String
) {
    private val api = RetrofitClient.instance.create(MistralService::class.java)

    fun getResponse(prompt: String): String {
        val request = MistralRequest(
            model = "mistral-small",  // modele
            temperature = 0.7,
            max_tokens = 1000,
            messages = listOf(
                MistralMessage(role = "user", content = prompt)
            )
        )

        // Log l'appel et les headers
        println("Calling Mistral API with prompt: $prompt")
        println("Authorization: Bearer $apiKey")

        val call: Call<MistralResponse> = api.getCompletion("Bearer $apiKey", request)
        val response: Response<MistralResponse> = try {
            call.execute()
        } catch (e: Exception) {
            println("Request failed: ${e.message}")
            return "Request failed: ${e.message}"
        }

        return if (response.isSuccessful) {
            println("Response received successfully.")
            response.body()?.choices?.firstOrNull()?.message?.content ?: "No response from the model."
        } else {
            val errorMessage = "error: ${response.errorBody()?.string()}"
            println(errorMessage)
            errorMessage
        }
    }

}
