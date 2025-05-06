package cit.app.test

object UserRepository {
    val userList = ArrayList<User>()

    fun addUser(user: User): Boolean {
        if (userList.any { it.email == user.email }) {
            return false // Email already registered
        }
        userList.add(user)
        return true
    }

    fun validateUser(email: String, password: String): Boolean {
        return userList.any { it.email == email && it.password == password }
    }
}