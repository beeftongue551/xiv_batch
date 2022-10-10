package top.beeftongue551.batch

import org.springframework.batch.core.explore.JobExplorer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class BatchApplication

@Autowired
private var jobs: JobExplorer? = null

fun main(args: Array<String>) {
	runApplication<BatchApplication>(*args)
}
