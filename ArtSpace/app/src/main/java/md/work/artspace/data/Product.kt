package md.work.artspace.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val name: String,
    val authorName: String,
    val category: String,
    val description: String,
    val dimensions: String,
    val price: Float,
    val offerPercentage: Float? = null,
    val specs: String? = null,
    val images: List<String>
): Parcelable {
    constructor():this("0","","","","","",0f,images = emptyList())
}