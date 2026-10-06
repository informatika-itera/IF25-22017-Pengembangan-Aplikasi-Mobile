package com.itera.pam.p5.latihan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// Hands-on 2: Passing Data via Arguments
// Tugas: dari daftar item di Home, kirim `itemId` sebagai argumen route ke
// Detail, lalu tampilkan item yang sesuai.

private data class Item(val id: Int, val nama: String)

private val daftarItem = listOf(
    Item(1, "Buku Kotlin"),
    Item(2, "Laptop"),
    Item(3, "Headphone"),
)

/**
 * Layar navigasi yang mengirimkan data ID barang antar halaman.
 */
@Composable
fun Handson2Screen() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeListScreen(navController) }
        composable(
            route = "detail/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: -1
            DetailItemScreen(navController, itemId)
        }
    }
}

@Composable
private fun HomeListScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Daftar Item")
        daftarItem.forEach { item ->
            Button(onClick = {
                navController.navigate("detail/${item.id}")
            }) {
                Text(item.nama)
            }
        }
    }
}

@Composable
private fun DetailItemScreen(navController: NavHostController, itemId: Int) {
    val item = daftarItem.find { it.id == itemId }
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Detail Item")
        Text("ID: $itemId")
        Text("Nama: ${item?.nama ?: "(tidak ditemukan)"}")
        Button(onClick = { navController.popBackStack() }) {
            Text("< Kembali")
        }
    }
}
