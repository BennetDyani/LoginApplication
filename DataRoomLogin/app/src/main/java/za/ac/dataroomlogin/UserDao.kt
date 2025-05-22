package za.ac.dataroomlogin

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_table WHERE email = :email AND password = :password")
    suspend fun login(email: String, password: String): User?

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers(): List<User>
}

annotation class Dao

annotation class Query(val string: String)

annotation class Insert

class OnConflictStrategy {
    object REPLACE {

    }

}
