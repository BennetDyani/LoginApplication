package za.ac.dataroomlogin



import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey val email: String,
    val password: String
)

annotation class PrimaryKey

annotation class Entity
