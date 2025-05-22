package za.ac.loginapplication.za.ac.loginapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = AppDatabase.getInstance(application).userDao()

    private val _loggedInUser = MutableStateFlow<User?>(null)
    val loggedInUser: StateFlow<User?> = _loggedInUser

    private val _loginState = MutableStateFlow<LoginResult>(LoginResult.Idle)
    val loginState: StateFlow<LoginResult> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = userDao.login(email, password)
            if (user != null) {
                _loggedInUser.value = user
                _loginState.value = LoginResult.Success("Login successful")
            } else {
                _loginState.value = LoginResult.Failure("Invalid email or password")
            }
        }
    }

    fun registerUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            val existingUser = userDao.getUserByEmail(email)
            if (existingUser == null) {
                val newUser = User(firstName = name, email = email, password = password)
                userDao.insertUser(newUser)
                _loggedInUser.value = newUser
                _loginState.value = LoginResult.Success("Registration successful")
            } else {
                _loginState.value = LoginResult.Failure("User already exists")
            }
        }
    }

    fun logout() {
        _loggedInUser.value = null
        _loginState.value = LoginResult.Idle
    }

    sealed class LoginResult {
        object Idle : LoginResult()
        data class Success(val message: String) : LoginResult()
        data class Failure(val error: String) : LoginResult()
    }
}

