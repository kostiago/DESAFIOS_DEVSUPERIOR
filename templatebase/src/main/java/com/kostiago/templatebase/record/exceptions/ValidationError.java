package com.kostiago.templatebase.record.exceptions;

import java.time.Instant;
import java.util.List;

public record ValidationError(Instant timestamp, Integer status, String error, String path, List<FieldMessage> errors) {

}
