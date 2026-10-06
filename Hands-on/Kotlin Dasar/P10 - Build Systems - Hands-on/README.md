# Hands-on Pertemuan 10 (Kotlin Dasar) — Build Systems

Proyek Kotlin/JVM untuk 3 latihan praktikum materi Build Systems (IF25-22017 — Pengembangan Aplikasi Mobile, ITERA — jalur suplemen Kotlin Dasar).

## Capaian Pembelajaran

- Menjelaskan peran build system (Maven, Gradle) dalam mengubah source code menjadi artifact
- Memahami convention Gradle untuk resource dan bagaimana resource dikemas ke classpath
- Membuat dan menjalankan custom Gradle task dengan Kotlin DSL (`tasks.register`, `doLast`)
- Mendeklarasikan dan me-resolve dependency eksternal lewat `dependencies {}` dan `repositories {}`

## Cara Menjalankan

1. Buka folder **"P10 - Build Systems - Hands-on"** ini di Android Studio / IntelliJ IDEA (`File > Open`) sebagai proyek Gradle terpisah.
2. Tunggu proses Gradle sync selesai.
3. Untuk **handson1**: buka `Latihan.kt`, lengkapi bagian `TODO`, lalu klik ▶️ di sebelah `fun main()`.
4. Untuk **handson2**: tugasnya ada di **`build.gradle.kts`** module `handson2-latihan`, bukan di file Kotlin. Lengkapi `TODO` di dalam `doLast {}`, lalu jalankan lewat terminal:
   ```
   ./gradlew :handson2-latihan:printProjectInfo
   ```
5. Untuk **handson3**: tugasnya juga ada di **`build.gradle.kts`** module `handson3-latihan` — tambahkan dependency yang diminta di komentar `TODO`, lalu jalankan `Latihan.kt` seperti biasa.
6. Jika stuck, bandingkan dengan module `-solusi` yang berpasangan.

Setiap latihan adalah modul Gradle terpisah, jadi latihan yang belum selesai (belum bisa di-compile) **tidak akan mengganggu** latihan atau solusi lain.

## Daftar Latihan

### 1. `handson1-latihan` / `handson1-solusi` — Resource & Packaging
Baca file `app.properties` yang ditaruh di `src/main/resources` lewat classloader (`getResourceAsStream`), lalu tampilkan isinya.

- **Konsep:** Gradle resource convention, classpath, `java.util.Properties`.

### 2. `handson2-latihan` / `handson2-solusi` — Custom Gradle Task
Lengkapi custom task `printProjectInfo` di `build.gradle.kts` supaya mencetak nama project, versi project, dan versi Gradle saat dijalankan lewat `./gradlew`.

- **Catatan:** tugas ini ada di `build.gradle.kts`, bukan di file `.kt` — task akan tetap sukses dijalankan walau TODO belum dilengkapi, hanya saja belum mencetak apa-apa.
- **Konsep:** `tasks.register`, `doLast`, configuration vs execution phase.

### 3. `handson3-latihan` / `handson3-solusi` — Dependency Declaration
Tambahkan dependency `kotlinx-datetime` ke `build.gradle.kts` module ini supaya `Latihan.kt` (yang sudah lengkap) bisa resolve dan mencetak tanggal hari ini.

- **Catatan:** module ini **sengaja tidak bisa di-compile** sebelum kamu melengkapi TODO — itu bagian dari latihan.
- **Konsep:** `dependencies {}`, koordinat `groupId:artifactId:version`, `implementation` vs `api`.

## Troubleshooting

| Error | Penyebab | Solusi |
|---|---|---|
| `app.properties tidak ditemukan di classpath` / hasil `null` | File properties ditaruh di folder yang salah (bukan `src/main/resources`) atau nama file salah ketik | Pastikan file ada persis di `src/main/resources/app.properties` |
| `Task 'printProjectInfo' not found` | Salah ketik nama task, atau menjalankan dari module yang salah | Jalankan dengan path lengkap: `./gradlew :handson2-latihan:printProjectInfo` |
| `Unresolved reference: datetime` / `Could not find org.jetbrains.kotlinx:kotlinx-datetime:...` | Dependency belum ditambahkan di `build.gradle.kts`, atau salah ketik versi/koordinat | Tambahkan `implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")` di dalam `dependencies {}`, lalu re-sync Gradle |

## Sumber Pustaka

- [Gradle Kotlin DSL Primer](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
- [Gradle: Writing Custom Tasks](https://docs.gradle.org/current/userguide/custom_tasks.html)
- [kotlinx-datetime GitHub](https://github.com/Kotlin/kotlinx-datetime)
