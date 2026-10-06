package com.itera.pam.p7.db

import app.cash.sqldelight.db.SqlDriver

// expect/actual: deklarasi di sini (commonMain). Implementasi:
// - androidMain -> AndroidSqliteDriver (butuh Context)
// - iosMain     -> NativeSqliteDriver
// - desktopMain -> JdbcSqliteDriver (perlu Schema.create() manual)
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
