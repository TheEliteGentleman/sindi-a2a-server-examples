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
@Agent(name="Content Editor Agent", description = "An agent that can proof-read and polish content.")
@PublicCard(version = "1.0.0", defaultInputModes = { "text" }, defaultOutputModes = { "text" })
@RegisterAIService(scope = ApplicationScoped.class)
public interface ContentEditorAgent {

	/**
     * Edits and polishes the provided content.
     *
     * @param assignment the content to be edited
     * @return the polished content
     */
    @SystemMessage("""
            You are an expert editor that can proof-read and polish content.

            Your output should only consist of the final polished content.
            """)
    @Skill(id = "editor", name = "Edits content", description = "Edits content by proof-reading and polishing", tags = {"writer"}, examples = {"Edit the following article, make sure it has a professional tone"})
    String editContent(@UserMessage String assignment);
}
