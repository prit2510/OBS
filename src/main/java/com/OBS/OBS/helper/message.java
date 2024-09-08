package com.OBS.OBS.helper;

import com.OBS.OBS.helper.messageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class message {

    private String content;
    @Builder.Default
    private messageType type = messageType.blue;

}
