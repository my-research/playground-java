package com.example.cqs;

import lombok.Value;

@Value(staticConstructor = "of")
public class CancelCommand {
    Long memberId;
    Long walletId;
}
