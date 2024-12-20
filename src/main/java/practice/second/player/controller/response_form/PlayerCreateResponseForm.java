package practice.second.player.controller.response_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.player.service.response.PlayerCreateResponse;

@Getter
@RequiredArgsConstructor
public class PlayerCreateResponseForm {
    private final String nickname;
    private final boolean success;

    public static PlayerCreateResponseForm from(PlayerCreateResponse playerCreateResponse) {
        return new PlayerCreateResponseForm(playerCreateResponse.getNickname(), playerCreateResponse.isSuccess());
    }
}
// from(): 정적 팩토리 메서드
// 서비스에서 반환된 데이터를 클라이언트에 적합한 형태로 변환
// 객체 생성 로직을 깔끔하게 캡슐화함
