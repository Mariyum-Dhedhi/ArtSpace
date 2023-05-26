package md.work.artworkadder

data class Product(
    val id: String,
    val name: String,
    val authorName: String,
    val category: String,
    val price: Float,
    val offerPercentage: Float? = null,
    val description: String,
    val dimensions: String,
    val specs: String? = null,
    val images: List<String>
)