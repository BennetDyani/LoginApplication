package za.ac.dataroomlogin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application, Room).userDao()

    fun registerUser(email: String, password: String) {
        viewModelScope.launch {
            dao.insertUser(User(email, password))
        }
    }

    fun login(email: String, password: String, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = dao.login(email, password)
            callback(user != null)
        }
    }

    suspend fun getAllUsers(): List<User> {
        return withContext(Dispatchers.IO) {
            dao.getAllUsers()
        }
    }
}