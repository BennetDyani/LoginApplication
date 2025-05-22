package za.ac.dataroomlogin

import android.content.Context

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, Room: Any): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}

private fun Any.databaseBuilder(
    context: Context,
    klass: Class<AppDatabase>,
    string: String
) {
}

open annotation class RoomDatabase

annotation class Database
