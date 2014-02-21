package jggug

import org.junit.runner.RunWith

@RunWith(JGGUGRunner.class)
class FizzBuzzTest {

    def fizzBuzz = new FizzBuzz()

    def "1から100の間で3の倍数でも5の倍数でもないものはその数字を返す"() {
        //なにか処理
        println "A"
    }

    def "1から100の間で3の倍数はFizzと返す"() {
        //なにか処理
        assert 1 == 2
    }

    //def "1から100の間で5の倍数はBuzzと返す"() {
    //    //なにか処理
    //    println "C"
    //}
    //
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
