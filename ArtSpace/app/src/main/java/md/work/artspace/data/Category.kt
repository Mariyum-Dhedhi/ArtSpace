package md.work.artspace.data

sealed class Category(val category: String) {

    object Abstract: Category("Abstract")
    object Nature: Category("Nature")
    object Geometric: Category("Geometric")
    object Minimalist: Category("Minimalist")
    object Surrealist: Category("Surrealist")
    object Portraiture: Category("Portraiture")
    object StillLife: Category("Still Life")
    object Pop: Category("Pop")
    object Typography: Category("Typography")

}