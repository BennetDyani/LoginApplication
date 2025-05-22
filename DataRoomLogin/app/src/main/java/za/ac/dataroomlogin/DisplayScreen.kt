package za.ac.dataroomlogin

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ViewModel
import za.ac.dataroomlogin.User
import za.ac.dataroomlogin.UserViewModel
import za.ac.dataroomlogin.UserViewModelFactory

@Composable
fun DisplayScreen() {
    val context = LocalContext.current.applicationContext as Application
    val viewModel: UserViewModel = viewModel(factory = UserViewModelFactory(context))

    var users by remember { mutableStateOf(emptyList<User>()) }

    LaunchedEffect(Unit) {
        try {
            users = viewModel.getAllUsers()
        } catch (e: Exception) {
            Toast.makeText(context, "Error loading users", Toast.LENGTH_SHORT).show()
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Registered Users", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(users) { user ->
                Column(modifier = Modifier.padding(vertical = 4.dp)) {
                    Text("Email: ${user.email}")
                    Text("Password: ${user.password}")
                    Divider(modifier = Modifier.padding(vertical = 4.dp))
                }
            }
        }
    }
}
