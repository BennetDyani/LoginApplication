User Authentication App (Jetpack Compose + Room)
Overview
This project is a simple user authentication app built with Kotlin, Jetpack Compose, Room, and MVVM architecture. It demonstrates:

Practical enterprise app development using modern Android tools.

Effective state management with ViewModel and Kotlin Coroutines.

Basic database operations using Room ORM with SQLite.

User registration, login, and session handling flows.

Navigation between screens using Jetpack Navigation Compose.

Modules Implemented
Applications Development
Developed UI with Jetpack Compose for declarative, reactive interface.

Implemented asynchronous database access using Room and Kotlin Coroutines.

Built a ViewModel to manage UI state and handle business logic.

Applications Development Theory
Applied MVVM architecture to separate UI and data concerns.

Used Kotlin sealed class to represent UI state and handle success/failure clearly.

Enforced user input validation and error feedback.

Information Systems
Designed database schema with Room Entities (User).

Executed SQL queries for user retrieval and insertion (@Query and @Insert).

Ensured thread-safe singleton database access with a RoomDatabase instance.

Professional Practice 3
Added user feedback with Toasts for validation and errors.

Structured code for readability and maintainability.

Handled navigation lifecycle to avoid backstack issues on logout and registration.

Project 3
Integrated UI, database, and navigation into a cohesive end-to-end user authentication flow.

Managed state consistently across multiple composables.

Simulated real-world login/registration functionality.

Project Management
Used Kotlin Coroutines and viewModelScope for lifecycle-aware background tasks.

Ensured thread safety with @Volatile and synchronized blocks for singleton database instance.

Handled screen transitions with clear navigation actions and backstack control.

Features
User Registration: Check for existing email before creating a new user.

User Login: Authenticate users with email and password.

Welcome Screen: Display logged-in user's info and allow logout.

Password Storage: (Note: Currently plaintext, to be improved with hashing).

Navigation: Compose Navigation with safe backstack handling.

Project Structure
kotlin
Copy
Edit
com.example.app
├── data
│   ├── User.kt                   // Entity class
│   ├── UserDao.kt                // Room DAO interface
│   ├── AppDatabase.kt            // Room Database singleton
├── ui
│   ├── WelcomeScreen.kt          // Welcome composable screen
│   ├── RegisterScreen.kt         // Registration composable screen
│   ├── LoginScreen.kt            // (Not shown, but assumed)
├── viewmodel
│   ├── UserViewModel.kt          // ViewModel managing auth state
├── MainActivity.kt               // NavHost and app entry point
How to Run
Clone the repo.

Open in Android Studio.

Build and run on emulator or device.

Register a new user or login with existing credentials.

Navigate between screens with state persisted in Room DB.

Next Steps / Improvements
Secure password storage using hashing (SHA-256 or bcrypt).

Persist login session with DataStore or SharedPreferences.

Add password reset functionality.

Implement input form validation with inline error messages.

Add unit tests for ViewModel and DAO.

Improve UI with Material3 theming and animations.
