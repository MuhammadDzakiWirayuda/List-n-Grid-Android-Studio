package com.example.koleksibukunyaocong.ui.theme


data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val year: Int,
    val category: String,
    val color: Long
)

object BookData {
    val bookList = listOf(
        Book(
            id = 1,
            title = "Laskar Pelangi",
            author = "Andrea Hirata",
            year = 2005,
            category = "Novel",
            color = 0xFFE3F2FD // Biru muda
        ),
        Book(
            id = 2,
            title = "Bumi Manusia",
            author = "Pramoedya Ananta Toer",
            year = 1980,
            category = "Novel Sejarah",
            color = 0xFFFFF3E0 // Orange muda
        ),
        Book(
            id = 3,
            title = "Negeri 5 Menara",
            author = "Ahmad Fuadi",
            year = 2009,
            category = "Novel",
            color = 0xFFF3E5F5 // Ungu muda
        ),
        Book(
            id = 4,
            title = "Perahu Kertas",
            author = "Dee Lestari",
            year = 2009,
            category = "Romance",
            color = 0xFFFFEBEE // Merah muda
        ),
        Book(
            id = 5,
            title = "Ronggeng Dukuh Paruk",
            author = "Ahmad Tohari",
            year = 1982,
            category = "Novel",
            color = 0xFFE8F5E9 // Hijau muda
        ),
        Book(
            id = 6,
            title = "Cantik Itu Luka",
            author = "Eka Kurniawan",
            year = 2002,
            category = "Fiksi",
            color = 0xFFFFFDE7 // Kuning muda
        ),
        Book(
            id = 7,
            title = "Hujan",
            author = "Tere Liye",
            year = 2016,
            category = "Fantasy",
            color = 0xFFE0F2F1 // Cyan muda
        ),
        Book(
            id = 8,
            title = "Pulang",
            author = "Tere Liye",
            year = 2015,
            category = "Drama",
            color = 0xFFFCE4EC // Pink muda
        ),
        Book(
            id = 9,
            title = "Sang Pemimpi",
            author = "Andrea Hirata",
            year = 2006,
            category = "Novel",
            color = 0xFFE1F5FE // Sky blue
        ),
        Book(
            id = 10,
            title = "Supernova",
            author = "Dee Lestari",
            year = 2001,
            category = "Sci-Fi",
            color = 0xFFF1F8E9 // Light green
        )
    )
}