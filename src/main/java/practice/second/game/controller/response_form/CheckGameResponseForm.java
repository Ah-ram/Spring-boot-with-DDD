package practice.second.game.controller.response_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.game.service.response.CheckGameResponse;

@Getter
@RequiredArgsConstructor
public class CheckGameResponseForm {
    private final String message;

    public static CheckGameResponseForm from(CheckGameResponse checkGameResponse) {
        return new CheckGameResponseForm(checkGameResponse.getMessage());
    }
}