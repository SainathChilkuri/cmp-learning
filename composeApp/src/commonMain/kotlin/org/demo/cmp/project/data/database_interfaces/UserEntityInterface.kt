import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface  UserEntityInterface {
    @Upsert
    suspend fun insert(user: UserEntity): Long

    @Delete
    suspend fun delete(user: UserEntity)

    @Query("DELETE FROM UserEntity")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM UserEntity")
    suspend fun getAllUsers(): List<UserEntity>
}