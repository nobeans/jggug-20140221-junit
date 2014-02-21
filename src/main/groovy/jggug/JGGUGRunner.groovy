package jggug

import org.junit.runner.Description
import org.junit.runner.Runner
import org.junit.runner.notification.RunNotifier

class JGGUGRunner extends Runner {

    private Class klass

    JGGUGRunner(Class<?> klass) {
        this.klass = klass
        println "Constructor: $klass"
    }

    int count = 0

    @Override
    Description getDescription() {
        println klass.name
        def desc = Description.createTestDescription(klass.name, "B")
        klass.declaredMethods.each { method ->
            if (method.returnType != Object) return
            if (method.parameterTypes.size() > 0) return
            if (method.name =~ /super\$.*/) return
            desc.addChild Description.createTestDescription(klass.name, method.name)
            count++
        }
        return desc
    }

    @Override
    void run(RunNotifier notifier) {
        //notifier.fireTestStarted(description)

        description.children.each { child ->
            notifier.fireTestStarted(child)
        }

        //def result = new Result()
        //def listener = result.createListener()
        //listener.testRunFinished(null)
        //notifier.fireTestRunFinished(result)
        println "run"
    }
}
