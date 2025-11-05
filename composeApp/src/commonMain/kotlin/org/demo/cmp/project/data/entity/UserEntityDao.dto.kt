import androidx.room.Entity
import androidx.room.PrimaryKey
import org.demo.cmp.project.domain.models.UserModel

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val displayName: String,
    val email: String,
    val username: String?= null
)