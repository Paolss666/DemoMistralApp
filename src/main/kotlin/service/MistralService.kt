package service

import com.example.mistral.demo.models.MistralRequest
import com.example.mistral.demo.models.MistralResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface MistralService {
        @Headers(
            "Content-Type: application/json",
            "Accept: application/json"
        )
        @POST("chat/completions")
        fun getCompletion(
            @Header("Authorization") apiKey: String,
            @Body request: MistralRequest
        ): Call<MistralResponse>
}
