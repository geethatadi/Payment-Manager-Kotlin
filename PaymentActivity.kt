import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class PaymentActivity : AppCompatActivity() {

    private lateinit var recipientName: TextView
    private lateinit var recipientEmail: TextView
    private lateinit var paymentOptions: RadioGroup
    private lateinit var dueAmount: TextView
    private lateinit var authorizePaymentButton: Button

    private val BASE_URL = "https://yourapi.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        recipientName = findViewById(R.id.recipientName)
        recipientEmail = findViewById(R.id.recipientEmail)
        paymentOptions = findViewById(R.id.paymentOptions)
        dueAmount = findViewById(R.id.dueAmount)
        authorizePaymentButton = findViewById(R.id.authorizePaymentButton)


        recipientName.text = "John Doe"
        recipientEmail.text = "john.doe@example.com"
        dueAmount.text = "Due Amount: $100"

     
        authorizePaymentButton.setOnClickListener {
            val selectedPaymentMethod = findViewById<RadioButton>(paymentOptions.checkedRadioButtonId).text.toString()
            authorizePayment(selectedPaymentMethod)
        }
    }

    private fun authorizePayment(paymentMethod: String) {
        val paymentDetails = PaymentRequest(paymentMethod, 100) // Pass the payment method and amount

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(PaymentApi::class.java)
        val call = api.authorizePayment(paymentDetails)

        call.enqueue(object : Callback<PaymentResponse> {
            override fun onResponse(call: Call<PaymentResponse>, response: Response<PaymentResponse>) {
                if (response.isSuccessful) {
                    // Handle success, payment authorized
                } else {
                    // Handle failure
                }
            }

            override fun onFailure(call: Call<PaymentResponse>, t: Throwable) {
                // Handle network failure
            }
        })
    }
}


data class PaymentRequest(val paymentMethod: String, val amount: Int)

data class PaymentResponse(val status: String, val transactionId: String)
e
interface PaymentApi {
    @POST("payment/authorize")
    fun authorizePayment(@Body paymentRequest: PaymentRequest): Call<PaymentResponse>
}
