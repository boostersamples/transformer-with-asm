package io.github.boostersamples.transformer.asm

import com.didiglobal.booster.kotlinx.ifNotEmpty
import com.didiglobal.booster.transform.TransformContext
import com.didiglobal.booster.transform.asm.ClassTransformer
import com.didiglobal.booster.transform.asm.className
import com.google.auto.service.AutoService
import org.objectweb.asm.tree.ClassNode

/**
 * @author johnsonlee
 */
@AutoService(ClassTransformer::class)
class SampleAsmTransformer : ClassTransformer {

    override fun transform(context: TransformContext, klass: ClassNode) = klass.also {
        println("Transforming ${klass.className}: ")
        klass.fields.ifNotEmpty {
            println(klass.fields.joinToString("\n") {
                "  - " + it.name + ": " + it.desc
            })
        }
        klass.methods.ifNotEmpty {
            println(klass.methods.joinToString("\n") {
                "  - " + it.name + it.desc
            })
        }
    }

}
