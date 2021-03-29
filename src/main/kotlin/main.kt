
class Car {
    var doors: Int = 0
}

fun printCar(car: Car?) {
    val isCoupe = car?.let {
        (it.doors <= 2)
    }
    if (isCoupe == true) {
        println("Coupes are awesome")
    }
}

fun printCar2(car: Car?) {
    val isCoupe = car?.run {
        (this.doors <= 2)
    }

    if (isCoupe == true) {
        println("Coupes are awesome")
    }
}

fun main(args: Array<String>) {
    println("Hello World!")
}