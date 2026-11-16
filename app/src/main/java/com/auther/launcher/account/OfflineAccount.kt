package com.auther.launcher.account

import java.util.UUID

data class OfflineAccount(
    val username: String,
    val uuid: String
) {
    companion object {
        fun create(username: String): OfflineAccount? {
            val cleanName = username.trim()

            if (!cleanName.matches(Regex("[A-Za-z0-9_]{3,16}"))) {
                return null
            }

            val uuid = UUID.nameUUIDFromBytes(
                "OfflinePlayer:$cleanName".toByteArray()
            ).toString()

            return OfflineAccount(cleanName, uuid)
        }
    }
}
