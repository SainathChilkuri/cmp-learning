import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserTableEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val displayName: String,
    val email: String,
    val username: String?= null
)