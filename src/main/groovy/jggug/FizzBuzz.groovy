package jggug

class FizzBuzz {

    String get(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("too small")
        }
        if (number > 100) {
            throw new IllegalArgumentException("too large")
        }
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz"
        }
        if (number % 3 == 0) {
            return "Fizz"
        }
        if (number % 5 == 0) {
            return "Buzz"
        }
        return number as String
    }
}
