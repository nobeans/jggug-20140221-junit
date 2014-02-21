# JUnit4の構成要素
JUnit4は主に次のような要素から成立している。

+ Runner/Runners
+ Description
+ Suite/Test
+ Assert/Matchers
+ Before/After/Rule/Timeout/ExpectedException
+ Theories/Enclosed/Categoriesなどの拡張

実行処理のみを使うという方針をとると、知ればいいのは最初の3つだけ。（実際のクラス数でも5個前後)

## Runner/Runners
+ ツールなどからテスト実行を命令されて、対象のテストを選定して実行するコンポーネント。
+ JUnit4だと@Testのついているメソッドを集めて、実行して、結果を通知する感じ。
+ SpockのSpecificationはこのRunnerを拡張した感じのつくり。


    class Sample Test extends Specification { // このSpecification
        def aaa(){
            given:
            when:
            then:
        }
    }

## Suite/Test
+ JUnit4ではTestをまとめるSuiteという考えになっている。
+ それぞれディレクトリとファイルのような関係になっている。
+ Suite:Test = ディレクトリ:ファイル

## Description
+ SuiteとTestを保持するオブジェクトであり、それぞれの名前を管理している。
+ IDE, Gradleで表示されているテストメソッド名はここで保持している名前になる。
+ 名前を文字列で指定することも出来るが、classを指定するとIDEなんかでテストメソッドからジャンプできるので便利。


[Next](Sample.md)