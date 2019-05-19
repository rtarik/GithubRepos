package teeyare.github.io.githubrepos.domain

data class GithubRepo(
    val name: String,
    val description: String,
    val stars: Int,
    val ownerUsername: String,
    val ownerAvatar: String
)