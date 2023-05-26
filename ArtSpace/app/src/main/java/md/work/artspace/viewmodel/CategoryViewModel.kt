package md.work.artspace.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import md.work.artspace.data.Category
import md.work.artspace.data.Product
import md.work.artspace.util.Resource

class CategoryViewModel constructor(
    private val firestore: FirebaseFirestore,
    private val category: Category
) : ViewModel() {


    private val _products = MutableStateFlow<Resource<List<Product>>>(Resource.Unspecified())
    val products = _products.asStateFlow()

    init {
        fetchProducts()
    }

     fun fetchProducts() {
        viewModelScope.launch {
            _products.emit(Resource.Loading())
        }
        firestore.collection("Products").whereEqualTo("category", category.category).get()
            .addOnSuccessListener {
                val products = it.toObjects(Product::class.java)
                viewModelScope.launch {
                    _products.emit(Resource.Success(products))
                }
            }.addOnFailureListener {
                viewModelScope.launch {
                    _products.emit(Resource.Error(it.message.toString()))
                }
            }
    }

}