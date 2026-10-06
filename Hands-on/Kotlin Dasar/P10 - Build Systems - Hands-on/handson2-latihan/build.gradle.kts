// Hands-on 2: Custom Gradle Task
// Tugas: Lengkapi custom task "printProjectInfo" di bawah ini supaya saat
// dijalankan (./gradlew :handson2-latihan:printProjectInfo) task tersebut
// mencetak nama project, versi project, dan versi Gradle yang dipakai.
//
// Konsep: tasks.register(...) mendaftarkan task baru secara LAZY (baru
// dikonfigurasi saat benar-benar dibutuhkan). doLast {} berisi aksi yang
// dijalankan pada EXECUTION phase, bukan saat Gradle mengevaluasi script
// (CONFIGURATION phase).

version = "1.0.0"

tasks.register("printProjectInfo") {
    group = "kotlin dasar"
    description = "Mencetak nama project, versi project, dan versi Gradle"

    doLast {
        // TODO 1: Cetak nama project ini lewat properti `project.name`.
        //   Contoh: println("Nama project: " + project.name)

        // TODO 2: Cetak versi project ini lewat properti `project.version`.
        //   Contoh: println("Versi project: " + project.version)

        // TODO 3: Cetak versi Gradle yang sedang menjalankan build ini
        //   lewat `gradle.gradleVersion`.
        //   Contoh: println("Versi Gradle: " + gradle.gradleVersion)
    }
}
