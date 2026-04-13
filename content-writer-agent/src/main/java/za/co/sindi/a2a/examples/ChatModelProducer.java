/**
 * 
 */
package za.co.sindi.a2a.examples;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

/**
 * @author Buhake Sindi
 * @since 05 April 2026
 */
@ApplicationScoped
public final class ChatModelProducer {

	@Produces @ApplicationScoped
	public ChatModel geminiChatModel() {
		return GoogleAiGeminiChatModel.builder()
				.apiKey("ENTER YOUR API KEY HERE...")
				.frequencyPenalty(0.7)
				.logRequestsAndResponses(true)
				.modelName("gemini-3-flash-preview")
				.presencePenalty(0d)
				.frequencyPenalty(0d)
				.build();
	}
}
