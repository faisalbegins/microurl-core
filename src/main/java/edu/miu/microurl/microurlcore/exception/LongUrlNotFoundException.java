package edu.miu.microurl.microurlcore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such URL")
public class LongUrlNotFoundException extends RuntimeException {}
