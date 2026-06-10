package br.com.coderbank.customerportal.dto.response;


import br.com.coderbank.customerportal.enuns.Status;

import java.util.UUID;

public record CustomerResponseDto(
        UUID id,
        Status status,
        String createdByUser,
        String createdDateAndTime,
        String editedByUser,
        String editedDateAndTime
) {
}
