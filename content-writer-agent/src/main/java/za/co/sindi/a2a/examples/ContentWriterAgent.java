/**
 * 
 */
package za.co.sindi.a2a.examples;

import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import jakarta.enterprise.context.ApplicationScoped;
import za.co.sindi.ai.a2a.server.spi.Agent;
import za.co.sindi.ai.a2a.server.spi.PublicCard;
import za.co.sindi.ai.a2a.server.spi.Skill;

/**
 * Content editor agent interface for proofreading and polishing content.
 * 
 * @author Buhake Sindi
 * @since 05 April 2026
 */
@Agent(name="Content Writer Agent", description = "An agent that can write a "
        + "comprehensive and engaging piece of content "
        + "based on the provided outline and high-level "
        + "description of the content")
@PublicCard(version = "1.0.0", defaultInputModes = { "text" }, defaultOutputModes = { "text" })
@RegisterAIService(scope = ApplicationScoped.class)
public interface ContentWriterAgent {

	/**
     * Writes content based on the provided assignment.
     *
     * @param assignment the content assignment with outline
     * @return the generated content
     */
    @SystemMessage("""
            You are an expert writer that can write a comprehensive and
            engaging piece of content based on a provided outline and a
            high-level description of the content.

            Do NOT attempt to write content without being given an outline.

            Your output should only consist of the final content.
            """)
    @Skill(id = "writer", name = "Writes content using an outline", description = "Writes content using a given "
            + "outline and high-level description of "
            + "the content", tags = {"writer"}, examples = {"Write a short, upbeat, and "
                    + "encouraging twitter post about learning "
                    + "Java. Base your writing on the given "
                    + "outline."})
    String writeContent(@UserMessage String assignment);
}
