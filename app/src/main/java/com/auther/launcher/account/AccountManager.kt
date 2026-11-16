package com.auther.launcher.account

class AccountManager {

    private val accounts = mutableListOf<Any>()

    fun addOfflineAccount(username: String): Boolean {
        val account = OfflineAccount.create(username) ?: return false

        accounts.removeAll {
            it is OfflineAccount && it.username == account.username
        }

        accounts.add(account)
        return true
    }

    fun addElyByAccount(account: ElyByAccount) {
        accounts.removeAll {
            it is ElyByAccount && it.uuid == account.uuid
        }

        accounts.add(account)
    }

    fun getAccounts(): List<Any> {
        return accounts.toList()
    }

    fun removeAccount(uuid: String) {
        accounts.removeAll {
            when (it) {
                is OfflineAccount -> it.uuid == uuid
                is ElyByAccount -> it.uuid == uuid
                else -> false
            }
        }
    }
}
