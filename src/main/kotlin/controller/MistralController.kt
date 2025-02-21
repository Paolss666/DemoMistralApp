package com.example.mistral.demo.controller.MistralController


import com.example.mistral.demo.models.MistralRequest
import com.example.mistral.demo.service.MistralApiService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chat")
class MistralController(private val mistralApiService: MistralApiService) {

    @PostMapping("/completions")
    fun generate(@RequestBody request: MistralRequest): ResponseEntity<String> {
        val result = mistralApiService.getResponse(request.messages.firstOrNull()?.content ?: "")
        return ResponseEntity.ok(result)
    }
}


