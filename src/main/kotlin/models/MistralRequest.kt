package com.example.mistral.demo.models

data class MistralRequest(
    val model: String = "mistralai/mistral-small-24b-instruct-2501:free",
    val temperature: Double = 0.7,
    val max_tokens: Int = 1000,
    val messages: List<MistralMessage>
)

data class MistralMessage(
    val role: String,
    val content: String
)
