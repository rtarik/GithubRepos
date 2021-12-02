package teeyare.github.io.githubrepos.framework.model

import com.google.gson.annotations.SerializedName

data class GithubRepoResponseList(
    @SerializedName("total_count") val totalCount: Int?,
    val items: List<GithubRepoResponse>?
)

data class GithubRepoResponse(
    val name: String?,
    val owner: GithubOwnerResponse?,
    val description: String?,
    @SerializedName("stargazers_count") val stars: Int?
) {
    data class GithubOwnerResponse(
        val login: String?,
        @SerializedName("avatar_url") val avatarUrl: String?
    )
}
