**GiftCard Payment Manager**
GiftCard Payment Manager is an Android application that allows users to manage gift card transactions and authorize payments through different methods. The app fetches data from a REST API, sorts transactions by date, and presents them in a RecyclerView layout. Users can select a payment method and authorize transactions easily.

**Features:**
Fetch Data from API: The app retrieves gift card transactions from a RESTful API.
Sort Transactions by Date: Transactions are sorted chronologically, allowing for a streamlined view.
Display in RecyclerView: Transactions are displayed efficiently using a RecyclerView.
Payment Authorization: Users can select from various payment methods (e.g., Credit Card, Debit Card, PayPal) and authorize the transaction.
Due Amount Display: The app shows the due amount for each transaction before payment authorization.

**Technologies Used:**
Kotlin: Programming language for Android development.
Retrofit: Library for handling API requests.
RecyclerView: Used for displaying the list of gift card transactions.
Coroutines: Used to perform network requests asynchronously.
Android SDK: For building the Android app.

**Setup Instructions:**
Prerequisites:
Before running the app, ensure you have the following installed:
Android Studio: The IDE for building and running the Android project.
Java Development Kit (JDK): Ensure you have the latest version of JDK installed.
Retrofit: Retrofit library for handling API calls.

**Step 1: Clone the Repository**
Clone the repository to your local machine using the following command:
git clone https://github.com/yourusername/GiftCard-Payment-Manager-Kotlin.git

**Step 2: Add Dependencies**
In your build.gradle (Module: app) file, add the following dependencies for Retrofit, Gson converter, and Coroutines:
// Retrofit Dependencies
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'

// Coroutines Dependency
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3'

// RecyclerView Dependency
implementation 'androidx.recyclerview:recyclerview:1.2.0'

**Step 3: Set Up the API**
Replace the base URL of the API in the Retrofit instance with your own backend URL. In PaymentActivity class, find the following line:
.baseUrl("https://your-api-base-url.com/")  // Replace with your API base URL

**Step 4: Run the App**
Connect your Android device or use the Android Emulator.
Build and run the app from Android Studio.

**Step 5: Test the Application**
The app will:
Fetch gift card transactions from the API.
Display them in a RecyclerView, sorted by date.
Allow you to select a payment method and authorize payments.

**Project Structure:**
PaymentActivity.kt: The main activity that fetches data from the API, sorts it by date, and displays it in a RecyclerView.
PaymentRequest.kt: Data model representing the request to authorize a payment.
PaymentResponse.kt: Data model for the response from the API after authorizing the payment.
PaymentApi.kt: The API interface that defines the authorization POST request.
res/layout/activity_payment.xml: Layout for the payment activity, including recipient details, payment options, and due amount.
res/layout/item_transaction.xml: Layout for each item in the RecyclerView, displaying transaction
