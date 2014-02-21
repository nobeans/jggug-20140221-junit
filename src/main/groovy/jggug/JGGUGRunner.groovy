package jggug

import org.junit.runner.Description
import org.junit.runner.Result
import org.junit.runner.Runner
import org.junit.runner.notification.Failure
import org.junit.runner.notification.RunNotifier

class JGGUGRunner extends Runner {

    private Class klass
    private Description desc

    JGGUGRunner(Class<?> klass) {
        this.klass = klass
        //println "Constructor: $klass"

        desc = Description.createTestDescription(klass.name, "")
        klass.declaredMethods.each { method ->
            // まずは素直に@Testを付けて絞り込んだ方がいい予感
            if (method.returnType != Object) return
            if (method.parameterTypes.size() > 0) return
            if (method.name =~ /^super\$.*/) return  // 何か混ざるので無視
            if (method.name =~ /^[a-zA-Z].*/) return // 日本語始まり以外は無視

            desc.addChild Description.createTestDescription(klass.name, method.name)
            //println "Found test method: ${method.name}"
        }
    }

    @Override
    Description getDescription() {
        return desc
    }

    @Override
    void run(RunNotifier notifier) {
        description.children.each { child ->
            notifier.fireTestStarted(child)

            //println ">" * 10
            //println "Running ${child.displayName}"

            def result = new Result()
            try {
                def instance = klass.newInstance()
                instance.invokeMethod(child.methodName, null)

                notifier.fireTestRunFinished(result)
                notifier.fireTestFinished(child)

            } catch (AssertionError e) {
                //println e.message

                def failure = new Failure(child, e)
                notifier.fireTestFailure(failure)
            }

        }
    }
}
