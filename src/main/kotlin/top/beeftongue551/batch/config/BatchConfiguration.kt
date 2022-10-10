package top.beeftongue551.batch.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import top.beeftongue551.batch.tasklet.ItemTasklet
import top.beeftongue551.batch.tasklet.RecipeTasklet
import java.time.LocalDateTime


@Configuration
@EnableBatchProcessing
class BatchConfiguration {

    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory
    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    lateinit var itemTasklet: ItemTasklet
//    @Autowired
//    lateinit var recipeTasklet: RecipeTasklet

    @Bean
    fun csvJob(): Job {
        val dateAndTime: LocalDateTime = LocalDateTime.now()
        return jobBuilderFactory.get("csvJob$dateAndTime")
            .flow(itemStep())
            .end().build()
    }

    @Bean
    fun itemStep(): Step {
        return stepBuilderFactory.get("itemStep")
            .tasklet(itemTasklet)
            .build()
    }

    @Bean
    fun recipeStep(): Step {
        return stepBuilderFactory.get("recipeStep")
            .tasklet(RecipeTasklet())
            .build()
    }
}