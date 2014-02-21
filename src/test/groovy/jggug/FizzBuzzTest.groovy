package jggug

import org.junit.runner.RunWith

@RunWith(JGGUGRunner.class)
class FizzBuzzTest {

    def fizzBuzz = new FizzBuzz()

    def "1から100の間で3の倍数でも5の倍数でもないものはその数字を返す"() {
        assert fizzBuzz.get(1) == "1"
        assert fizzBuzz.get(2) == "2"
        assert fizzBuzz.get(4) == "4"
        assert fizzBuzz.get(7) == "7"
        assert fizzBuzz.get(8) == "8"
        assert fizzBuzz.get(11) == "11"

    }

    def "1から100の間で3の倍数はFizzと返す"() {
        assert fizzBuzz.get(3) == "Fizz"
        assert fizzBuzz.get(6) == "Fizz"
        assert fizzBuzz.get(9) == "Fizz"
        assert fizzBuzz.get(12) == "Fizz"
    }

    def "1から100の間で5の倍数はBuzzと返す"() {
        assert fizzBuzz.get(5) == "Buzz"
        assert fizzBuzz.get(10) == "Buzz"
        assert fizzBuzz.get(20) == "Buzz"
    }

    //def "1から100の間で3と5の倍数はFizzBuzzと返す"() {
    //    //なにか処理
    //    println "D"
    //}
    //
    //def "1未満もしくは101以上の場合は例外を返す"() {
    //    //なにか処理
    //    println "E"
    //}

}
