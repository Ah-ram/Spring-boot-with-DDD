package practice.second.game.controller.response_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.game.service.response.CreateSimpleGameResponse;

@Getter
@RequiredArgsConstructor
public class CreateSimpleGameResponseForm {
    private final int gameId;
    private final boolean success;

    public static CreateSimpleGameResponseForm from(CreateSimpleGameResponse createSimpleGameResponse) {
        return new CreateSimpleGameResponseForm(
                createSimpleGameResponse.getGameId(),
                createSimpleGameResponse.isSuccess());
    }
}
