package jggug

import org.junit.runner.Description
import org.junit.runner.Result
import org.junit.runner.Runner
import org.junit.runner.notification.RunNotifier

class JGGUGRunner extends Runner {

    private Class klass
    private Description desc

    JGGUGRunner(Class<?> klass) {
        this.klass = klass
        println "Constructor: $klass"

        desc = Description.createTestDescription(klass.name, "")
        klass.declaredMethods.each { method ->
            if (method.returnType != Object) return
            if (method.parameterTypes.size() > 0) return
            if (method.name =~ /super\$.*/) return
            desc.addChild Description.createTestDescription(klass.name, method.name)
            println "Found test method: ${method.name}"
        }
    }

    @Override
    Description getDescription() {
        return desc
    }

    @Override
    void run(RunNotifier notifier) {
        //notifier.fireTestStarted(description)

        description.children.each { child ->
            notifier.fireTestStarted(child)

            def instance = klass.newInstance()

            println ">" * 10
            println "Running ${child.displayName}"

            def result = new Result()
            def listener = result.createListener()

            try {
                instance.invokeMethod(child.methodName, null)

                listener.testFinished(child)
                notifier.fireTestRunFinished(result)
            } catch (AssertionError e) {
                listener.testFailure(null)
                notifier.fireTestFailure(result)
            }
        }

        //def result = new Result()
        //def listener = result.createListener()
        //listener.testRunFinished(null)
        //notifier.fireTestRunFinished(result)
    }
}
