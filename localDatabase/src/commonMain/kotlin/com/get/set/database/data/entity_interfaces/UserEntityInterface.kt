import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface UserEntityInterface {
    @Upsert
    suspend fun insert(user: UserTableEntity): Long

    @Delete
    suspend fun delete(user: UserTableEntity)

    @Query("DELETE FROM UserTableEntity")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM UserTableEntity")
    suspend fun getAllUsers(): List<UserTableEntity>
}