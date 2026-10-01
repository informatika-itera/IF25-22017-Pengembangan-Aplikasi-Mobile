package com.itera.pam.p5.latihan

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

// Hands-on 3: Bottom Navigation
// Tugas: buat 3 tab (Home/Search/Profil) dengan NavigationBar yang terhubung
// ke NavHost.
//
// CATATAN PENTING: kode navigasi tab DI BAWAH INI SUDAH BISA JALAN, tapi
// PERILAKUNYA SALAH — coba jalankan, buka tab Home > Search > Home > Search
// berkali-kali, lalu tekan tombol Back: kamu akan melihat back stack menumpuk
// dan tidak balik ke tab awal. Ini karena `navigate(route)` di bawah TIDAK
// menyertakan opsi popUpTo/launchSingleTop/restoreState. Lengkapi TODO untuk
// memperbaikinya.

private data class Tab(val route: String, val label: String)

private val tabs = listOf(
    Tab("home", "Home"),
    Tab("search", "Search"),
    Tab("profil", "Profil"),
)

/**
 * Layar utama dengan bilah navigasi di bawah yang bisa berpindah-pindah antar menu tanpa kehilangan status.
 */
@Composable
fun Handson3Screen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route

                tabs.forEach { tab ->
                    NavigationBarItem(
                        selected = currentRoute == tab.route,
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { },
                        label = { Text(tab.label) }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { Text("Halaman Home") }
            composable("search") { Text("Halaman Search") }
            composable("profil") { Text("Halaman Profil") }
        }
    }
}
