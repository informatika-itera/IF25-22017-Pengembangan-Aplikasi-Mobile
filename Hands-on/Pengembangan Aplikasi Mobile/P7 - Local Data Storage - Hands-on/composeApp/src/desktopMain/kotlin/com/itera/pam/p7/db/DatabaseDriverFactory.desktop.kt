package com.itera.pam.p7.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        // Driver JDBC SQLite tidak otomatis membuat tabel — kita harus
        // memanggil AppDatabase.Schema.create(driver) secara manual sekali
        // sebelum digunakan (berbeda dari AndroidSqliteDriver/NativeSqliteDriver
        // yang sudah menangani ini secara otomatis lewat parameter `schema`).
        val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        AppDatabase.Schema.create(driver)
        return driver
    }
}
