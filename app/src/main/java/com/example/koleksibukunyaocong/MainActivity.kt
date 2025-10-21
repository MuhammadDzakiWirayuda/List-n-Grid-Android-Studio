package com.example.koleksibukunyaocong


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.koleksibukunyaocong.ui.theme.Book
import com.example.koleksibukunyaocong.ui.theme.BookData

/**
 * MainActivity - Entry point aplikasi
 * ANDA TIDAK PERLU MENGUBAH BAGIAN INI
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BookCatalogApp()
            }
        }
    }
}

/**
 * Composable utama aplikasi
 * ANDA BISA MENGUBAH:
 * - Judul aplikasi di topBar (saat ini "Katalog Buku")
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookCatalogApp() {
    // State untuk menyimpan mode tampilan (true = List, false = Grid)
    var isListView by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Koleksi Bukunya Ocong", // <- UBAH JUDUL DI SINI
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    // Tombol untuk toggle antara List dan Grid
                    IconButton(onClick = { isListView = !isListView }) {
                        Icon(
                            imageVector = if (isListView) Icons.Default.GridView else Icons.Default.ViewList,
                            contentDescription = if (isListView) "Switch to Grid" else "Switch to List"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        // Tampilkan List atau Grid berdasarkan state
        if (isListView) {
            BookListView(
                books = BookData.bookList,
                modifier = Modifier.padding(paddingValues)
            )
        } else {
            BookGridView(
                books = BookData.bookList,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}


@Composable
fun BookListView(
    books: List<Book>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp), // <- Ubah padding kiri-kanan di sini
        verticalArrangement = Arrangement.spacedBy(8.dp), // <- Ubah jarak antar item di sini
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(books) { book ->
            BookListItem(book = book)
        }
    }
}


@Composable
fun BookGridView(
    books: List<Book>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // <- Ubah jumlah kolom di sini (2 = 2 kolom)
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // <- Ubah padding di sini
        horizontalArrangement = Arrangement.spacedBy(12.dp), // <- Jarak horizontal
        verticalArrangement = Arrangement.spacedBy(12.dp), // <- Jarak vertikal
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(books) { book ->
            BookGridItem(book = book)
        }
    }
}


@Composable
fun BookListItem(book: Book) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp), // <- Ubah tinggi card di sini
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(book.color)) // Menggunakan warna dari data
                .padding(16.dp), // <- Ubah padding dalam card di sini
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Kolom kiri: Icon/Indicator
            Surface(
                modifier = Modifier
                    .size(60.dp), // <- Ubah ukuran kotak warna di sini
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = book.id.toString(),
                        fontSize = 24.sp, // <- Ubah ukuran angka di sini
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Kolom kanan: Informasi buku
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = book.title,
                    fontSize = 18.sp, // <- Ubah ukuran judul di sini
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Oleh ${book.author}",
                    fontSize = 14.sp, // <- Ubah ukuran penulis di sini
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    Text(
                        text = book.category,
                        fontSize = 12.sp, // <- Ubah ukuran kategori di sini
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "• ${book.year}",
                        fontSize = 12.sp, // <- Ubah ukuran tahun di sini
                        color = Color.Gray
                    )
                }
            }
        }
    }
}


@Composable
fun BookGridItem(book: com.example.koleksibukunyaocong.ui.theme.Book) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp), // <- Ubah tinggi card di sini
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(book.color))
                .padding(12.dp), // <- Ubah padding dalam card di sini
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Bagian atas: Icon/Indicator
            Surface(
                modifier = Modifier
                    .size(50.dp), // <- Ubah ukuran kotak angka di sini
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = book.id.toString(),
                        fontSize = 20.sp, // <- Ubah ukuran angka di sini
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // Bagian tengah: Informasi buku
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = book.title,
                    fontSize = 16.sp, // <- Ubah ukuran judul di sini
                    fontWeight = FontWeight.Bold,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = book.author,
                    fontSize = 12.sp, // <- Ubah ukuran penulis di sini
                    color = Color.Gray,
                    maxLines = 1
                )
            }

            // Bagian bawah: Kategori dan tahun
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = book.category,
                    fontSize = 11.sp, // <- Ubah ukuran kategori di sini
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = book.year.toString(),
                    fontSize = 11.sp, // <- Ubah ukuran tahun di sini
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MaterialTheme {
        BookCatalogApp()
    }
}