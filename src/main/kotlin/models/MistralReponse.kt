package com.example.mistral.demo.models

data class MistralResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: MistralMessage
)


